package stack;

import list.linkedlist.Node;

/**
 * @author : 조재철
 * @since 1.0
 */
public class LinkedStack<E> implements StackInterface<E> {

    private Node<E> topNode;
    private final E ERROR = null;

    public LinkedStack() {
        this.topNode = null;
    }

    @Override
    public void push(E newItem) {
        topNode = new Node<>(newItem, topNode);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return ERROR;
        }

        Node<E> temp = this.topNode;
        this.topNode = topNode.getNext();

        return temp.getItem();
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return ERROR;
        }

        return this.topNode.getItem();
    }

    @Override
    public boolean isEmpty() {
        return (topNode == null);
    }

    @Override
    public void popAll() {
        topNode = null;
    }
}
