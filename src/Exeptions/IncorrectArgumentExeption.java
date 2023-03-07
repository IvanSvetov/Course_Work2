package Exeptions;

public class IncorrectArgumentExeption extends RuntimeException {

    public IncorrectArgumentExeption() {
        super();
    }

    public IncorrectArgumentExeption(String message) {
        super(message);
    }

}


