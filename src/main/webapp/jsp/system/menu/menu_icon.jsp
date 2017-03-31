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

    <!--引入弹窗组件start-->
    <link rel="stylesheet" href="/resource/plugins/layui/css/layui.css"/>
    <script type="text/javascript" src="/resource/plugins/layui/layui.js"></script>

    <script type="text/javascript" src="//cdn.bootcss.com/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="/resource/common/js/getToJson.js"></script>

    <script type="text/javascript">

        $(top.hangge());
        //保存
        function save() {
            if ($("#menuIcon").val() == "") {
                alert('请选择图标');
                return false;
            }

            $.ajax({
                url: "/menu/editIcon.do",
                data: getToJsonString($('#menuForm').serialize()),
                dataType: "json",
                type: 'POST',
                async: true,    //或false,是否异步
                timeout: 10000,    //超时时间
                cache: false,
                error: function (data) {
                    alert(data);
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
        function seticon(icon) {
            $("#menuIcon").val(icon);
        }

    </script>

</head>

<body>
<form name="menuForm" id="menuForm">
    <input type="hidden" name="menuId" id="menuId" value="${menuId}"/>
    <input type="hidden" name="menuIcon" id="menuIcon" value=""/>
    <div id="zhongxin">
        <table id="table_report" class="table table-striped table-bordered table-hover">
            <tr>
                <td><label onclick="seticon('icon-desktop');"><input name="form-field-radio" type="radio"
                                                                     value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-desktop"></i></span></label></td>
                <td><label onclick="seticon('icon-list');"><input name="form-field-radio" type="radio"
                                                                  value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-list"></i></span></label></td>
                <td><label onclick="seticon('icon-edit');"><input name="form-field-radio" type="radio"
                                                                  value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-edit"></i></span></label></td>
                <td><label onclick="seticon('icon-list-alt');"><input name="form-field-radio" type="radio"
                                                                      value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-list-alt"></i></span></label></td>
                <td><label onclick="seticon('icon-calendar');"><input name="form-field-radio" type="radio"
                                                                      value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-calendar"></i></span></label></td>
                <td><label onclick="seticon('icon-picture');"><input name="form-field-radio" type="radio"
                                                                     value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-picture"></i></span></label></td>
                <td><label onclick="seticon('icon-th');"><input name="form-field-radio" type="radio"
                                                                value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-th"></i></span></label></td>
                <td><label onclick="seticon('icon-file');"><input name="form-field-radio" type="radio"
                                                                  value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-file"></i></span></label></td>
                <td><label onclick="seticon('icon-folder-open');"><input name="form-field-radio" type="radio"
                                                                         value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-folder-open"></i></span></label></td>
            </tr>
            <tr>
                <td><label onclick="seticon('icon-book');"><input name="form-field-radio" type="radio"
                                                                  value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-book"></i></span></label></td>
                <td><label onclick="seticon('icon-cogs');"><input name="form-field-radio" type="radio"
                                                                  value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-cogs"></i></span></label></td>
                <td><label onclick="seticon('icon-comments');"><input name="form-field-radio" type="radio"
                                                                      value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-comments"></i></span></label></td>
                <td><label onclick="seticon('icon-envelope-alt');"><input name="form-field-radio" type="radio"
                                                                          value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-envelope-alt"></i></span></label></td>
                <td><label onclick="seticon('icon-film');"><input name="form-field-radio" type="radio"
                                                                  value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-film"></i></span></label></td>
                <td><label onclick="seticon('icon-heart');"><input name="form-field-radio" type="radio"
                                                                   value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-heart"></i></span></label></td>
                <td><label onclick="seticon('icon-lock');"><input name="form-field-radio" type="radio"
                                                                  value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-lock"></i></span></label></td>
                <td><label onclick="seticon('icon-exclamation-sign');"><input name="form-field-radio" type="radio"
                                                                              value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-exclamation-sign"></i></span></label></td>
                <td><label onclick="seticon('icon-facetime-video');"><input name="form-field-radio" type="radio"
                                                                            value="icon-edit"><span class="lbl">&nbsp;<i
                        class="icon-facetime-video"></i></span></label></td>
            </tr>
            <tr>
                <td style="text-align: center;" colspan="100">
                    <a class="btn btn-mini btn-primary" onclick="save();">保存</a>
                    <a class="btn btn-mini btn-danger"
                       onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));">取消</a>
                </td>
            </tr>
        </table>
    </div>
    <div id="zhongxin2" class="center" style="display:none"><img src="/resource/common/images/jzx.gif"/></div>
</form>
</body>
</html>