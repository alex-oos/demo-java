package demo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <P></p>
 *
 * @author Alex
 * @since 2023/11/25 下午2:54
 */
public class BigIntegerDemo {

    public static void main(String[] args) {

        BigInteger bigInteger = new BigInteger("0");
        int i = bigInteger.compareTo(BigInteger.ZERO);
        System.out.println("i = " + i);

        List<Integer> expectList = IntStream.range(0, 9).mapToObj(g -> -g).sorted().collect(Collectors.toList());
        System.out.println(expectList);

        List<Integer> list = IntStream.range(0, 6).mapToObj(h -> -h).collect(Collectors.toList());
        System.out.println("expectList.containsAll(list) = " + expectList.containsAll(list));
        list.remove(3);
        int a = 0;
        for (int j = 0; j < list.size(); j++) {
            if (a != list.get(j)) {
                System.out.println("list.get(j) = " + list.get(j));
            }
        }

        BigInteger bigInteger1 = new BigInteger("1742736939379912704");
        BigInteger bigInteger2 = new BigInteger("9223372036854775807");
        int i1 = bigInteger1.compareTo(bigInteger2);
        System.out.println("i1 = " + i1);

        // 1. 生成一个map
        // 2. map的value转成list
        // 3. list转成string
        Map<Integer, Integer> map = IntStream.range(0, 10).boxed().collect(Collectors.toMap(k -> k, v -> v));
        System.out.println("map = " + map);
        List<String> collect = map.values().stream().map(e -> String.valueOf(e)).collect(Collectors.toList());
        String c = String.join("-", collect);
        System.out.println("c = " + c);


    }


}
