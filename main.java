package main;

import definition.ContactList;
import definition.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactList contactList = new ContactList();
        String firstName;
        String lastName;
        String[] contactNumber = new String[3];
        String email;
        boolean flag = true;
        while (flag == true) {
            System.out.println();
            System.out.println("welcome to Saurabh contact list");
            System.out.println("Press 1 to add a new contact\n" +
                    "Press 2 to view all contacts\n" +
                    "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" +
                    "Press 5 to exit program ");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 1:
                    System.out.println("You have chosen to add a new contact: \n" +
                            "Please enter the name of the Person");
                    System.out.print("First Name: ");
                    firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    lastName = scanner.nextLine();
                    contactList.setName(firstName, lastName);
                    contactList.setFirstNameInList(firstName);
                    System.out.print("Contact Number:");
                    contactNumber[0] = scanner.nextLine();
                    for (int i = 1; i <= 2; i++) {
                        System.out.print("Would you like to add new Number (y/n): ");
                        char response = scanner.next().charAt(0);
                        if (response == 'y') {
                            System.out.print("Contact Number: ");
                            contactNumber[i] = scanner.next();
                        } else {
                            break;
                        }
                    }
                    System.out.print("Would you like to add email (y/n): ");
                    char response = scanner.next().charAt(0);
                    if (response == 'y') {
                        System.out.println("Enter the Email:");
                        email = scanner.next();
                    } else {
                        break;
                    }
                    Person person = new Person(firstName, lastName, contactNumber, email);

                    contactList.add(person);
                    break;
                case 2:
                    contactList.viewAllContacts();
                    break;
                case 3:
                    System.out.println("You could search for a contact from there contact name");
                    String name = scanner.next();
                    contactList.search(name);
                    break;
                case 4:
                    System.out.println("Here are your contacts");
                    for (int i = 0; i < contactList.getArrayOfNames().size(); i++) {
                        System.out.println((i + 1) + ". " + contactList.getArrayOfNames().get(i));
                    }
                    if (contactList.getArrayOfNames().size() != 0) {
                        System.out.println("Press the number against the contact to delete it: ");

                        int index = scanner.nextInt();
                        String tempName = contactList.getArrayOfNames().get(index - 1).toString();
                        contactList.delete(index);
                        System.out.println(tempName + " has been deleted from your contacts");
                    } else {
                        System.out.println("NO CONTACTS AVAILABLE");
                    }
                    break;
                case 5:
                    System.out.println("Thank You For Using Our Services");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Input enter the right input:");
                    break;
            }

        }
    }
}