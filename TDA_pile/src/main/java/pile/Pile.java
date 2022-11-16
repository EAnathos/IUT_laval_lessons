package pile;

public interface Pile {
    boolean isEmpty() throws TestException;

    boolean isFull()  throws TestException;

    int length();

    Object peak();

    void stack(Object elem);

    Object unstack();
}
