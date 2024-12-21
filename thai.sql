-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.2.3-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for 40_05_nguyenquocthai_21135961
CREATE DATABASE IF NOT EXISTS `40_05_nguyenquocthai_21135961` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `40_05_nguyenquocthai_21135961`;

-- Dumping structure for table 40_05_nguyenquocthai_21135961.cuahang
CREATE TABLE IF NOT EXISTS `cuahang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table 40_05_nguyenquocthai_21135961.cuahang: ~0 rows (approximately)
INSERT INTO `cuahang` (`id`, `ten`) VALUES
	(1, 'ThaiPhone'),
	(2, 'ThinhPhone');

-- Dumping structure for table 40_05_nguyenquocthai_21135961.donhang
CREATE TABLE IF NOT EXISTS `donhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `ma_don_hang` varchar(255) NOT NULL,
  `ngay_dat_hang` date DEFAULT NULL,
  `ten_khach_hang` varchar(50) NOT NULL,
  `ten_sp` varchar(255) NOT NULL,
  `trang_thai` bit(1) NOT NULL,
  `machf` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk07b7axksihf9sctoh65ch4tb` (`machf`),
  CONSTRAINT `FKk07b7axksihf9sctoh65ch4tb` FOREIGN KEY (`machf`) REFERENCES `cuahang` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table 40_05_nguyenquocthai_21135961.donhang: ~4 rows (approximately)
INSERT INTO `donhang` (`id`, `email`, `ma_don_hang`, `ngay_dat_hang`, `ten_khach_hang`, `ten_sp`, `trang_thai`, `machf`) VALUES
	(1, 'thai@gmail.com', 'DH1', '2024-12-15', 'Nguyễn Quốc Thái', 'Sam Sung', b'1', 1),
	(2, 'tin@gmail.com', 'DH2', '2024-12-15', 'Võ nhật tín', 'Apple', b'1', 1),
	(3, 'thinh@gmail.com', 'DH3', '2024-12-15', 'Hồ Huỳnh Hoài Thịnh', 'Xiaomi', b'1', 2),
	(4, 'huy@gmail.com', 'DH4', '2024-12-15', 'Nguyễn Hoàng Huy', 'Google', b'1', 2),
	(5, 'email@gmail.com', '20241221052813', '2025-01-01', 'Nguyen Xuan Ky', 'gáo nước mưa', b'0', 1),
	(7, 'hongvu@gmail.com', '20241221062810', '2024-12-25', 'thịnh boo', 'Iphone 100', b'0', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
