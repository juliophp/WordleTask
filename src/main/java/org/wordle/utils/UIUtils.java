package org.wordle.utils;

import org.wordle.config.AppConfig;
import org.wordle.model.CharacterFeedback;
import org.wordle.model.FeedbackType;

import java.util.List;

public class UIUtils {

    public static void printGameIntro(AppConfig config) {

        String sb = "=========================================\n" +
                "         WELCOME TO WORDLE!\n" +
                "=========================================\n\n" +
                "Enter a " + config.getNumberOfLettersAllowedInGuessWord() + "-letter word to start the game.\n" +
                "You have " + config.getNumberOfGuessesAllowedInGame() + " attempts to guess the correct word.\n\n" +
                "Color Guide:\n" +
                " - " + AnsiConstants.GREEN +
                "Green" + AnsiConstants.RESET +
                "   = Correct letter in correct place\n" +
                " - " + AnsiConstants.YELLOW +
                "Yellow" + AnsiConstants.RESET +
                "  = Correct letter in wrong place\n" +
                " - " + AnsiConstants.RESET +
                "No Color" + AnsiConstants.RESET +
                " = Letter not in the word\n" +
                "\nGood luck!\n" +
                "=========================================\n";
        System.out.println(sb);
    }
    public static void printFeedbackFromGuessHistory(List<List<CharacterFeedback>> guessHistory){
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
