package io.crossengage.assignment.reader;

import java.util.List;
import java.util.function.Consumer;

import io.crossengage.assignment.bo.User;

/**
 * The Interface UserReader.
 *
 * @author Mustafa Dagher
 */
public interface UserReader {

    /**
     * Reads users from file in chunks and apply the consumer method in each chunk.
     *
     * @param sender the sender consumer
     */
    void read(Consumer<List<User>> sender);
}
