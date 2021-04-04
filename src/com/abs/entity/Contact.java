package com.abs.entity;

public class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String zipCode;
    private String city;
    private String state;
    private String phoneNo;
    private String emailId;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String address, String zipCode, String city, String state, String phoneNo, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public boolean equals(Object o) {
        Contact newContact = (Contact) o;
        boolean firstNameEquals = (this.firstName.equals(newContact.firstName));
        boolean lastNameEquals = (this.lastName.equals(newContact.lastName));
        return firstNameEquals && lastNameEquals;
    }

    @Override
    public String toString() {
        return String.format(
                " First Name - " + this.getFirstName() +
                        " \n Last Name - " + this.getLastName() +
                        " \n Address - " + this.getAddress() +
                        " \n Zipcode - " + this.getZipCode() +
                        " \n City - " + this.getCity() +
                        " \n State - " + this.getState() +
                        " \n PhoneNo - " + this.getPhoneNo() +
                        " \n Email ID - " + this.getEmailId() + "\n");
    }
}
