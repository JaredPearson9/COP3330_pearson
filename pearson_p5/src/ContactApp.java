import java.util.*;

public class ContactApp{

    private static final Scanner input = new Scanner(System.in);

    public static void basicContactListMenu(ContactList currentCL) {

        int choice3 = 0;

        //menu displayed until option 6 is chosen
        while(choice3 != 6) {
            System.out.println(" ");
            System.out.println("List Operation Menu");
            System.out.println("-------------------");
            System.out.println(" ");
            System.out.println("1) view the list");
            System.out.println("2) add an item");
            System.out.println("3) edit an item");
            System.out.println("4) remove an item");
            System.out.println("5) save the current list");
            System.out.println("6) quit to the main menu");
            System.out.println(" ");
            System.out.print(">");

            //gets user input
            int retry3 = 1;
            while(retry3 != 0) {
                try {
                    choice3 = Integer.parseInt(input.nextLine());
                    retry3 = 0;
                } catch (InputMismatchException | NumberFormatException ex) {
                    System.out.println("not a valid choice, type 1, 2, 3, 4, 5, or 6");
                    System.out.print(">");
                } catch (Exception ex) {
                    System.out.println("An unexpected error has occurred");
                }
            }

            if(choice3 <= 0 | choice3 >=7){
                System.out.println("not a valid choice, type 1, 2, 3, 4, 5, or 6");
            }

            //view the list
            if (choice3 == 1) {
                displayCurrentContacts(currentCL);
            }

            //add an item
            if (choice3 == 2) {

                int retry = 1;

                while (retry != 0) {
                    try {
                        ContactItem item = new ContactItem(obtainContactItemFirstName(), obtainContactItemLastName(), obtainContactItemPhoneNumber(),obtainContactItemEmailAddress());
                        currentCL.add(item);
                        System.out.println(" ");
                        retry = 0;
                    } catch (ContactItem.InvalidContactItemException ex) {
                        System.out.println("contact item is not valid; at least one entry must not be blank");
                        System.out.println(" ");
                    } catch(Exception ex){
                        System.out.println("An unexpected error has occurred");
                        retry = 0;
                    }
                }
            }

            //edit an item
            if (choice3 == 3) {

                if(currentCL.contacts.size() == 0){
                    System.out.print("There are no contacts to edit");
                    System.out.println(" ");
                }

                if(currentCL.contacts.size() != 0) {
                    displayCurrentContacts(currentCL);

                    int retry = 1;

                    while (retry != 0) {
                        try {
                            System.out.print("Which contact will you edit (enter one of the integers on the left of the contacts)? ");
                            int j = Integer.parseInt(input.nextLine());
                            ContactItem newItem = new ContactItem(editContactItemFirstName(), editContactItemLastName(), editContactItemPhoneNumber(),editContactItemEmailAddress());
                            currentCL.edit(j, newItem);
                            retry = 0;
                        } catch (IndexOutOfBoundsException ex) {
                            System.out.println("Index is out of bounds for task number chosen, choose an integer value to the left of one of the tasks");
                            System.out.println(" ");
                        } catch (InputMismatchException ex) {
                            System.out.println("Please enter an integer");
                            System.out.println(" ");
                            input.nextLine();
                        } catch (ContactItem.InvalidContactItemException ex) {
                            System.out.println("contact item is not valid; at least one entry must not be blank");
                            System.out.println(" ");
                        } catch (NumberFormatException ex) {
                            System.out.println("Please enter an integer");
                        } catch (Exception ex) {
                            System.out.println("An unexpected error has occurred");
                            retry = 0;
                        }
                    }
                }
            }

            //remove an item
            if (choice3 == 4) {
                if(currentCL.contacts.size() == 0){
                    System.out.print("There are no contacts to remove");
                    System.out.println(" ");
                }

                if(currentCL.contacts.size() != 0) {
                    displayCurrentContacts(currentCL);

                    int retry = 1;

                    while (retry != 0) {
                        try {
                            System.out.print("Which contact will you remove (enter one of the integers on the left of the contacts)? ");
                            int j = Integer.parseInt(input.nextLine());
                            currentCL.remove(j);
                            retry = 0;

                        } catch (IndexOutOfBoundsException ex) {
                            System.out.println("Index is out of bounds for task number chosen, choose an integer value to the left of one of the tasks");
                            System.out.println(" ");
                        } catch (InputMismatchException ex) {
                            System.out.println("Please enter an integer");
                            System.out.println(" ");
                        } catch (NumberFormatException ex) {
                            System.out.println("Please enter an integer");
                        } catch (Exception ex) {
                            System.out.println("An unexpected error has occurred");
                            retry = 0;
                        }
                    }
                }
            }

            //saves the current list to a file
            if (choice3 == 5) {
                if(currentCL.contacts.size() == 0){
                    System.out.print("There are no contacts to save");
                    System.out.println(" ");
                }

                if(currentCL.contacts.size() != 0) {
                    System.out.print("Enter the filename to save as: ");
                    String filename = input.nextLine();
                    currentCL.write(filename);
                }
            }
        }
    }

    private static String obtainContactItemFirstName() {
        System.out.print("Contact first name: ");
        return input.nextLine();
    }

    private static String obtainContactItemLastName() {
        System.out.print("Contact last name: ");
        return input.nextLine();
    }

    private static String obtainContactItemPhoneNumber() {
        System.out.print("Contact phone number: ");
        return input.nextLine();
    }

    private static String obtainContactItemEmailAddress() {
        System.out.print("Contact email address: ");
        return input.nextLine();
    }

    private static String editContactItemFirstName() {
        System.out.print("New contact first name: ");
        return input.nextLine();
    }

    private static String editContactItemLastName() {
        System.out.print("New contact last name: ");
        return input.nextLine();
    }

    private static String editContactItemPhoneNumber() {
        System.out.print("New contact phone number: ");
        return input.nextLine();
    }

    private static String editContactItemEmailAddress() {
        System.out.print("New contact email address: ");
        return input.nextLine();
    }

    private static void displayCurrentContacts(ContactList currentCL){
        System.out.println("Current Contacts");
        System.out.println("----------------");
        System.out.println(" ");
        ContactItem contact;
        for(int i = 0; i < currentCL.contacts.size(); i++ ) {
            contact = currentCL.contacts.get(i);

            System.out.println(i + ") Name: " + contact.getContactItemFirstName() + " " + contact.getContactItemLastName());
            System.out.println("Phone: " + contact.getContactItemPhoneNumber());
            System.out.println("Email: " + contact.getContactItemEmailAddress());

        }
        System.out.println(" ");
    }
}
