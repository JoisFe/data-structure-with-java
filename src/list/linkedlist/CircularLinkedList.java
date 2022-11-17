package list.linkedlist;

import list.arraylist.ListInterface;

/**
 * @author : 조재철
 * @since 1.0
 */
public class CircularLinkedList<E> implements ListInterface<E> {

    public static int NOT_FOUND = -12345;

    private Node<E> tail;
    private int numItems;

    public CircularLinkedList() {
        this.numItems = 0;
        this.tail = new Node(-1);
        this.tail.setNext(tail);
    }

    @Override
    public void add(int index, E x) {
        if (index >= 0 && index <= this.numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node(x, prevNode.getNext());

            prevNode.setNext(newNode);

            if (index == numItems) {
                tail = newNode;
            }

            ++numItems;
        }
    }

    @Override
    public void append(E x) {
        Node<E> prevNode = this.tail;
        Node<E> newNode = new Node(x, this.tail.getNext());

        prevNode.setNext(newNode);

        this.tail = newNode;

        ++numItems;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < numItems) {
            Node<E> prevNode = getNode(index - 1);

            E rItem = prevNode.getNext().getItem();
            prevNode.setNext(prevNode.getNext().getNext());

            if (index == numItems - 1) {
                this.tail = prevNode;
            }

            --numItems;

            return rItem;
        }
        return null;
    }

    @Override
    public boolean removeItem(E x) {
        Node<E> currNode = tail.getNext();

        Node<E> prevNode;

        for (int i = 0; i < numItems; ++i) {
            prevNode = currNode;
            currNode = currNode.getNext();

            if (((Comparable)(currNode.getItem())).compareTo(x) == 0) {
                prevNode.setNext(currNode.getNext());

                --numItems;

                return true;
            }
        }

        return false;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < numItems) {
            return getNode(index).getItem();
        }

        return null;
    }

    @Override
    public void set(int index, E x) {
        if (index >= 0 && index < numItems) {
            getNode(index).setItem(x);
        } else {
            // 에러 처리
        }
    }

    public Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems) {
            Node<E> currNode = this.tail.getNext();

            for (int i = 0; i <= index; ++i) {
                currNode = currNode.getNext();
            }

            return currNode;
        }

        return null;
    }

    @Override
    public int indexOf(E x) {
        Node<E> currNode = tail.getNext();

        for (int i = 0; i < numItems; ++i) {
            currNode = currNode.getNext();

            if (((Comparable)(currNode.getItem())).compareTo(x) == 0) {
                return i;
            }
        }

        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        tail = new Node(-1);
        tail.setNext(tail);
    }
}
