package demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/3/27 下午3:34
 */
public class asdsad {

    public static void main(String[] args) {

        List<Map<String, Integer>> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("demo", 1);
        map.put("age", 2);
        Collections.addAll(list, map);

        Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(item ->
                item.get("demo"), item -> item.get("age")));

        collect.forEach((key, value) -> {
            System.out.println(key + "===" + value);
        });


    }

}
