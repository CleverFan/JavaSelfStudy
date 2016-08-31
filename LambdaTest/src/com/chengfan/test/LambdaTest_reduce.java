package com.chengfan.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ChengFan on 2016/8/31.
 */
public class LambdaTest_reduce {
    @Test
    public void print() {
        System.out.println("使用for循环：");
        List<Integer> nums = Arrays.asList(5,10,15,20);
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        System.out.println(sum);
    }

    @Test
    public void test() {
        System.out.println("使用reduce实现：");
        int result = Stream.of(5,10,15,20)
                .reduce(0,(sum,x) -> sum + x);
        System.out.println(result);
    }
}
