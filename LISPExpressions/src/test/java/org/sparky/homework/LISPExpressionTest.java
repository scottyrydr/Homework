package org.sparky.homework;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LISPExpressionTest {

    private LISPExpression anExpression;

    @BeforeMethod
    public void setUp() throws Exception {
        anExpression = new LISPExpression("`((3 a) (4 b) (5 c) 2)");
    }


    @Test
    public void testGetElements() throws Exception {
        List<LISPElement> elements = anExpression.getElements();
        assertEquals(elements.size(), 4);
        for (int i = 0; i < 3; i++) {
            assertTrue(elements.get(i).getClass().equals(LISPList.class));
        }
        assertTrue(elements.get(3).getClass().equals(LISPAtom.class));
        assertEquals(Integer.valueOf(elements.get(3).getValue()).intValue(), 2);
    }

    @Test
    public void testSimpleAtoms() {
        anExpression = new LISPExpression("`(A B C)");
        List<LISPElement> elements = anExpression.getElements();
        assertEquals(elements.size(), 3);
        for (LISPElement element : elements) {
            assertTrue(element.getClass().equals(LISPAtom.class));
        }

    }

    @Test
    public void testGetNextElement() {

        String expression = "a (3 a) b (2 c) (4 d) 2";
        anExpression = new LISPExpression(expression);

        LISPList firstList = new LISPList("3 a");

        LISPElement anElement = anExpression.getNextElement();
        assertTrue(anElement.getClass().equals(LISPAtom.class));
        anElement = anExpression.getNextElement();
        assertTrue(anElement.getClass().equals(LISPList.class));

    }

    @Test
    public void testListSingletonCombinations() {

        String inputExpression = "`((3 a) b (2 c) (4 d) 2 34)";

        anExpression = new LISPExpression(inputExpression);

        List<LISPElement> elements = anExpression.getElements();
        assertEquals(anExpression.toString(), inputExpression);
        assertEquals(elements.size(), 6);
    }
}