import java.util.*;

public class App{
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int firstChoice = 0;

        while(firstChoice != 3) {
            System.out.println(" ");
            System.out.println("Select Your Application");
            System.out.println("-----------------------");
            System.out.println("1) task list");
            System.out.println("2) contact list");
            System.out.println("3) quit program");
            System.out.println(" ");
            System.out.print(">");

            int retry = 1;
            while(retry != 0) {
                try {
                    firstChoice = Integer.parseInt(input.nextLine());
                    retry = 0;
                } catch (InputMismatchException | NumberFormatException ex) {
                    System.out.println("not a valid choice, type 1, 2, or 3");
                    System.out.print(">");
                } catch (Exception ex) {
                    System.out.println("An unexpected error has occurred");
                }
            }

            if(firstChoice <= 0 | firstChoice >=4){
                System.out.println("not a valid choice, type 1, 2, or 3");
            }

            //goes to create or load menu
            if (firstChoice == 1 | firstChoice == 2) {
                createOrLoadMenu(firstChoice);
            }
        }
    }

    private static void createOrLoadMenu(int firstChoice){

        int choice = 0;

        //displays menu until 3 is chosen
        while(choice != 3) {
            System.out.println(" ");
            System.out.println("main menu");
            System.out.println("---------");
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");
            System.out.println(" ");
            System.out.print(">");

            //gets user input
            int retry = 1;
            while(retry != 0) {
                try {
                    choice = Integer.parseInt(input.nextLine());
                    retry = 0;
                } catch (InputMismatchException | NumberFormatException ex) {
                    System.out.println("not a valid choice, type 1, 2, or 3");
                    System.out.print(">");
                } catch (Exception ex) {
                    System.out.println("An unexpected error has occurred");
                }
            }

            if(choice <= 0 | choice >=4){
                System.out.println("not a valid choice, type 1, 2, or 3");
            }

            //makes a new task list or contact list
            if (choice == 1) {
                TaskList currentTaskList;
                ContactList currentContactList;

                //creates a new task list and opens the task app
                if(firstChoice == 1){
                    currentTaskList = new TaskList();

                    System.out.println("new task list has been created");
                    System.out.println(" ");

                    TaskApp.basicTaskListMenu(currentTaskList);
                }

                //creates a new contact list and opens the task app
                if(firstChoice == 2){
                    currentContactList = new ContactList();

                    System.out.println("new contact list has been created");
                    System.out.println(" ");

                    ContactApp.basicContactListMenu(currentContactList);
                }
            }

            //loads a saved task list or contact list from a file
            if (choice == 2) {

                //loads a saved task list and opens the task app
                if(firstChoice == 1){
                    System.out.print("Enter the filename to load: ");
                    String filename = input.nextLine();

                    TaskList currentTaskList = new TaskList();
                    currentTaskList.load(filename);

                    TaskApp.basicTaskListMenu(currentTaskList);
                }

                //loads a saved contact list and opens the contact app
                if(firstChoice == 2){
                    System.out.print("Enter the filename to load: ");
                    String filename = input.nextLine();

                    ContactList currentContactList = new ContactList();
                    currentContactList.load(filename);

                    ContactApp.basicContactListMenu(currentContactList);
                }
            }
        }
    }
}