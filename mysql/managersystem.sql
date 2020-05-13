-- MySQL dump 10.13  Distrib 5.6.26, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: managersystem
-- ------------------------------------------------------
-- Server version	5.6.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `research_money`
--

DROP TABLE IF EXISTS `research_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_money` (
  `project_id` bigint(20) NOT NULL,
  `project_owner` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_state` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_theme` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_grade` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_prospect` varchar(100) COLLATE utf8_bin NOT NULL,
  `project_describe` varchar(200) COLLATE utf8_bin NOT NULL,
  `project_money` bigint(20) DEFAULT NULL,
  `project_moneyed` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_money`
--

LOCK TABLES `research_money` WRITE;
/*!40000 ALTER TABLE `research_money` DISABLE KEYS */;
INSERT INTO `research_money` VALUES (11,'韩勇','已审核','2020-04-30 07:24:32','能量守恒','应用性','国家级','能量守恒','能量守恒',10000,NULL),(16,'韩勇','已审核','2020-05-05 10:13:39','与外天空文明的交流','经验研究性','校级','与他人沟通，了解他人的故事','沟通是解决问题的最好方式',20000,NULL);
/*!40000 ALTER TABLE `research_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_moneyed`
--

DROP TABLE IF EXISTS `research_moneyed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_moneyed` (
  `project_id` bigint(20) NOT NULL,
  `project_owner` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_state` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_theme` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_grade` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_prospect` varchar(100) COLLATE utf8_bin NOT NULL,
  `project_describe` varchar(200) COLLATE utf8_bin NOT NULL,
  `project_money` bigint(20) DEFAULT NULL,
  `project_moneyed` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_moneyed`
--

LOCK TABLES `research_moneyed` WRITE;
/*!40000 ALTER TABLE `research_moneyed` DISABLE KEYS */;
INSERT INTO `research_moneyed` VALUES (11,'韩勇','已审核','2020-04-30 07:24:32','能量守恒','应用性','国家级','能量守恒','能量守恒',10000,1200),(14,'韩勇','已审核','2020-04-30 07:46:24','无人汽车','应用性','省级','实现无人汽车驾驶','可以帮助人们休闲出行',10000,22000),(16,'韩勇','已审核','2020-05-05 10:13:39','与外天空文明的交流','经验研究性','校级','与他人沟通，了解他人的故事','沟通是解决问题的最好方式',10000,12000);
/*!40000 ALTER TABLE `research_moneyed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_project`
--

DROP TABLE IF EXISTS `research_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_owner` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_state` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '未审核',
  `project_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `project_theme` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_grade` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_prospect` varchar(100) COLLATE utf8_bin NOT NULL,
  `project_describe` varchar(200) COLLATE utf8_bin NOT NULL,
  `project_money` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_project`
--

LOCK TABLES `research_project` WRITE;
/*!40000 ALTER TABLE `research_project` DISABLE KEYS */;
INSERT INTO `research_project` VALUES (20,'韩勇','未审核','2020-05-07 06:23:47','外天空对话','应用性','国家级','友好沟通','友好沟通是进步的桥梁',NULL);
/*!40000 ALTER TABLE `research_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_projected`
--

DROP TABLE IF EXISTS `research_projected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_projected` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_owner` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_state` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '已审核',
  `project_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `project_theme` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_grade` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_prospect` varchar(100) COLLATE utf8_bin NOT NULL,
  `project_describe` varchar(200) COLLATE utf8_bin NOT NULL,
  `project_money` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_projected`
--

LOCK TABLES `research_projected` WRITE;
/*!40000 ALTER TABLE `research_projected` DISABLE KEYS */;
INSERT INTO `research_projected` VALUES (11,'韩勇','已审核','2020-04-30 07:24:32','能量守恒','应用性','国家级','能量守恒','能量守恒',10000),(14,'韩勇','已审核','2020-04-30 07:46:24','无人汽车','应用性','省级','实现无人汽车驾驶','可以帮助人们休闲出行',NULL),(16,'韩勇','已审核','2020-05-05 10:13:39','与外天空文明的交流','经验研究性','校级','与他人沟通，了解他人的故事','沟通是解决问题的最好方式',NULL);
/*!40000 ALTER TABLE `research_projected` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_result`
--

DROP TABLE IF EXISTS `research_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_result` (
  `project_id` bigint(20) NOT NULL,
  `project_owner` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_state` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_time_end` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `project_result_state` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '未结题',
  `project_theme` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_grade` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_prospect` varchar(100) COLLATE utf8_bin NOT NULL,
  `project_describe` varchar(200) COLLATE utf8_bin NOT NULL,
  `project_money` bigint(20) DEFAULT NULL,
  `project_moneyed` bigint(20) DEFAULT NULL,
  `project_result_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_monograph_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_monograph_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `project_press_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_press_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `project_patent_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_patent_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `project_technology_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_technology_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_result`
--

LOCK TABLES `research_result` WRITE;
/*!40000 ALTER TABLE `research_result` DISABLE KEYS */;
INSERT INTO `research_result` VALUES (11,'韩勇','已审核','2020-04-30 07:24:32','2020-05-07 07:43:44','未结题','能量守恒','应用性','国家级','能量守恒','能量守恒',10000,1200,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `research_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_resulted`
--

DROP TABLE IF EXISTS `research_resulted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_resulted` (
  `project_id` bigint(20) NOT NULL,
  `project_owner` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_state` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_time_end` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `project_result_state` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '已结题',
  `project_theme` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_grade` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_prospect` varchar(100) COLLATE utf8_bin NOT NULL,
  `project_describe` varchar(200) COLLATE utf8_bin NOT NULL,
  `project_money` bigint(20) DEFAULT NULL,
  `project_moneyed` bigint(20) DEFAULT NULL,
  `project_result_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_monograph_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_monograph_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `project_press_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_press_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `project_patent_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_patent_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `project_technology_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_technology_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `project_result_grade` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `project_result_comment` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_resulted`
--

LOCK TABLES `research_resulted` WRITE;
/*!40000 ALTER TABLE `research_resulted` DISABLE KEYS */;
INSERT INTO `research_resulted` VALUES (14,'韩勇','已审核','2020-04-30 07:46:24','2020-05-07 06:16:09','已结题','无人汽车','应用性','省级','实现无人汽车驾驶','可以帮助人们休闲出行',10000,22000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'100','很好'),(16,'韩勇','已审核','2020-05-05 10:13:39','2020-05-07 07:43:06','已结题','与外天空文明的交流','经验研究性','校级','与他人沟通，了解他人的故事','沟通是解决问题的最好方式',10000,12000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `research_resulted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_manager_personnel`
--

DROP TABLE IF EXISTS `user_manager_personnel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_manager_personnel` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_eno` int(10) NOT NULL,
  `user_name` varchar(24) COLLATE utf8_bin DEFAULT NULL,
  `user_pwd` varchar(24) COLLATE utf8_bin DEFAULT NULL,
  `user_phone` bigint(20) DEFAULT NULL,
  `user_mail` varchar(24) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_manager_personnel`
--

LOCK TABLES `user_manager_personnel` WRITE;
/*!40000 ALTER TABLE `user_manager_personnel` DISABLE KEYS */;
INSERT INTO `user_manager_personnel` VALUES (1,2017110409,'韩勇','111111',17361041018,'2607223301@qq.com'),(2,2017110425,'刘海锋','222222',22222222222,'2222222222@qq.com'),(3,2017110433,'宋博宇','333333',33333333333,'3333333333@qq.com'),(4,2017110436,'唐梦予','444444',44444444444,'4444444444@qq.com'),(5,2017110456,'郑园','555555',55555555555,'5555555555@qq.com');
/*!40000 ALTER TABLE `user_manager_personnel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_personnel`
--

DROP TABLE IF EXISTS `user_personnel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_personnel` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_eno` int(10) DEFAULT NULL,
  `user_name` varchar(24) COLLATE utf8_bin DEFAULT NULL,
  `user_pwd` varchar(24) COLLATE utf8_bin NOT NULL,
  `user_phone` bigint(20) DEFAULT NULL,
  `user_mail` varchar(24) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_personnel`
--

LOCK TABLES `user_personnel` WRITE;
/*!40000 ALTER TABLE `user_personnel` DISABLE KEYS */;
INSERT INTO `user_personnel` VALUES (1,2017110409,'韩勇','123456',17361041018,'2607223301@qq.com'),(2,2017110425,'刘海锋','222222',22222222222,'22222222222@qq.com'),(3,2017110433,'宋博宇','333333',33333333333,'33333333333@qq.com'),(4,2017110448,'唐梦予','444444',44444444444,'44444444444@qq.com'),(5,2017110456,'郑园','555555',55555555555,'55555555555@qq.com'),(27,2017110401,'张三','111111',NULL,NULL),(30,2017110409,'王五','111111',NULL,NULL);
/*!40000 ALTER TABLE `user_personnel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_sys_manager_personnel`
--

DROP TABLE IF EXISTS `user_sys_manager_personnel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_sys_manager_personnel` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_eno` int(10) DEFAULT NULL,
  `user_name` varchar(24) COLLATE utf8_bin DEFAULT NULL,
  `user_pwd` varchar(24) COLLATE utf8_bin DEFAULT NULL,
  `user_phone` bigint(20) DEFAULT NULL,
  `user_mail` varchar(24) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_sys_manager_personnel`
--

LOCK TABLES `user_sys_manager_personnel` WRITE;
/*!40000 ALTER TABLE `user_sys_manager_personnel` DISABLE KEYS */;
INSERT INTO `user_sys_manager_personnel` VALUES (1,2017110409,'韩勇','123456',17361041018,'2607223301@qq.com');
/*!40000 ALTER TABLE `user_sys_manager_personnel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-13  9:00:21
