package com.qjl.lambdatest.exer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class TestTransaction {

    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
    @Test
    public void test01() {
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                //	.sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
    }

    //2. 交易员都在哪些不同的城市工作过？
    @Test
    public void test02() {
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    //3. 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test03() {
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()))
                .forEach(System.out::println);
    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test04() {
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted((t1, t2) -> t1.compareToIgnoreCase(t2))
                .forEach(System.out::println);
        System.out.println("----------------------------");
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .flatMap(this::filterCharacter)
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::print);
    }

    public Stream<String> filterCharacter(String string) {
        List<String> list = new ArrayList<>();
        for (Character c : string.toCharArray()) {
            list.add(c.toString());
        }
        return list.stream();
    }


    //5. 有没有交易员是在米兰工作的？
    @Test
    public void test05() {
        boolean bl = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(t -> "Milan".equals(t.getCity()));
        System.out.println(bl);
    }

    //6. 打印生活在剑桥的交易员的所有交易额
    @Test
    public void test06() {
        Optional<Integer> sum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                // .forEach(System.out::println);
                //.reduce((t1,t2)->Integer.sum(t1,t2));
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }


    //7. 所有交易中，最高的交易额是多少
    @Test
    public void test07() {
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(max.get());
    }

    //8. 找到交易额最小的交易
    @Test
    public void test08() {
        Optional<Transaction> min = transactions.stream()
                // .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(min.get());
    }

}