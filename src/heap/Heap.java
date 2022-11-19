package heap;

import heap.exception.PQException;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Heap<E extends Comparable> implements PQInterface<E> {

    private E[] headArray;
    private int numItems;

    public Heap(int arraySize) {
        this.headArray = (E[]) new Comparable[arraySize];
        this.numItems = 0;
    }

    public Heap(E[] headArray, int numItems) {
        this.headArray = headArray;
        this.numItems = numItems;
    }

    @Override
    public void insert(E newItem) throws PQException {
        if (this.numItems < this.headArray.length) {
            this.headArray[numItems] = newItem;

            percolateUp(numItems);

            ++numItems;
        } else {
            throw new PQException("HeapErr: Insert()-Overflow!");
        }
    }

    private void percolateUp(int i) {
        int parent = (i - 1) / 2;

        if (parent >= 0 && this.headArray[i].compareTo(this.headArray[parent]) > 0) {
            E tmp = this.headArray[i];
            this.headArray[i] = this.headArray[parent];
            this.headArray[parent] = tmp;

            percolateUp(parent);
        }
    }

    @Override
    public E deleteMax() throws PQException {
        if (!isEmpty()) {
            E max = this.headArray[0];

            this.headArray[0] = this.headArray[numItems - 1];
            --numItems;
            percolateDown(0);

            return max;
        }

        throw new PQException("HeapErr: DeleteMax()-Underflow");
    }

    private void percolateDown(int i) {
        int child = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (child <= numItems - 1) {
            if (rightChild <= numItems - 1 && this.headArray[child].compareTo(this.headArray[rightChild]) < 0) {
                child = rightChild;
            }

            if (this.headArray[i].compareTo(this.headArray[child]) < 0) {
                E tmp = this.headArray[i];
                this.headArray[i] = this.headArray[child];
                this.headArray[child] = tmp;

                percolateDown(child);
            }
        }
    }

    @Override
    public E max() throws PQException {
        if (!isEmpty()) {
            return this.headArray[0];
        }

        throw new PQException("HeapErr: Max()-Empty");
    }

    @Override
    public boolean isEmpty() {
        return this.numItems == 0;
    }

    @Override
    public void clear() {
        this.headArray = (E[]) new Comparable[this.headArray.length];
        this.numItems = 0;
    }

    public void buildHeap() {
        if (this.numItems >= 2) {
            for (int i = (numItems - 2) / 2; i >= 0; --i) {
                percolateDown(i);
            }
        }
    }
}
