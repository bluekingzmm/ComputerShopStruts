/*
MySQL Backup
Source Server Version: 5.7.11
Source Database: computer_shop
Date: 2017/9/21 09:54:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(255) NOT NULL,
  `admin_name` varchar(50) DEFAULT NULL,
  `admin_password` varchar(50) DEFAULT NULL,
  `status` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `brand_id` int(10) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `computer_info`
-- ----------------------------
DROP TABLE IF EXISTS `computer_info`;
CREATE TABLE `computer_info` (
  `com_id` int(255) NOT NULL AUTO_INCREMENT,
  `brand_id` int(255) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `price` double(255,0) DEFAULT NULL,
  `rel_price` double(255,0) DEFAULT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `pixels` varchar(255) DEFAULT NULL,
  `cpu_id` int(255) DEFAULT NULL,
  `screen_id` int(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `status` int(10) DEFAULT '1' COMMENT '0未上架  1上架',
  `num` int(255) DEFAULT '1',
  `content` longtext,
  PRIMARY KEY (`com_id`),
  KEY `b` (`cpu_id`),
  KEY `c` (`screen_id`),
  KEY `asad` (`brand_id`),
  CONSTRAINT `asad` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`),
  CONSTRAINT `asd` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `cpu`
-- ----------------------------
DROP TABLE IF EXISTS `cpu`;
CREATE TABLE `cpu` (
  `cpu_id` int(255) NOT NULL AUTO_INCREMENT,
  `cpu_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cpu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `order_detail_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail_info`;
CREATE TABLE `order_detail_info` (
  `order_detail_id` int(255) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(255) DEFAULT NULL,
  `com_id` int(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `buy_price` double(255,0) DEFAULT NULL,
  `account` int(255) DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `lo` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` bigint(255) NOT NULL,
  `total_price` double(255,0) DEFAULT '0',
  `user_id` int(255) DEFAULT NULL,
  `buy_date` datetime DEFAULT NULL,
  `ispay` int(10) DEFAULT NULL COMMENT '支付 0没有  1 已支付',
  `isdeliver` int(10) DEFAULT NULL COMMENT '发货 0 没有 1发货',
  `label` longtext COMMENT '说明',
  `tx` int(10) DEFAULT '0',
  `state` int(10) DEFAULT '0' COMMENT '信息默认存在为1，不存在为0',
  PRIMARY KEY (`order_id`),
  KEY `m` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `screen`
-- ----------------------------
DROP TABLE IF EXISTS `screen`;
CREATE TABLE `screen` (
  `screen_id` int(255) NOT NULL AUTO_INCREMENT,
  `screen_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`screen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(255) NOT NULL,
  `age` int(100) DEFAULT '0',
  `user_name` varchar(80) DEFAULT NULL,
  `user_password` varchar(80) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `address` text,
  `mail` varchar(100) DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  `reg_time` date DEFAULT NULL,
  `code` varchar(100) DEFAULT '0',
  `rel_name` varchar(80) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `Id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  View definition for `vcomputer`
-- ----------------------------
DROP VIEW IF EXISTS `vcomputer`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vcomputer` AS select `brand`.`brand_name` AS `brand_name`,`computer_info`.`com_id` AS `com_id`,`brand`.`brand_id` AS `brand_id`,`cpu`.`cpu_id` AS `cpu_id`,`cpu`.`cpu_name` AS `cpu_name`,`screen`.`screen_id` AS `screen_id`,`screen`.`screen_name` AS `screen_name`,`computer_info`.`model` AS `model`,`computer_info`.`price` AS `price`,`computer_info`.`color` AS `color`,`computer_info`.`rel_price` AS `rel_price`,`computer_info`.`reg_date` AS `reg_date`,`computer_info`.`pixels` AS `pixels`,`computer_info`.`ram` AS `ram`,`computer_info`.`status` AS `status`,`computer_info`.`img_path` AS `img_path`,`computer_info`.`num` AS `num`,`computer_info`.`content` AS `content` from (((`brand` join `computer_info` on((`computer_info`.`brand_id` = `brand`.`brand_id`))) join `cpu` on((`computer_info`.`cpu_id` = `cpu`.`cpu_id`))) join `screen` on((`computer_info`.`screen_id` = `screen`.`screen_id`)));

-- ----------------------------
--  View definition for `vorder`
-- ----------------------------
DROP VIEW IF EXISTS `vorder`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vorder` AS select `user_info`.`user_name` AS `user_name`,`user_info`.`user_id` AS `user_id`,`user_info`.`age` AS `age`,`user_info`.`user_password` AS `user_password`,`user_info`.`phone` AS `phone`,`user_info`.`address` AS `address`,`user_info`.`mail` AS `mail`,`user_info`.`reg_time` AS `reg_time`,`user_info`.`code` AS `code`,`user_info`.`rel_name` AS `rel_name`,`user_info`.`sex` AS `sex`,`user_info`.`Id` AS `Id`,`order_info`.`order_id` AS `order_id`,`order_info`.`total_price` AS `total_price`,`order_info`.`buy_date` AS `buy_date`,`order_info`.`ispay` AS `ispay`,`order_info`.`isdeliver` AS `isdeliver`,`order_info`.`label` AS `label`,`order_info`.`tx` AS `tx`,`order_info`.`state` AS `state`,`user_info`.`status` AS `status` from (`order_info` join `user_info` on((`user_info`.`user_id` = `order_info`.`user_id`)));

-- ----------------------------
--  View definition for `vorderdetail`
-- ----------------------------
DROP VIEW IF EXISTS `vorderdetail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vorderdetail` AS select `computer_info`.`com_id` AS `com_id`,`computer_info`.`brand_id` AS `brand_id`,`computer_info`.`model` AS `model`,`computer_info`.`color` AS `color`,`computer_info`.`price` AS `price`,`computer_info`.`rel_price` AS `rel_price`,`computer_info`.`img_path` AS `img_path`,`computer_info`.`reg_date` AS `reg_date`,`computer_info`.`pixels` AS `pixels`,`computer_info`.`cpu_id` AS `cpu_id`,`computer_info`.`screen_id` AS `screen_id`,`computer_info`.`ram` AS `ram`,`computer_info`.`num` AS `num`,`computer_info`.`content` AS `content`,`cpu`.`cpu_name` AS `cpu_name`,`screen`.`screen_name` AS `screen_name`,`brand`.`brand_name` AS `brand_name`,`order_detail_info`.`order_detail_id` AS `order_detail_id`,`order_detail_info`.`order_id` AS `order_id`,`order_detail_info`.`buy_price` AS `buy_price`,`order_detail_info`.`account` AS `account`,`order_info`.`total_price` AS `total_price`,`order_info`.`buy_date` AS `buy_date`,`order_info`.`ispay` AS `ispay`,`order_info`.`isdeliver` AS `isdeliver`,`order_info`.`label` AS `label`,`user_info`.`user_id` AS `user_id`,`user_info`.`age` AS `age`,`user_info`.`user_name` AS `user_name`,`user_info`.`user_password` AS `user_password`,`user_info`.`phone` AS `phone`,`user_info`.`address` AS `address`,`user_info`.`mail` AS `mail`,`user_info`.`reg_time` AS `reg_time`,`user_info`.`code` AS `code`,`user_info`.`rel_name` AS `rel_name`,`user_info`.`sex` AS `sex`,`user_info`.`Id` AS `Id` from ((((((`computer_info` join `order_detail_info` on((`order_detail_info`.`com_id` = `computer_info`.`com_id`))) join `order_info` on((`order_info`.`order_id` = `order_detail_info`.`order_id`))) join `user_info` on((`user_info`.`user_id` = `order_info`.`user_id`))) join `cpu` on((`cpu`.`cpu_id` = `computer_info`.`cpu_id`))) join `screen` on((`screen`.`screen_id` = `computer_info`.`screen_id`))) join `brand` on((`brand`.`brand_id` = `computer_info`.`brand_id`)));

-- ----------------------------
--  View definition for `vsale`
-- ----------------------------
DROP VIEW IF EXISTS `vsale`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vsale` AS select `computer_info`.`com_id` AS `com_id`,`computer_info`.`model` AS `model`,`computer_info`.`rel_price` AS `rel_price`,sum(`order_detail_info`.`account`) AS `count`,`brand`.`brand_name` AS `brand_name` from ((`computer_info` left join `order_detail_info` on((`computer_info`.`com_id` = `order_detail_info`.`com_id`))) join `brand` on((`brand`.`brand_id` = `computer_info`.`brand_id`))) group by `computer_info`.`com_id` order by `count` desc;

-- ----------------------------
--  Event definition for `upload_to_sdmp`
-- ----------------------------
DROP EVENT IF EXISTS `upload_to_sdmp`;
CREATE DEFINER=`root`@`localhost` EVENT `upload_to_sdmp` ON SCHEDULE EVERY 10 SECOND STARTS '2016-12-29 20:01:00' ON COMPLETION NOT PRESERVE ENABLE DO update order_info set tx=0;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('1','admin','123456','1'), ('10','fjhkhkhj','fsdfsf','1'), ('18','456khjk77777','456kjhk','1'), ('2','bbbbbbbbbbbbbbb','dskhjk','1'), ('20','HHHHH','12khj','1'), ('7','aaaaaaaaaaaa','fsdfsf','1'), ('8','rwerwe','rwerwr','1');
INSERT INTO `brand` VALUES ('1','联想'), ('2','华硕'), ('3','戴尔'), ('4','宏碁'), ('5','惠普'), ('6','66');
INSERT INTO `computer_info` VALUES ('1','2','K501LB5200','银色','4999','4099','hs1.jpg','2017-01-07','1920*1080','2','2','4','1','3','不错的选择！'), ('2','2','K550JX4200','黑色','5699','5099','hs2.jpg','2016-12-17','1920*1080','2','2','8','1','1','优点：外观还好 散热也还不错（玩nba2k14全高 cpu没超过75度显卡没超过55度）配置还好 显卡不错 玩NBA2K15中高画质 玩GTA5加了4G内存 可以开中画质 网游方面玩LOL,NBA2KOL CPU从来没超过60度 显卡 也是50度左右 lol特效全开10M宽带无压力缺点：自带WIN8系统让我很不爽，磁盘占用一直100，拖累了这么好的配置，很多游戏不兼容，而且屏幕感觉一般，我友达的屏，最让我蛋疼的是网线接口，很容易松动而且不好拔出来，玩着游戏不小心碰下网就断了总结：我和一室友都用的这款，他找熟人买的4250 ，我在实体店买的5000，送包 鼠标 贴膜。他是奇美屏，我是友达的，感觉使用的还好，配置 还不错 就是硬盘太渣了，开个qq音乐，挂俩qq再玩个NBA2KOL就会卡顿，一切任务管理器发现磁盘占用100，而cpu一般玩游戏占用不到40，内存4G占用60左右，我把那些什么家庭组都禁用了，找店家删了些自带没用的软件还是无法解决，卖家说只能加固态。就平常使用玩个游戏少开点软件很流畅的 这配置加固态体验是非常不错的。'), ('3','5',' 暗影精灵II','黑色','5999','5599','hp1.jpg','2017-09-12','1920*1080','1','2','8','1','2','优点：在大白电脑网上比较了三款电脑，最终选择暗夜精灵。 1.工作上网游戏非常流畅，开机时间8~12秒不等。 2.外观确实很漂亮，绿色背光简直让人爱不释手啊！是我买的最满意的笔记本，用来做第一电脑使用。 3.英雄联盟、极品飞车16、鬼泣5运行无压力。 4.做工还可以，比上一台神舟好。 5.白天听不到风扇转动声，半夜周围非常静，会听到一丁点风声。缺点：1.在玩游戏时开最高特效，CPU和显卡温度达到80度左右，键盘的左手位置可以明显的感觉到发热。 2.看到其他人也在吐槽雾面屏，我就放心了，真心不如镜面屏。 3.电池续航时间短，也就三小时左右。总结：整体来说值得购买，外观和性能我都很满意，其它都是小问题啦！'), ('4','5','光影精灵','黑色','6999','6299','hp2.jpg','2016-12-17','1920*1080','1','2','8','1','13','在扩展性方面，光影精灵基本能够满足用户的日常需求。在机身右侧，这款产品配置了电源插孔、RJ-45以太网口、HDMI接口、USB 3.0接口以及读卡器；机身左侧则配置了安全锁孔、2个USB 3.0接口以及1个3.5mm耳机麦克风插孔，整体的扩展性能够满足用户的使用需求。'), ('5','3',' 灵越15(7559)','黑色','8199','1099','de1.jpg','2016-12-16','1920*1080','1','2','8','1','6','999'), ('6','3','灵越Ins15','灰色','4499','3799','de2.jpg','2016-12-16','1920*1080','6','2','4','1','9','\r\n优点：\r\n\r\n配置很高，有独立显卡。\r\n缺点：\r\n\r\n没有DVD刻录光驱，除了这一个缺点，就没了。\r\n总结：\r\n\r\n标配i7处理器，8GB内存，1TB硬盘4GB独立显卡，非常好。'), ('7','1',' IdeaPad','黑色','6868','5868','lx1.jpg','2016-12-25','1920*1080','2','2','8','1','19','\r\n优点：\r\n\r\n外观时尚，运行快，音质好，清晰度高，开机只需7s，etc.\r\n缺点：\r\n\r\n不能触控and其他暂无。\r\n总结：\r\n\r\n不知道为什么那么多人都说这款电脑除了颜值高就一无是处，但其实就我这四个月的使用来看，这款电脑还是用得相当顺手的，完全不像他们说的总在出问题（至少我的这台机器一直运行良好，至于噪音，讲真只有散热时才会有一点，但比起外接的散热器来说噪音真不大）。不过也许对于游戏玩家来说这款电脑性能并不怎么样，毕竟超极本为了保证厚度和重量并不会配上足以玩大型游戏的硬件，所以它自然不会是游戏玩家的首选设备。但对于文艺小清新来说，这款电脑足以让人一见倾心——它有足以与苹果匹敌的外观（反正我觉得它比苹果好看得多），有Intel独立显卡、Dolby以及JBL音响设备（你们在苹果专卖店看到的水晶音箱就是这个牌子 ）以带来华丽的视听盛宴。 总而言之，游戏玩家就不要选这款电脑啦，你们需要的是游戏本；商务人士嘛，你们需要的是大容量移动硬盘，毕竟超极本硬盘都不大；爱听音乐、看电影的文艺青年（比如我）倒是可以考虑入手，believe me,你们一定会爱上它！！！'), ('8','1','y50','黑色','6299','5899','lx2.jpg','2016-12-17','1920*1080','4','2','4','1','35','\r\n优点：\r\n\r\n设计和做工很好，性能也不错。保留了核心显卡，键盘和掌托手感不错。开后盖也容易开启，方便升级内存和清灰等。内部的设计很规整，有双风扇的散热。另外，有人说联想在美国配置高还便宜，在中国低配高价，其实这样说不合理。毕竟联想是个企业，中国是个很大的市场，哪有企业跟钱过不去的？非要在大陆降低标准影响销量。天朝贵是因为天朝的万税，而且实际上差价大的是外星人，玩家国度那种上万的高端游戏本。不信你们可以去美国的亚马逊和百思买看看，这款的价格与大陆是差不多的。所以这款Y50的性能和性价比都是非常不错的。\r\n缺点：\r\n\r\n屏幕虽然是1080P的分辨率，但不是IPS材质的，可视角度一般，但实际效果也不像某些人说的那样不好。没有第二个硬盘位，要想换固态硬盘，就要把原来的硬盘去下，这也是为了超薄轻量化的设计吧。至于取消光驱一般来说应该是无所谓的，反正多数人都不怎么用。金属的材质虽好，但容易粘指纹。还有，8G内存，4G显存的那款其实性价比不高，还不如这款。自己加个4G的内存也不贵，而同样是860M的显卡，2G或者4G的显存对性能影响不大，没必要多花好几百。有那钱升级IPS屏幕或者固态硬盘更加明智。\r\n总结：\r\n\r\n联想的Y系列一直都有不错的口碑，这款Y50取消了不常用的光驱，采用金属材质和超薄的设计，性能和做工都很好，在同级别的笔记本中也有不错的性价比，是款非常不错的笔记本，要是能把屏幕变为IPS材质的就更好了。'), ('9','4','蜂鸟 S5-371','白色','5799','5299','hj1.jpg','2016-12-16','1920*1080','3','2','4','1','41','总结：\r\n\r\n外观漂亮，很轻薄，充电器也轻巧，方便在家里和外出时用。'), ('10','4',' YOGA710','银色','5999','5699','hj2.jpg','2016-11-25','1920*1080','2','3','4','1','49','机身做工很细致，外观大方耐看，磨砂手感，键盘打字手感很好，设计很贴心，键盘背光有两个光度可以调节。开机很快没超过10秒，画面很清晰，音质效果也很好，长时间使用机身也不是很烫，扇热效果很好，节电模式电脑续航时间还是有8小时，充满电用时很短。'), ('14','5','薄锐HP ENVY 15-as109TU','天然银','7499','6599','1483782833806.png','2017-01-07','1920*1080','1','2','8','1','19','    身临其境的观影体验，带来全新的娱乐盛宴。 出彩的 FHD 或 4K[1] 显示屏、Bang & Olufsen 音频以及 HP Audio Boost 技术，确保您尽情享用。\r\n    高达 16 GB 的内存、全新英特尔®酷睿™ i 处理器[3]和 512 GB 的可选 PCIe SSD 存储容量，您可以高速浏览娱乐资源、轻松阅读文档。\r\n    在日常忙碌的工作中，您需要准备一台设备，来应对随时出现的任务。 这款笔记本电脑具有轻薄的全金属机身，电池续航时间可达一整天[2]，轻松满足您的日常需求。'), ('15','1',' Flex3 触摸屏幕','黑色','3298','2999','1483785478183.png','2017-01-07','1366×768','7','3','4','1','20','不错的选择！赶快购物吧。。'), ('16','2','FX50JX','黑色','5699','5499','1483785983795.png','2017-01-07','1920×1080','5','2','4','1','9','可以的！实惠！'), ('17','2','X540LJ4005','黑色','2999','2799','1483786362032.png','2017-01-07','1366×768','8','2','4','1','45','漂亮！服务周到！'), ('29','2','ds','sd','3','3','1492613295797.jpg','2017-04-19','3','2','2','5','1','3','hjhjh');
INSERT INTO `cpu` VALUES ('1','酷睿i7-6代'), ('2','酷睿i5-6代'), ('3','酷睿i5-5代'), ('4','酷睿i5-4代'), ('5','酷睿i7-4代'), ('6','AMD-A10'), ('7','AMD-A8'), ('8','酷睿i3-4代');
INSERT INTO `order_detail_info` VALUES ('1','14838567526571','5',' 灵越15(7559)','1099','1'), ('2','14838567734671','6','灵越Ins15','3799','4'), ('8','149067985730999935','4','光影精灵','6299','1'), ('17','149261275451299935','14','薄锐HP ENVY 15-as109TU','6599','1'), ('18','150517422422599935','5',' 灵越15(7559)','1099','1'), ('19','150517422422599935','6','灵越Ins15','3799','1');
INSERT INTO `order_info` VALUES ('14838567526571','1099','1','2017-01-08 02:25:52','0','1',NULL,'0','0'), ('14838567734671','15096','1','2017-01-08 02:26:13','0','1',NULL,'0','0'), ('149261275451299935','6499','99935','2017-04-19 10:39:14','1','1',NULL,'0','0'), ('150517422422599935','4898','99935','2017-09-12 07:57:03','0','0',NULL,'0','0');
INSERT INTO `screen` VALUES ('1','17英寸以上'), ('2','15.6英寸'), ('3','14英寸'), ('4','13英寸'), ('5','12英寸'), ('6','11英寸以及以下');
INSERT INTO `user_info` VALUES ('1','21','bbbb','bbbb','188778','安徽省/芜湖市/鸠江区','738993102@qq.com','1','2016-11-22','495AF14056DB4E138FC2FDBCAEBB8F09','张松南伞','男','341225199587672345'), ('99928','0','11','11','11111','11123','1281487298@qq.com','0','2016-12-05','2BBA104D074243F39849E896FB232725','张晓娟','女','152445677876768917'), ('99932','21','qwer','qwer','18855676567','北京市/北京市/海淀区','1369878613@qq.com','1','2016-12-08','1A4D813BB65745F695B5DEEDAD150C86','张某某','男','341225199625463651'), ('99933','0','fgfdgdf','fff','33','ff','738993102@qq.com','0','2016-12-11','19C48A7EE59D40F08F612A3C64BBD564','到','男','341225188987867272'), ('99934','23','wqdqw','dwq','dasd','dwq','738993102@qq.com','1','2016-12-12','C83CE8394BA54851914E4577CD76EB63','点','男','341225155678765678'), ('99935','20','admin','admin','18855012360','安徽省/芜湖市/弋江区','738993102@qq.com','1','2016-12-12','1A4D813BB65745F695B5DEEDAD150C86','大放送','男','341225199798767652'), ('99937','20','sdff','dgsd','gdsg','江苏省/常州市/溧阳市','gdsg','0','2017-03-22','48747A1216384BC0932C80AE17BE81B5','gdg','男','341225199705163953'), ('99939','21','dfdsf','fssfdf','18855362541','江苏省/常州市/溧阳市','738993102@qq.com','0','2017-03-23','4271BD3FE06940CDAF96FDD412704527','政治','女','341225199654562514'), ('99941','19','aaaaaaa','1111111111','18855042615','江苏省/常州市/溧阳市','738993102@qq.com','0','2017-03-23','A4AB9D17884C4C188C12636AB91714A3','暂住证','男','34122519981212654x'), ('99943','19','jhhjkhjkh','klklk','18855201236','江苏省/常州市/溧阳市','738993102@qq.com','0','2017-03-23','FF147C5AA0BB4AAF85F2F5FEA38B1DC5','在在在','男','34122519981212654x'), ('99944','19','kjjkkjkjj','jkkjkjkjk','18855201236','江苏省/常州市/溧阳市','738993102@qq.com','0','2017-03-23','FA5E39DC4A7646199F3E24F926876AF2','自组织','男','34122519981212654x'), ('99945','21','klklllklk','klklklkllk','18855042615','江苏省/常州市/溧阳市','738993102@qq.com','1','2017-03-23','90B4053A7FE64643AFA2E4C043BBBA08','方法','男','341225199625463651'), ('99946','19','adsasdsd','dassdds','18855012365','江苏省/常州市/溧阳市','738993102@qq.com','0','2017-03-23','A59681C37DEE4CE58AD62A29349E5E60','学校','男','34122519981212654x'), ('99947','21','fsdsdfsdfd','dsffsddf','18855201236','江苏省/常州市/溧阳市','738993102@qq.com','1','2017-03-23','84A91311D43E41F38B5DD23903133E58','在制作中','男','341225199620123651'), ('99948','21','aaaa','123456','18855201236','江苏省/常州市/溧阳市','738993102@qq.com','1','2017-03-23','ADCEC0492596487C8F7770C00A87CF1C','说说','男','341225199625463651'), ('99949','21','ewew','tewet','18855201236','江苏省/常州市/溧阳市','738993102@qq.com','1','2017-03-24','707D5838A65C4D6CB7782E40347575C9','订单','男','341225199625463651'), ('99950','-2641','sffs','sfdsfd','18855012365','江苏省/常州市/溧阳市','738993102@qq.com','1','2017-03-24','262C4247CD914AD887C6F676B4AC2529','多发点对','男','341225465852123654'), ('99951','19','kjjjk','jklkjlklj','18855012365','江苏省/常州市/溧阳市','738993102@qq.com','0','2017-03-24','7A5BD079A8BB42F28B4E336D56DDC378','素数','男','34122519981212654x'), ('99952','21','455454546564','1313531','18855241563','江苏省/常州市/溧阳市','738993102@qq.com','0','2017-03-24','D4281D4364904D5EB2237C85ACC939E7','广告歌','男','341225199620123651');
