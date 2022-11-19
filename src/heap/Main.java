package heap;

import heap.exception.PQException;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        PQInterface<Integer> h = new Heap<>(10);

        try {
            h.insert(1);
            h.insert(2);
            h.clear();
            h.insert(3);
            h.insert(4);
            h.insert(5);
            h.insert(6);
            h.deleteMax();
            h.insert(1);
            h.insert(3);
            h.deleteMax();

            while(!h.isEmpty()) {
                System.out.println(h.max());
                h.deleteMax();
            }

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
        }
    }

}
