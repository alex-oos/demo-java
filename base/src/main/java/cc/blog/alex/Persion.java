package cc.blog.alex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/2/29 上午10:58
 */
@AllArgsConstructor
@NoArgsConstructor
//@Data
public class Persion {

    private  String name;

    private Integer age;


    public static void main(String[] args) {

        Persion persion = new Persion("li", 12);
        System.out.println(persion.equals("demo"));
        System.out.println(persion.hashCode());
        System.out.println(persion.toString());
    }
}
