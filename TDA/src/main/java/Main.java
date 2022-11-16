import java.util.Scanner;

import pile.PileParTableau;

public class Main{
    public static void main(String[] args) {
        //PileParTableau pile1 = new PileParTableau(5);

        Scanner scan = new Scanner(System.in);

        System.out.println("How many values do you want in your array ?");
        int tabLength = scan.nextInt();

        char[] tab = new char[tabLength];

        int pileLength = 0;

        for (int i=0; i<tabLength; i++) {
            System.out.println("Enter your value in the array, it must be an operator or a number");
            tab[i] = scan.next().charAt(0);
            if (isInteger(tab[i])) {
                pileLength++;
            }
        }

        System.out.println("Your stack has " + pileLength + " numbers");

        PileParTableau pile2 = new PileParTableau(pileLength);

        for(int i=0; i<pileLength; i++) {
            pile2.stack(tab[i]);
        }

        int currentOp = pileLength;

        while (pile2.length() != 1) {

            int operator2 = getNumber(pile2.unstack());
            int operator1 = getNumber(pile2.unstack());

            char operator = tab[currentOp];

            pile2.stack(Operate(operator1, operator2, operator));
            currentOp++;
        }

        System.out.println("The result is : " + pile2.peak());

        //Verify if there is still a value in the pile.
        pile2.unstack();

        /* Test Phase
        for (int i=0; i<5;i++) {
            pile1.stack(i);
            Arrays.stream(pile1.myPile).forEach(o -> System.out.println(o));
        }

        System.out.println("separation");

        for (int i=0; i<5; i++) {
            System.out.println(pile1.unstack());
        }
         */
    }

    private static boolean isInteger(final char elem) {
        try {
            Integer.parseInt(String.valueOf(elem));
            return true;
        } catch (final NumberFormatException exception) {
            return false;
        }
    }

    private static int Operate(int elem1, int elem2, char op) {
        return switch (op) {
            case '+':
                yield elem1 + elem2;
            case '*':
                yield elem1 * elem2;
            case '-':
                yield elem1 - elem2;
            case '/':
                yield elem1 / elem2;
            default:
                throw new IllegalArgumentException("Unexpected operator");
        };
    }

    private static int getNumber(Object elem1) {
        return Integer.parseInt(String.valueOf(elem1));
    }
}
