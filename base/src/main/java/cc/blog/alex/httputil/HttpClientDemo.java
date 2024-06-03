package cc.blog.alex.httputil;


import okhttp3.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * @author Alex
 * @since 2024/5/21 下午2:58
 * <p></p>
 */
public class HttpClientDemo {

    public static String host = "http://localhost:8080";

    static String getUri = "/car";

    public static long httpClientGet() {

        Instant begin = Instant.now();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(host + getUri);
            Instant now = Instant.now();
            HttpResponse response = httpClient.execute(request);
            long millis = Duration.between(now, Instant.now()).toMillis();
            System.out.println("httpclient execute 耗时：" + millis + "毫秒");
            String result = EntityUtils.toString(response.getEntity());
            //System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Duration between = Duration.between(begin, Instant.now());
        //System.out.println("httpclient耗时：" + between.toMillis() + "毫秒");
        return between.toMillis();
    }

    public static long okHttpClientGet() {

        Instant begin = Instant.now();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(host + getUri).get().build();

        try {
            Instant now = Instant.now();
            Response response = client.newCall(request).execute();
            long millis = Duration.between(now, Instant.now()).toMillis();
            System.out.println("okhttp execute 耗时：" + millis + "毫秒");
            if (response.isSuccessful()) {
                String result = response.body().string();
                //System.out.println(result);
            } else {
                System.out.println("请求失败");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Duration between = Duration.between(begin, Instant.now());
        //System.out.println("okhttp耗时：" + between.toMillis() + "毫秒");
        return between.toMillis();

    }

    public static CompletableFuture<String> okHttpClientAsyncGet() {

        Instant begin = Instant.now();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(host + getUri).get().build();
        CompletableFuture<String> future = new CompletableFuture<>();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                future.completeExceptionally(e);

                System.out.println("请求失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                if (response.isSuccessful()) {
                    String result = response.body().string();
                    System.out.println(result);
                    future.complete(result);
                } else {
                    future.completeExceptionally(new IOException("Unexpected code " + response));

                }
            }
        });


        Duration between = Duration.between(begin, Instant.now());
        System.out.println("okhttpAsync耗时：" + between.toMillis() + "毫秒");
        return future;

    }

    public static void okHttpClientRetry() {

        Instant now = Instant.now();

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request request = chain.request();
            Response response = null;
            boolean responseOk = false;
            int tryCount = 0;
            while (!responseOk && tryCount < 3) {
                try {
                    response = chain.proceed(request);
                    responseOk = response.isSuccessful();
                } catch (IOException e) {
                    System.err.println("请求失败"+e.getMessage());
                    tryCount++;
                }
            }
            if (response == null) {
                throw new IOException("Request failed after 3 attempts");

            }
            return response;
        }).build();

        Request request = new Request.Builder().url(host + getUri).get().build();

        try {
            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                String result = response.body().string();
                System.out.println(result);
            } else {
                 //throw new IOException("Unexpected code " + response);
                System.out.println("请求失败");
            }

        } catch (IOException e) {
            //System.err.println("请求失败"+e.getMessage());
            throw new RuntimeException(e);
        }
        long millis = Duration.between(now, Instant.now()).toMillis();
        System.out.println("okhttp execute 耗时：" + millis + "毫秒");
    }

    public static void main(String[] args) {

        //long httpclientTime = httpClientGet();
        //long okClientTime = okHttpClientGet();
        //CompletableFuture<String> future = okHttpClientAsyncGet();
        //String message = httpclientTime > okClientTime ? "httpclient 耗时比较长" : "okhttp 耗时比较长";
        //System.out.println(message + "\n" + "httpClient 耗时为：" + httpclientTime + "ms\n" + "okhttp 耗时为：" + okClientTime + "ms");
        //
        //String s = null;
        //try {
        //    s = future.get();
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //} catch (ExecutionException e) {
        //    throw new RuntimeException(e);
        //}
        //System.out.println(s);

        okHttpClientRetry();


    }

}
