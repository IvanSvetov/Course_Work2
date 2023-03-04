import Exeptions.TaskNotFoundExeption;
import Tasks.TaskService;
import java.util.Scanner;
import static Tasks.Task.taskList;
import static Tasks.TaskService.checkMinMax;
import static Tasks.TaskService.printAllTasks;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws TaskNotFoundExeption {
        while (true) {
            TaskService.mainMenu();
            int number = checkMinMax("=====================", 0, 4);
            if (number == 0) {
                System.out.println("Exit");
                break;
            } else if (number == 1) {
                TaskService.addTask();
                System.out.println("=====================");
            } else if (number == 2) {
                printAllTasks(taskList);
            } else if (number == 3) {
                System.out.println("Input task ID");
                System.out.println(TaskService.findTaskByID(scanner.nextLong()));
            } else if (number == 4) {
                printAllTasks(taskList);
                System.out.println("Input task ID for remove");
                TaskService.removeByID(scanner.nextLong());
            }
        }
    }
}
