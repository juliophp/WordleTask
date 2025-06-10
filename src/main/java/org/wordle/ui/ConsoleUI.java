package org.wordle.ui;

import org.wordle.core.*;
import org.wordle.model.CharacterFeedback;
import org.wordle.model.FeedbackType;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);

    public void run() throws IOException {
        System.out.println("Welcome to Wordle! " +
                "\n Enter a 5 letter word to start " +
                "\n You have 5 attempts" +
                "\n green = correct, yellow = present," +
                " white = absent");

        IWordReader wordReader = new FileWordReader("src/words.txt");
        String targetWord = wordReader.getRandomWord();

        IGame game = new WordleGame(targetWord, new GuessEvaluator());
        while (!game.isGameOver()){
            System.out.printf("\n Enter your guess (%d attempts left): ", game.getRemainingAttempts());
            String guess = scanner.nextLine().trim().toLowerCase();
            if (guess.length() != 5){
                System.out.println("Invalid guess, must be 5 characters");
                continue;
            }
            game.submitGuess(guess);
            printFeedBack(game.getGuessHistory());
        }
        if (game.isWin()){
            System.out.println("Congratulations, You won!");
        }else{
            System.out.println("You have used up all your attempts, sorry!");
        }
        System.out.println("Thanks for playing!");
    }

    private static void printFeedBack(List<List<CharacterFeedback>> guessHistory){
        StringBuilder line = new StringBuilder();
        for (List<CharacterFeedback> feedbacks : guessHistory){
            for (CharacterFeedback characterFeedback : feedbacks){
                char c = Character.toUpperCase(characterFeedback.getLetter());
                switch (characterFeedback.getFeedBackType()){
                    case CORRECT:
                        FeedbackType.CORRECT.colorize(c, line);
                        continue;
                    case MISPLACED:
                        FeedbackType.MISPLACED.colorize(c, line);
                        continue;
                    case ABSENT:
                        FeedbackType.ABSENT.colorize(c, line);
                        continue;
                    default:{}
                }
            }
            line.append("\n");
        }
        System.out.println(line);
    }

}
