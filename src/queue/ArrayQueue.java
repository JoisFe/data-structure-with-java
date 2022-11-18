package queue;

/**
 * @author : 조재철
 * @since 1.0
 */
public class ArrayQueue<E> implements QueueInterface<E> {

    private E queue[];
    private int front, tail, numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public ArrayQueue() {
        this.queue = (E[]) new Object[DEFAULT_CAPACITY];
        this.front = 0;
        this.tail = DEFAULT_CAPACITY - 1;
        this.numItems = 0;
    }

    @Override
    public void enqueue(E newItem) {
        if (isFull()) {
            System.out.println("Queue Full");

            return;
        }

        this.tail = (tail + 1) % this.queue.length;
        this.queue[tail] = newItem;
        ++this.numItems;
    }

    public boolean isFull() {
        return (this.numItems == this.queue.length);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return ERROR;
        }

        E queueFront = this.queue[front];
        this.front = (front + 1) % this.queue.length;
        --this.numItems;

        return queueFront;
    }

    @Override
    public E front() {
        if (isEmpty()) {
            return ERROR;
        }

        return this.queue[front];
    }

    @Override
    public boolean isEmpty() {
        return (this.numItems == 0);
    }

    @Override
    public void dequeueAll() {
        this.queue = (E[]) new Object[queue.length];

        this.front = 0;
        this.tail = queue.length - 1;
        this.numItems = 0;
    }
}
