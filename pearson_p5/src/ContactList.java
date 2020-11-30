import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ContactList {

    List<ContactItem> contacts;

    public ContactList(){
        contacts = new ArrayList<>();
    }

    public void add(ContactItem contact){
        contacts.add(contact);
    }

    public void edit(int index,ContactItem contact){
        contacts.set(index,contact);
    }

    public void remove(int index){
        contacts.remove(index);
    }

    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < contacts.size(); i++) {
                ContactItem contact = contacts.get(i);
                output.format("%s;%s;%s;%s%n", contact.getContactItemFirstName(), contact.getContactItemLastName(), contact.getContactItemPhoneNumber(), contact.getContactItemEmailAddress());
            }

            System.out.println("Contact list has been saved");
            System.out.println(" ");

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to make the file, make sure to enter at least 1 character");
        } catch (Exception ex) {
            System.out.println("An unexpected error has occurred");
            ex.printStackTrace();
        }
    }

    public void load(String filename) {
        try {
            File fileObj = new File(filename);
            Scanner reader = new Scanner(fileObj);

            while(reader.hasNextLine()){

                String line = reader.nextLine();

                String[] stringArray = line.split(";");

                ContactItem contact = new ContactItem(stringArray[0], stringArray[1], stringArray[2], stringArray[3]);
                contacts.add(contact);
            }

            System.out.println("Contact list has been loaded");
            System.out.println(" ");

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file, make sure the file you are trying to load is in the same directory, starting a new list instead");
        } catch (Exception ex) {
            System.out.println("An unexpected error has occurred");
            ex.printStackTrace();
        }
    }

}
