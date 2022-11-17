package list.arraylist;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface ListInterface<E> {

    void add(int index, E x);

    void append(E x);

    E remove(int index);

    boolean removeItem(E x);

    E get(int index);

    void set(int index, E x);

    int indexOf(E x);

    int len();

    boolean isEmpty();

    void clear();
}
