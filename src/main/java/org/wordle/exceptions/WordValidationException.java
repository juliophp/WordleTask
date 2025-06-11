package org.wordle.exceptions;

import java.util.InputMismatchException;

public class WordValidationException extends InputMismatchException {
    public WordValidationException(String message) {
        super("Word Validation Error: "+message);
    }
}
