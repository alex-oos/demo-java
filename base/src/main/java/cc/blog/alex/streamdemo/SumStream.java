package cc.blog.alex.streamdemo;

import cc.blog.alex.streamdemo.entity.Employee;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @since 2024/6/11 下午4:42
 * <p></p>
 */
public class SumStream {

    public static void main(String[] args) {

        Employee employee1 = new Employee(1, 500);
        Employee employee2 = new Employee(2, 600);
        Employee employee3 = new Employee(3, 700);
        Employee employee4 = new Employee(4, 800);
        Employee employee5 = new Employee(5, 900);
        Employee employee6 = new Employee(6, 1000);
        Employee employee7 = new Employee(7, 1000);

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);
        list.add(employee7);

        //统计薪水
        IntSummaryStatistics statistics = list.stream().collect(Collectors.summarizingInt(Employee::getSalary));

        System.out.println("statistics is " + statistics);
        //统计薪水
        Integer sum = list.stream().collect(Collectors.summingInt(Employee::getSalary));


        System.out.println("sum = " + sum);
        // 取出最大的值
        Optional<Integer> max = list.stream().map(Employee::getSalary).max(Integer::compareTo);
        if (max.isPresent()) {
            System.out.println("max is " + max.get());
        }

        Optional<Employee> optionalEmployee = list.stream().filter(employee -> employee.getSalary() > 700).findFirst();
        if (optionalEmployee.isPresent()) {
            System.out.println("optionalEmployee.get() = " + optionalEmployee.get());
        }
        //anyMatch()，只要有一个元素匹配传入的条件，就返回 true。
        //allMatch()，只有有一个元素不匹配传入的条件，就返回 false；如果全部匹配，则返回 true。

        //noneMatch()，只要有一个元素匹配传入的条件，就返回 false；如果全部匹配，则返回 true。
        boolean anyMatch = list.stream().anyMatch(employee -> employee.getSalary() == 700);
        boolean allMatch = list.stream().allMatch(employee -> employee.getSalary() > 700);
        boolean noneMatch = list.stream().noneMatch(employee -> employee.getSalary() < 1000);
        System.out.println("anyMatch = " + anyMatch);
        System.out.println("allMatch = " + allMatch);
        System.out.println("noneMatch = " + noneMatch);



    }

}
