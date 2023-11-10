package org.example.algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <P>
 * 给一个数组，取出相邻的两个元素
 * </p>
 *
 * @author lijiang
 * @since 2023/11/10 下午5:19
 */
public class ListGetTwo {

    /**
     * 暴力解法， 写一个for循环，取出相邻的两个元素
     */
    public static Map<Integer, Integer> function(List<Integer> list) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size() - 1; i++) {
            int first = list.get(i);
            int second = list.get(i + 1);
            map.put(first, second);
        }
        System.out.println("map = " + map);

        return map;

    }

    /**
     * 使用 instream 和maptoObj 来解决
     */
    public static List<List<Integer>> f1(List<Integer> list) {


        List<List<Integer>> collect = IntStream.range(0, list.size() - 1).mapToObj(i -> List.of(list.get(i), list.get(i + 1))).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        return collect;

    }

    public static void main(String[] args) {


        List<Integer> list = List.of(1, 2, 3, 4);
        f1(list);


    }

}
