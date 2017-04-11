<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>
    <title></title>
    <meta name="description" content="overview & stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/2.3.0/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="/resource/common/css/font-awesome.min.css"/>
    <!-- 下拉框 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/chosen/1.6.2/chosen.min.css"/>
    <link rel="stylesheet" href="/resource/common/ace/ace.min.css"/>
    <link rel="stylesheet" href="/resource/common/ace/ace-responsive.min.css"/>
    <link rel="stylesheet" href="/resource/common/ace/ace-skins.min.css"/>

    <script type="text/javascript" src="//cdn.bootcss.com/jquery/1.8.3/jquery.min.js"></script>
    <!--提示框-->
    <script type="text/javascript" src="/resource/common/js/jquery.tips.js"></script>
    <script type="text/javascript" src="/resource/common/js/getToJson.js"></script>

    <script type="text/javascript">
        $(top.hangge());
        $(document).ready(function () {

            $("#userName").attr("readonly", "readonly");
            $("#userName").css("color", "gray");

            $("#trueName").attr("readonly", "readonly");
            $("#trueName").css("color", "gray");

            $("#mobile").attr("readonly", "readonly");
            $("#mobile").css("color", "gray");

            $("#email").attr("readonly", "readonly");
            $("#email").css("color", "gray");

            $("#roleId").attr("disabled", "disabled");

        });
    </script>
</head>
<body>
<form name="userForm" id="userForm">
    <input type="hidden" name="userId" id="userId" value="${user.userId }"/>
    <div id="zhongxin">
        <table>

            <tr class="info">
                <td>
                    <select class="chzn-select" name="roleId" id="roleId" data-placeholder="请选择职位"
                            style="vertical-align:top;">
                        <option value=""></option>
                        <c:forEach items="${roleList}" var="role">
                            <option value="${role.roleId }"
                                    <c:if test="${role.roleId == user.roleId }">selected</c:if>>${role.roleName }
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td><input type="text" name="userName" id="userName" value="${user.userName }" maxlength="32"
                           placeholder="这里输入用户名" title="用户名"/></td>
            </tr>
            <tr>
                <td><input type="text" name="trueName" id="trueName" value="${user.trueName}" maxlength="32"
                           placeholder="这里输入姓名" title="姓名"/></td>
            </tr>
            <tr>
                <td><input type="number" name="mobile" id="mobile" value="${user.mobile }" maxlength="32"
                           placeholder="这里输入手机号" title="手机号"/></td>
            </tr>
            <tr>
                <td><input type="email" name="email" id="email" value="${user.email }" maxlength="32"
                           placeholder="这里输入邮箱" title="邮箱"/></td>
            </tr>
            <tr>
                <td style="text-align: center;">
                    <a class="btn btn-mini btn-danger"
                       onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));">关闭</a>
                </td>
            </tr>
        </table>
    </div>

    <div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img
            src="/resource/common/images/jiazai.gif"/><br/><h4 class="lighter block green"></h4></div>

</form>

<!-- 引入 -->
<script type="text/javascript">window.jQuery || document.write("<script src='//cdn.bootcss.com/jquery/1.8.3/jquery.min.js'>\x3C/script>");</script>
<script src="//cdn.bootcss.com/bootstrap/2.3.0/bootstrap.min.js"></script>
<script src="/resource/common/ace/ace-elements.min.js"></script>
<script src="/resource/common/ace/ace.min.js"></script>
<script type="text/javascript" src="//cdn.bootcss.com/chosen/1.6.2/chosen.jquery.min.js"></script><!-- 下拉框 -->

<script type="text/javascript">

    $(function () {
        //单选框
        $(".chzn-select").chosen();
        $(".chzn-select-deselect").chosen({allow_single_deselect: true});
    });

</script>

</body>
</html>