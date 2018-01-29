/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.54 : Database - vue-admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `tb_blog` */

DROP TABLE IF EXISTS `tb_blog`;

CREATE TABLE `tb_blog` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `userId` varchar(50) DEFAULT NULL COMMENT '作者',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_blog` */

insert  into `tb_blog`(`id`,`title`,`content`,`userId`,`createTime`) values ('1c6732d554044385837ba956112a252a','呵呵','哈哈','uidxxx','2017-06-09 09:53:10'),('436bfa2df0fe4b65b126dec65b3efb34','测试','测试内容','09c63f873a9e472ca464accb61cd5e51','2016-12-30 11:16:31'),('45e3d28b04774f48b8be0206a90cffe8','机构和计划','发的','uidxxx','2017-06-20 11:45:51'),('52d47feaf7404c818255e5ae021eacab','测试','测试内容','09c63f873a9e472ca464accb61cd5e51','2016-12-30 11:16:18'),('5a8d876cfe164695b5543091f7a91629','呵呵','哈哈','uidxxx','2017-06-09 10:27:40'),('7177a02736ed4985b4fc74a356a7b96e','测试','测试内容','09c63f873a9e472ca464accb61cd5e51','2016-12-30 11:16:30'),('72142bfdfbb84bd793e9dd8e961f3518','测试','测试内容','09c63f873a9e472ca464accb61cd5e51','2016-12-30 11:16:21'),('8f2b518ffb9645dc8e36030fa6cd2181','更多发挥','广告费','uidxxx','2017-06-20 11:25:20'),('e975e62814d04264bf97793ca71609fb','呵呵','哈哈',NULL,'2017-06-09 09:52:36');

/*Table structure for table `tb_log` */

DROP TABLE IF EXISTS `tb_log`;

CREATE TABLE `tb_log` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `logTitle` varchar(100) DEFAULT NULL COMMENT '日志标题',
  `logContent` varchar(300) DEFAULT NULL COMMENT '日志内容',
  `clientIp` varchar(50) DEFAULT NULL COMMENT 'IP',
  `logTime` datetime DEFAULT NULL COMMENT '时间',
  `requestMethod` varchar(50) DEFAULT NULL COMMENT '请求方式',
  `requestParams` text COMMENT '参数',
  `other` varchar(300) DEFAULT NULL COMMENT '其他数据',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名',
  `logUrl` varchar(500) DEFAULT NULL COMMENT '日志URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_log` */

insert  into `tb_log`(`id`,`logTitle`,`logContent`,`clientIp`,`logTime`,`requestMethod`,`requestParams`,`other`,`userName`,`logUrl`) values ('03619a4db5cc40ac9c4b3eae2bb3fb0f','','batch delete','192.168.245.1','2018-01-29 09:43:21','DELETE','{\"ids\":[\"aec4990b8db1468a993147c3a1a32d19,b34f0cc6c91e4eceabf18947bfef3223,c3046a5cc6a440509eb83a17cd3b8554,d95c1788e9b4451f9f4ce67a121c1a81,e0b676b48248462a96053f5ee27675e4,e26e146e138c4254a5cfd129ec48cde2,ee66a5ac88f14ef59434d99ba0677c44,ee8c537e80674ac6bb17312d09007253,f1b390850be54717af6a2d8d9aabb788,f43c91608aa444b6b280a4c1dd1aa6e2\"]}',NULL,NULL,'/vue-admin/role/del/batch?ids=aec4990b8db1468a993147c3a1a32d19,b34f0cc6c91e4eceabf18947bfef3223,c3046a5cc6a440509eb83a17cd3b8554,d95c1788e9b4451f9f4ce67a121c1a81,e0b676b48248462a96053f5ee27675e4,e26e146e138c4254a5cfd129ec48cde2,ee66a5ac88f14ef59434d99ba0677c44,ee8c537e80674ac6bb17312d09007253,f1b390850be54717af6a2d8d9aabb788,f43c91608aa444b6b280a4c1dd1aa6e2'),('118a06e7db40450f821c04260ed32c98',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('26e89698a58f4ceca7fa65457a2b8c71','','delete','192.168.245.1','2018-01-29 09:43:14','DELETE','{}',NULL,NULL,'/vue-admin/role/790e5da14b2c4dcc8520f351ed2dbfd4?null'),('2f1f62b78e294641a1cc99667cb00e71','','batch delete','192.168.245.1','2018-01-29 09:43:24','DELETE','{\"ids\":[\"fe1c4e043a9b489d998f057d817f3346\"]}',NULL,NULL,'/vue-admin/role/del/batch?ids=fe1c4e043a9b489d998f057d817f3346'),('682f2f849bbe467faf6fee4c7c1e78f0','','delete','192.168.245.1','2018-01-29 09:43:17','DELETE','{}',NULL,NULL,'/vue-admin/role/8d89f1ef813040cea561a3b30228b8cf?null'),('7ae850739eeb4c73a12989075558bac7','','add','0:0:0:0:0:0:0:1','2018-01-29 10:43:23','POST','{}',NULL,NULL,'/vue-admin/log?null'),('8a4b8f98c056419ca1c3271df5a618dc','','add','192.168.245.1','2018-01-29 10:37:32','POST','{\"roleName\":[\"xxxl\"],\"roleDesc\":[\"xdaads\"]}',NULL,NULL,'/vue-admin/role?roleName=xxxl&roleDesc=xdaads'),('978f5417e2d04a2ab2a95f1fb552d08f','','add','192.168.245.1','2018-01-29 09:43:41','POST','{\"roleName\":[\"超级管理员\"],\"roleDesc\":[\"所有权限\"]}',NULL,NULL,'/vue-admin/role?roleName=%E8%B6%85%E7%BA%A7%E7%AE%A1%E7%90%86%E5%91%98&roleDesc=%E6%89%80%E6%9C%89%E6%9D%83%E9%99%90'),('99f3b995c5ce488189ac6c9432c430e5','','delete','192.168.245.1','2018-01-29 09:43:08','DELETE','{}',NULL,NULL,'/vue-admin/role/430e50ef947449a58f739be01d1c8b32?null'),('9d23e851ad914e90adbfd816fc3e6070','','delete','192.168.245.1','2018-01-29 09:43:12','DELETE','{}',NULL,NULL,'/vue-admin/role/7636fed6376d416b8bea266638b40463?null'),('a5b1bb2e8540456c9662518c8b5c4618','','delete','192.168.245.1','2018-01-29 09:43:10','DELETE','{}',NULL,NULL,'/vue-admin/role/5875c297968b4130b8270644dfdc917c?null'),('f1f426959f2b45e98b6b597496983f89','','delete','192.168.245.1','2018-01-29 09:43:06','DELETE','{}',NULL,NULL,'/vue-admin/role/398f19bfba1d4bebb4dd159a1f72aa26?null');

/*Table structure for table `tb_menu` */

DROP TABLE IF EXISTS `tb_menu`;

CREATE TABLE `tb_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `menuName` varchar(50) NOT NULL COMMENT '菜单名称',
  `pid` varchar(50) NOT NULL COMMENT '父级菜单ID',
  `url` varchar(255) DEFAULT NULL COMMENT '连接地址',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `deep` int(11) DEFAULT NULL COMMENT '深度',
  `code` varchar(50) DEFAULT NULL COMMENT '编码',
  `resource` varchar(50) DEFAULT NULL COMMENT '资源名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `tb_menu` */

insert  into `tb_menu`(`id`,`menuName`,`pid`,`url`,`icon`,`sort`,`deep`,`code`,`resource`) values ('0818e1c76bbd44eba3a698547ec4e637','查询系统设置','10',NULL,NULL,0,3,'010600','listSetting'),('0c9b5fc8b44b41d1871a8fc8300247ec','删除菜单','4',NULL,NULL,4,3,'010303','deleteMenu'),('1','系统管理','0',NULL,'fa fa-cogs',1,1,'01',NULL),('10','系统配置','1','/system/setting/page',' fa-cog',6,2,'0106','setting'),('1db9105008404a3485b6fac30dba3c0e','查看角色列表','3',NULL,NULL,0,3,'010200','listRole'),('2','用户管理','1','/system/user/list/1','fa-user-circle-o',1,2,'0101','user'),('22e38e885f9b40b9aae6a36deb78e89c','部门管理','1','/system/dept/list/1','fa-graduation-cap',4,2,'0104','dept'),('3','角色管理','1','/system/role/list/1','fa-users',2,2,'0102','role'),('363a778e78a346a68210b2590163a943','编辑部门','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,2,3,'010402','editDept'),('3f26102ef0e04c3c9328cb97067cc5fa','创建菜单','4',NULL,NULL,1,3,'010301','addMenu'),('3fb6a7a5935b4efabf3de82e7e1baeb6','新增部门','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,1,3,'010401','addDept'),('4','菜单管理','1','/system/menu/list/1','fa-list',3,2,'0103','menu'),('4253190001c1480fb0d631d64d150535','编辑用户','2',NULL,NULL,2,3,'010102','editUser'),('42dd5ae31e3a43b3a197440e8ec19a94','监控列表','f5a20c82110b4a3ea9e30ca01a038680',NULL,NULL,1,3,'010701','monitorList'),('488ef1eff57b4827acade7c0744278ce','查看菜单列表','4',NULL,NULL,0,3,'010300','listMenu'),('4e816a9854714d24b0413d929d637a2b','查看部门列表','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,0,3,'010400','listDept'),('5','业务日志','1','/system/log/list/1','fa-info-circle',5,2,'0105','log'),('5bb55dd90ba44db39d6e3d7f3f316af0','类目管理','661a1f4a6ec94fa89ec6f90ce77a8eb3','#','fa-file',2,2,'0202',NULL),('5d3dd56c16ff4e32aecae1b3228159c7','查看日志列表','5',NULL,NULL,0,3,'010500','listLog'),('60dda993d87647f5989c15f14f866df9','新增角色','3',NULL,NULL,1,3,'010201','addRole'),('649b484b58414d91aefa5a26143e6557','删除用户','2',NULL,NULL,3,3,'010103','deleteUser'),('661a1f4a6ec94fa89ec6f90ce77a8eb3','商品管理','0',NULL,'fa-folder',1,1,'02',NULL),('686630c7cb624cc786dcdc9958971a6b','编辑角色','3',NULL,NULL,2,3,'010202','editRole'),('79d78b8357174cac8f44abd275dec597','删除部门','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,3,3,'010403','deleteDept'),('915c309ebe5047b68645b3eb777dd8c9','操作系统设置','10',NULL,NULL,1,3,'010601','doSetting'),('a5ebf29168234406939856bc6890c86b','角色授权','3',NULL,NULL,4,3,'010204','authRole'),('a73802e513cc4465883530ec8074abbb','新增用户','2',NULL,NULL,1,3,'010101','addUser'),('b1487b113b324e79b7fbadbe28660349','采购管理','0',NULL,'fa-folder',3,1,'03',NULL),('b4e7232189b14cf3ba160cf7b0d3bf37','删除角色','3',NULL,NULL,3,3,'010203','deleteRole'),('d2bc30feb5474a1bb7e02d48d39a3f8a','查看用户列表','2',NULL,NULL,0,3,'010100','listUser'),('dc5f478d98ed4297a8ae638fe90df050','编辑菜单','4',NULL,NULL,3,3,'010302','editMenu'),('e0ff3505df7c4aff87c60bb510c6d274','仓库管理','0',NULL,'fa-folder',4,1,'04',NULL),('f5a20c82110b4a3ea9e30ca01a038680','系统监控','1','/system/monitor/list','fa-eye',7,2,'0107',NULL),('f899f3d3baec4571b1c786717f9906fd','批量删除角色','3',NULL,NULL,5,3,'010205','deleteBatchRole'),('f8db3e5b12d04a46b07026e2828791fc','SPU管理','661a1f4a6ec94fa89ec6f90ce77a8eb3','#','fa-file',1,2,'0201',NULL);

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `id` varchar(50) NOT NULL COMMENT '逐渐',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `roleDesc` varchar(300) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_role` */

insert  into `tb_role`(`id`,`roleName`,`roleDesc`) values ('71dbb93ee0f14119a86ca9d241051516','xxxl','xdaads'),('80f5b7ac3a8f4044bb9f6219877d185e','超级管理员','所有权限');

/*Table structure for table `tb_role_menu` */

DROP TABLE IF EXISTS `tb_role_menu`;

CREATE TABLE `tb_role_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `roleId` varchar(50) NOT NULL COMMENT '角色主键',
  `menuId` varchar(50) NOT NULL COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

/*Data for the table `tb_role_menu` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `userDesc` varchar(300) DEFAULT NULL COMMENT '描述',
  `userStatus` int(1) DEFAULT '1' COMMENT '状态,1-启用,0-禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`userName`,`password`,`createTime`,`userDesc`,`userStatus`) values ('09c63f873a9e472ca464accb61cd5e51','test','','2016-12-12 15:50:39','aaaaa',0),('22b9f1ba85364bf08418a7fcf3c8214b','dsadsa','','2018-01-28 13:46:46','dasdsadas',1),('629ba7eb1d8944d2873ecfc6896288e7','zhangsan','','2016-12-12 11:49:21','张三负责系统的委会和开发工作。',1);

/*Table structure for table `tb_user_role` */

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `Id` varchar(50) NOT NULL COMMENT '主键',
  `userId` varchar(50) NOT NULL COMMENT '用户主键',
  `roleId` varchar(50) NOT NULL COMMENT '角色主键',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

/*Data for the table `tb_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
