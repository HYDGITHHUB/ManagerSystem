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
INSERT INTO `research_money` VALUES (63,'韩勇','已审核','2020-05-20 06:39:01','无线未来','应用性','省级','无限未来','无限未来',NULL,NULL);
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
INSERT INTO `research_moneyed` VALUES (57,'韩勇','已审核','2020-05-18 02:26:28','无线技术的未来','应用性','省级','未来可期','未来可期',10000,15000),(58,'h韩勇','已审核','2020-05-18 05:43:54','水化油','经验研究性','国家级','未来可期','未来可期',10000,NULL),(59,'韩勇','已审核','2020-05-18 05:44:28','5G时代','应用性','国家级','未来可期','未来可期',12000,15000),(60,'韩勇','已审核','2020-05-18 06:20:49','能量守恒','应用性','国家级','未来可期','未来可期',200000,200),(61,'张三','已审核','2020-05-18 16:56:32','虚拟数据张三','应用性','国家级','虚拟数据','虚拟数据',200000,250000),(62,'韩勇','已审核','2020-05-20 06:34:59','激光武器','经验研究性','国家级','未来可期','未来可期',100000,12000);
/*!40000 ALTER TABLE `research_moneyed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_moneying`
--

DROP TABLE IF EXISTS `research_moneying`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_moneying` (
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
-- Dumping data for table `research_moneying`
--

LOCK TABLES `research_moneying` WRITE;
/*!40000 ALTER TABLE `research_moneying` DISABLE KEYS */;
/*!40000 ALTER TABLE `research_moneying` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_project`
--

LOCK TABLES `research_project` WRITE;
/*!40000 ALTER TABLE `research_project` DISABLE KEYS */;
INSERT INTO `research_project` VALUES (64,'韩勇','未审核','2020-05-20 06:40:06','虚假数据1','应用性','国家级','虚假数据1','虚假数据1',NULL);
/*!40000 ALTER TABLE `research_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_projected`
--

DROP TABLE IF EXISTS `research_projected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_projected` (
  `project_id` bigint(20) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_projected`
--

LOCK TABLES `research_projected` WRITE;
/*!40000 ALTER TABLE `research_projected` DISABLE KEYS */;
INSERT INTO `research_projected` VALUES (57,'韩勇','已审核','2020-05-18 02:26:28','无线技术的未来','应用性','省级','未来可期','未来可期',10000),(58,'h韩勇','已审核','2020-05-18 05:43:54','水化油','经验研究性','国家级','未来可期','未来可期',10000),(59,'韩勇','已审核','2020-05-18 05:44:28','5G时代','应用性','国家级','未来可期','未来可期',12000),(60,'韩勇','已审核','2020-05-18 06:20:49','能量守恒','应用性','国家级','未来可期','未来可期',200000),(61,'张三','已审核','2020-05-18 16:56:32','虚拟数据张三','应用性','国家级','虚拟数据','虚拟数据',200000),(62,'韩勇','已审核','2020-05-20 06:34:59','激光武器','经验研究性','国家级','未来可期','未来可期',100000),(63,'韩勇','已审核','2020-05-20 06:39:01','无线未来','应用性','省级','无限未来','无限未来',NULL);
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
  `project_time` date DEFAULT NULL,
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
INSERT INTO `research_result` VALUES (60,'韩勇','已审核','2020-05-18','未结题','能量守恒','应用性','国家级','未来可期','未来可期',200000,200,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,'韩勇','已审核','2020-05-20','未结题','激光武器','经验研究性','国家级','未来可期','未来可期',100000,12000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
  `project_time` date DEFAULT NULL,
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
INSERT INTO `research_resulted` VALUES (57,'韩勇','已审核','2020-05-18','2020-05-18 02:28:33','未结题','无线技术的未来','应用性','省级','未来可期','未来可期',10000,15000,'学术专著','基础论著','未来确实很可期',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,'韩勇','已审核','2020-05-18','2020-05-20 06:49:47','未结题','5G时代','应用性','国家级','未来可期','未来可期',12000,15000,NULL,'基础论著','未来可期',NULL,NULL,NULL,NULL,NULL,NULL,'100','很好'),(62,'虚假信息李四','已审核','2020-05-19','2020-05-19 16:41:38','未结题','虚假信息李四','应用性','国家级','虚假信息李四','虚假信息李四',20000,12000,'学术专著','基础论著','未来可期',NULL,NULL,NULL,NULL,NULL,NULL,'99','很好');
/*!40000 ALTER TABLE `research_resulted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_resulting`
--

DROP TABLE IF EXISTS `research_resulting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_resulting` (
  `project_id` bigint(20) NOT NULL,
  `project_owner` varchar(20) COLLATE utf8_bin NOT NULL,
  `project_state` varchar(10) COLLATE utf8_bin NOT NULL,
  `project_time` date DEFAULT NULL,
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
-- Dumping data for table `research_resulting`
--

LOCK TABLES `research_resulting` WRITE;
/*!40000 ALTER TABLE `research_resulting` DISABLE KEYS */;
INSERT INTO `research_resulting` VALUES (61,'张三','已审核','2020-05-19','未结题','虚拟数据张三','应用性','国家级','虚拟数据','虚拟数据',200000,250000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `research_resulting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(20) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,'韩勇','111111',1),(11,'刘海锋','111111',1),(12,'李昊源','111111',3),(13,'郑园','111111',2);
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

-- Dump completed on 2020-05-20 15:43:57
