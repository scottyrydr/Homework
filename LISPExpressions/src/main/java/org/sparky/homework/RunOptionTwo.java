package org.sparky.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sparky on 2/21/15.
 */
public class RunOptionTwo {
    /**
     * Count consecutive duplicates
     */
    public static LISPExpression execute(LISPExpression lispExpression) throws Exception {
        List<LISPElement> elementList = lispExpression.getElements();
        List<LISPElement> countElementList = new ArrayList<>(elementList.size());

        /* Prepare by looking at first element in the elementList */
        LISPElement firstElement = elementList.remove(0);
        String previousElementValue = firstElement.getValue();
        int elementCount = 1;

        for (LISPElement anElement : elementList) {
            if (anElement.getClass().equals(LISPAtom.class)) {
                if (anElement.getValue().equals(previousElementValue)) {
                    elementCount++;
                }
                else {
                    countElementList.add(new LISPList(elementCount + " " + previousElementValue));
                    previousElementValue = anElement.getValue();
                    elementCount = 1;
                }

            }
            else {
                throw new Exception("Can only include LISPAtom in the Expression.");
            }
        }
        countElementList.add(new LISPList(elementCount + " " + previousElementValue));

        LISPExpression countedExpression = new LISPExpression(countElementList);

        System.out.println(countedExpression.toString());

        return countedExpression;
    }
}
