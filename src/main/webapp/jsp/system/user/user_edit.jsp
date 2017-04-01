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
            if ($("#userId").val() != "") {
                $("#userName").attr("readonly", "readonly");
                $("#userName").css("color", "gray");
            }
        });

        //保存
        function save() {
            if ($("#roleId").val() == "") {

                $("#roleId").tips({
                    side: 3,
                    msg: '选择角色',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#roleId").focus();
                return false;
            }
            if ($("#userName").val() == "" || $("#userName").val() == "此用户名已存在!") {

                $("#userName").tips({
                    side: 3,
                    msg: '输入用户名',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#userName").focus();
                $("#userName").val('');
                $("#userName").css("background-color", "white");
                return false;
            } else {
                $("#userName").val(jQuery.trim($('#userName').val()));
            }


            if ($("#userId").val() == "" && $("#password").val() == "") {

                $("#password").tips({
                    side: 3,
                    msg: '输入密码',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#password").focus();
                return false;
            }
            if ($("#password").val() != $("#checkPassword").val()) {

                $("#checkPassword").tips({
                    side: 3,
                    msg: '两次密码不相同',
                    bg: '#AE81FF',
                    time: 3
                });

                $("#checkPassword").focus();
                return false;
            }
            if ($("#trueName").val() == "") {

                $("#trueName").tips({
                    side: 3,
                    msg: '输入姓名',
                    bg: '#AE81FF',
                    time: 3
                });
                $("#trueName").focus();
                return false;
            }

            var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
            if ($("#mobile").val() == "") {

                $("#mobile").tips({
                    side: 3,
                    msg: '输入手机号',
                    bg: '#AE81FF',
                    time: 3
                });
                $("#mobile").focus();
                return false;
            } else if ($("#mobile").val().length != 11 && !myreg.test($("#mobile").val())) {
                $("#mobile").tips({
                    side: 3,
                    msg: '手机号格式不正确',
                    bg: '#AE81FF',
                    time: 3
                });
                $("#mobile").focus();
                return false;
            }

            if ($("#email").val() == "") {

                $("#email").tips({
                    side: 3,
                    msg: '输入邮箱',
                    bg: '#AE81FF',
                    time: 3
                });
                $("#email").focus();
                return false;
            } else if (!ismail($("#email").val())) {
                $("#email").tips({
                    side: 3,
                    msg: '邮箱格式不正确',
                    bg: '#AE81FF',
                    time: 3
                });
                $("#email").focus();
                return false;
            }


            if ($("#userId").val() == "") {
                existUserName();
            } else {
                $.ajax({
                    url: "${action}",
                    data: getToJsonString($('#userForm').serialize()),
                    dataType: "json",
                    type: 'POST',
                    async: true,    //或false,是否异步
                    timeout: 10000,    //超时时间
                    cache: false,
                    error: function (data) {
                        alert(data.message);
                    },
                    success: function (data) {
                        if (data.success) {
                            // close 当前对话框
                            parent.layer.close(parent.layer.getFrameIndex(window.name));
                            parent.location.reload(true);
                        } else {
                            top.hangge();
                            layui.use(['layer', 'form'], function () {
                                layer.msg(data.message, {
                                    time: 2000, //2s后自动关闭
                                    icon: 2
                                });
                            });
                        }
                    }
                });
                $("#zhongxin").hide();
                $("#zhongxin2").show();
            }
        }

        function ismail(mail) {
            return (new RegExp(/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/).test(mail));
        }

        //判断用户名是否存在
        function existUserName() {
            var userName = $.trim($("#userName").val());
            $.ajax({
                type: "POST",
                url: '<%=basePath%>/user/existUserName.do',
                data: getToJsonString($.param({userName: userName, tm: new Date().getTime()})),
                dataType: 'json',
                cache: false,
                success: function (data) {
                    if (data.success) {
                        $.ajax({
                            url: "${action}",
                            data: getToJsonString($('#userForm').serialize()),
                            dataType: "json",
                            type: 'POST',
                            async: true,    //或false,是否异步
                            timeout: 10000,    //超时时间
                            cache: false,
                            error: function (data) {
                                alert(data.message);
                            },
                            success: function (data) {
                                if (data.success) {
                                    // close 当前对话框
                                    parent.layer.close(parent.layer.getFrameIndex(window.name));
                                    parent.location.reload(true);
                                } else {
                                    top.hangge();
                                    layui.use(['layer', 'form'], function () {
                                        layer.msg(data.message, {
                                            time: 2000, //2s后自动关闭
                                            icon: 2
                                        });
                                    });
                                }
                            }
                        });

                        $("#zhongxin").hide();
                        $("#zhongxin2").show();
                    } else {
                        $("#userName").css("background-color", "#D16E6C");
                        setTimeout("$('#userName').val('此用户名已存在!')", 500);
                    }
                }
            });
        }

        //判断邮箱是否存在
        function existEmail(userName) {
            var email = $.trim($("#email").val());

            $.ajax({
                type: "POST",
                url: '<%=basePath%>/user/existEmail.do',
                data: getToJsonString($.param({email: email, userName: userName, tm: new Date().getTime()})),
                dataType: 'json',
                cache: false,
                success: function (data) {
                    if (!data.success) {
                        $("#email").tips({
                            side: 3,
                            msg: '邮箱已存在',
                            bg: '#AE81FF',
                            time: 3
                        });
                        setTimeout("$('#email').val('')", 2000);
                    }
                }
            });
        }

    </script>
</head>
<body>
<form name="userForm" id="userForm">
    <input type="hidden" name="userId" id="userId" value="${user.userId }"/>
    <div id="zhongxin">
        <table>

            <c:if test="${user.roleId != '1'}">
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
            </c:if>
            <c:if test="${user.roleId == '1'}">
                <input name="roleId" id="roleId" value="1" type="hidden"/>
            </c:if>

            <tr>
                <td><input type="text" name="userName" id="userName" value="${user.userName }" maxlength="32"
                           placeholder="这里输入用户名" title="用户名"/></td>
            </tr>
            <tr>
                <td><input type="password" name="password" id="password" maxlength="32" placeholder="输入密码" title="密码"/>
                </td>
            </tr>
            <tr>
                <td><input type="password" name="checkPassword" id="checkPassword" maxlength="32" placeholder="确认密码"
                           title="确认密码"/></td>
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
                           placeholder="这里输入邮箱" title="邮箱" onblur="existEmail('${user.userName }')"/></td>
            </tr>
            <tr>
                <td style="text-align: center;">
                    <a class="btn btn-mini btn-primary" onclick="save();">保存</a>
                    <a class="btn btn-mini btn-danger"
                       onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));">取消</a>
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