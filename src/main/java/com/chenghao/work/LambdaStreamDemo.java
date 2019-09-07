package com.chenghao.work;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenghao
 * @date 2019/9/7
 */
public class LambdaStreamDemo {

    private static void test(){
        /**
         *  实战1  获取url后面的参数
         *  index.action?username=chenghao&userId=1&type=20&token=adfded&age=18
         */
        String str="username=chenghao&userId=1&type=20&token=adfded&age=18";
        Map<String, String> urlMap = Stream.of(str.split("&")).map(x -> x.split("="))
                .collect(Collectors.toMap(s -> s[0], s -> s[1]));
        System.out.println(urlMap);

        /**
         *  实战2 只将集合中id返回给前端
         */
        List<Book> books = Book.books();
        List<Integer> collect = books.stream()
                .map(Book::getId).collect(Collectors.toList());
        System.out.println(collect);
        /**
         * 实战3 将书的类型去重后返回给前端
         */
        List<String> collect1 = Book.books().stream()
                .map(Book::getType).distinct().collect(Collectors.toList());
        System.out.println(collect1);

        Set<String> collect2 = Book.books().stream()
                .map(Book::getType).collect(Collectors.toSet());
        System.out.println(collect2);
        /**
         * 实战4 将书的价格大于60，按发版日期降序传给前端
         */
        Book.books().stream().filter(book -> book.getPrice()>60)
                .sorted(Comparator.comparing(Book::getPublishDate).reversed()).forEach(System.out::print);


        /**
         * 实战5 转map 将book 转换为对应id 的map
         */
        Map<Integer, Book> map = Book.books().stream()
                .collect(Collectors.toMap(Book::getId, book -> book));
        System.out.println(map);
        /**
         * 实战6 最大小  将book最贵的返回给前端
         */
        Optional<Book> collect3 = Book.books().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Book::getPrice)));
        System.out.println(collect3);

        /**
         * 实战7 按类型分组后，取每组价格最高端
         */
        Map<String, Optional<Book>> collect4 = Book.books().stream()
                .collect(Collectors.groupingBy(Book::getType, Collectors.maxBy(Comparator.comparing(Book::getPrice))));
        System.out.println(collect4);
    }

    public static void main(String[] args) {
        test();
    }
}
