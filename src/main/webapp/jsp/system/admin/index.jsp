<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<%@ include file="top.jsp"%>
	<style type="text/css">
		.commitopacity {
			position: absolute;
			width: 100%;
			height: 100px;
			background: #7f7f7f;
			filter: alpha(opacity=50);
			-moz-opacity: 0.8;
			-khtml-opacity: 0.5;
			opacity: 0.5;
			top: 0px;
			z-index: 99999;
		}
	</style>
	
</head>
<body>

	<!-- 页面顶部¨ -->
	<%@ include file="head.jsp"%>
	<div id="websocket_button"></div>
	<div class="container-fluid" id="main-container">
		<a href="#" id="menu-toggler"><span></span></a>
		<!-- menu toggler -->

		<!-- 左侧菜单 -->
		<%@ include file="left.jsp"%>

		<div id="main-content" class="clearfix">

			<div id="jzts" style="display:none; width:100%; position:fixed; z-index:99999999;">
			<div class="commitopacity" id="bkbgjz"></div>
				<div style="padding-left: 43%;padding-top: 300px;">
                    <div style="float: left;margin-top: 10px;"><img src="/resource/page/index/images/loadingi.gif"/>
                    </div>
				<div style="margin-top: 5px;"><h4 class="lighter block red">&nbsp;加载中 ...</h4></div>
			</div>
			</div>

			<div>
				<iframe name="mainFrame" id="mainFrame" frameborder="0" src="/tab.do"
						style="margin:0 auto;width:100%;height:100%;"></iframe>
			</div>

			<!-- 换肤 -->
			<div id="ace-settings-container">
				<div class="btn btn-app btn-mini btn-warning" id="ace-settings-btn">
					<i class="icon-cog"></i>
				</div>
				<div id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hidden">
								<option data-class="default" value="#438EB9"
										<c:if test="${user.skin =='default' }">selected</c:if>>#438EB9
								</option>
								<option data-class="skin-1" value="#222A2D"
										<c:if test="${user.skin =='skin-1' }">selected</c:if>>#222A2D
								</option>
								<option data-class="skin-2" value="#C6487E"
										<c:if test="${user.skin =='skin-2' }">selected</c:if>>#C6487E
								</option>
								<option data-class="skin-3" value="#D0D0D0"
										<c:if test="${user.skin =='skin-3' }">selected</c:if>>#D0D0D0
								</option>
							</select>
						</div>
						<span>&nbsp; 选择皮肤</span>
					</div>
					<div>
						<label><input type='checkbox' name='menusf' id="menusf"
							onclick="menusf();" /><span class="lbl" style="padding-top: 5px;">菜单缩放</span></label>
					</div>
				</div>
			</div>
			<!--/#ace-settings-container-->

		</div>
		<!-- #main-content -->
	</div>
	<!--/.fluid-container#main-container-->
	<!-- basic scripts -->
		<!-- 引入 -->
    <script type="text/javascript">window.jQuery || document.write("<script src='//cdn.bootcss.com/jquery/1.8.3/jquery.min.js'>\x3C/script>");</script>
    <script src="//cdn.bootcss.com/bootstrap/2.3.0/bootstrap.min.js"></script>
    <script src="/resource/common/ace/ace-elements.min.js"></script>
    <script src="/resource/common/ace/ace.min.js"></script>
		<!-- 引入 -->

    <script type="text/javascript" src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script type="text/javascript" src="/resource/page/index/js/menusf.js"></script>
		
		<!--引入属于此页面的js -->
    <script type="text/javascript" src="/resource/page/index/js/index.js"></script>
</body>
</html>
