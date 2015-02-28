package org.sparky.homework;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RunOptionOneTest {

    String input1 = "`(A B C D E)";
    String expectedResult = "`(E D C B A)";

    @Test
    public void testExecute() throws Exception {

        LISPExpression inputExpression = new LISPExpression(input1);

        LISPExpression actualResult = RunOptionOne.execute(inputExpression);
        assertEquals(actualResult.toString(), expectedResult);
    }
}