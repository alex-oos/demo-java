package org.example.reflection;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2023/11/8 上午10:18
 */
@Data
public class ReflectionDemo {

    private String name;


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class clazz = Class.forName("org.example.reflection.ReflectionDemo");
        Object instance = clazz.newInstance();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "lijiang");

        java.util.Map<?, ?> map = (java.util.Map<?, ?>) jsonObject;
        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = field.getName();
            if (map.containsKey(fieldName)) {
                field.setAccessible(true);
                field.set(instance, map.get(fieldName));
            }
        }
        System.out.println(instance);

    }

}
