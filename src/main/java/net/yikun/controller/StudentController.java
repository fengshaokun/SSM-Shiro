package net.yikun.controller;

import com.github.pagehelper.PageInfo;
import net.yikun.pojo.Student;
import net.yikun.service.StudentServiceI;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("stu")
public class StudentController {

    @Autowired
    private StudentServiceI studentServiceI;


    @RequestMapping("getAllStus")
    public String getAllStus(Map map) {
//        PageHelper.startPage(1, 2);
        List<Student> allStus = studentServiceI.getAllStus();
        map.put("stus", allStus);
        return "student";

    }


//    @RequiresRoles("管理员")
    @RequiresPermissions("user:update")
    @RequestMapping("getAllStusByPage")
    public String getAllStus(Map map,@RequestParam(required = false,defaultValue = "1") Integer pageNum) {
        PageInfo<Student> pageInfo = studentServiceI.getAllStusByPage(pageNum);
        map.put("pageInfo", pageInfo);
        return "student";
    }
}
