package cc.blog.alex;

import org.apache.commons.collections.ListUtils;
import org.apache.poi.ss.formula.functions.Sumif;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/3/20 下午3:47
 */
public class RecursionMethod {

    public static void main(String[] args) {

        Integer i = fn(10);
        System.out.println(i);
        Integer sum = getSum(2);
        System.out.println(sum);

        String string = getString("hello");
        System.out.println(string);

        String function = function(1);
        System.out.println(function);

    }

    public static Integer fn(int n) {

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            return 2 * fn(n - 1) + fn(n - 2);
        }

    }

    public static Integer getSum(int n) {

        if (n == 1) {
            return 1;
        } else {
            return n + getSum(n - 1);
        }


    }

    public static Integer getSum2(int n) {

        if (n == 1) {
            return 1;
        } else {
            return n * getSum2(n - 1);
        }
    }

    public static String getString(String n) {

        if (n.length() == 1) {
            return n;
        } else {
            return getString(n.substring(1)) + n.charAt(0);
        }


    }

    public static String function(int n) {
        if (n == 1){
            return "（）";
        }else {
            return "(" + function(n - 1);
        }

    }

}
