package pile;

public class PileParTableau implements Pile {
    private int peak = -1;
    private int MAXLENGTH;
    public Object[] myPile = new Object[MAXLENGTH];

    public PileParTableau(int MAXLENGTH) {
        this.MAXLENGTH = MAXLENGTH;
    }

    @Override
    public boolean isEmpty() {
        return (this.peak == -1);
    }

    @Override
    public boolean isFull() {
        return (this.peak == this.MAXLENGTH - 1);
    }

    @Override
    public int length() {
        return this.peak +1;
    }

    @Override
    public Object peak() {
        return this.myPile[peak];
    }

    @Override
    public void stack(Object elem) {
        if (!this.isFull()) {
            this.peak++;
            this.myPile[peak] = elem;
        }
    }

    @Override
    public Object unstack() {
        if (!this.isEmpty()) {
            this.peak--;
            return this.myPile[peak + 1];
        }
        return false;
    }
}