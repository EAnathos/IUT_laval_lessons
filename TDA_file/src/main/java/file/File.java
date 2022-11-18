package file;

public interface File {
    boolean isEmpty();

    int length();

    String showFile();

    Object peak();

    void push(Object elem);

    Object pop();
}
