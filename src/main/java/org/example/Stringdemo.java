package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lijiang
 * @since 2023/10/12 下午2:57
 * <P></p>
 */
public class Stringdemo {

    public static void main(String[] args) {

        String a = "consistent";
        System.out.println("a.toUpperCase() = " + a.toUpperCase());

        String demo = "LAYER_NAME, FIELD_NAME, ACTUAL_NAME, FEATURE_ID, ASSIST_NAME, ASSIST_ID, CHECK_ID, CHECK_NAME,\n" + " ERR_CODE, ERR_DESC, MISINFO, IMP_LEVEL, PARA_VALUE, TASK_ID, TILE, ASSIST_TILE, MANUAL_MIS        DATE_TIME, STEP, UUID, DIFF_FLAG, MIS_FLAG, CHECK_VERSION, LOG_SOURCE, FEEDBACK, UPDATEUSER,UPDATETIME, GEOTEXT, GEOMETRY, GEOMETRY_Z, SUB_TASK_I";

        String[] split = demo.split(",");
        List<String> list = Arrays.asList(split);
        List<String> collect = list.stream().map(e -> e.toLowerCase().strip()).collect(Collectors.toList());
        // collect.forEach(e ->{
        //     System.out.print(" " + e);
        // });
        String join = String.join(",", collect);
        System.out.println("join = " + join);

        String name = "李将";
        int age = 28;
        String format = String.format("大家好，我叫 %s ,今年 %d 岁", name, age);
        System.out.println("format = " + format);
    }

}
