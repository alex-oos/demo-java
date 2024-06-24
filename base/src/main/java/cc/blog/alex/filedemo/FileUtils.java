package cc.blog.alex.filedemo;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Alex
 * @since 2024/6/19 下午4:15
 * <p></p>
 */
public class FileUtils {

    /**
     * 删除文件 / 递归删除文件夹下所有文件。谨慎操作！
     * 主要用于容器内废弃文件清理
     *
     * @param path 文件/文件夹路径
     */
    public static void deleteAll(String path) {

        try {
            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                    Files.delete(file);
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

                    Files.delete(dir);
                    return super.postVisitDirectory(dir, exc);
                }
                @Override
                public FileVisitResult visitFileFailed(Path dir, IOException exc) throws IOException {

                    Files.delete(dir);
                    return super.visitFileFailed(dir, exc);
                }
            });
        } catch (IOException e) {
            //log.error("删除文件失败, path: {}, error: {}", path, e.getMessage());
        }
    }

}
