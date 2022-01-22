
$(document).ready(function() {
    $("#recognize-button").on("click",function () {
        var email=$("#tags1").val();
        var badge=$("#badge").val();
        var reason=$("#reason").val();
        var karma=$("#karma").val();
        console.log("button clicked");

      // var num=
           $.ajax({
            url: "/submitComment",
            method: "post",
            data: {email: email, badge: badge, reason:reason,karma:karma},

            success: function() {

                        $("#tags1").val('');
                        $("#reason").val('');
                        $("#badge").val(0);
                        $("#karma").val(0);
                location.reload(true);
                alert("Yeahh! you just give a badge");
            },
              error: function () {
                alert("Please fill out all details");
            }

        });
    });
});

$(function () {
    var availableTags = [];

    $.ajax({
        url: "/getAllUsers",
        method: "post",
        data: {},


        success: function (data) {

            for (var i = 0; i < data.length; i++) {


                availableTags.push(data[i].email);

            }


        }

    });

    $("#tags1").autocomplete({
        source: availableTags
    });
});

$(document).ready(function() {
        $.ajax({
            url: "/calculatePoints",
            method: "post",
            data: {},
            success: function(data) {

                $("#yukti").append(data);
            },
            error: function () {
                $("yukti").append(0);
            }})
});