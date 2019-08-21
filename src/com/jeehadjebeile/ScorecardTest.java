package com.jeehadjebeile;

import junit.framework.TestCase;

public class ScorecardTest extends TestCase {

    public void testScoreFrame() {

        Scorecard scorecard = Scorecard.getInstance();
        int bowl1 = 4;
        int bowl2 = 5;

        scorecard = Scorecard.scoreFrame(scorecard, bowl1, bowl2);

        assertNotNull(scorecard);

        assertEquals(9, scorecard.getCurrentScore());

    }

}