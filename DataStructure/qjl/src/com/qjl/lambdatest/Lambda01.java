package com.qjl.lambdatest;




import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lambda01 {

    List<Employee> emps = Arrays.asList(
            new Employee(1, "张三", 18),
            new Employee(2, "李四", 20),
            new Employee(3, "王五", 25),
            new Employee(4, "赵六", 30),
            new Employee(5, "田七", 35)
    );

    @Test
    public void test01() {
        /*happy(100, (x) -> {
            System.out.println(x);
        });*/

        /*List<Integer> numList = getNumList(10, () -> {
            return (int) (Math.random()*10);
        });
        System.out.println(numList);*/

        String s1 = filterStr("  sd7sda2hj", s -> {
            return s.trim();
        });
        System.out.println(s1);
    }


    public String filterStr(String list, Function<String,String>function){
        return function.apply(list);
    }


    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<num;i++){
            Integer s = supplier.get();
            list.add(s);
        }
        return list;
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}















