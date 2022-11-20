package tree;

/**
 * @author : 조재철
 * @since 1.0
 */
public class TreeNode {

    private Comparable key;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Comparable key) {
        this.key = key;

        this.left = this.right = null;
    }

    public TreeNode(Comparable key, TreeNode left, TreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public Comparable getKey() {
        return key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
