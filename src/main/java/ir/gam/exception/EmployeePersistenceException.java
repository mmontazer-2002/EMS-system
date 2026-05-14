package ir.gam.exception;

public class EmployeePersistenceException extends RuntimeException {

    public EmployeePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeePersistenceException(String message) {
        super(message);
    }
}
