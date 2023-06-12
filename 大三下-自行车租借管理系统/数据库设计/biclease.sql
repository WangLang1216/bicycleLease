/*
 Navicat Premium Data Transfer

 Source Server         : wanglang
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : biclease

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 12/06/2023 20:18:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bicycleimages
-- ----------------------------
DROP TABLE IF EXISTS `bicycleimages`;
CREATE TABLE `bicycleimages`  (
  `bicycleimages_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '产品附属图片编号',
  `bicycleinfo_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '自行车编号',
  `b_image` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片名称\r\n图片名称\r\n图片名称',
  `b_imgurl` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片地址',
  PRIMARY KEY (`bicycleimages_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycleimages
-- ----------------------------
INSERT INTO `bicycleimages` VALUES ('1', '1', 'Propel Advanced SL 0', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220819/166087296229868.jpg');
INSERT INTO `bicycleimages` VALUES ('10', '2', 'Propel Advanced SL 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220819/166087340350457.jpg');
INSERT INTO `bicycleimages` VALUES ('11', '3', 'Propel Advanced Pro 0 Di', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220822/166113373956160.jpg');
INSERT INTO `bicycleimages` VALUES ('12', '3', 'Propel Advanced Pro 0 Di', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220822/166113352351522.jpg');
INSERT INTO `bicycleimages` VALUES ('13', '3', 'Propel Advanced Pro 0 Di', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220822/166113352322240.jpg');
INSERT INTO `bicycleimages` VALUES ('14', '3', 'Propel Advanced Pro 0 Di', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220822/166113352575585.jpg');
INSERT INTO `bicycleimages` VALUES ('15', '4', 'TCX Espoir 24', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220907/166251826393695.jpg');
INSERT INTO `bicycleimages` VALUES ('16', '4', 'TCX Espoir 24', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220907/166251822188492.jpg');
INSERT INTO `bicycleimages` VALUES ('17', '4', 'TCX Espoir 24', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220907/166251822639049.jpg');
INSERT INTO `bicycleimages` VALUES ('18', '5', 'TCR Advanced SL Disc Team', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230402/168040467419876.jpg');
INSERT INTO `bicycleimages` VALUES ('19', '6', 'TCR Advanced Disc 3', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230116/167384732130805.png');
INSERT INTO `bicycleimages` VALUES ('2', '1', 'Propel Advanced SL 0', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230519/168445705542796.jpg');
INSERT INTO `bicycleimages` VALUES ('20', '7', 'TCR SLR 1 Disc', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20221206/167029800773123.jpg');
INSERT INTO `bicycleimages` VALUES ('21', '7', 'TCR SLR 1 Disc', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20221206/167030834266128.jpg');
INSERT INTO `bicycleimages` VALUES ('22', '7', 'TCR SLR 1 Disc', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20221206/167030834396306.jpg');
INSERT INTO `bicycleimages` VALUES ('23', '8', 'TCR Advanced Pro 1 D-AX', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220906/166244949869689.jpg');
INSERT INTO `bicycleimages` VALUES ('24', '8', 'TCR Advanced Pro 1 D-AX', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220906/166244946891311.jpg');
INSERT INTO `bicycleimages` VALUES ('25', '8', 'TCR Advanced Pro 1 D-AX', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220906/166244947271145.jpg');
INSERT INTO `bicycleimages` VALUES ('26', '9', 'Revolt Advanced 0', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230116/167385238529094.jpg');
INSERT INTO `bicycleimages` VALUES ('27', '10', 'XTC Advanced 3', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230116/167385075637221.jpg');
INSERT INTO `bicycleimages` VALUES ('28', '10', 'XTC Advanced 3', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20230116/167385071347195.jp');
INSERT INTO `bicycleimages` VALUES ('29', '11', 'Revolt F 2', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220311/164696041957948.jpg');
INSERT INTO `bicycleimages` VALUES ('3', '1', 'Propel Advanced SL 0', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220819/166087296229868.jpg');
INSERT INTO `bicycleimages` VALUES ('30', '11', 'Revolt F 2', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220311/164696031219983.jpg');
INSERT INTO `bicycleimages` VALUES ('31', '12', 'Revolt F 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220311/164696002629188.jpg');
INSERT INTO `bicycleimages` VALUES ('32', '13', 'Fastroad 24 JR 2', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220908/166260013675672.jpg');
INSERT INTO `bicycleimages` VALUES ('33', '13', 'Fastroad 24 JR 2', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220908/166259905460021.jpg');
INSERT INTO `bicycleimages` VALUES ('34', '13', 'Fastroad 24 JR 2', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220908/166259907098099.jpg');
INSERT INTO `bicycleimages` VALUES ('35', '14', 'Fastroad 24 JR 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220908/166259772374492.jpg');
INSERT INTO `bicycleimages` VALUES ('36', '14', 'Fastroad 24 JR 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220908/166259749784838.jpg');
INSERT INTO `bicycleimages` VALUES ('37', '15', 'ATX 610 24', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220302/164620028541391.jpg');
INSERT INTO `bicycleimages` VALUES ('38', '15', 'ATX 610 24', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220302/164620012354903.jpg');
INSERT INTO `bicycleimages` VALUES ('39', '15', 'ATX 610 24', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220302/164620012918212.jpg');
INSERT INTO `bicycleimages` VALUES ('4', '2', 'Propel Advanced SL 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220819/166087311575580.jpg');
INSERT INTO `bicycleimages` VALUES ('40', '16', 'ATX 20-S', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220311/164695784220844.jpg');
INSERT INTO `bicycleimages` VALUES ('41', '16', 'ATX 20-S', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220311/164695767743385.jpg');
INSERT INTO `bicycleimages` VALUES ('5', '2', 'Propel Advanced SL 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220819/166087311866298.jpg');
INSERT INTO `bicycleimages` VALUES ('6', '2', 'Propel Advanced SL 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220819/166087343519287.jpg');
INSERT INTO `bicycleimages` VALUES ('7', '2', 'Propel Advanced SL 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220819/166087340148572.jpg');
INSERT INTO `bicycleimages` VALUES ('8', '2', 'Propel Advanced SL 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220819/166087340125555.jpg');
INSERT INTO `bicycleimages` VALUES ('9', '2', 'Propel Advanced SL 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/fileupload/20220819/166087340215700.jpg');

-- ----------------------------
-- Table structure for bicycleinfo
-- ----------------------------
DROP TABLE IF EXISTS `bicycleinfo`;
CREATE TABLE `bicycleinfo`  (
  `bicycleinfo_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '自行车编号',
  `store_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '店铺编号',
  `deposit_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '押金编号',
  `currentprice_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '时价编号',
  `b_brand` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '自行车品牌',
  `b_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '自行车名称',
  `b_type` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '自行车类型',
  `b_stock` int NOT NULL COMMENT '自行车库存，类型包含公路车，山地车',
  `b_image` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片名称',
  `b_imgurl` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片地址',
  `b_essay` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '自行车描述',
  PRIMARY KEY (`bicycleinfo_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycleinfo
-- ----------------------------
INSERT INTO `bicycleinfo` VALUES ('1', '1', '1', '1', 'GIANT', 'SL 01', '公路车', 14, 'Propel Advanced SL 0', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220819/166087296229868.jpg', '全新的Propel的设计理念基于AeroSystem超低风阻管型技术打造。通过分析管型形状、角度以及接合点，作为一个整体的系统每一个组成部件都显得尤为关键。空力系统管型重新设计，灵动的线条和优化的椭圆截背管型以最大限度减少阻力。 专属空力套件，标配两款专属设计的水壶架以遵循我们对空气动力学设计的理念，以最大限度地减少空气阻力。整合的空力水壶经过UCI认证可正式参赛。');
INSERT INTO `bicycleinfo` VALUES ('10', '1', '2', '1', 'GIANT', 'Advanced 3', '山地车', 0, 'XTC Advanced 3', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230116/167385075637221.jpg', '车架组专为100毫米前叉而设计，采用特定的复合叠层方案手工制作，该方案会根据车架尺寸而变化，以创造最佳的刚度重量比和恰到好处的垂直顺应性。它具有更宽的Boost轮毂间距，可提高车轮刚性并增加了轮胎的间隙，以及许多其他功能，几乎可让您在任何类型的地形上发挥其卓越性能。');
INSERT INTO `bicycleinfo` VALUES ('11', '1', '1', '1', 'GIANT', 'Revolt F 2', '山地车', 16, 'Revolt F 2', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220311/164696041957948.jpg', '类Gravel车型的舒适几何，满足城市通勤和短距离郊游宽胎设计，通过性、稳定性大大提高\n减震D型座垫杆，充分吸收骑行过程中的震动\n');
INSERT INTO `bicycleinfo` VALUES ('12', '3', '1', '1', 'GIANT', 'Revolt F 1', '山地车', 11, 'Revolt F 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220311/164696002629188.jpg', '类Gravel车型的舒适几何，满足城市通勤和短距离郊游宽胎设计，通过性、稳定性大大提高\n减震D型座垫杆，充分吸收骑行过程中的震动\n');
INSERT INTO `bicycleinfo` VALUES ('13', '1', '1', '1', 'GIANT', 'JR 2', '山地车', 4, 'Fastroad 24 JR 2', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220908/166260013675672.jpg', 'GIANT ALUXX青少年铝合金车架\n专为青少年设计，符合青少年公路车骑行几何，\n铝合金车架拥有轻量化结构，以及值得信赖的强度与刚性。\n');
INSERT INTO `bicycleinfo` VALUES ('14', '2', '1', '1', 'GIANT', 'JR 1', '山地车', 0, 'Fastroad 24 JR 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220908/166259772374492.jpg', 'GIANT ALUXX青少年铝合金车架\n专为青少年设计，符合青少年公路车骑行几何，\n铝合金车架拥有轻量化结构，以及值得信赖的强度与刚性。\n');
INSERT INTO `bicycleinfo` VALUES ('15', '1', '1', '1', 'GIANT', 'ATX 610 24', '山地车', 7, 'ATX 610 24', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220302/164620028541391.jpg', 'GIANT ALUXX轻量化铝合金技术打造， 坚固耐用的车架能够达到长久的陪伴。 专为青少年设计的车架，符合青少年的骑 乘几何。转把方便青少年使用，变速快速 精准。专用青少年坐垫更加适合青少年骑 行姿势，在单车上挥洒汗水。');
INSERT INTO `bicycleinfo` VALUES ('16', '1', '1', '1', 'GIANT', 'ATX 20-S', '山地车', 0, 'ATX 20-S', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220311/164695784220844.jpg', '突破自我经典重塑\n专为青少年定制的轻量化铝合金车架,强度与重量\n比进一步优化,同时采用传统管件成型与热处理工艺,保证骑行品质\n');
INSERT INTO `bicycleinfo` VALUES ('2', '2', '2', '2', 'GIANT', 'SL 1', '公路车', 11, 'Propel Advanced SL 1', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230519/168445705542796.jpg', '仅需一个4号内六角即可完成把立的更换以及调节垫片和车把。 车首部分经过完全重新设计，设计全新专属D型OverDrive Aero舵管，以及采用创新的Contact Aero车把和把立。 Contact Aero把立将所有线管均压入把立下方，更换把立无需重新走线，使更换部件更为容易，复杂度更低、契合度更高。 Contact Aero车把，整合式的外观拥有±10°可调节的车把角度，经过人体工学优化空力有更好的Fitting适应性。');
INSERT INTO `bicycleinfo` VALUES ('3', '1', '3', '1', 'GIANT', 'Pro 0 Di', '公路车', 5, 'Propel Advanced Pro 0 Di', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220822/166113373956160.jpg', '全新的Propel的设计理念基于AeroSystem超低风阻管型技术打造。\r\n\r\n通过分析管型形状、角度以及接合点，\r\n\r\n作为一个整体的系统每一个组成部件都显得尤为关键。\r\n\r\n空力系统管型重新设计，灵动的线条和优化的椭圆截背管型以最大限度减少阻力。\r\n\r\n专属空力套件，标配两款专属设计的水壶架以遵循我们对空气动力学设计的理念，\r\n\r\n以最大限度地减少空气阻力。整合的空力水壶经过UCI认证可正式参赛。');
INSERT INTO `bicycleinfo` VALUES ('6', '3', '1', '1', 'GIANT', 'Disc 3', '公路车', 0, 'TCR Advanced Disc 3', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230116/167384732130805.png', 'TCR Advanced Disc 3以更轻量的车架 提升爬坡效率，更强的踩踏刚性与更具空 气力学的整合式设计，让您的竞赛表现提 升至全新境界。油压碟刹在晴雨天气均能 保持一致的制动力，高刚性前叉让您在下 坡和压弯时自信操控。');
INSERT INTO `bicycleinfo` VALUES ('7', '1', '1', '1', 'GIANT', 'SLR 1 Disc', '公路车', 5, 'TCR SLR 1 Disc', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20221206/167029800773123.jpg', '捷安特顶级的ALUXX SLR铝合金制造工艺，车架采用三段抽管工艺，最薄仅0.7mm，M码相较于上一代TCR SL减重10%。\n使用同TCR ADV一致的极具真实空力的椭圆截尾管件造型，\n帮助TCR SLR 1 DISC在真实的骑乘环境内获得与TCR ADV高度匹配的气动性能。\n');
INSERT INTO `bicycleinfo` VALUES ('8', '1', '1', '1', 'GIANT', 'Pro 1 D-AX', '公路车', 23, 'TCR Advanced Pro 1 D-AX', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220906/166244949869689.jpg', '全能公路');
INSERT INTO `bicycleinfo` VALUES ('9', '2', '1', '1', 'GIANT', 'Advanced 0', '公路车', 1, 'Revolt Advanced 0', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230116/167385238529094.jpg', '准备好碾碎一些砾石吧！Revolt Advanced凭借其全新设计的车架提供丰富的拓展性和兼容性不牺牲性能和舒适度，让您在崎岖不平的道路、砾石或泥土上行驶得更远更快。可调轴距尾钩兼容不同胎宽的同时还能改变整车的操控性，长轴距提供更好的稳定平顺性，短轴距则拥有更好操控，同一车架不同体验。不止有捷安特创新的D-Fuse seatpost系统帮助吸收冲击，现在拥有另一个选择，兼容30.9mm坐管，能够安装升降坐管，面对不同地形，轻松调节高度，有助于通过崎岖不平的砾石路段。上管和前叉加入拓展口，全车多个拓展位，自由选择拓展方式，无论是工具包还是水壶，都可以轻松放置。');
INSERT INTO `bicycleinfo` VALUES ('GIANT-121', '3', '1', '230607222231881', 'GIANT', '121', '公路车', 1, '', 'http://rvtteknnm.hn-bkt.clouddn.com/2023/06/10/0ca7f17b2fc547a8aacea1edf40f1bc8.jpg', '1111111111111111111111111111111');
INSERT INTO `bicycleinfo` VALUES ('GIANT-SL5', '1', '1', '1', 'GIANT', 'SL 5', '公路车', 20, 'Propel Advanced SL 0', 'http://rvtteknnm.hn-bkt.clouddn.com/2023/06/07/c77178fede704e438457a930a371f2ef.jpg', '全新的Propel的设计理念基于AeroSystem超低风阻管型技术打造。通过分析管型形状、角度以及接合点，作为一个整体的系统每一个组成部件都显得尤为关键。空力系统管型重新设计，灵动的线条和优化的椭圆截背管型以最大限度减少阻力。 专属空力套件，标配两款专属设计的水壶架以遵循我们对空气动力学设计的理念，以最大限度地减少空气阻力。整合的空力水壶经过UCI认证可正式参赛。');

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`  (
  `carousel_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '数据编号',
  `c_image` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片名称',
  `c_imgurl` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片地址',
  PRIMARY KEY (`carousel_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES ('2', '捷安特XTC 800气压避震XC竞技30速铝合金油压碟刹山地自行车', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230519/168445705542796.jpg');
INSERT INTO `carousel` VALUES ('230612084102884', 'ATX 20-S', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220311/164695784220844.jpg');
INSERT INTO `carousel` VALUES ('230612175719449', '123', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220907/166251826393695.jpg');
INSERT INTO `carousel` VALUES ('3', '捷安特Speeder D2公路自行车', 'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220819/166087296229868.jpg');

-- ----------------------------
-- Table structure for currentprice
-- ----------------------------
DROP TABLE IF EXISTS `currentprice`;
CREATE TABLE `currentprice`  (
  `currentprice_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '时价编号',
  `c_primary` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '时价区间1',
  `c_secondary` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '时价区间2',
  `c_price` double NOT NULL COMMENT '时价',
  PRIMARY KEY (`currentprice_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of currentprice
-- ----------------------------
INSERT INTO `currentprice` VALUES ('1', '100', '500', 15);
INSERT INTO `currentprice` VALUES ('2', '500', '800', 20);
INSERT INTO `currentprice` VALUES ('230607222231881', '2000', '3000', 40);
INSERT INTO `currentprice` VALUES ('3', '800', '1000', 25);
INSERT INTO `currentprice` VALUES ('4', '1000', '1500', 28);
INSERT INTO `currentprice` VALUES ('5', '1500', '2000', 30);

-- ----------------------------
-- Table structure for custaccount
-- ----------------------------
DROP TABLE IF EXISTS `custaccount`;
CREATE TABLE `custaccount`  (
  `accountcust_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客账号，为手机号',
  `c_password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号密码',
  `c_date` date NOT NULL COMMENT '注册日期',
  `c_status` int NOT NULL DEFAULT 0 COMMENT '账号状态，0：正常，1：禁用',
  PRIMARY KEY (`accountcust_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of custaccount
-- ----------------------------
INSERT INTO `custaccount` VALUES ('17345449120', '16815X', '2023-06-06', 0);
INSERT INTO `custaccount` VALUES ('17345449129', '123456', '2023-06-03', 0);
INSERT INTO `custaccount` VALUES ('18682745313', '123456', '2023-06-03', 0);
INSERT INTO `custaccount` VALUES ('18686897664', '16815X', '2023-06-11', 1);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客编号',
  `accountcust_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客编号，为手机号',
  `c_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '顾客姓名',
  `c_sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '顾客性别',
  `c_age` int NULL DEFAULT NULL COMMENT '顾客年龄',
  `c_card` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '身份证号',
  `c_phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系电话',
  `c_email` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱地址',
  `c_address` char(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系地址',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('202306038157', '18682745313', NULL, NULL, NULL, '513723200010028157', '18682745313', '3547839266@qq.com', NULL);
INSERT INTO `customer` VALUES ('20230603815X', '17345449129', '王狼', '男', 22, '51192320011216815X', '17345449129', '2605735186@qq.com', '四川省成都市青羊区文家场正街227号');
INSERT INTO `customer` VALUES ('20230611815X', '18686897664', '测试', NULL, 20, '51192320011216815X', '18686897664', '2724077672@qq.com', '宋朝');

-- ----------------------------
-- Table structure for depositi
-- ----------------------------
DROP TABLE IF EXISTS `depositi`;
CREATE TABLE `depositi`  (
  `deposit_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '押金编号',
  `d_primary` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '押金区间1',
  `d_secondary` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '押金区间2',
  `d_price` double NOT NULL COMMENT '区间押金',
  PRIMARY KEY (`deposit_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depositi
-- ----------------------------
INSERT INTO `depositi` VALUES ('1', '100', '500', 200);
INSERT INTO `depositi` VALUES ('2', '500', '800', 500);
INSERT INTO `depositi` VALUES ('230607221844102', '2000', '3000', 2000);
INSERT INTO `depositi` VALUES ('3', '800', '1500', 1000);
INSERT INTO `depositi` VALUES ('4', '1500', '2000', 1500);

-- ----------------------------
-- Table structure for leaseinfo
-- ----------------------------
DROP TABLE IF EXISTS `leaseinfo`;
CREATE TABLE `leaseinfo`  (
  `leaseinfo_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '租借编号',
  `bicycleinfo_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '自行车编号',
  `accountcust_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客编号',
  `orderdeposit_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单押金编号',
  `l_datefrist` date NULL DEFAULT NULL COMMENT '起始日期',
  `l_timefrist` time NULL DEFAULT NULL COMMENT '起始时间',
  `l_datesecond` date NULL DEFAULT NULL COMMENT '结束日期',
  `l_timesecond` time NULL DEFAULT NULL COMMENT '结束时间',
  `l_duration` int NULL DEFAULT NULL COMMENT '租借时长',
  `l_money` double NULL DEFAULT NULL COMMENT '租借金额',
  `l_number` int NOT NULL COMMENT '租借数量',
  `l_status` int NOT NULL DEFAULT 0 COMMENT '租借状态，0：租借中，1：租借结束，2：租借异常',
  PRIMARY KEY (`leaseinfo_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leaseinfo
-- ----------------------------
INSERT INTO `leaseinfo` VALUES ('230607085232938', '1', '17345449129', '230607085257951', '2023-06-05', '10:00:00', '2023-06-06', '09:00:00', 23, 345, 1, 1);
INSERT INTO `leaseinfo` VALUES ('230607085236195', '5', '17345449129', '230607085252415', '2023-06-07', NULL, NULL, NULL, NULL, NULL, 1, 3);
INSERT INTO `leaseinfo` VALUES ('230611153322531815X', '1', '17345449129', '230611153322476', '2023-06-11', '15:30:34', NULL, NULL, NULL, NULL, 3, 1);
INSERT INTO `leaseinfo` VALUES ('230611153847472815X', '16', '17345449129', '230611153847469', '2023-06-11', '15:36:32', NULL, NULL, NULL, NULL, 1, 3);
INSERT INTO `leaseinfo` VALUES ('230611154246298815X', '15', '18686897664', '230611154246295', '2023-06-11', '01:23:38', '2023-06-11', '11:23:38', 10, 450, 3, 0);
INSERT INTO `leaseinfo` VALUES ('2306111620411028157', '12', '18682745313', '230611162041099', '2023-06-12', '06:22:06', '2023-06-14', '07:22:06', 49, 735, 1, 0);
INSERT INTO `leaseinfo` VALUES ('2306111620540858157', '10', '18682745313', '230611162054084', '2023-06-11', '12:25:16', '2023-06-12', '11:25:16', 23, 345, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612192843865', '3', '17345449129', '230612193150025', '2023-06-11', NULL, NULL, NULL, NULL, NULL, 3, 0);
INSERT INTO `leaseinfo` VALUES ('230612192845762', '6', '17345449129', '230612193150025', '2023-06-11', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612193310514', '2', '17345449129', '230612193320426', '2023-06-13', NULL, NULL, NULL, NULL, NULL, 3, 0);
INSERT INTO `leaseinfo` VALUES ('230612193412257', '1', '17345449129', '230612193425174', '2023-06-14', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612193456965', '14', '17345449129', '230612193513318', '2023-06-12', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612193506645', '3', '17345449129', '230612193623210', '2023-06-14', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612193508448', '2', '17345449129', '230612193636299', '2023-06-15', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612193826397', '16', '17345449129', '230612193832628', '2023-06-12', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612193848102', '15', '17345449129', '230612193859099', '2023-06-12', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612194059150', '2', '17345449129', '230612194130854', '2023-06-13', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612194245561', '2', '17345449129', '230612194304965', '2023-06-12', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612194419470', '14', '17345449129', '230612194443504', '2023-06-14', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612194506319', '2', '17345449129', '230612194513481', '2023-06-12', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612194958966', '2', '17345449129', '230612195005129', '2023-06-12', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612195115625', '3', '17345449129', '230612195119295', '2023-06-12', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612195757777', '2', '17345449129', '230612195803012', '2023-06-12', NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `leaseinfo` VALUES ('230612200608790', '1', '17345449129', '230612200614329', '2023-06-12', NULL, NULL, NULL, NULL, NULL, 1, 0);

-- ----------------------------
-- Table structure for orderdeposit
-- ----------------------------
DROP TABLE IF EXISTS `orderdeposit`;
CREATE TABLE `orderdeposit`  (
  `orderdeposit_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单押金编号',
  `o_price` double NOT NULL COMMENT '押金价格编号',
  `o_status` int NOT NULL DEFAULT 0 COMMENT '押金状态，0：未退回，1：已退回',
  PRIMARY KEY (`orderdeposit_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderdeposit
-- ----------------------------
INSERT INTO `orderdeposit` VALUES ('230607085252415', 400, 1);
INSERT INTO `orderdeposit` VALUES ('230607085257951', 200, 1);
INSERT INTO `orderdeposit` VALUES ('230611153322476', 600, 0);
INSERT INTO `orderdeposit` VALUES ('230611162054084', 200, 0);
INSERT INTO `orderdeposit` VALUES ('230612193150025', 3200, 0);
INSERT INTO `orderdeposit` VALUES ('230612193320426', 1500, 0);
INSERT INTO `orderdeposit` VALUES ('230612193425174', 200, 0);
INSERT INTO `orderdeposit` VALUES ('230612193513318', 200, 0);
INSERT INTO `orderdeposit` VALUES ('230612193623210', 1000, 0);
INSERT INTO `orderdeposit` VALUES ('230612193636299', 500, 0);
INSERT INTO `orderdeposit` VALUES ('230612193832628', 200, 0);
INSERT INTO `orderdeposit` VALUES ('230612193859099', 200, 0);
INSERT INTO `orderdeposit` VALUES ('230612194130854', 500, 0);
INSERT INTO `orderdeposit` VALUES ('230612194304965', 500, 0);
INSERT INTO `orderdeposit` VALUES ('230612194443504', 200, 0);
INSERT INTO `orderdeposit` VALUES ('230612194513481', 500, 0);
INSERT INTO `orderdeposit` VALUES ('230612195005129', 500, 0);
INSERT INTO `orderdeposit` VALUES ('230612195119295', 1000, 0);
INSERT INTO `orderdeposit` VALUES ('230612195803012', 500, 0);
INSERT INTO `orderdeposit` VALUES ('230612200614329', 200, 0);

-- ----------------------------
-- Table structure for platedata
-- ----------------------------
DROP TABLE IF EXISTS `platedata`;
CREATE TABLE `platedata`  (
  `platedata_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '板块数据编号',
  `bicycleinfo_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '自行车编号',
  `p_plate` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '数据板块，板块分为：推荐，公路车，山地车',
  PRIMARY KEY (`platedata_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of platedata
-- ----------------------------
INSERT INTO `platedata` VALUES ('1', '1', '推荐');
INSERT INTO `platedata` VALUES ('10', '14', '推荐');
INSERT INTO `platedata` VALUES ('11', '5', '推荐');
INSERT INTO `platedata` VALUES ('12', '3', '公路车');
INSERT INTO `platedata` VALUES ('13', '4', '公路车');
INSERT INTO `platedata` VALUES ('14', '5', '公路车');
INSERT INTO `platedata` VALUES ('15', '6', '公路车');
INSERT INTO `platedata` VALUES ('16', '7', '公路车');
INSERT INTO `platedata` VALUES ('17', '8', '公路车');
INSERT INTO `platedata` VALUES ('18', '9', '公路车');
INSERT INTO `platedata` VALUES ('19', '16', '山地车');
INSERT INTO `platedata` VALUES ('2', '2', '推荐');
INSERT INTO `platedata` VALUES ('20', '15', '山地车');
INSERT INTO `platedata` VALUES ('21', '14', '山地车');
INSERT INTO `platedata` VALUES ('22', '13', '山地车');
INSERT INTO `platedata` VALUES ('23', '12', '山地车');
INSERT INTO `platedata` VALUES ('230612114357199', 'GIANT-121', '配件');
INSERT INTO `platedata` VALUES ('3', '2', '公路车');
INSERT INTO `platedata` VALUES ('4', '1', '公路车');
INSERT INTO `platedata` VALUES ('5', '3', '推荐');
INSERT INTO `platedata` VALUES ('6', '16', '推荐');
INSERT INTO `platedata` VALUES ('7', '15', '推荐');

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`  (
  `reservation_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '预约编号',
  `accountcust_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客编号',
  `bicycleinfo_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '自行车编号',
  `r_resdate` date NULL DEFAULT NULL COMMENT '预约日期',
  `r_number` int NOT NULL DEFAULT 1 COMMENT '预约数量',
  `r_totalprice` double NOT NULL COMMENT '总价金额',
  `r_status` int NOT NULL DEFAULT 0 COMMENT '预约状态，0：未成功，1：已成功',
  PRIMARY KEY (`reservation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('230607085228856', '17345449129', '1', '2023-06-07', 1, 200, 1);
INSERT INTO `reservation` VALUES ('230607085232938', '17345449129', '14', '2023-06-07', 1, 200, 1);
INSERT INTO `reservation` VALUES ('230612192843865', '17345449129', '3', '2023-06-11', 3, 3000, 1);
INSERT INTO `reservation` VALUES ('230612192845762', '17345449129', '6', '2023-06-11', 1, 200, 1);
INSERT INTO `reservation` VALUES ('230612193310514', '17345449129', '2', '2023-06-13', 3, 1500, 1);
INSERT INTO `reservation` VALUES ('230612193412257', '17345449129', '1', '2023-06-14', 1, 200, 1);
INSERT INTO `reservation` VALUES ('230612193456965', '17345449129', '14', '2023-06-12', 1, 200, 1);
INSERT INTO `reservation` VALUES ('230612193506645', '17345449129', '3', '2023-06-14', 1, 1000, 1);
INSERT INTO `reservation` VALUES ('230612193508448', '17345449129', '2', '2023-06-15', 1, 500, 1);
INSERT INTO `reservation` VALUES ('230612193826397', '17345449129', '16', '2023-06-12', 1, 200, 1);
INSERT INTO `reservation` VALUES ('230612193848102', '17345449129', '15', '2023-06-12', 1, 200, 1);
INSERT INTO `reservation` VALUES ('230612194059150', '17345449129', '2', '2023-06-13', 1, 500, 1);
INSERT INTO `reservation` VALUES ('230612194245561', '17345449129', '2', '2023-06-12', 1, 500, 1);
INSERT INTO `reservation` VALUES ('230612194419470', '17345449129', '14', '2023-06-14', 1, 200, 1);
INSERT INTO `reservation` VALUES ('230612194506319', '17345449129', '2', '2023-06-12', 1, 500, 1);
INSERT INTO `reservation` VALUES ('230612194953004', '17345449129', '16', NULL, 1, 200, 0);
INSERT INTO `reservation` VALUES ('230612194958966', '17345449129', '2', '2023-06-12', 1, 500, 1);
INSERT INTO `reservation` VALUES ('230612195115625', '17345449129', '3', '2023-06-12', 1, 1000, 1);
INSERT INTO `reservation` VALUES ('230612195752944', '17345449129', '16', NULL, 1, 200, 0);
INSERT INTO `reservation` VALUES ('230612195757777', '17345449129', '2', '2023-06-12', 1, 500, 1);
INSERT INTO `reservation` VALUES ('230612200608790', '17345449129', '1', '2023-06-12', 1, 200, 1);

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `store_id` char(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '店铺编号',
  `s_name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '店铺名称',
  `s_address` char(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '店铺地址',
  `s_phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '店铺电话',
  `s_status` int NOT NULL DEFAULT 0 COMMENT '店铺状态，0：正常，1：闭店',
  PRIMARY KEY (`store_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '王狼', '成都市武侯区锦城大道南段', '17345449129', 0);
INSERT INTO `store` VALUES ('2', '王海鹏', '成都市新都区新都大道西段', '18682745313', 0);
INSERT INTO `store` VALUES ('3', '李燕军', '成都市青羊区青羊大道北段', '18148444679', 0);

SET FOREIGN_KEY_CHECKS = 1;
