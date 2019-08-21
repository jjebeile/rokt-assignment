package com.jeehadjebeile;

public class Scorecard {

    private Frame [] frames = new Frame[10];
    private int currentFrame = 0;

    public Frame[] getFrames() {
        return this.frames;
    }

    public static Scorecard getInstance() {
        return new Scorecard();
    }

    /**
     * Given a scorecard and the results of two bowls, return an updated scorecard.
     */
    public static Scorecard scoreFrame(Scorecard scorecard, int bowl1, int bowl2) throws ScoreCardException {
        validateScores(bowl1, bowl2);
        scorecard.frames[scorecard.currentFrame++] = new Frame(bowl1, bowl2);
        return scorecard;
    }


    private static void validateScores(int bowl1, int bowl2) throws ScoreCardException {
        // Bowl1 validation
        if(bowl1 < 0 || bowl1 > 10) {
            throw new ScoreCardException(ScoreCardException.INVALID_BOWL1_SCORE);
        }

        // Bowl2 validation
        if(bowl2 < 0 || bowl2 > 10) {
            throw new ScoreCardException(ScoreCardException.INVALID_BOWL2_SCORE);
        }

        // If bowl is a Strike, bowl 2 must be 0
        if(bowl1 == 10 && bowl2 > 0) {
            throw new ScoreCardException(ScoreCardException.INVALID_STRIKE);
        }
    }

    /**
     * Returns the current score based on the number of frames/bowls played.
     */
    public int getCurrentScore() {
        int currentScore = 0;
        for(Frame frame : getFrames()) {
            if(frame != null) {
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
                currentScore += bowl1 + bowl2;
            }
        }
        return currentScore;
    }
}
