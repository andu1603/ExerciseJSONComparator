package project.exceptions;

public class SystemException extends RuntimeException {

    public SystemException(String msg) {
        super(msg);
    }

    public SystemException(String msg, Throwable e) {
        super(msg, e);
    }
}
