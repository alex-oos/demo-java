package cc.blog.alex;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author Alex
 * @since 2024/6/7 下午5:30
 * <p></p>
 */
public class TimeCalculator {

    public static void main(String[] args) {

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

}
