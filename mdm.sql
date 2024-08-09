-- MariaDB dump 10.19  Distrib 10.11.6-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: db24111
-- ------------------------------------------------------
-- Server version	10.11.6-MariaDB

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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `view_count` int(11) DEFAULT NULL,
  `board_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`board_id`),
  KEY `FKsds8ox89wwf6aihinar49rmfy` (`member_id`),
  CONSTRAINT `FKsds8ox89wwf6aihinar49rmfy` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES
(9,43,9,'인명피해는 없어서 다행인데.. 오늘처럼 교차로에서 사고 나는 경우 보통 어떤식으로 과실비율 측정이 될까요?','2024/05/29 01:26:20','2024/05/30 18:34:01','가천대 교차로에서 교통사고 났나요?'),
(11,45,6,'1차선에서 저속 주행하는 차 때문에 사고가 날 뻔했어요..','2024/05/29 01:28:02','2024/05/30 18:33:55','고속도로에서 교통사고 날 뻔했어요..'),
(9,46,10,'오늘 오후 10시쯤 오목교 사거리 도로 포장 공사하는데 말이죠..\n그 누구도 교통 통제를 안해서 차들이 엉켜서 난리도 아니었어요\n초보 운전자는 울어요','2024/05/29 01:30:09','2024/05/30 18:59:53','오목교 사거리 어이없는 일..'),
(7,47,10,'고양이야 위험해!!!','2024/05/29 01:30:50','2024/05/30 18:33:42','꽁꽁 얼어붙은 도로 위를 고양이가 지나다닙니다.'),
(4,48,2,'안녕하세요 가입했습니다.','2024/05/29 09:16:37','2024/05/30 19:11:16','안녕하세요'),
(4,49,2,'도와주세요','2024/05/30 19:10:15','2024/05/31 16:18:28','30개 써놔야합니다');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `board_id` bigint(20) DEFAULT NULL,
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `review_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FKlij9oor1nav89jeat35s6kbp1` (`board_id`),
  KEY `FKmrrrpi513ssu63i2783jyiv9m` (`member_id`),
  KEY `FKnf4ni761w29tmtgdxymmgvg8r` (`review_id`),
  CONSTRAINT `FKlij9oor1nav89jeat35s6kbp1` FOREIGN KEY (`board_id`) REFERENCES `board` (`board_id`),
  CONSTRAINT `FKmrrrpi513ssu63i2783jyiv9m` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FKnf4ni761w29tmtgdxymmgvg8r` FOREIGN KEY (`review_id`) REFERENCES `review` (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES
(45,22,10,NULL,'아이쿠.. 놀라셨겠다!!ㅠ 항상 안전운전!','2024/05/29 01:28:33','2024/05/29 01:28:33'),
(47,23,9,NULL,'고양아 조심해!!! ㅠ','2024/05/29 01:34:58','2024/05/29 01:34:58'),
(46,24,9,NULL,'근데 면허 없으시지 않나요?;;;;','2024/05/29 01:35:12','2024/05/29 01:35:12'),
(45,25,9,NULL,'면허 없으시잖아요...;;','2024/05/29 01:35:25','2024/05/29 01:35:25'),
(43,26,6,NULL,'과실비율 측정 서비스 이용해보세요..\n','2024/05/29 01:35:48','2024/05/29 01:35:48'),
(43,27,9,NULL,'교차로는 거의 4:6 이나 3:7 이런식이더라고요..','2024/05/29 01:35:56','2024/05/29 01:35:56'),
(48,28,2,NULL,'댓글 작성해보겠습니다.','2024/05/29 09:23:07','2024/05/29 09:23:07'),
(49,29,9,NULL,'디비 밀고 각자 10개씩 쓰자 ㅋㅋ\n','2024/05/31 16:18:25','2024/05/31 16:18:25');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `board_id` bigint(20) DEFAULT NULL,
  `file_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `inquiry_id` bigint(20) DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `origin_file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`file_id`),
  KEY `FKhxmhyint41lp428u8yxcy4alx` (`board_id`),
  KEY `FK2xn20d26sldh7kq4brpg5fa5u` (`inquiry_id`),
  CONSTRAINT `FK2xn20d26sldh7kq4brpg5fa5u` FOREIGN KEY (`inquiry_id`) REFERENCES `inquiry` (`inquiry_id`),
  CONSTRAINT `FKhxmhyint41lp428u8yxcy4alx` FOREIGN KEY (`board_id`) REFERENCES `board` (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `negligencea` int(11) DEFAULT NULL,
  `negligenceb` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `video_id` bigint(20) DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `negligence` varchar(255) DEFAULT NULL,
  `origin_file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_s7rt8tr8bwsceb86k9vk4yq7q` (`video_id`),
  KEY `FKbnwj6i7md9xd8vr1pfqqbf1q5` (`member_id`),
  CONSTRAINT `FKbnwj6i7md9xd8vr1pfqqbf1q5` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FKlxcb55el15q6huo5abu5ct8xw` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES
(NULL,NULL,1,6,NULL,'2024/05/27 19:55:29','2024/05/27 19:55:29','POST_55310378-7a16-4b6f-999d-50c3f952aaa0.mp4','video/mp4','\"100:0\"','23.mp4'),
(NULL,NULL,2,6,NULL,'2024/05/27 19:55:37','2024/05/27 19:55:37','POST_722d024a-fdbb-4779-9f9b-56e4857496d3.mp4','video/mp4','100:0','23.mp4'),
(NULL,NULL,3,2,NULL,'2024/05/27 20:04:27','2024/05/27 20:04:27','POST_9521b4bb-0211-4ebc-88b1-84a5a84929e4.mp4','video/mp4','{\"ratio\":null}','13.mp4'),
(NULL,NULL,4,2,NULL,'2024/05/27 20:10:33','2024/05/27 20:10:33','POST_676b7f1d-060b-4bdc-832b-8914b16b7e35.mp4','video/mp4','{\"ratio\":null}','13.mp4'),
(NULL,NULL,5,2,NULL,'2024/05/27 20:16:33','2024/05/27 20:16:33','POST_2773f685-8bba-48c5-9716-5fe93c81fbd3.mp4','video/mp4','{\"ratio\":\"50:50\"}','13.mp4'),
(NULL,NULL,8,2,NULL,'2024/05/28 00:17:28','2024/05/28 00:17:28','POST_63d528a2-3ef3-4d5c-a8cb-d72962585b11.mp4','video/mp4','{\"ratio\":\"50:50\"}','13.mp4'),
(NULL,NULL,9,2,NULL,'2024/05/28 00:20:01','2024/05/28 00:20:01','POST_e056928e-6ed3-41a6-bc4e-7b8d0ed847e6.mp4','video/mp4','{\"ratio\":\"70:30\"}','23.mp4'),
(NULL,NULL,10,2,NULL,'2024/05/28 00:22:05','2024/05/28 00:22:05','POST_a85f8caf-715c-46db-a288-ece1d4f19c35.mp4','video/mp4','{\"ratio\":\"70:30\"}','23.mp4'),
(NULL,NULL,11,9,NULL,'2024/05/29 09:40:54','2024/05/29 09:40:54','POST_4a5d299a-f6e7-4648-976d-85c14ccda207.mp4','video/mp4','{\"ratio\":\"20:80\"}','23.mp4'),
(NULL,NULL,12,9,NULL,'2024/05/29 09:44:22','2024/05/29 09:44:22','POST_c184bb85-fc9d-4cea-8cf0-ec7f7c9b00c6.mp4','video/mp4','{\"ratio\":\"10:90\"}','13.mp4'),
(NULL,NULL,13,6,NULL,'2024/05/29 09:56:41','2024/05/29 09:56:41','POST_aa8cea8d-669b-44bb-b096-4fbd2a4e4aef.mp4','video/mp4','{\"ratio\":\"10:90\"}','13.mp4'),
(NULL,NULL,14,9,NULL,'2024/05/29 10:05:38','2024/05/29 10:05:38','POST_2e3bf4bf-43a9-4d2b-9b27-604d349132f6.mp4','video/mp4','{\"ratio\":\"10:90\"}','13.mp4'),
(NULL,NULL,15,2,NULL,'2024/05/29 10:16:46','2024/05/29 10:16:46','POST_60ab1e63-8149-42ef-9893-e1d8bd5a930d.mp4','video/mp4','{\"ratio\":\"10:90\"}','13.mp4'),
(NULL,NULL,16,6,NULL,'2024/05/29 10:43:59','2024/05/29 10:43:59','POST_de967f1d-5bed-484e-9a38-e2e85732f477.mp4','video/mp4','100:0','23.mp4'),
(NULL,NULL,17,2,NULL,'2024/05/29 10:54:03','2024/05/29 10:54:03','POST_24dcba42-87a2-4851-ae3e-d957f64db24a.mp4','video/mp4','{\"ratio\":\"10:90\"}','13.mp4'),
(NULL,NULL,18,2,NULL,'2024/05/29 11:05:10','2024/05/29 11:05:10','POST_4087fe2b-66a6-4943-a6d9-ac1ebe70f2aa.mp4','video/mp4','{\"ratio\":\"0:100\"}','4.mp4'),
(NULL,NULL,19,6,NULL,'2024/05/29 14:16:10','2024/05/29 14:16:10','POST_8df67a36-948f-44e8-8a3b-40059b01a8cd.mp4','video/mp4','{\"ratio\":\"0:100\"}','qwer.mp4'),
(NULL,NULL,20,6,NULL,'2024/05/29 14:18:05','2024/05/29 14:18:05','POST_19359b91-703f-4933-b26c-8d0a8548c941.mp4','video/mp4','{\"ratio\":\"Unknown\"}','qwer.mp4'),
(NULL,NULL,21,6,NULL,'2024/05/29 14:22:07','2024/05/29 14:22:07','POST_cd9a45b5-687c-4a78-bf07-ce16ab8ed833.mp4','video/mp4','{\"ratio\":\"60:40\"}','qwer.mp4'),
(NULL,NULL,22,6,NULL,'2024/05/29 14:23:25','2024/05/29 14:23:25','POST_73dfe98f-7d58-42e6-a7d7-d5106576b8cc.mp4','video/mp4','{\"ratio\":\"0:100\"}','qwer1.mp4'),
(NULL,NULL,23,6,NULL,'2024/05/29 14:23:47','2024/05/29 14:23:47','POST_1abd1553-f80a-4015-ab0f-cd7dc0fdf43f.mp4','video/mp4','{\"ratio\":\"0:100\"}','qwer1.mp4'),
(NULL,NULL,24,6,NULL,'2024/05/29 14:25:31','2024/05/29 14:25:31','POST_a4cea8ac-98d7-4cc0-9458-7e136202b1e5.mp4','video/mp4','{\"ratio\":\"20:80\"}','qwer1.mp4'),
(NULL,NULL,25,6,NULL,'2024/05/29 14:52:06','2024/05/29 14:52:06','POST_41209b8e-42d9-419f-a584-8ffe07480187.mp4','video/mp4','{\"ratio\":\"40:60\"}','12345.mp4'),
(NULL,NULL,26,6,NULL,'2024/05/29 14:52:35','2024/05/29 14:52:35','POST_b67e3506-5e84-494f-96f4-fe32dd0104fd.mp4','video/mp4','{\"ratio\":\"90:10\"}','12345.mp4'),
(NULL,NULL,27,9,NULL,'2024/05/31 18:46:57','2024/05/31 18:46:57','POST_37c28160-0d54-4452-a84e-9add9f983056.MP4','video/mp4','{\"ratio\":\"70:30\"}','0223.MP4'),
(NULL,NULL,28,6,NULL,'2024/05/31 18:47:13','2024/05/31 18:47:13','POST_2eb92f4c-a109-470a-98ed-cbc04e6ce5d9.mp4','video/mp4','{\"ratio\":\"80:20\"}','0223.mp4');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquiry`
--

DROP TABLE IF EXISTS `inquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inquiry` (
  `date` date DEFAULT NULL,
  `replied` bit(1) DEFAULT NULL,
  `inquiry_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `answer` varchar(1000) DEFAULT NULL,
  `contents` varchar(1000) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `inquiry_type` enum('SERVICE','EVENT','ETC') DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`inquiry_id`),
  KEY `FKf47xlnlpohnc6gd4k511g0wra` (`member_id`),
  CONSTRAINT `FKf47xlnlpohnc6gd4k511g0wra` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquiry`
--

LOCK TABLES `inquiry` WRITE;
/*!40000 ALTER TABLE `inquiry` DISABLE KEYS */;
INSERT INTO `inquiry` VALUES
(NULL,'',11,9,'네 가능합니다. 주소 남겨주시면 수정해드리겠습니다.','제가 이사를 해서 집 주소가 바뀌었는데 \n불스원샷을 이사한 집 주소로 받을 수 있을까요?','이벤트 관련 문의합니다.',NULL,'2024/05/29 01:28:07','2024/05/29 01:29:41'),
(NULL,'',12,6,'당연하죠! 얼른 과실비율 측정을 경험해보세요~!','차대 보행자 같은 교통사고도 예측이 가능한가요?','교통사고 예측 서비스 관련 문의합니다...',NULL,'2024/05/29 01:32:28','2024/05/29 01:33:30'),
(NULL,'',13,10,'일단 이*지 님의 이벤트 상품은 출고가 되었습니다.\n상품은 랜덤으로 발송되는 점 ^^; 죄송합니다! 다시한번 저희 서비스를 이용해주셔서 감사합니다!','언제. 배송이. 오나요? 저는 불스원샷 빨간 뚜껑으로 보내주세요!!','이벤트 관련 문의입니다.',NULL,'2024/05/29 01:33:22','2024/05/29 01:34:26');
/*!40000 ALTER TABLE `inquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `birth` date DEFAULT NULL,
  `drive_exp` int(11) DEFAULT NULL,
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `my_name` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `roles` enum('USER','ADMIN') DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES
('1999-12-08',7,2,'2024/05/08 14:07:45','mari394337@gmail.com','2024/05/16 21:34:50','전민혁','전빡빡1','$2a$10$wxmGhG9iBJP9.HhAnqHZ.OVXBMTe3LAVqEKv54JlMWNjR2HU7GfqC','mari394337@gmail.com','USER'),
('2024-05-08',1,4,'2024/05/16 18:09:16','admin@naver.com','2024/05/16 18:09:16','관리자','관리자','$2a$10$y7v79gS6jVgZBUXJp6CBm.58Rin53S5/Ky7m/DYyNpyFtMpOmSdvC','admin','ADMIN'),
(NULL,0,6,'2024/05/27 15:56:41','k@k','2024/05/27 15:56:41','가한솔','둥봉','$2a$10$oT4zCZKKsMOeQ/3AdIhfMuyesPCZPSiuFy2cThttmrh3hM.ik72Hu','k','USER'),
('1998-02-23',0,9,'2024/05/29 01:24:42','dldusthd7@naver.com','2024/05/29 01:24:42','이연송','쫑이','$2a$10$VfpFc4hnxe5voCJ5IVX3p.FN.OXnaTDmR8IrKRJYhcTrAjUijxq62','dldusthd7','USER'),
('2000-09-22',2,10,'2024/05/29 01:25:02','dpwl0922@naver.com','2024/05/29 01:25:02','이예지','뛰뛰빵빵','$2a$10$Y6cAztlkHvqPoMlmU24FKutbmZe4NPG9s/3/CkUGKzo4wnMko74va','brr922','USER');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `notice_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` varchar(255) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `view_count` int(11) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`notice_id`),
  KEY `FKnriaekshh15qoqnlhvqkj931e` (`member_id`),
  CONSTRAINT `FKnriaekshh15qoqnlhvqkj931e` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES
(6,'2024/05/29 01:32:53','2024/05/29 01:32:53','추첨을 통해 불스원샷을 드립니다!','5월 후기 이벤트',0,4);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `view_count` int(11) NOT NULL,
  `history_id` bigint(20) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `review_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `video_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`review_id`),
  UNIQUE KEY `UK_6kdyxb7ue95r2tlybv59vh8m8` (`history_id`),
  UNIQUE KEY `UK_1ta8eclgp9x7eskigp1rkk2or` (`video_id`),
  KEY `FKk0ccx5i4ci2wd70vegug074w1` (`member_id`),
  CONSTRAINT `FK2qtreaxlj8iqomk15pk1on43w` FOREIGN KEY (`history_id`) REFERENCES `history` (`id`),
  CONSTRAINT `FK8hj963gki25k4ve0i93icv9o` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`),
  CONSTRAINT `FKk0ccx5i4ci2wd70vegug074w1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES
(25,1,6,2,NULL,'두번째 후기 60:40','2024/05/28 00:59:41','2024/05/31 16:18:40','후기 테스트 수정'),
(48,10,2,3,NULL,'첫번쨰후기 70:30','2024/05/28 02:15:38','2024/05/29 10:17:15','첫번째 후기'),
(4,9,2,4,NULL,'생각보다 정확해서 좋아요','2024/05/29 09:17:52','2024/05/31 16:20:42','후기 작성합니다'),
(2,14,9,5,NULL,'안녕','2024/05/31 16:19:37','2024/05/31 18:47:44','안녕하세요'),
(1,28,6,6,NULL,'정확도가 높은 거 같아요','2024/05/31 18:47:38','2024/05/31 18:47:49','후기입니다');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `member_id` bigint(20) DEFAULT NULL,
  `video_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `origin_file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`video_id`),
  KEY `FKt1qraed5ypqn1u5s3jiq0xu1i` (`member_id`),
  CONSTRAINT `FKt1qraed5ypqn1u5s3jiq0xu1i` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES
(NULL,1,'POST_b5e67641-63ec-4a8f-8a8f-72cf800a8e01.mp4',NULL,'video/mp4','test1.mp4'),
(NULL,2,'POST_96dad904-6e67-47cd-8027-19854c41ddb1.mp4',NULL,'video/mp4','test1.mp4'),
(NULL,3,'POST_c4f48a0d-409c-4bff-a0db-97f7dab233e3.mp4',NULL,'video/mp4','test1.mp4'),
(NULL,4,'POST_c1c16368-8cee-4cf9-a31a-74f60cc65dca.mp4',NULL,'video/mp4','test1.mp4'),
(NULL,5,'POST_5ff05805-30a2-462c-b916-74673f5b0607.mp4',NULL,'video/mp4','test3.mp4'),
(NULL,6,'POST_1d0a72e7-be97-47bb-92f5-68e5243b8fcb.mp4',NULL,'video/mp4','test4.mp4'),
(NULL,7,'POST_d31ec35f-8d22-461a-9335-5433785fbba5.mp4',NULL,'video/mp4','test1.mp4'),
(NULL,8,'POST_b7b53f62-ba92-4573-897b-387f799ebf93.mp4',NULL,'video/mp4','test1.mp4'),
(NULL,9,'POST_afb8673f-610a-4e3b-809e-ec057865b929.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,10,'POST_2cd6d4e0-c076-4b9a-8cec-5f3eaacf67c7.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,11,'POST_460e3ff4-12e1-4ba6-97db-e6aef49b45a7.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,12,'POST_f07bde5d-e65c-4d8f-9bbb-35ad3b88f238.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,13,'POST_5295ea8f-3098-4e40-9ceb-c4089a1d203e.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,14,'POST_82575d33-c3fc-4e3e-ba95-8943f2c21046.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,15,'POST_67db5136-a23f-438a-9bc0-9f17251b450f.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,16,'POST_7ef28f3f-94e8-4463-8ce7-db80112263e1.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,17,'POST_a16afa84-1355-4f20-a746-712903b0e8d9.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,18,'POST_ff011e5c-c549-432f-af25-47a428c3d2e5.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,19,'POST_7fead170-0b82-44ee-93e3-6b1959bfef3a.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,20,'POST_c59993ff-2994-4a88-a0ad-1c548a830c88.mp4',NULL,'video/mp4','POST_2_4a096317-f072-4595-b4f5-ce5419e1df4b.mp4'),
(NULL,21,'POST_0e943a7a-b829-4e54-8a34-e20c370a9425.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,22,'POST_0c49e321-6de9-4675-a0f3-a6314288ee55.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,23,'POST_5daad64b-087f-4d0e-a02f-8f87a4bbb01b.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,24,'POST_07cfa07b-c2ac-4aea-9e81-4de4425f0d22.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,25,'POST_cb862db6-fdf4-44f1-a3eb-0b326951cccc.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,26,'POST_ae2e12b3-c5a0-418d-afab-deec325a25fd.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,27,'POST_88a63b83-f4ff-4afc-b6c2-9452364c101d.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,28,'POST_ad85f625-7cc5-4350-a41f-90d15c189b58.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,29,'POST_30a73a8b-a4c7-45ff-8248-90c57b6ce731.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,30,'POST_d16a3a62-f5ce-400d-ad5d-71865af437b2.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,31,'POST_ec12ed61-e9ff-488f-b9e9-97e38f620efc.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,32,'POST_720d4348-ed97-4e88-b23f-756b78e403bb.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,33,'POST_70e8585e-ec62-4016-abeb-758c4cb4730b.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,34,'POST_568ad0c7-eba6-4b7d-a512-3ecb56a8fc7d.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,35,'POST_a0b6418c-efd2-4c3c-81d8-a32763a86145.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,36,'POST_a43738bd-debf-4862-9894-da95e5ce5277.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,37,'POST_65a0687e-ca91-4e1a-a381-5ae11c1679c0.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,38,'POST_04cb1a9c-5d24-4d29-9886-10c4bfe060c7.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,39,'POST_b79a841c-f13d-4831-b145-64d7b68ca063.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,40,'POST_1cec1061-8dcb-4b24-a06f-a6514d56e752.mp4',NULL,'video/mp4','KakaoTalk_20240513_002726262.mp4'),
(NULL,41,'POST_3df0ec2c-712f-4c17-8b56-a5be56cfa10f.mp4',NULL,NULL,'output_video.mp4'),
(NULL,42,'POST_9e400582-1d50-4946-a5f5-a679a1384dae.mp4',NULL,NULL,'output_video.mp4'),
(NULL,43,'POST_001b5440-12df-429f-8eca-cdbb7781d8dd.mp4',NULL,'video/mp4','KakaoTalk_Video_2024-05-14-01-58-02.mp4'),
(NULL,44,'POST_72f95c5c-5077-4b20-a895-4090bc5b8a1c.mp4',NULL,'video/mp4','KakaoTalk_Video_2024-05-14-01-58-02.mp4'),
(NULL,45,'POST_2fe93355-f11d-4caf-8726-f3722e991e96.mp4',NULL,'video/mp4','KakaoTalk_Video_2024-05-14-01-58-02.mp4'),
(NULL,46,'POST_d2a12884-ef93-46c2-bd35-ffe2e282e283.mp4',NULL,NULL,'output_video.mp4'),
(NULL,47,'POST_a03aaf87-5e52-497e-8653-97967557b6bb.mp4',NULL,NULL,'output_video.mp4'),
(NULL,48,'POST_b75bc208-8c9b-443a-bff4-db32800d5213.mp4',NULL,NULL,'output_video.mp4'),
(NULL,49,'POST_51bb1d2f-bf6d-4b92-9fe3-8b42e22067fb.mp4',NULL,NULL,'output_video.mp4'),
(NULL,50,'POST_4d46a31b-15da-4fa1-977e-ce9615fc2689.mp4',NULL,NULL,'output_video.mp4'),
(NULL,51,'POST_40852b57-2dbe-494e-9d5e-6e26a7b68ef0.mp4',NULL,NULL,'output_video.mp4'),
(NULL,52,'POST_22fd05be-7bc2-4c8c-b23e-05fae77165b4.mp4',NULL,NULL,'output_video.mp4'),
(NULL,53,'POST_7bf5b3a0-26e1-4aec-9d13-0fdf9b40c66e.mp4',NULL,NULL,'output_video.mp4'),
(NULL,54,'POST_8410cfa8-fe01-47d4-9837-1a5acb565cdc.mp4',NULL,NULL,'output_video.mp4'),
(NULL,55,'POST_95b11a74-1df4-49f5-a2ea-9460db5d1db2.mp4',NULL,NULL,'output_video.mp4'),
(NULL,56,'POST_d7e765eb-d726-44f1-98a9-5e2a044c5c2b.mp4',NULL,NULL,'output_video.mp4'),
(NULL,57,'POST_ac1d6068-a927-48dd-8b1c-73e22af6b5b0.mp4',NULL,NULL,'output_video.mp4'),
(NULL,58,'POST_0d95b069-bfa7-450a-8a52-a4a8466a04d9.mp4',NULL,NULL,'output_video.mp4'),
(NULL,59,'POST_d031a181-2c5b-48ef-b0f0-50344c9a5c14.mp4',NULL,NULL,'output_video.mp4'),
(NULL,60,'POST_936252a7-d758-4bd5-b973-06ebddfd9ef1.mp4',NULL,NULL,'output_video.mp4'),
(NULL,61,'POST_e500354e-93ec-4df1-933e-180207952fdf.mp4',NULL,NULL,'output_video.mp4'),
(NULL,62,'POST_abeb68cb-9098-46cf-acb6-256455f65504.mp4',NULL,NULL,'output_video.mp4'),
(NULL,63,'POST_f3eda629-39f5-4865-9226-6c9de293db2e.mp4',NULL,NULL,'output_video.mp4'),
(NULL,64,'POST_00719ab7-d55f-41c1-b2b8-bdf08ef89a09.mp4',NULL,NULL,'output_video.mp4'),
(NULL,65,'POST_0039f74d-c717-46a6-be31-9751eb76e8b3.mp4',NULL,NULL,'output_video.mp4'),
(NULL,66,'POST_5fcffd6c-9da6-41a1-8ade-a948eefac770.mp4',NULL,NULL,'output_video.mp4'),
(NULL,67,'POST_c7f5e057-496d-45f8-9283-a361dc41aae8.mp4',NULL,NULL,'output_video.mp4'),
(NULL,68,'POST_bc432c37-5ab9-4653-8d7e-2279f18208ba.mp4',NULL,'video/mp4','KakaoTalk_20240514_015704437.mp4'),
(NULL,69,'POST_2ca43800-4bcc-4489-ae84-751480b303c4.mp4',NULL,NULL,'output_video.mp4'),
(NULL,70,'POST_98d3a22c-f1b1-4f3b-a7e5-2501f0530c6b.mp4',NULL,NULL,'output_video.mp4'),
(NULL,71,'POST_b2f36db3-f5f6-4094-a8e5-a4dbd6ceab1d.mp4',NULL,'video/mp4','KakaoTalk_20240514_015704437.mp4'),
(NULL,72,'POST_5bdf23d9-51e2-4626-a7bf-c87ad3a55191.mp4',NULL,'video/mp4','KakaoTalk_20240514_015704437.mp4'),
(NULL,73,'POST_d21a8c63-499e-48be-86bb-24c61311b50e.mp4',NULL,NULL,'output_video.mp4'),
(NULL,74,'POST_05623166-1a0d-4714-ad80-4aaa66c40036.mp4',NULL,NULL,'output_video.mp4'),
(NULL,75,'POST_fdc128a8-5967-4160-b0af-d1ffb96e7365.mp4',NULL,NULL,'output_video.mp4'),
(NULL,76,'POST_3301be67-c0ca-410f-9939-95bf6c248fa0.mp4',NULL,NULL,'output_video.mp4'),
(NULL,77,'POST_bb784a85-3450-4714-a398-ab46b458abb6.mp4',NULL,NULL,'output_video.mp4'),
(NULL,78,'POST_ce2567a0-168a-485d-843c-9e41185986af.mp4',NULL,NULL,'output_video.mp4'),
(NULL,79,'POST_57c66d8e-950e-4c67-8a9a-883b6fae1248.mp4',NULL,NULL,'output_video.mp4'),
(NULL,80,'POST_772d74e7-1917-4fa4-b401-13f1777c6125.mp4',NULL,NULL,'output_video.mp4'),
(NULL,81,'POST_d8aabb80-8203-474f-85ae-35525611b298.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,82,'POST_00dc3c79-f2dc-4f6b-af4b-480bf58d2fd6.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,83,'POST_0ddd954d-47e9-436f-babb-b3caa3af1adc.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,84,'POST_a7b05150-2c1a-4836-bd2d-5dca3acf10e2.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,85,'POST_4ce3c2ff-d3fe-41a3-8b22-937f8f239bb7.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,86,'POST_430c4ded-e805-4c2f-a68d-d3e6c454b74f.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,87,'POST_39b4aac7-0961-4c8a-acdb-ff4b518f8fca.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,88,'POST_9d52c6d2-0996-47f6-85df-79fae22bb91c.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,89,'POST_b3dfe3d5-4b92-4e25-9a77-d23b4b3dcf86.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,90,'POST_06b31cf3-737d-4715-91d1-ac19715c7640.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,91,'POST_7a1ced86-4fee-4b5d-ae49-958e1b4d7b63.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,92,'POST_8d78af41-10cc-4160-adec-74016430849d.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,93,'POST_7111dbf4-4dc4-4e11-bff0-c667ac4d0e30.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,94,'POST_ce4997b4-4ea5-40a6-a60c-435e54d4fefc.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,95,'POST_f7521062-1a5d-4a28-b84d-6e60d5d1c96e.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,96,'POST_afd9fc8b-b7ed-48b0-9a18-c0a4cf47806e.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,97,'POST_e9c9e6e7-ea10-485a-812c-7a750395f49c.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,98,'POST_3ecfdae3-7683-4144-a876-2baafd911157.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,99,'POST_a8821d2a-6020-4c1f-97f1-0c435edf23a3.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,100,'POST_9cc32af6-bcab-41a3-8e97-e4343e25dfd6.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,101,'POST_41b6fa27-b192-40b0-a72b-ea5eca6d23fe.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,102,'POST_c4585327-3bdb-415a-aacf-5508bae35ce5.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,103,'POST_08139de2-3892-4318-896e-ca30874619bc.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,104,'POST_0a34dce3-0260-47a6-9a9f-d774196e8e2f.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,105,'POST_e0a8f998-7548-494e-9650-ec0606b09569.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,106,'POST_8a2c55d6-6fca-497c-823c-960250c92007.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,107,'POST_96ef66cd-e15f-48f5-9a09-100e6cc51948.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,108,'POST_03a719cc-c47c-42e9-8300-f8392d52997c.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,109,'POST_7c436cba-17b1-4f4f-bd87-f5778890b5e3.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,110,'POST_6f61a3e1-8ceb-44c3-b68b-bffee3633bea.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,111,'POST_6dcf49ad-1a81-44a3-94a0-7b609d8f00b4.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,112,'POST_5051da5a-027e-4480-882a-b5c75d795964.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,113,'POST_9755f974-9115-46e5-bf5a-153ad0538a32.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,114,'POST_e9c4840e-78e8-408a-8f4f-bd3c17f34783.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,115,'POST_adaf1d95-4454-4ab6-b61e-7e9dcbbe3097.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,116,'POST_ed08029e-785b-4565-9138-be0e9687c6c4.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,117,'POST_6b9bd2a4-53b2-4803-895d-da76ddbf3ee8.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,118,'POST_2d4a3a97-577f-4589-92e3-aed9e88fb1ef.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,119,'POST_cf997293-fda4-45c5-bc5a-383d7928d27b.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,120,'POST_678c897c-bdb5-4cd0-875d-7e501cd1702c.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,121,'POST_ec9173fa-2cfe-4e75-8e56-887767f9637c.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,122,'POST_202fdb0b-6ea1-4e21-a67d-5922273f5600.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,123,'POST_3f306f57-6691-40e2-9c2c-0abca8dca8a5.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,124,'POST_7aac74ed-7de0-4b15-9fbf-1f921a6a6d55.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,125,'POST_65275f85-8abc-4f91-a294-fe60c440eab2.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,126,'POST_a6a835ba-affe-44db-b2aa-fbc86f118662.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,127,'POST_1b426747-c4f0-44d5-b4ec-bbfc7a8872c0.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,128,'POST_51cca691-af03-4d17-a9fd-2c59c562d821.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,129,'POST_258165a7-d417-4289-8d16-cfeec77ad6c6.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,130,'POST_047dde67-0523-483c-abdd-9681657920aa.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,131,'POST_d47b22ac-9037-4e91-905e-34bfd77e6e56.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,132,'POST_5609b6aa-967b-44d8-8add-592987bea07d.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,133,'POST_9032c3ea-7928-4561-b7ab-ead432f580b6.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,134,'POST_ea75fc75-7d57-477e-8e9e-495093793b41.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,135,'POST_5a886e17-be27-4a1c-b267-d0c293c885e7.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,136,'POST_ef7eea9c-5cf7-4ee6-8fc3-16eba548db44.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,137,'POST_38f25ee3-88cf-4c72-b76a-986a8d6b2de7.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,138,'POST_0a10f728-c22c-4b03-bf1d-8dfae146eda0.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,139,'POST_16da4016-e116-488e-aab7-94e193a8d271.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,140,'POST_d37d618f-084c-4136-8006-17ced80304f7.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,141,'POST_56bc22a6-44b2-4918-bd42-0c1807ef4f8d.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,142,'POST_34d06b44-3022-46c4-87a7-a465c9203cbf.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,143,'POST_0cba42b3-4a8a-44fb-bc26-fa803569fe0c.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,144,'POST_5be1f863-a464-49c4-a272-b04dfa2232a6.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,145,'POST_9160d1dd-7f6a-4761-85b6-99c874cebc9f.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,146,'POST_cf304058-0034-4aa8-bc4f-dc7d49b5edac.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,147,'POST_5a8827d8-cd61-46e1-ab83-9c04d51c5c60.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,148,'POST_4d30e89f-39a8-4170-9116-5f4fcbc4e0c4.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,149,'POST_f812666c-f8cb-4f2a-965f-de9f66ab1a98.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,150,'POST_1e0db1a3-7318-4990-ba0d-792a4d14b53d.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,151,'POST_4dd67373-345a-4b71-bab5-27bdb533b93f.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,152,'POST_a8e2d183-3c65-4bde-89f3-40de4b40dee0.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,153,'POST_be06be02-74b2-4b8c-baa3-f45b17d1aae5.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,154,'POST_b01e9300-ace3-48c3-b53e-41703ae54f0d.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,155,'POST_a0e3f1da-9a80-4be1-a32f-44a96f803083.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,156,'POST_dd0d7abc-0970-49e1-a121-97ee6fefdc25.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,157,'POST_e272e872-88c6-4eb8-bd06-62e21ff41cd6.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,158,'POST_56ec2d31-352f-4dd4-931d-f761fcc85db2.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,159,'POST_82a2f8e1-e6eb-4209-92c6-3b59b6a40f3d.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,160,'POST_f933e614-cba8-4403-9614-27eaa721fd3e.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,161,'POST_f3fdb2aa-5827-4101-813a-0ba8a518f75c.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,162,'POST_0eabe542-1aeb-4d06-8e56-995221a55975.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,163,'POST_bd174f25-3819-4c09-afdd-39836ece1476.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,164,'POST_fdccc235-c360-4f7c-8152-dd4ab32586b3.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,165,'POST_4f5ffc78-8ada-4354-b26b-ad7d67a261e1.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,166,'POST_8c547719-70cb-4e98-b6bd-79b020b3e32e.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,167,'POST_ca8e9313-ccb7-49a3-bd14-8143cbc68ca4.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,168,'POST_7daf16e9-abeb-40d5-9544-83e61e54fdcc.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,169,'POST_7d84eea1-e11f-4322-a46a-90123a46ef4b.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,170,'POST_2dcaa10b-2748-4bce-bf03-849ad38b3877.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,171,'POST_e9be79ac-8465-4ec5-bb84-3e130973d9b6.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,172,'POST_01e61422-0aca-45b3-829a-2b4a22df9e68.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,173,'POST_72a3ec02-00a8-409c-aa50-70a9210af0bd.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,174,'POST_8ba776e3-abb1-417f-a57e-9643d9613aa6.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,175,'POST_0b82bceb-1b03-40ea-a491-ba685d10cb32.mp4',NULL,'video/mp4','13.mp4'),
(NULL,176,'POST_9c714528-3cfd-4eeb-88d5-63721964ba18.mp4',NULL,'video/mp4','13.mp4'),
(NULL,177,'POST_6007dcbd-025e-4f76-bc5f-7eed32e54e60.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,178,'POST_f6489d87-3850-4be5-a842-dc6fcab82da0.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,179,'POST_89667873-d3c3-4f6d-927e-5e2c775cd984.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,180,'POST_34109222-fe06-4809-b780-6b1e75fc866b.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,181,'POST_a98b960b-d9e5-4335-b845-cde5fbdae965.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,182,'POST_27e0d1d8-02c8-4c1c-8393-213151741653.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,183,'POST_45fad5b2-2f61-4b21-b855-17250433dfa5.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,184,'POST_85903be1-fc02-4ba2-8a57-33133c022d7b.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,185,'POST_519593b2-c1f9-45ed-afa9-2822defbc2ab.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,186,'POST_2b7b1cfe-256c-4e75-bfb7-a24de8d1e576.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,187,'POST_8e2dd605-3093-4a16-b8c1-2d51e32a3c49.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,188,'POST_ea92fb4d-713d-4955-9ffe-55e8a7305282.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,189,'POST_c4996cb7-239d-42e4-80ae-a43eefad3cba.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,190,'POST_e4341e65-7066-4aed-a856-c5d6aa85ede9.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,191,'POST_05485c31-c861-4b3f-b9cd-5a3474697af4.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,192,'POST_6e38fa2e-54a9-45d6-b4e3-de79ee7da90a.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,193,'POST_4e858163-11f6-4cd8-9eb9-50c42cbc11b6.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,194,'POST_834738c6-2ef6-4feb-9c73-e1e66fa65f49.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,195,'POST_3f4a485e-77bf-4cc3-991e-3a68d08167bb.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,196,'POST_0b8451d2-3922-47f3-a519-8decf4aa1c91.mp4',NULL,'video/mp4','output_video.mp4'),
(NULL,197,'POST_6c0a8f7f-714e-4c63-b16c-7553106b7ace.mp4',NULL,'video/mp4','output_video.mp4');
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-02  1:01:12
