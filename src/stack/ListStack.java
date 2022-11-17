package stack;

import list.arraylist.ListInterface;
import list.linkedlist.LinkedList;

/**
 * @author : 조재철
 * @since 1.0
 */
public class ListStack<E> implements StackInterface<E> {

    private ListInterface<E> list;

    public ListStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public void push(E newItem) {
        this.list.add(0, newItem);
    }

    @Override
    public E pop() {
        return this.list.remove(0);
    }

    @Override
    public E top() {
        return this.list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void popAll() {
        this.list.clear();
    }
}
