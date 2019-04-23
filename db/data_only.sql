-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tseam_six_3
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Voula'),(2,'Glifada'),(3,'Pagkrati'),(4,'N. Ionia'),(5,'Kallithea'),(6,'Petralona'),(7,'Melissia'),(8,'Patisia'),(9,'Vrilissia'),(10,'N. Smyrni'),(11,'Aigalew'),(12,'Peiraias'),(13,'Ag. Dimitrios'),(14,'Dafni'),(15,'Argyroupoli'),(16,'Ilioupoli'),(17,'Moshato'),(18,'Tavros'),(19,'Kifisia'),(20,'N. Irakleio'),(21,'Patisia'),(22,'Vironas');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (10,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(11,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(12,58,60,'2019-04-03 14:21:54','Ahoy!!',0),(13,58,60,'2019-04-03 14:21:54','Ahoy!!',0),(14,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(15,58,61,'2019-04-03 14:21:54','Ahoy!!',1),(16,58,61,'2019-04-03 14:21:54','Ahoy!!',1),(17,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(18,58,60,'2019-04-03 14:21:54','Ahoy!!',0),(19,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(20,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(21,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(22,59,60,'2019-04-03 14:21:54','Ahoy Back!!',0),(23,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(24,59,61,'2019-04-03 14:21:54','Ahoy Back!!',1),(25,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(26,59,61,'2019-04-03 14:21:54','Ahoy Back!!',1),(27,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(28,59,60,'2019-04-03 14:21:54','Ahoy Back!!',0),(29,59,60,'2019-04-03 14:21:54','Ahoy Back!!',0),(30,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(31,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(32,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(33,60,59,'2019-04-03 14:24:47','Tom in da house!',1),(34,60,61,'2019-04-03 14:24:47','Tom in da house!',1),(35,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(36,60,59,'2019-04-03 14:24:47','Tom in da house!',1),(37,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(38,60,61,'2019-04-03 14:24:47','Tom in da house!',1),(39,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(40,60,59,'2019-04-03 14:24:47','Tom in da house!',1),(41,60,61,'2019-04-03 14:24:47','Tom in da house!',1),(42,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(43,61,58,'2019-04-03 14:25:42','Pete calling!',1),(44,61,58,'2019-04-03 14:25:42','Pete calling!',1),(45,61,59,'2019-04-03 14:25:42','Pete calling!',1),(46,61,60,'2019-04-03 14:25:42','Pete calling!',0),(47,61,58,'2019-04-03 14:25:42','Pete calling!',1),(48,61,60,'2019-04-03 14:25:42','Pete calling!',0),(49,61,58,'2019-04-03 14:25:42','Pete calling!',1),(50,61,59,'2019-04-03 14:25:42','Pete calling!',1),(51,61,60,'2019-04-03 14:25:42','Pete calling!',0),(52,61,58,'2019-04-03 14:25:42','Pete calling!',1),(53,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(54,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(55,58,60,'2019-04-03 14:21:54','Ahoy!!',0),(56,58,60,'2019-04-03 14:21:54','Ahoy!!',0),(57,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(58,58,61,'2019-04-03 14:21:54','Ahoy!!',1),(59,58,61,'2019-04-03 14:21:54','Ahoy!!',1),(60,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(61,58,60,'2019-04-03 14:21:54','Ahoy!!',0),(62,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(63,58,59,'2019-04-03 14:21:54','Ahoy!!',1),(64,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(65,59,60,'2019-04-03 14:21:54','Ahoy Back!!',0),(66,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(67,59,61,'2019-04-03 14:21:54','Ahoy Back!!',1),(68,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(69,59,61,'2019-04-03 14:21:54','Ahoy Back!!',1),(70,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(71,59,60,'2019-04-03 14:21:54','Ahoy Back!!',0),(72,59,60,'2019-04-03 14:21:54','Ahoy Back!!',0),(73,59,58,'2019-04-03 14:21:54','Ahoy Back!!',1),(74,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(75,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(76,60,59,'2019-04-03 14:24:47','Tom in da house!',1),(77,60,61,'2019-04-03 14:24:47','Tom in da house!',1),(78,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(79,60,59,'2019-04-03 14:24:47','Tom in da house!',1),(80,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(81,60,61,'2019-04-03 14:24:47','Tom in da house!',1),(82,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(83,60,59,'2019-04-03 14:24:47','Tom in da house!',1),(84,60,61,'2019-04-03 14:24:47','Tom in da house!',1),(85,60,58,'2019-04-03 14:24:47','Tom in da house!',1),(86,61,58,'2019-04-03 14:25:42','Pete calling!',1),(87,61,58,'2019-04-03 14:25:42','Pete calling!',1),(88,61,59,'2019-04-03 14:25:42','Pete calling!',1),(89,61,60,'2019-04-03 14:25:42','Pete calling!',0),(90,61,58,'2019-04-03 14:25:42','Pete calling!',1),(91,61,60,'2019-04-03 14:25:42','Pete calling!',0),(92,61,58,'2019-04-03 14:25:42','Pete calling!',1),(93,61,59,'2019-04-03 14:25:42','Pete calling!',1),(94,61,60,'2019-04-03 14:25:42','Pete calling!',0),(95,61,58,'2019-04-03 14:25:42','Pete calling!',1),(96,58,59,'2019-04-03 14:54:49','Ela mou!',1),(97,58,59,'2019-04-03 17:11:36','Paul??',1),(98,58,59,'2019-04-04 12:30:51','Paul???',1),(99,64,58,'2019-04-11 13:52:48','Ela pari mou!',1),(100,64,58,'2019-04-11 16:34:25','Pari me akous?\n',1),(101,64,58,'2019-04-11 18:51:08','PAri!!!??',1),(102,64,58,'2019-04-11 18:51:09','PAri!!!??',1),(103,64,58,'2019-04-11 18:51:21','Nai egw eimai!!',1),(104,64,58,'2019-04-11 18:51:29','o admin tis kardias sou!',1),(105,58,59,'2019-04-11 23:25:15','elaaaa',1),(106,58,64,'2019-04-12 19:15:26','Hello!',0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (8,15,'50 euros down the drain!','2019-04-03 14:30:08',1),(9,14,'Great boxing!!','2019-04-03 14:31:04',5),(13,19,'Xaliaaaaaaaa','2019-04-07 17:57:35',3),(14,16,'Swstos o Pete','2019-04-07 18:00:27',3),(15,21,'Dunatos o Paul, alla mporouse ka ikalutera','2019-04-07 18:00:46',4),(16,22,'Super!!!!','2019-04-07 18:59:19',5),(17,20,'Milame me eliwse o foustis!! Kalos alla dinei polu pono!!','2019-04-08 14:53:53',4),(18,40,'Etsi Ki etsi','2019-04-11 16:48:31',3);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'user'),(2,'trainer'),(3,'admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (54,'fa71f328-7433-4a91-937b-dfb637ee2b80',58,'2019-04-04 12:28:27'),(55,'c026c427-d2fc-4943-bf42-68db3ded0a4d',59,'2019-04-04 12:28:53'),(56,'8f350f94-32ac-42f3-9a46-1257e2b7ad20',58,'2019-04-04 15:55:22'),(58,'8b8d373e-ff7a-4ca0-8fd0-c8c7f0610228',59,'2019-04-04 16:46:49'),(59,'76238251-8851-4372-86d4-61b21ca28c75',58,'2019-04-04 22:28:33'),(60,'3e1d5f93-85c3-458b-8c7b-8eef8d250930',58,'2019-04-04 22:44:16'),(61,'2654b993-9dbe-4b35-8dd4-534212d59000',58,'2019-04-05 11:22:47'),(62,'df6f7bb6-028f-4dc7-8b67-86fa536608ce',58,'2019-04-05 11:28:23'),(63,'2897a80c-6828-4e31-a3ef-2461f79e0659',59,'2019-04-05 12:09:00'),(64,'d6f58c22-da03-4d93-bd68-5918fb3c4f2c',59,'2019-04-05 12:15:10'),(65,'63ce438d-0f02-4698-abac-3ad789e6ec08',59,'2019-04-05 14:15:14'),(66,'848389b3-e839-4a57-8fe6-5ce8a672bf0c',61,'2019-04-05 14:15:56'),(68,'47935f28-bb25-4f6c-8240-925edbd8de59',58,'2019-04-07 10:59:01'),(69,'437b8fa2-d411-4fbc-827d-10607e09b516',58,'2019-04-07 11:04:53'),(70,'593c5409-a825-4af2-8a48-1eac83cc658c',58,'2019-04-07 16:01:17'),(73,'3b90f71b-9aba-4379-b8e1-92cf8e390c47',58,'2019-04-08 14:52:03'),(76,'f70d83fc-363c-40cc-ba5e-61c297c9409d',59,'2019-04-08 18:05:19'),(77,'28cd7686-5efb-4a28-8409-d9169f203eb5',58,'2019-04-08 18:21:51'),(84,'34bfacf9-798f-4686-9031-46000764375c',59,'2019-04-09 16:21:36'),(85,'137ac283-21d5-4645-a200-b863bc7a6ba4',59,'2019-04-09 17:16:23'),(86,'07d1d7e0-5bb6-4b52-9d54-0ffac3682260',58,'2019-04-09 17:17:07'),(87,'b0a6ecee-d12c-40e6-bb00-bdcd20bf666a',58,'2019-04-09 18:31:06'),(88,'1d1a7d4a-4062-4089-88e5-3836e9dae42a',58,'2019-04-09 19:48:01'),(91,'6745339c-3cea-493f-9e19-9b91cbb6a737',58,'2019-04-10 14:12:42'),(94,'451641f6-38a2-422d-a339-e9ded2ded68b',58,'2019-04-10 14:38:37'),(102,'05269f2b-96a6-4578-a95b-207922548e7e',58,'2019-04-10 15:31:59'),(104,'72284bac-1fd4-48fc-b3fe-5f2f894aaaf7',61,'2019-04-10 16:18:01'),(106,'51bf9ce1-89c3-4c7f-9b3f-4dcca6ffed1f',63,'2019-04-10 16:53:11'),(107,'f3c372b4-c966-4f3c-86a5-17edf0a8ab83',59,'2019-04-10 16:55:46'),(108,'4627dcea-5665-4249-b2a5-b457956b1799',58,'2019-04-10 17:29:03'),(109,'eacdc850-49dd-4d1f-8635-e3fa7b1285fc',59,'2019-04-10 19:05:13'),(110,'7f5dc013-cd2a-4aaa-9779-6fceac327d4c',58,'2019-04-11 12:46:43'),(111,'04ccec76-396e-448e-9de5-183e41680896',59,'2019-04-11 12:48:24'),(112,'227933b6-cb18-4b34-a6b8-7a979f1c23e1',64,'2019-04-11 12:53:13'),(113,'ff88d275-eccd-41ab-a772-ce46e21ae8e9',58,'2019-04-11 13:19:26'),(114,'c1eb5161-eaea-4d34-83d4-8e1f1a3c948c',64,'2019-04-11 13:26:14'),(115,'51db19b3-eb07-4182-9bcc-149a27e32586',63,'2019-04-11 14:36:26'),(116,'595395c3-bfa2-45fc-aa94-61bef24cdb12',63,'2019-04-11 14:38:31'),(117,'0b9c09cb-7e74-46a8-aa6e-4ca9edcb1cc0',58,'2019-04-11 18:51:51'),(118,'096d68bf-d283-4766-87cd-abcbe282b412',58,'2019-04-11 18:53:04'),(119,'a6c49227-898c-4df0-9302-99838200a7a7',59,'2019-04-11 23:13:13'),(120,'c4933689-3c09-4d5a-8bb4-5a3772b9df22',58,'2019-04-11 23:17:30'),(121,'ff779809-0934-400b-bd8b-104712831234',58,'2019-04-12 11:36:37'),(122,'9815899e-af34-420f-abaa-b3292f904e23',59,'2019-04-12 11:39:07'),(124,'6cb9d601-938f-4ce6-8207-bd9ebb91ae94',58,'2019-04-12 14:37:23'),(126,'d50da9e6-b7ec-45ea-a541-e2e169ec61e6',95,'2019-04-12 18:28:24'),(127,'a6c3d6fa-9626-4077-8dc7-87c228deb311',58,'2019-04-12 18:33:29'),(128,'89b4a1a2-e80b-42a7-bafc-f1b3bee58f44',95,'2019-04-12 18:33:45'),(129,'bae20409-673c-473e-be46-f6cd48edc9b9',64,'2019-04-12 19:02:33'),(130,'4b7efc40-2753-4f1f-9a3c-b7fe08574580',58,'2019-04-12 19:10:57'),(131,'b279da21-3863-433d-a14f-08dd77dd5f84',58,'2019-04-18 20:44:03'),(132,'292a7be5-fbbf-41ff-8ba8-daf01f878d38',59,'2019-04-18 21:07:14');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trainer_area`
--

LOCK TABLES `trainer_area` WRITE;
/*!40000 ALTER TABLE `trainer_area` DISABLE KEYS */;
INSERT INTO `trainer_area` VALUES (68,1),(69,1),(70,1),(71,1),(72,1),(73,1),(74,1),(75,1),(76,1),(77,1),(78,1),(79,1),(80,1),(81,1),(82,1),(83,1),(84,1),(61,2),(62,2),(65,2),(66,2),(68,2),(69,2),(70,2),(71,2),(72,2),(73,2),(74,2),(75,2),(76,2),(77,2),(78,2),(79,2),(80,2),(81,2),(82,2),(83,2),(84,2),(95,2),(59,3),(66,3),(62,5),(65,5),(61,6),(66,6),(59,7),(61,7),(62,7),(65,7),(66,7),(67,7),(59,10),(65,10),(95,10),(59,12),(66,12);
/*!40000 ALTER TABLE `trainer_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trainer_specialization`
--

LOCK TABLES `trainer_specialization` WRITE;
/*!40000 ALTER TABLE `trainer_specialization` DISABLE KEYS */;
INSERT INTO `trainer_specialization` VALUES (59,1),(65,1),(66,1),(67,1),(68,1),(69,1),(70,1),(71,1),(72,1),(73,1),(74,1),(75,1),(76,1),(77,1),(78,1),(79,1),(80,1),(81,1),(82,1),(83,1),(84,1),(95,1),(59,2),(61,2),(62,2),(65,2),(67,2),(68,2),(69,2),(70,2),(71,2),(72,2),(73,2),(74,2),(75,2),(76,2),(77,2),(78,2),(79,2),(80,2),(81,2),(82,2),(83,2),(84,2),(59,3),(61,3),(62,3),(61,4),(95,4),(59,5),(62,5),(61,6);
/*!40000 ALTER TABLE `trainer_specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `training_session`
--

LOCK TABLES `training_session` WRITE;
/*!40000 ALTER TABLE `training_session` DISABLE KEYS */;
INSERT INTO `training_session` VALUES (14,58,59,1,1,'2019-03-10','19:00:00',1,0,0),(15,58,40,1,1,'2019-03-11','19:00:00',0,0,0),(16,58,61,2,2,'2019-03-10','19:00:00',0,0,0),(17,58,59,2,2,'2019-05-10','19:00:00',1,1,1),(19,58,59,1,4,'2019-02-14','10:00:00',1,0,0),(20,58,59,1,4,'2019-02-15','10:00:00',1,0,0),(21,58,59,1,4,'2019-02-16','10:00:00',1,0,0),(22,58,59,1,4,'2019-02-17','10:00:00',1,0,0),(23,58,59,1,4,'2019-02-18','10:00:00',1,0,0),(26,58,59,1,2,'2019-04-09','10:00:00',1,0,0),(29,58,61,7,4,'2019-04-22','13:00:00',0,1,1),(31,58,61,2,4,'2019-04-28','12:00:00',0,1,1),(36,58,61,6,2,'2019-04-24','11:00:00',0,1,1),(37,58,59,12,2,'2019-04-27','13:00:00',1,1,1),(38,58,61,6,2,'2019-04-21','20:00:00',0,1,1),(40,58,59,12,1,'2019-04-10','19:00:00',1,0,0),(41,58,59,3,1,'2019-04-14','13:00:00',1,1,1),(42,63,59,3,2,'2019-04-21','12:00:00',1,1,1),(43,58,61,2,2,'2019-04-15','15:00:00',0,1,1),(45,58,59,3,1,'2019-04-20','10:00:00',1,1,1),(48,58,61,6,2,'2019-04-13','11:00:00',0,0,0),(49,58,59,3,3,'2019-04-23','12:00:00',1,1,1),(50,58,59,3,1,'2019-04-13','20:00:00',1,0,0),(51,58,95,2,1,'2019-04-13','11:00:00',1,0,0),(52,58,61,6,2,'2019-04-14','15:00:00',0,1,1);
/*!40000 ALTER TABLE `training_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `training_type`
--

LOCK TABLES `training_type` WRITE;
/*!40000 ALTER TABLE `training_type` DISABLE KEYS */;
INSERT INTO `training_type` VALUES (1,'Boxing'),(2,'Run'),(3,'Weights'),(4,'Pilates'),(5,'Yoga'),(6,'Body-building');
/*!40000 ALTER TABLE `training_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (40,'kostas','iYtqiwn2BQ4G/tGSq4Qckw==','kostas','Stasinos','stas@outlook.com',0,'',2,'',1,''),(58,'paris','6c22a2287f213da6735f30d1c2b440adcc7570a4df6f1c08ebecdd1704c996c6','Paris','Troias','paris@mail.com',0,'eimai o paris kai mou aresei i react',1,'http://localhost:8080/files/downloadFile/animal-belgian-shepherd-dog-dog-37735.jpg',0,'3c9ddd02-d24b-4f0c-80db-c996fa40ee78'),(59,'paul','958ad91ab6182863a575029f328b0c8e165ca341eb8814512097f81a3a9596ee','Paul','Paulou','paul@mail.com',23,'Eimai polu kalos leme!!!!\nEimai o Paul',2,'http://localhost:8080/files/downloadFile/ironman.gif',0,'1177d371-da6d-4b24-b6cd-7c848be1f99b'),(60,'tom','e656e128f7c54f8678eb0e9cd66e33c373126b5a49b9eec265626d9ebadb9e9d','Tom','Jones','tom@mail.com',0,'',1,'',0,'a611c6b4-8c17-458a-85d2-b2784d608804'),(61,'pete','37ca35b67a2c73e99a757bb6d2d596e7569b0548e7c815be9bba9895a993c375','Pete','Burgens','pete@mail.com',29,'• Personal Trainer με εμπειρία στη γυμναστική από μικρή ηλικία • Εκγύμναση με το βάρος του σώματος • Γυμναστική με βάρη • Αερόβια-αναερόβια άσκηση • Δημόσιοι και κλειστοί χώροι • Πλήρης καθοδήγηση στις ασκήσεις βήμα βήμα και γρήγορα αποτελέσματα • Όγκος, γράμμωση, απώλεια βάρους',2,'http://localhost:8080/files/downloadFile/avatar-2018-10-10-134138.jpg',0,'41f242b2-271e-484f-996f-368fff5e337f'),(62,'kreas','1c6294e2e304e0b3c23c298869a698ff6148bc7e9ec305905f7a0acab69dcbcb','Spoigf','LGdsf','spalrewfds@gdsfgfd',23,'',2,'',1,'e2cdff45-1d69-4488-a62e-4a748d7ee5bd'),(63,'kitsa','61ce19e27cb66e7e485537bf7458642b558e3fc7a26fac607f57bb05d0874445','Kitsa','Kitsou','kitsa@mail.com',0,'',1,'http://localhost:8080/files/downloadFile/bruce-mars-556415-unsplash.jpg',0,'bab5f840-ca35-4a67-a357-8fadb0e10867'),(64,'admin','600373b6c1c05bc83d7be25d68a8ef34fd5c39ea80cb1e6cd396cfd0b6af84a0','admin','admin','admin@mail.com',0,'',3,'',0,'72ea8e39-a5cc-4fa8-87d7-ba6eca7126c9'),(65,'stavros','bc123bf723b97d93cdb8802af4abc98dc583f9a8a80d4330e06fa8f528bf8461','stavros','stavros','stavros@mail.com',0,NULL,2,NULL,0,'b88e2161-4643-4fb7-8916-a75e5f691b0c'),(66,'spiros','a601955856f9d2693ba191e7b14f3fc1bf507b5f491da0d1677e2e723836dc0a','spiros','spiros','spiros@mail.com',0,NULL,2,NULL,0,'92afc0ad-33cf-4a25-a38b-6d4950f44257'),(67,'nikos','9680b670beef09d5915d69b71bb3cf1034517f0d9b0b83e9205a60988fb4f4c5','nikos','nikos','nikos@mail.com',0,NULL,2,NULL,0,'2b10ec7f-2c96-48b3-a83b-e6efc9b84cab'),(68,'petros','234ba2b0e16b764589de9ea82ed582a3a9ca0ae61e57a05471c44844685e75b4','petros','petros','petros@mail.com',0,NULL,2,NULL,0,'527162a1-143a-4067-bd15-fbd8417c1cf1'),(69,'stefanos','42fa48717da26b08e26136d5ab2aca4e8e788b3dd90dba40c88eea55d251a2a6','stefanos','stefanos','stefanos@mail.com',0,NULL,2,NULL,0,'b0645292-f3e7-4d87-8476-ca53426b8093'),(70,'sokratis','980e1a2f68f98a9dfdb4babb97a203b19daba8d9002149e460e1d5cce66d774c','sokratis','sokratis','sokratis@mail.com',0,NULL,2,NULL,0,'a73f731c-662d-4d58-a134-607501a43698'),(71,'avraam','ef883edc0b51f27390883801fe37c1bd708c3adb90f777e60f2bbaa3533e3cb6','avraam','avraam','avraam@mail.com',0,NULL,2,NULL,0,'bea96579-5ca1-4348-a771-d919e4d3fd1c'),(72,'eratw','893c203fb0493eb354b3c5da9b5bea5287fd3715683b0dbc61c1f26f4eff1d44','eratw','eratw','eratw@mail.com',0,NULL,2,NULL,0,'78b4200e-c5ed-49e1-8df2-a824670e2e9d'),(73,'natasa','1ca575a0caa7666e6277528fcbff4c868c75378134db87d64ac3ab70eb55d35b','natasa','natasa','natasa@mail.com',0,NULL,2,NULL,0,'c96acdcd-4e16-4e90-82e0-a5c45bf4e7c4'),(74,'athina','826bb0f402fa0e9cff1268803c8aae920b758041b54daa6212eb03a0e5ad41dc','athina','athina','athina@mail.com',0,NULL,2,NULL,0,'dcafb1f5-f8cd-4c87-919d-12e14ebd1c41'),(75,'orfeas','29ad88422f6c5f6d654598e5147c4c8bb8e4170250217bf0e7109b54f397d6d6','orfeas','orfeas','orfeas@mail.com',0,NULL,2,NULL,0,'8b78ca07-6d5f-41f6-ad5d-e971accf93ff'),(76,'platwnas','428df3dafdf8b615d2fabac6385b53af3a224ec3f12482780808ca594a8c420f','platwnas','platwnas','platwnas@mail.com',0,NULL,2,NULL,0,'5bf78126-6b68-413a-ae6f-095b38023c69'),(77,'alex','6423639ef6910467cfbdd248293a1926c192b358b81808148f8cafe0a496c306','alex','alex','alex@mail.com',0,NULL,2,NULL,0,'a8caa336-3d01-4ed9-b95b-bcb1b6aa37a9'),(78,'jean','3bbaf4020ab0e00e0d5a701f58920cb5a19ef4b39dff834894ec9d0a63c2f2f5','jean','jean','jean@mail.com',0,NULL,2,NULL,0,'ed19912c-ba10-4588-9491-8bed66a924cc'),(79,'joceline','3abba98c3402a9575c8589890bf92d372bbf72803e6581d089d2aff8d7ccbb3f','joceline','joceline','joceline@mail.com',0,NULL,2,NULL,0,'3347f9fb-f0c5-47f4-b1ba-a409e958e5e3'),(80,'brad','f6bb61a0ecc8cb6a30ae531464edb8b80810b3b91318ee7c9fea23d7bb9c8963','brad','brad','brad@mail.com',0,NULL,2,NULL,0,'ee1e6f54-461e-4aad-9729-8aade71fce65'),(81,'michele','e84a6ef71b5651cafdce517d6f393d4f11923e94e4278531aeb264eea8ba6e22','michele','michele','michele@mail.com',0,NULL,2,NULL,0,'7e5bf532-8318-44a0-8c64-7609ae32f961'),(82,'krewn','d08bf10c5268167d496e0983ac45c2f4323798f503e40c94786254822e528ee2','krewn','krewn','krewn@mail.com',0,NULL,2,NULL,0,'a683accd-ea04-4a90-858a-da784ce7becc'),(83,'stathis','2a3e20dc1303e3abde14ba0f4fdb3f57f07613e6a6133f5e36e2249742f149ec','stathis','stathis','stathis@mail.com',0,NULL,2,NULL,0,'a7da40b8-21ac-4c95-8a52-fa9d840424a6'),(84,'panos','b00ded25ad9b22fe8d88cb950e2995a9c06c41d5a89d55aacfb42c13cd952a19','panos','panos','panos@mail.com',0,NULL,2,NULL,0,'879a3298-1606-4203-85bc-80afe7bd022d'),(85,'skilos','a10ea1407fd5550607fe1d5c7e9b960b4265d3c64b5ae0fe44f3430262022475','Mavros','Katrami','skilos@mail.com',0,NULL,1,NULL,0,'aad21829-b334-43ab-9561-59835a39f27d'),(86,'skilost','072cdc71a21813b628be0c447ce17d208851ec0426fa48ea31318bf5b7a7612d','Mavros','Katrami','skilost@mail.com',0,NULL,2,NULL,0,'cd2b469e-18a7-4fd1-b323-f03f080e36af'),(87,'skilosu2','cc586c40588354ad5f6f32571c81c54cfc613ff885d3fd79b3a163bb11843aa5','Mavros','Katrami','skilosu2@mail.com',0,NULL,2,NULL,0,'e8f50091-59cd-4a69-b413-0110fcd41f7e'),(88,'skilosu3','29f8e855690b87b608dc945d8b351be587ef52786dab92813c058a9932116aa9','Mavros','Katrami','skilosu3@mail.com',0,NULL,1,NULL,0,'dc44b8d7-fc34-4f26-94e6-c9d4d3d05445'),(89,'skilosu','7fe2f673fff13495472c838efbe376fc7ade4abef699716ba512f27d485ffa05','Mavros','Katrami','skilosugtfg3@mail.com',0,NULL,2,NULL,0,'7fe0ec61-2a75-4f23-8aee-f4d3e941b4a9'),(90,'skilosgfdsgdsf','faf3c641aa2e820a7b9d09d16b41e2beec6d3bbbe9813e7a8e7b4c3304cd0a23','Mavros???','Katrami','skilosu@mail.com',0,NULL,1,NULL,0,'a756b056-0883-4dda-a317-f1bdfee2069a'),(91,'skilosdsfds','3969b3add639410120603aa5928fbef6f7f6f3c1971aff9b1d8755f3937c16c5','Mavros','Katrami???','skiloszzzzzfsdzzz@mail.com',0,NULL,1,NULL,0,'a71d01ca-f4fd-4e78-9306-ed49ee4889f8'),(92,'skilosfdfs','7e0c049a8e2f390e2e3555b217441b0894d045c627415f4e58158e9979dd0140','Mavros','Katrami','skilofdzz@mail.com',0,NULL,1,NULL,0,'170a1868-bb74-41a0-9041-755ced6dce46'),(93,'skilosgf','94d2a3dc4753590d769e1cea8b420db55fc44ec736faf8d3ee82fec6e4551453','Mavros','Katrami','admigfn@gsd.gfds',0,NULL,1,NULL,0,'650aa301-0259-4097-a6a4-83e0ffd20d32'),(94,'paristew','50bfb450851d2f825871cc7ff7d560dce1ef3a20eaffd4cc6d8ae0091d434ddd','54325324','3245','paris@fdsfsd.com',0,NULL,1,NULL,0,'91abbee8-2437-44f6-ad7a-bef869ae9737'),(95,'stas','e8d4e929b27f882f45d4db1a5b7fbf56f9a7a8a05619e7536ec2136c56477849','Kostas','Stasinos','kostasstas@mail.com',50,NULL,2,'http://localhost:8080/files/downloadFile/GOPR5707.JPG',0,'88a50ca4-f13e-4e4e-a656-a38e8af8fa5f');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tseam_six_3'
--

--
-- Dumping routines for database 'tseam_six_3'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-18 21:12:15
