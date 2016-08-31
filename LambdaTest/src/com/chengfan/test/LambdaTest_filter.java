package com.chengfan.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ChengFan on 2016/8/31.
 */
public class LambdaTest_filter {
    @Test
    public void old(){
        System.out.println("使用for循环:");
        List<Integer> numbers = Arrays.asList(5,10,15);
        for (Integer number : numbers) {
            if (number > 10) {
                System.out.println(number);
            }
        }
    }

    @Test
    public void testNew() {
        System.out.println("使用filter:");
        List<Integer> numbers = Stream.of(5,10,15).collect(Collectors.toList());
        numbers.stream().filter(x -> x > 10).forEach(System.out::println);

    }
}
