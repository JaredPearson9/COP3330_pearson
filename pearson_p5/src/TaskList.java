import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    List<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void add(TaskItem task){
        tasks.add(task);
    }

    public void edit(int index,TaskItem task){
        tasks.set(index,task);
    }

    public void remove(int index){
        tasks.remove(index);
    }

    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < tasks.size(); i++) {
                TaskItem task = tasks.get(i);
                output.format("%s;%s;%s;%b%n", task.getTaskItemTitle(), task.getTaskItemDescription(), task.getTaskItemDueDate(), task.getTaskItemComplete());
            }

            System.out.println("Task list has been saved");
            System.out.println(" ");

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file, make sure to enter at least 1 character");
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

                boolean complete = Boolean.parseBoolean(stringArray[3]);

                TaskItem task = new TaskItem(stringArray[0], stringArray[1], stringArray[2], complete);
                tasks.add(task);
            }

            System.out.println("Task list has been loaded");
            System.out.println(" ");

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file, make sure the file you are trying to load is in the same directory, starting a new list instead");
        } catch (Exception ex) {
            System.out.println("An unexpected error has occurred");
            ex.printStackTrace();
        }
    }
}