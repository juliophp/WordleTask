package org.wordle;

import org.wordle.ui.ConsoleUI;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Starting Wordle Game");
        try {
            new ConsoleUI().run();
        } catch (Exception e) {
            LOGGER.severe("Error: " + e.getMessage());
        }
        LOGGER.info("Wordle Game Ended");
    }
}