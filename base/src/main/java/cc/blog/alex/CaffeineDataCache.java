package cc.blog.alex;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/2/26 下午5:33
 */
public class CaffeineDataCache {


    public static void main(String[] args) {

        Cache<String, String> cache = Caffeine.newBuilder()
                .initialCapacity(10)
                .maximumSize(Long.MAX_VALUE)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .recordStats()
                .build();

        LocalDateTime now1 = LocalDateTime.now();

        int i = 0;
        while (i < Short.MAX_VALUE) {
            String uuid = UUID.randomUUID().toString();
            cache.put(uuid, uuid);
            i++;
            String ifPresent = cache.getIfPresent(uuid);
            //System.out.println(ifPresent);
        }
        long seconds = Duration.between(now1, LocalDateTime.now()).toMillis();
        System.out.println("耗时" + seconds + "毫秒");

        Map<String, String> map = new HashMap<>();
        Instant now = Instant.now();

        int j = 0;
        while (j < Short.MAX_VALUE) {
            String uuid = UUID.randomUUID().toString();
            map.put(uuid, uuid);
            j++;
            String s = map.get(uuid);
            //System.out.println(s);
        }

        long millis = Duration.between(now, Instant.now()).toMillis();
        System.out.println("耗时" + millis + "毫秒");

    }

}
