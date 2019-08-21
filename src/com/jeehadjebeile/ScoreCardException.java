package com.jeehadjebeile;

public class ScoreCardException extends Exception {

    public static final String INVALID_STRIKE = "Strike should have second bowl value as 0.";

    public ScoreCardException(String message) {
        super(message);
    }
}
