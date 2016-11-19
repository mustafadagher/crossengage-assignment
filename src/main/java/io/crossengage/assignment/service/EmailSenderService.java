/**
 *
 */
package io.crossengage.assignment.service;

import java.util.List;

import io.crossengage.assignment.bo.User;

/**
 * The Class EmailSenderService.
 *
 * @author Mustafa Dagher
 */
public class EmailSenderService implements EmailService {

    /*
     * (non-Javadoc)
     * @see io.crossengage.assignment.service.EmailService#sendBatchEmail(java.util.List)
     */
    @Override
    public void sendBatchEmail(final List<User> users) {
        users.stream().filter(u -> u.isActive()).forEach(u -> sendEmail(u));
    }

    /**
     * Send email.
     *
     * @param user the user
     */
    private void sendEmail(final User user) {
        System.out.println("Email Sent to user: " + user.getUsername() + " <" + user.getEmail() + ">.");
    }

}
