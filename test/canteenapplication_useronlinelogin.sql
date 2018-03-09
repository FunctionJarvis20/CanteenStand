-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: canteenapplication
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `useronlinelogin`
--

DROP TABLE IF EXISTS `useronlinelogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useronlinelogin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pin_code` varchar(15) NOT NULL,
  `registered_date` date NOT NULL,
  PRIMARY KEY (`phone_number`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useronlinelogin`
--

LOCK TABLES `useronlinelogin` WRITE;
/*!40000 ALTER TABLE `useronlinelogin` DISABLE KEYS */;
INSERT INTO `useronlinelogin` VALUES ('h','h','ghdghdg','ghjfghdf','46364','dghdghd','234325','2018-02-21'),('etwertewr','rygeryrey','afadsfd','dfsdfsdf','635643rtertr','fsdfdsfg','5235235dfgrgr','2018-02-11'),('snehal24@','snehalkharde','snehal','gaikwad nager p.y thorat marge chembur ,mumbai 89','9619656151','snehalkharde24@gmail.com','400089','2018-02-11'),('shivam@123','1234','shivam kharde','gaikwad nager','9702436813','shiuvam121820@gmail.com','400089','2018-02-18'),('hello','hello','ketki kharde','wndjdknwbldnlasn','9702437817','ket@gmail.com','40089','2018-02-19');
/*!40000 ALTER TABLE `useronlinelogin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-09  7:17:51
