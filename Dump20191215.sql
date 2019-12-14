-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: data_manage_system
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '国别',
  `position` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '具体位置',
  `type_id` int(11) NOT NULL COMMENT '类别',
  `ppi` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '分辨率',
  `location_x` double DEFAULT NULL COMMENT '经度',
  `location_y` double DEFAULT NULL COMMENT '维度',
  `gather_time` datetime DEFAULT NULL COMMENT '采集时间',
  `gather_duration` int(11) DEFAULT NULL COMMENT '采集时长',
  `scale` double DEFAULT NULL COMMENT '比例尺',
  `user_id` int(11) NOT NULL COMMENT '创建用户id',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `thumb_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (74,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/e67cc110-3572-441c-ba5d-064feead3a77.jpg','/upfile/img/thumb/e67cc110-3572-441c-ba5d-064feead3a77-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18'),(75,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/1c2e7a86-184b-4d2a-8793-e2b457910a06.jpg','/upfile/img/thumb/1c2e7a86-184b-4d2a-8793-e2b457910a06-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18'),(76,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/b685dbdb-2ae7-4f73-95d2-ded27800a799.jpg','/upfile/img/thumb/b685dbdb-2ae7-4f73-95d2-ded27800a799-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18'),(77,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/cf609878-0eb9-42a7-a818-8c86bbcf33f8.jpg','/upfile/img/thumb/cf609878-0eb9-42a7-a818-8c86bbcf33f8-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18'),(78,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/3052a131-365c-475d-befe-21c959f75341.jpg','/upfile/img/thumb/3052a131-365c-475d-befe-21c959f75341-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18'),(79,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/9984e1db-b589-46ec-8557-ca3ae0b56084.jpg','/upfile/img/thumb/9984e1db-b589-46ec-8557-ca3ae0b56084-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18'),(80,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/00e0c4b1-6b02-4571-a999-8799db119440.jpg','/upfile/img/thumb/00e0c4b1-6b02-4571-a999-8799db119440-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18'),(81,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/bd3c1f5e-4b65-4002-96e8-dae3d061e213.jpg','/upfile/img/thumb/bd3c1f5e-4b65-4002-96e8-dae3d061e213-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18'),(82,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/b736a90a-c9d0-4109-9c5b-e390d58a8607.jpg','/upfile/img/thumb/b736a90a-c9d0-4109-9c5b-e390d58a8607-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18'),(83,'1','11',1,'1.0',1,1,'2019-11-10 00:00:00',12,11,50,'/upfile/img/294b8bd6-e7df-46c0-b167-6d0696c4e7ff.jpg','/upfile/img/thumb/294b8bd6-e7df-46c0-b167-6d0696c4e7ff-thumbnail.jpg','2019-12-15 01:39:18','2019-12-15 01:39:18');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'卫星图','卫星图',1,'2019-09-11 00:00:00','2019-11-23 14:11:51'),(2,'2D图','2D图',1,'2019-09-01 00:00:00','2019-09-11 00:00:00'),(15,'卫星','卫星',50,'2019-12-14 23:26:41','2019-12-14 23:26:41'),(16,'3D','3D',50,'2019-12-14 23:26:41','2019-12-14 23:26:41');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码MD5',
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `status` int(11) DEFAULT NULL,
  `creator_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (48,'10185101252','05d83402183b8e8e3e272e00182728cd','2739967118@qq.com','35000001295307',1,1,'2019-11-23 00:15:20','2019-11-23 00:15:20'),(49,'2739967118@qq.com','05d83402183b8e8e3e272e00182728cd','2739967118@qq.com','aaa',0,1,'2019-11-23 00:15:33','2019-11-23 00:15:33'),(50,'admin','05d83402183b8e8e3e272e00182728cd','2739967118@qq.com','Jeff',1,1,'2019-11-23 14:15:41','2019-11-23 14:15:41'),(54,'1111','caeb93e4b662a6f1653e3d458e30defc','2739967118@qq.com','111',0,1,'2019-11-23 17:35:21','2019-11-23 17:35:21'),(57,'18876389925','caeb93e4b662a6f1653e3d458e30defc','2739967118@qq.com','asdf',0,1,'2019-11-23 17:37:41','2019-11-23 17:37:41'),(58,'10185101253','f327c2175b9aa305049a63f100fcceee','2739967118@qq.com','123',0,50,'2019-12-14 23:42:01','2019-12-14 23:42:01'),(59,'10185101258','f327c2175b9aa305049a63f100fcceee','2739967118@qq.com','123',0,50,'2019-12-14 23:42:01','2019-12-14 23:42:01');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-15  2:26:36
