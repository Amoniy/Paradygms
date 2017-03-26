package Paradygms.AbstractQueuePack;

import java.util.function.Predicate;

public class LinkedQueue extends AbstractQueue implements Queue {
    //Inv: for each i [0..array.length-1] array[i]!=null and size>=0
    private Node head;
    private Node tail;

    protected Object[] toArrayImpl(Object[] array) {
        Node pointer = head;
        for (int i = 0; i < size; i++) {
            array[i] = pointer.value;
            pointer = pointer.next;
        }
        return array;
    }

    // pre: object ≠ null
    // post: size = size' + 1 ∧ array[(head+size)%array.length] = element
    protected void enqueueImpl(Object object) {
        if (size > 0) {
            //tail.next = new Paradygms.AbstractQueuePack.Node(object, tail, null);
            tail.next = new Node(object, null);
            tail = tail.next;
        }
        if (size == 0) {
            //tail = new Paradygms.AbstractQueuePack.Node(object, null, null);
            tail = new Node(object, null);
            head = tail;
        }
    }

    protected LinkedQueue filterImpl(Predicate<Object> predicate) {
        LinkedQueue queue = new LinkedQueue();
        Node anotherHead = head;
        for (int i = 0; i < size; i++) {
            if (predicate.test(anotherHead.value)) {
                queue.enqueue(anotherHead.value);
            }
            anotherHead = anotherHead.next;
        }

        return queue;
    }

    protected LinkedQueue mapImpl(java.util.function.Function<Object, Object> func) {
        LinkedQueue queue = new LinkedQueue();
        Node anotherHead = head;
        for (int i = 0; i < size; i++) {
            queue.enqueue(func.apply(anotherHead.value));
            anotherHead = anotherHead.next;
        }

        return queue;
    }

    // pre: size > 0
    // post: ℝ = array[head] ∧ size = size'
    protected Object elementImpl() {
        return head.value;
    }

    // pre: size > 0
    // post: ℝ = array[head] ∧ size = size' − 1 ∧ head = (head' + 1)%array.length
    protected Object dequeueImpl() {
        Object ret = head.value;
        head = head.next;
        //if (size > 1) {
        //    head.prev = null;
        //}
        return ret;
    }

    protected void remove() {
        head = head.next;
    }

    // post: ℝ = size ∧ size = size'
    public int size() {
        return size;
    }

    // post: ℝ = ((true if size=0)||(false if size!=0)) ∧ size = size'
    public boolean isEmpty() {
        return size == 0;
    }

    // post: size=0 head=0
    protected void clearImpl() {
        head = null;
        tail = null;
    }
}
