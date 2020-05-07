package com.houkai.functionref;

import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        //Supplier 代表一个输出
        Supplier s=()->12;
        System.out.println(s.get());
        //Consumer 代表一个输入
        Consumer c= (a)-> System.out.println(a);
        c.accept(12);
        //BiConsumer 代表两个输入
        BiConsumer<String,String> bc=(a,b)->
                System.out.println("a: "+a+" b: "+b);
        bc.accept("sd", "db");
        //Function 代表一个输入一个输出  (一般输入和输出是不同类型的)Function<T, R>对类型为T的对象应用操作，并返回结果。结果是R类型的对象
        Function<Integer,String> f=(a)->"a: "+a;
        //UnaryOperator 代表一个输入一个输出 (输入输出是同类型的)
        UnaryOperator<Integer> uo=(a)->a;
        System.out.println(uo.apply(123));
        //BiFunction 代表两个输入一个输出 (输入和输出是不同类型的)
        BiFunction<Integer,Integer,String> bf=(a,b)->"a: "+a+" b: "+b;
        System.out.println(bf.apply(34, 123));
        //BinaryOperator代表两个输入一个输出 (输入和输出是同类型的)
        BinaryOperator<Integer> bo=(a,b)->a+b;
        System.out.println(bo.apply(3   ,4));
        //Predicate<T>确定类型为T的对象是否满足某约束，并返回boolean 值
        Predicate<Boolean> p=(a)->a;
        System.out.println(p.test(1>2));
    }
}
