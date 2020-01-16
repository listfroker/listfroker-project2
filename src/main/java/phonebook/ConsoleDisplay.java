package phonebook;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ConsoleDisplay {
    public void printMenu(){
        System.out.println("1 -  Добавить контакт; 2 - Удалить контакт; 3 - Редактировать; 4 - Показать контакты; 5 - Найти...; 0 - Выход");
    }
    public void printContacts(ArrayList<Contact> contacts){
        if(contacts.size() ==0){
            System.out.println("No contacts found!");
        }
        else {
            int i = 1;
            for (Contact contact : contacts) {
                System.out.println(i++);
                System.out.println(contact.getName());
                System.out.println(contact.getPhone());
                System.out.println("-------------------------");
            }
        }
    }
    public void printContact(Contact contact){
        System.out.println("Contact: ");

        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        System.out.println(contact.getBirthday());
        System.out.println("-------------------------");

    }
}
