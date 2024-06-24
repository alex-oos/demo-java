package cc.blog.alex.filedemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alex
 * @since 2024/6/20 下午5:44
 * <p></p>
 */
public class FileUtil {

    public static void main(String[] args) throws IOException {

        //获取目录下的所有文件的绝对路径
        //方式一：使用commons-io 中的FileUtils
        List<String> filePathList = FileUtils.listFiles(new File("/home/alex/IdeaProjects/demo/base"), null, true).stream().map(File::getAbsolutePath).collect(Collectors.toList());
        System.out.println(filePathList);

        //方式二：使用Files.walk
        try (Stream<Path> walk = Files.walk(Paths.get("/home/alex/IdeaProjects/demo/base"));) {
            List<String> filePaths = walk.filter(Files::isRegularFile).map(a -> a.toAbsolutePath().toString()).collect(Collectors.toList());
            System.out.println(filePaths);
        }

    }

}
