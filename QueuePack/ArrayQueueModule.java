package Paradygms.QueuePack;

public class ArrayQueueModule {
    private static int size = 0;
    private static Object[] array = new Object[5];
    private static int head = 0;
    //private static int tail = -1;

    public static void enqueue(Object object) {
        assert object != null;
        ensure(size + 1);
        //tail = (tail + 1) % array.length;
        array[(size + head) % array.length] = object;
        size++;

    }

    private static void ensure(int capacity) {
        if (capacity > array.length) {
            Object[] newArray = new Object[2 * capacity];
            newArray = copy(newArray);
            array = newArray;
            head = 0;
            //tail = capacity - 2;
        }
    }

    public static Object[] toArray() {
        Object[] newArray = new Object[size];
        if (size == 0) return newArray;
        newArray = copy(newArray);
        return newArray;
    }

    private static Object[] copy(Object[] newArray) {
        if ((head + size - 1) % array.length >= head) {
            System.arraycopy(array, head, newArray, 0, size);
        } else {
            System.arraycopy(array, head, newArray, 0, array.length - head);
            System.arraycopy(array, 0, newArray, array.length - head, size - array.length + head);
        }
        return newArray;
    }

    public static Object element() {
        assert (size > 0);
        return array[head];
    }

    public static Object dequeue() {
        assert (size > 0);
        int marker = head;
        head = (head + 1) % array.length;
        size--;
        return array[marker];
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        size = 0;
        head = 0;
        array = new Object[array.length];
        //tail = -1;
    }


    public static String toStr() {
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

    public static void main(String[] args) {
        ArrayQueueModule a = new ArrayQueueModule();
        ArrayQueueModule b = new ArrayQueueModule();

        /*a.enqueue(1);
        System.out.println(element());
        System.out.println(dequeue());
        clear();
        System.out.println(isEmpty());
        System.out.println(size());
        System.out.println("\n");

        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);
        enqueue(6);
        System.out.println(isEmpty());
        System.out.println(size());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        clear();
        System.out.println(dequeue());
        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        dequeue();
        dequeue();
        dequeue();
        enqueue(5);
        enqueue(6);
        enqueue(7);
        Object[] b = toArray();
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }*/
    }
}
