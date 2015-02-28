package org.sparky.homework;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RunOptionTwoTest {

    LISPExpression anExpression = new LISPExpression("`(A A A A B C C A A D E E E E)");
    String expectedString = "`((4 A) (1 B) (2 C) (2 A) (1 D) (4 E))";

    @Test
    public void testExecute() throws Exception {
        LISPExpression actual = RunOptionTwo.execute(anExpression);
        assertEquals(actual.toString(), expectedString);
    }
}