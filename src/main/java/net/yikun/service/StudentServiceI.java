package net.yikun.service;

import com.github.pagehelper.PageInfo;
import net.yikun.pojo.Student;

import java.util.List;

public interface StudentServiceI {
    List<Student> getAllStus();

    PageInfo<Student> getAllStusByPage(Integer pageNum);

}
