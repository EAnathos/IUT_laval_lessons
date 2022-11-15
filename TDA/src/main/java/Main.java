import pile.PileParTableau;

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        PileParTableau pile1 = new PileParTableau(5);

        for (int i=0; i<5;i++) {
            pile1.empiler(i);
            Arrays.stream(pile1.myPile).forEach(o -> System.out.println(o));
        }

        System.out.println("séparation");

        for (int i=0; i<5; i++) {
            System.out.println(pile1.depiler());
        }
    }
}
