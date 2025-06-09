package org.wordle.core;

import org.wordle.model.CharacterFeedback;

import java.util.Collection;
import java.util.List;

public interface IGame {
    List<CharacterFeedback> submitGuess();

    boolean isWin();

    boolean isGameOver();

    int getRemainingAttempts();

    List<CharacterFeedback> getGuessHistory();
}
