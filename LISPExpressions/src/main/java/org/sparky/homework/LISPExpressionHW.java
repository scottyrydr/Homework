package org.sparky.homework;

import java.util.List;
import java.util.Scanner;

/**
 * Created by sparky on 2/20/15.
 */
public class LISPExpressionHW {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input expression: ");
        String inputExpression = scanner.nextLine();


        LISPExpression lispExpression = new LISPExpression(inputExpression);
        List<LISPElement> elements = lispExpression.getElements();

        System.out.println("Original input expression:");
        for (LISPElement anElement : elements) {
            System.out.print(anElement.toString());
        }
        System.out.println();

        System.out.println("Running operation number 1:");
        LISPExpression optionOneExpression = RunOptionOne.execute(lispExpression);


    }

}
