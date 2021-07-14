package net.yikun.mapper;

import net.yikun.pojo.Role;
import net.yikun.pojo.User;

import java.util.List;

public interface UserMapper {

    void addUser(User user);

    User getUserByName(String username);

    List<Role> getUserAll(Integer userId);



}
