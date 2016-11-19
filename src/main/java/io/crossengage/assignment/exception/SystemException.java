/**
 *
 */
package io.crossengage.assignment.exception;


/**
 * @author Mustafa Dagher
 *
 */
public class SystemException extends Exception {

    private static final long serialVersionUID = -5753372255424531377L;

    public SystemException() {
        // Empty constructor
    }

    public SystemException(final String message) {
        this(message, null);
    }

    public SystemException(final Throwable cause) {
        this(null, cause);
    }

    public SystemException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
