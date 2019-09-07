package com.chenghao.work;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenghao
 * @date 2019/9/7
 */
public class StreamDemo {
    /**
     * 创建Stream
     */
    public static void createStream(){
        /**
         *  利用数组创建stream
         */
        String[] arr ={"1","2"};
        Stream<String> stream1 = Stream.of(arr);
        stream1.forEach(System.out::println);

        /**
         *  利用集合创建stream
         */
        List<String> stringList = Arrays.asList("3", "4");
        Stream<String> stream2 = stringList.stream();
        stream2.forEach(System.out::println);

        /**
         *  filter
         */
        Arrays.asList(1,2,3,4,5).stream()
                .filter(x -> x%2==0).forEach(System.out::println);
        /**
         * distinct
         */
        Arrays.asList(1,2,3,3,2).stream()
                .distinct().forEach(System.out::println);
        /**
         * sorted
         */
        Arrays.asList(9,7,8,6).stream()
                .sorted().forEach(System.out::println);
        /**
         * map
         */
        Arrays.asList("13","12").stream()
                .map(Integer::valueOf).forEach(System.out::println);
        /**
         * mapToInt sum
         */
        int sum = Arrays.asList(16, 17).stream()
                .mapToInt(x -> x).sum();
        System.out.println(sum);
        /**
         * limit
         */
        Arrays.asList(20,23,99,88).stream()
                .limit(3).forEach(System.out::println);


        /**
         * max,min
         */
        Integer integer = Arrays.asList(10, 14, 12).stream()
                .max((a, b) -> a - b).get();
        System.out.println(integer);

        /**
         *  从1-50里面的所有偶数找出来你，放到一个list里面
         */

		List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50)
                .filter(x -> x%2 == 0).collect(Collectors.toList());
	    System.out.println(list);
    }

    public static void main(String[] args) {
        createStream();
    }

}
