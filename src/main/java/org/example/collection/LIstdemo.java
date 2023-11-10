package org.example.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * <P></p>
 *
 * @author Alex
 * @since 2023/10/30 下午2:14
 */
public class LIstdemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println("list.isEmpty() = " + list.isEmpty());

        list.add("demos");
        list.add("demo1");

        ArrayList<String> strings = new ArrayList<>();
        strings.add("demo1");
        strings.add("demo2");
        boolean b = strings.containsAll(list);
        System.out.println("b = " + b);
    }

}
