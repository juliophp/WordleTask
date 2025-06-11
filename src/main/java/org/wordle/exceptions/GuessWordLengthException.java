package org.wordle.exceptions;

import java.util.InputMismatchException;

public class GuessWordLengthException extends InputMismatchException {
    public GuessWordLengthException(String message) {
        super("Guess Word Length Error: "+message);
    }
}
