/**
 *
 */
package io.crossengage.assignment;

import io.crossengage.assignment.controller.UserEmailController;

/**
 * @author Mustafa Dagher
 *
 */
public class Application {

    private static UserEmailController userEmailController;

    /**
     * @param args
     */
    public static void main(final String[] args) {

        if (args.length == 0) {
            System.out.println("Missing arguments!!");
            System.out.println("Usage: crossengage-assignment-0.0.1.jar users_file_path  batchSize <optional>");
            return;
        }

        final String filePath = args[0];
        String batchSize = null;

        if (args.length > 1) {
            batchSize = args[1];
        }
        userEmailController = new UserEmailController();
        userEmailController.sendBatchEmail(filePath, batchSize);

    }

}
