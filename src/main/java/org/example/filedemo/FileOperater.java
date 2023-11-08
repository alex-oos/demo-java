package org.example.filedemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2023/11/6 下午3:04
 */
public class FileOperater {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("data/data.txt");

        List<String> list = Files.readAllLines(path);
        // System.out.println("list = " + list);
        String collect = list.stream().map(s -> "\"" + s + "\"").collect(Collectors.joining(","));

        System.out.println(collect);
    }

}
