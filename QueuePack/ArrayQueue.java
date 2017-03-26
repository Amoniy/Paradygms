package Paradygms.QueuePack;

public class ArrayQueue{


    //Inv: for each i [0..array.length-1] array[i]!=null and size>=0
    private int size = 0;
    private Object[] array = new Object[5];
    private int head = 0;
    //private int tail = -1;

    // pre: object ≠ null
    // post: size = size' + 1 ∧ array[(head+size)%array.length] = element
    public void enqueue(Object object) {
        assert object != null;
        ensure(size + 1);
        array[(size + head) % array.length] = object;//
        //tail = (tail + 1) % array.length;
        size++;
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
        Object[] newArray = toArray();
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


    // post: R = newArray:
    //      if((head+size-1)%array.length>=head): для i=0..size-1 newArray[i]=array[head+i]
    //      else: для i=0..array.length-1 newArray[i]=array[head+i] для j=0..size-array.length+head-1 newArray[size-1+j]=array[j]
    // ∧ size=size'
    public Object[] toArray() {
        Object[] newArray = new Object[size];
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
    public Object element() {
        assert (size > 0);
        return array[head];
    }

    // pre: size > 0
    // post: ℝ = array[head] ∧ size = size' − 1 ∧ head = (head' + 1)%array.length
    public Object dequeue() {
        assert (size > 0);
        int marker = head;
        head = (head + 1) % array.length;
        size--;
        return array[marker];
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
    public void clear() {
        size = 0;
        head = 0;
        array = new Object[array.length];
        //tail = -1;
    }

    public static void main(String[] args) {
        /*Paradygms.AbstractQueuePack.ArrayQueue a = new Paradygms.AbstractQueuePack.ArrayQueue();
        a.enqueue(1);
        System.out.println(a.element());
        System.out.println(a.dequeue());
        a.clear();
        System.out.println(a.isEmpty());
        System.out.println(a.size());
        System.out.println("\n");

        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);
        System.out.println(a.isEmpty());
        System.out.println(a.size());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        a.clear();
        System.out.println(a.dequeue());*/

    }
}
