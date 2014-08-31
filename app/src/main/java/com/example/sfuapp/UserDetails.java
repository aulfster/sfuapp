package com.example.sfuapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;

import java.sql.Date;


public class UserDetails extends Activity {

    Button registerButton;
    EditText firstName;
    EditText lastName;
    EditText sfuId;
    EditText password;
    RadioButton male;
    RadioButton female;

    String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        message = intent.getStringExtra(ToDoActivity.EXTRA_MESSAGE);


        setContentView(R.layout.activity_user_details2);

        registerButton = (Button)findViewById(R.id.register_button);
        firstName = (EditText)findViewById(R.id.firstName_editText);
        lastName=(EditText)findViewById(R.id.lastName_editText);
        sfuId =(EditText)findViewById(R.id.sfuEmailId_editText);
        password = (EditText)findViewById(R.id.sfuPassword_editText);
        male = (RadioButton)findViewById(R.id.male_radioButton);
        female = (RadioButton)findViewById(R.id.female_radioButton);

        registerButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        InsertIntoUsersTable();
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_user_details, container, false);
//            return rootView;
//        }
//    }

    private void InsertIntoUsersTable()
    {
                        Users newUser = new Users();

                        newUser.setStatus("Online");
                        newUser.setId(message);
                        newUser.setSfuId(sfuId.getText().toString());
                        newUser.setFirstName(firstName.getText().toString());
                        newUser.setLastName(lastName.getText().toString());
                        newUser.setPassword(password.getText().toString());
                        if(male.isChecked())
                            newUser.setGender("Male");
                        if(female.isChecked())
                            newUser.setGender("Female");
                        newUser.setMajor("Undefined");


                        Date dob = new Date(19880426);
                        newUser.setDateOfBirth(dob);


                        ToDoActivity.mUsersTable.insert(newUser, new TableOperationCallback<Users>() {
                            public void onCompleted(Users entity,
                                                    Exception exception,
                                                    ServiceFilterResponse response) {
                                if (exception == null) {
                                    Log.i("CHECKTHIS", "Read object with ID " + entity.getSfuId());
                                    //createAndShowDialog("Added: " + newUser.getSfuId(), "");

                                }
                                else
                                {
                                    Log.i("CHECKTHIS", "Failed ");
                                }

                                Intent intent = new Intent(UserDetails.this, MainScreen.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                UserDetails.this.finish();
                            }
                        });
    }
}
