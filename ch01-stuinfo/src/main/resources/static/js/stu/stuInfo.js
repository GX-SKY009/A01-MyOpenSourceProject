$(function () {
    queryStuInfo()  //请求数据
    getPage()     //分页操作

    $("#stuSearchBtn").click(function () {
        layer.msg('加载数据...', {
            icon: 16
            , shade: 0.01
            , time: 500
        });
        return queryStuInfo();
    })
})

var page = 1; //设置首页页码
var limit = 10;  //设置一页显示的条数
let total;    //总条数


/**
 * 查找学上信息
 */

function queryStuInfo() {
    $.ajax({
        url: "/stu/queryStuInfo",
        async: false, //改为同步方式
        type: "POST",
        data: {
            sno: $("#sno").val().trim(),
            sname: $("#sname").val().trim(),
            idno: $("#idno").val().trim(),
            age: $("#age").val().trim(),
            sex: $("#sex").val().trim(),
            hometown: $("#hometown").val().trim(),
            nationality: $("#nationality").val().trim(),
            address: $("#address").val().trim(),
            phone: $("#phone").val().trim(),
            sclassname: $("#sclassname").val().trim(),
            pageIndex: (page-1)*limit,
            pageSize: limit
        },
        success: function (data) {
            total = data.total;
            $("#tbodyStuInfo").empty();
            $.each(data.stuInfoListMap, function (index, stu) {
                $("#tbodyStuInfo").append("<tr>" +
                    "<td>" + (index + 1) + "</td>" +
                    "<td>" + stu.sno + "</td>" +
                    "<td>" + stu.sname + "</td>" +
                    "<td>" + stu.idno + "</td>" +
                    "<td>" + stu.age + "</td>" +
                    "<td>" + (stu.sex == 1 ? "男" : "女") + "</td>" +
                    "<td>" + stu.hometown + "</td>" +
                    "<td>" + stu.nationality + "</td>" +
                    "<td>" + stu.address + "</td>" +
                    "<td>" + stu.phone + "</td>" +
                    "<td>" + stu.sclassname + "</td>" +
                    "<td><div class='layui-btn-group'><input type='button' value='删除' class='layui-btn  layui-btn-danger' onclick='deleteStu(" + stu.sno + ")'>" +
                    "<input type='button' value='成绩' class='layui-btn'  onclick='queryAchievement(" + stu.sno + ")'>" +
                    "<input type='button' value='修改' class='layui-btn layui-btn-warm'  onclick='modifyStuInfomation(" + stu.sno + ")'>" +
                    "</div></td>" +
                    "</tr>");
            })
            getPage()
        },
        dataType:"json"
    });
}


function getPage() {
    layui.use('laypage', function () {
        var laypage = layui.laypage;
        //执行一个laypage实例
        laypage.render({
            elem: 'pagination' //注意，这里的 test1 是 ID，不用加 # 号
            , count: total, //数据总数，从服务端得到
            limit: limit,   //每页条数设置
            jump: function (obj, first) {
                //obj包含了当前分页的所有参数，比如：
                page = obj.curr;  //改变当前页码
                limit = obj.limit;
                //首次不执行
                if (!first) {
                    /**
                     * 初始化数据
                     */
                    queryStuInfo();
                }
            }
        });
    });
}


/**
 * 删除学生
 * @param sno 学生编号
 */
function deleteStu(sno) {
    layer.confirm("您确定要删除学生[" + sno + "]吗？", {btn: ['确定', '取消']}, function () {
        layer.msg('正在删除...', {
            icon: 16
            , shade: 0.01
            , time: false
        });

        $.post("/stu/deleteStuBySno", {sno: sno}, deleteStuBySno, "json")
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
 * 查看学生成绩
 * @param sno 学生编号
 */
function queryAchievement(sno) {
    window.location = "/stu/stuScore?sno=" + sno
}

/**
 * 修改学生信息
 * @param sno 学生编号
 */
function modifyStuInfomation(sno) {
    window.location = "/stu/toModifyStuInfo?sno=" + sno
}
