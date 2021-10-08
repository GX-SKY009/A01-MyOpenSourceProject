package com.sky.stu.service;

import java.util.Map;

/**
 * @program: Code05
 * @description: 接口
 * @author: 云上幻歌
 * @create: 2021-08-28 10:15
 **/
public interface AdminService {
    /**
     * 登录系统
     *
     * @param tName
     * @param tPassword
     * @return
     */
    Map<String, Object> login(String tName, String tPassword);

    /**
     * 修改信息
     *
     * @param adminInfoMap
     * @return
     */
    Map<String, Object> reModifyAdminInfo(Map<String, Object> adminInfoMap);

    /**
     * 查找教师信息
     *
     * @param conditionMap
     * @return
     */
    Map<String, Object> queryAdminInfo(Map<String, Object> conditionMap);

    /**
     * 删除教师（管理员）
     *
     * @param tno 教师编号
     * @return
     */
    Map<String, Object> deleteAdmin(Integer tno);

    /**
     * 添加教师
     *
     * @param adminAddMap 表单集合
     * @return 结果信息
     */
    Map<String, Object> adminAdd(Map<String, Object> adminAddMap);
}
