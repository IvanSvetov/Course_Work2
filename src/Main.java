import Exeptions.IncorrectArgumentExeption;
import Exeptions.TaskNotFoundExeption;
import Tasks.TaskService;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import static Tasks.Task.taskList;
import static Tasks.TaskService.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws TaskNotFoundExeption {
        while (true) {
            try {
                TaskService.mainMenu();
                int number = checkMinMax("=====================", 0, 5);
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
                } else if (number == 5) {
                    System.out.println("Input Date");
                    printTaskByDate(LocalDate.of(checkMinMax("Input year: YYYY", 2023, 2123),
                            checkMinMax("Input month: MM",1,12),
                            checkMinMax("Input day: dd", 1, 31)));
                }
            }     catch (IncorrectArgumentExeption| DateTimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
