package tree;

import tree.binarySearchTree.BinarySearchTree;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        IndexInterface bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);

        bst.delete(20);


        System.out.println(bst.search(10));
        System.out.println(bst.search(20));
    }
}
