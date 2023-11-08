package org.example.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <P></p>
 *
 * @author Alex
 * @since 2023/11/4 上午11:08
 */
public class GenaturValue {

    public static void main(String[] args) {

        List<Integer> list1 = IntStream.range(8, 13).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.range(20, 22).boxed().collect(Collectors.toList());
        List<Integer> list3 = IntStream.range(25, 33).boxed().collect(Collectors.toList());
        List<Integer> list4 = IntStream.range(42, 43).boxed().collect(Collectors.toList());
        List<Integer> list5 = IntStream.range(45, 46).boxed().collect(Collectors.toList());
        List<Integer> list6 = Arrays.asList(0, 1, 4, 18, 48, 50);

        List<Integer> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
        list.addAll(list3);
        list.addAll(list4);
        list.addAll(list5);
        list.addAll(list6);
        Collections.sort(list);
        String collect = list.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println("collect = " + collect);
        String a = "0,1,4,8,9,10,11,12,18,20,21,25,26,27,28,29,30,31,32,42,45,48,50";
        String[] split = a.split(",");
        List<String> collect1 = Arrays.stream(split).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);


    }

}
