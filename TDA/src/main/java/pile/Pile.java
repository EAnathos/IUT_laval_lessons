package pile;

public interface Pile {
    boolean pileVide();

    boolean pilePleine();

    int longueur();

    Object sommet();

    void empiler();

    Object depiler();
}
