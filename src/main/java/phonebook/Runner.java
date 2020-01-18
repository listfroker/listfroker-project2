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
                    System.out.println("Введите возраст: ");
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

                    System.out.println("You can find by name or by phone( 1 - by name, 2- by phone)");

                    int findId = scanner.nextInt();


                    if (findId == 1) {
                        System.out.println("Find by name:");
                        String name = scanner.next();
                        ArrayList<Contact> filteredContacts = phoneBook.findByNameStart(name);
                        ConsoleDisplay.printContacts(filteredContacts);
                    } else if (findId == 2) {
                        System.out.println("Find by last 4 numbers of phone: ");
                        String phone = scanner.next();
                        ArrayList<Contact> filteredContacts = phoneBook.findByPhone(phone);
                        ConsoleDisplay.printContacts(filteredContacts);
                    } else {
                        System.out.println("NO, please enter number! ");
                        scanner.nextInt();
                    }
                }
                else if(input == ActionType.SAVE.getIndex()){
                        FileController.saveToFile(phoneBook.getAllContacts());;
                        System.out.println("Contact's has been saved");
                    }
                }
                else {
                    System.out.println("Choose one of the find variants: ");
                }
            }
        }
    }




