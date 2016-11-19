/**
 *
 */
package io.crossengage.assignment.service;

import java.util.List;

import io.crossengage.assignment.bo.User;

/**
 * @author mustafa.kamel
 *
 */
public class EmailSenderService implements EmailService {

    @Override
    public void sendBatchEmail(final List<User> users) {
        users.stream().filter(u -> u.isActive()).forEach(u -> sendEmail(u));
    }

    private void sendEmail(final User user) {
        System.out.println("Email Sent to user: " + user.getUsername() + " <" + user.getEmail() + ">.");
    }

}
