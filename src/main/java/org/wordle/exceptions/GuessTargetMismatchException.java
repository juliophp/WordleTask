package org.wordle.exceptions;

import java.io.IOException;
import java.util.InputMismatchException;

public class GuessTargetMismatchException extends InputMismatchException {
    public GuessTargetMismatchException(String message) {
        super("Guess and Target Mismatch: "+message);
    }
}
