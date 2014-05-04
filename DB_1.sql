CREATE DATABASE  IF NOT EXISTS `eventoris_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eventoris_db`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: eventoris_db
-- ------------------------------------------------------
-- Server version	5.6.17-log

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
-- Table structure for table `event_categories`
--

DROP TABLE IF EXISTS `event_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_categories` (
  `id_event_categories` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) DEFAULT NULL,
  `category_description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_event_categories`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_categories`
--

LOCK TABLES `event_categories` WRITE;
/*!40000 ALTER TABLE `event_categories` DISABLE KEYS */;
INSERT INTO `event_categories` VALUES (1,'Sport','Activitati sportive');
/*!40000 ALTER TABLE `event_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_info`
--

DROP TABLE IF EXISTS `event_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_info` (
  `id_event_info` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `id_category` int(11) DEFAULT NULL,
  `description` text,
  `date_created` datetime DEFAULT NULL,
  `date_of_event` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `id_owner` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_event_info`),
  KEY `id_category_idx` (`id_category`),
  CONSTRAINT `id_category` FOREIGN KEY (`id_category`) REFERENCES `event_categories` (`id_event_categories`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_info`
--

LOCK TABLES `event_info` WRITE;
/*!40000 ALTER TABLE `event_info` DISABLE KEYS */;
INSERT INTO `event_info` VALUES (2,'PaintBall',1,'Teambuilding','2014-04-29 16:02:53','2014-04-29 16:02:53','Bubuieci',12);
/*!40000 ALTER TABLE `event_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant_status`
--

DROP TABLE IF EXISTS `participant_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participant_status` (
  `id_participant_status` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_participant_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant_status`
--

LOCK TABLES `participant_status` WRITE;
/*!40000 ALTER TABLE `participant_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `participant_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participants`
--

DROP TABLE IF EXISTS `participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participants` (
  `id_participants` int(11) NOT NULL AUTO_INCREMENT,
  `id_event` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_participants`),
  KEY `id_event_idx` (`id_event`),
  KEY `id_status_idx` (`id_status`),
  CONSTRAINT `id_event` FOREIGN KEY (`id_event`) REFERENCES `event_info` (`id_event_info`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_status` FOREIGN KEY (`id_status`) REFERENCES `participant_status` (`id_participant_status`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participants`
--

LOCK TABLES `participants` WRITE;
/*!40000 ALTER TABLE `participants` DISABLE KEYS */;
/*!40000 ALTER TABLE `participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_users` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password_hash` varchar(25) DEFAULT NULL,
  `password_salt` varchar(5) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `banner` tinyint(1) DEFAULT NULL,
  `reset_key` varchar(45) DEFAULT NULL,
  `reset_expires` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_users`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-04 23:08:43
