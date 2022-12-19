package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {

//	ArrayList for storing contact
	ArrayList<Contact> ContactList = new ArrayList<Contact>();
	static HashMap<String, ArrayList> addressBookList = new HashMap<>(); // Hash map for storing address book.

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
	public void addContact(Contact person) {
		boolean isDuplicate = checkDuplicateContact(person);
		if (isDuplicate) {
			System.out.println("Contact name already exists");
		} else {
			ContactList.add(person);
			System.out.println("contact added to AddressBook " + AddressBookName);
			System.out.println(person);
		}
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

//	Create or add new address book
	void addNewAddressBook() {
		System.out.println("Enter name for AddressBook: ");
		String addressBookName = sc.next();
		ArrayList<Contact> addressBook = new ArrayList();
		addressBookList.put(addressBookName, addressBook);
		System.out.println("new AddressBook created");
		addressBook = addressBookList.get(addressBookName);
		AddressBookName = addressBookName;
	}

//	select address book already created
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

//	checking duplicacity in Address Book with the help of Fist name
	boolean checkDuplicateContact(Contact newPerson) {
		return ContactList.stream()
				.anyMatch((person) -> person.getFirstName().equalsIgnoreCase(newPerson.getFirstName()));
	}

//	Search contacts in Address Book
	void searchContact() {
		System.out.println("1.Search by City \n2.Search by State");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("Enter city :");
			searchByCity(sc.next());
			break;
		case 2:
			System.out.println("Enter State :");
			searchByState(sc.next());
			break;
		default:
			searchContact();
		}
	}

//	Search by city 
	void searchByCity(String city) {

		List<Contact> result = (List<Contact>) ContactList.stream().filter(n -> n.city.equals(city))
				.collect(Collectors.toList());
		result.forEach(n -> {
			System.out.println("The persons in a city are " + n.firstName);

		});
	}

//	Search by State
	void searchByState(String state) {

		List<Contact> result = (List<Contact>) ContactList.stream().filter(n -> n.state.equals(state))
				.collect(Collectors.toList());
		result.forEach(n -> {
			System.out.println("The persons in a State are " + n.firstName);

		});
	}

//	Count contacts in Address Book
	void countContact() {
		System.out.println("1.Count by City \n2.Count by State");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("Enter city :");
			countByCity(sc.next());
			break;
		case 2:
			System.out.println("Enter State :");
			countByState(sc.next());
			break;
		default:
			countContact();
		}
	}

//	Count person in particular city
	public void countByCity(String city) {
		long count = ContactList.stream().filter(n -> n.city.equals(city)).count();
		System.out.println("The no of persons in a city are " + count);

	}

//	Count person in particular state
	public void countByState(String state) {
		long count = ContactList.stream().filter(n -> n.state.equals(state)).count();
		System.out.println("The no of persons in a state are " + count);

	}

	public void sortContact() {
		List<Contact> allContacts = getAllContacts();
		List<Contact> sortedContacts;

		System.out.println("1.Sort By Name \n2.Sort By CIty \n3.Sort By State \n4.Sort By Zipcode \n5.back");
		switch (sc.nextInt()) {
		case 1:
			sortedContacts = allContacts.stream().sorted((x, y) -> x.getFirstName().compareTo(y.getFirstName()))
					.collect(Collectors.toList());
			sortedContacts.forEach(x -> System.out.println(x));
			break;
		case 2:
			sortedContacts = allContacts.stream().sorted((x, y) -> x.getCity().compareTo(y.getCity()))
					.collect(Collectors.toList());
			sortedContacts.forEach(x -> System.out.println(x));
			break;
		case 3:
			sortedContacts = allContacts.stream().sorted((x, y) -> x.getState().compareTo(y.getState()))
					.collect(Collectors.toList());
			sortedContacts.forEach(x -> System.out.println(x));
			break;
		case 4:
			sortedContacts = allContacts.stream().sorted((x, y) -> Integer.compare(x.getZip(), y.getZip()))
					.collect(Collectors.toList());
			sortedContacts.forEach(x -> System.out.println(x));
			break;
		case 5:
			break;
		default:
			sortContact();
			break;
		}
	}

	List<Contact> getAllContacts() {
		List<Contact> allContacts = new ArrayList<>();
		for (String key : addressBookList.keySet()) {
			allContacts.addAll(addressBookList.get(key));
		}
		return allContacts;
	}

}
