/**
 * @program: Code05
 * @description: 教师信息
 * @author: 云上幻歌
 * @create: 2021-08-28 14:15
 **/

/**
 * 查看密码
 */
function checkPswd() {
    $("#tpassword").attr("type", "text");
    layer.msg('查看隐私中....', {
        icon: 7
        , time: 2000
    }, function () {
        $("#tpassword").attr("type", "password");
    });
}

/**
 * 打开编辑状态
 */
function toEdit() {
    $("#tname").attr("readonly", false)
    $("#tpassword").attr("readonly", false)
    $("#ctpasswordDiv").attr("hidden", false)
    $("#modifyBtnDiv").attr("hidden", false)
}

/**
 * 修改信息
 */
function modifyAdminInfo() {

    var tname = $("#tname").val().trim()
    var tpassword = $("#tpassword").val().trim()
    var ctpassword = $("#ctpassword").val().trim()
    var email = $("#email").val().trim()
    var phone = $("#phone").val().trim()

    if (tname == '' || tpassword == '' || ctpassword == '' || email == '' || phone == '') {
        //添加结果
        layer.msg("信息不完整！", {
            icon: 2
            , time: 2000
        }, function () {
            return;
        });
    } else if (tpassword != ctpassword) {
        layer.msg("重复密码不相等！", {
            icon: 2
            , time: 2000
        }, function () {
            return;
        });
    } else {
        //信息无误
        layer.confirm("确定修改？", {btn: ['确定', '取消']}, function () {
            layer.msg('正在修改...', {
                icon: 16
                , shade: 0.01
                , time: false
            });
            $.post("/admin/modifyAdminInfo", $("#modifyAdminInfoForm").serialize(), reModifyAdminInfo, "json")
        })
    }

    function reModifyAdminInfo(data) {
        //修改结果
        layer.msg(data.reMsg, {
            icon: data.reCode
            , time: 2000
        })
    }
}

$(function () {
    queryAdminInfo()  //请求数据
    getPage()     //分页操作

    $("#stuSearchBtn").click(function () {
        layer.msg('加载数据...', {
            icon: 16
            , shade: 0.01
            , time: 500
        });
        return queryAdminInfo();
    })
})

var page = 1; //设置首页页码
var limit = 10;  //设置一页显示的条数
let total;    //总条数


/**
 * 查找学上信息
 */

function queryAdminInfo() {
    $.ajax({
        url: "/admin/queryAdminInfo",
        async: false, //改为同步方式
        type: "POST",
        data: {
            tno: $("#tno").val().trim(),
            tname: $("#tname").val().trim(),
            phone: $("#phone").val().trim(),
            email: $("#email").val().trim(),
            admin: $("#admin").val().trim(),
            pageIndex: (page - 1) * limit,
            pageSize: limit
        },
        success: function (data) {
            total = data.total;
            $("#tbodyStuInfo").empty();
            $.each(data.adminInfoListMap, function (index, admin) {
                $("#tbodyStuInfo").append("<tr>" +
                    "<td>" + (index + 1) + "</td>" +
                    "<td>" + admin.tno + "</td>" +
                    "<td>" + admin.tpassword + "</td>" +
                    "<td>" + admin.tname + "</td>" +
                    "<td>" + admin.phone + "</td>" +
                    "<td>" + admin.email + "</td>" +
                    "<td>" + (admin.admin == 1 ? "管理员" : "教师") + "</td>" +
                    "<td><div class='layui-btn-group'><input type='button' value='删除' class='layui-btn  layui-btn-danger' onclick='deleteAdmin(" + admin.tno + ")'>" +
                    "<input type='button' value='修改' class='layui-btn layui-btn-warm'  onclick='modifyAdminInformation(" + admin.tno + ")'>" +
                    "</div></td>" +
                    "</tr>");
            })
        },
        dataType: "json"
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
                    queryAdminInfo();
                }
            }
        });
    });
}

/**
 * 删除教师
 * @param tno 教师编号
 */
function deleteAdmin(tno) {

    if (tno == $("#tnoTemp").val()){
        layer.msg('管理员不允许删除自己！', {
            icon: 2
            , shade: 0.01
            , time: 1500
        },function () {
            return;
        });
    }else {
        layer.confirm("确认删除？", {btn: ['确定', '取消']}, function () {
            layer.msg('正在删除...', {
                icon: 16
                , shade: 0.01
                , time: false
            });
            $.post("/admin/deleteAdmin", {tno:tno},reDeleteAdmin, "json")
        })
    }

    function reDeleteAdmin(data){
        //删除结果
        layer.msg(data.reMsg, {
            icon: data.reCode
            , time: 1500
        },function () {
            window.location = ""
        });
    }
}

/**
 * 前往修改教师界面
 * @param tno
 */
function modifyAdminInformation(tno) {
    window.location.href = "/admin/modifyAdminInformation?tno="+tno;
}

/**
 * 模态窗口处理
 */
$(function(){
    $('#adminAddFrom').submit(function(e){
        return false;
    });
    $('#modaltrigger').leanModal({ top: 110, overlay: 0.45, closeButton: ".hidemodal" });
});

/**
 * 添加教师
 */
function adminAdd() {
    var tno = $("#tno2").val().trim()
    var tpassword = $("#tpassword2").val().trim()
    var tname = $("#tname2").val().trim()
    var phone = $("#phone2").val().trim()
    var email = $("#email2").val().trim()
    var admin = $("#admin2").val().trim()

    if (tno == '' || tpassword == '' || tname == '' || phone == '' || email == '' || admin == '' ){
        layer.msg('请填写完整信息...', {
            icon: 2
            , shade: 0.01
            , time: 1500
        },function () {
            return;
        });
    }else {
        //信息完整
        layer.confirm("您确定要添加教师[" + tname + "]吗？", {btn: ['确定', '取消']}, function () {
            layer.msg('正在添加...', {
                icon: 16
                , shade: 0.01
                , time: false
            });
            $.post("/admin/adminAdd", $("#adminAddFrom").serialize(), reAdminAdd, "json")
        })
    }
    function reAdminAdd(data) {
        //添加结果
        layer.msg(data.reMsg, {
            icon: data.reCode
            , time: 1500
        },function () {
            if (data.reCode == 1){
                window.location = ""
            }
        });
    }
}