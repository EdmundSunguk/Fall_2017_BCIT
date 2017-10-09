package ca.bcit.comp2526.a1c;

/**
 * BadWidthException.
 *
 * @author BCIT
 * @version 2017
 */
public class BadWidthException extends Exception {

    /**
     * Serial number to avoid warning.
     * Author is not BCIT.
     * 
     * @author Sunguk (Edmund) Ham, A00979841
     */
    private static final long serialVersionUID = -7963499628230772424L;

    /**
     * Creates an object of type BadWidthException.
     */
    public BadWidthException() {
    }

    /**
     * Creates an object of type BadWidthException.
     * @param message the message stored in the exception
     */
    public BadWidthException(String message) {
        super(message);
    }

    /**
     * Creates an object of type BadWidthException.
     * @param cause the cause of the exception
     */
    public BadWidthException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
