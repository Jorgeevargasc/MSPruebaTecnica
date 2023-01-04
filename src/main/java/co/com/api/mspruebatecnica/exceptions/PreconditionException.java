package co.com.api.mspruebatecnica.exceptions;

public class PreconditionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PreconditionException(String message) {
        super(message);
    }

    public PreconditionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PreconditionException(Throwable cause) {
        super(cause);
    }
}
