package com.sky.stu.service.impl;

import com.sky.stu.mapper.AdminMapper;
import com.sky.stu.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Code05
 * @description: 实现类
 * @author: 云上幻歌
 * @create: 2021-08-28 10:15
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    /**
     * 登录系统
     *
     * @param tName
     * @param tPassword
     * @return
     */
    @Override
    public Map<String, Object> login(String tName, String tPassword) {
        Map<String, Object> reMap = new HashMap<>();
        Map<String, Object> adminInfoMap = adminMapper.login(tName, tPassword);
        Integer reCode = 1;
        if (adminInfoMap == null) {
            //没有找到
            reMap.put("reMsg", "信息错误，请重新登录！");
            reCode = 2;
        } else {
            reMap = adminInfoMap;
        }
        reMap.put("reCode", reCode);
        return reMap;
    }

    /**
     * 修改信息
     *
     * @param adminInfoMap
     * @return
     */
    @Override
    public Map<String, Object> reModifyAdminInfo(Map<String, Object> adminInfoMap) {
        Map<String, Object> reMap = new HashMap<>();
        String reMsg = "修改失败!";
        Integer reCode = 2;
        Integer reModifyAdminInfoCode = adminMapper.reModifyAdminInfo(adminInfoMap);
        if (reModifyAdminInfoCode == 1) {
            //修改成功
            reMsg = "恭喜您！修改成功。";
            reCode = 1;
        }
        reMap.put("reMsg", reMsg);
        reMap.put("reCode", reCode);
        return reMap;
    }

    /**
     * 查找教师信息
     *
     * @param conditionMap
     * @return
     */
    @Override
    public Map<String, Object> queryAdminInfo(Map<String, Object> conditionMap) {
        Map<String, Object> allInfoMap = new HashMap<>();
        allInfoMap.put("adminInfoListMap", adminMapper.queryAdminInfo(conditionMap));
        if (null == conditionMap.get("tno") || conditionMap.get("tno") == "") {
            allInfoMap.put("total", adminMapper.queryStuInfoCount(conditionMap));
        }
        return allInfoMap;
    }

    /**
     * 删除教师（管理员）
     *
     * @param tno 教师编号
     * @return
     */
    @Override
    public Map<String, Object> deleteAdmin(Integer tno) {
        Map<String, Object> reMap = new HashMap<>();
        String reMsg = "删除失败";
        Integer reCode = 2;
        Integer deleteAdminMsg = adminMapper.deleteAdmin(tno);
        if (deleteAdminMsg >= 1) {
            reMsg = "删除成功";
            reCode = 1;
        }
        reMap.put("reMsg", reMsg);
        reMap.put("reCode", reCode);
        return reMap;
    }

    /**
     * 添加教师
     *
     * @param adminAddMap 表单集合
     * @return 结果信息
     */
    @Override
    public Map<String, Object> adminAdd(Map<String, Object> adminAddMap) {
        Map<String, Object> reMap = new HashMap<>();
        String reMsg = "添加失败";
        Integer reCode = 2;
        try {
            Integer deleteAdminMsg = adminMapper.adminAdd(adminAddMap);
            if (deleteAdminMsg >= 1) {
                reMsg = "添加成功";
                reCode = 1;
            }
        } catch (Exception e) {
            reMsg = "教师已存在或信息错误！";
        }
        reMap.put("reMsg", reMsg);
        reMap.put("reCode", reCode);
        return reMap;
    }
}
