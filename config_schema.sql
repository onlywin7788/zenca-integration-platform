-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.5-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 zenca.config 구조 내보내기
CREATE TABLE IF NOT EXISTS `config` (
  `APP_CONFIG_UID` int(11) NOT NULL AUTO_INCREMENT,
  `APPLICATION` varchar(200) NOT NULL,
  `PROFILE` varchar(50) DEFAULT NULL,
  `LABEL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`APP_CONFIG_UID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 테이블 데이터 zenca.config:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` (`APP_CONFIG_UID`, `APPLICATION`, `PROFILE`, `LABEL`) VALUES
	(1, 'zenca', 'test', 'master'),
	(2, 'api-gateway', 'dev', 'master'),
	(3, 'service', 'dev', 'master');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;

-- 테이블 zenca.config_properties 구조 내보내기
CREATE TABLE IF NOT EXISTS `config_properties` (
  `APP_CONFIG_UID` int(11) DEFAULT NULL,
  `NAME` varchar(200) DEFAULT NULL,
  `VALUE` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 zenca.config_properties:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `config_properties` DISABLE KEYS */;
INSERT INTO `config_properties` (`APP_CONFIG_UID`, `NAME`, `VALUE`) VALUES
	(1, 'conn.host', '127.0.0.1'),
	(1, 'conn.port', '33308'),
	(2, 'zuul.routes.test.stripPrefix', 'false'),
	(2, 'zuul.routes.test.path', '/v1/test/**'),
	(2, 'zuul.routes.test.url', 'http://localhost:9011'),
	(3, 'service.interface.list.all', '{\r\n    "name": "interface1",\r\n    "family": "interface2",\r\n    "age": "interface3",\r\n    "weight": "interface4"\r\n}');
/*!40000 ALTER TABLE `config_properties` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
