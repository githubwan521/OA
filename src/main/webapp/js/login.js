$(document).ready(function () {
    $("#sub").click(function () {
        var userName = $("#nickname").val();
        var password = $("#password").val();

        var message = {"nickname": userName, "password": password};
        $.ajax({
            url: "/oa/login?method=login",
            type: "post",
            data: message,
            dataType: "jsonp",

            jsonpCallback: "jsonpCallback",

            success: function (json) {
                if (json.result) {
                    alert(json.userData.nickname);
                }
            }
        })

    });
});