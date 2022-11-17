package stack;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface StackInterface<E> {

    void push(E newItem);
    E pop();
    E top();
    boolean isEmpty();
    void popAll();
}
