package org.wordle.config;

import org.wordle.Main;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static AppConfig instance = null;
    Properties properties = new Properties();


    public AppConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        }
        catch (Exception e) {
            System.out.println("Sorry, unable to find config.properties");
            return;
        }

    }




    public int getNumberOfLettersAllowedInGuessWord() {
        return Integer.parseInt(properties.getProperty("number_of_letters_allowed_in_guess_word"));
    }

    public int getNumberOfGuessesAllowedInGame() {
        return Integer.parseInt(properties.getProperty("max_number_of_guess_allowed_in_game"));
    }

    public String getFilePathToReadWords() {
        return properties.getProperty("file_path_to_read_words");
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }


}