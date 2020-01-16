package phonebook;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay();
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);


        while(true){
            consoleDisplay.printMenu();
            if (scanner.hasNextInt()){
                int input = scanner.nextInt();

                if(input == 0){
                    break;
                }
                else if(input == 1){
                    System.out.println("Введите имя: ");
                    final String name = scanner.next();
                    System.out.println("Введите номер: ");
                    final String phone = scanner.next();
                    System.out.println("Введите возраст: ");
                    final String birthday = scanner.next();
                    Contact contact = new Contact(name, phone, birthday);
                    phoneBook.add(contact);
                    consoleDisplay.printContacts(phoneBook.getAllContacts());

                }
                else if(input == 4){
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    Contact contact = phoneBook.find(id);
                    consoleDisplay.printContact(contact);

                }
                else if(input == 2){
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    phoneBook.del(id);
                    
                }
                else if(input == 5){

                    System.out.println("You can find by name or by phone( 1 - by name, 2- by phone)");

                    int findId = scanner.nextInt();
                        if(findId == scanner.nextInt()){


                            if(findId == 1){
                                System.out.println("Find by name:");
                                String name = scanner.next();
                                ArrayList<Contact> filteredContacts = phoneBook.findByNameStart(name);
                                consoleDisplay.printContacts(filteredContacts);
                            }
                            else if(findId == 2){
                                System.out.println("Find by last 4 numbers of phone: ");
                                String phone = scanner.next();
                                ArrayList<Contact> filteredContacts = phoneBook.findByPhone(phone);
                                consoleDisplay.printContacts(filteredContacts);
                            }
                        }
                        else {
                            System.out.println("Choose one of the find variants: ");


                        }


                }
                else if(input == 3){
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    Contact contact = phoneBook.find(id);
                    consoleDisplay.printContact(contact);
                    System.out.println("Choose part of contact, what you want to edit(1 - Name; 2 - Phone; 3 - Birthday): ");
                    int editId = scanner.nextInt();
                    if(editId == 1){

                    }
                }
            }   else{
                System.out.println("Choose one of the functions in PhoneBook");
                break;
            }

        }
    }
}
