package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

//	ArrayList for storing contact
	ArrayList<Contact> ContactList = new ArrayList<Contact>();
	static HashMap<String, ArrayList> addressBookList = new HashMap<>();
	static String AddressBookName;
	Scanner sc = new Scanner(System.in);

//	Creating contact
	public Contact getContactInput() {

		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String lastName = sc.nextLine();
		System.out.println("Enter the Address: ");
		String address = sc.nextLine();
		System.out.println("Enter the City: ");
		String city = sc.nextLine();
		System.out.println("Enter the State: ");
		String state = sc.nextLine();
		System.out.println("Enter the Zip: ");
		int zip = sc.nextInt();
		System.out.println("Enter the Phone No: ");
		long phoneNumber = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter the Email: ");
		String email = sc.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, email, zip, phoneNumber);

		return contact;
	}

//	New contact added
	public void addContact(Contact createPerson) {
		System.out.println("Added a New Contacts for " + createPerson.firstName);
		ContactList.add(createPerson);
		System.out.println("Contacts Added Successfully");
	}

//	Editing contact with details
	public void editContact() {
		System.out.println("Enter First Name of Contacts to Edit : ");
		String cName = sc.nextLine();
		Contact editContact = ContactList.get(cName.indexOf(cName));

		if (editContact.getFirstName().equals(cName)) {

			System.out.println("Which Details You Would Like To Edit ?");
			System.out.println("Press - 1 for First Name \nPress - 2 for Last Name \n"
					+ "Press - 3 for Address \nPress - 4 for City \nPress - 5 for State \nPress - 6 for Zip \n"
					+ "Press - 7 for Phone No. \nPress - 8 for Email");

			int num = sc.nextInt();

			switch (num) {
			case 1:
				System.out.println("Enter New First Name ");
				sc.nextLine();
				String fName = sc.nextLine();
				editContact.setFirstName(fName);
				System.out.println("Update a Sucessfully " + fName);
				break;
			case 2:
				System.out.println("Enter New Last Name");
				sc.nextLine();
				String lName = sc.nextLine();
				editContact.setLastName(lName);
				System.out.println("Update a Sucessfully " + lName);
				break;
			case 3:
				System.out.println("Enter New Address");
				sc.nextLine();
				String address = sc.nextLine();
				editContact.setAddress(address);
				System.out.println("Update a Sucessfully " + address);
				break;
			case 4:
				System.out.println("Enter New City");
				sc.nextLine();
				String city = sc.nextLine();
				editContact.setCity(city);
				System.out.println("Update a Sucessfully " + city);
				break;
			case 5:
				System.out.println("Enter New State");
				sc.nextLine();
				String state = sc.nextLine();
				editContact.setState(state);
				System.out.println("Update a Sucessfully " + state);
				break;
			case 6:
				System.out.println("Enter New Zip");
				int zip = sc.nextInt();
				editContact.setZip(zip);
				System.out.println("Update a Sucessfully " + zip);
				break;
			case 7:
				System.out.println("Enter New Phone Number");
				long phoneNumber = sc.nextLong();
				editContact.setPhoneNo(phoneNumber);
				System.out.println("Update a Sucessfully " + phoneNumber);
				break;
			case 8:
				System.out.println("Enter New Email");
				sc.nextLine();
				String email = sc.nextLine();
				editContact.setEmail(email);
				System.out.println("Update a Sucessfully " + email);
				break;
			default:
				System.out.println("Edit Failed!");
			}
		} else {
			System.out.println("No such contact");

		}
	}

//	Deleting contact
	public void deleteContact() {
		if (ContactList.size() == 0) {
			System.out.println("No Contacts found");
		} else {
			System.out.println("Enter First Name of Contact you want to Delete : ");
			String cName = sc.nextLine();
			Contact editContact = ContactList.get(cName.indexOf(cName));

			if (editContact.getFirstName().equals(cName)) {
				ContactList.remove(editContact);
				System.out.println("Contacts Delete Successfully");
			} else {
				System.out.println("No such Contact to Delete");
			}
		}
	}

//	Print contact details
	public void viewContacts() {

		if (ContactList.size() == 0) {
			System.out.println("No Contacts found");
		} else {

			for (int i = 0; i < ContactList.size(); i++) {
				int num = i + 1;
				System.out.println("Contact: " + num);
				System.out.println("First Name: " + ContactList.get(i).firstName + "\nLast Name: "
						+ ContactList.get(i).lastName + "\nAddress: " + ContactList.get(i).address + "\nCity: "
						+ ContactList.get(i).city + "\nState: " + ContactList.get(i).state + "\nZip: "
						+ ContactList.get(i).zip + "\nPhone No.: " + ContactList.get(i).phoneNumber + "\nEmail: "
						+ ContactList.get(i).email);
				System.out.println();
			}
		}

	}

	void addNewAddressBook() {
		System.out.println("Enter name for AddressBook: ");
		String addressBookName = sc.next();
		ArrayList<Contact> addressBook = new ArrayList();
		addressBookList.put(addressBookName, addressBook);
		System.out.println("new AddressBook created");
		addressBook = addressBookList.get(addressBookName);
		AddressBookName = addressBookName;
	}

	void selectAddressBook() {
		System.out.println(addressBookList.keySet());
		System.out.println("Enter name of address book:");
		String addressBookName = sc.next();

		for (String key : addressBookList.keySet()) {
			if (key.equalsIgnoreCase(addressBookName)) {
				ContactList = addressBookList.get(key);
				AddressBookName = key;
			}
		}
		System.out.println("current AddressBook is: " + AddressBookName);
	}

}
