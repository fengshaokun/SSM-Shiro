package net.yikun.service;

import net.yikun.pojo.Role;
import net.yikun.pojo.User;

import java.util.List;

public interface UserServiceI {

    void register(User user);

    String shiroMD5(String password, String salt);

    User getUserByName(String username);


    List<Role> getUserAll(Integer userId);



}
