package org.sparky.homework;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RunOptionFourTest {
    public static final String actualInput1 = "`((4 A) (1 B) (2 C) (2 A) (1 D) (4 E) 2)";
    public static final String expectedStr1 = "`((4 A) (2 C) (1 D) 2)";
    public static final String actualInput2 = "`((4 A) (1 B) (2 C) (2 A) (1 D) (4 E) 3)";
    public static final String expectedStr2 = "`((4 A) (1 B) (2 A) (1 D) 3)";

    LISPExpression anExpression = new LISPExpression(actualInput1);

    @Test
    public void testExecute() throws Exception {
        LISPExpression actual = RunOptionFour.execute(anExpression);
        assertEquals(actual.toString(), expectedStr1);

        actual = RunOptionFour.execute(new LISPExpression(actualInput2));
        assertEquals(actual.toString(), expectedStr2);
    }
}