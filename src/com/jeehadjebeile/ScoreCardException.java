package com.jeehadjebeile;

public class ScoreCardException extends Exception {

    public static final String INVALID_BOWL1_SCORE = "Bowl1 score needs to be > 0 and <= 10";
    public static final String INVALID_BOWL2_SCORE = "Bowl2 score needs to be > 0 and <= 10";
    public static final String INVALID_BOWL3_SCORE = "Bowl3 score needs to be > 0 and <= 10";
    public static final String INVALID_SCORE_IN_FRAME = "Total score cannot be greater than 10";
    public static final String TOO_MANY_BOWLS_IN_FRAME = "Can only have 3 bowls on final frame";

    public ScoreCardException(String message) {
        super(message);
    }
}
