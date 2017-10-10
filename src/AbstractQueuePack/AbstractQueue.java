package AbstractQueuePack;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractQueue implements Queue {
    protected int size = 0;

    public Object[] toArray() {
        Object[] array = new Object[size];
        array = toArrayImpl(array);
        return array;
    }

    public AbstractQueue filter(Predicate<Object> predicate) {
        return filterImpl(predicate);
    }

    public AbstractQueue map(java.util.function.Function<Object, Object> func) {
        return mapImpl(func);
    }

    protected abstract AbstractQueue mapImpl(Function<Object, Object> func);

    protected abstract AbstractQueue filterImpl(Predicate<Object> predicate);

    protected abstract Object[] toArrayImpl(Object[] array);

    public Object dequeue() {
        assert (size > 0);
        Object ans = element();
        remove();
        size--;
        return ans;
        //return dequeueImpl();
    }

    protected abstract void remove();

    //protected abstract Object dequeueImpl();

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        clearImpl();
    }

    protected abstract void clearImpl();

    public Object element() {
        assert (size > 0);
        return elementImpl();
    }

    protected abstract Object elementImpl();


    public void enqueue(Object element) {
        assert (element != null);
        enqueueImpl(element);
        size++;
    }

    protected abstract void enqueueImpl(Object element);
}
