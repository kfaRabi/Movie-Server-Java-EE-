-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: movie_server
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

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
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `categoryName` varchar(255) NOT NULL,
  PRIMARY KEY (`categoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES ('Adventure'),('Animation'),('Biography'),('Comedy'),('Crime'),('Documentary'),('Drama'),('Fantasy'),('History'),('Horror'),('Musical'),('Mystery'),('Romance'),('Sci-Fi'),('Sport'),('Thriller'),('War'),('Western');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Movie`
--

DROP TABLE IF EXISTS `Movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Movie` (
  `movieName` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `movieExt` varchar(255) DEFAULT NULL,
  `posterExt` varchar(255) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `releasedYear` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`movieName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie`
--

LOCK TABLES `Movie` WRITE;
/*!40000 ALTER TABLE `Movie` DISABLE KEYS */;
INSERT INTO `Movie` VALUES ('abc','qwetyui','.mp4','.png',0,'1235'),('c','cccc','.mp4','.png',4.6,'456'),('Join The Army','Just For Lughs Short Prank Video','.mp4','.png',9.1,'2014'),('one','one two three','.mp4','.png',8,'2001'),('people are awesome','clip of awesome people','.mp4','.png',10,'2015'),('sa','sdgsb','.mp4','.png',6,'1244'),('test','loriam ispum is simple dummy text','.mp4','.png',5.5,'2005');
/*!40000 ALTER TABLE `Movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Movie_Category`
--

DROP TABLE IF EXISTS `Movie_Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Movie_Category` (
  `movies_movieName` varchar(255) NOT NULL,
  `categories_categoryName` varchar(255) NOT NULL,
  KEY `FK_cy07e8aifup6ea4r7mtxgg2fj` (`categories_categoryName`),
  KEY `FK_18bf1hpw57a5j696im5608vsa` (`movies_movieName`),
  CONSTRAINT `FK_18bf1hpw57a5j696im5608vsa` FOREIGN KEY (`movies_movieName`) REFERENCES `Movie` (`movieName`),
  CONSTRAINT `FK_cy07e8aifup6ea4r7mtxgg2fj` FOREIGN KEY (`categories_categoryName`) REFERENCES `Category` (`categoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie_Category`
--

LOCK TABLES `Movie_Category` WRITE;
/*!40000 ALTER TABLE `Movie_Category` DISABLE KEYS */;
INSERT INTO `Movie_Category` VALUES ('Join The Army','Romance'),('Join The Army','Romance'),('sa','Drama'),('sa','Drama'),('sa','Drama'),('sa','Drama'),('sa','Drama'),('sa','Drama'),('sa','Drama'),('test','Documentary'),('test','Documentary'),('test','Documentary'),('test','Documentary'),('test','Documentary'),('test','Documentary'),('one','Biography'),('one','Biography'),('one','Biography'),('abc','Biography'),('abc','Biography'),('abc','Biography'),('c','Adventure'),('c','Animation'),('c','Crime'),('c','Drama'),('people are awesome','Adventure'),('people are awesome','Animation'),('people are awesome','Biography'),('people are awesome','Comedy'),('people are awesome','Crime'),('people are awesome','Documentary'),('people are awesome','Drama'),('people are awesome','Fantasy'),('people are awesome','Horror'),('people are awesome','History'),('people are awesome','Musical'),('people are awesome','Mystery'),('people are awesome','Romance'),('people are awesome','Sci-Fi'),('people are awesome','Sport'),('people are awesome','Thriller'),('people are awesome','War'),('people are awesome','Western');
/*!40000 ALTER TABLE `Movie_Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('admin','admin','admin'),('rabi','pass','user');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-08 12:08:12
