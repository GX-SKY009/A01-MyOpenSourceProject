package com.sky.stu.controller;

import com.sky.stu.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生信息控制器
 */
@Controller
@RequestMapping("stu")
public class StuController {

    @Autowired
    private StuService stuService;

    /**
     * 跳转顶部页面
     *
     * @return
     */
    @RequestMapping("stuTop")
    public String stuTop() {
        return "main/stuTop";
    }

    /**
     * 跳转底部页面
     *
     * @return
     */
    @RequestMapping("stuBottom")
    public String stuBottom() {
        return "main/stuBottom";
    }

    /**
     * 学生信息页面
     *
     * @return
     */
    @RequestMapping("stuInfo")
    public String stuInfo() {
        return "stu/stuInfo";
    }

    /**
     * 查询学生信息
     *
     * @param request
     * @return
     */
    @RequestMapping("queryStuInfo")
    @ResponseBody
    public Map<String, Object> queryStuInfo(HttpServletRequest request) {
        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("sno", request.getParameter("sno"));
        conditionMap.put("sname", request.getParameter("sname"));
        conditionMap.put("idno", request.getParameter("idno"));
        conditionMap.put("sex", request.getParameter("sex"));
        conditionMap.put("hometown", request.getParameter("hometown"));
        conditionMap.put("nationality", request.getParameter("nationality"));
        conditionMap.put("address", request.getParameter("address"));
        conditionMap.put("phone", request.getParameter("phone"));
        conditionMap.put("sclassname", request.getParameter("sclassname"));
        try {
            conditionMap.put("pageIndex", Integer.valueOf(request.getParameter("pageIndex")));
            conditionMap.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
        } catch (Exception e) {
            conditionMap.put("pageIndex", 0);
            conditionMap.put("pageSize", 1);
        }

        return stuService.queryStuInfo(conditionMap);
    }

    /**
     * 根据学生学号删除学生
     *
     * @param sno 学号
     * @return
     */
    @RequestMapping("deleteStuBySno")
    @ResponseBody
    public Map<String, Object> deleteStuBySno(Integer sno) {
        return stuService.deleteStuBySno(sno);
    }

    /**
     * 调转到学生添加页面
     *
     * @return
     */
    @RequestMapping("toStuAdd")
    public String toStuAdd() {
        return "stu/stuAdd";
    }

    /**
     * 查询所有班级
     *
     * @return
     */
    @RequestMapping("queryClass")
    @ResponseBody
    public List<Map<String, Object>> queryClass() {
        return stuService.queryClass();
    }

    /**
     * 添加学生
     *
     * @param stuInfoMap
     * @return
     */
    @RequestMapping("stuAdd")
    @ResponseBody
    public Map<String, Object> stuAdd(@RequestParam Map<String, String> stuInfoMap) {
        return stuService.stuAdd(stuInfoMap);
    }

    /**
     * 查看学生成绩
     *
     * @param sno
     * @return
     */
    @RequestMapping("stuScore")
    public String stuScore(Integer sno, Integer id, Model model) {
        Map<String, Object> stuScoreConditions = new HashMap<>();
        stuScoreConditions.put("sno", sno);
        stuScoreConditions.put("id", id);
        List<Map<String, Object>> stuScores = stuService.stuScore(stuScoreConditions);
        model.addAttribute("sno", sno);
        model.addAttribute("sname", stuScores.get(0).get("sname"));
        model.addAttribute("stuScores", stuScores);
        String view = "stu/stuScore";
        if (id != null) view = "stu/modifyStuScore";
        return view;
    }

    /**
     * 跳转到修改学生信息界面
     *
     * @param sno 学号：用来查询学生信息
     * @return
     */
    @RequestMapping("toModifyStuInfo")
    public String toModifyStuInfor(Integer sno, Model model) {
        model.addAttribute("sno", sno);
        return "stu/modifyStuInfo";
    }

    /**
     * 修改学生信息
     *
     * @param newStuInfo
     * @return
     */
    @RequestMapping("modifyStuInfo")
    @ResponseBody
    public Map<String, Object> modifyStuInfo(@RequestParam Map<String, String> newStuInfo) {
        return stuService.modifyStuInfo(newStuInfo);
    }

    /**
     * 页面跳转，添加学生分数
     *
     * @return
     */
    @RequestMapping("toStuScoreAdd")
    public String toStuBottom() {
        return "stu/stuScoreAdd";
    }

    /**
     * 添加学生分数
     *
     * @param scoreMap
     * @return
     */
    @RequestMapping("stuScoreAdd")
    @ResponseBody
    public Map<String, Object> stuScoreAdd(@RequestParam Map<String, Object> scoreMap) {
        return stuService.stuScoreAdd(scoreMap);
    }

    /**
     * 根据成绩序号删除学生成绩
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteStuScoreById")
    @ResponseBody
    public Map<String, Object> deleteStuScoreById(Integer id) {
        return stuService.deleteStuScoreById(id);
    }

    /**
     * 修改学生成绩界面
     *
     * @param id
     * @param sno
     * @param model
     * @return
     */
    @RequestMapping("toModifyStuScore")
    public String toModifyStuScore(Integer id, Integer sno, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("sno", sno);
        return "stu/modifyStuScore";
    }

    /**
     * 修改学生信息
     *
     * @param stuScoreMap
     * @return
     */
    @RequestMapping("modifyStuScore")
    @ResponseBody
    public Map<String, Object> modifyStuScore(@RequestParam Map<String, Object> stuScoreMap) {
        return stuService.modifyStuScore(stuScoreMap);
    }


}
