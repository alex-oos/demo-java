package demo;

import java.lang.reflect.InvocationTargetException;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/2/21 下午3:58
 */
public class Demo1 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Persion persion = new Persion();
        persion.setName("alex");
        persion.setAge(20);
        String string = persion.getClass().getMethod("getName").invoke(persion).toString();

        System.out.println(string);
        System.out.println(string);

    }

}
