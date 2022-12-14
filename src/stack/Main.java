package stack;

import list.linkedlist.LinkedList;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        StackInterface<Integer> s = new InheritedStack<>();

        s.push(300);
        s.push(200);
        s.push(100);
        s.pop();

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

}
