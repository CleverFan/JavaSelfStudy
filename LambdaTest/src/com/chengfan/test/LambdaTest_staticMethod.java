package com.chengfan.test;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ChengFan on 2016/8/31.
 */
public class LambdaTest_staticMethod {
    List<String> strs = null;
    @Before
    public void init(){
        strs = Arrays.asList("aa","bb","cc");
    }

    @Test
    public void oldMethod(){
        for (String str: strs){
            System.out.println(str);
        }
    }

    @Test
    public void newMethod(){
        strs.forEach(System.out::println);
    }

    @Test
    private void testPrinter() {
        Printer p = new Printer();
        p.print();
    }
}
class Printer {

    void print(){
        System.out.println("instanceRefence::methodName");
    }

    private void printInfo(){
        //实例方法引用
        new Thread(this::print);
    }
}