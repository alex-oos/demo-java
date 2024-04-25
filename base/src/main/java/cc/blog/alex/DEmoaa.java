package cc.blog.alex;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/3/21 下午2:38
 */
public class DEmoaa {

    public static void main(String[] args) {

        List<Map<Object,Object>> list = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("name","alex");
        map.put("age",18);
        list.add(map);

        Map<Object, Object> collect = list.stream().collect(Collectors.toMap(item -> item.get("name"), item -> item.get("age")));
        System.out.println(collect);


    }

}
