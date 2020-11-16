import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertThrows(TaskItem.InvalidDueDateException.class , () -> new TaskItem("Title","Description","2020/04/20"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        assertThrows(TaskItem.InvalidTitleException.class , () -> new TaskItem("","Description","2020-04-20"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        assertDoesNotThrow(() -> new TaskItem("Title","Description","2020-04-20"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        assertDoesNotThrow(() -> new TaskItem("Title","Description","2020-04-20"));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){

    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){

    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){

    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){

    }

}
