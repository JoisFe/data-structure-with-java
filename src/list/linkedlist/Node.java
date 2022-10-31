package list.linkedlist;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Node<E> {

    private E item;
    private Node<E> next;

    public Node(E newItem) {
        this.item = newItem;
        next = null;
    }

    public Node(E newItem, Node<E> nextNode) {
        this.item = newItem;
        this.next = nextNode;
    }

    public E getItem() {
        return item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
