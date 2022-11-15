package pile;

public class PileParTableau implements Pile {

    private int sommet;
    private int TAILLEMAX;
    Object myPile[] = new Object[TAILLEMAX];

    @Override
    public boolean pileVide() {
        if(this.sommet > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean pilePleine() {
        if(this.sommet == this.TAILLEMAX) {
            return true;
        }
        return false;
    }

    @Override
    public int longueur() {
        return sommet+1;
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
            sommet--;
            return this.myPile[sommet+1];
        }
    }
}
