/*
 Navicat Premium Data Transfer

 Source Server         : rental
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 192.168.85.129:3306
 Source Schema         : myhome

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 17/05/2021 13:03:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answers
-- ----------------------------
DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `answer_status` tinyint(2) NULL DEFAULT NULL,
  `answer_time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answers
-- ----------------------------
INSERT INTO `answers` VALUES (1, '大概1个月', 2, NULL, NULL, 11);
INSERT INTO `answers` VALUES (2, '各种费用', 1, NULL, NULL, 33);
INSERT INTO `answers` VALUES (3, '阿斯蒂芬', 1, NULL, NULL, 12);
INSERT INTO `answers` VALUES (4, 'asdfasdf', 2, NULL, NULL, 22);

-- ----------------------------
-- Table structure for chatinfos
-- ----------------------------
DROP TABLE IF EXISTS `chatinfos`;
CREATE TABLE `chatinfos`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_user` int(11) NULL DEFAULT NULL,
  `to_user` int(11) NULL DEFAULT NULL,
  `chat_time` bigint(13) NULL DEFAULT NULL,
  `chat_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `info_type` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chatinfos
-- ----------------------------
INSERT INTO `chatinfos` VALUES (1, 1, 4, 1531045313395, '123123阿斯顿发生阿斯顿发斯蒂芬', NULL);
INSERT INTO `chatinfos` VALUES (2, 4, 1, 1531045313395, '2332423', NULL);
INSERT INTO `chatinfos` VALUES (3, 1, 3, 1531045313395, '12213123', NULL);
INSERT INTO `chatinfos` VALUES (4, 1, 3, 1531045313395, '12', NULL);
INSERT INTO `chatinfos` VALUES (5, 1, 3, 1531045313395, '12', NULL);
INSERT INTO `chatinfos` VALUES (6, 1, 3, 1531045313395, '1212', NULL);
INSERT INTO `chatinfos` VALUES (7, 1, 5, 1531045313395, '21', NULL);
INSERT INTO `chatinfos` VALUES (8, 1, 5, 1531045313395, '21', NULL);
INSERT INTO `chatinfos` VALUES (9, 1, 5, 1531045313395, '21', NULL);
INSERT INTO `chatinfos` VALUES (10, 1, 5, 1531045313395, '21', NULL);
INSERT INTO `chatinfos` VALUES (11, 1, 4, 1531045313395, 'asdfasdf', NULL);
INSERT INTO `chatinfos` VALUES (12, 1, 4, 1531045313395, 'asdfasdf', NULL);
INSERT INTO `chatinfos` VALUES (13, 4, 1, 1531045313395, 'qqqqqqqqqqqqqqq', NULL);
INSERT INTO `chatinfos` VALUES (14, 4, 1, 1531045313395, 'qqqqqqqqqqqqqqq', NULL);
INSERT INTO `chatinfos` VALUES (15, 1, 4, 1531045313395, 'asdfasdf', NULL);
INSERT INTO `chatinfos` VALUES (16, 4, 1, 1531045325852, 'qqqqqqqqqqqqqqq', NULL);
INSERT INTO `chatinfos` VALUES (17, 4, 1, 1531045370933, '111111111111111111111111111', NULL);
INSERT INTO `chatinfos` VALUES (18, 1, 4, 1531045556105, 'ddddd', NULL);
INSERT INTO `chatinfos` VALUES (19, 1, 4, 1531045661187, 'ddddd', NULL);
INSERT INTO `chatinfos` VALUES (20, 4, 1, 1531046801236, 'ffffffffffff', NULL);
INSERT INTO `chatinfos` VALUES (21, 1, 4, 1531046808033, 'qqqqqqqqqqq', NULL);
INSERT INTO `chatinfos` VALUES (22, 1, 4, 1531046885117, 'qqqqqqqqqqq', NULL);
INSERT INTO `chatinfos` VALUES (23, 4, 1, 1531046894848, 'ffffffffffff', NULL);
INSERT INTO `chatinfos` VALUES (24, 1, 4, 1531046914735, 'qqqqqqqqqqq', NULL);
INSERT INTO `chatinfos` VALUES (25, 4, 1, 1531046939552, 'ffffffffffff', NULL);
INSERT INTO `chatinfos` VALUES (26, 4, 1, 1531047011310, 'xxxxxxxxxxxx', NULL);
INSERT INTO `chatinfos` VALUES (27, 1, 4, 1531048063180, 'ff', NULL);
INSERT INTO `chatinfos` VALUES (28, 4, 1, 1531048083611, 'cc', NULL);
INSERT INTO `chatinfos` VALUES (29, 1, 4, 1531048211102, 'qq', NULL);
INSERT INTO `chatinfos` VALUES (30, 4, 1, 1531048221818, 'zzzzz', NULL);
INSERT INTO `chatinfos` VALUES (31, 1, 4, 1531048508556, '1123', NULL);
INSERT INTO `chatinfos` VALUES (32, 1, 4, 1531048645638, 'q1', NULL);
INSERT INTO `chatinfos` VALUES (33, 1, 4, 1531048716097, 'q2', NULL);
INSERT INTO `chatinfos` VALUES (34, 1, 4, 1531051755172, '11', NULL);
INSERT INTO `chatinfos` VALUES (35, 4, 1, 1531051882470, '123', NULL);
INSERT INTO `chatinfos` VALUES (36, 1, 4, 1531051904051, '12333', NULL);
INSERT INTO `chatinfos` VALUES (37, 1, 4, 1531052012222, 'asfdasd', NULL);
INSERT INTO `chatinfos` VALUES (38, 4, 1, 1531052026630, 'asdfasdfsafasdf', NULL);
INSERT INTO `chatinfos` VALUES (39, 1, 4, 1531052106458, 'aaaaaaaa', NULL);
INSERT INTO `chatinfos` VALUES (40, 4, 1, 1531052223896, 'asdfasdf', NULL);
INSERT INTO `chatinfos` VALUES (41, 1, 4, 1531052230472, 'asdfasdfs', NULL);
INSERT INTO `chatinfos` VALUES (42, 1, 4, 1531052293531, 'asdfasdf', NULL);
INSERT INTO `chatinfos` VALUES (43, 1, 4, 1531052463653, 'asdfasdf', NULL);
INSERT INTO `chatinfos` VALUES (44, 4, 1, 1531052472240, '34', NULL);
INSERT INTO `chatinfos` VALUES (45, 1, 4, 1531052483350, 'asdfasdfasdf', NULL);
INSERT INTO `chatinfos` VALUES (46, 1, 4, 1531052551695, '11', NULL);
INSERT INTO `chatinfos` VALUES (47, 4, 1, 1531052557989, '22', NULL);
INSERT INTO `chatinfos` VALUES (48, 1, 4, 1531052567608, '33', NULL);
INSERT INTO `chatinfos` VALUES (49, 4, 1, 1531052988841, '22ggggg', NULL);
INSERT INTO `chatinfos` VALUES (50, 1, 4, 1531053000380, '3377777', NULL);
INSERT INTO `chatinfos` VALUES (51, 4, 1, 1534671948813, 'adfasdfsadf', NULL);
INSERT INTO `chatinfos` VALUES (52, 1, 4, 1534671981066, 'asdfasdfadsf', NULL);
INSERT INTO `chatinfos` VALUES (53, 1, 4, 1534671985657, 'asdfasdfadsfasdfasdf', NULL);
INSERT INTO `chatinfos` VALUES (54, 1, 4, 1534672132633, '你好', NULL);
INSERT INTO `chatinfos` VALUES (55, 4, 1, 1534672157322, '你也好', NULL);
INSERT INTO `chatinfos` VALUES (56, 1, 4, 1534672173177, '你更好', NULL);
INSERT INTO `chatinfos` VALUES (57, 1, 4, 1534672204390, 'hello', NULL);
INSERT INTO `chatinfos` VALUES (58, 1, 4, 1534749788241, '123', NULL);
INSERT INTO `chatinfos` VALUES (59, 4, 1, 1534749800342, 'nihao', NULL);
INSERT INTO `chatinfos` VALUES (60, 1, 4, 1534749915288, '1', NULL);
INSERT INTO `chatinfos` VALUES (61, 4, 1, 1534750017542, '2', NULL);
INSERT INTO `chatinfos` VALUES (62, 4, 1, 1534750095142, '123', NULL);
INSERT INTO `chatinfos` VALUES (63, 1, 4, 1534750113016, '111', NULL);
INSERT INTO `chatinfos` VALUES (64, 1, 4, 1534752091940, 'adsf', NULL);
INSERT INTO `chatinfos` VALUES (65, 4, 1, 1534752107251, '111', NULL);
INSERT INTO `chatinfos` VALUES (66, 1, 4, 1534752412046, '你好', NULL);
INSERT INTO `chatinfos` VALUES (67, 4, 1, 1534752426778, '你也好', NULL);

-- ----------------------------
-- Table structure for homeimgs
-- ----------------------------
DROP TABLE IF EXISTS `homeimgs`;
CREATE TABLE `homeimgs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `home_id` int(11) NULL DEFAULT NULL,
  `img_status` tinyint(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homeimgs
-- ----------------------------

-- ----------------------------
-- Table structure for homes
-- ----------------------------
DROP TABLE IF EXISTS `homes`;
CREATE TABLE `homes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `home_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `home_price` decimal(10, 0) NULL DEFAULT NULL,
  `home_desc` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `home_infos` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `home_type` tinyint(2) NULL DEFAULT NULL,
  `home_tags` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `home_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `home_status` tinyint(2) NULL DEFAULT NULL,
  `home_time` bigint(13) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homes
-- ----------------------------
INSERT INTO `homes` VALUES (1, '安贞西里123', 4511, '72.32㎡/南 北/低楼层', NULL, 1, '海淀,昌平', NULL, NULL, NULL, 12);
INSERT INTO `homes` VALUES (2, '安贞西里 三室一厅', 4533, '72.32㎡/南 北/低楼层', NULL, 1, '海淀', NULL, NULL, NULL, 1212);
INSERT INTO `homes` VALUES (3, '安贞西里 三室一厅', 4220, '72.32㎡/南 北/低楼层', NULL, 2, '海淀', NULL, NULL, NULL, 1);
INSERT INTO `homes` VALUES (4, '安贞西里 三室一厅', 4500, '72.32㎡/南 北/低楼层', '4500', 2, '海淀', '', NULL, NULL, 12);
INSERT INTO `homes` VALUES (5, '安贞西里 三室一厅', 4522, '72.32㎡/南 北/低楼层', NULL, 3, '海淀', NULL, NULL, NULL, 23);
INSERT INTO `homes` VALUES (6, '安贞西里 三室一厅', 4500, '72.32㎡/南 北/低楼层', NULL, 3, '海淀', NULL, NULL, NULL, 1221);
INSERT INTO `homes` VALUES (7, '安贞西里 三室一厅', 4500, '72.32㎡/南 北/低楼层', NULL, 2, '海淀', NULL, NULL, NULL, 23);
INSERT INTO `homes` VALUES (8, '安贞西里 三室一厅', 4500, '72.32㎡/南 北/低楼层', NULL, 1, '海淀', NULL, NULL, NULL, 23);
INSERT INTO `homes` VALUES (9, '安贞西里 三室一厅', 4500, '72.32㎡/南 北/低楼层', NULL, 4, '海淀', NULL, NULL, NULL, 23);

-- ----------------------------
-- Table structure for informations
-- ----------------------------
DROP TABLE IF EXISTS `informations`;
CREATE TABLE `informations`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `info_thumb` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `info_time` int(11) NULL DEFAULT NULL,
  `info_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `info_status` tinyint(2) NULL DEFAULT NULL,
  `info_type` tinyint(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of informations
-- ----------------------------
INSERT INTO `informations` VALUES (1, '房企半年销售业绩继', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `informations` VALUES (2, '上半年土地市场两重天：一线降温三四线量价齐升', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `informations` VALUES (3, '上半年土地市场两重天：一线降温三四线量价齐升', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `informations` VALUES (4, '上半年土地市场两重天：一线降温三四线量价齐升', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `informations` VALUES (5, '房企半年销售业绩继续冲高三巨头销售额过亿', NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `informations` VALUES (6, '房企半年销售业绩继续冲高三巨头销售额过亿', NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `informations` VALUES (7, '房企半年销售业绩继续冲高三巨头销售额过亿', NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `informations` VALUES (8, '房企半年销售业绩继续冲高三巨头销售额过亿', NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `informations` VALUES (9, '房企半年销售业绩继续冲高三巨头销售额过亿', NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `informations` VALUES (10, '房企半年销售业绩继续冲高三巨头销售额过亿', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `informations` VALUES (11, '房企半年销售业绩继续冲高三巨头销售额过亿', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `informations` VALUES (12, '房企半年销售业绩继', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `informations` VALUES (13, 'wwwwwwwwwwwww', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `informations` VALUES (14, '房企半年销售业绩继续冲高三巨头销售额过亿', NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `informations` VALUES (15, '房企半年销售业绩继续冲高三巨头销售额过亿', NULL, NULL, NULL, NULL, NULL, 3);

-- ----------------------------
-- Table structure for map
-- ----------------------------
DROP TABLE IF EXISTS `map`;
CREATE TABLE `map`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `x` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `y` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map
-- ----------------------------
INSERT INTO `map` VALUES (1, '116.43244', '39.929986', 1);
INSERT INTO `map` VALUES (2, '116.424355', '39.92982', 1);
INSERT INTO `map` VALUES (3, '116.423349', '39.935214', 1);
INSERT INTO `map` VALUES (4, '116.350444', '39.931645', 1);
INSERT INTO `map` VALUES (5, '116.351684', '39.91867', 1);
INSERT INTO `map` VALUES (6, '116.353983', '39.913855', 1);
INSERT INTO `map` VALUES (7, '116.357253', '39.923152', 1);
INSERT INTO `map` VALUES (8, '116.349168', '39.923152', 1);
INSERT INTO `map` VALUES (9, '116.354954', '39.935767', 1);
INSERT INTO `map` VALUES (10, '116.36232', '39.938339', 1);
INSERT INTO `map` VALUES (11, '116.374249', '39.94625', 1);
INSERT INTO `map` VALUES (12, '116.380178', '39.953053', 1);

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `menu_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `menu_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `menu_status` tinyint(2) NULL DEFAULT NULL,
  `menu_style` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES (1, '二手房', 'home', '/home', 1, NULL);
INSERT INTO `menus` VALUES (2, '新房', NULL, NULL, NULL, NULL);
INSERT INTO `menus` VALUES (3, '租房', NULL, NULL, NULL, NULL);
INSERT INTO `menus` VALUES (4, '海外', NULL, NULL, NULL, NULL);
INSERT INTO `menus` VALUES (5, '地图找房', NULL, NULL, NULL, NULL);
INSERT INTO `menus` VALUES (6, '查公交', NULL, NULL, NULL, NULL);
INSERT INTO `menus` VALUES (7, '计算器', NULL, NULL, NULL, NULL);
INSERT INTO `menus` VALUES (8, '问答', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `question_time` int(11) NULL DEFAULT NULL,
  `question_tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES (1, '在北京买房，需要支付的税费有哪些？', 1, NULL, '学区,海淀');
INSERT INTO `questions` VALUES (2, '一般首付之后，贷款多久可以下来？', 1, NULL, '学区,昌平');
INSERT INTO `questions` VALUES (3, '按时发生', 1, NULL, '学区,昌平');
INSERT INTO `questions` VALUES (4, 'asdfasdfasda', 4, 2147483647, '学区,昌平');
INSERT INTO `questions` VALUES (5, 'asfsadfsaf', 4, 2147483647, '学区,昌平');
INSERT INTO `questions` VALUES (6, 'sadsad', 4, 2147483647, '学区,昌平');
INSERT INTO `questions` VALUES (7, 'adsfasdf', 1, 2147483647, NULL);
INSERT INTO `questions` VALUES (8, 'afdasdfasdfadsf', 1, 2147483647, NULL);
INSERT INTO `questions` VALUES (9, '你好', 1, 2147483647, NULL);
INSERT INTO `questions` VALUES (10, 'asdfsdf', 1, 2147483647, NULL);

-- ----------------------------
-- Table structure for swipes
-- ----------------------------
DROP TABLE IF EXISTS `swipes`;
CREATE TABLE `swipes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `original_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `thumbnail_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` tinyint(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of swipes
-- ----------------------------
INSERT INTO `swipes` VALUES (1, 'public/1.png', 'pic-thumb1.png', NULL);
INSERT INTO `swipes` VALUES (2, 'public/2.png', 'pic-thumb2.png', NULL);
INSERT INTO `swipes` VALUES (3, 'public/3.png', 'pic-thumb3.png', NULL);

-- ----------------------------
-- Table structure for tb_ad
-- ----------------------------
DROP TABLE IF EXISTS `tb_ad`;
CREATE TABLE `tb_ad`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(10) NULL DEFAULT NULL COMMENT '广告类型',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片URL地址',
  `created` datetime(0) NULL DEFAULT NULL,
  `updated` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_ad
-- ----------------------------
INSERT INTO `tb_ad` VALUES (1, 1, 'UniCity万科天空之城', ',http://image.cherryrental.com/images/2020/04/13/2020041308042276703316.jpg', '2018-11-26 11:28:49', '2018-11-26 11:28:51');
INSERT INTO `tb_ad` VALUES (2, 1, '天和尚海庭前', 'http://image.cherryrental.com/images/2020/04/13/2020041308041720503541.jpg', '2018-11-26 11:29:27', '2018-11-26 11:29:29');
INSERT INTO `tb_ad` VALUES (3, 1, '[奉贤 南桥] 光语著', 'http://image.cherryrental.com/images/2020/04/11/2020041107282318503947.jpg', '2018-11-26 11:30:04', '2018-11-26 11:30:06');
INSERT INTO `tb_ad` VALUES (4, 1, '[上海周边 嘉兴] 融创海逸长洲', 'http://image.cherryrental.com/images/2020/04/13/2020041308042982003886.jpg', '2018-11-26 11:30:49', '2018-11-26 11:30:53');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `weixin` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `type` int(2) NULL DEFAULT NULL,
  `avatar` mediumtext CHARACTER SET utf8 COLLATE utf8_bin NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'tom', '123', '123', 'qqq', 'qqq', '111', 1, 1, 'public/icon.png');
INSERT INTO `users` VALUES (2, 'jerry', '123', NULL, NULL, NULL, NULL, NULL, NULL, 'public/icon.png');
INSERT INTO `users` VALUES (3, 'spike', '123', NULL, NULL, NULL, NULL, NULL, NULL, 'public/icon.png');
INSERT INTO `users` VALUES (4, 'abc', '1234', NULL, NULL, NULL, NULL, NULL, NULL, 'public/icon.png');
INSERT INTO `users` VALUES (5, 'asfdasdf', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'public/icon.png');
INSERT INTO `users` VALUES (6, 'Mau', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
