package list.arraylist;

/**
 * @author : 조재철
 * @since 1.0
 */
public class ArrayListMain {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

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

    }
}
