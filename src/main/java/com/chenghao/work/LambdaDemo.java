package com.chenghao.work;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * lambda表达式
 *
 */
public class LambdaDemo
{
    /**
     * lambda表达式
     */
    private static void testLambda() throws Exception{
        /**
         *  Runnable 类上有@FunctionalInterface作为函数式接口标示
         *  无参数，无返回值
         */
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("lambda入门第一列");
            }
        };
        r1.run();
        Runnable r2 = () -> {System.out.println("lambda入门第一列包含大括号");};
        r2.run();
        Runnable r3 = () -> System.out.println("lambda入门第一列不包含大括号");
        r3.run();

        /**
         *  无参数，有返回值
         */
        Callable<String> c1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        };

        Callable<String> c2 = () -> {return "hello有括号";};
        Callable<String> c3 = () -> "hello无括号";

        System.out.println(c1.call());
        System.out.println(c2.call());
        System.out.println(c3.call());

        /**
         * 有参数有返回
         * 输入一个字符串，返回输入字符串的大写
         * aaa -> AAA
         * Function 一个输入一个输出
         */
        Function<String, String> fn = (str) -> str.toUpperCase();
        System.out.println(fn.apply("admin"));

        /**
         * 有参数无返回
         * Consumer 一个输入
         */
        Consumer<String> c = arg -> {System.out.println(arg);};
        c.accept("hello");


        /**
         *  forEach(Consumer<? super T> action)
         *  实际上集合的遍历，里面用的就是输入型function
         */
        List<String> stringList = Arrays.asList("chenghao", "xiaode", "jiajia");
        stringList.forEach(System.out::println);
    }

    public static void main ( String[] args ) throws Exception
    {
        testLambda();
    }

}
