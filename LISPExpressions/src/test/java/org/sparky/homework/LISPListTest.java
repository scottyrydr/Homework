package org.sparky.homework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LISPListTest {

    LISPList aList = null;

    @BeforeTest
    public void setUp() {
        aList = new LISPList("3 a");
    }


    @Test
    public void testGetNumberComponent() throws Exception {
        assertEquals(aList.getNumberComponent().intValue(), 3, "Incorrect number value in List");
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(aList.toString(), "(3 a)", "Incorrect String representation");
    }
}