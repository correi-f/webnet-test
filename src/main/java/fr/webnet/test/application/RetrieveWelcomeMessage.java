package fr.webnet.test.application;

import org.springframework.stereotype.Service;

@Service
public class RetrieveWelcomeMessage {

    private static final String WELCOME = "Welcome to the Webnet jungle";

    public String of() {
        return WELCOME;
    }
}