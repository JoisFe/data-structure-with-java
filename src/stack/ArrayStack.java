package stack;

/**
 * @author : 조재철
 * @since 1.0
 */
public class ArrayStack<E> implements StackInterface<E> {

    private E[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public ArrayStack() {
        this.stack = (E[]) new Object[DEFAULT_CAPACITY];
        this.topIndex = -1;
    }

    public ArrayStack(int n) {
        this.stack = (E[]) new Object[n];
        this.topIndex = -1;
    }

    @Override
    public void push(E newItem) {
        if (isFull()) {
            // 에러 처리
        } else {
            stack[++topIndex] = newItem;
        }
    }

    public boolean isFull() {
        return (topIndex == stack.length - 1);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return ERROR;
        }

        return stack[topIndex--];
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return ERROR;
        }

        return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return (topIndex < 0);
    }

    @Override
    public void popAll() {
        stack = (E[]) new Object[stack.length];

        topIndex = -1;
    }
}
