package stack;

import list.linkedlist.LinkedList;

/**
 * @author : 조재철
 * @since 1.0
 */
public class InheritedStack<E> extends LinkedList<E> implements StackInterface<E> {

    public InheritedStack() {
        super();
    }

    @Override
    public void push(E newItem) {
        super.add(0, newItem);
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return super.remove(0);
        }

        return null;
    }

    @Override
    public E top() {
        return super.get(0);
    }

    @Override
    public void popAll() {
        super.clear();
    }
}
