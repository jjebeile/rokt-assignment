package com.jeehadjebeile;

import junit.framework.TestCase;

public class ScorecardTest extends TestCase {

    Scorecard scorecard;
    @Override
    protected void setUp() throws Exception {
        this.scorecard = Scorecard.getInstance();
    }

    public void testBasicScoreFrame() {
        // No Spares or Strikes and exactly 10 frames (last frame only 2 balls)
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 3, 3);
            assertEquals(15, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 1, 2);
            assertEquals(18, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 8, 0);
            assertEquals(26, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 0, 9);
            assertEquals(35, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 1, 8);
            assertEquals(44, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 2, 7);
            assertEquals(53, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 3, 6);
            assertEquals(62, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(71, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 5, 4);
            assertEquals(80, scorecard.getCurrentScore());
        } catch (ScoreCardException sce) {
            fail("Exception should not have been thrown");
        }
    }

    public void testInvalidStrike() {
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 10, 1);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.INVALID_STRIKE, sce.getMessage());
        }
    }

    public void testInvalidBowl1() {
        try {
            scorecard = Scorecard.scoreFrame(scorecard, -1, 1);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.INVALID_BOWL1_SCORE, sce.getMessage());
        }

        try {
            scorecard = Scorecard.scoreFrame(scorecard, 13, 1);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.INVALID_BOWL1_SCORE, sce.getMessage());
        }
    }

    public void testInvalidBowl2() {
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 1, -5);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.INVALID_BOWL2_SCORE, sce.getMessage());
        }

        try {
            scorecard = Scorecard.scoreFrame(scorecard, 0, 15);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.INVALID_BOWL2_SCORE, sce.getMessage());
        }
    }

    public void testValidScores() {
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 4, 6);
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            scorecard = Scorecard.scoreFrame(scorecard, 2, 7);
            scorecard = Scorecard.scoreFrame(scorecard, 8, 0);
            scorecard = Scorecard.scoreFrame(scorecard, 0, 0);
            scorecard = Scorecard.scoreFrame(scorecard, 0, 10);
        } catch (ScoreCardException sce) {
            fail("Exception should not have been thrown");
        }

    }
}