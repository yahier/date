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
                $("#showPic").attr("src", res.msg);
            } else {
                alert(res.msg);
            }
        },
        error: function (err) {
            alert("服务异常");
        }

    })

}