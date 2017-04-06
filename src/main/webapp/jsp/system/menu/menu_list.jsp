<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
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

    <script type="text/javascript">
        $(top.hangge());

        //新增
        function addMenu() {
            top.jzts();
            layui.use(['layer', 'form'], function () {
                layer.open({
                    type: 2,
                    title: '<i class="layui-icon" style="font-size: 15px;">&#xe654;</i>新增菜单',
                    skin: 'layui-layer-lan', //加上边框
                    area: ['245px', '291px'], //宽高
                    scrollbar: false,
                    content: '<%=basePath%>/menu/toAdd.do',
                    cancel: function (index, layero) {
                        layer.close(index)
                    }
                });
            });
        }

        //修改
        function editMenu(menuId) {
            top.jzts();
            layui.use(['layer', 'form'], function () {
                layer.open({
                    type: 2,
                    title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>编辑菜单',
                    skin: 'layui-layer-lan', //加上边框
                    area: ['245px', '291px'], //宽高
                    scrollbar: false,
                    content: '<%=basePath%>/menu/toEdit.do?menuId=' + menuId,
                    cancel: function (index, layero) {
                        layer.close(index)
                    }
                });
            });

        }

        //编辑顶部菜单图标
        function editTb(menuId) {
            top.jzts();
            layui.use(['layer', 'form'], function () {
                layer.open({
                    type: 2,
                    title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>编辑图标',
                    skin: 'layui-layer-lan', //加上边框
                    area: ['530px', '200x'], //宽高
                    content: '<%=basePath%>/menu/toEditIcon.do?menuId=' + menuId,
                    cancel: function (index, layero) {
                        layer.close(index)
                    }
                });
            });
        }

        //删除菜单
        function delMenu(menuId, isParent) {
            var msg = '确定要删除该菜单吗?';
            if (isParent) {
                msg = msg + '其下子菜单将一并删除！';
            }
            layui.use(['layer', 'form'], function () {
                //询问框
                layer.confirm(msg, {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    top.jzts();
                    var url = "<%=basePath%>/menu/del.do?menuId=" + menuId + "&guid=" + new Date().getTime();
                    $.get(url, function (data) {
                        if (data.success) {
                            document.location.reload();
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

        function openClose(menuId, curObj, trIndex) {
            var txt = $(curObj).text();
            if (txt == "展开") {
                $(curObj).text("折叠");
                $("#tr" + menuId).after("<tr id='tempTr" + menuId + "'><td colspan='5' class='center'>数据载入中</td></tr>");
                if (trIndex % 2 == 0) {
                    $("#tempTr" + menuId).addClass("main_table_even");
                }
                var url = "<%=basePath%>/menu/sub.do?menuId=" + menuId + "&guid=" + new Date().getTime();
                $.get(url, function (data) {
                    if (data.length > 0) {
                        var html = "";
                        $.each(data, function (i) {
                            html = "<tr style='height:24px;line-height:24px;' name='subTr" + menuId + "'>";
                            html += "<td></td>";
                            html += "<td class='center'><span style='width:80px;display:inline-block;'></span>";
                            if (i == data.length - 1)
                                html += "<img src='/resource/page/menu/images/joinbottom.gif' style='vertical-align: middle;'/>";
                            else
                                html += "<img src='/resource/page/menu/images/join.gif' style='vertical-align: middle;'/>";
                            html += "<span style='width:100px;text-align:left;display:inline-block;'>" + this.menuName + "</span>";
                            html += "</td>";
                            html += "<td class='center'>" + this.menuUrl + "</td>";
                            html += "<td class='center'>" + this.menuOrder + "</td>";
                            html += "<td><a class='btn btn-mini btn-info' title='编辑' onclick='editMenu(\"" + this.menuId + "\")'><i class='icon-edit'></i></a> <a class='btn btn-mini btn-danger' title='删除' onclick='delMenu(\"" + this.menuId + "\",false)'><i class='icon-trash'></i></a></td>";
                            html += "</tr>";
                            $("#tempTr" + menuId).before(html);
                        });
                        $("#tempTr" + menuId).remove();
                        if (trIndex % 2 == 0) {
                            $("tr[name='subTr" + menuId + "']").addClass("main_table_even");
                        }
                    } else {
                        $("#tempTr" + menuId + " > td").html("没有相关数据");
                    }
                }, "json");
            } else {
                $("#tempTr" + menuId).remove();
                $("tr[name='subTr" + menuId + "']").remove();
                $(curObj).text("展开");
            }
        }
    </script>
</head>

<body>
<table id="table_report" class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
        <th class="center" style="width: 50px;">序号</th>
        <th class='center'>名称</th>
        <th class='center'>资源路径</th>
        <th class='center'>排序</th>
        <th class='center'>操作</th>
    </tr>
    </thead>
    <c:choose>
        <c:when test="${not empty menuList}">
            <c:forEach items="${menuList}" var="menu" varStatus="vs">
                <tr id="tr${menu.menuId }">
                    <td class="center">${vs.index+1}</td>
                    <td class='center'><i class="${menu.menuIcon}">&nbsp;</i>${menu.menuName }&nbsp;
                        <c:if test="${menu.menuType == '1' }">
                            <span class="label label-success arrowed">系统</span>
                        </c:if>
                        <c:if test="${menu.menuType != '1' }">
                            <span class="label label-important arrowed-in">业务</span>
                        </c:if>

                    </td>
                    <td>${menu.menuUrl == '#'? '': menu.menuUrl}</td>
                    <td class='center'>${menu.menuOrder }</td>
                    <td style="width: 25%;">
                        <a class='btn btn-mini btn-warning'
                           onclick="openClose('${menu.menuId }',this,${vs.index })">展开</a>
                        <a class='btn btn-mini btn-purple' title="图标" onclick="editTb('${menu.menuId }')"><i
                                class='icon-picture'></i></a>

                        <c:if test="${permission.editRights}">
                        <a class='btn btn-mini btn-info' title="编辑" onclick="editMenu('${menu.menuId }')"><i
                                class='icon-edit'></i></a>
                        </c:if>
                        <c:if test="${permission.deleteRights}">
                        <a class='btn btn-mini btn-danger' title="删除" onclick="delMenu('${menu.menuId }',true)"><i
                                class='icon-trash'></i></a>
                        </c:if>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="100">没有相关数据</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

<div class="page_and_btn">
    <div>
        &nbsp;&nbsp;
        <c:if test="${permission.addRights}">
            <a class="btn btn-small btn-success" onclick="addMenu();">新增</a>
        </c:if>
    </div>
</div>

</body>
</html>