##学生信息管理系统

###1.系统环境
开发工具：IDEA2021
数据库：MySQL5.x，8.x
Jdk:11
使用框架：spring boot

###2.需求
学生信息管理系统，可用于学校等机构的学生信息管理，查询，更新与维护，使用方便，易用性强。
该系统实现的大致功能；
用户登陆。提供了学生学籍信息的查询，添加，修改，删除；

学生成绩的 录入，修改，删除，查询班级排名，修改密码等功能。
管理员管理拥有最高的权限。允许添加教师
信息和课程信息等。其提供了简单.方便的操作。

###3.新建表

####学生表
CREATE TABLE `t_stu` (
`sno` int(11) NOT NULL COMMENT '学号',
`sname` varchar(50) NOT NULL COMMENT '姓名',
`idno` varchar(50) DEFAULT NULL COMMENT '身份证号',
`age` varchar(11) DEFAULT NULL COMMENT '年龄',
`sex` char(1) DEFAULT '1' COMMENT '性别，‘0’女，‘1’男',
`hometown` varchar(50) DEFAULT NULL COMMENT '籍贯',
`nationality` varchar(50) DEFAULT NULL COMMENT '民族',
`address` varchar(50) DEFAULT NULL COMMENT '家庭住址',
`phone` varchar(50) DEFAULT NULL COMMENT '电话号码',
`sclassno` varchar(11) DEFAULT NULL COMMENT '学生班级编号',
PRIMARY KEY (`sno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

####班级表
CREATE TABLE `t_class` (
`sclassno` int(11) NOT NULL COMMENT '班级编号',
`sclassname` varchar(50) NOT NULL COMMENT '班级名称',
PRIMARY KEY (`sclassno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
####成绩表
CREATE TABLE `t_achievement` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
`sno` int(11) NOT NULL COMMENT '学号',
`semester` varchar(50) DEFAULT NULL COMMENT '学期',
`Chinese` varchar(3) DEFAULT '0' COMMENT '语文',
`mathematics` varchar(3) DEFAULT '0' COMMENT '数学',
`English` varchar(3) DEFAULT '0' COMMENT '英语',
`physics` varchar(3) DEFAULT '0' COMMENT '物理',
`chemistry` varchar(3) DEFAULT '0' COMMENT '化学',
`biology` varchar(3) DEFAULT '0' COMMENT '生物',
`geography` varchar(3) DEFAULT '0' COMMENT '地理',
`history` varchar(3) DEFAULT '0' COMMENT '历史',
`politics` varchar(3) DEFAULT '0' COMMENT '政治',
`sports` varchar(3) DEFAULT '0' COMMENT '体育',
`music` varchar(3) DEFAULT '0' COMMENT '音乐',
`practice` varchar(3) DEFAULT '0' COMMENT '实践',
`java` varchar(3) DEFAULT '0',
`cplus` varchar(3) DEFAULT '0',
`python` varchar(3) DEFAULT '0',
`c` varchar(3) DEFAULT '0',
`html` varchar(3) DEFAULT '0',
`css` varchar(3) DEFAULT '0',
`javascript` varchar(3) DEFAULT '0',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
####教师表
CREATE TABLE `t_teacher` (
`tno` int(11) NOT NULL COMMENT '账号',
`tname` varchar(50) DEFAULT NULL COMMENT '姓名',
`tpassword` varchar(255) DEFAULT NULL COMMENT '密码',
`phone` varchar(50) DEFAULT NULL COMMENT '电话号码',
`email` varchar(50) DEFAULT NULL COMMENT '邮箱地址',
`admin` int(1) DEFAULT '0' COMMENT '系统权限',
PRIMARY KEY (`tno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

###4.功能

1.添加登录界面
2.添加jQuery3.5.1
3.添加layer
4.添加学生信息查询页面
  4.1.查询
  4.2.删除
  4.3.搜索


