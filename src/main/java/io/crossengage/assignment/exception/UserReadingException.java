/**
 *
 */
package io.crossengage.assignment.exception;


/**
 * @author mustafa.kamel
 *
 */
public class UserReadingException extends SystemException {

    private static final long serialVersionUID = 7068990079482347725L;

    public UserReadingException() {
        // Empty constructor
    }

    public UserReadingException(final String message) {
        this(message, null);
    }

    public UserReadingException(final Throwable cause) {
        this(null, cause);
    }

    public UserReadingException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
