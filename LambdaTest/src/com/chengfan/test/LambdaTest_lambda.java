package com.chengfan.test;

import org.junit.Test;

/**
 * Created by ChengFan on 2016/8/31.
 */
public class LambdaTest_lambda {

    @Test
    public void oldMethod(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out .println("hello lambda");
            }
        }).start();
    }

    @Test
    public void newMethod(){
        new Thread(()->System.out.println("new!")).start();
    }

    @Test
    public void useMan(){
        Human h = str -> System.out.println(str);
        h.say("hello");
    }
}
