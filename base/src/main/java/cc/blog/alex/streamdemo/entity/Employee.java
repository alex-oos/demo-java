package cc.blog.alex.streamdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Alex
 * @since 2024/6/11 下午4:44
 * <p></p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {


    private Integer number;

    private Integer salary;


}
