package org.wordle.core;

import org.wordle.model.CharacterFeedback;
import org.wordle.model.FeedbackType;

import java.util.ArrayList;
import java.util.List;

public class GuessEvaluator implements IGuessEvaluator {
    @Override
    public List<CharacterFeedback> evaluateGuess(String target, String guess) {

        target = target.toUpperCase();
        guess = guess.toUpperCase();
        List<CharacterFeedback> result = new ArrayList<>(5);
        FeedbackType[] fb = new FeedbackType[5];
        boolean[] used = new boolean[5];

        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                fb[i] = FeedbackType.CORRECT;
                used[i] = true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (fb[i] == null){
                char g = guess.charAt(i);
                boolean matched = false;
                for (int j = 0; j < 5; j++) {
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

        for (int i = 0; i < 5; i++) {
            result.add(new CharacterFeedback(guess.charAt(i), fb[i]));
        }
        return result;
    }
}
