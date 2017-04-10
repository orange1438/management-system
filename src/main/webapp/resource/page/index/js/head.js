var locat = (window.location + '').split('/');
$(function () {
    if ('main' == locat[3]) {
        locat = locat[0] + '//' + locat[2];
    } else {
        locat = locat[0] + '//' + locat[2] + '/' + locat[3];
    }
    ;
});


//菜单状态切换
var fmid = "fhindex";
var mid = "fhindex";
function siMenu(id, fid, MENU_NAME, MENU_URL) {
    if (id != mid) {
        $("#" + mid).removeClass();
        mid = id;
    }
    if (fid != fmid) {
        $("#" + fmid).removeClass();
        fmid = fid;
    }
    $("#" + fid).attr("class", "active open");
    $("#" + id).attr("class", "active");
    top.mainFrame.tabAddHandler(id, MENU_NAME, MENU_URL);
    if (MENU_URL != "/druid/index.html") {
        jzts();
    }
}

$(function () {

    //换肤
    $("#skin-colorpicker").ace_colorpicker().on("change", function () {
        var b = $(this).find("option:selected").data("class");
        hf(b);
        var url = locat + '/head/setSkin?skin=' + b + '&tm=' + new Date().getTime();
        $.get(url, function (data) {
        });

    });
});

var USER_ID;

var userName = "FH";	//用于即时通讯（ 当前登录用户）

$(function () {

    $.ajax({
        type: "POST",
        url: locat + '/head/getUser.do?tm=' + new Date().getTime(),
        data: encodeURI(""),
        dataType: 'json',
        cache: false,
        success: function (data) {
            //alert(data.list.length);
            $.each(data, function (i, user) {
                //登陆者资料
                $("#user_info").html('<small>Welcome</small> ' + user.trueName + '');
                userName = user.userName;
                USER_ID = user.userId;//用户ID
                hf(user.skin);//皮肤
                if (user.userName != 'admin') {
                    $("#adminmenu").hide();	//隐藏菜单设置
                    $("#adminzidian").hide();	//隐藏数据字典
                    $("#systemset").hide();	//隐藏系统设置
                    $("#productCode").hide();	//隐藏代码生成
                }
            });
        }
    });
});


//换肤
function hf(b) {

    var a = $(document.body);
    a.attr("class", a.hasClass("navbar-fixed") ? "navbar-fixed" : "");
    if (b != "default") {
        a.addClass(b);
    }
    if (b == "skin-1") {
        $(".ace-nav > li.grey").addClass("dark");
    } else {
        $(".ace-nav > li.grey").removeClass("dark");
    }
    if (b == "skin-2") {
        $(".ace-nav > li").addClass("no-border margin-1");
        $(".ace-nav > li:not(:last-child)").addClass("white-pink")
            .find('> a > [class*="icon-"]').addClass("pink").end()
            .eq(0).find(".badge").addClass("badge-warning");
    } else {
        $(".ace-nav > li").removeClass("no-border").removeClass("margin-1");
        $(".ace-nav > li:not(:last-child)").removeClass("white-pink")
            .find('> a > [class*="icon-"]').removeClass("pink").end()
            .eq(0).find(".badge").removeClass("badge-warning");
    }
    if (b == "skin-3") {
        $(".ace-nav > li.grey").addClass("red").find(".badge").addClass("badge-yellow");
    } else {
        $(".ace-nav > li.grey").removeClass("red").find(".badge").removeClass("badge-yellow");
    }
}

//修改个人资料
function editUser() {
    jzts();
    layui.use(['layer', 'form'], function () {
        layer.open({
            type: 2,
            title: '<i class="layui-icon" style="font-size: 15px;">&#xe642;</i>修改资料',
            skin: 'layui-layer-lan', //加上边框
            area: ['250px', '450px'], //宽高
            content: '/user/toEdit.do?userId=' + USER_ID,
            cancel: function (index, layero) {
                layer.close(index)
            }
        });
    });
}

//系统设置
function editSys() {

    layui.use(['layer', 'form'], function () {
        layer.msg('功能未实现', {
            time: 3000, //2s后自动关闭
            icon: 2
        });
    });
}

//代码生成
function productCode() {

    layui.use(['layer', 'form'], function () {
        layer.msg('功能未实现', {
            time: 3000, //2s后自动关闭
            icon: 2
        });
    });
}

//数据字典
function zidian() {
    jzts();


}
var indexNum;

//清除加载进度
function hangge() {
    $("#jzts").hide();
}

//显示加载进度
function jzts() {
    $("#jzts").show();
}