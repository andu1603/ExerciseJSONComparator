package project.exceptions;

public class IncorrectInputParametersException extends RuntimeException {

    public IncorrectInputParametersException(String msg) {
        super(msg);
    }

    public IncorrectInputParametersException(String msg, Throwable e) {
        super(msg, e);
    }
}
