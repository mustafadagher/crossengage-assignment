/**
 *
 */
package io.crossengage.assignment.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import io.crossengage.assignment.bo.User;
import io.crossengage.assignment.exception.EmptyLineException;
import io.crossengage.assignment.exception.InvalidFormatException;
import io.crossengage.assignment.exception.SystemException;
import io.crossengage.assignment.exception.UserReadingException;
import io.crossengage.assignment.util.UserUtils;

/**
 * The Class UserFileReader.
 *
 * @author Mustafa Dagher
 */
public class UserFileReader implements UserReader {

    private BufferedReader userReader;

    private UserEmailQueue queue;

    public UserFileReader(final String filePath) throws FileNotFoundException {
        this(filePath, null);
    }

    public UserFileReader(final String filePath, final Integer batchSize) throws FileNotFoundException {
        final FileReader reader = new FileReader(filePath);
        userReader = new BufferedReader(reader);
        queue = new UserEmailQueue(batchSize);
    }

    /* (non-Javadoc)
     * @see io.crossengage.assignment.reader.UserReader#read()
     */
    @Override
    public void read(final Consumer<List<User>> sender) {

        while (true) {
            try {
                final User user = this.getUser();
                if (user != null) {
                    queue.queueUser(user);
                }

                if (queue.batchFull()) {
                    sender.accept(queue.flush());
                }
            } catch (final EmptyLineException e) {
                sender.accept(queue.flush());
                break;
            } catch (final SystemException e) {
                if (e instanceof UserReadingException) {
                    System.out.println("Exception while reading the file.");
                }
            }
        }
    }

    private User getUser() throws SystemException {
        String userString = null;
        try {
            userString = userReader.readLine();
            if (userString == null || userString.isEmpty()) {
                userReader.close();
                throw new EmptyLineException();
            } else {
                return UserUtils.fromString(userString);
            }
        } catch (final IOException e) {
            throw new UserReadingException(e);
        } catch (final InvalidFormatException e) {
            System.out.println("The user entry: {" + userString + "} has an invalid format.");
            return null;
        }
    }
}
