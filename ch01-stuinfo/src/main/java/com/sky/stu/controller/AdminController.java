package com.sky.stu.controller;

import com.sky.stu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统管理控制器
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 前往信息界面
     *
     * @return
     */
    @RequestMapping("toAdminInfo")
    public String toAdminInfo() {
        return "admin/adminInfo";
    }

    /**
     * 修改信息
     *
     * @param adminInfoMap
     * @return
     */
    @RequestMapping("modifyAdminInfo")
    @ResponseBody
    public Map<String, Object> reModifyAdminInfo(@RequestParam Map<String, Object> adminInfoMap) {
        Map<String, Object> reMap = adminService.reModifyAdminInfo(adminInfoMap);
        return reMap;
    }

    /**
     * 教师管理
     *
     * @return 页面
     */
    @RequestMapping("adminManage")
    public String adminManage() {
        return "admin/adminManage";
    }

    /**
     * 查找教师信息
     *
     * @param request
     * @return
     */
    @RequestMapping("queryAdminInfo")
    @ResponseBody
    public Map<String, Object> queryAdminInfo(HttpServletRequest request) {
        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("tno", request.getParameter("tno"));
        conditionMap.put("tname", request.getParameter("tname"));
        conditionMap.put("phone", request.getParameter("phone"));
        conditionMap.put("email", request.getParameter("email"));
        conditionMap.put("admin", request.getParameter("admin"));
        try {
            conditionMap.put("pageIndex", Integer.valueOf(request.getParameter("pageIndex")));
            conditionMap.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
        } catch (Exception e) {
            conditionMap.put("pageIndex", 0);
            conditionMap.put("pageSize", 1);
        }
        return adminService.queryAdminInfo(conditionMap);
    }

    /**
     * 删除教师（管理员）
     *
     * @param tno 教师编号
     * @return
     */
    @RequestMapping("deleteAdmin")
    @ResponseBody
    public Map<String, Object> deleteAdmin(Integer tno) {
        return adminService.deleteAdmin(tno);
    }

    /**
     * 跳转修改教师页面
     *
     * @param tno   教师编号
     * @param model 信息存储
     * @return 页面
     */
    @RequestMapping("modifyAdminInformation")
    public String modifyAdminInformation(Integer tno, Model model) {
        model.addAttribute("tno", tno);
        return "admin/modifyAdminInfo";
    }

    /**
     * 添加教师
     *
     * @param adminAddMap 表单集合
     * @return 结果信息
     */
    @RequestMapping("adminAdd")
    @ResponseBody
    public Map<String, Object> adminAdd(@RequestParam Map<String, Object> adminAddMap) {
        return adminService.adminAdd(adminAddMap);
    }
}
