package com.chengfan.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ChengFan on 2016/8/31.
 */
public class LambdaTest_map {
    @Test
    public void testOold() {
        List<String> strs = Arrays.asList("a","b","c");
        for (String str : strs) {
            System.out.println(str.toUpperCase());
        }
    }

    @Test
    public void testNew() {
        List<String> strs = Stream.of("a","b","c")
                .map(str->str.toUpperCase())
                .collect(Collectors.toList());
        strs.forEach(System.out::println);
    }
}
