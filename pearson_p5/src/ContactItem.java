import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ContactItem {

    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String emailAddress;


    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress){

        if(isContactItemValid(firstName, lastName, phoneNumber, emailAddress)){

            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;

        } else{
            throw new ContactItem.InvalidContactItemException("contact item is not valid; at least one entry must not be blank");
        }
    }

    private boolean isContactItemValid(String firstName, String lastName, String phoneNumber, String emailAddress) {
        boolean valid = true;

        if (firstName.isBlank() && lastName.isBlank() && phoneNumber.isBlank() && emailAddress.isBlank()) {
            valid = false;
        }

        return valid;
    }

    public String getContactItemFirstName(){
        return this.firstName;
    }

    public String getContactItemLastName(){
        return this.lastName;
    }

    public String getContactItemPhoneNumber(){
        return this.phoneNumber;
    }

    public String getContactItemEmailAddress(){
        return this.emailAddress;
    }

    static class InvalidContactItemException extends IllegalArgumentException {
        public InvalidContactItemException(String msg) {
            super(msg);
        }
    }
}
