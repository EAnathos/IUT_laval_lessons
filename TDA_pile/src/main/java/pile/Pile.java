package pile;

public interface Pile {
    boolean isEmpty() throws TestException;

    boolean isFull()  throws TestException;

    int length();

    Object peak();

    void push(Object elem);

    Object pop();
}
