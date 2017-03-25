<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <!-- jsp文件头和头部 -->
    <%@ include file="top.jsp" %>

</head>
<body>

<div class="container-fluid" id="main-container">


    <div id="page-content" class="clearfix">

        <div class="page-header position-relative">
            <h1>
                后台首页
                <small><i class="icon-double-angle-right"></i></small>
            </h1>
        </div>
        <!--/page-header-->
        success

        <!--/row-->


    </div>
    <!-- #main-content -->
</div>
<!--/.fluid-container#main-container-->
<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse"> <i
        class="icon-double-angle-up icon-only"></i>
</a>
<%--<!-- basic scripts -->--%>
<script type="text/javascript">
    $(top.hangge());

</script>
</body>
</html>
