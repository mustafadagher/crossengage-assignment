/**
 *
 */
package io.crossengage.assignment.service;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.crossengage.assignment.bo.User;

/**
 * @author mustafa.kamel
 */
public class EmailSenderServiceTest {

    private EmailService testee;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        testee = new EmailSenderService();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testSendBatchEmail() {
        final List<User> users = createUsersList(5, 3);
        assertEquals(8, users.size());
        testee.sendBatchEmail(users);
        final String output = outContent.toString();
        final String[] lines = output.split("[\\r\\n]+");
        assertEquals(5, lines.length);
    }

    private List<User> createUsersList(final int active, final int inactive) {
        final List<User> users = new ArrayList<>();
        for (int i = 0; i < active; i++) {
            users.add(new User("u" + i, "e" + i + "@gmail.com", true));
        }

        for (int i = 0; i < inactive; i++) {
            users.add(new User("u" + i, "e" + i + "@gmail.com", false));
        }
        return users;
    }

}
