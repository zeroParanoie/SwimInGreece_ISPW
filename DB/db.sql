CREATE DATABASE  IF NOT EXISTS `SwimInGreeceDB` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `SwimInGreeceDB`;
-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: localhost    Database: SwimInGreeceDB
-- ------------------------------------------------------
-- Server version	8.0.35-0ubuntu0.23.04.1

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
-- Table structure for table `Bookings`
--

DROP TABLE IF EXISTS `Bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Bookings` (
  `Swimmer` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Org` varchar(45) NOT NULL,
  `Date` varchar(45) NOT NULL,
  PRIMARY KEY (`Swimmer`,`Name`,`Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bookings`
--

LOCK TABLES `Bookings` WRITE;
/*!40000 ALTER TABLE `Bookings` DISABLE KEYS */;
INSERT INTO `Bookings` VALUES ('Sw1','Tour in Crete','Org1','23/05/2024'),('Sw1','Tour in Naxos','Org1','06/06/2024'),('Sw1','Tour in Naxos','Org1','31/05/2024'),('Sw2','Tour in Crete','Org1','08/06/2024');
/*!40000 ALTER TABLE `Bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Organisers`
--

DROP TABLE IF EXISTS `Organisers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Organisers` (
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Fullname` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Organisers`
--

LOCK TABLES `Organisers` WRITE;
/*!40000 ALTER TABLE `Organisers` DISABLE KEYS */;
INSERT INTO `Organisers` VALUES ('Org1','1','Mario Rossi'),('Org2','1','Giuseppe Verdi'),('Org3','1','Luca Bianchi');
/*!40000 ALTER TABLE `Organisers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PastBookings`
--

DROP TABLE IF EXISTS `PastBookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PastBookings` (
  `Swimmer` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Org` varchar(45) NOT NULL,
  PRIMARY KEY (`Swimmer`,`Name`,`Org`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PastBookings`
--

LOCK TABLES `PastBookings` WRITE;
/*!40000 ALTER TABLE `PastBookings` DISABLE KEYS */;
/*!40000 ALTER TABLE `PastBookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reviews`
--

DROP TABLE IF EXISTS `Reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Reviews` (
  `IdReview` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Body` varchar(100) DEFAULT NULL,
  `Rating` int NOT NULL,
  `Tour` varchar(45) NOT NULL,
  PRIMARY KEY (`IdReview`,`Username`,`Tour`),
  KEY `Fk_bookings_swimmer_idx` (`Username`),
  CONSTRAINT `Fk_bookings_swimmer` FOREIGN KEY (`Username`) REFERENCES `Swimmers` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reviews`
--

LOCK TABLES `Reviews` WRITE;
/*!40000 ALTER TABLE `Reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Swimmers`
--

DROP TABLE IF EXISTS `Swimmers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Swimmers` (
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Fullname` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Swimmers`
--

LOCK TABLES `Swimmers` WRITE;
/*!40000 ALTER TABLE `Swimmers` DISABLE KEYS */;
INSERT INTO `Swimmers` VALUES ('Sw1','1','Andrea Tsilo'),('Sw2','1','Sara Luciani');
/*!40000 ALTER TABLE `Swimmers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Swims`
--

DROP TABLE IF EXISTS `Swims`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Swims` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Place` varchar(45) NOT NULL,
  `Tour` varchar(45) NOT NULL,
  `Organiser` varchar(45) NOT NULL,
  `Length` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_swims_tour_idx` (`Tour`),
  KEY `Fk_swims_org_idx` (`Organiser`),
  CONSTRAINT `Fk_swims_org` FOREIGN KEY (`Organiser`) REFERENCES `Organisers` (`Username`),
  CONSTRAINT `Fk_swims_tour` FOREIGN KEY (`Tour`) REFERENCES `Tours` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Swims`
--

LOCK TABLES `Swims` WRITE;
/*!40000 ALTER TABLE `Swims` DISABLE KEYS */;
INSERT INTO `Swims` VALUES (1,'Naxos','Tour in Naxos','Org1',7),(2,'Naxos','Tour in Naxos','Org1',4),(3,'Naxos','Tour in Naxos','Org1',5);
/*!40000 ALTER TABLE `Swims` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tours`
--

DROP TABLE IF EXISTS `Tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tours` (
  `Name` varchar(45) NOT NULL,
  `Organiser` varchar(45) NOT NULL,
  `TotalLength` float NOT NULL,
  `Place` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Name`,`Organiser`),
  KEY `Fk_Tours_org_idx` (`Organiser`),
  CONSTRAINT `Fk_Tours_org` FOREIGN KEY (`Organiser`) REFERENCES `Organisers` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tours`
--

LOCK TABLES `Tours` WRITE;
/*!40000 ALTER TABLE `Tours` DISABLE KEYS */;
INSERT INTO `Tours` VALUES ('Tour in Crete','Org1',10,'Crete'),('Tour in Naxos','Org1',16,'Naxos');
/*!40000 ALTER TABLE `Tours` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-02 21:54:23
