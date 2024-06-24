package cc.blog.alex;


import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.io.unit.DataUnit;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * @author Alex
 * @since 2024/6/7 下午5:30
 * <p></p>
 */
public class TimeCalculator {

    /**
     * 计算和他们在一起了
     */
    public static void timeTogether() {

        LocalDate begin = LocalDate.of(2017, 12, 10);
        LocalDate end = LocalDate.of(2024, 4, 10);
        Period period = Period.between(begin, end);
        System.out.println("前任（王娅琴）：我们曾经在一起" + period.getYears() + "年，" + period.getMonths() + "月，" + period.getDays() + "天");
        long days = ChronoUnit.DAYS.between(begin, end);
        System.out.println("前任（王娅琴）：我们曾经在一起" + days + "天");


        LocalDate localDate = LocalDate.of(2024, 6, 5);
        long day = ChronoUnit.DAYS.between(localDate, LocalDate.now());
        System.out.println("现女友（夏琳琳）：在一起" + day + "天");
    }

    /**
     * 计算你活了多久
     */
    public static void time() {

        System.out.println("请输入你的出生日期：如果是阳历，请输入 true,农历输入false");
        Scanner scanner = new Scanner(System.in);
        boolean isSucess = scanner.nextBoolean();
        System.out.println("请输入你的出生日期:格式为：yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String time = scanner.next();
        String[] split = time.split("-");
        //如果是农历，需要特殊处理一下
        if (!isSucess) {
            ChineseDate chineseDate = new ChineseDate(LocalDate.now());
            System.out.println(chineseDate.getChineseDay());

        }

        LocalDate birthDate = LocalDate.parse(time, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        int yearsLived = age.getYears();
        int daysLived = (int) ChronoUnit.DAYS.between(birthDate, currentDate);
        System.out.println("你已经活了 " + yearsLived + " 年, 共 " + daysLived + " 天");


    }

    public static void main(String[] args) {

        ChineseDate chineseDate = new ChineseDate(1,1,1);

        System.out.println(chineseDate.getMonth());
        System.out.println(chineseDate.getChineseDay());



    }

}
