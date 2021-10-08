
$(function () {

    /**
     * 查询所有班级
     */
    $.get("/stu/queryClass", queryClassToSelect, "json")
    function queryClassToSelect(data) {
        $("#sclassno").empty()
        $.each(data, function (index, element) {
            $("#sclassno").append("<option value='" + element.sclassno + "'>" + element.sclassname + "</option>")
        })
        refresh();
    }

    /**
     * 查询学生信息
     */

    $.post("/stu/queryStuInfo", {sno: $("#snoTemp").text()}, reQueryStuInfo, "json")
    function reQueryStuInfo(data) {
        $.each(data.stuInfoListMap, function (index, element) {
            $("#sno").val(element.sno)
            $("#sname").val(element.sname)
            $("#idno").val(element.idno)
            $("#age").val(element.age)
            $("#sex").val(element.sex);
            $("#hometown").val(element.hometown)
            $("#nationality").val(element.nationality)
            $("#address").val(element.address)
            $("#phone").val(element.phone)
            $("#sclassno").val(element.sclassno)
        })
        refresh();
    }
})

/**
 * 修改学生信息
 * @param sno
 */
function modifyStuInfo() {
    layer.confirm("您确定要修改学生[" + $("#snoTemp").text() + "]的信息吗？", {btn: ['确定', '取消']}, function () {
        layer.msg('正在修改...', {
            icon: 16
            , shade: 0.01
            , time: false
        });
        $.post("/stu/modifyStuInfo", $("#stuInfoFrom").serialize(), reModifyStuInfo, "json")
    })

    function reModifyStuInfo(data) {
        //修改结果
        layer.msg(data.reMsg, {
            icon: data.reCode
            , time: 1500
        });
    }
}

function refresh() {
    layui.use('form', function () {
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();
        form.render('select', 'test'); //刷新select选择框渲染
    });
}
