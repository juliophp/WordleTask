package org.wordle.core.impl;

import org.wordle.config.AppConfig;
import org.wordle.core.IGuessEvaluator;
import org.wordle.exceptions.GuessTargetMismatchException;
import org.wordle.model.CharacterFeedback;
import org.wordle.model.FeedbackType;

import java.util.ArrayList;
import java.util.List;

public class GuessEvaluator implements IGuessEvaluator {
    private final AppConfig configInstance = AppConfig.getInstance();;

    public GuessEvaluator() {
    }

    @Override
    public List<CharacterFeedback> evaluateGuess(String target, String guess) {
        target = target.toUpperCase();
        guess = guess.toUpperCase();
        if (target.length() != guess.length()) {
            throw new GuessTargetMismatchException("Guess and target words must have same length");
        }
        int numberOfLettersAllowedInGuessWord = configInstance.getNumberOfLettersAllowedInGuessWord();
        List<CharacterFeedback> result = new ArrayList<>();
        FeedbackType[] fb = new FeedbackType[numberOfLettersAllowedInGuessWord];
        boolean[] used = new boolean[numberOfLettersAllowedInGuessWord];

        for (int i = 0; i < numberOfLettersAllowedInGuessWord; i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                fb[i] = FeedbackType.CORRECT;
                used[i] = true;
            }
        }

        for (int i = 0; i < numberOfLettersAllowedInGuessWord; i++) {
            if (fb[i] == null){
                char g = guess.charAt(i);
                boolean matched = false;
                for (int j = 0; j < numberOfLettersAllowedInGuessWord; j++) {
                    if (!used[j] && target.charAt(j) == g){
                        fb[i] = FeedbackType.MISPLACED;
                        used[j] = true;
                        matched = true;
                        break;
                    }
                }
                if (!matched){
                    fb[i] = FeedbackType.ABSENT;
                }
            }
        }

        for (int i = 0; i < numberOfLettersAllowedInGuessWord; i++) {
            result.add(new CharacterFeedback(guess.charAt(i), fb[i]));
        }
        return result;
    }
}
