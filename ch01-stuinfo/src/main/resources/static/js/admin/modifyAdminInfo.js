
$(function () {
    /**
     * 查询学生信息
     */
    $.post("/admin/queryAdminInfo", {tno: $("#tnoTemp").text()}, reQueryAdminInfo, "json")
    function reQueryAdminInfo(data) {
        $.each(data.adminInfoListMap, function (index, element) {
            $("#tno").val(element.tno)
            $("#tname").val(element.tname)
            $("#tpassword").val(element.tpassword)
            $("#phone").val(element.phone)
            $("#email").val(element.email);
            $("#admin").val(element.admin)
        })
        refresh();
    }
})

/**
 * 修改教师信息
 * @param sno
 */
function modifyStuInfo() {
    layer.confirm("您确定要修改教师[" + $("#tnoTemp").text() + "]的信息吗？", {btn: ['确定', '取消']}, function () {
        layer.msg('正在修改...', {
            icon: 16
            , shade: 0.01
            , time: false
        });
        $.post("/admin/modifyAdminInfo", $("#stuInfoFrom").serialize(), reModifyAdminInfo, "json")
    })

    function reModifyAdminInfo(data) {
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
