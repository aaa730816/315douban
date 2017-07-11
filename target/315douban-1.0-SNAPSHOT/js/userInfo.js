/**
 * Created by Tony on 2017/6/30.
 */
$(function () {
    var oriPassRight = false;
    $("#listGroup").width(($(window).width() - 600) / 4 - 20);
    $("#infoContent").width((($(window).width() - 600) / 4) * 3 - 20);
    $(".clickA").click(function () {
        $("#infoContent").load(this.href);
        return false;
    })
    $("#changeUserIcon").click(function () {
        $("#changeIconModal").modal('show');
        // alert("click")
    })

    $("#changeUerIconBtn").click(function () {
        $("#changeUserIconForm").ajaxSubmit(function (data) {
            if (data == "Y") {
                $("#changeHint").text("更换成功!");
                $("#back").text("返回");
                $("#back").click(function () {
                    $("#changeStatusModal").modal('hide');
                    $("#changeIconModal").modal('hide');
                    // $("#infoContent").load("/views/myInfo.jsp");
                    location.reload();
                })
                $("#changeStatusModal").modal('show');
            }
            else {
                $("#changeHint").text("更换失败!");
                $("#back").text("关闭");
                $("#changeStatusModal").modal('hide');
            }
        })
    })
    $("#oriPass").blur(function () {
        oriPassRight = false;
        var oriPass = $(this).val();
        $.ajax({
            url: "/user/isPassRight",
            data: {"oriPass": oriPass},
            success: function (data) {
                if (data == "Y") {
                    $("#changePassHint").css({"color": "#006600"});
                    $("#changePassHint").text("原密码输入正确");
                    oriPassRight = true;
                }
                else {
                    $("#changePassHint").css({"color": "#ff0000"});
                    $("#changePassHint").text("原密码输入错误");
                    oriPassRight = false;

                }
            }
        })
    })
    $("#changePassBtn").click(function () {
        if (oriPassRight == true && $("#newPass").val() != "") {
            $("#changePassForm").ajaxSubmit(function (data) {
                if (data == "Y") {
                    $("#changeHint").text("修改密码成功!");
                    $("#back").text("返回");
                    $("#back").click(function () {
                        $("#changePassStatusModal").modal('hide');
                        $("#changePassStatusModal").modal('hide');
                        // $("#infoContent").load("/views/myInfo.jsp");
                        location.reload();
                    })
                    $("#changePassStatusModal").modal('show');
                }
                else {
                    $("#changeHint").text("修改密码失败!");
                    $("#back").text("关闭");
                    $("#changePassStatusModal").modal('hide');
                }
            })
        }
    })
    $("#searchFriBtn").click(function () {
        $("#searchFriTable").html("");
        if ($("#searchFriWord").val() == "")
            return false;
        else {
            var url = "/user/searchUser";
            var args = {"username": $("#searchFriWord").val()};
            $.getJSON(url, args, function (data) {
                if (data.length != 0) {
                    for (var i = 0; i < data.length; i++) {
                        $("#searchFriTable").append("<tr><td>" + data[i] + "</td>" +
                            "<td><button class='btn btn-primary addFri'>添加</button> </td>" +
                            "</tr>");
                    }
                    $(".addFri").click(function () {
                        var frientName = $(this).parent().prev().text();
                        var url = "/user/addFriend?friendName=" + frientName;
                        $.ajax({
                            url: url, success: function (data) {
                                $("#friModalTitle").text("添加好友");
                                if (data == "Y") {
                                    $("#friStatusHint").text("添加好友成功");
                                    $("#friStatusModal").modal();
                                }
                                else {
                                    $("#friStatusHint").text("你们已经是好友了");
                                    $("#friStatusModal").modal();
                                }
                            }
                        })
                    })
                }

            })
        }
    })
    $(".delFri").click(function () {
        var frientName = $(this).attr("name");
        var url = "/user/delFriend?friendName=" + frientName;
        $.ajax({
            url: url, success: function (data) {
                $("#friModalTitle").text("删除好友");
                if (data == "Y") {
                    $("#friStatusHint").text("已解除好友关系");
                    $("#friStatusModal").modal();
                }
                else {
                    $("#friStatusHint").text("无法接触好友关系");
                    $("#friStatusModal").modal();
                }
            }
        })
    })
    $("#friStatusModal").on('hidden.bs.modal',function () {
        // $("#friStatusModal").modal('hide');
        if ($("#friModalTitle").text()=="删除好友") {
            $("#infoContent").load("/user/toMyFriendPage");
        }
    })
    $("#addFriendsBtn").click(function () {
        $("#searchFriTable").html("");
        $("#searchFriWord").val("");
        $("#addFriendModal").modal();
    })
})