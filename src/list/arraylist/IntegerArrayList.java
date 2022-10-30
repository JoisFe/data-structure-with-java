package list.arraylist;

/**
 * @author : 조재철
 * @since 1.0
 */
public class IntegerArrayList implements IntegerListInterface {

    private Integer[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private final int NOT_FOUND = -12345;

    public IntegerArrayList() {
        this.item = new Integer[DEFAULT_CAPACITY];
    }

    public IntegerArrayList(int n) {
        this.item = new Integer[n];
        this.numItems = 0;
    }

    @Override
    public void add(int index, Integer x) {
        if (numItems >= item.length || index < 0 || index > numItems) {
            // 에러 처리
        } else {
            for (int i = numItems - 1; i >= index; --i) {
                item[i + 1] = item[i];
            }

            item[index] = x;

            ++numItems;
        }
    }

    @Override
    public void append(Integer x) {
        if (numItems >= item.length) {
            // 에러 처리
        } else {
            item[numItems++] = x;
        }
    }

    @Override
    public Integer remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1) {
            return null;
        } else {
            Integer tmp = item[index];

            for (int i = index; i < numItems - 1; ++i) {
                item[i] = item[i + 1];
            }

            --numItems;

            return tmp;
        }
    }

    @Override
    public boolean removeItem(Integer x) {
        int k = 0;

        while (k < numItems && item[k].compareTo(x) != 0) {
            ++k;
        }

        if (k == numItems) {
            return false;
        }

        for (int i = k; i < numItems - 1; ++i) {
            item[i] = item[i + 1];
        }

        --numItems;

        return true;
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index < numItems) {
            return item[index];
        }

        return null;
    }

    @Override
    public void set(int index, Integer x) {
        if (index >= 0 && index < numItems) {
            item[index] = x;
        } else {
            // 에러 처리
        }
    }

    @Override
    public int indexOf(Integer x) {
        int i = 0;

        for (i = 0; i < numItems; ++i) {
            if (((Comparable)item[i]).compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        item = new Integer[item.length];

        numItems = 0;
    }
}
