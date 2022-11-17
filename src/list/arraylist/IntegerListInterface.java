package list.arraylist;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface IntegerListInterface {

    void add(int index, Integer x);

    void append(Integer x);

    Integer remove(int index);

    boolean removeItem(Integer x);

    Integer get(int index);

    void set(int index, Integer x);

    int indexOf(Integer x);

    int len();

    boolean isEmpty();

    void clear();
}
