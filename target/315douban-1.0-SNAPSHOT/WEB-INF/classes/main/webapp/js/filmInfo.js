/**
 * Created by Tony on 2017/7/4.
 */
$(function () {
    var sComPage=0;
    var lComPage=0;
    var score=0;
    $("#filmInfoDiv").width($("#content").width);
    $("#filmimg").width($(".tab").width());
    $("#filmScore").width($(".tab").width());
    $("#filmInfo").width($("#filmInfoDiv").width()-$("#filmScore").width()-$("#filmImg").width());
    $("#filmSc").width($("#filmScore").width());
    $("#filmDBSc").width($("#filmScore").width());
    $("#curFilmScore").width($("#filmScore").width());
    $("#userScoreFilm").width($("#filmScore").width());
    $("#filmimg img").width($("#filmImg").width()-50).height($("#filmImg").height()-50);
    $("#filmScore").next().width($("#filmImg img").width()).css({"text-align":"center"});
    $("#moreScom").width($("#filmInfoDiv").width());
    $(".showContent").width($(".panel").width()).height(30);
    // $("#filmInfo").width($("#content").width-$("#filmImg").width-$("#filmScore").width);
    $(".star").click(function () {
        score=$(this).index()+1;
        for (var i=0;i<=$(this).index();i++) {
            $("#stars").children().eq(i).attr("src", "../image/star.png");
            $("#userScore").children().eq(1).text(score);
        }

        for (var i=$(this).index()+1;i<=9;i++){
            $("#stars").children().eq(i).attr("src","../image/starO.png");
        }
    })

    $("#subScore").click(function () {
        var filmName=$("#filmName").val();
        var href="/film/userScore";
        var args={"filmName":filmName,"score":score};
        if (score==0)
        {
            $("#scoreFilmHint").text("请您先打分");
            $("#back").click(function () {
                $("#userScoreFilmStatus").modal('hide');
            })
            $("#userScoreFilmStatus").modal();
        }
        else {
            $.ajax({url:href,data:args,success:function (data) {
                if (data=="Y")
                {
                    $("#scoreFilmHint").text("打分成功");
                    $("#back").click(function () {
                        $('.modal').map(function() {
                            $(this).modal('hide');
                        });
                        $(".modal-backdrop").remove();
                        var reg=new RegExp(" ","g");
                        var value=filmName.replace(reg,"%20");
                        $("#content").load("/film/filmInfo?filmName="+value);
                    })
                    $("#userScoreFilmStatus").modal();
                }
                else
                {
                    $("#scoreFilmHint").text("打分失败");
                    $("#back").click(function () {
                        $("#userScoreFilmStatus").modal('hide');
                    })
                    $("#userScoreFilmStatus").modal();
                }
            }})
        }
    })
    $("#shortComment").click(function () {
        $("#commentHint textarea").val("");
        $("#wordNums").text(0);
        var filmName=$("#filmName").val();
        $("#commentTitle").hide();
        $("#commentHint textarea").attr("maxlength",150).width(560).height(200);
        $("#commentModal").modal();
        $("#commentBtn").click(function () {
            var comment=$("#commentHint textarea").val();
            var href="/film/addFilmScom";
            var args={"comment":comment,"filmName":filmName};
            if (comment.length==0){
                $("#scoreFilmHint").text("请输入评论");
                $("#back").click(function () {
                    $("#userScoreFilmStatus").modal('hide');
                })
                $("#userScoreFilmStatus").modal();
            }
            else {
                $.ajax({url:href,data:args,success:function (data) {
                    if (data=="Y")
                    {
                        $("#scoreFilmHint").text("评论成功");
                        $("#back").click(function () {
                            $('.modal').map(function() {
                                $(this).modal('hide');
                            });
                            $(".modal-backdrop").remove();
                            var reg=new RegExp(" ","g");
                            var value=filmName.replace(reg,"%20");
                            $("#content").reload("/film/filmInfo?filmName="+value);
                        })
                        $("#userScoreFilmStatus").modal();
                    }
                    else
                    {
                        $("#scoreFilmHint").text("您已评论过此影片");
                        $("#back").click(function () {
                            $('.modal').map(function() {
                                $(this).modal('hide');
                            });
                            $(".modal-backdrop").remove();
                        })
                        $("#userScoreFilmStatus").modal();
                    }
                }})
            }
        })
            $("#commentWords").on("keyup",function () {
                $("#wordNums").text($("#commentWords").val().length);
                if ($("#commentWords").val().length>=150)
                    $("#wordNums").css({"color":"#ff0033"});
                else
                    $("#wordNums").css({"color":"#000"});
            })
    })
    $("#longComment").click(function () {
        $("#commentHint textarea").val("");
        $("#wordNums").text(0);
        var filmName=$("#filmName").val();
        $("#commentTitle").show();
        $("#commentHint textarea").attr("maxlength",10000).width(560).height(200);
        $("#commentModal").modal();
        $("#commentBtn").click(function () {
            var comment=$("#commentHint textarea").val();
            var href="/film/addFilmLcom";
            var title=$("#commentTitle").val();
            var args={"comment":comment,"filmName":filmName,"title":title};
            if (comment.length==0){
                $("#scoreFilmHint").text("请输入评论");
                $("#back").click(function () {
                    $("#userScoreFilmStatus").modal('hide');
                })
                $("#userScoreFilmStatus").modal();
            }
            else {
                $.ajax({url:href,data:args,success:function (data) {
                    if (data=="Y")
                    {
                        $("#scoreFilmHint").text("评论成功");
                        $("#back").click(function () {
                            $('.modal').map(function() {
                                $(this).modal('hide');
                            });
                            $(".modal-backdrop").remove();
                            var reg=new RegExp(" ","g");
                            var value=filmName.replace(reg,"%20");
                            $("#content").reload("/film/filmInfo?filmName="+value);
                        })
                        $("#userScoreFilmStatus").modal();
                    }
                    else
                    {
                        $("#scoreFilmHint").text("您已评论过此影片");
                        $("#back").click(function () {
                            $('.modal').map(function() {
                                $(this).modal('hide');
                            });
                            $(".modal-backdrop").remove();
                        })
                        $("#userScoreFilmStatus").modal();
                    }
                }})
            }
        })
            $("#commentWords").on("keyup",function () {
                $("#wordNums").text($("#commentWords").val().length);
                if ($("#commentWords").val().length>=10000)
                    $("#wordNums").css({"color":"#ff0033"});
                else
                    $("#wordNums").css({"color":"#000"});
            })
    })
    $("#moreScom").click(function () {
        sComPage+=1;
        var href = "/film/getMoreScom";
        var args={"page":sComPage,"filmName":$("#filmName").val()};
        $.getJSON(href,args,function (data) {
            if (data.length>0){
                for (var i=0;i<data.length;i++) {
                    $("#shortCom").append("<div class='panel panel-primary'>" +
                        "<div class='panel-heading'>" +
                        "<div class='panel-title'>" + data[i].userName + "&nbsp;&nbsp;" + data[i].commentDate +
                        "<input type='hidden' value='"+data[i].sComId+"'>" +
                    "<div class='likesCom' style='float: right'>" +
                    "<img style='width: 20px;height: 20px;'" +
                    "src='../image/like.png'>&nbsp;" +
                    "<span>"+data[i].like+"</span>" +
                    "</div></div>" +
                        "</div>" +
                        "<div class='panel-body'>" +
                        data[i].commentContent +
                        "</div>" +
                        "</div>");
                }
            $(".likesCom").click(function () {
                // alert($(this).children("span").text());
                var index=$(".likesCom").index(this);
                var href="/film/likeScom";
                var args={"filmScomId":$(this).prev().val()};
                $.ajax({url:href,data:args,success:function (data) {
                    $(".likesCom").eq(index).children("span").text(data);
                }})
            })
            }
        })
    })
    $(".likesCom").click(function () {
        // alert($(this).children("span").text());
        var index=$(".likesCom").index(this);
        // alert(index)
        var href="/film/likeScom";
        var args={"filmScomId":$(this).prev().val()};
        $.ajax({url:href,data:args,success:function (data) {
            $(".likesCom").eq(index).children("span").text(data);
        }})
    })
    $(".likelCom").click(function () {
        // alert($(this).children("span").text());
        var index=$(".likelCom").index(this);
        // alert(index)
        var href="/film/likeLcom";
        var args={"filmLcomId":$(this).prev().val()};
        $.ajax({url:href,data:args,success:function (data) {
            $(".likelCom").eq(index).children("span").text(data);
        }})
    })

    $("#moreLcom").click(function () {
        lComPage+=1;
        var href = "/film/getMoreLcom";
        var args={"page":lComPage,"filmName":$("#filmName").val()};
        $.getJSON(href,args,function (data) {
            if (data.length>0){
                for (var i=0;i<data.length;i++) {
                    $("#longCom").append("<div class='panel panel-info'>" +
                    "<div class='panel-heading'>" +
                    "<div class='panel-title'>"+data[i].userName+"&nbsp;&nbsp;"+data[i].lComDate +
                    "<input type='hidden' value='"+data[i].lComId+"'>" +
                    "<div class='likelCom' style='float: right'>" +
                    "<img style='width: 20px;height: 20px;'" +
                    "src='../image/like.png'>&nbsp;" +
                    "<span>"+data[i].like+"</span>" +
                    "</div></div>"+"</div>" +
                    "<div class='panel-body'>" +
                    "标题&nbsp;:&nbsp;"+data[i].lComTitle+
                    "</div>" +
                    "<div class='lComContent' hidden>" +
                    "<hr>" +
                    data[i].lComContent +
                    "</div>" +
                    "<div class='showContent'>" +
                    "<span style='vertical-align: middle' class='glyphicon glyphicon-chevron-down'></span>" +
                    "</div>" +
                    "</div>");
                }
                $(".showContent").width($(".panel").width()).height(30);
                $(".showContent").click(function () {
                    if ($(this).prev().is(":hidden")){
                        $(this).prev().fadeIn();
                        $(this).children().eq(0).attr("class","glyphicon glyphicon-chevron-up");
                    }
                    else {
                        $(this).prev().fadeOut();
                        $(this).children().eq(0).attr("class","glyphicon glyphicon-chevron-down");
                    }

                });
                $(".likelCom").click(function () {
                    // alert($(this).children("span").text());
                    var index=$(".likelCom").index(this);
                    // alert(index)
                    var href="/film/likeLcom";
                    var args={"filmLcomId":$(this).prev().val()};
                    $.ajax({url:href,data:args,success:function (data) {
                        $(".likelCom").eq(index).children("span").text(data);
                    }})
                })
            }
        })
    })
    $(".showContent").click(function () {
        if ($(this).prev().is(":hidden")){
            $(this).prev().fadeIn();
            $(this).children().eq(0).attr("class","glyphicon glyphicon-chevron-up");
        }
        else {
            $(this).prev().fadeOut();
            $(this).children().eq(0).attr("class","glyphicon glyphicon-chevron-down");
        }

    })

})