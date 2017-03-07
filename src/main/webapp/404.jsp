<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 根目录地址，为动静分离资源做准备，可能需要单独的静态服务器而准备的 --%>
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

    <meta name="description" content="404 Error Page"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link href="/resource/common/bootstrap/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resource/common/bootstrap/bootstrap-responsive.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/resource/common/other/css/font-awesome.min.css"/>
    <!-- page specific plugin styles -->
    <!-- ace styles -->
    <link rel="stylesheet" href="/resource/common/other/css/ace.min.css"/>
    <link rel="stylesheet" href="/resource/common/other/css/ace-responsive.min.css"/>
    <link rel="stylesheet" href="/resource/common/other/css/ace-skins.min.css"/>
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="/resource/common/other/css/ace-ie.min.css"/>
    <![endif]-->

<body>
<div class="navbar navbar-inverse">

</div><!--/.navbar-->
<div class="container-fluid" id="main-container">

    <div id="main-content" class="clearfix">

        <div id="page-content" class="clearfix">

            <div class="row-fluid">
                <!-- PAGE CONTENT BEGINS HERE -->
                <div class="error-container">
                    <div class="well">
                        <h1 class="grey lighter smaller">
                            <span class="blue bigger-125"><i class="icon-sitemap"></i> 404</span> 没有找到此页面
                        </h1>
                        <hr/>
                        <h3 class="lighter smaller">We looked everywhere but we couldn't find it!</h3>

                        <div>

                            <div class="space"></div>

                            <h4 class="smaller">Try one of the following:</h4>
                            <ul class="unstyled spaced inline bigger-110">
                                <li><i class="icon-hand-right blue"></i> 检查路径是不是有误</li>
                                <li><i class="icon-hand-right blue"></i> 检查代码是不是有误</li>
                                <li><i class="icon-hand-right blue"></i> 检查环境配置是不是有误</li>
                            </ul>
                        </div>

                        <hr/>
                        <div class="space"></div>

                        <div class="row-fluid">
                            <div id="zhongxin">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- PAGE CONTENT ENDS HERE -->
            </div><!--/row-->

        </div><!--/#page-content-->

    </div><!-- #main-content -->
</div><!--/.fluid-container#main-container-->
<!-- basic scripts -->
<script src="/resource/common/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/resource/common/jquery/jquery-1.9.1.min.js'>\x3C/script>");
</script>

<script src="/resource/common/bootstrap/bootstrap.min.js"></script>
<!-- page specific plugin scripts -->

<!-- ace scripts -->
<script src="/resource/common/other/js/ace-elements.min.js"></script>
<script src="/resource/common/other/js/ace.min.js"></script>
<!-- inline scripts related to this page -->

<script type="text/javascript">
    $(top.hangge());
</script>
</body>
</html>