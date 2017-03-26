package Paradygms.AbstractQueuePack;

import java.util.function.Predicate;

public class ArrayQueue extends AbstractQueue implements Queue {
    //Inv: for each i [0..array.length-1] array[i]!=null and size>=0
    private Object[] array = new Object[5];
    private int head = 0;
    //private int tail = -1;

    // pre: object ≠ null
    // post: size = size' + 1 ∧ array[(head+size)%array.length] = element
    protected void enqueueImpl(Object object) {
        ensure(size + 1);
        array[(size + head) % array.length] = object;//
        //tail = (tail + 1) % array.length;
        //size++;
        //array[tail] = object;
    }

    // post:
    //if(size=array.length)
    //      size=size' ∧ array.length=2*(array'.length+1)
    //      ∧
    //      if((head+size-1)%array'.length>=head): для i=0..size-1 array[i]=array'[head+i]
    //      else: для i=0..array'.length-1 array[i]=array'[head+i] для j=0..size-array'.length+head-1 array[size-1+j]=array'[j]
    //
    //else
    //      size=size' for each i[0...array.length-1] array[i]=array'[i]
    private void ensure(int size) {
        if (size > array.length) {
            Object[] newArray = new Object[2 * size];
            newArray = copy(newArray);
            array = newArray;
            head = 0;
            //tail = size - 2;
        }
    }

    //post: R='['+array[0]+', '+...+', '+array[arrat.length-1]+']'    size=size' for each i[0...array.length-1] array[i]=array'[i]
    public String toStr() {
        StringBuilder builder = new StringBuilder();
        Object[] newArray = new Object[size];
        newArray = toArrayImpl(newArray);
        builder.append('[');
        for (int i = 0; i < newArray.length - 1; i++) {
            builder.append(newArray[i].toString());
            builder.append(',');
            builder.append(' ');
        }
        if (newArray.length > 0) {
            builder.append(newArray[newArray.length - 1]);
        }
        builder.append(']');
        return builder.toString();
    }

    protected void remove() {
        head = (head + 1) % array.length;
    }

    protected ArrayQueue filterImpl(Predicate<Object> predicate) {
        ArrayQueue queue = new ArrayQueue();
        int anotherHead = head;
        for (int i = 0; i < size; i++) {
            if (predicate.test(array[anotherHead])) {
                queue.enqueue(array[anotherHead]);
            }
            anotherHead = (anotherHead + 1) % array.length;
        }
        return queue;
    }

    protected ArrayQueue mapImpl(java.util.function.Function<Object, Object> func) {
        ArrayQueue queue = new ArrayQueue();
        int anotherHead = head;
        for (int i = 0; i < size; i++) {
            queue.enqueue(func.apply(array[anotherHead]));
            anotherHead = (anotherHead + 1) % array.length;
        }
        return queue;
    }


    // post: R = newArray:
    //      if((head+size-1)%array.length>=head): для i=0..size-1 newArray[i]=array[head+i]
    //      else: для i=0..array.length-1 newArray[i]=array[head+i] для j=0..size-array.length+head-1 newArray[size-1+j]=array[j]
    // ∧ size=size'
    public Object[] toArrayImpl(Object[] newArray) {
        if (size == 0) return newArray;
        newArray = copy(newArray);
        return newArray;
    }

    //post: R = newArray:
    //      if((head+size-1)%array.length>=head): для i=0..size-1 newArray[i]=array[head+i]
    //      else: для i=0..array.length-1 newArray[i]=array[head+i] для j=0..size-array.length+head-1 newArray[size-1+j]=array[j]
    // ∧ size=size'
    private Object[] copy(Object[] newArray) {
        if ((head + size - 1) % array.length >= head) {
            System.arraycopy(array, head, newArray, 0, size);
        } else {
            System.arraycopy(array, head, newArray, 0, array.length - head);
            System.arraycopy(array, 0, newArray, array.length - head, size - array.length + head);
        }
        return newArray;
    }

    // pre: size > 0
    // post: ℝ = array[head] ∧ size = size'
    protected Object elementImpl() {
        return array[head];
    }

    // pre: size > 0
    // post: ℝ = array[head] ∧ size = size' − 1 ∧ head = (head' + 1)%array.length
    protected Object dequeueImpl() {
        int marker = head;
        head = (head + 1) % array.length;
        return array[marker];
    }


    // post: ℝ = size ∧ size = size'
    //public int size() {
    //    return size;
    //}

    // post: ℝ = ((true if size=0)||(false if size!=0)) ∧ size = size'
    //public boolean isEmpty() {
    //    return size == 0;
    //}

    // post: size=0 head=0
    protected void clearImpl() {
        head = 0;
        array = new Object[array.length];
        //tail = -1;
    }
}
