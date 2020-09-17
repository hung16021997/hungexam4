
DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gdp` double NOT NULL,
  `name` varchar(15) DEFAULT NULL,
  `population` double NOT NULL,
  `countryId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf30cqcsw5iq7u31gk7ckpj2vf` (`countryId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,23000,'The biggest city in Italy',100,'Rome',60,3),(3,3000,'What a wonderful city!',40000,'Los Angeles',11,2),(4,6600,'What a romantic city!',64.9,'Paris',12.5,5),(6,2900,'Nice',900,'Tokyo',31,6);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Vietnam'),(2,'USA'),(3,'Italy'),(4,'Thailand'),(5,'France'),(6,'Japan');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;
