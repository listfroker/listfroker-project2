package phonebook;

import javax.swing.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            ConsoleDisplay.printMenu();
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();

                if (input == ActionType.EXIT.getIndex()) {
                    break;
                } else if (input == ActionType.ADD.getIndex()) {
                    System.out.println("Введите имя: ");
                    final String name = scanner.next();
                    System.out.println("Введите номер: ");
                    final String phone = scanner.next();
                    System.out.println("Введите дату рождения: ");
                    final String birthday = scanner.next();
                    Contact contact = new Contact(name, phone, birthday);
                    phoneBook.add(contact);
                    ConsoleDisplay.printContacts(phoneBook.getAllContacts());

                } else if (input == ActionType.SHOW.getIndex()) {
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    Contact contact = phoneBook.find(id);
                    ConsoleDisplay.printContact(contact);

                } else if (input == ActionType.DELETE.getIndex()) {
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    phoneBook.del(id);

                } else if (input == ActionType.FIND.getIndex()) {
                    while (true) {
                        System.out.println("You can find by name or by phone( 1 - by name, 2- by phone)");

                        int findId = scanner.nextInt();


                        if (findId == 2) {
                            System.out.println("Find by first letters of name:");
                            String name = scanner.next();
                            ArrayList<Contact> filteredContacts = phoneBook.findByNameStart(name);
                            ConsoleDisplay.printContacts(filteredContacts);
                        } else if (findId == 3) {
                            System.out.println("Find by last 4 numbers of phone: ");
                            String phone = scanner.next();
                            ArrayList<Contact> filteredContacts = phoneBook.findByPhone(phone);
                            ConsoleDisplay.printContacts(filteredContacts);
                        } else if (findId == 1) {
                            System.out.println("Find by full name:");
                            String fullName = scanner.next();
                            ArrayList<Contact> filteredContacts = phoneBook.findByName(fullName);
                            ConsoleDisplay.printContacts(filteredContacts);
                        }
                    }
                } else if (input == ActionType.SAVE.getIndex()) {
                    FileController.saveToFile(phoneBook.getAllContacts());
                    ;
                    System.out.println("Contact's has been saved");
                } else if (input == ActionType.UPDATE.getIndex()) {
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                        Contact contact = phoneBook.find(id);
                        ConsoleDisplay.printContact(contact);
                    System.out.println("What you want to update?(1 - name, 2 - phone, 3 - birthday, 0 - exit)");
                    int updateId = scanner.nextInt();
                        if (updateId == 0) {
                            break;
                        } else if (updateId == 1) {
                            contact.setName(String name) = scanner.next();
                            ConsoleDisplay.printContact(contact);
                        }
                }
            } else {
                System.out.println("Please, enter number! ");
                scanner.next();
            }
        }
    }
}



