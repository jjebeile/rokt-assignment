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
        updateScores(scorecard, new Frame(bowl1, bowl2));
        return scorecard;
    }

    /**
     * Given a scorecard and the results of three bowls, return an updated scorecard.
     */
    public static Scorecard scoreFrame(Scorecard scorecard, int bowl1, int bowl2, int bowl3) throws ScoreCardException {
//        validateScores(bowl1, bowl2, bowl3);
//        updateScores(scorecard, new Frame(bowl1, bowl2, bowl3));
        return scorecard;
    }

    private static void updateScores(Scorecard scorecard, Frame frame) {
        scorecard.frames[scorecard.currentFrame] = frame;


        scorecard.currentFrame++;
    }



    /**
     * Returns the current score based on the number of frames/bowls played.
     */
    public int getCurrentScore() {
        int currentScore = 0;
        for(Frame frame : getFrames()) {
            if(frame != null) {
                currentScore += frame.getScore();
            }
        }
        return currentScore;
    }
}
