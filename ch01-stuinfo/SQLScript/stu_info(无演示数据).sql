/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : stu_info

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 31/08/2021 10:16:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_achievement`;
CREATE TABLE `t_achievement`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sno` int NOT NULL COMMENT '学号',
  `semester` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学期',
  `Chinese` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '语文',
  `mathematics` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '数学',
  `English` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '英语',
  `physics` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '物理',
  `chemistry` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '化学',
  `biology` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '生物',
  `geography` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '地理',
  `history` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '历史',
  `politics` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '政治',
  `sports` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '体育',
  `music` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '音乐',
  `practice` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '实践',
  `java` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `cplus` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `python` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `c` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `html` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `css` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `javascript` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class`  (
  `sclassno` int NOT NULL COMMENT '班级编号',
  `sclassname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`sclassno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_stu
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu`  (
  `sno` int NOT NULL COMMENT '学号',
  `sname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `idno` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `age` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '性别，‘0’女，‘1’男',
  `hometown` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `nationality` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `sclassno` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生班级编号',
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `tno` int NOT NULL COMMENT '账号',
  `tname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `tpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `admin` int NULL DEFAULT 0 COMMENT '系统权限',
  PRIMARY KEY (`tno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
