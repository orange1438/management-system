/**
 * login页面需要的js
 * Created by orange on 2017/2/1 0001.
 */

//TOCMAT重启之后 点击左侧列表跳转登录首页
if (window != top) {
    top.location.href = location.href;
}

$(document).ready(function () {
    changeCode();
    // 绑定点击图片事件
    $("#codeImg").on("click", changeCode);

    // 绑定登录事件
    $("#toLogin").on("click", severCheck);

    // 绑定取消事件
    $("#toCancel").on("click", cancel);

    // 绑定记住密码事件
    $("#saveId").on("click", rememberPassword);
});

/**
 * 键盘事件
 */
$(document).keyup(function (event) {
    if (event.keyCode == 13) {
        $("#toLogin").trigger("click");
    }
});

/**
 * 服务器校验
 */
function severCheck() {
    if (verifyCheck()) {
        var loginName = $("#loginName").val();
        var password = $("#password").val();
        var code = "http://www.cnblogs.com/orange1438"
            + loginName
            + ",orange,"
            + password
            + "http://www.cnblogs.com/orange1438"
            + ",orange," + $("#verCode").val();
        $.ajax({
            type: "POST",
            url: 'login_login',
            data: {KEYDATA: code, tm: new Date().getDate()},
            dataType: 'json',
            cache: false,
            success: function (data) {
                if ("success" == data.result) {
                    saveCookie();
                    window.location.href = "main/index";
                } else if ("usererror" == data.result) {
                    $("#loginName").tips({
                        side: 1,
                        msg: "用户名或密码有误",
                        bg: '#FF5080',
                        time: 15
                    });
                    $("#loginName").focus();
                } else if ("codeerror" == data.result) {
                    $("#verCode").tips({
                        side: 1,
                        msg: "验证码输入有误",
                        bg: '#FF5080',
                        time: 15
                    });
                    $("#verCode").focus();
                } else {
                    $("#loginName").tips({
                        side: 1,
                        msg: "缺少参数",
                        bg: '#FF5080',
                        time: 15
                    });
                    $("#loginName").focus();
                }
            }
        });
    }
}

/**
 * 客户端校验检查
 * @returns {boolean}
 */
function verifyCheck() {

    if ($("#loginName").val() == "") {

        $("#loginName").tips({
            side: 2,
            msg: '用户名不得为空',
            bg: '#AE81FF',
            time: 3
        });

        $("#loginName").focus();
        return false;
    } else {
        $("#loginName").val(jQuery.trim($('#loginName').val()));
    }

    if ($("#password").val() == "") {

        $("#password").tips({
            side: 2,
            msg: '密码不得为空',
            bg: '#AE81FF',
            time: 3
        });

        $("#password").focus();
        return false;
    }
    if ($("#verCode").val() == "") {

        $("#verCode").tips({
            side: 1,
            msg: '验证码不得为空',
            bg: '#AE81FF',
            time: 3
        });

        $("#verCode").focus();
        return false;
    }

    $("#loginbox").tips({
        side: 1,
        msg: '正在登录 , 请稍后 ...',
        bg: '#68B500',
        time: 10
    });

    return true;
}

/**
 * 验证码请求
 */
function changeCode() {
    $("#codeImg").attr("src", "code.do?t=" + genTimestamp());
}

/**
 * 得到毫秒数
 * @returns {number}
 */
function genTimestamp() {
    return (new Date()).getTime();//毫秒数
}

/**
 * 记住密码
 */
function rememberPassword() {
    if (!$("#saveId").attr("checked")) {
        $.cookie('loginName', '', {
            expires: -1
        });
        $.cookie('password', '', {
            expires: -1
        });
        $("#loginName").val('');
        $("#password").val('');
    }
}

/**
 * 取消输入的信息
 */
function cancel() {
    $("#loginName").val('');
    $("#password").val('');
}

/**
 * 保存cookie
 */
function saveCookie() {
    if ($("#saveId").attr("checked")) {
        $.cookie('loginName', $("#loginName").val(), {
            expires: 7
        });
        $.cookie('password', $("#password").val(), {
            expires: 7
        });
    }
}

/**
 * 从cookie得到账户
 */
jQuery(function () {
    var loginName = $.cookie('loginName');
    var password = $.cookie('password');
    if (typeof(loginName) != "undefined"
        && typeof(password) != "undefined") {
        $("#loginName").val(loginName);
        $("#password").val(password);
        $("#saveId").attr("checked", true);
        $("#verCode").focus();
    }
});