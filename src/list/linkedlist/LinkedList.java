package list.linkedlist;

import list.arraylist.ListInterface;

/**
 * @author : 조재철
 * @since 1.0
 */
public class LinkedList<E> implements ListInterface<E> {

    private Node<E> head;
    private int numItems;
    private final int NOT_FOUND = -12345;

    public LinkedList() {
        this.numItems = 0;
        head = new Node<>(null, null);
    }

    public Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            Node<E> currNode = head;

            for (int i = 0; i <= index; ++i) {
                currNode = currNode.getNext();
            }

            return currNode;
        }

        return null;
    }

    @Override
    public void add(int index, E item) {
        if (index >= 0 && index <= numItems) {
            Node<E> preNode = getNode(index - 1);
            Node<E> newNode = new Node<>(item, preNode.getNext());

            preNode.setNext(newNode);

            ++numItems;
        }
    }

    @Override
    public void append(E item) {
        Node<E> preNode = this.head;

        while (preNode.getNext() != null) {
            preNode = preNode.getNext();
        }

        Node<E> newNode = new Node<>(item, null);

        preNode.setNext(newNode);

        ++numItems;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < numItems) {
            Node<E> preNode = getNode(index - 1);
            Node<E> currNode = preNode.getNext();

            preNode.setNext(currNode.getNext());

            --numItems;

            return currNode.getItem();
        }

        return null;
    }

    @Override
    public boolean removeItem(E item) {
        Node<E> preNode;
        Node<E> currNode = head;

        for (int i = 0; i < numItems; ++i) {
            preNode = currNode;
            currNode = currNode.getNext();

            if (((Comparable)(currNode.getItem())).compareTo(item) == 0) {
                preNode.setNext(currNode.getNext());

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
    public void set(int index, E item) {
        if (index >= 0 && index <= numItems - 1) {
            getNode(index).setItem(item);
        } else {
            // 에러 처리
        }
    }

    @Override
    public int indexOf(E item) {
        Node<E> currNode = head;

        int i;

        for (i = 0; i < numItems; ++i) {
            currNode = currNode.getNext();

            if (((Comparable)(currNode.getItem())).compareTo(item) == 0) {
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
        head = new Node<>(null, null);
    }
}
