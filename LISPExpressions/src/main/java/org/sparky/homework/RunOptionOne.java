package org.sparky.homework;

import java.util.Collections;
import java.util.List;

/**
 * Created by sparky on 2/21/15.
 */
public class RunOptionOne {

    /**
     * Print list in reverse order
     */
    public static LISPExpression execute(LISPExpression lispExpression) {
        List<LISPElement> elementList = lispExpression.getElements();

        Collections.reverse(elementList);

        LISPExpression reverseExpression = new LISPExpression(elementList);

        System.out.println(reverseExpression.toString());

        return reverseExpression;
    }
}
