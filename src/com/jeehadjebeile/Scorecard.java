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
        Frame frame = new Frame(bowl1, bowl2);
        scorecard.frames[scorecard.currentFrame++] = frame;
        updateScores(scorecard);
        return scorecard;
    }

    private static void updateScores(Scorecard scorecard) {
        Frame[] frames = scorecard.getFrames();
        // Update scores for Spares and Strikes
        for(int i=0; i<scorecard.currentFrame-1; i++) {
            if (frames[i].isSpare()) {
                frames[i].setScore(10 + frames[i + 1].getBowl1());
            }
            if (frames[i].isStrike()) {
                if (frames[i + 1].isSpare()) {
                    frames[i].setScore(20);
                } else if(frames[i + 1].isStrike()) {
                    if (i < scorecard.currentFrame - 2) {
                        frames[i].setScore(20 + frames[i + 2].getBowl1());
                    }
                } else {
                    frames[i].setScore(10 + frames[i + 1].getScore());
                }
            }
        }

    }

    /**
     * Given a scorecard and the results of three bowls, return an updated scorecard.
     */
    public static Scorecard scoreFrame(Scorecard scorecard, int bowl1, int bowl2, int bowl3) throws ScoreCardException {
//        validateScores(bowl1, bowl2, bowl3);
//        updateScores(scorecard, new Frame(bowl1, bowl2, bowl3));
        return scorecard;
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
