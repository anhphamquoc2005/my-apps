public class Task {
    private int id;
    private String nameTask;
    private boolean finishedTask;

    public Task(int id, String nameTask) {
        this.id = id;
        this.nameTask = nameTask;
        this.finishedTask = false;
    }

    public int getId() {
        return id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public boolean isFinishedTask() {
        return finishedTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public void setFinishedTask(boolean finishedTask) {
        this.finishedTask = finishedTask;
    }

    public void printInfo() {
        String status = finishedTask ? "(completed)" : "(loading...)";
        System.out.println(id + ". " + nameTask + ". " + status);
    }
}
