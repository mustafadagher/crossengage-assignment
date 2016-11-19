package io.crossengage.assignment.service;

import java.util.List;

import io.crossengage.assignment.bo.User;

public interface EmailService {

    void sendBatchEmail(List<User> users);

}
