package cc.blog.alex;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * <P></p>
 *
 * @author Alex
 * @since 2023/11/10 上午10:51
 */
public class SqlSync {

    public static final String prodHost = "http://prod-datavalidator-hdmap.evad.mioffice.cn/hdmap/";
    public static final String stagingdHost = "http://staging-datavalidator-hdmap.evad.mioffice.cn/hdmap/";
    public static final String predHost = "http://prod-datavalidator-hdmap.evad.mioffice.cn/hdmap/";
    public static final String testHost = "http://test-datavalidator-hdmap.evad.mioffice.cn/hdmap/";
    public static final String localhost = "http://localhost:8989/hdmap/";

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 50, 1L, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());


    public static List<String> getSql(String operate) {
        String filepath = "./sql/";
        switch (operate) {
            case "insert":
                filepath += "insert.sql";
                break;
            case "update":
                filepath += "update.sql";
                break;
            case "alter":
                filepath += "alter.sql";
                break;
            default:
                throw new RuntimeException("operate is not support");
        }

        List<String> sqls = null;

        try {
            sqls = Files.readAllLines(Paths.get(filepath));
            // 过滤掉空行
            sqls = sqls.stream().filter(StringUtils::isNotEmpty).collect(Collectors.toList());
            return sqls;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject sqlExec(String host, String operate, String sql) {
        String url = null;
        String responseStr = null;
        JSONObject reponse = null;
        switch (operate) {
            case "insert":
                url = host + "insert";
                responseStr = HttpRequest.post(url).header("Content-Type", "text/plain").body(sql).execute().body();
                reponse = JSONObject.parseObject(responseStr);
                reponse.put("requestBody", sql);
                return reponse;
            case "update":
                url = host + "update";
                responseStr = HttpRequest.put(url).header("Content-Type", "text/plain").body(sql).execute().body();
                reponse = JSONObject.parseObject(responseStr);
                reponse.put("requestBody", sql);
                return reponse;
            case "alter":
                url = host + "alter";
                break;
        }
        return null;

    }

    public static void main(String[] args) {
        String operateInsert = "insert";
        String operateUpdate = "update";
        String operateAlter = "alter";
        List<String> sqls = getSql(operateInsert);
        List<CompletableFuture<JSONObject>> result = new ArrayList<>();
        for (String sql : sqls) {
            CompletableFuture<JSONObject> future = CompletableFuture.supplyAsync(
                () -> sqlExec(localhost, operateInsert, sql),
                executor);
            result.add(future);

        }

        List<JSONObject> errorList = new ArrayList<>();
        for (CompletableFuture<JSONObject> completableFuture : result) {
            try {
                JSONObject res = completableFuture.get();
                if (res.getInteger("code") != 200) {
                    errorList.add(res);
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("一共执行了" + result.size() + "条sql语句");
        System.out.println("执行成功：" + (result.size() - errorList.size()) + "条sql语句");
        if (!errorList.isEmpty()) {
            System.out.println("执行失败：" + errorList.size() + "条sql语句");
            System.out.println("失败为：" + errorList);

        }
    }





}
