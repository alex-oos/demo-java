package demo;

/**
 * <P></p>
 *
 * @author Alex
 * @since 2023/11/25 下午12:48
 */
public class Demo {

    public static void main(String[] args) {

        int  a = 61440;
        int c =a/1024;
        System.out.println(c);

        // 跳出标记
        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    continue outer;
                }
                System.out.print("j = " + j + " ");
            }
            System.out.println("i = " + i);
        }
    }

}
