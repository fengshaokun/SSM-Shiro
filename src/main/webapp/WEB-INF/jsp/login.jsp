<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="application/javascript" src="/js/jquery-1.10.2.min.js"></script>
    <script type="application/javascript" src="/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<div class="container">
    <form class="form-horizontal" action="" method="post">
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">用户名：</span>
            <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1" name="username">
        </div>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon2">密  码：</span>
            <input type="password" class="form-control" placeholder="密码" aria-describedby="basic-addon2"
                   name="password">
        </div>
        <div class="input-group">
            <input type="button" value="登录" class="btn btn-primary" onclick="changeAction(1)">

            <input type="button" value="注册" class="btn btn-warning" onclick="changeAction(0)">
        </div>
    </form>
</div>


<div>
    <shiro:hasRole name="role1">
        <button>角色1</button>
    </shiro:hasRole>
    <shiro:hasRole name="role2">
        <button>角色2</button>
    </shiro:hasRole>
    <shiro:hasRole name="role3">
        <button>角色3</button>
    </shiro:hasRole>

    <shiro:hasPermission name="user:update">
        <button>修改权限</button>
    </shiro:hasPermission>

    <shiro:hasPermission name="user:delete">
        <button>删除权限</button>
    </shiro:hasPermission>

    <%--<shiro:hasPermission name="user:select">
        <button>查询权限</button>
    </shiro:hasPermission>--%>
    <shiro:authenticated>
        <button>查询权限</button>
    </shiro:authenticated>

</div>

<script type="application/javascript">
    function changeAction(flag) {
        if (flag) {
            $(".form-horizontal").attr("action", "/login/login").submit();
        } else {
            $(".form-horizontal").attr("action", "/login/register").submit();
        }
    }
</script>
</body>
</html>