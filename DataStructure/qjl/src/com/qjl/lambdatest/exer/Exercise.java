package com.qjl.lambdatest.exer;


import com.qjl.lambdatest.Employee;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Exercise {

    List<Employee> emps = Arrays.asList(
            new Employee(1, "张三", 18),
            new Employee(2, "李四", 20),
            new Employee(3, "王五", 25),
            new Employee(4, "赵六", 30),
            new Employee(5, "田七", 35)
    );
    
    @Test
    public void test01(){
        Integer[] nums = new Integer[]{1,2,3,4,5};
        List<Integer> list = Arrays.stream(nums)
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void test02(){
        Integer result = emps.stream()
                .map(e -> 1)
                .reduce(0, Integer::sum);
        System.out.println(result);

        Optional<Integer> result2 = emps.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
        System.out.println(result2.get());
    }
}
