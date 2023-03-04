package Exeptions;

public class IncorrectArgumentExeption extends RuntimeException{

    public IncorrectArgumentExeption() {
        super();
    }
    public IncorrectArgumentExeption(String message) {
        super(message);
    }
    public static void checkTypeTask(int number) throws IncorrectArgumentExeption{
        if (number > 5) {
            throw new IncorrectArgumentExeption();
        }
    }
}
