package tree.avl;

import tree.IndexInterface;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        IndexInterface avl = new AVLTree();

        System.out.println("isEmpty(): " + avl.isEmpty());

        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.delete(20);
        System.out.println(avl.search(20));

    }

}
