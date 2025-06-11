package org.wordle.ui;

import org.wordle.config.AppConfig;
import org.wordle.core.*;

import java.io.IOException;
import java.util.Scanner;

import static org.wordle.utils.UIUtils.*;

public class ConsoleUI {
    private final AppConfig configInstance;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI() {
        this.configInstance = AppConfig.getInstance();
    }

    public void run() throws IOException {
        printGameIntro(configInstance);
        IWordReader wordReader = new FileWordReader(configInstance.getFilePathToReadWords());
        String targetWord = wordReader.getRandomWord();
        IGame game = new WordleGame(targetWord, new GuessEvaluator(), configInstance.getNumberOfGuessesAllowedInGame());
        while (!game.isGameOver()){
            System.out.printf("\n Enter your guess (%d attempts left): ", game.getRemainingAttempts());
            String guess = scanner.nextLine().trim().toLowerCase();
            if (guess.length() != configInstance.getNumberOfLettersAllowedInGuessWord()){
                System.out.printf("Invalid guess, must be %d characters \n", configInstance.getNumberOfLettersAllowedInGuessWord());
                continue;
            }
            game.submitGuess(guess);
            printFeedbackFromGuessHistory(game.getGuessHistory());
        }
        if (game.isWin()){
            System.out.println("Congratulations, You won!");
        }else{
            System.out.printf("You have used up all your attempts, sorry! \n The word was %s \n", targetWord);
        }
        System.out.println("Thanks for playing!");
    }


}
