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
        assertThrows(ContactItem.InvalidContactItemException.class , () -> new ContactItem(" ","", "    ", ""));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){

    }

    @Test
    public void editingSucceedsWithBlankFirstName(){

    }

    @Test
    public void editingSucceedsWithBlankLastName(){

    }

    @Test
    public void editingSucceedsWithBlankPhone(){

    }

    @Test
    public void editingSucceedsWithNonBlankValues(){

    }

    @Test
    public void testToString(){

    }
}
