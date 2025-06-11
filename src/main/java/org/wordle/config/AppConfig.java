package org.wordle.config;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class AppConfig {
    private static AppConfig instance = null;
    Properties properties = new Properties();
    private static final Logger LOGGER = Logger.getLogger(AppConfig.class.getName());


    public AppConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                LOGGER.severe("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        }
        catch (Exception e) {
            LOGGER.severe("Error: " + e.getMessage());
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

    public String getValidationPatternForWords() {
        return String.format(properties.getProperty("allowed_pattern.regexp"), getNumberOfLettersAllowedInGuessWord());
    }

    public String getFailedRegexMessage() {
        return properties.getProperty("failed_reg_exp_message");
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }


}