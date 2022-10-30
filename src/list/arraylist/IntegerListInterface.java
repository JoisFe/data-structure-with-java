package list.arraylist;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface IntegerListInterface {
    public void add(int index, Integer x);
    public void append(Integer x);
    public Integer remove(int index);
    public boolean removeItem(Integer x);
    public Integer get(int index);
    public void set(int index, Integer x);
    public int indexOf(Integer x);
    public int len();
    public boolean isEmpty();
    public void clear();
}
