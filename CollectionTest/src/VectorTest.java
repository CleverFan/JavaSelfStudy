import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class VectorTest {
    private void vectorTest(){
        Vector<Integer> list = new Vector<>();
        Random r = new Random();
        for (int i = 0 ; i < 10; i++){
            list.add(new Integer(r.nextInt(100)));
        }
        System.out.println("size of vector is " + list.size());
        System.out.println(list);
        System.out.println(list.firstElement());
        System.out.println(list.lastElement());
        System.out.println(list.subList(3, 8));
        List<Integer> temp = new ArrayList<>();
        for(int i = 4; i < 7; i++){
            temp.add(list.get(i));
        }
        list.retainAll(temp);
        System.out.println("size of vector is " + list.size());
        System.out.println(list);
    }
}
