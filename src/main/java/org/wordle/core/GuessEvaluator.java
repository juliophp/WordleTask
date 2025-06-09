package org.wordle.core;

import org.wordle.model.CharacterFeedback;

import java.util.Collections;
import java.util.List;

public class GuessEvaluator implements IGuessEvaluator {
    @Override
    public List<CharacterFeedback> evaluateGuess(String target, String guess) {
        return Collections.emptyList();
    }
}
