package tree.binarySearchTree;

import tree.IndexInterface;
import tree.TreeNode;

/**
 * @author : 조재철
 * @since 1.0
 */
public class BinarySearchTree implements IndexInterface<TreeNode> {

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public TreeNode search(Comparable searchKey) {
        return searchItem(this.root, searchKey);
    }

    public TreeNode searchItem(TreeNode tNode, Comparable searchKey) {
        if (tNode == null) {
            return null;
        } else if (searchKey.compareTo(tNode.getKey()) == 0) {
            return tNode;
        } else if (searchKey.compareTo(tNode.getKey()) < 0) {
            return searchItem(tNode.getLeft(), searchKey);
        }

        return searchItem(tNode.getRight(), searchKey);
    }

    @Override
    public void insert(Comparable newKey) {
        this.root = insertItem(this.root, newKey);
    }

    private TreeNode insertItem(TreeNode tNode, Comparable newItem) {
        if (tNode == null) {
            tNode = new TreeNode(newItem, null, null);
        } else if (newItem.compareTo(tNode.getKey()) < 0) {
            tNode.setLeft(insertItem(tNode.getLeft(), newItem));
        } else {
            tNode.setRight(insertItem(tNode.getRight(), newItem));
        }

        return tNode;
    }

    @Override
    public void delete(Comparable searchKey) {
        this.root = deleteItem(this.root, searchKey);
    }

    private TreeNode deleteItem(TreeNode tNode, Comparable searchKey) {
        if (tNode == null) {
            return null;
        }

        if (searchKey == tNode.getKey()) {
            tNode = deleteNode(tNode);
        } else if (searchKey.compareTo(tNode.getKey()) < 0) {
            tNode.setLeft(deleteItem(tNode.getLeft(), searchKey));
        } else {
            tNode.setRight(deleteItem(tNode.getRight(), searchKey));
        }

        return tNode;
    }

    private TreeNode deleteNode(TreeNode tNode) {
        if ((tNode.getLeft() == null) && (tNode.getRight() == null)) {
            return null;
        } else if (tNode.getLeft() == null) {
            return tNode.getRight();
        } else if (tNode.getRight() == null) {
            return tNode.getLeft();
        }

        ReturnPair rPair = deleteMinItem(tNode.getRight());

        tNode.setKey(rPair.key);
        tNode.setRight(rPair.node);

        return tNode;
    }

    private ReturnPair deleteMinItem(TreeNode tNode) {
        if (tNode.getLeft() == null) {
            return new ReturnPair(tNode.getKey(), tNode.getRight());
        }

        ReturnPair rPair = deleteMinItem(tNode.getLeft());
        tNode.setLeft(rPair.node);
        rPair.node = tNode;

        return rPair;
    }

    private static class ReturnPair {

        private Comparable key;
        private TreeNode node;

        public ReturnPair(Comparable key, TreeNode node) {
            this.key = key;
            this.node = node;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void clear() {
        this.root = null;
    }
}
