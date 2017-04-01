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

    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/2.3.0/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="/resource/common/css/font-awesome.min.css"/>

    <link type="text/css" rel="stylesheet" href="/resource/plugins/zTree/2.6/zTreeStyle.css"/>
    <link rel="stylesheet" href="/resource/common/ace/ace.min.css"/>
    <link rel="stylesheet" href="/resource/common/ace/ace-responsive.min.css"/>
    <link rel="stylesheet" href="/resource/common/ace/ace-skins.min.css"/>


    <style type="text/css">
        footer {
            height: 50px;
            position: fixed;
            bottom: 0px;
            left: 0px;
            width: 100%;
            text-align: center;
        }
    </style>

</head>
<body>
<div id="zhongxin">
    <ul id="tree" class="tree" style="overflow:auto;"></ul>
</div>
<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img
        src="/resource/common/images/jiazai.gif"/><br/>
    <h4 class="lighter block green"></h4></div>


<script type="text/javascript" src="//cdn.bootcss.com/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="/resource/plugins/zTree/2.6/jquery.ztree-2.6.min.js"></script>

<script type="text/javascript">
    $(top.hangge());
    var zTree;
    $(document).ready(function () {

        var setting = {
            showLine: true,
            checkable: true
        };
        var zn = '${zTreeNodes}';
        var zTreeNodes = eval(zn);
        zTree = $("#tree").zTree(setting, zTreeNodes);
    });
</script>
<script type="text/javascript">

    function save() {

        var nodes = zTree.getCheckedNodes();
        var tmpNode;
        var ids = "";
        for (var i = 0; i < nodes.length; i++) {
            tmpNode = nodes[i];
            if (i != nodes.length - 1) {
                ids += tmpNode.id + ",";
            } else {
                ids += tmpNode.id;
            }
        }
        <c:if test="${page=='group'}">
        var groupId = "${groupId}";
        var url = "<%=basePath%>/group/auth.do";
        var postData = {"groupId": groupId, "menuIds": ids};
        </c:if>

        <c:if test="${page=='role'}">
        var roleId = "${roleId}";
        var type = "${type}";
        var url = "<%=basePath%>/role/auth.do";
        var postData = {"roleId": roleId, "type": type, "menuIds": ids};
        </c:if>

        $("#zhongxin").hide();
        $("#zhongxin2").show();
        $.post(url, postData, function (data) {
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
        });

    }

</script>
<footer>
    <div style="width: 100%;" class="center">
        <a class="btn btn-mini btn-primary" onclick="save();">保存</a>
        <a class="btn btn-mini btn-danger" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));">取消</a>
    </div>
</footer>
</body>
</html>