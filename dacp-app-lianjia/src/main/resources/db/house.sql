/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.20
Source Server Version : 50632
Source Host           : 192.168.1.20:3306
Source Database       : z_wangguang_test

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-05-10 18:12:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `subtitle` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fav_count` int(255) DEFAULT NULL,
  `cart_count` int(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `unit_price` decimal(10,2) DEFAULT NULL,
  `first_pay_price` decimal(10,2) DEFAULT NULL,
  `tax_price` decimal(10,2) DEFAULT NULL,
  `room_main_info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `room_main_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `room_sub_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `area_main_info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `area_sub_info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `community_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `area_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `school_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tags` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `decorating_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `house_type_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `investment_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `village_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `school_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `selling_point_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `reason4sale_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `supporting_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `traffic_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `base_content1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content4` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content5` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content6` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content7` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content8` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content9` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content10` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content11` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `base_content12` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content4` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content5` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content6` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content7` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content8` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content9` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `transaction_content10` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `html` mediumtext COLLATE utf8_bin,
  `chengjiao_price` decimal(10,2) DEFAULT NULL,
  `room_sub_info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `room_size` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
