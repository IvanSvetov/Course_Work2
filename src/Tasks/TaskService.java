package Tasks;
import Exeptions.TaskNotFoundExeption;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static Tasks.Task.taskList;
public class TaskService {
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("Main menu");
        System.out.println("Enter command: ");
        System.out.println("1 - Add task ");
        System.out.println("2 - Print all tasks ");
        System.out.println("3 - Find task by ID ");
        System.out.println("4 - Remove task by ID ");
        System.out.println("0 - Exit ");
    }

    public static void typeOfTheTask() {
        System.out.println("Select type of the task:");
        System.out.println("1 - Work task");
        System.out.println("2 - Personal task");
    }

    public static void taskFrequency() {
        System.out.println("Select the frequency of repetition of the task: ");
        System.out.println("1 - One time task");
        System.out.println("2 - Daily task");
        System.out.println("3 - Weekly task");
        System.out.println("4 - Monthly task");
        System.out.println("5 - Yearly task");
    }
    public static void addTask() {
        taskFrequency();
        switch ((checkMinMax(" ", 1, 5))) {
            case 1:
                OneTimeTask oneTimeTask = new OneTimeTask(verifyTitle("Input title"), verifyTitle("Input description"),
                        checkMinMax("Input year: YYYY", 2023, 2123),
                        checkMinMax("Input month: MM", 1, 12),
                        checkMinMax("Input day: dd", 1, 31), checkMinMax("Input hours: HH", 0, 23), checkMinMax("Input minutes: mm", 0, 59));
                taskList.add(oneTimeTask);
                System.out.println("Onetime task added:" + oneTimeTask);
                break;
            case 2:
                DailyTask dailyTask = new DailyTask(verifyTitle("Input title"), verifyTitle("Input description"),
                        checkMinMax("Input year: YYYY", 2023, 2123),
                        checkMinMax("Input month: MM", 1, 12),
                        checkMinMax("Input day: dd", 1, 31), checkMinMax("Input hours: HH", 0, 23), checkMinMax("Input minutes: mm", 0, 59));
                taskList.add(dailyTask);
                System.out.println("Daily task added" + dailyTask);
                break;
            case 3:
                WeeklyTask weeklyTask = new WeeklyTask(verifyTitle("Input title"), verifyTitle("Input description"),
                        checkMinMax("Input year: YYYY", 2023, 2123),
                        checkMinMax("Input month: MM", 1, 12),
                        checkMinMax("Input day: dd", 1, 31), checkMinMax("Input hours: HH", 0, 23), checkMinMax("Input minutes: mm", 0, 59));
                taskList.add(weeklyTask);
                System.out.println("Weekly task added" + weeklyTask);
                break;
            case 4:
                MonthlyTask monthlyTask = new MonthlyTask(verifyTitle("Input title"), verifyTitle("Input description"),
                        checkMinMax("Input year: YYYY", 2023, 2123),
                        checkMinMax("Input month: MM", 1, 12),
                        checkMinMax("Input day: dd", 1, 31), checkMinMax("Input hours: HH", 0, 23), checkMinMax("Input minutes: mm", 0, 59));
                taskList.add(monthlyTask);
                System.out.println("Monthly task added" + monthlyTask);
                break;
            case 5:
                YearlyTask yearlyTask = new YearlyTask(verifyTitle("Input title"), verifyTitle("Input description"),
                        checkMinMax("Input year: YYYY", 2023, 2123),
                        checkMinMax("Input month: MM", 1, 12),
                        checkMinMax("Input day: dd", 1, 31), checkMinMax("Input hours: HH", 0, 23), checkMinMax("Input minutes: mm", 0, 59));
                taskList.add(yearlyTask);
                System.out.println("Onetime task added" + yearlyTask);
                break;
        }
    }
    public static void printAllTasks(List<Task> taskList) {
        System.out.println("All tasks");
        Stream<Task> taskStream = taskList.stream();
        taskStream.forEach(System.out::println);
    }
    public static Task findTaskByID(long id) {
        var iterator = taskList.iterator();
        while (iterator.hasNext()) {
            var task = iterator.next();
            if (task.getId() == id) {
                return task;
            }
        }return null;
    }
    public static void removeByID(long id) throws TaskNotFoundExeption {
        try {
            if (taskList.contains(findTaskByID(id))) {
                Task r = findTaskByID(id);
                taskList.remove(r);
                System.out.println("Task " + id + " removed");
            } else {
                throw new TaskNotFoundExeption();
            }
        } catch (TaskNotFoundExeption e) {
            e.printStackTrace();
            System.out.println("Task not found");
        }
    }
    public static int checkMinMax(String s, int min, int max) {
        System.out.println(s);
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("This not a number, try again");
                scanner.next();
                continue;
            }
            int number = scanner.nextInt();
            if (number <= max && number >= min)
                return number;
            System.out.println("Incorrect number, try again");
        }
    }
    public static String verifyTitle(String s) {
        System.out.println(s);
        if (scanner.nextLine() == null)
            System.out.println("Incorrect");
        return scanner.next();
    }
}

