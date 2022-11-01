package hashtable.chainedHashTable;

import binarySearchTree.IndexInterface;
import list.linkedlist.LinkedList;
import list.linkedlist.Node;

/**
 * @author : 조재철
 * @since 1.0
 */
public class ChainedHashTable implements IndexInterface<Node> {

    private LinkedList<Integer>[] table;
    int  numItems = 0;

    public ChainedHashTable(int n) {
        table = (LinkedList<Integer>[]) new LinkedList[n];

        for (int i = 0; i < n; ++i) {
            table[i] = new LinkedList<>();
        }

        numItems = 0;
    }

    private int hash(Integer x) {
        return x % table.length;
    }

    @Override
    public Node search(Comparable x) {
        return null;
    }

    @Override
    public void insert(Comparable x) {

    }

    @Override
    public void delete(Comparable x) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
