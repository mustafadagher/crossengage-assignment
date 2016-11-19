/**
 *
 */
package io.crossengage.assignment.controller;

import java.io.FileNotFoundException;

import io.crossengage.assignment.reader.UserFileReader;
import io.crossengage.assignment.reader.UserReader;
import io.crossengage.assignment.service.EmailSenderService;
import io.crossengage.assignment.service.EmailService;

/**
 * The Class UserEmailController.
 *
 * @author Mustafa Dagher
 */
public class UserEmailController {

    /** The user reader. */
    private UserReader userReader;

    /** The email service. */
    private EmailService emailService;

    /**
     * Send batch email.<BR>
     * call the {@link UserReader#read} method and passes the {@link EmailService#sendBatchEmail} method to it's
     * consumer so that the reader reads user file and then sends email to each chunk of users
     *
     * @param filePath the file path
     * @param batchSize the batch size
     */
    public void sendBatchEmail(final String filePath, final String batchSize) {
        try {
            init(filePath, batchSize);
            userReader.read(s -> emailService.sendBatchEmail(s));
        } catch (final FileNotFoundException e) {
            System.out.println("File not found!!");
        }
    }

    /**
     * Initializes the userReader and emailService.
     *
     * @param filePath the file path
     * @param batchSize the batch size
     */
    private void init(final String filePath, final String batchSize) throws FileNotFoundException {

        Integer size = null;
        try {
            size = Integer.valueOf(batchSize);
        } catch (final NumberFormatException e) {
            System.out.println("Batch Size Argument Format error: will use default size of 1000.");
        }

        userReader = new UserFileReader(filePath, size);
        emailService = new EmailSenderService();
    }
}
