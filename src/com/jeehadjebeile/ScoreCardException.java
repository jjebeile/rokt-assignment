package com.jeehadjebeile;

public class ScoreCardException extends Exception {

    public static final String INVALID_STRIKE = "Strike should have second bowl value as 0.";
    public static final String INVALID_BOWL1_SCORE = "Bowl1 score needs to be > 0 and <= 10";
    public static final String INVALID_BOWL2_SCORE = "Bowl2 score needs to be > 0 and <= 10";

    public ScoreCardException(String message) {
        super(message);
    }
}
