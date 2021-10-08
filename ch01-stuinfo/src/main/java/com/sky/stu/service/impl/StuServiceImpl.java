package com.sky.stu.service.impl;

import com.sky.stu.mapper.StuMapper;
import com.sky.stu.service.StuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuServiceImpl implements StuService {

    @Resource
    private StuMapper stuMapper;

    /**
     * 按条件查询学生信息
     *
     * @param conditionMap
     * @return
     */
    @Override
    public Map<String, Object> queryStuInfo(Map<String, Object> conditionMap) {
        Map<String, Object> allInfoMap = new HashMap<>();
        allInfoMap.put("stuInfoListMap", stuMapper.queryStuInfo(conditionMap));
        allInfoMap.put("total", stuMapper.queryStuInfoCount(conditionMap));
        return allInfoMap;
    }

    /**
     * 根据学生学号删除学生
     *
     * @param sno 学号
     * @return
     */
    @Override
    public Map<String, Object> deleteStuBySno(Integer sno) {
        Map<String, Object> reMap = new HashMap<>();
        reMap.put("reMsg", "删除失败！");
        Integer reCode = stuMapper.deleteStuBySno(sno);
        if (reCode != 0) {
            reMap.put("reMsg", "删除成功！");
        } else {
            reCode = 2;
        }
        reMap.put("reCode", reCode);
        return reMap;
    }

    /**
     * 查询所有班级
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryClass() {
        return stuMapper.queryClass();
    }

    /**
     * 添加学生
     *
     * @param stuInfoMap
     * @return
     */
    @Override
    public Map<String, Object> stuAdd(Map<String, String> stuInfoMap) {
        Map<String, Object> reMap = new HashMap<>();
        Integer reCode = 2;
        reMap.put("reCode", reCode);
        String reMsg = "添加失败！";
        try {
            reCode = stuMapper.stuAdd(stuInfoMap);
            if (reCode == 1) {
                reMsg = "添加成功！";
                reMap.put("reCode", reCode);
            }
        } catch (Exception e) {
            reMsg = "信息错误或学生已存在！";
        }
        reMap.put("reMsg", reMsg);
        return reMap;
    }

    /**
     * 查看学生成绩
     *
     * @param stuScoreConditions
     * @return
     */
    @Override
    public List<Map<String, Object>> stuScore(Map<String, Object> stuScoreConditions) {
        return stuMapper.stuScore(stuScoreConditions);
    }

    /**
     * 修改学生信息
     *
     * @param newStuInfo
     * @return
     */
    @Override
    public Map<String, Object> modifyStuInfo(Map<String, String> newStuInfo) {
        Map<String, Object> reMap = new HashMap<>();
        String reMsg = "修改失败！";
        Integer reCode = stuMapper.modifyStuInfo(newStuInfo);
        if (reCode > 0) {
            reMsg = "修改成功！";
            reCode = 1;
        } else {
            reCode = 2;
        }
        reMap.put("reMsg", reMsg);
        reMap.put("reCode", reCode);
        return reMap;
    }

    /**
     * 添加学生分数
     *
     * @param scoreMap
     * @return
     */
    @Override
    public Map<String, Object> stuScoreAdd(Map<String, Object> scoreMap) {
        Map<String, Object> reMap = new HashMap<>();
        String reMsg = "录入失败！";
        Integer reCode = 2;
        //查询对应学生对应学期是否有过成绩
        Integer scoreIfExist = stuMapper.queryScoreIfExist(scoreMap);
        if (scoreIfExist >= 1) {
            //成绩已经录入
            reMsg = "失败原因：学生[" + scoreMap.get("sno") + "]的[" + scoreMap.get("semester") + "]学期成绩已经录入！";
        } else {
            try {
                Integer scoreAdd = stuMapper.stuScoreAdd(scoreMap);
                if (scoreAdd >= 1) {
                    reMsg = "恭喜您，录入成功。";
                    reCode = 1;
                }
            } catch (Exception e) {
                reMsg = "失败原因：成绩信息有误！";
            }
        }
        reMap.put("reMsg", reMsg);
        reMap.put("reCode", reCode);
        return reMap;
    }

    /**
     * 根据成绩序号删除学生成绩
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> deleteStuScoreById(Integer id) {
        Map<String, Object> reMap = new HashMap<>();
        String reMsg = "删除失败！";
        Integer reCode = 2;
        Integer deleteCode = stuMapper.deleteStuScoreById(id);
        if (deleteCode >= 1) {
            reMsg = "删除成功";
            reCode = 1;
        }
        reMap.put("reMsg", reMsg);
        reMap.put("reCode", reCode);
        return reMap;
    }

    /**
     * 修改学生信息
     *
     * @param stuScoreMap
     * @return
     */
    @Override
    public Map<String, Object> modifyStuScore(Map<String, Object> stuScoreMap) {
        Map<String, Object> reMap = new HashMap<>();
        String reMsg = "修改失败!";
        Integer reCode = 2;
        try {
            Integer reStuScore = stuMapper.modifyStuScore(stuScoreMap);
            if (reStuScore >= 1) {
                //修改成功
                reMsg = "修改成功";
                reCode = 1;
            }
        } catch (Exception e) {
            System.out.println(e);
            reMsg = "信息异常！请检查后重试。";
        }
        reMap.put("reMsg", reMsg);
        reMap.put("reCode", reCode);
        return reMap;
    }
}
