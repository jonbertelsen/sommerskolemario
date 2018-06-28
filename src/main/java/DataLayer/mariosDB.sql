CREATE DATABASE  IF NOT EXISTS `mario` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_danish_ci */;
USE `mario`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: mario
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `kunde`
--

DROP TABLE IF EXISTS `kunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kunde` (
  `kunde_id` int(11) NOT NULL AUTO_INCREMENT,
  `tlf` varchar(12) COLLATE utf8_danish_ci NOT NULL,
  `navn` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `adresse` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `postnr` int(11) DEFAULT NULL,
  PRIMARY KEY (`kunde_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kunde`
--

LOCK TABLES `kunde` WRITE;
/*!40000 ALTER TABLE `kunde` DISABLE KEYS */;
INSERT INTO `kunde` VALUES (1,'22755844','Jon','Nordre Frihavnsgade ',2100),(2,'31233232','Jønke','Titangade 10',2200),(3,'56656565','Fehår','Titangade 10',2200),(4,'31211221','Totenschläger','Amagerbro 23',2300);
/*!40000 ALTER TABLE `kunde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordre`
--

DROP TABLE IF EXISTS `ordre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordre` (
  `ordre_id` int(11) NOT NULL AUTO_INCREMENT,
  `afhentningstid` int(11) NOT NULL DEFAULT '0',
  `samletpris` int(11) NOT NULL DEFAULT '0',
  `kunde_id` int(11) NOT NULL,
  PRIMARY KEY (`ordre_id`),
  KEY `fk_kunde_id_idx` (`kunde_id`),
  CONSTRAINT `fk_kunde_id` FOREIGN KEY (`kunde_id`) REFERENCES `kunde` (`kunde_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordre`
--

LOCK TABLES `ordre` WRITE;
/*!40000 ALTER TABLE `ordre` DISABLE KEYS */;
INSERT INTO `ordre` VALUES (1,1170,0,2),(2,1140,0,3),(3,1200,0,1);
/*!40000 ALTER TABLE `ordre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordrelinie`
--

DROP TABLE IF EXISTS `ordrelinie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordrelinie` (
  `ordre_id` int(11) NOT NULL,
  `pizza_id` int(11) NOT NULL,
  `antal` int(11) NOT NULL DEFAULT '1',
  `pris` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ordre_id`,`pizza_id`),
  KEY `fk_pizza_idx` (`pizza_id`),
  CONSTRAINT `fk_ordre_id` FOREIGN KEY (`ordre_id`) REFERENCES `ordre` (`ordre_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pizza_id` FOREIGN KEY (`pizza_id`) REFERENCES `pizza` (`pizza_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordrelinie`
--

LOCK TABLES `ordrelinie` WRITE;
/*!40000 ALTER TABLE `ordrelinie` DISABLE KEYS */;
INSERT INTO `ordrelinie` VALUES (1,1,2,0),(1,2,3,0),(2,3,1,0),(3,4,3,0);
/*!40000 ALTER TABLE `ordrelinie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `ordreliste`
--

DROP TABLE IF EXISTS `ordreliste`;
/*!50001 DROP VIEW IF EXISTS `ordreliste`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `ordreliste` AS SELECT 
 1 AS `kunde_id`,
 1 AS `kundenavn`,
 1 AS `ordre_id`,
 1 AS `afhentningstid`,
 1 AS `pizza_id`,
 1 AS `antal`,
 1 AS `pizzanavn`,
 1 AS `pris`,
 1 AS `ialt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza` (
  `pizza_id` int(11) NOT NULL,
  `navn` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `beskrivelse` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `pris` int(11) NOT NULL,
  PRIMARY KEY (`pizza_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza`
--

LOCK TABLES `pizza` WRITE;
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
INSERT INTO `pizza` VALUES (1,'Vesuvio','Tomat, ost, skinke',57),(2,'Amerikaner','Tomat, ost',53),(3,'Cacciotora','Tomat, pepperoni, ost',57),(4,'Cabona','Tomat, champignons, ruccola',63);
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `ordreliste`
--

/*!50001 DROP VIEW IF EXISTS `ordreliste`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ordreliste` AS select `k`.`kunde_id` AS `kunde_id`,`k`.`navn` AS `kundenavn`,`o`.`ordre_id` AS `ordre_id`,`o`.`afhentningstid` AS `afhentningstid`,`ol`.`pizza_id` AS `pizza_id`,`ol`.`antal` AS `antal`,`p`.`navn` AS `pizzanavn`,`p`.`pris` AS `pris`,(`ol`.`antal` * `p`.`pris`) AS `ialt` from (((`kunde` `k` join `ordre` `o` on((`k`.`kunde_id` = `o`.`kunde_id`))) join `ordrelinie` `ol` on((`ol`.`ordre_id` = `o`.`ordre_id`))) join `pizza` `p` on((`p`.`pizza_id` = `ol`.`pizza_id`))) order by `o`.`afhentningstid` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-28 11:17:56
