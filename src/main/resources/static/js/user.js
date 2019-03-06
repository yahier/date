//提交用户信息
function submitUserInfo() {
    var name = $('#name').val();
    var phone = $('#phone').val();
    var birthDate = $('#birthday').val();
    var height = $('#height').val();
    var weight = $('#weight').val();
    var career = $('#career').val();
    var remark = $('#remark').val();

    alert(name + " " + phone + " " + birthDate + " " + weight + " " + height + " " + career);
    var data = {
        "name": name,
        "phoneNo": phone,
        "birthDate": birthDate,
        "heightCM": height,
        "weightKG": weight,
        "career": career,
        "remark": remark
    }
    var url = "/userInfo/add";


    // $.ajax({
    //     url: '/userInfo/add',
    //     type: 'POST',
    //     data: data,
    //     async: true,
    //     cache: false,
    //     contentType: "application/x-www-form-urlencoded",
    //     processData: false,
    //     success: function (result) {
    //         if (result.code == 200) {
    //             alert('保存成功');
    //         } else {
    //             alert('保存失败:' + result.msg);
    //         }
    //
    //     },
    //     error: function (result) {
    //         alert('error 请求发送失败');
    //     }
    // });

    $.post(url, data, function (result) {
        if (result.code == 200) {
            alert(result.msg);
        } else {
            alert("请求失败:" + result.msg);
        }

    }).fail(function (result) {
        alert("请求失败");
    });


}