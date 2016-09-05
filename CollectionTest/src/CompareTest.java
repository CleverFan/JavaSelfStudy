import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CompareTest {
    private List<Integer> array = new ArrayList<>();
    private List<Integer> linked = new LinkedList<>();

    public void test() {
        for (int i = 0; i < 10000; i++) {
            array.add(i);
            linked.add(i);
        }
        System.out.println("array time:" + getTime(array));
        System.out.println("linked time:" + getTime(linked));
        System.out.println("array insert time:" + insertTime(array));
        System.out.println("linked insert time:" + insertTime(linked));

    }

   private  long getTime(List<Integer> list) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int index = Collections.binarySearch(list, list.get(i));
            if (index != i) {
                System.out.println("ERROR!");
            }
        }
        return System.currentTimeMillis() - time;
    }

    private long insertTime(List<Integer> list) {
        long time = System.currentTimeMillis();
        for (int i = 100; i < 10000; i++) {
            list.add(5000, i);
        }
        return System.currentTimeMillis() - time;

    }
}
