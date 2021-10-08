package com.sky.stu.controller;

import com.sky.stu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 登录信息控制器
 */

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    /**
     * 默认等陆界面
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "login/login";
    }

    /**
     * 登录系统
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpSession session, Model model) {
        String tName = request.getParameter("username");
        String tPassword = request.getParameter("password");
        Map<String, Object> adminInfoMap = adminService.login(tName, tPassword);
        String toUrl = "login/login";
        if (1 == (Integer) adminInfoMap.get("reCode")) {
            //登录成功
            session.setAttribute("admin", adminInfoMap);
            toUrl = "main/stuMenu";
        } else {
            //登录失败
            model.addAttribute("err", adminInfoMap.get("reMsg"));
        }
        return toUrl;
    }

    /**
     * 用户退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login/login";
    }

}
