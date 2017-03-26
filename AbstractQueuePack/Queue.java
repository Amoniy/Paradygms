package Paradygms.AbstractQueuePack;

import java.util.function.Predicate;

public interface Queue {
    // array- последовательность элементов, представляющая нашу очередь

    // pre: size > 0
    // post: ℝ = array[0] ∧ size = size' − 1
    Object dequeue();

    // post: R = newArray:
    //      для i=0..size-1 newArray[i]=array[i]
    // ∧ size=size'
    Object[] toArray();

    // pre: object ≠ null
    // post: size = size' + 1 ∧ array[0] = element
    void enqueue(Object element);

    // pre: size > 0
    // post: ℝ = array[0] ∧ size = size'
    Object element();

    // post: ℝ = size ∧ size = size'
    int size();

    // post: ℝ = ((true if size=0)||(false if size!=0)) ∧ size = size'
    boolean isEmpty();

    // post: size=0 head=0
    void clear();

    AbstractQueue filter(Predicate<Object> predicate);

    AbstractQueue map(java.util.function.Function<Object, Object> func);
}
