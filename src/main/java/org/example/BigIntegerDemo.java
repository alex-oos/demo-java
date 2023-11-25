package org.example;

import java.math.BigInteger;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2023/11/25 下午2:54
 */
public class BigIntegerDemo {

    public static void main(String[] args) {

        BigInteger bigInteger = new BigInteger("0");
        int i = bigInteger.compareTo(BigInteger.ZERO);
        System.out.println("i = " + i);
    }

}
