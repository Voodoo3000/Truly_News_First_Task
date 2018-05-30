package kz.epam.intlab.action;

public class ActionException extends Exception {

    public ActionException() {
    }

    public ActionException(String message) {
    }

    public ActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActionException(Throwable cause) {
        super(cause);
    }
}
