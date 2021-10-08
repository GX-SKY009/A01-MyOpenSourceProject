/**
 * 删除学生成绩
 * @param sno 学生编号
 */
function deleteStuScore(id) {
    layer.confirm("您确定要删除学生成绩吗？", {btn: ['确定', '取消']}, function () {
        layer.msg('正在删除...', {
            icon: 16
            , shade: 0.01
            , time: false
        });

        $.post("/stu/deleteStuScoreById", {id: id}, deleteStuBySno, "json")
    })
}

function deleteStuBySno(data) {
    //删除结果
    layer.msg(data.reMsg, {
        icon: data.reCode
        , time: 2000
    }, function () {
        window.location = ""
    });
}

/**
 * 前往成绩修改界面
 * @param id
 */
function toModifyStuScore(id, sno) {
    window.location.href = "/stu/stuScore?id=" + id + "&sno=" + sno
}

/**
 * 修改成绩
 */
function modifyStuScore() {

    layer.confirm("您确定要修改学生[" + $("#snoTemp").text() + "]的成绩吗？", {btn: ['确定', '取消']}, function () {
        layer.msg('正在修改...', {
            icon: 16
            , shade: 0.01
            , time: false
        });
        $.post("/stu/modifyStuScore", $("#stuScoreFrom").serialize(), reModifyStuInfo, "json")
    })

    function reModifyStuInfo(data) {
        //修改结果
        layer.msg(data.reMsg, {
            icon: data.reCode
            , time: 1500
        });
    }
}


