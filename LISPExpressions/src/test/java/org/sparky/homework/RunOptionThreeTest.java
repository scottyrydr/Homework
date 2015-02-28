package org.sparky.homework;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RunOptionThreeTest {

    LISPExpression anExpression = new LISPExpression("`(A A A A B C C A A D E E E E)");
    String expectedString = "`((4 A) B (2 C) (2 A) D (4 E))";

    @Test
    public void testExecute() throws Exception {
        LISPExpression actual = RunOptionThree.execute(anExpression);
        assertEquals(actual.toString(), expectedString);
    }
}