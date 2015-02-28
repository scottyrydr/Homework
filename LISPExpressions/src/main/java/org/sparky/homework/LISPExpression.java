package org.sparky.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sparky on 2/21/15.
 */
public class LISPExpression {

    private boolean initialized = false;
    private String inputExpression;
    private List<LISPElement> elementList = new ArrayList<>(10);
    private int leftIndex;
    private int inputExpressionLength;

    public LISPExpression(String inputExpression)
    {
        this.inputExpression = inputExpression;
        this.initialized = false;
    }

    public LISPExpression(List<LISPElement> anElementList)
    {
        this.elementList = anElementList;
        initialized = true;
    }

    public List<LISPElement> getElements()
    {
        if (!initialized) {
            parse();
        }
        return elementList;
    }

    private void parse()
    {

        /* Find matching parens working inward from both ends. */
        leftIndex = 0;
        inputExpressionLength = inputExpression.length();

        /* First, find outermost parens surrounding the entire LISP expression */
        int leftParenIndex = inputExpression.indexOf('(', leftIndex);
        int rightParenIndex = inputExpression.lastIndexOf(')', inputExpressionLength);
        if (leftParenIndex == -1 || rightParenIndex == -1) {
            throw new IllegalArgumentException("Missing at least one outer paren on LISPExpression.");
        }
        String bareExpression = inputExpression.substring(leftParenIndex + 1, rightParenIndex);

        System.out.print("leftParenIndex: " + leftParenIndex + ", rightParenIndex: " + rightParenIndex);
        System.out.println(", " + bareExpression);

        leftIndex = leftParenIndex + 1;

        /* Now left with combination of List and Atom items */
        LISPElement anElement;

        while (leftIndex < inputExpressionLength) {
            anElement = this.getNextElement();
            elementList.add(anElement);
        }

        System.out.println();
        this.initialized = true;
    }

    /**
     * Find the next LISPElement after the current index into this LISPExpression. Called internally during the
     * LISPExpression.parse() method.
     * Determines whether the LISPElement is a LISPList or LISPAtom, constructs an appropriate object, and returns it.
     * Updates the state of LISPExpression so that consequent invocations of getNextElement() returns the next
     * LISPElement.
     *
     * @return Next LISPElement in this LISPExpression.
     */
    protected LISPElement getNextElement()
    {
        LISPElement anElement;

        // Find next non-whitespace character after 'start'
        int elementStartIndex = leftIndex;
        while (inputExpression.charAt(elementStartIndex) == ' ') {
            elementStartIndex++;
        }

        // Is this new LISPElement a LISPList or LISPAtom
        if (inputExpression.charAt(elementStartIndex) == '(') {
            // This is a LISPList, find the end
            int closingParenIndex = inputExpression.indexOf(')', elementStartIndex);
            if (closingParenIndex == -1) {
                // No right paren found, that's an error
                throw new IllegalArgumentException("No right matching paren found.");
            }
            String bareExpression = inputExpression.substring(elementStartIndex + 1, closingParenIndex);
            anElement = new LISPList(bareExpression);
            leftIndex = closingParenIndex + 1;
        }
        else {
            // LISPAtom - it is bounded on right by ' ' or ')'
            int endOfAtomIndex = elementStartIndex + 1;
            while (inputExpression.charAt(endOfAtomIndex) != ' ' && inputExpression.charAt(
                    endOfAtomIndex) != ')' && (endOfAtomIndex < inputExpressionLength)) {
                endOfAtomIndex++;
            }

            anElement = new LISPAtom(inputExpression.substring(elementStartIndex, endOfAtomIndex));
            leftIndex = endOfAtomIndex + 1;
        }

        return anElement;
    }

    @Override
    public String toString()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("`(");

        for (LISPElement element : elementList) {
            sb.append(element.getValue()).append(" ");
        }

        return sb.toString().trim() + ")";
    }
}
