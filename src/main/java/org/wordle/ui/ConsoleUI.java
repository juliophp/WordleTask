package org.wordle.ui;

import org.wordle.core.*;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI extends FeedbackUI{

    private final Scanner scanner = new Scanner(System.in);

    public void run() throws IOException {
        System.out.println("Welcome to Wordle! " +
                "\n Enter a 5 letter word to start " +
                "\n You have 5 attempts" +
                "\n green = correct, yellow = present," +
                " white = absent");

        IWordReader wordReader = new FileWordReader("src/words.txt");
        String targetWord = wordReader.getRandomWord();

        IGame game = new WordleGame(targetWord, new GuessEvaluator(), 5);
        while (!game.isGameOver()){
            System.out.printf("\n Enter your guess (%d attempts left): ", game.getRemainingAttempts());
            String guess = scanner.nextLine().trim().toLowerCase();
            game.submitGuess(guess);
            printFeedBack(game.getGuessHistory());
        }
        if (game.isWin()){
            System.out.println("Congratulations, You won!");
        }else{
            System.out.printf("You have used up all your attempts, sorry! \n The word was %s \n", targetWord);
        }
        System.out.println("Thanks for playing!");
    }


}
