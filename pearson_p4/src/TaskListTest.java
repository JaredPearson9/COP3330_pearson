import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList TL = new TaskList();
        int initialSize = TL.tasks.size();
        TL.add(new TaskItem("task 1", "","2020-01-01",false));
        assertNotEquals(TL.tasks.size(),initialSize);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem item = new TaskItem("task 1", "","2020-01-01",false);
        boolean initialStatus = item.getTaskItemComplete();
        item.setComplete(true);
        assertNotEquals(item.getTaskItemComplete(),initialStatus);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList TL = new TaskList();
        TaskItem item = new TaskItem("task 1", "","2020-01-01",false);
        TL.add(item);
        assertThrows(IndexOutOfBoundsException.class , () -> TL.tasks.get(1).setComplete(true));
    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        TaskItem newTask = new TaskItem("task 2", "description","2020-01-02",true);

        TL.edit(0, newTask);

        assertNotEquals(originalTask.getTaskItemTitle(), TL.tasks.get(0).getTaskItemTitle());
        assertNotEquals(originalTask.getTaskItemDescription(), TL.tasks.get(0).getTaskItemDescription());
        assertNotEquals(originalTask.getTaskItemDueDate(), TL.tasks.get(0).getTaskItemDueDate());
        assertNotEquals(originalTask.getTaskItemComplete(), TL.tasks.get(0).getTaskItemComplete());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        TaskItem newTask = new TaskItem("task 1", "description","2020-01-01",false);

        TL.edit(0, newTask);

        assertNotEquals(originalTask.getTaskItemDescription(), TL.tasks.get(0).getTaskItemDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        TaskItem newTask = new TaskItem("task 1", "description","2020-01-01",false);

        assertThrows(IndexOutOfBoundsException.class , () -> TL.edit(1, newTask));
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        TaskItem newTask = new TaskItem("task 1", "","2020-01-02",false);

        TL.edit(0, newTask);

        assertNotEquals(originalTask.getTaskItemDueDate(), TL.tasks.get(0).getTaskItemDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        TaskItem newTask = new TaskItem("task 1", "","2020-01-02",false);

        assertThrows(IndexOutOfBoundsException.class , () -> TL.edit(1, newTask));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        TaskItem newTask = new TaskItem("task 2", "","2020-01-01",false);

        TL.edit(0, newTask);

        assertNotEquals(originalTask.getTaskItemTitle(), TL.tasks.get(0).getTaskItemTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        TaskItem newTask = new TaskItem("task 2", "","2020-01-01",false);

        assertThrows(IndexOutOfBoundsException.class , () -> TL.edit(1, newTask));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        assertThrows(IndexOutOfBoundsException.class , () -> TL.tasks.get(1).getTaskItemDescription());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        assertDoesNotThrow(() -> TL.tasks.get(0).getTaskItemDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        assertThrows(IndexOutOfBoundsException.class , () -> TL.tasks.get(1).getTaskItemDueDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        assertDoesNotThrow(() -> TL.tasks.get(0).getTaskItemDueDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        assertThrows(IndexOutOfBoundsException.class , () -> TL.tasks.get(1).getTaskItemTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskItem originalTask = new TaskItem("task 1", "","2020-01-01",false);

        TaskList TL = new TaskList();
        TL.add(originalTask);

        assertDoesNotThrow(() -> TL.tasks.get(0).getTaskItemTitle());
    }

    @Test
    public void newTaskListIsEmpty(){
        TaskList TL = new TaskList();
        assertEquals(TL.tasks.size(), 0);
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList TL = new TaskList();
        TL.add(new TaskItem("task 1", "","2020-01-01",false));
        int initialSize = TL.tasks.size();

        TL.remove(0);
        assertNotEquals(TL.tasks.size(),initialSize);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList TL = new TaskList();
        TL.add(new TaskItem("task 1", "","2020-01-01",false));

        assertThrows(IndexOutOfBoundsException.class , () ->  TL.remove(1));
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList TL = new TaskList();
        TaskItem initialTask = new TaskItem("task 1", "","2020-01-01",false);
        TL.add(initialTask);

        String filename = "filename";
        TL.write(filename);

        TaskList TL2 = new TaskList();
        TL2.load(filename);

        assertEquals(TL2.tasks.get(0).getTaskItemTitle(), TL.tasks.get(0).getTaskItemTitle());
        assertEquals(TL2.tasks.get(0).getTaskItemDescription(), TL.tasks.get(0).getTaskItemDescription());
        assertEquals(TL2.tasks.get(0).getTaskItemDueDate(), TL.tasks.get(0).getTaskItemDueDate());
        assertEquals(TL2.tasks.get(0).getTaskItemComplete(), TL.tasks.get(0).getTaskItemComplete());
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem item = new TaskItem("task 1", "","2020-01-01",true);
        boolean initialStatus = item.getTaskItemComplete();
        item.setComplete(false);
        assertNotEquals(item.getTaskItemComplete(),initialStatus);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList TL = new TaskList();
        TaskItem item = new TaskItem("task 1", "","2020-01-01",true);
        TL.add(item);
        assertThrows(IndexOutOfBoundsException.class , () -> TL.tasks.get(1).setComplete(false));
    }

}
