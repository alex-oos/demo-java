package cc.blog.alex;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.time.Duration;
import java.time.Instant;
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
public class DataCache {


    public static void main(String[] args) {

        Cache<String, String> cache = Caffeine.newBuilder().initialCapacity(10).maximumSize(10).expireAfterWrite(1, TimeUnit.SECONDS).recordStats().build();

        cache.put("cc/blog/alex", "cc/blog/alex");
        Instant start = Instant.now();

        int i = 0;
        while (i < Short.MAX_VALUE) {
            String uuid = UUID.randomUUID().toString();
            cache.put(uuid, uuid);
            i++;
            cache.getIfPresent(uuid);
        }
        Instant end = Instant.now();
        long seconds = Duration.between(start, end).toMillis();
        System.out.println(seconds);

        Map<String, String> map = new HashMap<>();
        Instant now = Instant.now();

        int j = 0;
        while (j < Short.MAX_VALUE) {
            String uuid = UUID.randomUUID().toString();
            map.put(uuid, uuid);
            j++;
            String s = map.get(uuid);
        }
        long millis = Duration.between(now, Instant.now()).toMillis();
        System.out.println(millis);

    }

}
