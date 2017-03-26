package Paradygms.AbstractQueuePack;

import Paradygms.QueuePack.ArrayQueue;
import Paradygms.QueuePack.ArrayQueueADT;
import Paradygms.QueuePack.ArrayQueueModule;

public class Test {
    public static void main(String[] args) {
        Paradygms.QueuePack.ArrayQueueModule a = new Paradygms.QueuePack.ArrayQueueModule();
        Paradygms.QueuePack.ArrayQueueModule b = new ArrayQueueModule();
        a.enqueue(1);

        Paradygms.QueuePack.ArrayQueueADT c = new Paradygms.QueuePack.ArrayQueueADT();
        Paradygms.QueuePack.ArrayQueueADT d = new ArrayQueueADT();
        c.enqueue(c,1);
        d.enqueue(d,2);

        Paradygms.QueuePack.ArrayQueue e = new Paradygms.QueuePack.ArrayQueue();
        Paradygms.QueuePack.ArrayQueue f = new ArrayQueue();
        e.enqueue(1);

        c.clear(d);
        System.out.println(c.dequeue(c));

        System.out.println(d.dequeue(d));


        f.enqueue(1);
        f.enqueue(3);
        System.out.println(f.toStr());
    }
}
