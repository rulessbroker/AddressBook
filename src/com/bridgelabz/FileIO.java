package com.bridgelabz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	static String FILE_PATH = "F:\\Languages\\Java\\AddressBook\\src\\Files\\";

	static boolean read(File filePath) throws FileNotFoundException {
		for (File file : filePath.listFiles()) {
			System.out.println("AddressBook name: " + file.getName());
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
		return true;
	}

	static boolean writeTxtFile(ArrayList<Contact> addressBook, String addressBookName) throws IOException {
		File file = new File(FILE_PATH + "txt\\" +  addressBookName + ".txt");
		boolean isCreated = file.createNewFile();
		if (!isCreated) {
			file.delete();
			file.createNewFile();
		}
		System.out.println("file created");
		FileWriter fileWriter = new FileWriter(file);
		String data = "";
		for (Contact contactPerson : addressBook) {
			data = data.concat(contactPerson.toString()).concat("\n");
		}
		System.out.println(data);
		fileWriter.write(data);
		fileWriter.close();
		return true;
		
	}
}
