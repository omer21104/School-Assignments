// submitted by Omer Zano - 315740118 && Gal Aloush - 206115156
package exceptions;

public class UnhealthyException extends Exception {
    public UnhealthyException() {
    }

    public UnhealthyException(String message) {
        super(message);
    }

    public UnhealthyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnhealthyException(Throwable cause) {
        super(cause);
    }

    public UnhealthyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
