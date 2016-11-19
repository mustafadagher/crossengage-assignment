/**
 *
 */
package io.crossengage.assignment.bo;

import java.io.Serializable;

/**
 * The Class User.
 *
 * @author Mustafa Dagher
 */
public class User implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 432931834797310974L;

    /** The username. */
    private String username;

    /** The email. */
    private String email;

    /** The active. */
    private boolean active;

    /**
     * Instantiates a new user.
     */
    public User() {
        // Empty constructor
    }

    /**
     * Instantiates a new user.
     *
     * @param username the username
     * @param email the email
     * @param active the active
     */
    public User(final String username, final String email, final boolean active) {
        this.username = username;
        this.email = email;
        this.active = active;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Checks if is active.
     *
     * @return true, if is active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the active.
     *
     * @param active the new active
     */
    public void setActive(final boolean active) {
        this.active = active;
    }

}
