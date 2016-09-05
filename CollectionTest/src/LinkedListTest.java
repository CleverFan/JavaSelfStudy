import java.util.LinkedList;
import java.util.Random;

/**
 * Created by ChengFan on 2016/9/4.
 */
public class LinkedListTest {
    private void linkedListTest(){
        LinkedList<Integer> list = new LinkedList<>();
        Random r = new Random();
        for (int i = 0 ; i < 10; i++){
            list.add(100);
        }
        list.add(null);
        System.out.println("size of linked list is " + list.size());
        System.out.println(list);
        System.out.println(list.element());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.peek());
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        System.out.println(list.poll());
        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        System.out.println(list.pop());
        list.push(100);
        System.out.println("size of linked list is " + list.size());
        System.out.println(list);
    }
}
