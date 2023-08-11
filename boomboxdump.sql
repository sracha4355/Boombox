-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: boomboxdev
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ALBUM`
--

DROP TABLE IF EXISTS `ALBUM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ALBUM` (
  `id` int NOT NULL AUTO_INCREMENT,
  `artist_id` int NOT NULL,
  `album_index` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `artist_index` varchar(255) DEFAULT NULL,
  `artist_name` varchar(255) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `is_deleted` int DEFAULT NULL,
  `picture_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `artist_id` (`artist_id`),
  KEY `picture_id` (`picture_id`),
  CONSTRAINT `album_ibfk_1` FOREIGN KEY (`artist_id`) REFERENCES `ARTIST` (`id`),
  CONSTRAINT `album_ibfk_2` FOREIGN KEY (`picture_id`) REFERENCES `PICTURES` (`id`),
  CONSTRAINT `album_chk_1` CHECK ((`album_index` = upper(`album_index`))),
  CONSTRAINT `album_chk_2` CHECK ((`artist_index` = upper(`artist_index`)))
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALBUM`
--

LOCK TABLES `ALBUM` WRITE;
/*!40000 ALTER TABLE `ALBUM` DISABLE KEYS */;
INSERT INTO `ALBUM` VALUES (1,2,'AM','AM','ARCTIC MONKEYS','Arctic Monkeys','2013-08-01',0,0,NULL),(2,1,'RODEO','Rodeo','TRAVIS SCOTT','Travis Scott','2015-09-04',0,0,NULL),(3,3,'VIEWS','Views','DRAKE','Drake','2016-04-29',0,0,NULL),(4,4,'JINX','Jinx','CRUMB','Crumb','2019-06-14',0,0,NULL),(5,5,'DARK SIDE OF THE MOON','Dark Side of the Moon','PINK FLOYD','Pink Floyd','1973-03-01',0,0,NULL),(11,35,'TEST ALBUM','Test album','TEST ARTIST','Test Artist','2002-11-22',0,0,NULL),(12,35,'TEST ALBUM2','Test album2','TEST ARTIST','Test Artist','2002-11-22',0,0,NULL),(13,35,'TEST ALBUM3','Test album3','TEST ARTIST','Test Artist','2002-11-22',0,0,NULL);
/*!40000 ALTER TABLE `ALBUM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `is_deleted` int DEFAULT NULL,
  `picture_id` int DEFAULT NULL,
  `artist_index` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `picture_id` (`picture_id`),
  CONSTRAINT `artist_ibfk_1` FOREIGN KEY (`picture_id`) REFERENCES `PICTURES` (`id`),
  CONSTRAINT `artist_chk_1` CHECK ((`artist_index` = upper(`artist_index`)))
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (1,'Travis Scott',0,NULL,'TRAVIS SCOTT'),(2,'Arctic Monkeys',0,NULL,'ARCTIC MONKEYS'),(3,'Drake',0,NULL,'DRAKE'),(4,'Crumb',0,NULL,'CRUMB'),(5,'Pink Floyd',0,NULL,'PINK FLOYD'),(11,'Tester',0,NULL,'TESTER'),(35,'Test Artist',0,NULL,'TEST ARTIST'),(36,'Test artist 1',0,NULL,'TEST ARTIST 1');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AUTHOR`
--

DROP TABLE IF EXISTS `AUTHOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AUTHOR` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `is_deleted` int DEFAULT NULL,
  `picture_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `picture_id` (`picture_id`),
  CONSTRAINT `author_ibfk_1` FOREIGN KEY (`picture_id`) REFERENCES `PICTURES` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AUTHOR`
--

LOCK TABLES `AUTHOR` WRITE;
/*!40000 ALTER TABLE `AUTHOR` DISABLE KEYS */;
INSERT INTO `AUTHOR` VALUES (1,'test-author','ta@gmail.com','ta1',NULL,NULL);
/*!40000 ALTER TABLE `AUTHOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PICTURES`
--

DROP TABLE IF EXISTS `PICTURES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PICTURES` (
  `id` int NOT NULL AUTO_INCREMENT,
  `filepath` varchar(255) DEFAULT NULL,
  `is_deleted` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PICTURES`
--

LOCK TABLES `PICTURES` WRITE;
/*!40000 ALTER TABLE `PICTURES` DISABLE KEYS */;
/*!40000 ALTER TABLE `PICTURES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REVIEW`
--

DROP TABLE IF EXISTS `REVIEW`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REVIEW` (
  `id` int NOT NULL AUTO_INCREMENT,
  `review` text,
  `album_id` int DEFAULT NULL,
  `song_id` int DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `author_id` int DEFAULT NULL,
  `is_deleted` int DEFAULT NULL,
  `review_for_album` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `album_id` (`album_id`),
  KEY `song_id` (`song_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`album_id`) REFERENCES `ALBUM` (`id`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`song_id`) REFERENCES `SONGS` (`id`),
  CONSTRAINT `review_ibfk_3` FOREIGN KEY (`author_id`) REFERENCES `AUTHOR` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REVIEW`
--

LOCK TABLES `REVIEW` WRITE;
/*!40000 ALTER TABLE `REVIEW` DISABLE KEYS */;
/*!40000 ALTER TABLE `REVIEW` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SONGS`
--

DROP TABLE IF EXISTS `SONGS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SONGS` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `artist_id` int NOT NULL,
  `album_id` int DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `is_deleted` int DEFAULT NULL,
  `picture_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `artist_id` (`artist_id`),
  KEY `album_id` (`album_id`),
  KEY `picture_id` (`picture_id`),
  CONSTRAINT `songs_ibfk_1` FOREIGN KEY (`artist_id`) REFERENCES `ARTIST` (`id`),
  CONSTRAINT `songs_ibfk_2` FOREIGN KEY (`album_id`) REFERENCES `ALBUM` (`id`),
  CONSTRAINT `songs_ibfk_3` FOREIGN KEY (`picture_id`) REFERENCES `PICTURES` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SONGS`
--

LOCK TABLES `SONGS` WRITE;
/*!40000 ALTER TABLE `SONGS` DISABLE KEYS */;
INSERT INTO `SONGS` VALUES (1,'Oh My Dis Side',1,2,'2015-09-04',0,0,NULL),(5,'Hotline Bling',3,3,'2016-04-29',0,0,NULL),(7,'Wanna be yours',2,1,'2013-08-01',0,0,NULL);
/*!40000 ALTER TABLE `SONGS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-11 10:29:24
