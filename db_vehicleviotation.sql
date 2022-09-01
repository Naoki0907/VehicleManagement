/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : db_vehicleviotation

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-05-07 21:00:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `car_no` char(8) CHARACTER SET utf8 NOT NULL,
  `engine_no` varchar(16) NOT NULL,
  `vin` varchar(17) NOT NULL,
  PRIMARY KEY (`car_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('京A11111', '123456', '654321');
INSERT INTO `car` VALUES ('晋G77777', '789012', '210987');
INSERT INTO `car` VALUES ('沪B22222', '234567', '765432');
INSERT INTO `car` VALUES ('浙C33333', '345678', '876543');
INSERT INTO `car` VALUES ('粤E55555', '567890', '098765');
INSERT INTO `car` VALUES ('苏D44444', '456789', '987654');
INSERT INTO `car` VALUES ('鲁F66666', '678901', '109876');

-- ----------------------------
-- Table structure for punish
-- ----------------------------
DROP TABLE IF EXISTS `punish`;
CREATE TABLE `punish` (
  `punish_id` varchar(10) NOT NULL,
  `punish_flag` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`punish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of punish
-- ----------------------------
INSERT INTO `punish` VALUES ('100001', '已办理');
INSERT INTO `punish` VALUES ('100002', '未办理');
INSERT INTO `punish` VALUES ('100003', '未办理');
INSERT INTO `punish` VALUES ('100004', '未办理');
INSERT INTO `punish` VALUES ('100005', '未办理');
INSERT INTO `punish` VALUES ('100006', '未办理');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `LoginName` varchar(50) NOT NULL,
  `LoginPwd` varchar(32) NOT NULL,
  `CreateTime` datetime NOT NULL DEFAULT '2019-04-02 00:00:00',
  `Role` varchar(5) NOT NULL,
  `car_no` char(8) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `LoginName` (`LoginName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '2019-08-06 17:38:16', '0', null);
INSERT INTO `user` VALUES ('2', 'daxiang', 'E10ADC3949BA59ABBE56E057F20F883E', '2019-08-06 17:38:16', '0', null);
INSERT INTO `user` VALUES ('3', 'a123', 'E10ADC3949BA59ABBE56E057F20F883E', '2019-08-05 17:38:16', '0', null);
INSERT INTO `user` VALUES ('4', 'b123', 'E10ADC3949BA59ABBE56E057F20F883E', '2019-08-06 17:38:16', '0', null);
INSERT INTO `user` VALUES ('5', 'c123', 'E10ADC3949BA59ABBE56E057F20F883E', '2019-08-06 17:38:16', '0', null);
INSERT INTO `user` VALUES ('6', '123456', 'E10ADC3949BA59ABBE56E057F20F883E', '2019-08-06 17:38:16', '0', null);
INSERT INTO `user` VALUES ('7', 'xiaoming', 'e10adc3949ba59abbe56e057f20f883e', '2019-08-06 22:28:30', '0', null);
INSERT INTO `user` VALUES ('8', 'admin1', 'E10ADC3949BA59ABBE56E057F20F883E', '2019-08-07 17:08:22', '0', null);
INSERT INTO `user` VALUES ('9', 'Nagase', '3e819e63f9dc4df405637c81d891a5d5', '2019-04-02 00:00:00', '0', null);
INSERT INTO `user` VALUES ('10', '111', '698d51a19d8a121ce581499d7b701668', '2019-04-02 00:00:00', '0', null);

-- ----------------------------
-- Table structure for viotation
-- ----------------------------
DROP TABLE IF EXISTS `viotation`;
CREATE TABLE `viotation` (
  `viotation_id` varchar(5) NOT NULL,
  `viotation_detail` varchar(100) CHARACTER SET utf8 NOT NULL,
  `fine` int(5) NOT NULL,
  `deduct` int(5) NOT NULL,
  `punish_id` varchar(10) NOT NULL,
  `viotation_date` datetime NOT NULL,
  `car_no` char(8) CHARACTER SET utf8 NOT NULL,
  `viotation_place` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`viotation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of viotation
-- ----------------------------
INSERT INTO `viotation` VALUES ('1106', '驾驶中型以上载客汽车以外的机动车行驶超过规定时速未达20%', '50', '3', '100008', '2019-03-05 16:04:07', '粤E55555', 'G路口');
INSERT INTO `viotation` VALUES ('1223', '驾驶时拨打接听手持电话', '100', '2', '100001', '2019-03-26 12:38:00', '京A11111', 'A路口');
INSERT INTO `viotation` VALUES ('1226', '连续驾驶机动车超过4小时未停车休息', '200', '2', '100005', '2019-01-31 17:54:00', '浙C33333', 'S765');
INSERT INTO `viotation` VALUES ('1230', '机动车违反禁止标线指示', '200', '2', '100002', '2019-03-27 15:57:00', '京A11111', 'B路口');
INSERT INTO `viotation` VALUES ('1232', '机动车违反警告标线指示的', '50', '2', '100006', '2019-02-16 18:34:00', '苏D44444', 'E路口');
INSERT INTO `viotation` VALUES ('1302', '机动车不按交通信号灯规定通行', '200', '3', '100003', '2019-03-14 09:13:00', '沪B22222', 'C路口');
INSERT INTO `viotation` VALUES ('1304', '机动车行驶超过规定时速50%以下', '150', '3', '100004', '2019-08-07 14:22:00', '沪B22222', 'D路口');
INSERT INTO `viotation` VALUES ('1305', '机动车不按交通信号灯规定通行', '200', '3', '100007', '2019-09-03 13:44:56', '苏D44444', 'F路口');
