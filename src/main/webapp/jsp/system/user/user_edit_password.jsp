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
            // 不为空，说明是新增
            if ($("#userId").val() != "") {
                $("#userName").attr("readonly", "readonly");
                $("#userName").css("color", "gray");
            }
        });

        //保存
        function save() {
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

    </script>
</head>
<body>
<form name="userForm" id="userForm">
    <input type="hidden" name="userId" id="userId" value="${user.userId }"/>
    <div id="zhongxin">
        <table>

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

</body>
</html>