package queue;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        QueueInterface<String> s = new InheritedQueue<>();

        s.enqueue("test1");
        s.enqueue("test2");
        s.dequeue();

        while (!s.isEmpty()) {
            System.out.println(s.dequeue());
        }
    }

}
