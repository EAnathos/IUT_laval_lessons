package file;

public interface File {
    boolean isEmpty() throws TestException;

    int length();

    Object peak();

    void push(Object elem);

    Object pop();
}
