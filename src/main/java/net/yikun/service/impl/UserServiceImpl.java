package net.yikun.service.impl;

import net.yikun.mapper.UserMapper;
import net.yikun.pojo.Role;
import net.yikun.pojo.User;
import net.yikun.service.UserServiceI;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServiceI {


    @Autowired
    private UserMapper userMapper;


    @Override
    public void register(User user) {

        if (user == null) {
            throw new RuntimeException("参数不能为空");
        }

//        user.setStatus("1");
//        定义盐值
        String salt = DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());
        user.setSalt(salt);
        user.setPassword(shiroMD5(user.getPassword(),salt));
        userMapper.addUser(user);
    }

    @Override
    public String shiroMD5(String password, String salt) {

        String hashAlgorithmName="MD5";
//        salt转成ByteSource型
        ByteSource saltSource = ByteSource.Util.bytes(salt);
        int hashIterations=2;

        Object simpleHash = new SimpleHash(hashAlgorithmName, password, saltSource, hashIterations);
        return simpleHash.toString();
    }

    @Override
    public User getUserByName(String username) {

//        从数据库查询
      /*  User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("86a7a5d17dee9684e4ba9b31b81de01a");
        user.setSalt("8cc5dc0663ba207fe3b694286fdc1166");*/
        User user = userMapper.getUserByName(username);
        return user;
    }

    @Override
    public List<Role> getUserAll(Integer userId) {

        List<Role> roles = userMapper.getUserAll(userId);

        return roles;
    }


}
