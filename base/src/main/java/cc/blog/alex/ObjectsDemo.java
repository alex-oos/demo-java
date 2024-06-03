package cc.blog.alex;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <P></p>
 *
 * @author LiJiang
 * @since 2024/5/13 上午10:45
 */
public class ObjectsDemo {

    public static void main(String[] args) throws UnknownHostException {

        int it = 65;
        float f1 = 65.0f;
        System.out.println(it == f1);

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        InetAddress localHost = InetAddress.getLocalHost();

        System.out.println(localHost);
    }

}
