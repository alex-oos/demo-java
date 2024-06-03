package cc.blog.alex.command;

import java.io.IOException;

/**
 * @author Alex
 * @since 2024/5/28 下午4:57
 * <p></p>
 */
public class JdkDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        Process exec = Runtime.getRuntime().exec("ping www.baidu.com");
        int waitFor = exec.waitFor();
        if (waitFor == 0) {
            System.out.println("ping success");
        } else {
            System.out.println("ping fail");
        }
    }

}
