package net.yikun.realm;

import net.yikun.pojo.Permission;
import net.yikun.pojo.Role;
import net.yikun.pojo.User;
import net.yikun.service.UserServiceI;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {


    @Autowired
    private UserServiceI userServiceI;


    //    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        获取当前登录的用户
        String username = (String) principalCollection.getPrimaryPrincipal();


        User user = userServiceI.getUserByName(username);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }


        List<Role> roles = userServiceI.getUserAll(user.getId());


//        获取所有的角色
        List<String> roleList = new ArrayList<String>();
        List<String> permissionList = new ArrayList<String>();
        for (Role role : roles) {
            roleList.add(role.getRoleName());
            for (Permission p : role.getPermissions()) {
                permissionList.add(p.getUrl());
            }


        }

//        获取所有的权限

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleList);
        simpleAuthorizationInfo.addStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }


    //    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //        从token中获取用户名和密码
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());


        User user = userServiceI.getUserByName(username);
        if (user == null) {
            throw new UnknownAccountException("账号有误");
        }

       /* if ("0".equals(user.getStatus())) {
            throw new LockedAccountException("账号被锁定");
        }*/

        String npwd = userServiceI.shiroMD5(password, user.getSalt());

        if (!npwd.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("密码错误");
        }




        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
    }

}
