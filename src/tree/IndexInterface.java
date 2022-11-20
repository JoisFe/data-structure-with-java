package tree;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface IndexInterface<T> {
    public T search(Comparable x);
    public void insert(Comparable x);
    public void delete(Comparable x);
    public boolean isEmpty();
    public void clear();
}
