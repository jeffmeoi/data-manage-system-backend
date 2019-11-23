-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: data_manage_system
-- ------------------------------------------------------
-- Server version	8.0.17

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
  `country` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '国别',
  `position` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '具体位置',
  `type_id` int(11) DEFAULT NULL COMMENT '类别',
  `ppi` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '分辨率',
  `location_x` double DEFAULT NULL COMMENT '经度',
  `location_y` double DEFAULT NULL COMMENT '维度',
  `gather_time` datetime DEFAULT NULL COMMENT '采集时间',
  `gather_duration` int(11) DEFAULT NULL COMMENT '采集时长',
  `scale` double DEFAULT NULL COMMENT '比例尺',
  `user_id` int(11) DEFAULT NULL COMMENT '创建用户id',
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `thumb_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (30,'11','111',1,'111.0',11,11,'2019-11-04 13:29:16',11,1,NULL,'/upfile/img/dfbd013c-10a3-4ce7-9f75-79160951033f.jpg','/upfile/img/thumb/dfbd013c-10a3-4ce7-9f75-79160951033f-thumbnail.jpg','2019-11-23 13:29:20','2019-11-23 14:12:38'),(31,'11','11',1,'1.0',1,1,'2019-11-13 13:32:21',11,11,45,'/upfile/img/43308178-af5d-4c90-b96d-8e5fb0cff497.jpg','/upfile/img/thumb/43308178-af5d-4c90-b96d-8e5fb0cff497-thumbnail.jpg','2019-11-23 13:32:25','2019-11-23 13:32:25'),(32,'11','11',1,'11.0',11,11,'2019-10-29 13:39:39',1000,1.01,45,'/upfile/img/a93ca067-d067-4bf1-8a2d-2bfb1d54cfa7.jpg','/upfile/img/thumb/a93ca067-d067-4bf1-8a2d-2bfb1d54cfa7-thumbnail.jpg','2019-11-23 13:39:43','2019-11-23 14:12:23'),(33,'11','11',1,'11.0',11,11,'2019-10-29 13:39:39',1,1,45,'/upfile/img/a93ca067-d067-4bf1-8a2d-2bfb1d54cfa7.jpg','/upfile/img/thumb/a93ca067-d067-4bf1-8a2d-2bfb1d54cfa7-thumbnail.jpg','2019-11-23 13:39:43','2019-11-23 13:39:43'),(36,'1111','111',1,'11.0',11,11,'2019-11-18 03:13:37',11,11,NULL,'/upfile/img/2160e186-13b0-41c2-a5db-ae7c5c36f9cf.jpg','/upfile/img/thumb/2160e186-13b0-41c2-a5db-ae7c5c36f9cf-thumbnail.jpg','2019-11-23 13:58:28','2019-11-23 13:58:28'),(38,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(39,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(40,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(41,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(42,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(43,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(44,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(45,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(46,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(47,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(48,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(49,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(50,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(51,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(52,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(53,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(54,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(55,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(56,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(57,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(58,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(59,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(60,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(61,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(62,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07'),(63,'21212','12212',2,'11.0',11,90,'2019-10-28 15:33:04',11,11,NULL,'/upfile/img/925ce62b-8194-4557-bcd8-37233917d503.jpg','/upfile/img/thumb/925ce62b-8194-4557-bcd8-37233917d503-thumbnail.jpg','2019-11-23 15:33:07','2019-11-23 15:33:07');
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
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'卫星图','卫星图',1,'2019-09-11 00:00:00','2019-11-23 14:11:51'),(2,'2D图','2D图',1,'2019-09-01 00:00:00','2019-09-11 00:00:00'),(12,'aaadsfdsfsdf','111',NULL,'2019-11-22 23:20:01','2019-11-22 23:43:58');
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
  `username` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '密码MD5',
  `email` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `status` int(11) DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (48,'10185101252','05d83402183b8e8e3e272e00182728cd','2739967118@qq.com','35000001295307',1,NULL,'2019-11-23 00:15:20','2019-11-23 00:15:20'),(49,'2739967118@qq.com','05d83402183b8e8e3e272e00182728cd','2739967118@qq.com','aaa',0,NULL,'2019-11-23 00:15:33','2019-11-23 00:15:33'),(50,'admin','05d83402183b8e8e3e272e00182728cd','2739967118@qq.com','Jeff',1,NULL,'2019-11-23 14:15:41','2019-11-23 14:15:41'),(54,'1111','caeb93e4b662a6f1653e3d458e30defc','2739967118@qq.com','111',0,NULL,'2019-11-23 17:35:21','2019-11-23 17:35:21'),(57,'18876389925','caeb93e4b662a6f1653e3d458e30defc','2739967118@qq.com','asdf',0,NULL,'2019-11-23 17:37:41','2019-11-23 17:37:41');
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

-- Dump completed on 2019-11-23 17:59:31
