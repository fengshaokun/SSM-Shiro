package net.yikun.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private List<Role> roles;

}
