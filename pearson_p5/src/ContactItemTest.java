import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(ContactItem.InvalidContactItemException.class , () -> new ContactItem(" ","", "    ", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> new ContactItem("first","last", "407-001-0002", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() -> new ContactItem("","last", "407-001-0002", "email@address.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(() -> new ContactItem("first","", "407-001-0002", "email@address.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(() -> new ContactItem("first","last", "", "email@address.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() -> new ContactItem("first","last", "407-001-0002", "email@address.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem contact = new ContactItem("first","last", "423-000-0234", "email@email.com");
        ContactList list = new ContactList();
        list.add(contact);

        assertThrows(ContactItem.InvalidContactItemException.class , () -> list.edit(0,new ContactItem(" ","", "    ", "")));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem contact = new ContactItem("first","last", "423-000-0234", "email@email.com");
        ContactList list = new ContactList();
        list.add(contact);

        assertDoesNotThrow(() -> list.edit(0,new ContactItem("first","last", "423-000-0234", "")));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem contact = new ContactItem("first","last", "423-000-0234", "email@email.com");
        ContactList list = new ContactList();
        list.add(contact);

        assertDoesNotThrow(() -> list.edit(0,new ContactItem("","last", "423-000-0234", "email@email.com")));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem contact = new ContactItem("first","last", "423-000-0234", "email@email.com");
        ContactList list = new ContactList();
        list.add(contact);

        assertDoesNotThrow(() -> list.edit(0,new ContactItem("first","", "423-000-0234", "email@email.com")));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem contact = new ContactItem("first","last", "423-000-0234", "email@email.com");
        ContactList list = new ContactList();
        list.add(contact);

        assertDoesNotThrow(() -> list.edit(0,new ContactItem("first","last", "", "email@email.com")));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem contact = new ContactItem("first","last", "423-000-0234", "email@email.com");
        ContactList list = new ContactList();
        list.add(contact);

        assertDoesNotThrow(() -> list.edit(0,new ContactItem("first","last", "423-000-0234", "email@email.com")));
    }
}
