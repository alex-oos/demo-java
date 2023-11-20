package org.example;

import java.math.BigInteger;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2023/11/20 下午4:59
 */
public class BigInterDemo {

    public static void main(String[] args) {

        BigInteger bigInteger = new BigInteger("9223372036854775807");
        System.out.println(bigInteger.compareTo(BigInteger.ZERO));
    }

}
