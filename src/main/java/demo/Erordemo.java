package demo;

import java.io.File;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/1/24 下午12:06
 */
public class Erordemo {

    public static void main(String[] args) {

        System.out.println(System.lineSeparator().length());
        System.out.println(File.separator);

        try {
            boolean c = true;
            if (c) {
                throw new RuntimeException("aa");
            }

            boolean d = true;
            if (d) {
                throw new RuntimeException("bb");
            }

        } catch (Exception e) {
            // System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            System.out.println(1);
            String a = "uploadfailed";
            System.out.println(a.length());
        }


    }


}
