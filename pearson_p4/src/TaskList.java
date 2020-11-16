import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TaskList {
    List<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void add(TaskItem task){
        tasks.add(task);
    }

    public void set(int index,TaskItem task){
        tasks.set(index,task);
    }

    public void remove(int index){
        tasks.remove(index);
    }

    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < tasks.size(); i++) {
                TaskItem task = tasks.get(i);
                output.format("%s;%s;%s%n", task.getTaskItemTitle(), task.getTaskItemDescription(), task.getTaskItemDueDate());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //shall contain 0 or more task items

    //taskList function letting user view current task list
    //taskList function letting user add an item to current task list
    //taskList function letting user edit an item in the current task list
    //taskList function letting user remove item from current task list
    //taskList function to mark item as complete
    //taskList function to unmark item as complete
    //taskList function to save current list

}
