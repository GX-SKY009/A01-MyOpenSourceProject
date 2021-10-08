package com.sky.stu.service;

import java.util.List;
import java.util.Map;

public interface StuService {
    /**
     * 按条件查询学生信息
     *
     * @param conditionMap
     * @return
     */
    Map<String, Object> queryStuInfo(Map<String, Object> conditionMap);

    /**
     * 根据学生学号删除学生
     *
     * @param sno 学号
     * @return
     */
    Map<String, Object> deleteStuBySno(Integer sno);

    /**
     * 查询所有班级
     *
     * @return
     */
    List<Map<String, Object>> queryClass();

    /**
     * 添加学生
     *
     * @param stuInfoMap
     * @return
     */
    Map<String, Object> stuAdd(Map<String, String> stuInfoMap);

    /**
     * 查看学生成绩
     *
     * @param stuScoreConditions
     * @return
     */
    List<Map<String, Object>> stuScore(Map<String, Object> stuScoreConditions);

    /**
     * 修改学生信息
     *
     * @param newStuInfo
     * @return
     */
    Map<String, Object> modifyStuInfo(Map<String, String> newStuInfo);

    /**
     * 添加学生分数
     *
     * @param scoreMap
     * @return
     */
    Map<String, Object> stuScoreAdd(Map<String, Object> scoreMap);

    /**
     * 根据成绩序号删除学生成绩
     *
     * @param id
     * @return
     */
    Map<String, Object> deleteStuScoreById(Integer id);

    /**
     * 修改学生信息
     *
     * @param stuScoreMap
     * @return
     */
    Map<String, Object> modifyStuScore(Map<String, Object> stuScoreMap);
}
