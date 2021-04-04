package com.abs.service;

import com.abs.entity.AddressBook;
import com.abs.entity.Contact;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class AddressService {

    private static Map<String, AddressBook> addressBookMap = new HashMap();

    /**
     * Initialize address list
     */
    public void initialize() {
        ArrayList<Contact> contactList = new ArrayList<Contact>(
                Arrays.asList(
                        new Contact("Ramya", "Rajaraman", "Street123", "10001", "Bangalore", "KA", "1234567890", "r@gmail.com"),
                        new Contact("Harry", "Potter", "West apt", "10007", "Bangalore", "KA", "9234567890", "hp@gmail.com"),
                        new Contact("Mickey", "Mouse", "East end road", "19001", "Bangalore", "TN", "1234567890", "r@gmail.com")
                )
        );

        AddressBook officeAddBook = new AddressBook();
        officeAddBook.setContactList(contactList);
        officeAddBook.setAddressBookName("Office");
        addressBookMap.put("Office", officeAddBook);

        ArrayList<Contact> secondContactList = new ArrayList<Contact>(
                Arrays.asList(
                        new Contact("Jay", "Peter", "Heaven 123", "10001", "Bangalore", "KA", "1234567890", "jp@gmail.com"),
                        new Contact("Ed", "Morrow", "lakside apt", "20007", "Hyderabad", "AP", "9234567890", "em@gmail.com"),
                        new Contact("Sherlock", "Holmes", "north end road", "19001", "Chennai", "TN", "1234567890", "sh@gmail.com")
                )
        );

        AddressBook personAddBook = new AddressBook();
        personAddBook.setContactList(secondContactList);
        personAddBook.setAddressBookName("Personal");
        addressBookMap.put("Personal", personAddBook);
    }

    /**
     * Used to add new Contact
     * @param addressBookName
     * @param firstName
     * @param lastName
     * @param address
     * @param zipCode
     * @param city
     * @param state
     * @param phoneNo
     * @param emailId
     */
    public void addNewContact(String addressBookName, String firstName, String lastName, String address, String zipCode, String city,
                              String state, String phoneNo, String emailId) {
        //Making new contact object
        Contact newContact = new Contact(firstName, lastName, address, zipCode, city,
                state, phoneNo, emailId);
        //Fecthing corresponding address book
        AddressBook addBook = addressBookMap.get(addressBookName);
        //fetching contact list for the address book
        List<Contact> contactList = addBook.getContactList();

        if (contactList.stream().filter(t1 -> t1.equals(newContact)).count() > 0) {
            System.out.println("****Contact with same name exists***");
        } else {
            contactList.add(newContact);
            System.out.println("****Contact List****");
            contactList.stream().forEach(t -> System.out.println("Contact " + t));
        }
    }

    /**
     * Used to search by city
     * @param cityName
     */
    public void searchByCity(String cityName) {
        for (String addBookName : addressBookMap.keySet()) {

            //Fetching corresponding address book
            AddressBook addBook = addressBookMap.get(addBookName);
            //fetching contact list for the address book
            List<Contact> contactList = addBook.getContactList();

            //Filtered list
            List<Contact> filteredList = contactList.stream().
                    filter(n -> cityName.equals(n.getCity())).
                    collect(Collectors.toList());

            if (filteredList.size() > 0) {
                System.out.println("Contacts with matching City");
                filteredList.stream().forEach(t -> System.out.println("Contact " + t));
            }

        }
    }

    /**
     * Search by state
     * @param stateName
     */
    public void searchByState(String stateName) {
        for (String addBookName : addressBookMap.keySet()) {

            //Fetching corresponding address book
            AddressBook addBook = addressBookMap.get(addBookName);
            //fetching contact list for the address book
            List<Contact> contactList = addBook.getContactList();

            //Filtered list
            List<Contact> filteredList = contactList.stream().
                    filter(n -> stateName.equals(n.getState())).
                    collect(Collectors.toList());

            if (filteredList.size() > 0) {
                System.out.println("Contacts with matching State");
                filteredList.stream().forEach(t -> System.out.println("Contact " + t));
            }

        }
    }

    /**
     * Sort by name within each address book
     */
    public void sortByName() {
        for (String addBookName : addressBookMap.keySet()) {

            //Fetching corresponding address book
            AddressBook addBook = addressBookMap.get(addBookName);
            //fetching contact list for the address book
            List<Contact> contactList = addBook.getContactList();

            //Filtered list
            List<Contact> sortedList = contactList.stream().
                    sorted(Comparator.comparing(Contact::getFirstName)).
                    collect(Collectors.toList());

            if (sortedList.size() > 0) {
                System.out.println("Sorted by first name, for address book " + addBookName);
                sortedList.stream().forEach(t -> System.out.println("Contact " + t));
            }

        }
    }

    /**
     * Sort by zip code
     */
    public void sortByZipCode() {
        for (String addBookName : addressBookMap.keySet()) {

            //Fetching corresponding address book
            AddressBook addBook = addressBookMap.get(addBookName);
            //fetching contact list for the address book
            List<Contact> contactList = addBook.getContactList();

            //Filtered list
            List<Contact> sortedList = contactList.stream().
                    sorted(Comparator.comparing(Contact::getZipCode)).
                    collect(Collectors.toList());

            if (sortedList.size() > 0) {
                System.out.println("Sorted by zip code, for address book " + addBookName);
                sortedList.stream().forEach(t -> System.out.println("Contact " + t));
            }

        }
    }

    /**
     * Used to count no of contacts per city
     * @param cityName
     */
    public void countByCity(String cityName) {
        long count = 0;
        for (String addBookName : addressBookMap.keySet()) {

            //Fetching corresponding address book
            AddressBook addBook = addressBookMap.get(addBookName);
            //fetching contact list for the address book
            List<Contact> contactList = addBook.getContactList();

            //Filtered list
            count = contactList.stream().filter(n -> cityName.equals(n.getCity())).count() + count;
        }
        System.out.println("Count of contacts for " + cityName + " " + count);
    }

    /**
     * View the persons by City
     */
    public void viewPersonsByCity() {
        for (String addBookName : addressBookMap.keySet()) {
            //Fetching corresponding address book
            AddressBook addBook = addressBookMap.get(addBookName);
            //fetching contact list for the address book
            List<Contact> contactList = addBook.getContactList();

            Map<String, List<Contact>> contactsPerCity = contactList.stream()
                    .collect(groupingBy(Contact::getCity));

            System.out.println("**Contacts per city for Address Book " + addBookName + "**");
            for (String cityName : contactsPerCity.keySet()) {
                System.out.println("Contacts for City --- " + cityName + "---");
                System.out.println(contactsPerCity.get(cityName));
            }

        }
    }

    public static void main(String args[]) {
        AddressService as = new AddressService();
        as.initialize();

        //Add new contact
        as.addNewContact("Office", "Sherlock", "Holmes", "north end road", "19001", "Chennai", "TN", "1234567890", "sh@gmail.com");
        //Add contact with same name
        as.addNewContact("Office", "Ramya", "Rajaraman", "Street123", "10001", "Bangalore", "KA", "1234567890", "r@gmail.com");

        //Search by city
        as.searchByCity("Hyderabad");

        //Search by state
        as.searchByState("TN");

        //Count by city
        as.countByCity("Bangalore");

        //Sort by FirstName
        as.sortByName();

        //Sort by ZipCode
        as.sortByZipCode();

        //View Persons By City
        as.viewPersonsByCity();
    }


}
