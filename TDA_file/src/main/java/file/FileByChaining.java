package file;

public class FileByChaining implements File {
    private Node first;
    private Node last;
    private int length;

    public FileByChaining() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    @Override
    public boolean isEmpty() throws TestException {
        if (this.first == null) return true;
        throw new TestException("The file is not empty");
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public Object peak() {
        return this.first.getValue();
    }

    @Override
    public void push(Object elem) {
        try {
            Node newNode = new Node(elem, null);
            if (this.isEmpty()) {
                this.first = newNode;
            } else {
                this.last.setNext(newNode);
            }
            this.last = newNode;
            this.length++;
        } catch (TestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object pop() {
        try {
            if (!this.isEmpty()) {
                Object value = this.first.getValue();
                this.first = this.first.getNext();
                this.length--;
                return value;
            }
        } catch (TestException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
