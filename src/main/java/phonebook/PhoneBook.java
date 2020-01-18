package phonebook;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PhoneBook {
    private ArrayList <Contact> contacts = new ArrayList<>();
    public ArrayList<Contact> getAllContacts(){
        return contacts;
    }

    public void add(Contact contact){
        contacts.add(contact);
    }

    public Contact find(int id){
        return contacts.get(--id);
    }
    public void del(int id){
        contacts.remove(--id);
    }
    public ArrayList<Contact> findByName(String name){
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if(contact.getName().equals(name)){
                result.add(contact);
            }



        }
        return result;
    }
    public ArrayList<Contact> findByNameStart(String value){
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if(contact.getName().startsWith(value)){
                result.add(contact);
            }
        }
        return result;
    }
    public ArrayList<Contact> findByPhone(String value){
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if(contact.getPhone().endsWith(value)){
                result.add(contact);
            }
        }
        return result;
    }

}
