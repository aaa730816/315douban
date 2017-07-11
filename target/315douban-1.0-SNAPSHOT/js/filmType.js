/**
 * Created by Tony on 2017/7/3.
 */
var currentPage;
$(function () {
    $("#filmsOFType").width(850);
    currentPage = 0;
    getFilmOfType(currentPage);
    function getFilmOfType(page) {
        var url = "/film/getFilmOFType";
        var type = $("#typeName").attr("content");
        var args = {"page": page,"type": type};
        $.getJSON(url, args, function (data) {
            if (data.length > 0) {
                currentPage += 1;
                $("#filmsOFType").empty();
                for (var i = 0; i < data.length; i++) {
                    $("#filmsOFType").append("<div class='filmDiv'> <img class='filmImg'  src='" + data[i].img + "'/><br><div class='filmName'><a class='toFilmInfo' href='/film/filmInfo?filmName="+data[i].filmName+"'>" + data[i].filmName + "</a></div></div>");
                    if ((i + 1) % 4 == 0) {
                        $("#filmsOFType").append("<br>");
                    }
                }
                $(".filmImg").width(150).height(200);
                $(".filmDiv").css({"float":"left","margin":"30px"});
                $(".toFilmInfo").click(function () {
                    $("#content").load(this.href);
                    return false;
                })
                $(".filmName").width(150).css({"overflow":"hidden","text-overflow":"ellipsis","white-space":"nowrap"});
            }
        })
    }

})
