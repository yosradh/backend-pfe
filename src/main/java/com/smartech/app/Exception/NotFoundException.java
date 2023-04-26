package com.smartech.app.Exception;

import java.util.List;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {

    private List<String> errors;
    public NotFoundException (List<String> errors) {
        super("Validation failed");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
    
    public NotFoundException(String message, Long id) {
        super(message);
    }
    
    
    public NotFoundException(String message) {
        super(message);
    }
    
    public NotFoundException(String message,Boolean x) {
        super(message);
    }
}
