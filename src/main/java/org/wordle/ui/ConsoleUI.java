package org.wordle.ui;

import org.wordle.config.AppConfig;
import org.wordle.core.*;
import org.wordle.core.impl.FileWordReader;
import org.wordle.core.impl.GuessEvaluator;
import org.wordle.core.impl.WordleGame;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.wordle.utils.UIUtils.*;

public class ConsoleUI {
    private final AppConfig configInstance =  AppConfig.getInstance();
    private final Scanner scanner = new Scanner(System.in);


    public ConsoleUI() {
    }

    public void run() {
        printGameIntro(configInstance);
        Pattern allowedPattern = Pattern.compile(configInstance.getValidationPatternForWords());
        IWordReader wordReader = new FileWordReader(configInstance.getFilePathToReadWords(), allowedPattern);
        String targetWord = wordReader.getRandomWord();
        IGame game = new WordleGame(targetWord, new GuessEvaluator(), configInstance.getNumberOfGuessesAllowedInGame());
        while (!game.isGameOver()){
            System.out.printf("\nEnter your guess (%d attempts left): ", game.getRemainingAttempts());
            String guess = scanner.nextLine().trim().toLowerCase();

            if(!allowedPattern.matcher(guess).matches()){
                System.out.println("Invalid guess :"+configInstance.getFailedRegexMessage());
                continue;
            }
            game.submitGuess(guess);
            printFeedbackFromGuessHistory(game.getGuessHistory());
        }
        if (game.isWin()){
            System.out.println("Congratulations, You won!");
        }else{
            System.out.printf("You have used up all your attempts, sorry! \nThe word was %s \n", targetWord.toUpperCase());
        }
        System.out.println("Thanks for playing!");
    }


}
