package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <P></p>
 *
 * @author Alex
 * @since 2023/10/30 下午2:50
 */
public class Demo1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("demo1");

        Set<String> set = new HashSet<>();
        set.add("demo1");

        System.out.println("list.containsAll(set) = " + list.containsAll(set));
    }

}
