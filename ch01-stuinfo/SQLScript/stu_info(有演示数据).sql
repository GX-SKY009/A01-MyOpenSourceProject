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

 Date: 31/08/2021 10:15:18
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
-- Records of t_achievement
-- ----------------------------
INSERT INTO `t_achievement` VALUES (4, 1005, '大一（上）', '54', '45', '54', '54', '54', '45', '54', '54', '45', '4', '78', '78', '87', '78', '78', '99', '87', '78', '100');
INSERT INTO `t_achievement` VALUES (5, 1003, '大一（上）', '23', '123', '33', '4', '23', '43', '100', '54', '45', '6', '3', '36', '8', '5', '25', '2', '54', '45', '36');
INSERT INTO `t_achievement` VALUES (6, 1005, '大一（下）', '12', '32', '4', '45', '65', '2', '43', '5', '65', '76', '2', '54', '76', '32', '5', '8', '42', '21', '100');
INSERT INTO `t_achievement` VALUES (7, 1005, '大二（上）', '32', '32', '23', '32', '23', '43', '43', '23', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43');
INSERT INTO `t_achievement` VALUES (9, 1003, '大二（下）', '52', '45', '25', '54', '45', '45', '45', '45', '45', '45', '45', '45', '45', '45', '45', '45', '444', '45', '45');
INSERT INTO `t_achievement` VALUES (10, 1005, '大四（上）', '33', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43', '43');

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
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES (101, '计算机一班');
INSERT INTO `t_class` VALUES (102, '计算机二班');
INSERT INTO `t_class` VALUES (103, '计算机三班');
INSERT INTO `t_class` VALUES (201, '艺术一班');
INSERT INTO `t_class` VALUES (202, '艺术二班');
INSERT INTO `t_class` VALUES (203, '艺术三班');

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
-- Records of t_stu
-- ----------------------------
INSERT INTO `t_stu` VALUES (1003, '赵六', '6546565456', '26', '0', '中国', '汉族', '的收费收费的', '5646546', '202');
INSERT INTO `t_stu` VALUES (1005, '女孩', '6546565456', '23', '0', '中国', '汉族', '士大夫大师傅', '123156', '202');
INSERT INTO `t_stu` VALUES (1006, '房贷首付', '452', '20', '1', '方', '方法都是', '大师傅似的', '65465', '203');
INSERT INTO `t_stu` VALUES (1007, '李白', '4654651654165', '23', '1', '王者峡谷', '汉', '硒鼓', '135246846', '201');
INSERT INTO `t_stu` VALUES (1008, '韩信', '465465165689', '56', '1', '王者峡谷', '汉', '硒鼓', '13321313', '203');
INSERT INTO `t_stu` VALUES (1009, '貂蝉', '465465156465', '56', '0', '王者峡谷', '汉', '硒鼓', '13321313', '201');
INSERT INTO `t_stu` VALUES (2001, '妲己', '16546465465', '23', '0', '王者峡谷', '汉', '硒鼓', '13658465465', '202');
INSERT INTO `t_stu` VALUES (2002, '额外人发', '75657', '25', '1', '中国', '壮族', '撒犯得上方法', '65654', '102');
INSERT INTO `t_stu` VALUES (2003, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (2004, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (2005, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (2006, '离心', '5546546546', '12', '1', '地方', '胜多负少', '随风倒十分', '6546546546', '103');
INSERT INTO `t_stu` VALUES (2007, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (3005, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (3006, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (30032, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (30053, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (300322, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (300534, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');
INSERT INTO `t_stu` VALUES (3003222, '额外人发', NULL, NULL, '1', NULL, NULL, NULL, NULL, '101');

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

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (101, '李四', '101', '13123', '13251@qq.com', 0);
INSERT INTO `t_teacher` VALUES (102, '王老师', '102', '65465', '546@oo.com', 1);

SET FOREIGN_KEY_CHECKS = 1;
