package com.jeehadjebeile;

public class Frame {

    private int bowl1 = 0;
    private int bowl2 = 0;
    private int bowl3 = 0;
    private int score = 0;

    public Frame(int bowl1, int bowl2) {
        this.bowl1 = bowl1;
        this.bowl2 = bowl2;
    }

    public int getBowl1() {
        return bowl1;
    }

    public void setBowl1(int bowl1) {
        this.bowl1 = bowl1;
    }

    public int getBowl2() {
        return bowl2;
    }

    public void setBowl2(int bowl2) {
        this.bowl2 = bowl2;
    }

    public int getBowl3() {
        return bowl3;
    }

    public void setBowl3(int bowl3) {
        this.bowl3 = bowl3;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
