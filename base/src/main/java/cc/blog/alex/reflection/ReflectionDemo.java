package cc.blog.alex.reflection;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * <P></p>
 *
 * @author Alex
 * @since 2023/11/8 上午10:18
 */
@Data
public class ReflectionDemo {

    private String name;


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class clazz = Class.forName("cc.blog.alex.reflection.ReflectionDemo");
        Object instance = clazz.newInstance();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Alex");

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
