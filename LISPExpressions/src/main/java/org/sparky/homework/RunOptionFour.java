package org.sparky.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sparky on 2/21/15.
 */
public class RunOptionFour {
    /**
     * Print with every Nth element deleted where N is the last Atom in the Expression
     */
    public static LISPExpression execute(LISPExpression lispExpression) throws Exception {
        List<LISPElement> elementList = lispExpression.getElements();
        List<LISPElement> outputList = new ArrayList<>();

        // What's the value of the last Atom?
        LISPAtom lastAtom = (LISPAtom) elementList.get(elementList.size() - 1);
        int skipValue = Integer.parseInt(lastAtom.getValue());

        // skip every Nth element excluding last Atom
        for (int i = 0; i < elementList.size() - 1; i++) {
            if ((i + 1) % skipValue != 0) {
                outputList.add(elementList.get(i));
            }
        }
        outputList.add(lastAtom);
        LISPExpression outputExpression = new LISPExpression(outputList);
        System.out.println(outputExpression.toString());

        return outputExpression;
    }
}
