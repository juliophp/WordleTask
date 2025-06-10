package org.wordle.ui;

import org.wordle.model.CharacterFeedback;
import org.wordle.model.FeedbackType;

import java.util.List;

public abstract class FeedbackUI {

    void printFeedBack(List<List<CharacterFeedback>> guessHistory){
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
