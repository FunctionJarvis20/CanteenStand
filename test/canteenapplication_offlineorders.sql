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
-- Table structure for table `offlineorders`
--

DROP TABLE IF EXISTS `offlineorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offlineorders` (
  `staff_id` varchar(45) DEFAULT NULL,
  `transaction_id` int(11) NOT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `customer_phone` double DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `order_time` time DEFAULT NULL,
  `combo_pack` varchar(50) DEFAULT NULL,
  `food_category` varchar(45) DEFAULT NULL,
  `food_name` varchar(45) DEFAULT NULL,
  `food_quantity` int(11) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offlineorders`
--

LOCK TABLES `offlineorders` WRITE;
/*!40000 ALTER TABLE `offlineorders` DISABLE KEYS */;
INSERT INTO `offlineorders` VALUES ('43',14820,'fgdfgd',3434342424,'2018-03-08','20:14:22','combo1',NULL,NULL,433,4545),('43',31022,'dgsdg',676767676,'2018-03-08','20:13:26','combo1',NULL,NULL,434,43434),('43',37391,'fdsfrr',456345434,'2018-03-08','16:00:00',NULL,NULL,NULL,4334,345),('43',45954,'ewedqw',23213,'2018-03-08','15:55:15',NULL,NULL,NULL,2312,3434),('43',66837,'dfdsf',970243681,'2018-03-08','15:53:53',NULL,NULL,NULL,434,3434),('455',74468,'fgdfg',54535,'2018-03-08','15:56:24',NULL,NULL,NULL,43423,43423),('43',83908,'dfd',4343434343,'2018-03-08','16:06:38',NULL,NULL,NULL,34,3434);
/*!40000 ALTER TABLE `offlineorders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-09  7:17:50
