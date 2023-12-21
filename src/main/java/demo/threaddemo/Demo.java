package demo.threaddemo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * <P></p>
 *
 * @author Alex
 * @since 2023/12/14 下午12:29
 */
public class Demo {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        System.out.println(map);
        String string = UUID.randomUUID().toString();
        while (true) {
            CompletableFuture.supplyAsync(() -> {
                // map.put("uuid", string);
                // System.out.println(map);
                Map<String, Object> map1 = new HashMap<>();
                map1.put("demo1", UUID.randomUUID().toString());
                map.put("uuid", map1);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return map;
            }).thenAccept((res) -> {
                System.out.println("res = " + res);
            });
        }


        // System.out.println(map);
    }

}
