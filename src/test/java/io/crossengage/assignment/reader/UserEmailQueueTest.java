/**
 *
 */
package io.crossengage.assignment.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.crossengage.assignment.bo.User;

/**
 * @author mustafa.kamel
 *
 */
public class UserEmailQueueTest {

    private static final int BATCH_SIZE = 3;

    private UserEmailQueue testee;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        testee = new UserEmailQueue(BATCH_SIZE);
    }


    /**
     * Test method for
     * {@link io.crossengage.assignment.reader.UserEmailQueue#queueUser(io.crossengage.assignment.bo.User)} and
     * {@link io.crossengage.assignment.reader.UserEmailQueue#flush()}.
     */
    @Test
    public void testQueueUserAndFlush() {

        final User user = new User("mustafa", "dagher.mustafa@gmail.com", true);
        testee.queueUser(user);
        List<User> users = testee.flush();
        assertNotNull(users);
        assertEquals(1, users.size());

        testee.queueUser(user);
        testee.queueUser(user);
        users = testee.flush();
        assertEquals(2, users.size());
    }

    /**
     * Test method for {@link io.crossengage.assignment.reader.UserEmailQueue#batchFull()}.
     */
    @Test
    public void testBatchFull() {
        final User user = new User("mustafa", "dagher.mustafa@gmail.com", true);
        testee.queueUser(user);
        testee.queueUser(user);
        testee.queueUser(user);
        assertTrue(testee.batchFull());
    }

}
