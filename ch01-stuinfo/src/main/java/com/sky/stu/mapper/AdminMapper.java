package com.sky.stu.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper {

    /**
     * 登录系统
     *
     * @param tName
     * @param tPassword
     * @return
     */
    Map<String, Object> login(@Param("tName") String tName, @Param("tPassword") String tPassword);

    /**
     * 修改信息
     *
     * @param adminInfoMap
     * @return
     */
    Integer reModifyAdminInfo(Map<String, Object> adminInfoMap);

    /**
     * 查找教师信息
     *
     * @param conditionMap
     * @return
     */
    List<Map<String, Object>> queryAdminInfo(Map<String, Object> conditionMap);

    /**
     * 查找教师信息 总数
     *
     * @param conditionMap
     * @return
     */
    Integer queryStuInfoCount(Map<String, Object> conditionMap);

    /**
     * 删除教师（管理员）
     *
     * @param tno 教师编号
     * @return
     */
    Integer deleteAdmin(Integer tno);

    /**
     * 添加教师
     *
     * @param adminAddMap 表单集合
     * @return 结果信息
     */
    Integer adminAdd(Map<String, Object> adminAddMap);
}
