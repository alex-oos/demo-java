package org.example;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2023/11/10 上午10:51
 */
public class HttpUtilDemo {

    public static List<String> getBody() {

        Path path = Paths.get("./data/db.text");
        List<String> list = null;
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    public static JSONObject request(String body) {

        String host = "http://prod-datavalidator-hdmap.evad.mioffice.cn";
        String localhost = "http://localhost:8989";

        String url = host + "/hdmap/update";
        String response = HttpRequest.put(url).header("Content-Type", "text/plain").body(body).execute().body();
        JSONObject jsonObject = JSONObject.parseObject(response);
        jsonObject.put("requestBody", body);
        return jsonObject;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 50, 1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());

        List<String> bodyList = getBody();
        // List<CompletableFuture<JSONObject>> list = new ArrayList<>();
        for (String body : bodyList) {
            CompletableFuture<JSONObject> completableFuture = CompletableFuture.supplyAsync(() -> request(body),
                    executor).thenApply(jsonObject -> {
                if (!jsonObject.get("code").equals(200)) {
                    System.out.println(jsonObject);
                }
                return jsonObject;
            });
            // list.add(completableFuture);
        }
        // for (CompletableFuture<JSONObject> jsonObjectCompletableFuture : list) {
        //     JSONObject jsonObject = jsonObjectCompletableFuture.get();
        //     if (!jsonObject.get("code").equals(200)) {
        //         System.out.println(jsonObject);
        //     }
        // }


    }

}
