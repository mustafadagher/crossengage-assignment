/**
 *
 */
package io.crossengage.assignment.reader;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.crossengage.assignment.service.EmailSenderService;
import io.crossengage.assignment.service.EmailService;

/**
 * @author mustafa.kamel
 *
 */
public class UserFileReaderTest {

    private static final int BATCH_SIZE = 3;

    private UserReader testee;

    private EmailService emailService;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        testee = new UserFileReader(this.getClass().getResource("/users.txt").getPath(), BATCH_SIZE);
        emailService = new EmailSenderService();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void test() {
        testee.read(users -> emailService.sendBatchEmail(users));
        final String output = outContent.toString();
        final String[] lines = output.split("[\\r\\n]+");
        assertEquals(10, lines.length);
    }

}
