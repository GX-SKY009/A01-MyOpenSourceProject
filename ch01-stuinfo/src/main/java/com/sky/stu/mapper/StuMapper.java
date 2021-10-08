package com.sky.stu.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StuMapper {

    /**
     * 按条件查询学生信息
     *
     * @param conditionMap
     * @return
     */
    List<Map<String, Object>> queryStuInfo(Map<String, Object> conditionMap);

    /**
     * 学生总数
     *
     * @param conditionMap
     * @return
     */
    Integer queryStuInfoCount(Map<String, Object> conditionMap);


    /**
     * 根据学生学号删除学生
     *
     * @param sno 学号
     * @return
     */
    Integer deleteStuBySno(Integer sno);

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
    Integer stuAdd(Map<String, String> stuInfoMap);

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
    Integer modifyStuInfo(Map<String, String> newStuInfo);

    /**
     * 查询对应学生对应学期是否有过成绩
     *
     * @param scoreMap
     * @return
     */
    Integer queryScoreIfExist(Map<String, Object> scoreMap);

    /**
     * 添加学生分数
     *
     * @param scoreMap
     * @return
     */
    Integer stuScoreAdd(Map<String, Object> scoreMap);

    /**
     * 根据成绩序号删除学生成绩
     *
     * @param id
     * @return
     */
    Integer deleteStuScoreById(Integer id);

    /**
     * 修改学生信息
     *
     * @param stuScoreMap
     * @return
     */
    Integer modifyStuScore(Map<String, Object> stuScoreMap);
}
