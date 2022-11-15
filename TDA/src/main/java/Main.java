import java.util.Scanner;
import pile.PileParTableau;

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        //PileParTableau pile1 = new PileParTableau(5);

        Scanner scan = new Scanner(System.in);
        System.out.println("Combien de valeur voulez vous dans votre tableau ?");

        int tabLength = scan.nextInt();

        char[] tab = new char[tabLength];

        int pileLength = 0;

        for (int i=0; i<tabLength; i++) {
            System.out.println("Entrez votre valeur dans le tableau, celà doit être un opérateur ou un chiffre");
            tab[i] = scan.next().charAt(0);
            if (isInteger(tab[i])) {
                pileLength++;
            }
        }

        System.out.println("Votre pile comporte " + pileLength + " nombres");

        PileParTableau pile2 = new PileParTableau(pileLength);

        for(int i=0; i<pileLength; i++) {
            pile2.stack(tab[i]);
        }

        int currentOp = pileLength;

        while (pile2.length() != 1) {
            int operator2 = Integer.parseInt(String.valueOf(pile2.unstack()));
            int operator1 = Integer.parseInt(String.valueOf(pile2.unstack()));
            char operator = tab[currentOp];
            pile2.stack(Operate(operator1, operator2, operator));
            currentOp++;
        }

        System.out.println("Le résultat est : " + pile2.peak());

        /*
        for (int i=0; i<5;i++) {
            pile1.empiler(i);
            Arrays.stream(pile1.myPile).forEach(o -> System.out.println(o));
        }

        System.out.println("séparation");

        for (int i=0; i<5; i++) {
            System.out.println(pile1.depiler());
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
        switch (op) {
            case '+':
                return elem1 + elem2;
            case '*':
                return elem1 * elem2;
            case '-':
                return elem1 - elem2;
            default:
                return elem1 / elem2;
        }
    }
}
