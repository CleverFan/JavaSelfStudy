/**
 * Created by ChengFan on 2016/9/4.
 */
public class ForeachTest {
    public void test(){
        //定义并初始化一个数组
        int arr[] = {2, 3, 1};
        System.out.println("----1----排序前的一维数组");
        for (int x : arr) {
           System.out.println(x); //逐个输出数组元素的值
        }
    }
}
