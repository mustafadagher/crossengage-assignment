/**
 *
 */
package io.crossengage.assignment.util;

import io.crossengage.assignment.bo.User;
import io.crossengage.assignment.exception.InvalidFormatException;

/**
 * The Class UserUtils.
 *
 * @author Mustafa Dagher
 */
public class UserUtils {

    /**
     * creates a user object from string.
     *
     * @param userString the user string
     * @return the user
     * @throws InvalidFormatException the invalid format exception
     */
    public static User fromString(final String userString) throws InvalidFormatException {

        final String[] fields = userString.split(",");

        if (fields.length < 3) {
            throw new InvalidFormatException();
        }

        final String username = fields[0].trim();
        final String email = fields[1].trim();
        final boolean active = fields[2].trim().equalsIgnoreCase("true");

        final User user = new User(username, email, active);
        return user;
    }

}
