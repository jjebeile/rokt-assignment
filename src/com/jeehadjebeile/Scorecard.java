package com.jeehadjebeile;

public class Scorecard {

    private Frame [] frames = new Frame[10];

    public Frame[] getFrames() {
        return frames;
    }

    public static Scorecard getInstance() {
        return new Scorecard();
    }

    /**
     * Given a scorecard and the results of two bowls, return an updated scorecard.
     */
    public static Scorecard scoreFrame(Scorecard scorecard, int bowl1, int bowl2) {
        return null;
    }

    /**
     * Returns the current score based on the number of frames/bowls played.
     */
    public int getCurrentScore() {
        return 0;
    }
}
