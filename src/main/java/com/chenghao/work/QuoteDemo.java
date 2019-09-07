package com.chenghao.work;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author chenghao
 * @date 2019/9/7
 */
public class QuoteDemo {
    /**
     * 方法引用
     */
    private static void testQuote(){
        /**
         *  静态方法引用
         *  如果函数式接口的实现恰好是通过调用一个静态方法来实现，那么就可以使用静态方法引用
         *  类名::staticMethod
         */
        Supplier supplier1 = () -> Person.study();
        System.out.println(supplier1.get());
        Supplier supplier2 = Person::study;
        System.out.println(supplier2.get());

        /**
         *实例方法引用
         *如果函数式接口的实现恰好可以通过调用一个实例的实例方法来实现，那么就可以使用实例方法引用
         */
        Function<String,String> function1 = str -> new Change().change(str);
        System.out.println(function1.apply("test1"));
        Function<String,String> function2 = new Change()::change;
        System.out.println(function2.apply("test2"));

        /**
         * 构造器引用
         * 比如在jpa中findById查找后，返回Optional,调用orElseThrow(自定义异常::new)
         */
        Supplier<Person> s1 = () -> new Person();
        s1.get();
        Supplier<Person> s2 = Person::new;
        s2.get();
    }

    public static void main(String[] args) {
        testQuote();
    }
}

class Person {
    public Person(){
        System.out.println("构造器");
    }
    public static String study() {
        return "1";
    }
}
class Change{
    public String change(String str){
        return str.toUpperCase();
    }
}