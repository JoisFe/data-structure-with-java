package list.arraylist;

/**
 * @author : 조재철
 * @since 1.0
 */
public class IntegerArrayListMain {

    public static void main(String[] args) {
        IntegerArrayList list = new IntegerArrayList();
        list.add(0, 300);
        list.add(0, 200);
        list.add(0, 100);
        list.append(500);
        list.append(600);
        list.remove(3);
        list.add(3, 250);
        list.add(1, 50);
        list.add(0, 10);
        list.append(700);
        list.remove(1);
        list.removeItem(600);

        for (int i = 0; i < list.len(); ++i) {
            System.out.println(list.get(i));
        }

        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(0, "test");
        stringArrayList.add(0, "sample");
        stringArrayList.add(0, "String");

        stringArrayList.append("test2");

        stringArrayList.remove(3);

        stringArrayList.add(3, "added-at-3");
        stringArrayList.add(1, "added-at-1");
        stringArrayList.add(0, "added-at-0");

        stringArrayList.append("appended");
        stringArrayList.remove(1);
        stringArrayList.removeItem("added-at-3");

        for (int i = 0; i < stringArrayList.len(); ++i) {
            System.out.println(stringArrayList.get(i));
        }
    }

}
