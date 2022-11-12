package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	List<Contact> people = new ArrayList();
	Scanner sc = new Scanner(System.in);

	public void addContacts() {
		Contact contacts = new Contact();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first Name:");
		String firstName = sc.nextLine();
		contacts.setFirstName(firstName);

		System.out.println("Enter Last Name:");
		String lastName = sc.nextLine();
		contacts.setLastName(lastName);

		System.out.println("Enter Adress:");
		String adress = sc.nextLine();
		contacts.setAddress(adress);

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

}
