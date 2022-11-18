package queue;

import list.linkedlist.Node;

/**
 * @author : 조재철
 * @since 1.0
 */
public class LinkedQueue<E> implements QueueInterface<E> {

    private Node<E> tail;

    private final E ERROR = null;

    public LinkedQueue() {
        this.tail = null;
    }

    @Override
    public void enqueue(E newItem) {
        Node<E> newNode = new Node<>(newItem);

        if (isEmpty()) {
                                                                        newNode.setNext(newNode);

            return;
        }

        newNode.setNext(this.tail.getNext());
        this.tail.setNext(newNode);
        tail = newNode;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return ERROR;
        }

        Node<E> front = this.tail.getNext();

        if (front == this.tail) {
            this.tail = null;
        } else {
            this.tail.setNext(front.getNext());
        }

        return front.getItem();
    }

    @Override
    public E front() {
        if (isEmpty()) {
            return ERROR;
        }

        return this.tail.getNext().getItem();
    }

    @Override
    public boolean isEmpty() {
        return (this.tail == null);
    }

    @Override
    public void dequeueAll() {
        this.tail = null;
    }
}
