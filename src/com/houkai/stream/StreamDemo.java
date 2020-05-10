package com.houkai.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @create: 2019-10-19 20:10
 */
public class StreamDemo {

    //通过数组来生成
    static void gen1(){
        String[] arr= {"a","b","c","d"};
        Stream<String> arr1 = Stream.of(arr);
        arr1.forEach(System.out::println);
    }

    //通过集合来生成
    static void gen2(){
        List<String> list =Arrays.asList("1","2","3","4");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }
    //generate
    static void gen3(){
        Stream<Integer> generate = Stream.generate(() ->1);
        generate.limit(10).forEach(System.out::println);
    }

    //使用iterator
    static void gen4(){
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }
    //其他方式
    static void gen5(){
        String str="sdfghjk";
        IntStream chars = str.chars();
        chars.forEach(System.out::println);
        AtomicInteger ai= new AtomicInteger();
    }
    public static void main(String[] args) {
        //stream生成的操作
//        gen1();
//        gen2();
//        gen3();
//        gen4();
//        gen5();

        //中间操作:如果调用方法之后返回的结果是Stream对象就意味着是一个中间操作
        Arrays.asList(1,2,3,4,5,6,7,8).stream().filter((x)->x%2==0).forEach(
                System.out::println);
        //求出结果集中所有偶数的和
        long count = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream().filter(
                (x) -> x % 2 == 0).mapToInt(x->x).sum();
        System.out.println(count);
        //求集合中的最大值
        /*OptionalInt max = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream().filter(
                (x) -> x % 2 == 0).mapToInt(x -> x).max();
        System.out.println(max.getAsInt());*/
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println(max.get());
        //求集合的最小值
        Optional<Integer> min = list.stream().min((a, b) -> a - b);
        System.out.println(min.get());


        Optional<Integer> any = list.stream().filter(x -> x % 2 == 0).findAny();
        System.out.println(any.get());
        Optional<Integer> first = list.stream().filter(x -> x % 2 == 0).findFirst();
        System.out.println(first.get());
        //获取最大值和最小值但是不使用min和max方法
        Optional<Integer> first1 = list.stream().sorted((a, b) -> a - b).findFirst();
        System.out.println(first1.get());
        Arrays.asList("ew","edf","wd","rf","tg","dw","qw").stream().sorted().forEach(System.out::println);
        System.out.println("----------------");
        Arrays.asList("ew","e84df","wd85","r2f","t594949g","dw","qw").stream().sorted((a,b)->a.length()-b.length()).forEach(System.out::println);
        //想将集合中的元素进行过滤同时返回一个集合对象
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);
        //去重操作
        System.out.println("---------");
        Arrays.asList(1,2,3,2,3,4,5,4,3,5).stream().distinct().forEach(System.out::println);
        System.out.println("---------");
        Arrays.asList(1,2,3,2,3,4,5,4,3,5).stream().collect(Collectors.toSet())
                .forEach(System.out::println);
        //打印20-30这样的集合数据
        System.out.println("---------");
        Stream.iterate(1, x->x+1).limit(50).skip(20).limit(10).forEach(System.out::println);
        System.out.println("---------");


        String str="11,22,3,44,55";
        System.out.println(Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println("---------");
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println("---------");
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println("---------");
        System.out.println(Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());
        //创建一组自定义对象
        String str2="java,scala,py";
        Stream.of(str2.split(",")).map(x->new Person(x)).forEach(System.out::println);
        System.out.println("----");
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);
        System.out.println("----");
        Stream.of(str2.split(",")).map(x->Person.build(x)).forEach(System.out::println);
        System.out.println("----");
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);
        System.out.println("----");
        //将str中的每一个数值都打印出来，同时算出最终的求和结果
        System.out.println(Stream.of(str.split(",")).peek(System.out::println)
                .mapToInt(Integer::valueOf).sum());
        System.out.println(list.stream().allMatch(x -> x > 0));
    }
}
