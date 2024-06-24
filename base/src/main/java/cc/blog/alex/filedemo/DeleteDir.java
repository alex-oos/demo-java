package cc.blog.alex.filedemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * <P>
 * 删除文件夹下所有的文件</p>
 *
 * @author Alex
 * @since 2024/4/25 下午4:51
 */
public class DeleteDir {

    public static void deleteFolder(File folder) {


        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.deleteOnExit();
                }
            }
            if (files.length < 1) {
                folder.deleteOnExit();
            }
        }


    }


    public static void main(String[] args) {

        String pathName = "/data/work/";
        File file = new File(pathName);
        deleteFolder(file);

        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
