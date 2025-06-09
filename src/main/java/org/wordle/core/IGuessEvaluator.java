package org.wordle.core;

import org.wordle.model.CharacterFeedback;

import java.util.List;

public interface IGuessEvaluator {
    List<CharacterFeedback> evaluateGuess(String target, String guess);
}
