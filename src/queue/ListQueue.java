package queue;

import list.arraylist.ArrayList;
import list.arraylist.ListInterface;

/**
 * @author : 조재철
 * @since 1.0
 */
public class ListQueue<E> implements QueueInterface<E> {

    private ListInterface<E> list;

    public ListQueue() {
        this.list = new ArrayList<>();
    }

    @Override
    public void enqueue(E newItem) {
        this.list.append(newItem);
    }

    @Override
    public E dequeue() {
        return this.list.remove(0);
    }

    @Override
    public E front() {
        return this.list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void dequeueAll() {
        this.list.clear();
    }
}
