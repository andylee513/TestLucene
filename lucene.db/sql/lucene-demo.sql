/*
Navicat MySQL Data Transfer

Source Server         : localhost_mysql
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : lucene-demo

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-07-26 15:11:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'java入门', '介绍java基础知识', 'java', 'www.baicu.com');
INSERT INTO `blog` VALUES ('2', 'java高级', '介绍java高级知识', 'java,', 'www.delta.com');
INSERT INTO `blog` VALUES ('3', 'C++入门', 'C++基础知识', 'C++,基础', 'www.google');
