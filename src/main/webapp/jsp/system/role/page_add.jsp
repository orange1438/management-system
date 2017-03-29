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

    <!--引入弹窗组件start-->
    <link rel="stylesheet" href="/resource/plugins/layui/css/layui.css"/>
    <script type="text/javascript" src="/resource/plugins/layui/layui.js"></script>

    <script type="text/javascript" src="/resource/common/js/getToJson.js"></script>

    <script type="text/javascript">
        top.hangge();
        //保存
        function save() {
            if ($("#roleName").val() == "") {
                $("#roleName").focus();
                return false;
            }

            $.ajax({
                url: "${page.action}",
                data: getToJsonString($('#form1').serialize()),
                dataType: "json",
                type: 'POST',
                async: true,    //或false,是否异步
                timeout: 10000,    //超时时间
                cache: false,
                error: function (data) {
                    alert(data.message);
                },
                success: function (data) {
                    // close 当前对话框
                    parent.layer.close(parent.layer.getFrameIndex(window.name));
                    parent.location.reload(true);
                }
            });

            $("#zhongxin").hide();
            $("#zhongxin2").show();
        }


    </script>
</head>
<body>
<form name="form1" id="form1">
    <input name="parentId" id="parentId" value="${page.parentId}" type="hidden">
    <div id="zhongxin">
        <table>
            <tr>
                <td><input type="text" name="Name" id="roleName" placeholder="这里输入${page.name}名称"
                           title="${page.name}名称"/></td>
            </tr>
            <tr>
                <td><input type="text" name="Description" id="roleDescription" placeholder="这里输入${page.name}描述"
                           title="${page.name}描述"/></td>
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
</form>

<div id="zhongxin2" class="center" style="display:none"><img src="/resource/common/images/jzx.gif"
                                                             style="width: 50px;"/><br/><h4
        class="lighter block green"></h4></div>
<!-- 引入 -->

<script type="text/javascript">window.jQuery || document.write("<script src='//cdn.bootcss.com/jquery/1.8.3/jquery.min.js'>\x3C/script>");</script>
<script src="//cdn.bootcss.com/bootstrap/2.3.0/bootstrap.min.js"></script>
<script src="/resource/common/ace/ace-elements.min.js"></script>
<script src="/resource/common/ace/ace.min.js"></script>
</body>
</html>
