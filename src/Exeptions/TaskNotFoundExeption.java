package Exeptions;

public class TaskNotFoundExeption extends Exception{
    public TaskNotFoundExeption() {
    }
    public TaskNotFoundExeption(String message) {
        super(message);
    }
}
