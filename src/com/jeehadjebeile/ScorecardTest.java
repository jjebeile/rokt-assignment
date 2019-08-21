package com.jeehadjebeile;

import junit.framework.TestCase;

public class ScorecardTest extends TestCase {

    Scorecard scorecard;
    @Override
    protected void setUp() throws Exception {
        this.scorecard = Scorecard.getInstance();
    }

    public void testScoreFrame() {

        try {
            scorecard = Scorecard.scoreFrame(scorecard, 4, 5);
        } catch (ScoreCardException sce) {
            fail("Exception should not have been thrown");
        }

        assertNotNull(scorecard);

//        assertEquals(9, scorecard.getCurrentScore());

    }

    public void testInvalidStrike() {
        try {
            scorecard = Scorecard.scoreFrame(scorecard, 10, 1);
        } catch (ScoreCardException sce) {
            assertEquals(ScoreCardException.INVALID_STRIKE, sce.getMessage());
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