package com.abs.entity;

import java.util.List;

public class AddressBook {
    private String addressBookName;
    private List<Contact> contactList;

    public AddressBook() {

    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }


}
