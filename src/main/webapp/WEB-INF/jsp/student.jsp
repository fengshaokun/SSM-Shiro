<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruce陈
  Date: 2019/6/10
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/jqPaginator.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>

<table border="1px solid">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>地址</th>
    </tr>

    <%--<c:forEach items="${stus}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.sname}</td>
            <td>${stu.age}</td>
            <td>${stu.gender}</td>
            <td>${stu.address}</td>
        </tr>
    </c:forEach>--%>

    <c:forEach items="${pageInfo.list}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.sname}</td>
            <td>${stu.age}</td>
            <td>${stu.gender}</td>
            <td>${stu.address}</td>
        </tr>
    </c:forEach>


</table>


<div class="pagination-layout">
    <div class="pagination">
        <ul class="pagination" total-items="pageInfo.totalRows" max-size="10" boundary-links="true">

        </ul>
    </div>
</div>


<script type="text/javascript">
    var if_firstime = true;
    window.onload = function () {
        $('.pagination').jqPaginator({
            totalPages: ${pageInfo.pages},
            visiblePages: 4,
            currentPage: ${pageInfo.pageNum},

            first: '<li class="first"><a href="javascript:void(0);">第一页</a></li>',
            prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
            next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
            last: '<li class="last"><a href="javascript:void(0);">最末页 </a></li>',
            page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',

            onPageChange: function (num) {
                if (if_firstime) {
                    if_firstime = false;
                } else if (!if_firstime) {
                    changePage(num);
                }

            }
        });
    }
    function changePage(num) {
        location.href = "/getAllStusByPage?pageNum=" + num;
    }
</script>

</body>
</html>
