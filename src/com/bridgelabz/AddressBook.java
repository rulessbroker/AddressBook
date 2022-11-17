package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	List<Contact> people = new ArrayList<Contact>();
	Scanner sc = new Scanner(System.in);
	Contact contacts = new Contact();

	public void createContacts() {

		System.out.println("Enter first Name:");
		String firstName = sc.nextLine();
		contacts.setFirstName(firstName);

		System.out.println("Enter Last Name:");
		String lastName = sc.nextLine();
		contacts.setLastName(lastName);

		System.out.println("Enter Address:");
		String address = sc.nextLine();
		contacts.setAddress(address);

		System.out.println("Enter city:");
		String city = sc.nextLine();
		contacts.setCity(city);

		System.out.println("Enter state:");
		String state = sc.nextLine();
		contacts.setState(state);

		System.out.println("Enter zip:");
		int zip = sc.nextInt();
		contacts.setZip(zip);

		System.out.println("Enter phoneNumber:");
		long phoneNumber = sc.nextLong();
		contacts.setPhoneNumber(phoneNumber);
		sc.nextLine();
		System.out.println("Enter email:");
		String email = sc.nextLine();
		contacts.setEmail(email);

		people.add(contacts);
		System.out.println("person created sucessfully");
	}

	void addContact() {
		boolean notDuplicate = checkDuplicateContact();
		if (notDuplicate) {
			createContacts();
		} else {
			System.out.println("already exist");
		}
	}

	public void listPeople() {
		if (people.isEmpty()) {
			System.out.println("Your address book is empty.");
			return;
		}
		System.out.println("\n Address Book:");
		for (Contact person : people) {
			System.out.println(person);
		}

	}

	public void editPerson() {
		System.out.println("Enter the first name you want to edit.");

		String firstName = sc.nextLine();

		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).getFirstName().equals(firstName)) {

				people.get(i).setFirstName(firstName);

				System.out.println("Enter Last Name:");
				String lastName = sc.nextLine();
				people.get(i).setLastName(lastName);

				System.out.println("Enter Adress:");
				String address = sc.nextLine();
				people.get(i).setAddress(address);

				System.out.println("Enter state:");
				String state = sc.nextLine();
				people.get(i).setState(state);

				System.out.println("Enter zip:");
				int zip = sc.nextInt();
				people.get(i).setZip(zip);

				System.out.println("Enter phoneNumber:");
				long phoneNumber = sc.nextLong();
				people.get(i).setPhoneNumber(phoneNumber);

				System.out.println("Enter email:");
				String email = sc.nextLine();
				people.get(i).setEmail(email);

				System.out.println("person edited sucessfully");
			} else {
				System.out.println("person not found");
			}

		}
	}

	public void removeContact() {
		System.out.println("Enter the first name you want to remove.");
		String firstName = sc.nextLine();
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).getFirstName().equals(firstName)) {
				people.remove(people.get(i));
				System.out.println("person removed sucessfully");
			} else {
				System.out.println("person not found");
			}

		}
	}

	public boolean checkDuplicateContact() {

		System.out.println("Enter First Name");
		String fname = sc.nextLine();
		System.out.println("Enter Last Name");
		String lname = sc.nextLine();
		for (int j = 0; j < people.size(); j++) {
			Contact temp = people.get(j);
			if (temp.getFirstName().equals(fname) && temp.getLastName().equals(lname)) {
				System.out.println("Contact already exists!!Please enter a different contact name");

			}
		}
		return true;

	}

}
