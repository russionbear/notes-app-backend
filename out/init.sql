-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.10.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for note
CREATE DATABASE IF NOT EXISTS `note` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `note`;

-- Dumping structure for table note.chat_info
CREATE TABLE IF NOT EXISTS `chat_info` (
  `sourceid` varchar(50) NOT NULL,
  `targetid` varchar(50) NOT NULL,
  `createTime` int(11) NOT NULL DEFAULT 0,
  `msg` varchar(200) NOT NULL DEFAULT '0',
  `got` tinyint(4) NOT NULL DEFAULT 0,
  `isSys` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`sourceid`,`targetid`,`createTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.chat_info: ~5 rows (approximately)
/*!40000 ALTER TABLE `chat_info` DISABLE KEYS */;
REPLACE INTO `chat_info` (`sourceid`, `targetid`, `createTime`, `msg`, `got`, `isSys`) VALUES
	('1', 'public', 1671605090, '09809', 0, 0),
	('public', '1', 9999, 'public -> 1 000', 0, 0),
	('public', '1', 1671605090, 'public -> 1', 0, 0),
	('public', '1', 1671612316, 'ni hao', 0, 0),
	('public', '1', 1671614235, 'w', 0, 0);
/*!40000 ALTER TABLE `chat_info` ENABLE KEYS */;

-- Dumping structure for table note.collection
CREATE TABLE IF NOT EXISTS `collection` (
  `userid` varchar(50) NOT NULL,
  `noteid` varchar(140) NOT NULL,
  PRIMARY KEY (`userid`,`noteid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.collection: ~1 rows (approximately)
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
REPLACE INTO `collection` (`userid`, `noteid`) VALUES
	('public', 'index');
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;

-- Dumping structure for table note.discuss
CREATE TABLE IF NOT EXISTS `discuss` (
  `userid` varchar(50) NOT NULL,
  `noteid` varchar(140) NOT NULL,
  `createTime` int(11) NOT NULL DEFAULT 0,
  `value` text NOT NULL,
  PRIMARY KEY (`userid`,`noteid`,`createTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.discuss: ~4 rows (approximately)
/*!40000 ALTER TABLE `discuss` DISABLE KEYS */;
REPLACE INTO `discuss` (`userid`, `noteid`, `createTime`, `value`) VALUES
	('public', 'index', 852489096, '123'),
	('public', 'index', 852627519, '123sdfsadf'),
	('public', 'index', 1671679777, 'hi, handsome'),
	('public', 'public', 21, '123');
/*!40000 ALTER TABLE `discuss` ENABLE KEYS */;

-- Dumping structure for table note.edit_model
CREATE TABLE IF NOT EXISTS `edit_model` (
  `userid` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dsc` varchar(200) NOT NULL,
  `value` text NOT NULL,
  PRIMARY KEY (`userid`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.edit_model: ~1 rows (approximately)
/*!40000 ALTER TABLE `edit_model` DISABLE KEYS */;
REPLACE INTO `edit_model` (`userid`, `name`, `dsc`, `value`) VALUES
	('public', 'test', 'dsc', '# fsdf');
/*!40000 ALTER TABLE `edit_model` ENABLE KEYS */;

-- Dumping structure for table note.good
CREATE TABLE IF NOT EXISTS `good` (
  `userid` varchar(50) NOT NULL,
  `noteid` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`,`noteid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.good: ~1 rows (approximately)
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
REPLACE INTO `good` (`userid`, `noteid`) VALUES
	('public', 'index');
/*!40000 ALTER TABLE `good` ENABLE KEYS */;

-- Dumping structure for table note.note_info
CREATE TABLE IF NOT EXISTS `note_info` (
  `userid` varchar(50) NOT NULL,
  `noteid` varchar(50) NOT NULL DEFAULT uuid(),
  `bookname` varchar(50) NOT NULL,
  `notename` varchar(40) NOT NULL,
  `updateTime` int(11) NOT NULL DEFAULT 0,
  `isPublic` tinyint(4) NOT NULL DEFAULT 0,
  `content` text NOT NULL DEFAULT '',
  PRIMARY KEY (`noteid`),
  UNIQUE KEY `userid_bookname_notename` (`userid`,`bookname`,`notename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.note_info: ~5 rows (approximately)
/*!40000 ALTER TABLE `note_info` DISABLE KEYS */;
REPLACE INTO `note_info` (`userid`, `noteid`, `bookname`, `notename`, `updateTime`, `isPublic`, `content`) VALUES
	('public', '4dadb3c0-80fe-11ed-ae8e-54ee7577590e', 'default', 'aaa', 1671635307, 1, ''),
	('public', '725602c7-8101-11ed-ae8e-54ee7577590e', 'default', 'bbb', 1671636657, 1, ''),
	('public', 'be0ebe46-8165-11ed-ae8e-54ee7577590e', 'public', 'about', 1671679731, 1, ''),
	('public', 'index', 'public', 'index', 0, 0, '0'),
	('public', 'public', 'public', 'public', 0, 0, '0');
/*!40000 ALTER TABLE `note_info` ENABLE KEYS */;

-- Dumping structure for table note.resource_info
CREATE TABLE IF NOT EXISTS `resource_info` (
  `noteid` varchar(140) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `value` mediumblob DEFAULT NULL,
  `createTime` int(11) NOT NULL,
  PRIMARY KEY (`noteid`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping structure for table note.storage_info
CREATE TABLE IF NOT EXISTS `storage_info` (
  `bookname` varchar(50) NOT NULL,
  `userid` varchar(50) NOT NULL,
  PRIMARY KEY (`bookname`,`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.storage_info: ~3 rows (approximately)
/*!40000 ALTER TABLE `storage_info` DISABLE KEYS */;
REPLACE INTO `storage_info` (`bookname`, `userid`) VALUES
	('b1', 'public'),
	('default', 'public'),
	('public', 'public');
/*!40000 ALTER TABLE `storage_info` ENABLE KEYS */;

-- Dumping structure for table note.token_info
CREATE TABLE IF NOT EXISTS `token_info` (
  `token` varchar(50) NOT NULL DEFAULT uuid(),
  `userid` varchar(50) NOT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.token_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `token_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `token_info` ENABLE KEYS */;

-- Dumping structure for table note.user_info
CREATE TABLE IF NOT EXISTS `user_info` (
  `userid` varchar(50) NOT NULL DEFAULT uuid(),
  `email` varchar(50) NOT NULL DEFAULT '',
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL DEFAULT '',
  `drop` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`userid`) USING BTREE,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.user_info: ~5 rows (approximately)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
REPLACE INTO `user_info` (`userid`, `email`, `username`, `password`, `role`, `drop`) VALUES
	('1', '1', '1', '1', '', 0),
	('1e99ccfb-8172-11ed-ae8e-54ee7577590e', '', 'public2', 'public2', '', 0),
	('2', '2', '2', '2', '', 0),
	('eedd78c9-7c81-11ed-ac69-54ee7577590e', '12', 'hlpt2', '123', '', 0),
	('public', 'public', 'public', 'public', '', 0);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

-- Dumping structure for table note.watch
CREATE TABLE IF NOT EXISTS `watch` (
  `userid` varchar(50) NOT NULL,
  `targetid` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`,`targetid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table note.watch: ~0 rows (approximately)
/*!40000 ALTER TABLE `watch` DISABLE KEYS */;
/*!40000 ALTER TABLE `watch` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
