package fr.webnet.test.exposition.exception;


import java.io.Serializable;

class ErrorDetails implements Serializable {

    private final String error;

    ErrorDetails(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
