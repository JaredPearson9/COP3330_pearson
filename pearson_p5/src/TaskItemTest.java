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
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title","Description","2020-05-20",false);
        list.add(task);

        assertThrows(TaskItem.InvalidDueDateException.class , () -> list.tasks.set(0,new TaskItem("Title","Description","2020/05/20",false)));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title","Description","2020-05-25",false);
        list.add(task);

        assertDoesNotThrow(() -> list.tasks.set(0,new TaskItem("Title","Description","2020-06-20",false)));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title","Description","2020-05-25",false);
        list.add(task);

        assertThrows(TaskItem.InvalidTitleException.class , () -> list.tasks.set(0, new TaskItem("","Description","2020-06-20",false)));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title","Description","2020-05-25",false);
        list.add(task);

        assertDoesNotThrow(() -> list.tasks.set(0,new TaskItem("Title","Description","2020-06-20",false)));
    }
}