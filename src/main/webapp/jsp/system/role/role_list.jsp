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

                                <td style="width:69px;"><a href="javascript:addGroup();"
                                                           class="btn btn-small btn-success">新增</a></td>

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
                                <a class="btn btn-mini btn-info" onclick="editGroup('${currentGroup.groupId}');">修改组名称<i
                                        class="icon-arrow-right  icon-on-right"></i></a>

                                <a class="btn btn-mini btn-purple"
                                   onclick="editRights('${currentGroup.groupId}');"><i class="icon-pencil"></i>组菜单权限</a>


                                <a class='btn btn-mini btn-danger' title="删除"
                                   onclick="delRole('${currentGroup.groupId}','z','${currentGroup.groupName}');"><i
                                        class='icon-trash'></i></a>
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
                        <th>角色</th>
                        <th class="center" bgcolor="#FFBF00">增加</th>
                        <th class="center">删除</th>
                        <th class="center" bgcolor="#BFEFFF">修改</th>
                        <th class="center">详细</th>
                        <th class="center" bgcolor="#EFFFBF">导入</th>
                        <th class="center">导出</th>
                        <th class="center" bgcolor="#EFBFFF">菜单</th>
                        <th style="width:155px;" class="center">操作</th>
                    </tr>
                    </thead>
                    <c:choose>
                        <c:when test="${not empty roleList}">
                            <c:forEach items="${roleList}" var="role" varStatus="vs">
                                <tr>
                                    <td class='center' style="width:30px;">${vs.index+1}</td>
                                    <td id="ROLE_NAMETd${role.roleId}">${role.roleName }</td>

                                    <td style="width:30px;"><a onclick="roleButton('${role.roleId }','add_qx');"
                                                               class="btn btn-warning btn-mini"
                                                               title="分配新增权限"><i
                                            class="icon-wrench icon-2x icon-only"></i></a></td>
                                    <td style="width:30px;"><a onclick="roleButton('${role.roleId  }','del_qx');"
                                                               class="btn btn-warning btn-mini"
                                                               title="分配删除权限"><i
                                            class="icon-wrench icon-2x icon-only"></i></a></td>
                                    <td style="width:30px;"><a
                                            onclick="roleButton('${role.roleId }','edit_qx');"
                                            class="btn btn-warning btn-mini" title="分配修改权限"><i
                                            class="icon-wrench icon-2x icon-only"></i></a></td>
                                    <td style="width:30px;"><a onclick="roleButton('${role.roleId }','cha_qx');"
                                                               class="btn btn-warning btn-mini"
                                                               title="分配详细权限"><i
                                            class="icon-wrench icon-2x icon-only"></i></a></td>
                                    <td style="width:30px;"><a onclick="roleButton('${role.roleId }','cha_qx');"
                                                               class="btn btn-warning btn-mini"
                                                               title="分配导入权限"><i
                                            class="icon-wrench icon-2x icon-only"></i></a></td>
                                    <td style="width:30px;"><a onclick="roleButton('${role.roleId }','cha_qx');"
                                                               class="btn btn-warning btn-mini"
                                                               title="分配导出权限"><i
                                            class="icon-wrench icon-2x icon-only"></i></a></td>

                                    <td style="width:30px;"><a onclick="roleButton('${role.roleId }','cha_qx');"
                                                               class="btn btn-warning btn-mini"
                                                               title="分配菜单权限"><i
                                            class="icon-wrench icon-2x icon-only"></i></a></td>

                                    <td style="width:155px;">

                                        <a class='btn btn-mini btn-info' title="编辑"
                                           onclick="editRole('${role.roleId }');"><i class='icon-edit'></i></a>


                                        <a class='btn btn-mini btn-danger' title="删除"
                                           onclick="delRole('${role.roleId }','c','${role.roleName }');"><i
                                                class='icon-trash'></i></a>

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
                            <td style="vertical-align:top;"><a class="btn btn-small btn-success"
                                                               onclick="addRole2('${pd.ROLE_ID }');">新增</a></td>
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

<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
<!-- 引入 -->

<script type="text/javascript">

    top.hangge();

    //新增组
    function addGroup() {
        top.jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "新增组";
        diag.URL = '<%=basePath%>/role/toAdd.do?parent_id=0';
        diag.Width = 222;
        diag.Height = 90;
        diag.CancelEvent = function () { //关闭事件
            if (diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none') {
                top.jzts();
                setTimeout("self.location.reload()", 100);
            }
            diag.close();
        };
        diag.show();
    }
    // 编辑组
    function editGroup(groupId) {
        top.jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "编辑";
        diag.URL = '<%=basePath%>role/toEdit.do?groupId=' + groupId;
        diag.Width = 222;
        diag.Height = 90;
        diag.CancelEvent = function () { //关闭事件
            if (diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none') {
                top.jzts();
                setTimeout("self.location.reload()", 100);
            }
            diag.close();
        };
        diag.show();
    }

    //新增角色
    function addRole2(pid) {
        top.jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "新增角色";
        diag.URL = '<%=basePath%>role/toAdd.do?parent_id=' + pid;
        diag.Width = 222;
        diag.Height = 90;
        diag.CancelEvent = function () { //关闭事件
            if (diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none') {
                top.jzts();
                setTimeout("self.location.reload()", 100);
            }
            diag.close();
        };
        diag.show();
    }

    //修改
    function editRole(ROLE_ID) {
        top.jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "编辑";
        diag.URL = '<%=basePath%>role/toEdit.do?ROLE_ID=' + ROLE_ID;
        diag.Width = 222;
        diag.Height = 90;
        diag.CancelEvent = function () { //关闭事件
            if (diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none') {
                top.jzts();
                setTimeout("self.location.reload()", 100);
            }
            diag.close();
        };
        diag.show();
    }

    //删除
    function delRole(ROLE_ID, msg, ROLE_NAME) {
        bootbox.confirm("确定要删除[" + ROLE_NAME + "]吗?", function (result) {
            if (result) {
                var url = "<%=basePath%>role/delete.do?ROLE_ID=" + ROLE_ID + "&guid=" + new Date().getTime();
                top.jzts();
                $.get(url, function (data) {
                    if ("success" == data.result) {
                        if (msg == 'c') {
                            top.jzts();
                            document.location.reload();
                        } else {
                            top.jzts();
                            window.location.href = "role.do";
                        }

                    } else if ("false" == data.result) {
                        top.hangge();
                        bootbox.dialog("删除失败，请先删除此部门下的职位!",
                            [
                                {
                                    "label": "关闭",
                                    "class": "btn-small btn-success",
                                    "callback": function () {
                                        //Example.show("great success");
                                    }
                                }]
                        );
                    } else if ("false2" == data.result) {
                        top.hangge();
                        bootbox.dialog("删除失败，请先删除此职位下的用户!",
                            [
                                {
                                    "label": "关闭",
                                    "class": "btn-small btn-success",
                                    "callback": function () {
                                        //Example.show("great success");
                                    }
                                }]
                        );
                    }
                });
            }
        });
    }

</script>

<script type="text/javascript">


    //扩展权限 ==============================================================
    var hcid1 = '';
    var qxhc1 = '';
    function kf_qx1(id, kefu_id, msg) {
        if (id != hcid1) {
            hcid1 = id;
            qxhc1 = '';
        }
        var value = 1;
        var wqx = $("#" + id).attr("checked");
        if (qxhc1 == '') {
            if (wqx == 'checked') {
                qxhc1 = 'checked';
            } else {
                qxhc1 = 'unchecked';
            }
        }
        if (qxhc1 == 'checked') {
            value = 0;
            qxhc1 = 'unchecked';
        } else {
            value = 1;
            qxhc1 = 'checked';
        }
        var url = "<%=basePath%>role/kfqx.do?kefu_id=" + kefu_id + "&msg=" + msg + "&value=" + value + "&guid=" + new Date().getTime();
        $.get(url, function (data) {
            if (data == "success") {
                //document.location.reload();
            }
        });
    }

    var hcid2 = '';
    var qxhc2 = '';
    function kf_qx2(id, kefu_id, msg) {
        if (id != hcid2) {
            hcid2 = id;
            qxhc2 = '';
        }
        var value = 1;
        var wqx = $("#" + id).attr("checked");
        if (qxhc2 == '') {
            if (wqx == 'checked') {
                qxhc2 = 'checked';
            } else {
                qxhc2 = 'unchecked';
            }
        }
        if (qxhc2 == 'checked') {
            value = 0;
            qxhc2 = 'unchecked';
        } else {
            value = 1;
            qxhc2 = 'checked';
        }
        var url = "<%=basePath%>role/kfqx.do?kefu_id=" + kefu_id + "&msg=" + msg + "&value=" + value + "&guid=" + new Date().getTime();
        $.get(url, function (data) {
            if (data == "success") {
                //document.location.reload();
            }
        });
    }

    var hcid3 = '';
    var qxhc3 = '';
    function kf_qx3(id, kefu_id, msg) {
        if (id != hcid3) {
            hcid3 = id;
            qxhc3 = '';
        }
        var value = 1;
        var wqx = $("#" + id).attr("checked");
        if (qxhc3 == '') {
            if (wqx == 'checked') {
                qxhc3 = 'checked';
            } else {
                qxhc3 = 'unchecked';
            }
        }
        if (qxhc3 == 'checked') {
            value = 0;
            qxhc3 = 'unchecked';
        } else {
            value = 1;
            qxhc3 = 'checked';
        }
        var url = "<%=basePath%>role/kfqx.do?kefu_id=" + kefu_id + "&msg=" + msg + "&value=" + value + "&guid=" + new Date().getTime();
        $.get(url, function (data) {
            if (data == "success") {
                //document.location.reload();
            }
        });
    }

    var hcid4 = '';
    var qxhc4 = '';
    function kf_qx4(id, kefu_id, msg) {
        if (id != hcid4) {
            hcid4 = id;
            qxhc4 = '';
        }
        var value = 1;
        var wqx = $("#" + id).attr("checked");
        if (qxhc4 == '') {
            if (wqx == 'checked') {
                qxhc4 = 'checked';
            } else {
                qxhc4 = 'unchecked';
            }
        }
        if (qxhc4 == 'checked') {
            value = 0;
            qxhc4 = 'unchecked';
        } else {
            value = 1;
            qxhc4 = 'checked';
        }
        var url = "<%=basePath%>role/kfqx.do?kefu_id=" + kefu_id + "&msg=" + msg + "&value=" + value + "&guid=" + new Date().getTime();
        $.get(url, function (data) {
            if (data == "success") {
                //document.location.reload();
            }
        });
    }

    //保存信件数
    function c1(id, msg, value, kefu_id) {
        if (isNaN(Number(value))) {
            alert("请输入数字!");
            $("#" + id).val(0);
            return;
        } else {
            var url = "<%=basePath%>role/gysqxc.do?kefu_id=" + kefu_id + "&msg=" + msg + "&value=" + value + "&guid=" + new Date().getTime();
            $.get(url, function (data) {
                if (data == "success") {
                    //document.location.reload();
                }
            });
        }
    }

    //组菜单权限
    function editRights(ROLE_ID) {
        top.jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "菜单权限";
        diag.URL = '<%=basePath%>role/auth.do?ROLE_ID=' + ROLE_ID;
        diag.Width = 280;
        diag.Height = 370;
        diag.CancelEvent = function () { //关闭事件
            diag.close();
        };
        diag.show();
    }

    //按钮权限
    function roleButton(ROLE_ID, msg) {
        top.jzts();
        if (msg == 'add_qx') {
            var Title = "授权新增权限";
        } else if (msg == 'del_qx') {
            Title = "授权删除权限";
        } else if (msg == 'edit_qx') {
            Title = "授权修改权限";
        } else if (msg == 'cha_qx') {
            Title = "授权查看权限";
        }

        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = Title;
        diag.URL = '<%=basePath%>role/button.do?ROLE_ID=' + ROLE_ID + '&msg=' + msg;
        diag.Width = 200;
        diag.Height = 370;
        diag.CancelEvent = function () { //关闭事件
            diag.close();
        };
        diag.show();
    }

</script>
</body>
</html>

