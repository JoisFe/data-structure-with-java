package tree.avl;

import tree.IndexInterface;

/**
 * @author : 조재철
 * @since 1.0
 */
public class AVLTree implements IndexInterface<AVLNode> {

    private final int LL = 1, LR = 2, RR = 3, RL = 4, NO_NEED = 0, ILLEGAL = -1;

    public static final AVLNode NIL = new AVLNode(null, null, null, 0);

    private AVLNode root;

    public AVLTree() {
        this.root = NIL;
    }

    @Override
    public AVLNode search(Comparable x) {
        return searchItem(root, x);
    }

    private AVLNode searchItem(AVLNode tNode, Comparable x) {
        if (tNode == NIL) {
            return NIL;
        }

        if (x.compareTo(tNode.getItem()) == 0) {
            return tNode;
        }

        if (x.compareTo(tNode.getItem()) < 0) {
            return searchItem(tNode.getLeft(), x);
        }

        return searchItem(tNode.getRight(), x);
    }

    @Override
    public void insert(Comparable x) {
        this.root = insertItem(this.root, x);
    }

    private AVLNode insertItem(AVLNode tNode, Comparable x) {
        if (tNode == NIL) {
            tNode = new AVLNode(x);
        } else if (x.compareTo(tNode.getItem()) < 0) {
            tNode.setLeft(insertItem(tNode.getLeft(), x));
            tNode.setHeight(1 + Math.max(tNode.getRight().getHeight(), tNode.getLeft().getHeight()));

            int type = needBalance(tNode);

            if (type != NO_NEED) {
                tNode = balanceAVL(tNode, type);
            }
        } else {
            tNode.setRight(insertItem(tNode.getRight(), x));
            tNode.setHeight(1 + Math.max(tNode.getRight().getHeight(), tNode.getLeft().getHeight()));

            int type = needBalance(tNode);
            if (type != NO_NEED) {
                tNode = balanceAVL(tNode, type);
            }
        }

        return tNode;
    }

    private AVLNode balanceAVL(AVLNode tNode, int type) {
        AVLNode returnNode = NIL;

        switch (type) {
            case LL:
                returnNode = rightRotate(tNode);
                break;
            case LR:
                tNode.setLeft(leftRotate(tNode.getLeft()));
                returnNode = rightRotate(tNode);
                break;
            case RR:
                returnNode = leftRotate(tNode);
                break;
            case RL:
                tNode.setRight(rightRotate(tNode));
                returnNode = leftRotate(tNode);
                break;
            default:
                System.out.println("Impossible type. Should be one of LL, LR, RR, RL");
                break;
        }

        return returnNode;
    }

    private AVLNode rightRotate(AVLNode tNode) {
        AVLNode LChild = tNode.getLeft();

        if (LChild == NIL) {
            System.out.println(tNode.getItem() + " s LChild shouldn't be NIL!");
        }

        AVLNode LRChild = LChild.getRight();
        LChild.setRight(tNode);

        tNode.setLeft(LRChild);
        tNode.setHeight(1 + Math.max(tNode.getLeft().getHeight(), LChild.getRight().getHeight()));

        LChild.setHeight(1 + Math.max(LChild.getLeft().getHeight(), LChild.getRight().getHeight()));

        return LChild;
    }

    private AVLNode leftRotate(AVLNode tNode) {
        AVLNode RChild = tNode.getRight();

        if (RChild == NIL) {
            System.out.println(tNode.getItem() + "s RChild shouldn't be NIL");
        }

        AVLNode RLChild = RChild.getLeft();
        RChild.setLeft(tNode);

        tNode.setRight(RLChild);
        tNode.setHeight(1 + Math.max(tNode.getLeft().getHeight(), tNode.getRight().getHeight()));

        RChild.setHeight(1 + Math.max(RChild.getLeft().getHeight(), RChild.getRight().getHeight()));

        return RChild;
    }

    private int needBalance(AVLNode tNode) {
        int type = ILLEGAL;

        if (tNode.getLeft().getHeight() + 2 <= tNode.getRight().getHeight()) {
            if (tNode.getRight().getLeft().getHeight() <= tNode.getRight().getRight().getHeight()) {
                type = RR;
            } else {
                type = RL;
            }
        } else if (tNode.getLeft().getHeight() >= tNode.getRight().getHeight() + 2) {
            if (tNode.getLeft().getLeft().getHeight() >= tNode.getLeft().getRight().getHeight()) {
                type = LL;
            } else {
                type = LR;
            }
        } else {
            type = NO_NEED;
        }

        return type;
    }

    @Override
    public void delete(Comparable x) {
        this.root = deleteItem(this.root, x);
    }

    private AVLNode deleteItem(AVLNode tNode, Comparable x) {
        if (tNode == NIL) {
            return NIL;
        }

        if (x.compareTo(tNode.getItem()) == 0) {
            tNode = deleteNode(tNode);
        } else if (x.compareTo(tNode.getItem()) < 0){
            tNode.setLeft(deleteItem(tNode.getLeft(), x));
            tNode.setHeight(1 + Math.max(tNode.getRight().getHeight(), tNode.getLeft().getHeight()));

            int type = needBalance(tNode);
            if (type != NO_NEED) {
                tNode = balanceAVL(tNode, type);
            }
        }

        tNode.setRight(deleteItem(tNode.getRight(), x));
        tNode.setHeight(1 + Math.max(tNode.getRight().getHeight(), tNode.getLeft().getHeight()));

        int type = needBalance(tNode);
        if (type != NO_NEED) {
            tNode = balanceAVL(tNode, type);
        }

        return tNode;
    }

    private AVLNode deleteNode(AVLNode tNode) {
        if (tNode.getLeft() == NIL && tNode.getRight() == NIL) {
            return NIL;
        } else if (tNode.getLeft() == NIL) {
            return tNode.getRight();
        } else if (tNode.getRight() == NIL) {
            return tNode.getLeft();
        }

        ReturnPair rPair = deleteMinItem(tNode.getRight());
        tNode.setItem(rPair.getItem());
        tNode.setRight(rPair.getNode());

        tNode.setHeight(1 + Math.max(tNode.getRight().getHeight(), tNode.getLeft().getHeight()));

        int type = needBalance(tNode);

        if (type != NO_NEED) {
            tNode = balanceAVL(tNode, type);
        }

        return tNode;
    }

    private ReturnPair deleteMinItem(AVLNode tNode) {
        int type;

        if (tNode.getLeft() == NIL) {
            return new ReturnPair(tNode.getItem(), tNode.getRight());
        }

        ReturnPair rPair = deleteMinItem(tNode.getLeft());
        tNode.setLeft(rPair.getNode());
        tNode.setHeight(1 + Math.max(tNode.getRight().getHeight(), tNode.getLeft().getHeight()));

        type = needBalance(tNode);

        if (type != NO_NEED) {
            tNode = balanceAVL(tNode, type);
        }

        rPair.setNode(tNode);

        return rPair;
    }

    @Override
    public boolean isEmpty() {
        return this.root == NIL;
    }

    @Override
    public void clear() {
        this.root = NIL;
    }

    private class ReturnPair {
        private Comparable item;
        private AVLNode node;

        private ReturnPair(Comparable item, AVLNode node) {
            this.item = item;
            this.node = node;
        }

        public Comparable getItem() {
            return item;
        }

        public AVLNode getNode() {
            return node;
        }

        public void setNode(AVLNode node) {
            this.node = node;
        }
    }
}
