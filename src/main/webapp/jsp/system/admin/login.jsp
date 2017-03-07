<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- 根目录地址，为动静分离资源做准备，可能需要单独的静态服务器而准备的 --%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>${SysName}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="/resource/common/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resource/login/css/camera.css"/>
    <link rel="stylesheet" href="/resource/common/bootstrap/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="/resource/login/css/matrix-login.css"/>
    <link rel="stylesheet" href="/resource/common/other/css/font-awesome.css"/>
    <link rel="stylesheet" href="/resource/login/css/login.css"/>

    <%--验证码需要--%>
    <script type="text/javascript" src="/resource/common/jquery/jquery-1.5.1.min.js"></script>

    <script type="text/javascript" src="/resource/common/other/js/getToJson.js"></script>
    <script type="text/javascript" src="/resource/login/js/login.js"></script>
</head>
<body>

<div class="lgoin_main_wrap">
    <div id="loginbox">
        <form action="" method="post" name="loginForm" id="loginForm">
            <div class="control-group normal_text">
                <h3>
                    <img src="/resource/login/images/logo.png" alt="Logo"/>
                </h3>
            </div>
            <div class="control-group">
                <div class="controls">
                    <div class="main_input_box">
							<span class="add-on bg_lg">
							<i><img src="/resource/login/images/user.png"/></i>
							</span><input type="text" id="loginName" value="" placeholder="请输入用户名"/>
                    </div>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <div class="main_input_box">
							<span class="add-on bg_ly">
							    <i><img src="/resource/login/images/suo.png"/></i>
							</span><input type="password" id="password" placeholder="请输入密码" value=""/>
                    </div>
                </div>
            </div>
            <div class="remember_password_wrap">
                <div class="remember_password_before_name">
                    <span>记住密码</span>
                </div>
                <div class="remember_password_last_btn">
                    <input name="form-field-checkbox" id="saveId" type="checkbox"/>
                </div>
            </div>
            <div class="form-actions">
                <div class="verification_wrap">
                    <div class="verification_wrap_left">
                        <i><img src="/resource/login/images/yan.png"/></i>
                    </div>
                    <div class="verification_wrap_left login_code_div">
                        <input type="text" id="verCode"/>
                    </div>
                    <div class="verification_wrap_left">
                        <i><img class="login_code_img" id="codeImg" alt="点击更换" title="点击更换" src=""/></i>
                    </div>
                    <span class="pull-right login_cancel">
                        <a id="toCancel" class="btn btn-success">取消</a>
                    </span>
                    <span class="pull-right">
                        <a id="toLogin" class="flip-link btn btn-info">登录</a>
                    </span>

                </div>
            </div>

        </form>

        <div class="controls">
            <div class="main_input_box">
                <span>Copyright © ${SysName} 2017</span>
            </div>
        </div>
    </div>
</div>

<div id="templatemo_banner_slide" class="container_wapper">
    <div class="camera_wrap camera_emboss" id="camera_slide">
        <div data-src="/resource/login/images/banner_slide_01.jpg"></div>
        <div data-src="/resource/login/images/banner_slide_02.jpg"></div>
        <div data-src="/resource/login/images/banner_slide_03.jpg"></div>
    </div>
    <!-- #camera_wrap_3 -->
</div>

<script src="/resource/common/bootstrap/bootstrap.min.js"></script>
<script src="/resource/common/jquery/jquery-1.7.2.js"></script>

<script src="/resource/common/jquery/jquery.easing.1.3.js"></script>

<script src="/resource/common/jquery/jquery.mobile.customized.min.js"></script>
<script src="/resource/login/js/camera.min.js"></script>
<script src="/resource/login/js/templatemo_script.js"></script>
<script type="text/javascript" src="/resource/common/jquery/jquery.tips.js"></script>
<script type="text/javascript" src="/resource/common/jquery/jquery.cookie.js"></script>
</body>

</html>