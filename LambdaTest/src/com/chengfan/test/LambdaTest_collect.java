package com.chengfan.test;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ChengFan on 2016/8/31.
 */
public class LambdaTest_collect {
    @Test
    public void test() {
        List<String> strs = Stream.of("a","b","c").collect(Collectors.toList());
        strs.forEach(System.out::println);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
