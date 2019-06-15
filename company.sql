
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `admin` VALUES ('1', 'admin', 'tuShOfiBrA8+br7ENrMS8A==');

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT '' COMMENT '名称',
  `number` int(11) DEFAULT NULL COMMENT '类目排序(从小到大)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `category` VALUES ('1', '电动卷帘', '1');
INSERT INTO `category` VALUES ('2', '手动卷帘', '2');
INSERT INTO `category` VALUES ('3', '布艺窗帘', '3');
INSERT INTO `category` VALUES ('4', '飘窗坐垫', '4');


DROP TABLE IF EXISTS `common`;
CREATE TABLE `common` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) DEFAULT NULL COMMENT '类型(1banner/2二维码/3横幅)',
  `value` varchar(255) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO `common` VALUES ('1', '1', '../index/images/1.jpg');
INSERT INTO `common` VALUES ('2', '1', '../index/images/2.jpg');
INSERT INTO `common` VALUES ('3', '1', '../index/images/3.jpg');
INSERT INTO `common` VALUES ('4', '1', '../index/images/4.jpg');
INSERT INTO `common` VALUES ('5', '2', '../index/images/ewm.png');
INSERT INTO `common` VALUES ('6', '3', '因为专注 所以专业');
INSERT INTO `common` VALUES ('7', '3', '公司主要销售百叶窗，办公窗帘，窗帘材料，电动帘，酒店窗帘，签到台，软包，椅裙台布等为企业公司提供一站式服务');
INSERT INTO `common` VALUES ('8', '3', '追求卓越 止于至善');
INSERT INTO `common` VALUES ('9', '3', '公司秉乘“诚信务实、高效创新、客户至上为宗旨的原则”的经营理念，全心全意为广大客户提供质优价廉的窗饰产品及方便、快捷的服务。');


DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '公司名',
  `title` varchar(255) DEFAULT NULL COMMENT '简介',
  `intro` varchar(1024) DEFAULT NULL COMMENT '介绍',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `url` varchar(20) DEFAULT NULL COMMENT '网址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT INTO `company` VALUES ('1', '那啥那啥装饰工程有限公司', '公司主要生产：高档宾馆酒店客房窗帘、家庭窗帘、工程卷帘、餐厅布草、软包装饰布艺等', '我们拥有专业的技术人员，有新颖独特翻新技术，几年的努力奋斗，诚信经营。\r\n经营范围：窗帘，窗纱，高档布艺 沙发，沙发套，床罩，各种套件加工定做。  \r\n另外承接：宾馆，酒店，写字楼，工程布艺，各种轨道，电动轨道等项目。\r\n我们承诺：\r\n*尊重客户要求，按照用户意愿主动提供完善的设计。\r\n*免费上门服务，实地测量尺寸，提供样品及原料样本。\r\n*按客户要求的时间，登门安装、调整，直到客户满意为止。\r\n*选用正规厂家生产的、质地优良的窗帘原材料和名牌配品配件。\r\n*客户使用过程，一旦发现问题，保证随叫随到，终身维修。', '010-12341234', '12312341234', '北京北京北京', 'aa@bb.com', 'www.java.org');

DROP TABLE IF EXISTS `example`;
CREATE TABLE `example` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '案例表',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `intro` varchar(512) DEFAULT NULL COMMENT '介绍',
  `photo` varchar(120) DEFAULT NULL COMMENT '存图片地址',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `category_id` int(20) DEFAULT NULL COMMENT '类目',
  PRIMARY KEY (`id`),
  KEY `type` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


INSERT INTO `example` VALUES ('1', '电动卷帘', null, '../photo/20180320135074497449.jpg', now(), '1');
INSERT INTO `example` VALUES ('2', '手动卷帘', null, '../photo/20180320135054335433.jpg', now(), '2');
INSERT INTO `example` VALUES ('3', '布艺窗帘', null, '../photo/2018321446422406217.jpg', now(), '3');
INSERT INTO `example` VALUES ('4', '飘窗坐垫', null, '../photo/20180320135084348434.jpg', now(), '4');

DROP TABLE IF EXISTS `gbook`;
CREATE TABLE `gbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '留言表id',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(20) DEFAULT NULL,
  `content` varchar(1024) DEFAULT NULL COMMENT '留言内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) DEFAULT '0' COMMENT '类型(1公司新闻/2行业动态)',
  `photo` varchar(120) DEFAULT NULL COMMENT '图片',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `intro` text COMMENT '内容',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


INSERT INTO `news` VALUES ('1', '1', '../photo/2018321418995107810.jpg', '百叶窗保养细则', '1、建议使用专门的除尘设备\r\n2、用半潮湿海绵或者柔软抹布擦拭去灰尘后，用干布擦干水分即可\r\n3、轻柔平滑的操作可以延长百叶帘的使用寿命，而定期使用蜡烛在拉绳上来回涂抹数次，可以使您的升降操作更加容易。\r\n4、保持帘片表面干燥', now());
INSERT INTO `news` VALUES ('2', '1', '../photo/2018321446214603551.jpg', '不同材质的窗帘清洗有窍门', '\r\n\r\n\r\n　　家用窗帘每年至少要清洗一次，但是我们现在的窗帘有很多种的，该如何方便快捷的清洗干净呢，下面就跟大家总结一下不同材质的窗帘清洗方法。\r\n\r\n　　软百叶窗帘是目前家庭中使用较多的一种窗帘。清洗先把窗关好，在其上喷洒适量清水或擦光剂，然后用抹布擦干，既可使窗帘保持较长时间的清洁光亮。窗帘的拉绳处，可用一把柔软的鬃毛刷轻轻擦拭。如果窗帘较脏，则可以抹布蘸些温水溶开的洗涤清洗，也可用少许氨溶液擦拭。\r\n\r\n　　天鹅绒制成的窗帘脏了时，先把窗帘浸泡在中碱性清洁液中，用手轻压。洗净后放在斜式架子上，使水份自动滴干，就会使窗帘清洁如新了。帆布或麻制成的窗帘清洗后难干燥。因此，不宜到水中直接清洗，宜用海绵蘸些温水或肥皂溶液、氨溶液混合液体进行揩抹，待晾干后卷起来既可。\r\n\r\n　　静电植绒布制成的窗帘不太容易脏，无需经常清洗。但如果清洗时须注意，切忌将其泡在水中揉洗或刷洗，只需用棉纱布蘸上酒精或汽油轻轻地揩擦就行了，如果绒布过湿，切忌用力拧绞，以免颈毛脱掉，影响美观。正确的清洗方法应该是用双手压去水分或让其自然晾干，这样就可以保持植绒原来的面貌。\r\n\r\n　　普通布料做成的窗帘对于一些用普通布料做成的窗帘，可用湿布擦洗，也可按常规方法放在清水中或洗衣机里清洗。\r\n\r\n　　总之，窗帘的清洗要因地制宜，不同的材质和面料就要选择相对应的方式与方法。顺应窗帘的样式，清洗起来也就方便了很多。\r\n', now());
INSERT INTO `news` VALUES ('3', '1', '../photo/2018321418110006034.jpg', '家居窗帘尽量别选复杂的', '　　人们常说窗户是居室的眼睛，而窗帘则被形象地称为“眉目传情”的睫毛。但很多消费者反映，目前市场上的窗帘越来越来花哨、复杂，种类也是五花八门。到底应该如何选择一款适合自己的窗帘呢？\r\n　　选窗帘时，尽量不要选繁琐、厚重的窗帘。过于厚重、复杂的窗帘，不仅会增加经济成本，对人们的视觉和精神空间也是一种侵占。国外有研究表明，人长时间与单一、过于繁琐的物品接触，极易出现烦躁情绪。从健康角度来说，繁琐的窗帘不但有窗纱和窗帘，还有窗幔和一些装饰物，很容易聚集灰尘颗粒和细菌，是引起哮喘、咳嗽等呼吸道疾病的罪魁祸首。\r\n　　在和居室总体色调和风格一致的情况下，窗帘的材质也很重要，尽量不要选用化纤、涂漆材质的窗帘。化纤面料会产生静电，而静电又容易吸附空气中的尘埃和病菌，对人体健康不利，但化纤面料的窗帘耐热性好，可以用在阳台上；居室内窗帘布料的选择取决于房间对光线的需求量，光线不足的可以选择薄纱、薄棉或丝质布料；房间光线过于充足则应选择稍厚的羊毛混纺或棉质面料做窗帘；如果对房间光线要求不是十分严格，一般选用素面印花棉质或麻质布料最好。\r\n　　选择窗帘还要根据个人喜好和生活习惯。对老年人来说，一丝光线的射入也会让他们在睡眠中辗转反侧，因此颜色重一些、密封效果好一点的窗帘比较适合。对于儿童来说，色彩活泼、透光性好的窗帘有利于孩子心理和生理健康，建议用卷帘。对于有严重睡眠障碍的人来说，只有选择遮光帘才能提供其所需要的完全黑暗的睡眠环境。', now());
INSERT INTO `news` VALUES ('4', '1', '../photo/20180320135031163116.jpg', '怎么挑选百叶窗帘', '\r\n\r\n　　整个窗帘配件包括叶片和所有配件（线架、调节棒、拉线）以及调节棒上的小配件都要保持颜色一致，这表明生产工艺已过关，窗帘的质量也较好。\r\n\r\n　　二、检查光洁度\r\n\r\n　　用手感觉叶片与线架的光滑度，质量好的产品应是光滑平整，边缘圆滑，无刺手扎手之感。\r\n\r\n　　三、打开窗帘，测试叶片的开合功能\r\n\r\n　　转动调节棒打开叶片，各叶片间应保持良好的水平度，即各叶片间的间隔距离匀称，各叶片保持平直，无上下弯曲之感。当叶片闭合时，各叶片间应相互吻合，无漏光的空隙。\r\n\r\n　　四、检查抗变形度\r\n\r\n　　叶片打开后，可用手用力下压叶片，使受力叶片下弯，然后迅速松手，如各叶片迅即恢复水平状态，无弯曲现象出现，则表明质量合格。\r\n\r\n　　五、测试自动锁紧功能\r\n\r\n　　当叶片全部闭合时，拉动拉线，即可卷起叶片。此时向右扯拉线，叶片应自动锁紧，保持相应的卷起状态，既不继续上卷，也不松脱下滑。否则，该锁紧功能就有问题。\r\n', now());
INSERT INTO `news` VALUES ('5', '2', '../photo/20180320135067116711.jpg', '选择窗帘的技巧', '\r\n\r\n选择窗帘的技巧 窗帘与居室的完美搭配，决定着房屋设计的完美。因此，建议您在购买窗帘的时候，注意下面的细节：  \r\n　　细节1提前了解布料功能性  1.防噪音 随着季节转暖，人们的户外活动增多，窗外的噪音需要窗帘的阻隔。如果希望得到较好的吸音效果，一般来说，越厚的窗帘其吸音性也越强，好比植绒、棉、麻等质地的窗帘。2.遮光性 在夏季的时候，光线强烈，在卧室里，选择遮光性强的窗帘布料可以保证良好的睡眠。在客厅和餐厅，则可以选择透光性好的薄质布料了。 \r\n　　细节2 窗帘尺寸的选择 窗帘的面积要能够遮盖窗户才会起到良好的遮光效果。窗帘的长度则应该按照窗户的具体情况而定。落地窗和长框窗需要用落地帘；窗台高于地板的窗户既可以用落地帘，也可以用齐窗台的窗帘；较大的窗户应该选择宽出窗洞的窗帘，这样才华达到视觉上的平衡效果。 \r\n　　细节3 窗帘要和窗户配套 由于现在房屋的户型和窗户变革多样，因此窗帘的选择要“因地制宜”。 卧式窗。对于这种短而宽的典型窗户，如果没有深阳台和散热器，那么选择落地帘是较好的选择。 不雅观景窗。这种窗户装有大块的玻璃，面积大，窗帘用布多，因此有须要使用带有拉绳等机械装置的重型帘轨。 凸窗。对于高大的凸窗来说，可以接纳由几幅单独的帘布组成的落地窗帘，各个帘布单独系好，使用持续的帘盒将各幅帘布联成一体。如果凸窗比较小，或者是弧形的，则可以将其当做一个整体来进行装修。接纳一个双幅帘，每幅都能完全拉到窗户的两边。 \r\n　　细节4 窗帘斑纹有讲究 窗帘斑纹和图案应该和房间的窗户大小、居住者的年龄阅历，以及室内装修、家具风格彼此协调。 如果窗户比较短，尽量不要选择横向的图案或者小碎花的图案，最好接纳竖直的斑纹。在小窗户上，应该制止选择大图案的窗帘，不然会更显得窗户狭小。窗帘的斑纹应该端正，不要倾斜，否则会造成窗户倾斜的错觉。  \r\n　　细节5 窗帘颜色的选择 在客厅，最好选择暖色调的窗帘，衬托热情、温馨的氛围。书房里可以选择清新的绿色系窗帘，营造自然、安静沉着僻静的气氛。在卧室里，可以选择平衡色，带来柔和、舒适、安闲的视觉感受。 在光线偏暗的朝北房间里，适合选择中性偏冷色调的窗帘；而在光线好的向阳房间里，悬挂栗红色或者黄色调的窗帘能够将强烈的光线调节成柔和的散光，烘托居室的温柔质感。 \r\n　　细节6 窗帘面料的选择 从材质上看，窗帘有棉质、麻质、纱质、绸缎、植绒、竹质、人造纤维等等。棉和麻是窗帘最常见的材质，便于洗涤和更换，适合卧室使用。 纱质窗帘的装修性较强，能够加强室内空间的纵深感，并且透光性好，一般适合在客厅和阳台上使用。 绸缎和植绒窗帘的质地非常细腻，显得豪华富丽，遮光性和隔音效果都很好，但是价格相对高一些。 竹帘的纹理清晰，采光效果好，并且十分耐磨、防潮、防霉，不容易褪色，在阳台使用非常合适。 人造纤维的窗帘质地比较硬，容易洗涤，而且比较耐用，其遮阳性也很好。 \r\n　　细节7 窗帘辅料的选择 一般来说，富丽华贵的欧式罗马帘往往由幔头、窗帘、纱帘组成，这类窗帘所使用的辅料会比较多，而现代款式的窗帘则可以省下不少辅料。 滑轨。轨道的用量一般就是窗户加上窗套，再加上10厘米摆布的长度。如果有纱帘和布帘，则需要采办两层滑轨。 铅线。它是由中心直径0.5厘米的小铅段用线穿起来的线，用在窗帘布的下摆处，以增加窗帘的垂感。它的用量一般等于所买布和纱下边沿的总米数。当然，如果面料的垂感已经比较好，则可以不用铅线。 布袋。它是一层加在纱帘和布帘顶部的质料，配合挂钩一起来固定窗帘。它的用量一般等于所买布和纱上边沿的总米数。 花边。花边的用量大致与幔头、垂边的长度相当，只需要按照窗幔面料的长度来计算就可以了。 清洁窗帘的时候不要用漂白剂，也尽量不要脱水或烘干，最好让其自然风干。不过，差别的窗帘，其清洁方法也是差别的，要按照材质自己的特点来进行。\r\n', now());
INSERT INTO `news` VALUES ('6', '2', '../photo/20180320135022882288.jpg', '窗帘种类概述', '\r\n\r\n窗帘的款式、风格及作用：\r\n1、开合帘（平开帘）——沿着轨道的轨迹或杆子作平行移动的窗帘。\r\n　　（1）欧式豪华形：上面有窗幔，窗帘的边沿饰有裙边，花型以色彩浓郁的大花为主显得比较华贵富丽。\r\n　　（2）罗马杆式：窗帘的轨道是用各种造型或材质的罗马杆，花型和做法的变化多，有窗幔和无窗幔的，花型可以用色彩浓郁的大花，也可用比较素雅条格形或素色等。\r\n　　（3）简约式：这种窗帘突出面料的质感和悬垂性，不添任何辅助的装饰手段，以素色、条格形或色彩比较淡雅的小花草为素材，显得比较时尚和大气。\r\n　　（4）实惠形（日式）：根据窗户的大小来制作，色彩或花型选用比较清淡、经济实惠。\r\n2、罗马帘（升降帘）——在绳索的牵引下作上下移动的窗帘。\r\n　　罗马帘多数以纱为主（当然也有其它面料）， 多从装饰美化这个层面来考虑。\r\n　　主要出现在客庭、过道或书房、宾馆的大庭、咖啡庭等等不需要阻挡强烈光源的场所，所以制作要求更高。它的款式大概有这样几种：\r\n　　（1）普通拉绳式，\r\n　　（2）横杆式，\r\n　　（3）扇形，\r\n　　（4）波浪形，\r\n　　还有有窗幔和无窗幔的设计，它可以是单独的窗帘，也可以同开合帘组合起来。\r\n3、卷帘——随着卷管的卷动而作上下移动的窗帘。\r\n　　卷帘一般用在卫生间、办公室等场所，主要起到阻挡视线的作用。\r\n　　材质一般选用压成各种纹路或印成各种图案的无纺布。要求亮而不透，表面挺刮。\r\n4、百叶帘——可以作180度调节并可以作上下垂直或左右平移的硬质窗帘。\r\n　　这种窗帘适用性比较广如： 书房、卫生间、厨房间、办公室及一些公共场所都可用，具有阻挡视线和调节光线的作用，材质有木质、金属、化纤布或成形的无纺布等，款式有垂直和平行两种。\r\n5、遮阳帘（天棚帘及户外遮阳帘）\r\n', now());


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品表',
  `name` varchar(48) DEFAULT NULL COMMENT '名称',
  `intro` text COMMENT '介绍',
  `photo` varchar(120) DEFAULT NULL COMMENT '存图片地址',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '产品发布时间',
  `category_id` int(11) DEFAULT NULL COMMENT '类目id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;


INSERT INTO `product` VALUES ('1', '电动卷帘', null, '../photo/20180320134915021502.jpg', now(), '1');
INSERT INTO `product` VALUES ('2', '电动卷帘', null, '../photo/20180320135069146914.jpg', now(), '1');
INSERT INTO `product` VALUES ('3', '电动卷帘', null, '../photo/20180320135093489348.jpg', now(), '1');
INSERT INTO `product` VALUES ('4', '电动卷帘', null, '../photo/20180320135024632463.jpg', now(), '1');
INSERT INTO `product` VALUES ('5', '电动卷帘', null, '../photo/20180320135049564956.jpg', now(), '1');
INSERT INTO `product` VALUES ('6', '电动卷帘', null, '../photo/20180320135074497449.jpg', now(), '1');
INSERT INTO `product` VALUES ('7', '电动卷帘', null, '../photo/20180320135000000.jpg', now(), '1');
INSERT INTO `product` VALUES ('8', '电动卷帘', null, '../photo/20180320135031163116.jpg', now(), '1');
INSERT INTO `product` VALUES ('9', '手动卷帘', null, '../photo/20180320135077507750.jpg', now(), '2');
INSERT INTO `product` VALUES ('10', '手动卷帘', null, '../photo/20180320135091729172.jpg', now(), '2');
INSERT INTO `product` VALUES ('11', '手动卷帘', null, '../photo/20180320135022882288.jpg', now(), '2');
INSERT INTO `product` VALUES ('12', '手动卷帘', null, '../photo/20180320135047804780.jpg', now(), '2');
INSERT INTO `product` VALUES ('13', '手动卷帘', null, '../photo/20180320135072737273.jpg', now(), '2');
INSERT INTO `product` VALUES ('14', '手动卷帘', null, '../photo/20180320135098249824.jpg', now(), '2');
INSERT INTO `product` VALUES ('15', '手动卷帘', null, '../photo/20180320135029402940.jpg', now(), '2');
INSERT INTO `product` VALUES ('16', '手动卷帘', null, '../photo/20180320135054335433.jpg', now(), '2');
INSERT INTO `product` VALUES ('17', '手动卷帘', null, '../photo/20180320135079267926.jpg', now(), '2');
INSERT INTO `product` VALUES ('18', '布艺窗帘', null, '../photo/2018321445919803852.jpg', now(), '3');
INSERT INTO `product` VALUES ('19', '布艺窗帘', null, '../photo/2018321446363501464.jpg', now(), '3');
INSERT INTO `product` VALUES ('20', '布艺窗帘', null, '../photo/2018321446422406217.jpg', now(), '3');
INSERT INTO `product` VALUES ('21', '布艺窗帘', null, '../photo/2018321446214603551.jpg', now(), '3');
INSERT INTO `product` VALUES ('22', '飘窗坐垫', null, '../photo/20180320135096519651.jpg', now(), '4');
INSERT INTO `product` VALUES ('23', '飘窗坐垫', null, '../photo/20180320135084348434.jpg', now(), '4');
INSERT INTO `product` VALUES ('24', '飘窗坐垫', null, '../photo/20180320135067116711.jpg', now(), '4');
INSERT INTO `product` VALUES ('25', '飘窗坐垫', null, '../photo/20180320135015501550.jpg', now(), '4');
