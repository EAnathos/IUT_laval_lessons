package pile;

public class PileParTableau implements Pile {
    private int sommet = -1;
    private int TAILLEMAX;
    public Object myPile[] = new Object[TAILLEMAX];

    public PileParTableau(int TAILLEMAX) {
        this.TAILLEMAX = TAILLEMAX;
        this.myPile = new Object[TAILLEMAX];
    }

    @Override
    public boolean pileVide() {
        if(this.sommet >= 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean pilePleine() {
        if(this.sommet == this.TAILLEMAX - 1) {
            return true;
        }
        return false;
    }

    @Override
    public int longueur() {
        return this.sommet+1;
    }

    @Override
    public Object sommet() {
        return this.myPile[sommet];
    }

    @Override
    public void empiler(Object elem) {
        if (!this.pilePleine()) {
            this.sommet++;
            this.myPile[sommet] = elem;
        }
    }

    @Override
    public Object depiler() {
        if (this.pileVide()) {
            return false;
        } else {
            this.sommet--;
            return this.myPile[sommet+1];
        }
    }
}