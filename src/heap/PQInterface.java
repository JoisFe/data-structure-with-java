package heap;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface PQInterface<E> {

    void insert(E newItem) throws Exception;

    E deleteMax() throws Exception;

    E max() throws Exception;

    boolean isEmpty();

    void clear();
}
