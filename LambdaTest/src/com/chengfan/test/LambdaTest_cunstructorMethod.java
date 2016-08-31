package com.chengfan.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChengFan on 2016/8/31.
 */
public class LambdaTest_cunstructorMethod {
    class User {
        String username;

        User(String username){
            this.username = username;
        }

        public String getUsername(){
            return username;
        }
    }

    @FunctionalInterface
    interface UserFactory<T extends User> {
        T create(String username);
    }

    private void test() {
        UserFactory<User> uf = User::new;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            users.add(uf.create("user"+i));
        }
        users.stream().map(User::getUsername).forEach(System.out::println);
    }

    @Test
    public void main() {
        LambdaTest_cunstructorMethod t = new LambdaTest_cunstructorMethod();
        t.test();
    }


}
