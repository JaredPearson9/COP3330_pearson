import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertThrows(TaskItem.InvalidDueDateException.class , () -> new TaskItem("Title","Description","2020/05/20",false));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        assertThrows(TaskItem.InvalidTitleException.class , () -> new TaskItem("","Description","2020-05-20",false));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        assertDoesNotThrow(() -> new TaskItem("Title","Description","2020-05-20",false));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        assertDoesNotThrow(() -> new TaskItem("Title","Description","2020-05-20",false));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDate(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title","Description","2020-05-20",false);
        list.add(task);

        assertThrows(TaskItem.InvalidDueDateException.class , () -> list.edit(0,new TaskItem("Title","Description","2020/05/20",false)));
    }

    @Test
    public void editingTaskItemDueDateSucceedsWithValidDate(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title","Description","2020-05-25",false);
        list.add(task);

        assertDoesNotThrow(() -> list.edit(0,new TaskItem("Title","Description","2020-06-20",false)));
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidTitle(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title","Description","2020-05-25",false);
        list.add(task);

        assertThrows(TaskItem.InvalidTitleException.class , () -> list.edit(0, new TaskItem("","Description","2020-06-20",false)));
    }

    @Test
    public void editingTaskItemTitleSucceedsWithExpectedValue(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("TitleBefore","Description","2020-05-25",false);
        list.add(task);

        assertDoesNotThrow(() -> list.edit(0,new TaskItem("Title","Description","2020-05-25",false)));
        assertEquals(list.tasks.get(0).getTaskItemTitle(),"Title");
    }
}