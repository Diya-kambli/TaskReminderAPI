package taskreminder;

public class Task {

    private int id;
    private String taskName;
    private String description;
    private String date;
    private String time;
    private String priority;
    private String status;

    public Task(String taskName, String description, String date,
                String time, String priority) {

        this.taskName = taskName;
        this.description = description;
        this.date = date;
        this.time = time;
        this.priority = priority;
        this.status = "Pending";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}