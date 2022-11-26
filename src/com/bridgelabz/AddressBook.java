package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

//	ArrayList for storing contact
	private ArrayList<Contact> ContactList;
	Scanner sc = new Scanner(System.in);

	public AddressBook() {
		ContactList = new ArrayList<Contact>();
	}

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

//	Check duplicate contact
	public boolean checkDuplicateContact() {
		System.out.println("Enter First Name");
		String fname = sc.nextLine();
		System.out.println("Enter Last Name");
		String lname = sc.nextLine();
		for (int j = 0; j < ContactList.size(); j++) {
			Contact temp = ContactList.get(j);
			if (temp.getFirstName().equals(fname) && temp.getLastName().equals(lname)) {
				System.out.println("Contact already exists!!Please enter a different contact name");

			}
		}
		return true;

	}

}
