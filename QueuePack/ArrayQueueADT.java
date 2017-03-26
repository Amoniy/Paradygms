package Paradygms.QueuePack;

public class ArrayQueueADT {
    private int size = 0;
    private Object[] array = new Object[5];
    private int head = 0;
    //private int tail = -1;

    public static void enqueue(ArrayQueueADT queue, Object object) {
        assert object != null;
        ensure(queue, queue.size + 1);
        //queue.tail = (queue.tail + 1) % queue.array.length;
        queue.array[(queue.size + queue.head) % queue.array.length] = object;
        queue.size++;
    }

    private static void ensure(ArrayQueueADT queue, int size) {
        if (size > queue.array.length) {
            Object[] newArray = new Object[2 * size];
            newArray = copy(queue, newArray);
            queue.array = newArray;
            queue.head = 0;
            //queue.tail = size - 2;
        }
    }

    private static Object[] copy(ArrayQueueADT queue, Object[] newArray) {
        if ((queue.head + queue.size - 1) % queue.array.length >= queue.head) {
            System.arraycopy(queue.array, queue.head, newArray, 0, queue.size);
        } else {
            System.arraycopy(queue.array, queue.head, newArray, 0, queue.array.length - queue.head);
            System.arraycopy(queue.array, 0, newArray, queue.array.length - queue.head, queue.size - queue.array.length + queue.head);
        }
        return newArray;
    }

    public static Object[] toArray(ArrayQueueADT queue) {
        Object[] newArray = new Object[queue.size];
        if (queue.size == 0) return newArray;
        newArray = copy(queue, newArray);
        return newArray;
    }

    public static Object element(ArrayQueueADT queue) {
        assert (queue.size > 0);
        return queue.array[queue.head];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        assert (queue.size > 0);
        int marker = queue.head;
        queue.head = (queue.head + 1) % queue.array.length;
        queue.size--;
        return queue.array[marker];
    }

    public static String toStr(ArrayQueueADT queue) {
        StringBuilder builder = new StringBuilder();
        Object[] newArray = toArray(queue);
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

    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.size = 0;
        queue.head = 0;
        queue.array = new Object[queue.array.length];
        //queue.tail = -1;
    }

    /*public static void main(String[] args) {
        Paradygms.QueuePack.Paradygms.AbstractQueuePack.ArrayQueueADT a = new Paradygms.QueuePack.Paradygms.AbstractQueuePack.ArrayQueueADT();
        enqueue(a, 1);
        System.out.println(element(a));
        System.out.println(dequeue(a));
        System.out.println(isEmpty(a));
        System.out.println(size(a));
        clear(a);
        System.out.println(isEmpty(a));
        System.out.println(size(a));
        System.out.println("\n");

        enqueue(a, 1);
        enqueue(a, 2);
        enqueue(a, 3);
        enqueue(a, 4);
        enqueue(a, 5);
        enqueue(a, 6);
        System.out.println(isEmpty(a));
        System.out.println(size(a));
        System.out.println(dequeue(a));
        System.out.println(dequeue(a));
        System.out.println(dequeue(a));
        System.out.println(dequeue(a));
        System.out.println(dequeue(a));
        System.out.println(dequeue(a));
        clear(a);
        System.out.println(dequeue(a));

    }*/
}
