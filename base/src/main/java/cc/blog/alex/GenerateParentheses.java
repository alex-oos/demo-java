package cc.blog.alex;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/3/20 下午4:53
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println("生成的括号组合为：" + result);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, "", result);
        return result;
    }

    private static void generateParenthesisHelper(int n, int leftCount, int rightCount, String current, List<String> result) {
        // 左右括号数量均达到n时，得到一个有效的括号组合
        if (leftCount == n && rightCount == n) {
            result.add(current);
            return;
        }

        // 放置左括号的条件：左括号数量小于n
        if (leftCount < n) {
            generateParenthesisHelper(n, leftCount + 1, rightCount, current + "(", result);
        }

        // 放置右括号的条件：右括号数量小于左括号数量
        if (rightCount < leftCount) {
            generateParenthesisHelper(n, leftCount, rightCount + 1, current + ")", result);
        }
    }
}
