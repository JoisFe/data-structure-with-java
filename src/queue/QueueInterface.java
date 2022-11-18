package queue;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface QueueInterface<E> {

    void enqueue(E x);
    E dequeue();
    E front();
    boolean isEmpty();
    void dequeueAll();
}
