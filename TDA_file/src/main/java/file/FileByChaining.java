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
    public boolean isEmpty() {
        if (this.first == null) return true;
        return false;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public Object peak() {
        return this.first.getValue();
    }

    public String showFile() {
        StringBuilder result = new StringBuilder();
        Node current = this.first;
        while (current != null) {
            result.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        return result.toString();
    }

    @Override
    public void push(Object elem) {
        Node newNode = new Node(elem, null);
        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }
        this.last = newNode;
        this.length++;
    }

    @Override
    public Object pop() {
        if (!this.isEmpty()) {
            Object value = this.first.getValue();
            this.first = this.first.getNext();
            this.length--;
            return value;
        }
        return null;
    }
}
