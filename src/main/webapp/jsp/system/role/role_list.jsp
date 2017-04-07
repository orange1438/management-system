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
    <!-- jsp文件头和头部 -->
    <%@ include file="../admin/top.jsp" %>
</head>
<body>

<div class="container-fluid" id="main-container">

    <div id="page-content">

        <div class="row-fluid">

            <div class="row-fluid">

                <div>
                    <div id="breadcrumbs">
                        <table class="center" style="width:100%;">
                            <tr height="35">

                                <c:if test="${permission.addRights}">
                                <td style="width:69px;"><a href="javascript:addGroup();"
                                                           class="btn btn-small btn-success">新增</a></td>
                                </c:if>

                                <c:choose>
                                <c:when test="${not empty groupList}">
                                <c:forEach items="${groupList}" var="group" varStatus="vs">
                                <td style="width:100px;" class="center"
                                        <c:choose>
                                            <c:when test="${currentGroup.groupId == group.groupId}">bgcolor="#FFC926"
                                                onMouseOut="javascript:this.bgColor='#FFC926';" </c:when>
                                            <c:otherwise>bgcolor="#E5E5E5"
                                                onMouseOut="javascript:this.bgColor='#E5E5E5';"</c:otherwise>
                                        </c:choose> onMouseMove="javascript:this.bgColor='#FFC926';">
                                    <a href="role.do?groupId=${group.groupId }"
                                       style="text-decoration:none; display:block;">
                                        <li class=" icon-group"></li>
                                        &nbsp;<font color="#666666">${group.groupName}</font></a>
                                </td>
                                <td style="width:5px;"></td>
                                </c:forEach>
                                </c:when>
                                <c:otherwise>
                            <tr>
                                <td colspan="100">没有相关数据</td>
                            </tr>
                            </c:otherwise>
                            </c:choose>
                            <td></td>
                            </tr>
                        </table>
                    </div>
                    <table>
                        <tr height="7px;">
                            <td colspan="100"></td>
                        </tr>
                        <tr>
                            <td><font color="#808080">本组：</font></td>
                            <td>
                                <c:if test="${permission.editRights}">
                                    <a class="btn btn-mini btn-info" onclick="editGroup('${currentGroup.groupId}');">修改组名称<i
                                            class="icon-arrow-right  icon-on-right"></i></a>


                                    <a class="btn btn-mini btn-purple"
                                       onclick="groupRights('${currentGroup.groupId}');"><i
                                            class="icon-pencil"></i>组菜单权限</a>
                                </c:if>

                                <c:if test="${permission.deleteRights}">
                                    <a class='btn btn-mini btn-danger' title="删除"
                                       onclick="delGroup('${currentGroup.groupId}','${currentGroup.groupName}');">
                                        <i class='icon-trash'></i></a>
                                </c:if>
                            </td>
                        </tr>
                        <tr height="7px;">
                            <td colspan="100"></td>
                        </tr>
                    </table>


                </div>
                <table id="table_report" class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="center">序号</th>
                        <th class="center">角色</th>
                        <c:if test="${permission.editRights}">
                            <th class="center" bgcolor="#FFBF00">增加</th>
                            <th class="center">删除</th>
                            <th class="center" bgcolor="#BFEFFF">修改</th>
                            <th class="center">详细</th>
                            <th class="center" bgcolor="#EFFFBF">导入</th>
                            <th class="center">导出</th>
                            <th class="center" bgcolor="#EFBFFF">菜单</th>
                        </c:if>
                        <th style="width:155px;" class="center">操作</th>
                    </tr>
                    </thead>
                    <c:choose>
                        <c:when test="${not empty roleList}">
                            <c:forEach items="${roleList}" var="role" varStatus="vs">
                                <tr>
                                    <td class='center' style="width:30px;">${vs.index+1}</td>
                                    <td class='center' id="ROLE_NAMETd${role.roleId}">${role.roleName }</td>

                                    <c:if test="${permission.editRights}">
                                        <td style="width:30px;"><a onclick="roleRights('${role.roleId }','add','新增');"
                                                                   class="btn btn-warning btn-mini"
                                                                   title="分配新增权限"><i
                                                class="icon-wrench icon-2x icon-only"></i></a></td>
                                        <td style="width:30px;"><a
                                                onclick="roleRights('${role.roleId  }','delete','删除');"
                                                class="btn btn-warning btn-mini"
                                                title="分配删除权限"><i
                                                class="icon-wrench icon-2x icon-only"></i></a></td>
                                        <td style="width:30px;"><a
                                                onclick="roleRights('${role.roleId }','edit');"
                                                class="btn btn-warning btn-mini" title="分配修改权限"><i
                                                class="icon-wrench icon-2x icon-only"></i></a></td>
                                        <td style="width:30px;"><a onclick="roleRights('${role.roleId }','view','详细');"
                                                                   class="btn btn-warning btn-mini"
                                                                   title="分配详细权限"><i
                                                class="icon-wrench icon-2x icon-only"></i></a></td>
                                        <td style="width:30px;"><a
                                                onclick="roleRights('${role.roleId }','import','导入');"
                                                class="btn btn-warning btn-mini"
                                                title="分配导入权限"><i
                                                class="icon-wrench icon-2x icon-only"></i></a></td>
                                        <td style="width:30px;"><a
                                                onclick="roleRights('${role.roleId }','export','导出');"
                                                class="btn btn-warning btn-mini"
                                                title="分配导出权限"><i
                                                class="icon-wrench icon-2x icon-only"></i></a></td>

                                        <td style="width:30px;"><a onclick="roleRights('${role.roleId }','menu','菜单');"
                                                                   class="btn btn-warning btn-mini"
                                                                   title="分配菜单权限"><i
                                                class="icon-wrench icon-2x icon-only"></i></a></td>
                                    </c:if>
                                    <td style="width:155px;">

                                        <c:if test="${permission.editRights}">
                                        <a class='btn btn-mini btn-info' title="编辑"
                                           onclick="editRole('${role.roleId }');"><i class='icon-edit'></i></a>
                                        </c:if>

                                        <c:if test="${permission.deleteRights}">
                                        <a class='btn btn-mini btn-danger' title="删除"
                                           onclick="delRole('${role.roleId }','${role.roleName }');"><i
                                                class='icon-trash'></i></a>
                                        </c:if>

                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="100" class="center">没有相关数据</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </table>

                <div class="page-header position-relative">

                    <table style="width:100%;">
                        <tr>
                            <c:if test="${permission.addRights}">
                                <td style="vertical-align:top;"><a class="btn btn-small btn-success"
                                                                   onclick="addRole('${currentGroup.groupId}');">新增</a>
                                </td>
                            </c:if>
                        </tr>
                    </table>

                </div>
            </div>


            <!-- PAGE CONTENT ENDS HERE -->
        </div><!--/row-->

    </div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->

<!-- 返回顶部  -->
<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
    <i class="icon-double-angle-up icon-only"></i>
</a>

<!-- 引入 -->
<script type="text/javascript" src="//cdn.bootcss.com/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">window.jQuery || document.write("<script src='//cdn.bootcss.com/jquery/1.8.3/jquery.min.js'>\x3C/script>");</script>
<script src="//cdn.bootcss.com/bootstrap/2.3.0/bootstrap.min.js"></script>
<script src="/resource/common/ace/ace-elements.min.js"></script>
<script src="/resource/common/ace/ace.min.js"></script>

<!--引入弹窗组件start-->
<link rel="stylesheet" href="/resource/plugins/layui/css/layui.css"/>
<script type="text/javascript" src="/resource/plugins/layui/layui.js"></script>

<!-- 引入组 -->
<script type="text/javascript">

    top.hangge();

    //新增组
    function addGroup() {
        top.jzts();

        layui.use(['layer', 'form'], function () {
            layer.open({
                type: 2,
                title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>新增组',
                skin: 'layui-layer-lan', //加上边框
                area: ['222px', '200px'], //宽高
                content: '<%=basePath%>/group/toAdd.do?parentId=0',
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        });
    }
    // 编辑组
    function editGroup(groupId) {
        top.jzts();
        layui.use(['layer', 'form'], function () {
            layer.open({
                type: 2,
                title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>编辑组',
                skin: 'layui-layer-lan', //加上边框
                area: ['222px', '200px'], //宽高
                content: '<%=basePath%>/group/toEdit.do?groupId=' + groupId,
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        });
    }

    //删除组
    function delGroup(groupId, groupName) {
        layui.use(['layer', 'form'], function () {
            //询问框
            layer.confirm('确定要删除[' + groupName + ']吗?', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                top.jzts();
                var url = "<%=basePath%>/group/delete.do?groupId=" + groupId + "&guid=" + new Date().getTime();
                $.get(url, function (data) {
                    if (data.success) {
                        window.location.href = "role.do";
                    } else {
                        top.hangge();
                        layer.msg(data.message, {
                            time: 2000, //2s后自动关闭
                            icon: 2
                        });
                    }
                });
            });
        });
    }

    //组菜单权限
    function groupRights(groupId) {
        top.jzts();
        layui.use(['layer', 'form'], function () {
            layer.open({
                type: 2,
                title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>组菜单权限',
                skin: 'layui-layer-lan', //加上边框
                area: ['300px', '400px'], //宽高
                content: '<%=basePath%>/group/toAuth.do?groupId=' + groupId,
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        });
    }

</script>

<!-- 引入角色 -->
<script type="text/javascript">
    //新增角色
    function addRole(groupId) {
        top.jzts();
        layui.use(['layer', 'form'], function () {
            layer.open({
                type: 2,
                title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>新增角色',
                skin: 'layui-layer-lan', //加上边框
                area: ['222px', '200px'], //宽高
                content: '<%=basePath%>/role/toAdd.do?parentId=' + groupId,
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        });
    }

    //修改角色
    function editRole(roleId) {
        top.jzts();
        layui.use(['layer', 'form'], function () {
            layer.open({
                type: 2,
                title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>编辑角色',
                skin: 'layui-layer-lan', //加上边框
                area: ['222px', '200px'], //宽高
                content: '<%=basePath%>/role/toEdit.do?roleId=' + roleId,
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        });
    }

    //删除角色
    function delRole(roleId, roleName) {
        layui.use(['layer', 'form'], function () {
            //询问框
            layer.confirm('确定要删除[' + roleName + ']吗?', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                top.jzts();
                var url = "<%=basePath%>/role/delete.do?roleId=" + roleId + "&guid=" + new Date().getTime();
                $.get(url, function (data) {
                    if (data.success) {
                        window.location.href = "role.do";
                    } else {
                        top.hangge();
                        layer.msg(data.message, {
                            time: 2000, //2s后自动关闭
                            icon: 2
                        });
                    }
                });
            });
        });
    }

    //角色菜单权限
    // type:add,delete,edit,view,import,export,menu
    function roleRights(roleId, type, msg) {
        top.jzts();
        layui.use(['layer', 'form'], function () {
            layer.open({
                type: 2,
                title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>角色' + msg + '权限',
                skin: 'layui-layer-lan', //加上边框
                area: ['300px', '400px'], //宽高
                content: '<%=basePath%>/role/toAuth.do?roleId=' + roleId + '&type=' + type,
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        });
    }
</script>
</body>
</html>

