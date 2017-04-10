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


    <div id="page-content" class="clearfix">

        <div class="row-fluid">

            <div class="row-fluid">

                <!-- 检索  -->
                <form action="/user.do" method="post" name="userForm" id="userForm">
                    <table>
                        <tr>
                            <td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="userName"
                                   value="${requestMap.userName }" placeholder="这里输入关键词"/>
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
                            </td>
                            <td><input class="span10 date-picker" name="lastLoginStart" id="lastLoginStart"
                                       value="${requestMap.lastLoginStart}" type="text" data-date-format="yyyy-mm-dd"
                                       readonly="readonly" style="width:88px;" placeholder="开始日期" title="最近登录开始"/></td>
                            <td><input class="span10 date-picker" name="lastLoginEnd" name="lastLoginEnd"
                                       value="${requestMap.lastLoginEnd}" type="text" data-date-format="yyyy-mm-dd"
                                       readonly="readonly" style="width:88px;" placeholder="结束日期" title="最近登录结束"/></td>
                            <td style="vertical-align:top;">
                                <select class="chzn-select" name="roleId" id="role_id" data-placeholder="请选择角色"
                                        style="vertical-align:top;width: 120px;">
                                    <option value=""></option>
                                    <option value="">全部</option>
                                    <c:forEach items="${roleList}" var="role">
                                        <option value="${role.roleId }"
                                                <c:if test="${requestMap.roleId==role.roleId}">selected</c:if>>${role.roleName }
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>

                            <td style="vertical-align:top;">
                                <button class="btn btn-mini btn-light" onclick="search();" title="检索"><i
                                        id="nav-search-icon" class="icon-search"></i></button>
                            </td>

                            <c:if test="${permission.exportRights}">
                                <td style="vertical-align:top;"><a class="btn btn-mini btn-light" onclick="toExcel();"
                                                                   title="导出到EXCEL"><i id="nav-search-icon"
                                                                                       class="icon-download-alt"></i></a>
                                </td>
                            </c:if>
                            <c:if test="${permission.importRights}">
                                <td style="vertical-align:top;"><a class="btn btn-mini btn-light" onclick="fromExcel();"
                                                                   title="从EXCEL导入"><i id="nav-search-icon"
                                                                                       class="icon-cloud-upload"></i></a>
                                </td>
                            </c:if>

                        </tr>
                    </table>
                    <!-- 检索  -->


                    <table id="table_report" class="table table-striped table-bordered table-hover">

                        <thead>
                        <tr>
                            <th class="center">
                                <label><input type="checkbox" id="zcheckbox"/><span class="lbl"></span></label>
                            </th>
                            <th>序号</th>
                            <th>编号</th>
                            <th>用户名</th>
                            <th>角色</th>
                            <th>姓名</th>
                            <th>电话</th>
                            <th><i class="icon-envelope"></i>邮箱</th>
                            <th><i class="icon-time hidden-phone"></i>最近登录</th>
                            <th>上次登录IP</th>
                            <th>登录次数</th>
                            <th>禁用</th>
                            <th class="center">操作</th>
                        </tr>
                        </thead>

                        <tbody>

                        <!-- 开始循环 -->
                        <c:choose>
                            <c:when test="${not empty userList}">
                                <c:forEach items="${userList}" var="user" varStatus="vs">

                                    <tr>
                                        <td class='center' style="width: 30px;">
                                            <c:if test="${user.userName == 'admin'}"><label><input type='checkbox'
                                                                                                   name='ids'
                                                                                                   value="${user.userId }"
                                                                                                   id="${user.email }"
                                                                                                   alt="${user.mobile }"/><span
                                                    class="lbl"></span></label></c:if>
                                                <%--<c:if test="${user.userName == 'admin'}"><label><input type='checkbox' disabled="disabled" /><span class="lbl"></span></label></c:if>--%>
                                        </td>
                                        <td class='center' style="width: 30px;">${vs.index+1}</td>
                                        <td>${user.userId }</td>
                                        <td><a>${user.userName }</a></td>
                                        <td>${user.roleName }</td>
                                        <td>${user.trueName }</td>
                                        <td>${user.mobile}</td>
                                        <td>${user.email }&nbsp;<i class="icon-envelope"></i></td>
                                        <td><fmt:formatDate value="${user.lastLoginTime}" type="both"/></td>
                                        <td>${user.loginIp}</td>
                                        <td>${user.loginCount}</td>

                                        <td style="width:60px;" class="center">
                                            <label>
                                                <input type="checkbox" class="ace-switch ace-switch-3"
                                                       id="disabled${vs.index+1}"
                                                       <c:if test="${user.isDisabled}">checked="checked"</c:if>
                                                       onclick="isDisabled(this.id,${user.userId})"/><span
                                                    class="lbl"></span></label></td>

                                        <td style="width: 60px;">
                                            <div class='hidden-phone visible-desktop btn-group'>


                                                <c:if test="${user.userName != 'admin'}">
                                                    <c:if test="${permission.editRights}">
                                                        <a class='btn btn-mini btn-info' title="编辑"
                                                           onclick="editUser('${user.userId }');"><i
                                                                class='icon-edit'></i></a>
                                                    </c:if>
                                                </c:if>

                                                <c:if test="${user.userName!='admin'}">
                                                    <c:if test="${permission.deleteRights}">
                                                        <a class='btn btn-mini btn-danger' title="删除"
                                                           onclick="delUser('${user.userId }','${user.userName }');"><i
                                                                class='icon-trash'></i></a>
                                                    </c:if>
                                                </c:if>

                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr class="main_info">
                                    <td colspan="13" class="center">没有相关数据</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>


                        </tbody>
                    </table>

                    <div class="page-header position-relative">
                        <table style="width:100%;">
                            <tr>
                                <td style="vertical-align:top;">
                                    <c:if test="${permission.addRights}">
                                        <a class="btn btn-small btn-success" onclick="add();">新增</a>
                                    </c:if>
                                    <c:if test="${permission.deleteRights}">
                                        <a title="批量删除" class="btn btn-small btn-danger"
                                           onclick="makeAll('确定要删除选中的数据吗?');"><i class='icon-trash'></i></a>
                                    </c:if>
                                </td>
                                <td style="vertical-align:top;">
                                    <div class="pagination"
                                         style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </form>
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
<script type="text/javascript">window.jQuery || document.write("<script src='//cdn.bootcss.com/jquery/1.8.3/jquery.min.js'>\x3C/script>");</script>
<script src="//cdn.bootcss.com/bootstrap/2.3.0/bootstrap.min.js"></script>
<script src="/resource/common/ace/ace-elements.min.js"></script>
<script src="/resource/common/ace/ace.min.js"></script>

<script type="text/javascript" src="//cdn.bootcss.com/chosen/1.6.2/chosen.jquery.min.js"></script><!-- 下拉框 -->
<script type="text/javascript"
        src="//cdn.bootcss.com/bootstrap-datepicker/1.7.0-RC1/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->

<!-- 引入 -->
<script type="text/javascript" src="/resource/common/js/jquery.tips.js"></script><!--提示框-->
<script type="text/javascript">

    $(top.hangge());

    /**
     * 是否禁用
     */
    function isDisabled(id, userId) {

        var checkedStatus = $("#" + id).attr("checked");
        var status = "true";
        if (checkedStatus == 'checked') {
            status = 'true';
        } else {
            status = 'false';
        }
        console.log(status);

        var url = "<%=basePath%>/user/disabled.do?userId=" + userId + "&value=" + status + "&tm=" + new Date().getTime();
        $.get(url, function (data) {
            if (data.success) {
//                window.location.href = "user.do";
            } else {
                top.hangge();
                layer.msg(data.message, {
                    time: 2000, //2s后自动关闭
                    icon: 2
                });
                window.location.href = "user.do";
            }
        });
    }

    //检索
    function search() {
        top.jzts();
        $("#userForm").submit();
    }

    //新增
    function add() {
        top.jzts();
        layui.use(['layer', 'form'], function () {
            layer.open({
                type: 2,
                title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>新增账户',
                skin: 'layui-layer-lan', //加上边框
                area: ['250px', '450px'], //宽高
                content: '<%=basePath%>/user/toAdd.do',
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        });
    }

    //修改
    function editUser(user_id) {
        top.jzts();
        layui.use(['layer', 'form'], function () {
            layer.open({
                type: 2,
                title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>编辑账户',
                skin: 'layui-layer-lan', //加上边框
                area: ['250px', '450px'], //宽高
                content: '<%=basePath%>/user/toEdit.do?userId=' + user_id,
                cancel: function (index, layero) {
                    layer.close(index)
                }
            });
        });
    }

    //删除
    function delUser(userId, msg) {
        layui.use(['layer', 'form'], function () {
            //询问框
            layer.confirm('确定要删除[' + msg + ']吗?', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                top.jzts();
                var url = "<%=basePath%>/user/delete.do?userId=" + userId + "&tm=" + new Date().getTime();
                $.get(url, function (data) {
                    if (data.success) {
                        window.location.href = "user.do";
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

    //批量操作
    function makeAll(msg) {
        bootbox.confirm(msg, function (result) {
            if (result) {
                var str = '';
                var emstr = '';
                var phones = '';
                for (var i = 0; i < document.getElementsByName('ids').length; i++) {
                    if (document.getElementsByName('ids')[i].checked) {
                        if (str == '') str += document.getElementsByName('ids')[i].value;
                        else str += ',' + document.getElementsByName('ids')[i].value;

                        if (emstr == '') emstr += document.getElementsByName('ids')[i].id;
                        else emstr += ';' + document.getElementsByName('ids')[i].id;

                        if (phones == '') phones += document.getElementsByName('ids')[i].alt;
                        else phones += ';' + document.getElementsByName('ids')[i].alt;
                    }
                }
                if (str == '') {
                    bootbox.dialog("您没有选择任何内容!",
                        [
                            {
                                "label": "关闭",
                                "class": "btn-small btn-success",
                                "callback": function () {
                                    //Example.show("great success");
                                }
                            }
                        ]
                    );

                    $("#zcheckbox").tips({
                        side: 3,
                        msg: '点这里全选',
                        bg: '#AE81FF',
                        time: 8
                    });

                    return;
                } else {
                    if (msg == '确定要删除选中的数据吗?') {
                        top.jzts();
                        $.ajax({
                            type: "POST",
                            url: '<%=basePath%>user/deleteAllU.do?tm=' + new Date().getTime(),
                            data: {USER_IDS: str},
                            dataType: 'json',
                            //beforeSend: validateData,
                            cache: false,
                            success: function (data) {
                                $.each(data.list, function (i, list) {
                                    nextPage(${page.pageNum});
                                });
                            }
                        });
                    } else if (msg == '确定要给选中的用户发送邮件吗?') {
                        sendEmail(emstr);
                    } else if (msg == '确定要给选中的用户发送短信吗?') {
                        sendSms(phones);
                    }


                }
            }
        });
    }

</script>

<script type="text/javascript">

    $(function () {

        //日期框
        $('.date-picker').datepicker();

        //下拉框
        $(".chzn-select").chosen();
        $(".chzn-select-deselect").chosen({allow_single_deselect: true});

        //复选框
        $('table th input:checkbox').on('click', function () {
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function () {
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });

        });

    });

    //导出excel
    function toExcel() {
        var USERNAME = $("#nav-search-input").val();
        var lastLoginStart = $("#lastLoginStart").val();
        var lastLoginEnd = $("#lastLoginEnd").val();
        var ROLE_ID = $("#role_id").val();
        window.location.href = '<%=basePath%>user/excel.do?USERNAME=' + USERNAME + '&lastLoginStart=' + lastLoginStart + '&lastLoginEnd=' + lastLoginEnd + '&ROLE_ID=' + ROLE_ID;
    }

    //打开上传excel页面
    function fromExcel() {
        top.jzts();
        var diag = new top.Dialog();
        diag.Drag = true;
        diag.Title = "EXCEL 导入到数据库";
        diag.URL = '<%=basePath%>user/goUploadExcel.do';
        diag.Width = 300;
        diag.Height = 150;
        diag.CancelEvent = function () { //关闭事件
            if (diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none') {
                if ('${page.pageNum}' == '0') {
                    top.jzts();
                    setTimeout("self.location.reload()", 100);
                } else {
                    nextPage(${page.pageNum});
                }
            }
            diag.close();
        };
        diag.show();
    }

</script>

</body>
</html>

