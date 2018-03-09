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
-- Table structure for table `adminfooddetails`
--

DROP TABLE IF EXISTS `adminfooddetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminfooddetails` (
  `food_item_no` int(10) NOT NULL,
  `food_item_category` varchar(40) DEFAULT NULL,
  `food_item_name` varchar(40) DEFAULT NULL,
  `food_item_amount` int(10) DEFAULT NULL,
  `required_product_id` varchar(10) DEFAULT NULL,
  `required_product_quantity` varchar(45) DEFAULT NULL,
  `required_product_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`food_item_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminfooddetails`
--

LOCK TABLES `adminfooddetails` WRITE;
/*!40000 ALTER TABLE `adminfooddetails` DISABLE KEYS */;
INSERT INTO `adminfooddetails` VALUES (2,'fgdfg','gdfsg',234,'s4','sf3',NULL),(3,'fdhdf','fvg',34,'er42','w44',NULL),(5,'dhhf','dfhdfhdf',244,'gsdfg','s43',NULL),(6,'ytdy','tyty',336,'ydry','e5',NULL),(7,'rrasfr','czfdsf',243,'fsf','fsdf',NULL),(9,'maincourse','biryani',150,'3t4','rice,onion',NULL),(10,'maincourse','paneer subji masala',330,'rer4','50',NULL),(11,'starter','paneer chilly',120,'e45f','60',NULL),(12,'starter','stir fried chilly chicken ',300,'f45g','70',NULL),(13,'starter','microwave paneer tikkas',340,'b56g','80',NULL),(14,'starter','cheese balls',220,'g 3b','90',NULL),(444,'tsdtgsdtgg','fgg',4343,'123','15','erew'),(4664,'fdsfdf','fdsfdsf',545,'1234','654','wewr'),(7068,'dsadf','dfdd',34324,'12436727','1343','fhjkhrkjhfkjewhfkewhkh'),(7567,'dsfdgfre','dfdsgfgre',564,'dfdrfg','dfgr',NULL),(8088,'ewqrewe','erwrer',423423,'123','1545','erew');
/*!40000 ALTER TABLE `adminfooddetails` ENABLE KEYS */;
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
