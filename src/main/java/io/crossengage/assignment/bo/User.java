/**
 *
 */
package io.crossengage.assignment.bo;

import java.io.Serializable;

/**
 * @author mustafa.kamel
 *
 */
public class User implements Serializable {

    private static final long serialVersionUID = 432931834797310974L;

    private String username;

    private String email;

    private boolean active;

    public User() {
        // Empty constructor
    }

    public User(final String username, final String email, final boolean active) {
        this.username = username;
        this.email = email;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

}
