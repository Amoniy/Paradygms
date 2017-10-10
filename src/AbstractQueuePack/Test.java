package AbstractQueuePack;

import QueuePack.ArrayQueue;
import QueuePack.ArrayQueueADT;
import QueuePack.ArrayQueueModule;

public class Test {
    public static void main(String[] args) {
        QueuePack.ArrayQueueModule a = new QueuePack.ArrayQueueModule();
        QueuePack.ArrayQueueModule b = new ArrayQueueModule();
        a.enqueue(1);

        QueuePack.ArrayQueueADT c = new QueuePack.ArrayQueueADT();
        QueuePack.ArrayQueueADT d = new ArrayQueueADT();
        c.enqueue(c, 1);
        d.enqueue(d, 2);

        QueuePack.ArrayQueue e = new QueuePack.ArrayQueue();
        QueuePack.ArrayQueue f = new ArrayQueue();
        e.enqueue(1);

        c.clear(d);
        System.out.println(c.dequeue(c));

        System.out.println(d.dequeue(d));

        f.enqueue(1);
        f.enqueue(3);
        System.out.println(f.toStr());
    }
}
