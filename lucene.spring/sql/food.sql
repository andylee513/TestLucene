/*
Navicat MySQL Data Transfer

Source Server         : localhost_mysql
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : food

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-07-27 09:59:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `foodid` int(11) DEFAULT NULL,
  `foodname` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `imagepath` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('6', '橙子水果', '54.00', 'c://aaaa');
INSERT INTO `food` VALUES ('2', '橘子水果', '3.00', 'c://bbb');
INSERT INTO `food` VALUES ('3', '苹果果汁', '67.00', 'c://ccc');
INSERT INTO `food` VALUES ('4', '苹果块', '23.00', 'c://ddd');
INSERT INTO `food` VALUES ('5', '葡萄水果', '34.00', 'c://ddd');
INSERT INTO `food` VALUES ('7', '苹果水果', '53.00', 'c://aaaa');
INSERT INTO `food` VALUES ('8', '梨水果', '52.00', 'c://aaaa');
INSERT INTO `food` VALUES ('9', '香蕉水果', '52.00', 'c://aaaa');
INSERT INTO `food` VALUES ('10', '李子水果', '51.00', 'c://aaaa');
INSERT INTO `food` VALUES ('1', '苹果水果', '5.00', 'c://aaaa');
INSERT INTO `food` VALUES ('11', '香蕉汁', '4.00', 'c://bba');
