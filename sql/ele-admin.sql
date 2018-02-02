/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.54 : Database - ele-admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `deptName` varchar(100) NOT NULL COMMENT '部门名称',
  `deptDesc` varchar(300) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`id`,`deptName`,`deptDesc`) values ('15234e8bceb949bf89b1cbe8239c07f6','产品部','xxx');

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `userName` varchar(50) NOT NULL COMMENT '用户',
  `title` varchar(300) DEFAULT NULL COMMENT '日志',
  `url` varchar(300) DEFAULT NULL COMMENT '地址',
  `params` text COMMENT '参数',
  `createTime` datetime DEFAULT NULL COMMENT '日志时间',
  `method` varchar(50) DEFAULT NULL COMMENT '请求方式',
  `ip` varchar(50) DEFAULT NULL COMMENT '客户端IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

/*Data for the table `sys_log` */

insert  into `sys_log`(`id`,`userName`,`title`,`url`,`params`,`createTime`,`method`,`ip`) values ('135ec833ff3a450bb189892376d049d2','admin','编辑角色','/ele-admin-api/sys/role/edit?id=482aac67013449478919e2783e0f7dd9&roleName=%E6%96%B9%E5%BC%8Ff&roleDesc=%E5%9C%B0%E6%96%B9%E7%9A%84&roleState=1&roleCode=rgdfsgfdgfd','{\"roleName\":[\"方式f\"],\"roleDesc\":[\"地方的\"],\"id\":[\"482aac67013449478919e2783e0f7dd9\"],\"roleState\":[\"1\"],\"roleCode\":[\"rgdfsgfdgfd\"]}','2018-02-02 11:29:42','PUT','192.168.245.1'),('cfb67c552d444349874855d99f6d03dd','admin','编辑角色','/ele-admin-api/sys/role/edit?id=6e9923a1a83d4f768d46d6551d4d4d19&roleName=%E6%8D%A2%E4%B8%AAhg&roleDesc=%E6%8D%A2%E4%B8%AA%E6%8D%A2%E4%B8%AA%E6%8D%A2%E4%B8%AA&roleState=1&roleCode=refdsfdsjjh','{\"roleName\":[\"换个hg\"],\"roleDesc\":[\"换个换个换个\"],\"id\":[\"6e9923a1a83d4f768d46d6551d4d4d19\"],\"roleState\":[\"1\"],\"roleCode\":[\"refdsfdsjjh\"]}','2018-02-02 11:29:40','PUT','192.168.245.1'),('d21facd2e9e142f68945b9cf912fd2ba','admin','编辑角色','/ele-admin-api/sys/role/edit?id=482aac67013449478919e2783e0f7dd9&roleName=%E6%96%B9%E5%BC%8Ff&roleDesc=%E5%9C%B0%E6%96%B9%E7%9A%84&roleState=-1&roleCode=rgdfsgfdgfd','{\"roleName\":[\"方式f\"],\"roleDesc\":[\"地方的\"],\"id\":[\"482aac67013449478919e2783e0f7dd9\"],\"roleState\":[\"-1\"],\"roleCode\":[\"rgdfsgfdgfd\"]}','2018-02-02 11:29:46','PUT','192.168.245.1'),('d5ce14e23361479fa82e7aff34bd8223','admin','编辑用户','/ele-admin-api/sys/user/edit?userState=1&id=335abede3bf74a99856e25b2e2818d7f&userName=%E4%BD%A0%E5%A5%BD&password=&userDesc=fdsfds&userImg=http:%2F%2Fnews.mydrivers.com%2FImg%2F20110518%2F04481549.png&password2=','{\"password\":[\"\"],\"userImg\":[\"http://news.mydrivers.com/Img/20110518/04481549.png\"],\"userState\":[\"1\"],\"userDesc\":[\"fdsfds\"],\"password2\":[\"\"],\"id\":[\"335abede3bf74a99856e25b2e2818d7f\"],\"userName\":[\"你好\"]}','2018-02-02 11:28:09','PUT','192.168.245.1'),('d8db750a98184f148fe10bf5abff7016','admin','创建角色','/ele-admin-api/sys/role/add?roleState=1&roleName=daf&roleCode=eaea&roleDesc=fasfers','{\"roleName\":[\"daf\"],\"roleDesc\":[\"fasfers\"],\"roleState\":[\"1\"],\"roleCode\":[\"eaea\"]}','2018-02-02 11:28:23','POST','192.168.245.1'),('fc7f3af0e30c4f2d8a3f33d02bffda31','admin','编辑角色','/ele-admin-api/sys/role/edit?id=b1f9ce5543a049be9f169a3f5e6b72a8&roleName=%E8%B6%85%E7%BA%A7%E7%AE%A1%E7%90%86%E5%91%98&roleDesc=%E8%B6%85%E7%BA%A7%E7%AE%A1%E7%90%86%E5%91%98&roleState=1&roleCode=fdfdfdsxxxxxxxxx','{\"roleName\":[\"超级管理员\"],\"roleDesc\":[\"超级管理员\"],\"id\":[\"b1f9ce5543a049be9f169a3f5e6b72a8\"],\"roleState\":[\"1\"],\"roleCode\":[\"fdfdfdsxxxxxxxxx\"]}','2018-02-02 11:29:37','PUT','192.168.245.1');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
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

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`menuName`,`pid`,`url`,`icon`,`sort`,`deep`,`code`,`resource`) values ('0818e1c76bbd44eba3a698547ec4e637','查询系统设置','10',NULL,NULL,0,3,'010600','listSetting'),('0c9b5fc8b44b41d1871a8fc8300247ec','删除菜单','4',NULL,NULL,4,3,'010303','deleteMenu'),('1','系统管理','0',NULL,'fa fa-cogs',1,1,'01',NULL),('10','系统配置','1','/system/setting/page',' fa-cog',6,2,'0106','setting'),('1db9105008404a3485b6fac30dba3c0e','查看角色列表','3',NULL,NULL,0,3,'010200','listRole'),('2','用户管理','1','/system/user/list/1','fa-user-circle-o',1,2,'0101','user'),('22e38e885f9b40b9aae6a36deb78e89c','部门管理','1','/system/dept/list/1','fa-graduation-cap',4,2,'0104','dept'),('3','角色管理','1','/system/role/list/1','fa-users',2,2,'0102','role'),('363a778e78a346a68210b2590163a943','编辑部门','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,2,3,'010402','editDept'),('3f26102ef0e04c3c9328cb97067cc5fa','创建菜单','4',NULL,NULL,1,3,'010301','addMenu'),('3fb6a7a5935b4efabf3de82e7e1baeb6','新增部门','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,1,3,'010401','addDept'),('4','菜单管理','1','/system/menu/list/1','fa-list',3,2,'0103','menu'),('4253190001c1480fb0d631d64d150535','编辑用户','2',NULL,NULL,2,3,'010102','editUser'),('42dd5ae31e3a43b3a197440e8ec19a94','监控列表','f5a20c82110b4a3ea9e30ca01a038680',NULL,NULL,1,3,'010701','monitorList'),('488ef1eff57b4827acade7c0744278ce','查看菜单列表','4',NULL,NULL,0,3,'010300','listMenu'),('4e816a9854714d24b0413d929d637a2b','查看部门列表','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,0,3,'010400','listDept'),('5','业务日志','1','/system/log/list/1','fa-info-circle',5,2,'0105','log'),('5bb55dd90ba44db39d6e3d7f3f316af0','类目管理','661a1f4a6ec94fa89ec6f90ce77a8eb3','#','fa-file',2,2,'0202',NULL),('5d3dd56c16ff4e32aecae1b3228159c7','查看日志列表','5',NULL,NULL,0,3,'010500','listLog'),('60dda993d87647f5989c15f14f866df9','新增角色','3',NULL,NULL,1,3,'010201','addRole'),('649b484b58414d91aefa5a26143e6557','删除用户','2',NULL,NULL,3,3,'010103','deleteUser'),('661a1f4a6ec94fa89ec6f90ce77a8eb3','商品管理','0',NULL,'fa-folder',1,1,'02',NULL),('686630c7cb624cc786dcdc9958971a6b','编辑角色','3',NULL,NULL,2,3,'010202','editRole'),('79d78b8357174cac8f44abd275dec597','删除部门','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,3,3,'010403','deleteDept'),('915c309ebe5047b68645b3eb777dd8c9','操作系统设置','10',NULL,NULL,1,3,'010601','doSetting'),('a5ebf29168234406939856bc6890c86b','角色授权','3',NULL,NULL,4,3,'010204','authRole'),('a73802e513cc4465883530ec8074abbb','新增用户','2',NULL,NULL,1,3,'010101','addUser'),('b1487b113b324e79b7fbadbe28660349','采购管理','0',NULL,'fa-folder',3,1,'03',NULL),('b4e7232189b14cf3ba160cf7b0d3bf37','删除角色','3',NULL,NULL,3,3,'010203','deleteRole'),('d2bc30feb5474a1bb7e02d48d39a3f8a','查看用户列表','2',NULL,NULL,0,3,'010100','listUser'),('dc5f478d98ed4297a8ae638fe90df050','编辑菜单','4',NULL,NULL,3,3,'010302','editMenu'),('e0ff3505df7c4aff87c60bb510c6d274','仓库管理','0',NULL,'fa-folder',4,1,'04',NULL),('f5a20c82110b4a3ea9e30ca01a038680','系统监控','1','/system/monitor/list','fa-eye',7,2,'0107',NULL),('f899f3d3baec4571b1c786717f9906fd','批量删除角色','3',NULL,NULL,5,3,'010205','deleteBatchRole'),('f8db3e5b12d04a46b07026e2828791fc','SPU管理','661a1f4a6ec94fa89ec6f90ce77a8eb3','#','fa-file',1,2,'0201',NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `roleName` varchar(50) NOT NULL COMMENT '角色名称',
  `roleDesc` varchar(300) DEFAULT NULL COMMENT '角色描述',
  `roleState` int(2) DEFAULT '1' COMMENT '状态,1-启用,-1禁用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `roleCode` varchar(50) DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`roleName`,`roleDesc`,`roleState`,`createTime`,`roleCode`) values ('482aac67013449478919e2783e0f7dd9','方式f','地方的',-1,'2018-02-01 14:27:13','rgdfsgfdgfd'),('6ca06ac0d8bb4fe9bb26af1d838c6a8c','daf','fasfers',1,'2018-02-02 11:28:23','eaea'),('6e9923a1a83d4f768d46d6551d4d4d19','换个hg','换个换个换个',1,'2018-02-01 14:27:09','refdsfdsjjh'),('b1f9ce5543a049be9f169a3f5e6b72a8','超级管理员','超级管理员',1,'2017-09-14 15:02:16','fdfdfdsxxxxxxxxx');

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `roleId` varchar(50) NOT NULL COMMENT '角色主键',
  `menuId` varchar(50) NOT NULL COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`roleId`,`menuId`) values ('0b1a27eb4b6045b1a6b1b98611039142','b1f9ce5543a049be9f169a3f5e6b72a8','0c9b5fc8b44b41d1871a8fc8300247ec'),('0f74f8af444d474f8a3798dc1c7f037a','b1f9ce5543a049be9f169a3f5e6b72a8','22e38e885f9b40b9aae6a36deb78e89c'),('17a304330b6343c69282d600cd5fe044','6e9923a1a83d4f768d46d6551d4d4d19','5'),('190580e1d96448a58692e0cc0791a17a','b1f9ce5543a049be9f169a3f5e6b72a8','488ef1eff57b4827acade7c0744278ce'),('1b79b5249a9b4d108615a2461d810c25','b1f9ce5543a049be9f169a3f5e6b72a8','42dd5ae31e3a43b3a197440e8ec19a94'),('1f68b02c7a3d46caab6ec03cc6cd7c88','b1f9ce5543a049be9f169a3f5e6b72a8','e0ff3505df7c4aff87c60bb510c6d274'),('23caf42d38f843c5bbb91afc0b108f19','b1f9ce5543a049be9f169a3f5e6b72a8','1'),('24f582d7ea774868b171b2add9dca113','b1f9ce5543a049be9f169a3f5e6b72a8','649b484b58414d91aefa5a26143e6557'),('34ae8393d0f44241ab2bfb8a0623fa4b','b1f9ce5543a049be9f169a3f5e6b72a8','b4e7232189b14cf3ba160cf7b0d3bf37'),('35255d74c3e645e3a396c5cbf0fad5e1','b1f9ce5543a049be9f169a3f5e6b72a8','686630c7cb624cc786dcdc9958971a6b'),('3be4050245a34eada80c6c64e383da3c','6e9923a1a83d4f768d46d6551d4d4d19','d2bc30feb5474a1bb7e02d48d39a3f8a'),('3ea8bc1e66ca46ba9242193f328ecfdd','6e9923a1a83d4f768d46d6551d4d4d19','2'),('41cbcdb1ab7f430aa34249a4b52b92a9','b1f9ce5543a049be9f169a3f5e6b72a8','d2bc30feb5474a1bb7e02d48d39a3f8a'),('464cb3e2013e405bb8d1ff856b54d076','b1f9ce5543a049be9f169a3f5e6b72a8','5'),('478f0a6ceec84568a4cdd2a1e0ad1a22','b1f9ce5543a049be9f169a3f5e6b72a8','363a778e78a346a68210b2590163a943'),('47c9a1cf75f348fd8e3e58892f716474','b1f9ce5543a049be9f169a3f5e6b72a8','79d78b8357174cac8f44abd275dec597'),('4e660a8d4f3a465ab0c1979455a13e8f','b1f9ce5543a049be9f169a3f5e6b72a8','dc5f478d98ed4297a8ae638fe90df050'),('5e76e81f52e746e9bde427527fd836ae','b1f9ce5543a049be9f169a3f5e6b72a8','a5ebf29168234406939856bc6890c86b'),('5f3ceee5bd474e0aad299f97b4904279','6e9923a1a83d4f768d46d6551d4d4d19','a73802e513cc4465883530ec8074abbb'),('6145fed12c934408a1c8d232db15a1ce','b1f9ce5543a049be9f169a3f5e6b72a8','4253190001c1480fb0d631d64d150535'),('62af03cbf00c4d8bb5f60e28cffe0c9b','b1f9ce5543a049be9f169a3f5e6b72a8','a73802e513cc4465883530ec8074abbb'),('67a1a540611746ca91c76cdee196b11e','b1f9ce5543a049be9f169a3f5e6b72a8','1db9105008404a3485b6fac30dba3c0e'),('6cfccbbd0edb478b92cbb6833ef7fa6d','b1f9ce5543a049be9f169a3f5e6b72a8','60dda993d87647f5989c15f14f866df9'),('8634ce5399e4426c93a8a0c800fc1bc4','b1f9ce5543a049be9f169a3f5e6b72a8','4e816a9854714d24b0413d929d637a2b'),('88cedfc2621d44bc9ebfa12aa1b9e07c','6e9923a1a83d4f768d46d6551d4d4d19','649b484b58414d91aefa5a26143e6557'),('95009eba9b0d4d03b6ea455bd7183dff','b1f9ce5543a049be9f169a3f5e6b72a8','3f26102ef0e04c3c9328cb97067cc5fa'),('ae4043b855db43b2a1e80f8656abf9e6','b1f9ce5543a049be9f169a3f5e6b72a8','5bb55dd90ba44db39d6e3d7f3f316af0'),('b64484e5c2194e0791035d4f0f409d0d','b1f9ce5543a049be9f169a3f5e6b72a8','0818e1c76bbd44eba3a698547ec4e637'),('bab841e5b7a74b389a0b8b5e040f8433','b1f9ce5543a049be9f169a3f5e6b72a8','3fb6a7a5935b4efabf3de82e7e1baeb6'),('bfcd0ec415aa4e67a68ced8f30f62946','6e9923a1a83d4f768d46d6551d4d4d19','4253190001c1480fb0d631d64d150535'),('c0a8ce9bd569438f9e0b662eedb3965d','b1f9ce5543a049be9f169a3f5e6b72a8','10'),('c34b877e914e424f8edac909a7bcf5f3','b1f9ce5543a049be9f169a3f5e6b72a8','b1487b113b324e79b7fbadbe28660349'),('d335d3df3d7e4df18cbe11c695abf8b5','6e9923a1a83d4f768d46d6551d4d4d19','5d3dd56c16ff4e32aecae1b3228159c7'),('dabbe739e20f4599b54d15ba85accfdf','b1f9ce5543a049be9f169a3f5e6b72a8','915c309ebe5047b68645b3eb777dd8c9'),('db58bbc8df294b6da0ef80070f558fe9','b1f9ce5543a049be9f169a3f5e6b72a8','f899f3d3baec4571b1c786717f9906fd'),('dc4f873651e74e4cb95f9aa800374c85','b1f9ce5543a049be9f169a3f5e6b72a8','4'),('e305c24a8bff40a8a612686dab39ac62','b1f9ce5543a049be9f169a3f5e6b72a8','3'),('e551fbe31eff4640a8ed18ed85597fa8','b1f9ce5543a049be9f169a3f5e6b72a8','2'),('e7c469838c8f4ff4bd8f7e89e7c4b090','b1f9ce5543a049be9f169a3f5e6b72a8','661a1f4a6ec94fa89ec6f90ce77a8eb3'),('f6966045c4f14068b9b97736536003db','b1f9ce5543a049be9f169a3f5e6b72a8','f5a20c82110b4a3ea9e30ca01a038680'),('f898f8033e6f49fda50f6af9276e273a','b1f9ce5543a049be9f169a3f5e6b72a8','f8db3e5b12d04a46b07026e2828791fc'),('fd453fa8ae8e4953a7ad60e301b9d38c','b1f9ce5543a049be9f169a3f5e6b72a8','5d3dd56c16ff4e32aecae1b3228159c7');

/*Table structure for table `sys_setting` */

DROP TABLE IF EXISTS `sys_setting`;

CREATE TABLE `sys_setting` (
  `Id` varchar(50) NOT NULL COMMENT '主键',
  `sysKey` varchar(50) NOT NULL COMMENT 'KEY',
  `sysName` varchar(50) NOT NULL COMMENT '名称',
  `sysValue` varchar(300) DEFAULT NULL COMMENT '值',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `sysDesc` varchar(300) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统设置表';

/*Data for the table `sys_setting` */

insert  into `sys_setting`(`Id`,`sysKey`,`sysName`,`sysValue`,`sort`,`sysDesc`) values ('1','systemName','系统名称','AdminLTE-admin',0,NULL),('2','systemSubName','系统简称','AD',1,NULL),('3','bottomCopyright','许可说明','Copyright © 2017 米粒电商. All rights reserved.',2,NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `userState` int(2) NOT NULL DEFAULT '1' COMMENT '用户状态,1-启用,-1禁用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `userDesc` varchar(300) DEFAULT NULL COMMENT '描述',
  `userImg` varchar(300) DEFAULT 'http://news.mydrivers.com/Img/20110518/04481549.png' COMMENT '头像',
  `deptId` varchar(50) DEFAULT NULL COMMENT '部门主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`userName`,`password`,`userState`,`createTime`,`userDesc`,`userImg`,`deptId`) values ('335abede3bf74a99856e25b2e2818d7f','你好','924efd66c90386a93077f56388f494dc',1,'2018-02-02 11:24:47','fdsfds','http://news.mydrivers.com/Img/20110518/04481549.png',NULL),('3568b1c7c7b842b8b0a5f47032ac14be','wsssssssssssss','0804f99064c7a59ebeff2c0252755c55',0,'2018-02-01 15:10:29','fdsfds','http://news.mydrivers.com/Img/20110518/04481549.png',NULL),('406b5e8ff862494ba6b09c9b2373d1b8','eadasdas','bc819f2c5788a92911e6c7e038f4376a',1,'2018-02-02 11:23:21','fsfdsfdsfds','http://news.mydrivers.com/Img/20110518/04481549.png',NULL),('b5a0647bc90d4d98af23b2a298929c35','fdsfdsfds','5bff2631e548e375612dbfc6e54a66a1',1,'2018-02-02 10:16:34','fsdfdsfds','http://news.mydrivers.com/Img/20110518/04481549.png',NULL),('c79ba431f9f74dfbae585b87b0cde933','admin','038bdaf98f2037b31f1e75b5b4c9b26e',1,'2017-09-14 15:02:17','xxxfdsfds','http://news.mydrivers.com/Img/20110518/04481549.png','15234e8bceb949bf89b1cbe8239c07f6'),('e44d2b9fd2394fba99db1aac8706da74','test','4292bb58be34c59d28a0dcbd11932d49',0,'2017-09-14 15:44:51','xxxtttt','http://news.mydrivers.com/Img/20110518/04481549.png','15234e8bceb949bf89b1cbe8239c07f6');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `Id` varchar(50) NOT NULL COMMENT '主键',
  `userId` varchar(50) NOT NULL COMMENT '用户主键',
  `roleId` varchar(50) NOT NULL COMMENT '角色主键',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`Id`,`userId`,`roleId`) values ('00d5df356ca545cf9ad552f23f2d7be6','8e4002d9b50643feabc6804299153862','b1f9ce5543a049be9f169a3f5e6b72a8'),('1891e090f58842d68d4c3a200b0aad3b','b5a0647bc90d4d98af23b2a298929c35','6e9923a1a83d4f768d46d6551d4d4d19'),('31d74df7628143e6a02aa3295c8a709f','b5a0647bc90d4d98af23b2a298929c35','482aac67013449478919e2783e0f7dd9'),('4c84ba89a7a743aca10c16830d3a1ff4','c79ba431f9f74dfbae585b87b0cde933','b1f9ce5543a049be9f169a3f5e6b72a8'),('6fc74723b90c4f16a9634e1742bea83c','9f51ddc024ce4d7e81468a2caa616fce','482aac67013449478919e2783e0f7dd9'),('707a363ffc2f46a98fa66b5ce9808967','e8ba7eb73d604b3ba7e6fff85bb34cc9','b1f9ce5543a049be9f169a3f5e6b72a8'),('9677ab92141245d1a77a8938ebe745ba','a0fb62a27d3a45b889e8fd7c04c92dae','b1f9ce5543a049be9f169a3f5e6b72a8'),('9ddc20cab0044f498d7f0669f6117e79','e44d2b9fd2394fba99db1aac8706da74','482aac67013449478919e2783e0f7dd9'),('bc79184a7c2b4e3d9f877fc9967bc118','b5a0647bc90d4d98af23b2a298929c35','b1f9ce5543a049be9f169a3f5e6b72a8'),('d402aa416fd94564b8f1f8b850e4f4ff','3568b1c7c7b842b8b0a5f47032ac14be','b1f9ce5543a049be9f169a3f5e6b72a8'),('f35c00d7e80e41019c7cf7b3c710e031','406b5e8ff862494ba6b09c9b2373d1b8','b1f9ce5543a049be9f169a3f5e6b72a8'),('ff271c47c72d4932b629fe8b4f27a014','3568b1c7c7b842b8b0a5f47032ac14be','6e9923a1a83d4f768d46d6551d4d4d19');

/*Table structure for table `tb_test` */

DROP TABLE IF EXISTS `tb_test`;

CREATE TABLE `tb_test` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `textDesc` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_test` */

insert  into `tb_test`(`id`,`name`,`age`,`birth`,`state`,`file`,`price`,`textDesc`) values ('1','张三xxx',18,'2017-09-18',1,'',50,'fsdfdsffdsfdsfds'),('6b3d9f5cd2494635b9d5cfb7cfbbe2d0','李四',16,NULL,1,'',2222,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
