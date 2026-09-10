import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> listTask = new ArrayList<>();

        int select;
        int idCounter = 1;

        do {
            System.out.println("\n=== App To-do List ===");
            System.out.println("1. Add new Task");
            System.out.println("2. View list Task");
            System.out.println("3. Tick finished Task");
            System.out.println("4. Remove task");
            System.out.println("5. Exit");
            System.out.println("Choose: ");

            select = sc.nextInt();
            sc.nextLine();

            switch (select) {
                case 1:
                    String content = null;
                    while (true) {
                        System.out.println("Enter task details: ");
                        content = sc.nextLine();
                        if (content.trim().isEmpty()) {
                            System.out.println("The content cannot be left blank.");
                        } else {
                            break;
                        }
                    }
                    Task newTask = new Task(idCounter++, content.trim());
                    listTask.add(newTask);
                    System.out.println("Task " + "'" + newTask.getNameTask() + "' " + "add completed!");
                    break;
                
                case 2:
                    System.out.println("\n--- To-do List ---");
                    if (listTask.isEmpty()) {
                        System.out.println("Don't have a job.");
                    } else {
                        for (Task t : listTask) {
                            t.printInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter id task finished: ");
                    int idFinished = sc.nextInt();
                    sc.nextLine();
                    boolean find = false;
                    for (Task t : listTask) {
                        if (idFinished == t.getId()) {
                            t.setFinishedTask(true);
                            find = true;
                            System.out.println("Task " + "'" + t.getNameTask() + "' " + "is completed!");
                        }
                    }
                    if (!find) {
                        System.out.println("Don't have a job.");
                    }
                    break;
                
                case 4:
                    System.out.println("Enter id task remove: ");
                    int idRemove = sc.nextInt();
                    sc.nextLine();
                    Task removeTask = null;
                    for (Task t : listTask) {
                        if (idRemove == t.getId()) {
                            removeTask = t;
                            break;
                        }
                    }
                    if (removeTask != null) {
                        listTask.remove(removeTask);
                        System.out.println("Task " + "'" + removeTask.getNameTask() + "'" + " remove completed!");
                    } else {
                        System.out.println("Don't have a job.");
                    }
                    break;

                case 5:
                    System.out.println("Exited app!");
                    break;

                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        } while (select != 5);
        sc.close();
    }
}
