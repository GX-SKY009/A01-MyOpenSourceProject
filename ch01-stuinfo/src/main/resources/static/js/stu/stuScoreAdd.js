/**
 * 添加学生成绩
 */

function fstuScoreAdd() {
    var resultmMark = true;
    $("input[type='number']").each(
        function () {
            if ($(this).val() == null) {
                resultmMark = false;
                layer.alert("请填写完整信息！")
            }
        }
    )
    if (!resultmMark || $("#semester").val().trim().length <= 0) return;
    layer.confirm("确认添加？", {btn: ['确定', '取消']}, function () {
        layer.msg('正在添加...', {
            icon: 16
            , shade: 0.01
            , time: false
        });
        $.post("/stu/stuScoreAdd", $("#stuScoreAddFrom").serialize(), reStuScoreAdd, "json")
    })
}


function reStuScoreAdd(data) {
    //添加结果
    layer.msg(data.reMsg, {
        icon: data.reCode
        , time: 2000
    });
}




