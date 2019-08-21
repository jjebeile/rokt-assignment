package com.jeehadjebeile;

public class Scorecard {

    private Frame [] frames = new Frame[10];
    private int currentFrame = 0;

    public Frame[] getFrames() {
        return frames;
    }

    public static Scorecard getInstance() {
        return new Scorecard();
    }

    /**
     * Given a scorecard and the results of two bowls, return an updated scorecard.
     */
    public static Scorecard scoreFrame(Scorecard scorecard, int bowl1, int bowl2) throws ScoreCardException {

        if(!isValidScore(bowl1, bowl2)) {
            throw new ScoreCardException("Invalid Score Combination Thrown" + "(" + bowl1 + "," + bowl2 + ")");
        }

        return scorecard;
    }

    private static boolean isValidScore(int bowl1, int bowl2) throws ScoreCardException {
        boolean isValid = true;

        // If first bowl is a Strike, bowl 2 must be 0
        if(bowl1 == 10 && bowl2 > 0) {
            throw new ScoreCardException(ScoreCardException.INVALID_STRIKE);
        }

        // If either bowl is greater than 10 or if the sum of both bowls is greater than 10
        if(bowl1 > 10 || bowl2 > 10 || bowl1 + bowl2 > 10) {
            isValid = false;
        }

        return isValid;
    }

    /**
     * Returns the current score based on the number of frames/bowls played.
     */
    public int getCurrentScore() {
        int currentScore = 0;
        for(Frame frame : getFrames()) {
            int bowl1 = frame.getBowl1();
            int bowl2 = frame.getBowl2();

            // Strike
            if(bowl1 == 10) {
                // Calculate next two bowls
            }

            // Spare
            if(bowl1 + bowl2 == 10) {
                // Calculate next bowl
            }

            // Open Frame

        }
        return currentScore;
    }
}
