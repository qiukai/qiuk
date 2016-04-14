/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : qiuk

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2016-04-14 20:55:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_user
-- ----------------------------
DROP TABLE IF EXISTS `log_user`;
CREATE TABLE `log_user` (
  `id` char(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `email` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '用户邮箱',
  `nick_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '用户昵称',
  `password` char(32) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `status` int(11) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `primary_id` char(32) COLLATE utf8_bin NOT NULL COMMENT '主表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表日志';

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` char(32) COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `email` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '用户邮箱',
  `nick_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '用户昵称',
  `password` char(32) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `status` int(11) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户的主要信息表';
