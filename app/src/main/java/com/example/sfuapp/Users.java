package com.example.sfuapp;

import java.util.Date;

/**
 * Created by Chander on 8/30/2014.
 */
public class Users {

    /**
     * Item text
     */
    @com.google.gson.annotations.SerializedName("firstname")
    private String firstName;

    @com.google.gson.annotations.SerializedName("lastname")
    private String lastName;

    @com.google.gson.annotations.SerializedName("sfuid")
    private String sfuId;

    @com.google.gson.annotations.SerializedName("password")
    private String password;
    /**
     * User Id - either a google, facebook or microsoft.
     */
    @com.google.gson.annotations.SerializedName("id")
    private String id;

    /**
     * Indicates if the user is online
     */
    @com.google.gson.annotations.SerializedName("status")
    private String status;

    @com.google.gson.annotations.SerializedName("gender")
    private String gender;

    @com.google.gson.annotations.SerializedName("major")
    private String major;

    @com.google.gson.annotations.SerializedName("dateofbirth")
    private Date dateOfBirth;

    /**
     * ToDoItem constructor
     */
    public Users() {

    }

//    @Override
//    public String toString() {
//        return getText();
//    }

    /**
     * Initializes a new ToDoItem
     *
     * @param text
     *            The item text
     * @param id
     *            The item id
     */
    public Users(String id, String sfuId, String firstName, String lastName, String gender, String major, Date dateOfBirth, String status) {

        this.setId(id);
        this.setSfuId(sfuId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setMajor(major);
        this.setStatus(status);
        this.setDateOfBirth(dateOfBirth);
    }

    public final void setId(String id)
    {
        this.id = id;
    }

    public final void setSfuId(String sfuId)
    {
        this.sfuId = sfuId;
    }

    public final void setPassword(String password)
    {
        this.password = password;
    }

    public final void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public final void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public final void setGender(String gender)
    {
        this.gender = gender;
    }

    public final void setMajor(String major)
    {
        this.major = major;
    }

    public final void setStatus(String status)
    {
        this.status = status;
    }

    public final void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the item text
     */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSfuId() {
        return sfuId;
    }

    public String getPassword(){
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getGender() {
        return gender;
    }

    public String getMajor() {
        return major;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Users && ((Users) o).sfuId == sfuId;
    }
}
