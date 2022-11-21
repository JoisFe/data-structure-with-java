package tree.avl;

/**
 * @author : 조재철
 * @since 1.0
 */
public class AVLNode {

    private Comparable item;
    private AVLNode left;
    private AVLNode right;
    private int height;

    public AVLNode(Comparable newItem) {
        this.item = newItem;
        this.left = this.right = AVLTree.NIL;
        this.height = 1;
    }

    public AVLNode(Comparable item, AVLNode left, AVLNode right) {
        this.item = item;
        this.left = left;
        this.right = right;
        this.height = 1;
    }

    public AVLNode(Comparable item, AVLNode left, AVLNode right, int height) {
        this.item = item;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    public Comparable getItem() {
        return item;
    }

    public AVLNode getLeft() {
        return left;
    }

    public AVLNode getRight() {
        return right;
    }

    public int getHeight() {
        return height;
    }

    public void setItem(Comparable item) {
        this.item = item;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
