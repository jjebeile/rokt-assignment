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

    public void testScoreFrameWithSpares() {
        // No Spares or Strikes and exactly 10 frames (last frame only 2 balls)
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 3, 7); // Spare
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 1, 2);
            assertEquals(23, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 8, 0);
            assertEquals(31, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 0, 10); // Spare
            assertEquals(31, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 8, 2); // Spare
            assertEquals(49, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 2, 7);
            assertEquals(70, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 4, 6); // Spare
            assertEquals(70, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(93, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 5, 4);
            assertEquals(102, scorecard.getCurrentScore());
        } catch (ScoreCardException sce) {
            fail("Exception should not have been thrown");
        }
    }

    public void testScoreFrameWithStrikes() {
        // No Spares or Strikes and exactly 10 frames (last frame only 2 balls)
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0); // Strike
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 1, 2);
            assertEquals(25, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 8, 0);
            assertEquals(33, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0); // Strike
            assertEquals(33, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0); // Strike
            assertEquals(33, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 2, 7);
            assertEquals(83, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0); // Strike
            assertEquals(83, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(111, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 5, 4);
            assertEquals(120, scorecard.getCurrentScore());
        } catch (ScoreCardException sce) {
            fail("Exception should not have been thrown");
        }
    }

    public void testComplexScoreFrame() {
        // A mix of Spares and Strikes and exactly 10 frames (last frame only 2 balls)
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0); // Strike
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 1, 9); // Spare
            assertEquals(29, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 8, 0);
            assertEquals(55, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0); // Strike
            assertEquals(55, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 8, 2); // Spare
            assertEquals(75, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0); // Strike
            assertEquals(95, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 4, 6); // Spare
            assertEquals(115, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(138, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 5, 4);
            assertEquals(147, scorecard.getCurrentScore());
        } catch (ScoreCardException sce) {
            fail("Exception should not have been thrown");
        }
    }

    public void testTooManyBowlsScoreFrame() {
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
            scorecard = Scorecard.scoreFrame(scorecard, 2, 7, 5);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.TOO_MANY_BOWLS_IN_FRAME, sce.getMessage());
        }
    }


    public void testSpareInFinalFrame() {
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 1, 2);
            assertEquals(25, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 8, 0);
            assertEquals(33, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(33, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(33, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 2, 7);
            assertEquals(83, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(83, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(111, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 6, 4, 9);
            assertEquals(130, scorecard.getCurrentScore());
        } catch (ScoreCardException sce) {
            fail("Exception should not have been thrown");
        }
    }

    public void testStrikeInFinalFrame() {
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(9, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 1, 2);
            assertEquals(25, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 8, 0);
            assertEquals(33, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(33, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(33, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 2, 7);
            assertEquals(83, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(83, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
            assertEquals(111, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 5, 3);
            assertEquals(129, scorecard.getCurrentScore());
        } catch (ScoreCardException sce) {
            fail("Exception should not have been thrown: " + sce.getMessage());
        }
    }

    public void testPerfectGame() {
        // All Strikes, should end up with a 300 as final score.
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(0, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(0, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(30, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(60, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(90, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(120, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(150, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(180, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 0);
            assertEquals(210, scorecard.getCurrentScore());
            scorecard = Scorecard.scoreFrame(scorecard, 10, 10, 10);
            assertEquals(300, scorecard.getCurrentScore());
        } catch (ScoreCardException sce) {
            fail("Exception should not have been thrown: " + sce.getMessage());
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

    public void testInvalidTotalFrame() {
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 7, 5);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.INVALID_SCORE_IN_FRAME, sce.getMessage());
        }
    }

    public void testInvalidBowl3() {
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 1, 5, -5);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.INVALID_BOWL3_SCORE, sce.getMessage());
        }

        try {
            scorecard = Scorecard.scoreFrame(scorecard, 0, 7, 15);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.INVALID_BOWL3_SCORE, sce.getMessage());
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
            fail("Exception should not have been thrown: " + sce.getMessage());
        }

    }
}