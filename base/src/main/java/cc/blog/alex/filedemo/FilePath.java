package cc.blog.alex.filedemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Alex
 * @date: 2023/10/7 上午10:35
 * @Descprition: 显示所有路径下的文件
 */
public class FilePath {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/mnt/pipeline_storage/data_validator_storage");
        try (Stream<Path> walk = Files.walk(path)) {
           List<String> filePaths = walk.filter(Files::isRegularFile).map(a -> a.toAbsolutePath().toString()).collect(Collectors.toList());
            System.out.println(filePaths);

        }
    }

}
