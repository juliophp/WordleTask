package org.wordle.model;

public class CharacterFeedback {
    public FeedbackType FeedBackType;
    public char letter;

    public CharacterFeedback(char letter, FeedbackType feedbackType) {
        this.letter = letter;
        this.FeedBackType = feedbackType;
    }

    public FeedbackType getFeedBackType() {
        return FeedBackType;
    }
}
