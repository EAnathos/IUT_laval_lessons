package pile;

public class PileParTableau implements Pile {
    private int peak = -1;
    private final int MAXLENGTH;
    public final Object[] myPile;

    public PileParTableau(int MAXLENGTH) {
        this.MAXLENGTH = MAXLENGTH;
        this.myPile = new Object[MAXLENGTH];
    }

    @Override
    public boolean isEmpty() throws TestException {
        if(peak != -1) return false;
        throw new TestException("The pile is empty");
    }

    @Override
    public boolean isFull() throws TestException {
        if (this.peak != this.MAXLENGTH - 1) return false;
        throw new TestException("The pile is full");
    }


    @Override
    public int length() { return this.peak +1; }

    @Override
    public Object peak() { return this.myPile[peak]; }

    @Override
    public void push(Object elem) {
        try {
            if (!this.isFull()) this.myPile[++peak] = elem;
        } catch (TestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object pop() {
        try {
            if (!this.isEmpty()) {
                this.peak--;
                return this.myPile[peak + 1];
            }
        } catch (TestException e) {
            e.printStackTrace();
        }
        return null;
    }
}