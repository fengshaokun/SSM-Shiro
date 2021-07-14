package net.yikun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yikun.mapper.StudentMapper;
import net.yikun.pojo.Student;
import net.yikun.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceI {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> getAllStus() {
        List<Student> allStus = studentMapper.getAllStus();
        return allStus;
    }

    @Override
    public PageInfo<Student> getAllStusByPage(Integer pageNum) {
        PageHelper.startPage(pageNum,3);
        List<Student> allStus = studentMapper.getAllStus();
        List<Student> allStus2 = studentMapper.getAllStus();
        PageInfo<Student> pageInfo = new PageInfo<Student>(allStus);
        return pageInfo;
    }

}
