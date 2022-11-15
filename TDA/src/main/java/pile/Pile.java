package pile;

public interface Pile {
    boolean isEmpty();

    boolean isFull();

    int length();

    Object peak();

    void stack(Object elem);

    Object unstack();
}
