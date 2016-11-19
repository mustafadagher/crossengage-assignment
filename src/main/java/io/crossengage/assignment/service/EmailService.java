package io.crossengage.assignment.service;

import java.util.List;

import io.crossengage.assignment.bo.User;

/**
 * The Interface EmailService.
 * 
 * @author Mustafa Dagher
 */
public interface EmailService {

    /**
     * Send batch email to the active users in a list of users.
     *
     * @param users the users
     */
    void sendBatchEmail(List<User> users);

}
