/*
 Navicat Premium Data Transfer

 Source Server         : rental
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 192.168.85.129:3306
 Source Schema         : cherryrental

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 17/05/2021 13:01:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_estate
-- ----------------------------
DROP TABLE IF EXISTS `tb_estate`;
CREATE TABLE `tb_estate`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼盘名称',
  `province` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在省',
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在市',
  `area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在区',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体地址',
  `year` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑年代',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑类型',
  `property_cost` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业费',
  `property_company` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业公司',
  `developers` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开发商',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1006 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '楼盘表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_estate
-- ----------------------------
INSERT INTO `tb_estate` VALUES (1001, '中远两湾城', '上海市', '上海市', '普陀区', '远景路97弄', '2001', '塔楼/板楼', '1.5', '上海中远物业管理发展有限公司', '上海万业企业股份有限公司', '2018-11-06 23:00:20', '2018-11-06 23:00:23');
INSERT INTO `tb_estate` VALUES (1002, '上海康城', '上海市', '上海市', '闵行区', '莘松路958弄', '2001', '塔楼/板楼', '1.5', '盛孚物业', '闵行房地产', '2018-11-06 23:02:30', '2018-11-27 23:02:33');
INSERT INTO `tb_estate` VALUES (1003, '保利西子湾', '上海市', '上海市', '松江区', '广富林路1188弄', '2008', '塔楼/板楼', '1.75', '上海保利物业管理', '上海城乾房地产开发有限公司', '2018-11-06 23:04:22', '2018-11-06 23:04:25');
INSERT INTO `tb_estate` VALUES (1004, '万科城市花园', '上海市', '上海市', '松江区', '广富林路1188弄', '2002', '塔楼/板楼', '1.5', '上海保利物业管理', '上海城乾房地产开发有限公司', '2018-11-13 16:43:40', '2018-11-13 16:43:42');
INSERT INTO `tb_estate` VALUES (1005, '上海阳城', '上海市', '上海市', '闵行区', '罗锦路888弄', '2002', '塔楼/板楼', '1.5', '上海莲阳物业管理有限公司', '上海莲城房地产开发有限公司', '2018-11-06 23:23:52', '2018-11-06 23:23:55');

-- ----------------------------
-- Table structure for tb_house_resources
-- ----------------------------
DROP TABLE IF EXISTS `tb_house_resources`;
CREATE TABLE `tb_house_resources`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房源标题',
  `estate_id` bigint(20) NULL DEFAULT NULL COMMENT '楼盘id',
  `building_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼号（栋）',
  `building_unit` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单元号',
  `building_floor_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门牌号',
  `rent` int(10) NULL DEFAULT NULL COMMENT '租金',
  `rent_method` tinyint(1) NULL DEFAULT NULL COMMENT '租赁方式，1-整租，2-合租',
  `payment_method` tinyint(1) NULL DEFAULT NULL COMMENT '支付方式，1-付一押一，2-付三押一，3-付六押一，4-年付押一，5-其它',
  `house_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户型，如：2室1厅1卫',
  `covered_area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑面积',
  `use_area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用面积',
  `floor` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼层，如：8/26',
  `orientation` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '朝向：东、南、西、北',
  `decoration` tinyint(1) NULL DEFAULT NULL COMMENT '装修，1-精装，2-简装，3-毛坯',
  `facilities` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配套设施， 如：1,2,3',
  `pic` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片，最多5张',
  `house_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `contact` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `time` tinyint(1) NULL DEFAULT NULL COMMENT '看房时间，1-上午，2-中午，3-下午，4-晚上，5-全天',
  `property_cost` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业费',
  `created` datetime(0) NULL DEFAULT NULL,
  `updated` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ss`(`title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '房源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_house_resources
-- ----------------------------
INSERT INTO `tb_house_resources` VALUES (1, '夫额外了', 1002, '88', '19', '11', 1000, 1, 2, '3室2厅8卫1厨2阳台', '99', '88', '12/33', '南', 1, '1,2,3,4,6,5', 'http://image.cherryrental.com/images/2020/04/17/2020041701213952705690.png,http://image.cherryrental.com/images/2020/04/17/2020041701222432703358.jpg', NULL, 'jjaxks', '13388138471', 1, '6', '2020-04-17 13:23:49', '2020-04-17 14:13:13');
INSERT INTO `tb_house_resources` VALUES (2, 'Yankee 3室1厅独卫1间', 1005, '21', '19', '11', 2400, 2, 1, '3室2厅1卫1厨2阳台', '110', '89', '12/33', '南', 1, '1,2,3', 'http://image.cherryrental.com/images/2020/04/13/2020041308041720503541.jpg,http://image.cherryrental.com/images/2020/04/13/2020041308042276703316.jpg,http://image.cherryrental.com/images/2020/04/13/2020041308042982003886.jpg', NULL, 'cherry', '15151811111', 1, '6', '2020-04-11 12:18:17', '2020-04-11 12:18:17');
INSERT INTO `tb_house_resources` VALUES (11, '中安3室1厅独卫1间', 1008, '6', '12', '8', 3000, 1, 2, '3室1厅1卫1厨1阳台', '98', '87', '12/23', '南', 1, '1,2,3', 'http://image.cherryrental.com/images/2020/04/11/2020041107282318503947.jpg,http://image.cherryrental.com/images/2020/04/11/2020041107282714804623.jpg', NULL, '终南山', '1377367722', 4, '2', '2020-04-11 19:28:38', '2020-04-11 19:28:38');
INSERT INTO `tb_house_resources` VALUES (12, 'hi里的卡萨活佛', 1005, '6', '19', '11', 1890, 1, 2, '1室2厅3卫1厨2阳台', '110', '89', '12/23', '南', 1, '1,2,3', 'http://image.cherryrental.com/images/2020/04/13/2020041308041720503541.jpg,http://image.cherryrental.com/images/2020/04/13/2020041308042276703316.jpg,http://image.cherryrental.com/images/2020/04/13/2020041308042982003886.jpg', NULL, '威威', '15151811111', 1, '1', '2020-04-13 20:04:36', '2020-04-13 20:04:36');
INSERT INTO `tb_house_resources` VALUES (13, '石头人', 1004, '11', '1', '2', 1233, 1, 3, '2室1厅1卫1厨1阳台', '110', '89', '12/33', '东', 1, '1,2,3', 'http://image.cherryrental.com/images/2020/04/17/2020041711124378606773.jpg,http://image.cherryrental.com/images/2020/04/17/2020041711125627905091.jpg', NULL, '威威额外', '1377367722', 1, '1', '2020-04-17 11:13:06', '2020-04-17 14:23:32');
INSERT INTO `tb_house_resources` VALUES (15, '东方曼哈顿 3室2厅 16000 元', 10044, '2', '1', '1', 1111, 1, 1, '1室1厅1卫1厨1阳台', '2', '2', '1/2', '南', 1, '1,2,3,8,9', 'http://image.cherryrental.com/images/2020/04/17/2020041711123972106471.jpg,http://image.cherryrental.com/images/2020/04/17/2020041711124378606773.jpg,http://image.cherryrental.com/images/2020/04/17/2020041711125627905091.jpg', '这个经纪人很懒 ，没写核心卖点', '张三', '11111111111', 1, '11', '2020-04-11 11:43:12', '2020-04-11 11:43:12');
INSERT INTO `tb_house_resources` VALUES (16, 'ww3室1厅独卫1间', 11, '21', '19', '11', 2400, 1, 1, '3室2厅1卫1厨2阳台', '110', '89', '12/33', '南', 1, '1,2,3,5', '', NULL, '终南山', '15151811111', 1, '6', '2021-04-05 22:26:06', '2021-04-05 22:26:06');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone', 18, 'test1@baomidou.com');
INSERT INTO `user` VALUES (2, 'Jack', 20, 'test2@baomidou.com');
INSERT INTO `user` VALUES (3, 'Tom', 28, 'test3@baomidou.com');
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com');
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com');

SET FOREIGN_KEY_CHECKS = 1;
