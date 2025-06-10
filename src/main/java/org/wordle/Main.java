package org.wordle;

import org.wordle.ui.ConsoleUI;

/public class Main {
    public static void main(String[] args) {
        try {
            new ConsoleUI();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}