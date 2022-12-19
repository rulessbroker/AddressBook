package com.bridgelabz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("\n***Welcome To Address Book Program***\n");

		AddressBook details = new AddressBook();

		int choice;
		do {
			System.out.println("1.Add contact\n2.Show Contact\n3.Edit Contact\n4.Delete Contact\n5.Add New Address Book"
					+ "\n6.Select Address Book\n7.Search Contact\n8.Count Contacts\n9.Sort contact\n10.Read AddressBook"
					+ "\n11.Write AddressBook\n12.Exit\n");
			System.out.println("Enter your choice: ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				Contact Contact = details.getContactInput();
				details.addContact(Contact);
				break;
			case 2:
				details.viewContacts();
				break;
			case 3:
				details.editContact();
				break;
			case 4:
				details.deleteContact();
				break;
			case 5:
				details.addNewAddressBook();
				break;
			case 6:
				details.selectAddressBook();
				break;
			case 7:
				details.searchContact();
				break;
			case 8:
				details.countContact();
				break;
			case 9:
				details.sortContact();
				break;
			case 10:
				details.readAddressBook();
				break;
			case 11:
				details.writeAddressBook();
				break;
			case 12:
				System.out.println("Program Terminate Successfully!!!");
				break;
			default:
				System.out.println("Enter Valid Input...");
			}
		} while (choice != 12);
	}
}
