package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("\n***Welcome To Address Book Program***\n");
		
		AddressBook details = new AddressBook();

		int choice;
		do {
			System.out.println("1.Add contact\n2.Show Contact\n3.Edit Contact\n4.Delete Contact\n5.Exit\n");
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
				System.out.println("Program Terminate Successfully!!!");
				break;
			default:
				System.out.println("Enter Valid Input...");
			}
		} while (choice != 5);
	}
}
