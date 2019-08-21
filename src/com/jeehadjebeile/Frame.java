package com.jeehadjebeile;

public class Frame {

    private int bowl1 = 0;
    private int bowl2 = 0;
    private int bowl3 = 0;
    private int score = 0;
    private boolean isSpare = false;
    private boolean isStrike = false;

    public Frame(int bowl1, int bowl2) throws ScoreCardException{
        validateScores(bowl1, bowl2);

        this.bowl1 = bowl1;
        this.bowl2 = bowl2;

        if(this.bowl1 == 10 && this.bowl2 == 0) {
            this.isStrike = true;
            this.score = 0;
        } else if(this.bowl1 + this.bowl2 == 10) {
            this.isSpare = true;
            this.score = 0;
        } else {
            this.score = this.bowl1 + this.bowl2;
        }
    }

    private void validateScores(int bowl1, int bowl2) throws ScoreCardException {
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


    public int getBowl1() {
        return bowl1;
    }

    public int getBowl2() {
        return bowl2;
    }

    public int getBowl3() {
        return bowl3;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
