function uploadPic() {
    alert("上传文件");
    var form = document.getElementById('upload'),
        formData = new FormData(form);
    $.ajax({
        url: "/file/uploadImg",
        type: "post",
        data: formData,
        processData: false,
        contentType: false,
        success: function (res) {
            if (res.code == 200) {
                alert("上传成功！");
                console.log(res);
                //$("#pic").val("");
                $("#showUrl").html(res.msg);
                alert("123");
                var src = window.URL.createObjectURL($("#file"))//这里传一个文件对象 例如：file.files[0]
                alert("src:" + src);
                $("#showPic").attr("src", src);
            } else {
                alert(res.msg);
            }
        },
        error: function (err) {
            alert("服务异常");
        }

    })

}

function getFileUrl(sourceId) {
    var url;
    if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE
        url = document.getElementById(sourceId).value;
    } else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox
        url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
    } else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome
        url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
    }
    return url;
}
