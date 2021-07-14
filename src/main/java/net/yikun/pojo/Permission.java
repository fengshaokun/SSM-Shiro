package net.yikun.pojo;

import lombok.Data;

@Data
public class Permission {
    private Integer permissionId;
    private String permissionName;
    private String url;
    private Integer parentId;
}
