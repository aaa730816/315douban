/**
 * Created by Tony on 2017/6/28.
 */
$(function () {
    //用户名、密码和验证码不能有一项为空，才可注册
    var checkUsername=false;
    var checkPassword=false;
    var checkCode=false;
    //用户名和密码都不能为空才可登陆
    var checkLoginUsername=false;
    var checkLoginPassword=false;
    //设置banner宽度为屏幕宽度
    $("#banner").width($(".navbar").width());
    //设置tab宽度
    $(".tab").width(($(window).width()-600)/4);
    $("#myTab").width(4*$(".tab").width());
    $("#content").width($(window).width()-600);
    //点击“注册”提交表单
    $("#doRegister").click(function () {
        if (checkUsername==true&&checkPassword==true&&checkCode==true) {
            $("#registerForm").ajaxSubmit(function (data) {
                if (data=="N"){
                    $("#loginHint").text("注册失败！");
                    $("#backMain").attr("data-dismiss","modal").text("关闭");
                    $("#loginStatusModal").modal();
                }
                else {
                    $("#loginHint").text("注册成功！");
                    $("#backMain").text("返回首页").click(function () {
                        $(location).attr("href","http://localhost:8080/main/toMainPage");
                    });
                    $("#loginStatusModal").modal();
                }
            });
        }
    })
    //账户输入框验证
    $("#registerUsername").blur(function () {
        if ($(this).val()==""||$(this).val()==null){
            $("#userExistHint").css({color:"#ff0000"});
            $("#userExistHint").text("请输入用户名");
            checkUsername=false;
        }
        else {
            var username = $(this).val();
            $.ajax({
                url: "/main/isUserExist?username=" + username,
                success: function (data) {
                    if (data == "Y") {
                        $("#userExistHint").css({color: "#ff0000"});
                        $("#userExistHint").text("用户名已存在");
                        checkUsername=false;
                    }
                    else {
                        $("#userExistHint").css({color: "#006600"});
                        $("#userExistHint").text("用户名可用");
                        checkUsername=true;
                    }
                }
            })
        }
    })
    //验证码输入框验证
    $("#imageCode").blur(function () {
        if ($(this).val()==""||$(this).val()==null){
            $("#imageCodeHint").css({color:"#ff0000"});
            $("#imageCodeHint").text("请输入验证码");
            checkCode=false;
        }
        else {
            var imageCode = $(this).val();
            $.ajax({
                url: "/main/isCodeRight?imageCode=" + imageCode,
                success: function (data) {
                    if (data == "Y") {
                        $("#imageCodeHint").css({color: "#006600"});
                        $("#imageCodeHint").text("验证码正确");
                        checkCode=true;
                    }
                    else {
                        $("#imageCodeHint").css({color: "#ff0000"});
                        $("#imageCodeHint").text("验证码错误");
                        checkCode=false;
                    }
                }
            })
        }
    })
    //密码输入框验证
    $("#registerPassword").blur(function () {
        if ($(this).val()==""||$(this).val()==null){
            $("#passwordNotNullHint").css({color:"#ff0000"});
            $("#passwordNotNullHint").text("请输入密码");
            checkPassword=false;
        }
        else {
            $("#passwordNotNullHint").text("");
            checkPassword = true;
        }
    })
    //点击刷新验证码
    $("#code").click(function () {
        $("#code").attr("src","/main/getImageCode?ver="+Math.random());
    })
    //提交登陆表单
    $("#doLogin").click(function(){
        if($("#loginUsername").val()!=""&&$("#loginpassword").val()!=""){
            $("#loginForm").ajaxSubmit(function (data) {
                if (data=="N"){
                    $("#loginHint").text("用户名或密码错误！");
                    $("#backMain").attr("data-dismiss","modal").text("关闭");
                    $("#loginStatusModal").modal();
                }
                else {
                    $("#loginHint").text("登陆成功！");
                    $("#backMain").text("返回首页").click(function () {
                        $(location).attr("href","http://localhost:8080/main/toMainPage");
                    });
                    $("#loginStatusModal").modal();
                }
            })
        }

    })
    //登出
    $("#logout").click(function () {
        $(location).attr("href","http://localhost:8080/main/logout");
    })
    //内容宽度
    $("#content").width($("#myTab").width());
    //点击用户名显示用户信息页面
    $("#username").click(function(){
        $("#content").load(this.href);
        return false;
    })
    //导航栏切换
    $(".tabBtn").click(function () {
        $("#content").load(this.href);
        return false;
    })

})