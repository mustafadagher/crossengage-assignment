/**
 *
 */
package io.crossengage.assignment.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;


/**
 * @author mustafa.kamel
 *
 */
public class UserEmailControllerTest {

    private static final String BATCH_SIZE = "3";

    private UserEmailController testee;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        testee = new UserEmailController();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Test method for {@link io.crossengage.assignment.controller.UserEmailController#sendBatchEmail(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testSendBatchEmail() {
        testee.sendBatchEmail(this.getClass().getResource("/users.txt").getPath(), BATCH_SIZE);
        final String output = outContent.toString();
        final String[] lines = output.split("[\\r\\n]+");
        assertNotNull(lines);
        assertEquals(10, lines.length);
    }

    /**
     * Test method for
     * {@link io.crossengage.assignment.controller.UserEmailController#sendBatchEmail(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testSendBatchEmail_NumberFormatException() {
        testee.sendBatchEmail(this.getClass().getResource("/users.txt").getPath(), "s");
        final String output = outContent.toString();
        final String[] lines = output.split("[\\r\\n]+");
        assertNotNull(lines);
        assertEquals(11, lines.length);
        assertEquals("Batch Size Argument Format error: will use default size of 1000.", lines[0]);
    }

    /**
     * Test method for
     * {@link io.crossengage.assignment.controller.UserEmailController#sendBatchEmail(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testSendBatchEmail_FileNotFoundException() {
        testee.sendBatchEmail("noFile.txt", "3");
        final String output = outContent.toString();
        final String[] lines = output.split("[\\r\\n]+");
        assertNotNull(lines);
        assertEquals(1, lines.length);
        assertEquals("File not found!!", lines[0]);
    }

}
