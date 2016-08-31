package com.chengfan.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChengFan on 2016/8/31.
 */
public class LambdaTest_interface {

    @Test
    public void main() {
        Man man = new Man();
        man.say("hello");
        man.eat();
    }
}
interface  Human{
    void say(String str);

    default void eat(){
        System.out.println("i an eating");
    }
}

class Man implements  Human{
    @Override
    public void say(String str) {
        System.out.println(str);
    }
}