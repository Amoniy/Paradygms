package AbstractQueuePack;

public class Node {
    Object value;
    Node next;
    Node prev;

    public Node(Object value, Node prev, Node next) {
        assert value != null;
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    public Node(Object value, Node next) {
        assert value != null;
        //this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
