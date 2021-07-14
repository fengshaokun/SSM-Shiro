package net.yikun.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Role {

    private Integer roleId;
    private String roleName;
    private List<Permission> permissions;

}
