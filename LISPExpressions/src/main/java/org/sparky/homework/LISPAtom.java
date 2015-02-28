package org.sparky.homework;

/**
 * Created by sparky on 2/21/15.
 */
public class LISPAtom implements LISPElement {

    String value;

    public LISPAtom(String expression) {
        this.value = expression;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String getValue() {
        return this.value;
    }
}
