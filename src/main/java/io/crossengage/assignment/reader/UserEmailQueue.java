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
 * @author mustafa.kamel
 *
 */
public class UserEmailQueue {

    private BlockingQueue<User> userQueue;

    private int batchSize;

    private UserEmailQueue() {
        userQueue = new LinkedBlockingQueue<User>();

        // default batch size is 1000
        this.batchSize = 1000;
    }

    public UserEmailQueue(final Integer batchSize) {
        this();
        if (batchSize != null) {
            this.batchSize = batchSize;
        }
    }

    public void queueUser(final User user) {
        userQueue.add(user);
    }

    public boolean batchFull() {
        return userQueue.size() == batchSize;
    }

    public List<User> flush() {
        final List<User> usersBatch = new ArrayList<>();
        userQueue.drainTo(usersBatch);
        return usersBatch;
    }
}
