import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ContactList CL = new ContactList();
        int sizeBeforeAdd = CL.contacts.size();

        CL.add(new ContactItem("first", "last","202-010-0111","email@email.com"));

        assertTrue(CL.contacts.size() > sizeBeforeAdd);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactItem originalContact = new ContactItem("first", "last","202-010-0111","email@email.com");

        ContactList CL = new ContactList();
        CL.add(originalContact);

        assertThrows(ContactItem.InvalidContactItemException.class , () -> CL.edit(0, new ContactItem("", "","","")));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactItem originalContact = new ContactItem("first", "last","202-010-0111","email@email.com");

        ContactList CL = new ContactList();
        CL.add(originalContact);

        assertThrows(IndexOutOfBoundsException.class , () -> CL.edit(1, new ContactItem("new", "last","202-010-0111","email@email.com")));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem originalContact = new ContactItem("first", "last","202-010-0111","email@email.com");

        ContactList CL = new ContactList();
        CL.add(originalContact);

        assertDoesNotThrow(() -> CL.edit(0, new ContactItem("", "last","202-010-0111","email@email.com")));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem originalContact = new ContactItem("first", "last","202-010-0111","email@email.com");

        ContactList CL = new ContactList();
        CL.add(originalContact);

        assertDoesNotThrow(() -> CL.edit(0, new ContactItem("first", "","202-010-0111","email@email.com")));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem originalContact = new ContactItem("first", "last","202-010-0111","email@email.com");

        ContactList CL = new ContactList();
        CL.add(originalContact);

        assertDoesNotThrow(() -> CL.edit(0, new ContactItem("first", "last","","email@email.com")));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem originalContact = new ContactItem("first", "last","202-010-0111","email@email.com");

        ContactList CL = new ContactList();
        CL.add(originalContact);

        assertDoesNotThrow(() -> CL.edit(0, new ContactItem("first", "last","","")));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem originalContact = new ContactItem("first", "last","202-010-0111","email@email.com");

        ContactList CL = new ContactList();
        CL.add(originalContact);

        assertDoesNotThrow(() -> CL.edit(0, new ContactItem("first", "last","202-010-0111","email@email.com")));
    }

    @Test
    public void newListIsEmpty(){
        ContactList list = new ContactList();
        assertEquals(list.contacts.size(),0);
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList CL = new ContactList();
        CL.add(new ContactItem("first", "last","202-010-0111","email@email.com"));

        int sizeBeforeRemove = CL.contacts.size();

        CL.remove(0);

        assertTrue(CL.contacts.size() < sizeBeforeRemove);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList CL = new ContactList();
        CL.add(new ContactItem("first", "last","202-010-0111","email@email.com"));

        assertThrows(IndexOutOfBoundsException.class , () -> CL.remove(1));
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList CL = new ContactList();
        ContactItem initialContact = new ContactItem("first", "last","202-010-0111","email@email.com");
        CL.add(initialContact);

        String filename = "filename";
        CL.write(filename);

        ContactList CL2 = new ContactList();
        CL2.load(filename);

        assertEquals(CL2.contacts.get(0).getContactItemFirstName(), CL.contacts.get(0).getContactItemFirstName());
        assertEquals(CL2.contacts.get(0).getContactItemLastName(), CL.contacts.get(0).getContactItemLastName());
        assertEquals(CL2.contacts.get(0).getContactItemPhoneNumber(), CL.contacts.get(0).getContactItemPhoneNumber());
        assertEquals(CL2.contacts.get(0).getContactItemEmailAddress(), CL.contacts.get(0).getContactItemEmailAddress());
    }

}
