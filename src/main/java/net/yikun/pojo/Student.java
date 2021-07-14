package net.yikun.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String sname;
    private Integer age;
    private String gender;
    private String address;


}
