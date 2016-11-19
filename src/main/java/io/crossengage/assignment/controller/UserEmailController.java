/**
 *
 */
package io.crossengage.assignment.controller;

import java.io.FileNotFoundException;
import java.util.List;

import io.crossengage.assignment.bo.User;
import io.crossengage.assignment.reader.UserFileReader;
import io.crossengage.assignment.reader.UserReader;
import io.crossengage.assignment.service.EmailSenderService;
import io.crossengage.assignment.service.EmailService;

/**
 * @author mustafa.kamel
 *
 */
public class UserEmailController {

    private UserReader userReader;

    private EmailService emailService;

    public void sendBatchEmail(final String filePath, final String batchSize) {
        init(filePath, batchSize);
        final List<User> users = userReader.read();
        emailService.sendBatchEmail(users);
    }

    private void init(final String filePath, final String batchSize) {

        Integer size = null;
        try {
            size = Integer.valueOf(batchSize);
        } catch (final NumberFormatException e) {
            System.out.println("Batch Size Argument Format error: will use default size of 1000.");
        }

        try {
            userReader = new UserFileReader(filePath, size);
            emailService = new EmailSenderService();
        } catch (final FileNotFoundException e) {
            System.out.println("File not found!!");
            return;
        }
    }
}
