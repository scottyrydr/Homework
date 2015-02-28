package org.sparky.homework;

import java.util.StringTokenizer;

/**
 * Created by sparky on 2/21/15.
 */
public class LISPList implements LISPElement {

    private String inputString;
    private Integer numberComponent;
    private String atomString;

    public LISPList(String listString) {
        this.inputString = listString;
        tokenize();
    }

    private void tokenize() {

        StringTokenizer st = new StringTokenizer(inputString, " ", false);
        if (st.countTokens() != 2) {
            throw new IllegalArgumentException("Need to find two tokens in LISPList input string.");
        }
        numberComponent = Integer.valueOf(st.nextToken());
        atomString = st.nextToken();


    }

    public String getValue() {
        return this.toString();
    }

    public String getAtomString() {
        return atomString;
    }

    public Integer getNumberComponent() {
        return numberComponent;
    }

    @Override
    public String toString() {
        return "(" + this.getNumberComponent() + " " + this.getAtomString() + ")";
    }
}
