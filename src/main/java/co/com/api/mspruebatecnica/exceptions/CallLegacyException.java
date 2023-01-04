package co.com.api.mspruebatecnica.exceptions;

/**
 * Interfaz para excepcion CallLegacy
 */
public class CallLegacyException extends RuntimeException {

    public CallLegacyException(String message) {
        super(message);
    }

    public CallLegacyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CallLegacyException(Throwable cause) {
        super(cause);
    }
}
