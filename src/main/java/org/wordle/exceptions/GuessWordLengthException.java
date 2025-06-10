package org.wordle.exceptions;

import java.util.InputMismatchException;

public class GuessWordLengthException extends InputMismatchException {
    public GuessWordLengthException(String message) {
        super(message);
    }
}
