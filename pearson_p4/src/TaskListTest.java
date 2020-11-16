import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList TL = new TaskList();
        TL.add(new TaskItem("task 1", "","2020-01-01",false));
        assertEquals(TL.tasks.size(),1);
    }

    @Test
    public void completingTaskItemChangesStatus(){

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){

    }

    @Test
    public void editingTaskItemChangesValues(){

    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){

    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){

    }

    @Test
    public void editingTaskItemDueDateChangesValue(){

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){

    }

    @Test
    public void editingTaskItemTitleChangesValue(){

    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){

    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){

    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){

    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){

    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){

    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){

    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){

    }

    @Test
    public void newTaskListIsEmpty(){

    }

    @Test
    public void removingTaskItemsDecreasesSize(){

    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){

    }

    @Test
    public void savedTaskListCanBeLoaded(){

    }

    @Test
    public void uncompletingTaskItemChangesStatus(){

    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){

    }

}
