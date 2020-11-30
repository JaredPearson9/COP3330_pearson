import java.util.*;

public class App {
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

            //goes to task list application
            if (firstChoice == 1) {
                createOrLoadMenu(firstChoice);
            }

            //loads a saved task list from a file
            if (firstChoice == 2) {
                createOrLoadMenu(firstChoice);
            }
        }

    }

    private static void createOrLoadMenu(int firstChoice){

        int choice = 0;

        while(choice != 3) {
            System.out.println(" ");
            System.out.println("main menu");
            System.out.println("---------");
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");
            System.out.println(" ");
            System.out.print(">");

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

            //makes a new task list
            if (choice == 1) {
                TaskList currentTaskList;
                ContactList currentContactList;

                if(firstChoice == 1){
                    currentTaskList = new TaskList();

                    System.out.println("new task list has been created");
                    System.out.println(" ");

                    basicTaskListMenu(currentTaskList);
                }

                if(firstChoice == 2){
                    currentContactList = new ContactList();

                    System.out.println("new contact list has been created");
                    System.out.println(" ");

                    basicContactListMenu(currentContactList);
                }
            }

            //loads a saved task list from a file
            if (choice == 2) {
                if(firstChoice == 1){
                    System.out.print("Enter the filename to load: ");
                    String filename = input.nextLine();

                    TaskList currentTaskList = new TaskList();
                    currentTaskList.load(filename);

                    basicTaskListMenu(currentTaskList);
                }

                if(firstChoice == 2){
                    System.out.print("Enter the filename to load: ");
                    String filename = input.nextLine();

                    ContactList currentContactList = new ContactList();
                    currentContactList.load(filename);

                    basicContactListMenu(currentContactList);
                }

            }
        }
    }

    private static void basicTaskListMenu(TaskList currentTL){

        int choice2 = 0;

        //menu displayed until option 8 is chosen
        while(choice2 != 8) {
            System.out.println(" ");
            System.out.println("List Operation Menu");
            System.out.println("-------------------");
            System.out.println(" ");
            System.out.println("1) view the list");
            System.out.println("2) add an item");
            System.out.println("3) edit an item");
            System.out.println("4) remove an item");
            System.out.println("5) mark an item as completed");
            System.out.println("6) unmark an item as completed");
            System.out.println("7) save the current list");
            System.out.println("8) quit to the main menu");
            System.out.println(" ");
            System.out.print(">");

            int retry2 = 1;
            while(retry2 != 0) {
                try {
                    choice2 = Integer.parseInt(input.nextLine());
                    retry2 = 0;
                } catch (InputMismatchException | NumberFormatException ex) {
                    System.out.println("not a valid choice, type 1, 2, 3, 4, 5, 6, 7, or 8");
                    System.out.print(">");
                } catch (Exception ex) {
                    System.out.println("An unexpected error has occurred");
                }
            }

            if(choice2 <= 0 | choice2 >=9){
                System.out.println("not a valid choice, type 1, 2, 3, 4, 5, 6, 7, or 8");
            }

            //view the list
            if (choice2 == 1) {
                displayCurrentTasks(currentTL);
            }

            //add an item
            if (choice2 == 2) {

                int retry = 1;

                while (retry != 0) {
                    try {
                        TaskItem item = new TaskItem(obtainTaskItemTitle(), obtainTaskItemDescription(), obtainTaskItemDueDate(),false);
                        currentTL.add(item);
                        System.out.println(" ");
                        retry = 0;
                    } catch (TaskItem.InvalidTitleException ex) {
                        System.out.println("title is not valid; must be at least 1 character long");
                        System.out.println(" ");
                    } catch (TaskItem.InvalidDueDateException ex) {
                        System.out.println("due date is not valid; must be of the form YYYY-MM-DD");
                        System.out.println(" ");
                    } catch(Exception ex){
                        System.out.println("An unexpected error has occurred");
                        retry = 0;
                    }
                }
            }

            //edit an item
            if (choice2 == 3) {

                if(currentTL.tasks.size() == 0){
                    System.out.print("There are no tasks to edit");
                }

                if(currentTL.tasks.size() != 0) {
                    displayCurrentTasks(currentTL);

                    int retry = 1;

                    while (retry != 0) {
                        try {
                            System.out.print("Which task will you edit (enter one of the integers on the left of the tasks)? ");
                            int j = Integer.parseInt(input.nextLine());
                            TaskItem newItem = new TaskItem(editTaskItemTitle(), editTaskItemDescription(), editTaskItemDueDate(), false);
                            currentTL.edit(j, newItem);
                            retry = 0;
                        } catch (IndexOutOfBoundsException ex) {
                            System.out.println("Index is out of bounds for task number chosen, choose an integer value to the left of one of the tasks");
                            System.out.println(" ");
                        } catch (InputMismatchException ex) {
                            System.out.println("Please enter an integer");
                            System.out.println(" ");
                            input.nextLine();
                        } catch (TaskItem.InvalidTitleException ex) {
                            System.out.println("title is not valid; must be at least 1 character long");
                            System.out.println(" ");
                        } catch (TaskItem.InvalidDueDateException ex) {
                            System.out.println("due date is not valid; must be of the form YYYY-MM-DD");
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
            if (choice2 == 4) {
                if(currentTL.tasks.size() == 0){
                    System.out.print("There are no tasks to remove");
                }

                if(currentTL.tasks.size() != 0) {
                    displayCurrentTasks(currentTL);

                    int retry = 1;

                    if (currentTL.tasks.size() == 0) {
                        System.out.println("There are no tasks to remove");
                        System.out.println(" ");
                        retry = 0;
                    }

                    while (retry != 0) {
                        try {
                            System.out.print("Which task will you remove (enter one of the integers on the left of the tasks)? ");
                            int j = Integer.parseInt(input.nextLine());

                            currentTL.remove(j);
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

            //mark an item as completed
            if (choice2 == 5) {

                int retry = 1;

                //counts number of incomplete tasks
                int count = 0;
                for(int i = 0; i < currentTL.tasks.size(); i++){
                    if(!currentTL.tasks.get(i).getTaskItemComplete()) {
                        count++;
                    }
                }

                //tells user if there are an incomplete tasks
                if(count == 0){
                    System.out.println("There are no tasks to mark as complete");
                    System.out.println(" ");
                    retry = 0;
                }

                displayIncompleteTasks(currentTL);

                while (retry != 0) {
                    try {
                        System.out.print("Which task will you mark as complete (enter one of the integers on the left of the tasks)? ");
                        int j = Integer.parseInt(input.nextLine());

                        currentTL.tasks.get(j).setComplete(true);
                        retry = 0;
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Index is out of bounds for task number chosen, choose an integer value to the left of one of the tasks");
                        System.out.println(" ");
                    } catch(InputMismatchException ex){
                        System.out.println("Please enter an integer");
                        System.out.println(" ");
                    } catch(NumberFormatException ex) {
                        System.out.println("Please enter an integer");
                    } catch(Exception ex){
                        System.out.println("An unexpected error has occurred");
                        retry = 0;
                    }
                }
            }

            //unmark an item as completed
            if (choice2 == 6) {

                int retry = 1;

                //counts the number of complete tasks
                int count = 0;
                for(int i = 0; i < currentTL.tasks.size(); i++){
                    if(currentTL.tasks.get(i).getTaskItemComplete()) {
                        count++;
                    }
                }

                //informs the user if their are no complete tasks to unmark
                if(count == 0){
                    System.out.println("There are no tasks to unmark as complete");
                    System.out.println(" ");
                    retry = 0;
                }

                displayCompleteTasks(currentTL);

                while (retry != 0) {
                    try {
                        System.out.print("Which task will you unmark as complete (enter one of the integers on the left of the tasks)? ");
                        int j = Integer.parseInt(input.nextLine());

                        currentTL.tasks.get(j).setComplete(false);
                        retry = 0;
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Index is out of bounds for task number chosen, choose an integer value to the left of one of the tasks");
                        System.out.println(" ");
                    } catch(InputMismatchException ex){
                        System.out.println("Please enter an integer");
                        System.out.println(" ");
                    } catch(NumberFormatException ex) {
                        System.out.println("Please enter an integer");
                    } catch(Exception ex){
                        System.out.println("An unexpected error has occurred");
                        retry = 0;
                    }
                }
            }

            //saves the current list to a file
            if (choice2 == 7) {
                if(currentTL.tasks.size() == 0){
                    System.out.print("There are no tasks to save");
                }

                if(currentTL.tasks.size() != 0) {
                    System.out.print("Enter the filename to save as: ");
                    String filename = input.nextLine();
                    currentTL.write(filename);
                }
            }
        }
    }

    private static void basicContactListMenu(ContactList currentCL) {


        int choice3 = 0;

        //menu displayed until option 8 is chosen
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
                }

                if(currentCL.contacts.size() != 0) {
                    displayCurrentContacts(currentCL);

                    int retry = 1;

                    if (currentCL.contacts.size() == 0) {
                        System.out.println("There are no contacts to remove");
                        System.out.println(" ");
                        retry = 0;
                    }

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
                }

                if(currentCL.contacts.size() != 0) {
                    System.out.print("Enter the filename to save as: ");
                    String filename = input.nextLine();
                    currentCL.write(filename);
                }
            }
        }
    }

    private static String obtainTaskItemTitle() {
        System.out.print("Task title: ");
        return input.nextLine();
    }

    private static String obtainTaskItemDescription() {
        System.out.print("Task Description: ");
        return input.nextLine();
    }

    private static String obtainTaskItemDueDate() {
        System.out.print("Task due date (YYYY-MM-DD): ");
        return input.nextLine();
    }

    private static String editTaskItemTitle() {
        System.out.print("New task title: ");
        return input.nextLine();
    }

    private static String editTaskItemDescription() {
        System.out.print("New task Description: ");
        return input.nextLine();
    }

    private static String editTaskItemDueDate() {
        System.out.print("New task due date (YYYY-MM-DD): ");
        return input.nextLine();
    }

    //displays tasks of the current task list
    private static void displayCurrentTasks(TaskList currentTL){
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println(" ");
        TaskItem task;
        for(int i = 0; i < currentTL.tasks.size(); i++ ) {
            task = currentTL.tasks.get(i);
            if(!task.getTaskItemComplete()) {
                System.out.println(i + ") [" + task.getTaskItemDueDate() + "] " + task.getTaskItemTitle() + ": " + task.getTaskItemDescription());
            }
            if(task.getTaskItemComplete()) {
                System.out.println(i + ") *** [" + task.getTaskItemDueDate() + "] " + task.getTaskItemTitle() + ": " + task.getTaskItemDescription());
            }
        }
        System.out.println(" ");
    }

    private static void displayCompleteTasks(TaskList currentTL) {
        System.out.println("Complete Tasks");
        System.out.println("--------------");
        System.out.println(" ");
        TaskItem task;
        for(int i = 0; i < currentTL.tasks.size(); i++ ) {
            task = currentTL.tasks.get(i);
            if(task.getTaskItemComplete()) {
                System.out.println(i + ") *** [" + task.getTaskItemDueDate() + "] " + task.getTaskItemTitle() + ": " + task.getTaskItemDescription());
            }
        }
        System.out.println(" ");
    }

    private static void displayIncompleteTasks(TaskList currentTL) {
        System.out.println("Incomplete Tasks");
        System.out.println("----------------");
        System.out.println(" ");
        TaskItem task;
        for(int i = 0; i < currentTL.tasks.size(); i++ ) {
            task = currentTL.tasks.get(i);
            if(!task.getTaskItemComplete()) {
                System.out.println(i + ") [" + task.getTaskItemDueDate() + "] " + task.getTaskItemTitle() + ": " + task.getTaskItemDescription());
            }
        }
        System.out.println(" ");
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