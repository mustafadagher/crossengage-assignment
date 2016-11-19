/**
 *
 */
package io.crossengage.assignment.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import io.crossengage.assignment.bo.User;

/**
 * The Class UserEmailQueue.
 *
 * @author Mustafa Dagher
 */
public class UserEmailQueue {

    /** The user queue. */
    private BlockingQueue<User> userQueue;

    /** The batch size. */
    private int batchSize;

    /**
     * Instantiates a new user email queue.
     */
    private UserEmailQueue() {
        userQueue = new LinkedBlockingQueue<User>();

        // default batch size is 1000
        this.batchSize = 1000;
    }

    /**
     * Instantiates a new user email queue.
     *
     * @param batchSize the batch size
     */
    public UserEmailQueue(final Integer batchSize) {
        this();
        if (batchSize != null) {
            this.batchSize = batchSize;
        }
    }

    /**
     * Queue user.
     *
     * @param user the user
     */
    public void queueUser(final User user) {
        userQueue.add(user);
    }

    /**
     * checks if batch is full.
     *
     * @return true, if queue size is equals the configured batch size
     */
    public boolean batchFull() {
        return userQueue.size() == batchSize;
    }

    /**
     * Flush the users chunk to an array list.
     *
     * @return the list
     */
    public List<User> flush() {
        final List<User> usersBatch = new ArrayList<>();
        userQueue.drainTo(usersBatch);
        return usersBatch;
    }
}
