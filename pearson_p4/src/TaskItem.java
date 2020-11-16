import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskItem {
    private final String title;
    private final String description;
    private final String dueDate;
    private boolean complete;

    public TaskItem(String title, String description, String dueDate, boolean complete){

        if(isTitleValid(title)){
            this.title = title;
        } else{
            throw new InvalidTitleException("title is not valid; must be at least 1 character long");
        }

        this.description = description;

        if(isDueDateValid(dueDate)){
            this.dueDate = dueDate;
        } else{
            throw new InvalidDueDateException("due date is not valid; must be of the form YYYY-MM-DD");
        }

        this.complete = complete;

    }

    private boolean isTitleValid(String title) {
        return title.length() > 0;
    }

    private boolean isDueDateValid(String dueDate) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try{
            sdf.parse(dueDate);
        } catch(ParseException ex){
            return false;
        }
        return true;
    }

    public String getTaskItemTitle(){
        return this.title;
    }

    public String getTaskItemDescription(){
        return this.description;
    }

    public String getTaskItemDueDate(){
        return this.dueDate;
    }

    public boolean getTaskItemComplete(){
        return this.complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    static class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
    }

    static class InvalidDueDateException extends IllegalArgumentException {
        public InvalidDueDateException(String msg) {
            super(msg);
        }
    }
}
