$(function () {
    /**
     * 查询所有班级
     */
    $.get("/stu/queryClass",queryClassToSelect,"json")
    function queryClassToSelect(data) {
        $("#sclass").empty()
        $.each(data,function (index,element) {
            $("#sclass").append("<option value='"+element.sclassno+"'>"+element.sclassname+"</option>")
        })
        layui.use('form', function(){
            var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
            form.render();
            form.render('select' ,'test'); //刷新select选择框渲染
        });
    }

    $("#stuAddBtn").click(function () {
        if ($("#sno").val().length == 0 || $("#sname").val().length == 0){
            layer.alert("学号与姓名必填！")
        }else {
            layer.msg('添加中...', {
                icon: 16
                ,shade: 0.01
                ,time:false
            });
            $.post("/stu/stuAdd",$("#stuAddFrom").serialize(),stuAddResult,"json")
        }
    })

    function stuAddResult(data) {
        //添加结果
        layer.msg(data.reMsg, {
            icon: data.reCode
            ,time:1500
        });
    }
})
