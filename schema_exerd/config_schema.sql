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

-- 테이블 zenca_meta.apigw_def 구조 내보내기
CREATE TABLE IF NOT EXISTS `apigw_def` (
  `APIGW_DEF_UID` int(11) NOT NULL AUTO_INCREMENT COMMENT '새 컬럼',
  `GROUP_NAME` varchar(255) DEFAULT NULL COMMENT '새 컬럼2',
  `GROUP_DESC` varchar(255) DEFAULT NULL COMMENT '새 컬럼3',
  PRIMARY KEY (`APIGW_DEF_UID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='새 테이블11';

-- 테이블 데이터 zenca_meta.apigw_def:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `apigw_def` DISABLE KEYS */;
INSERT INTO `apigw_def` (`APIGW_DEF_UID`, `GROUP_NAME`, `GROUP_DESC`) VALUES
	(1, 'test', 'test-application');
/*!40000 ALTER TABLE `apigw_def` ENABLE KEYS */;

-- 테이블 zenca_meta.apigw_method 구조 내보내기
CREATE TABLE IF NOT EXISTS `apigw_method` (
  `APIGW_METHOD_UID` int(11) NOT NULL AUTO_INCREMENT COMMENT '새 컬럼',
  `METHOD` varchar(255) DEFAULT NULL COMMENT '새 컬럼2',
  PRIMARY KEY (`APIGW_METHOD_UID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='새 테이블2';

-- 테이블 데이터 zenca_meta.apigw_method:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `apigw_method` DISABLE KEYS */;
INSERT INTO `apigw_method` (`APIGW_METHOD_UID`, `METHOD`) VALUES
	(1, 'GET'),
	(2, 'POST'),
	(3, 'PUT'),
	(4, 'DELETE'),
	(5, 'HEAD');
/*!40000 ALTER TABLE `apigw_method` ENABLE KEYS */;

-- 테이블 zenca_meta.apigw_spec 구조 내보내기
CREATE TABLE IF NOT EXISTS `apigw_spec` (
  `APIGW_SPEC_UID` int(11) NOT NULL AUTO_INCREMENT COMMENT '새 컬럼',
  `API_PATH` varchar(255) DEFAULT NULL COMMENT '새 컬럼2',
  `ENDPOINT_URI` varchar(255) DEFAULT NULL COMMENT '새 컬럼3',
  `APIGW_METHOD_UID` int(11) DEFAULT NULL COMMENT '새 컬럼4',
  `APIGW_DEF_UID` int(11) DEFAULT NULL COMMENT '새 컬럼5',
  PRIMARY KEY (`APIGW_SPEC_UID`),
  KEY `FK_APIGW_METHOD_TO_APIGW_SPEC` (`APIGW_METHOD_UID`),
  KEY `FK_APIGW_DEF_TO_APIGW_SPEC` (`APIGW_DEF_UID`),
  CONSTRAINT `FK_APIGW_DEF_TO_APIGW_SPEC` FOREIGN KEY (`APIGW_DEF_UID`) REFERENCES `apigw_def` (`APIGW_DEF_UID`),
  CONSTRAINT `FK_APIGW_METHOD_TO_APIGW_SPEC` FOREIGN KEY (`APIGW_METHOD_UID`) REFERENCES `apigw_method` (`APIGW_METHOD_UID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='새 테이블8';

-- 테이블 데이터 zenca_meta.apigw_spec:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `apigw_spec` DISABLE KEYS */;
INSERT INTO `apigw_spec` (`APIGW_SPEC_UID`, `API_PATH`, `ENDPOINT_URI`, `APIGW_METHOD_UID`, `APIGW_DEF_UID`) VALUES
	(1, '/v1/test/*', 'http://localhost:9011', 1, 1);
/*!40000 ALTER TABLE `apigw_spec` ENABLE KEYS */;

-- 테이블 zenca_meta.cfg_apigw 구조 내보내기
CREATE TABLE IF NOT EXISTS `cfg_apigw` (
  `CFG_APIGW_UID` int(11) NOT NULL AUTO_INCREMENT COMMENT '새 컬럼',
  `PROP_KEY` varchar(255) DEFAULT NULL COMMENT '새 컬럼2',
  `PROP_VALUE` varchar(255) DEFAULT NULL COMMENT '새 컬럼3',
  `CFG_GROUP_UID` int(11) DEFAULT NULL COMMENT 'CFG_COMMON_UID',
  `APIGW_SPEC_UID` int(11) DEFAULT NULL COMMENT '새 컬럼4',
  PRIMARY KEY (`CFG_APIGW_UID`),
  KEY `FK_CFG_GROUP_TO_CFG_APIGW` (`CFG_GROUP_UID`),
  KEY `FK_APIGW_SPEC_TO_CFG_APIGW` (`APIGW_SPEC_UID`),
  CONSTRAINT `FK_APIGW_SPEC_TO_CFG_APIGW` FOREIGN KEY (`APIGW_SPEC_UID`) REFERENCES `apigw_spec` (`APIGW_SPEC_UID`),
  CONSTRAINT `FK_CFG_GROUP_TO_CFG_APIGW` FOREIGN KEY (`CFG_GROUP_UID`) REFERENCES `cfg_group` (`CFG_GROUP_UID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='새 테이블3';

-- 테이블 데이터 zenca_meta.cfg_apigw:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `cfg_apigw` DISABLE KEYS */;
INSERT INTO `cfg_apigw` (`CFG_APIGW_UID`, `PROP_KEY`, `PROP_VALUE`, `CFG_GROUP_UID`, `APIGW_SPEC_UID`) VALUES
	(1, 'zuul.routes.test-get.stripPrefix', 'false', 2, 1),
	(2, 'zuul.routes.test-get.path', '/v1/test/*', 2, 1),
	(3, 'zuul.routes.test-get.url', 'http://localhost:9011', 2, 1);
/*!40000 ALTER TABLE `cfg_apigw` ENABLE KEYS */;

-- 테이블 zenca_meta.cfg_common 구조 내보내기
CREATE TABLE IF NOT EXISTS `cfg_common` (
  `CFG_PROP_UID` int(11) NOT NULL AUTO_INCREMENT COMMENT '새 컬럼',
  `PROP_KEY` varchar(255) DEFAULT NULL COMMENT '새 컬럼2',
  `PROP_VALUE` varchar(255) DEFAULT NULL COMMENT '새 컬럼3',
  `CFG_GROUP_UID` int(11) DEFAULT NULL COMMENT 'CFG_COMMON_UID',
  PRIMARY KEY (`CFG_PROP_UID`),
  KEY `FK_CFG_GROUP_TO_CFG_COMMON` (`CFG_GROUP_UID`),
  CONSTRAINT `FK_CFG_GROUP_TO_CFG_COMMON` FOREIGN KEY (`CFG_GROUP_UID`) REFERENCES `cfg_group` (`CFG_GROUP_UID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='새 테이블';

-- 테이블 데이터 zenca_meta.cfg_common:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `cfg_common` DISABLE KEYS */;
INSERT INTO `cfg_common` (`CFG_PROP_UID`, `PROP_KEY`, `PROP_VALUE`, `CFG_GROUP_UID`) VALUES
	(1, 'meta.database.host', '127.0.0.1', 1),
	(2, 'meta.database.port', '3306', 1);
/*!40000 ALTER TABLE `cfg_common` ENABLE KEYS */;

-- 테이블 zenca_meta.cfg_group 구조 내보내기
CREATE TABLE IF NOT EXISTS `cfg_group` (
  `CFG_GROUP_UID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'CFG_COMMON_UID',
  `APPLICATION` varchar(255) DEFAULT NULL COMMENT 'APPLICATION',
  `PROFILE` varchar(255) DEFAULT NULL COMMENT 'PROFILE',
  `LABEL` varchar(255) DEFAULT NULL COMMENT 'LABEL',
  PRIMARY KEY (`CFG_GROUP_UID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='CFG_COMMON';

-- 테이블 데이터 zenca_meta.cfg_group:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `cfg_group` DISABLE KEYS */;
INSERT INTO `cfg_group` (`CFG_GROUP_UID`, `APPLICATION`, `PROFILE`, `LABEL`) VALUES
	(1, 'common', 'dev', 'master'),
	(2, 'api-gateway', 'dev', 'master');
/*!40000 ALTER TABLE `cfg_group` ENABLE KEYS */;

-- 테이블 zenca_meta.int_intf 구조 내보내기
CREATE TABLE IF NOT EXISTS `int_intf` (
  `INT_INTF_UID` int(11) NOT NULL AUTO_INCREMENT COMMENT '새 컬럼',
  `INTF_NAME` varchar(255) DEFAULT NULL COMMENT '새 컬럼2',
  `INTF_DESC` varchar(2048) DEFAULT NULL COMMENT '새 컬럼3',
  `INT_PROJECT_UID` int(11) DEFAULT NULL COMMENT '새 컬럼4',
  `INT_INTF_TYPE_UID` int(11) DEFAULT NULL COMMENT '새 컬럼5',
  PRIMARY KEY (`INT_INTF_UID`),
  KEY `FK_INT_PROJECT_TO_INT_INTF` (`INT_PROJECT_UID`),
  KEY `FK_INT_INTF_TYPE_TO_INT_INTF` (`INT_INTF_TYPE_UID`),
  CONSTRAINT `FK_INT_INTF_TYPE_TO_INT_INTF` FOREIGN KEY (`INT_INTF_TYPE_UID`) REFERENCES `int_intf_type` (`INT_INTF_TYPE_UID`),
  CONSTRAINT `FK_INT_PROJECT_TO_INT_INTF` FOREIGN KEY (`INT_PROJECT_UID`) REFERENCES `int_project` (`INT_PROJECT_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='새 테이블6';

-- 테이블 데이터 zenca_meta.int_intf:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `int_intf` DISABLE KEYS */;
/*!40000 ALTER TABLE `int_intf` ENABLE KEYS */;

-- 테이블 zenca_meta.int_intf_api_map 구조 내보내기
CREATE TABLE IF NOT EXISTS `int_intf_api_map` (
  `INT_INTF_UID` int(11) DEFAULT NULL COMMENT '새 컬럼2',
  `CFG_APIGW_UID` int(11) DEFAULT NULL COMMENT '새 컬럼',
  KEY `FK_INT_INTF_TO_INT_INTF_API_MAP` (`INT_INTF_UID`),
  KEY `FK_CFG_APIGW_TO_INT_INTF_API_MAP` (`CFG_APIGW_UID`),
  CONSTRAINT `FK_CFG_APIGW_TO_INT_INTF_API_MAP` FOREIGN KEY (`CFG_APIGW_UID`) REFERENCES `cfg_apigw` (`CFG_APIGW_UID`),
  CONSTRAINT `FK_INT_INTF_TO_INT_INTF_API_MAP` FOREIGN KEY (`INT_INTF_UID`) REFERENCES `int_intf` (`INT_INTF_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='새 테이블5';

-- 테이블 데이터 zenca_meta.int_intf_api_map:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `int_intf_api_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `int_intf_api_map` ENABLE KEYS */;

-- 테이블 zenca_meta.int_intf_type 구조 내보내기
CREATE TABLE IF NOT EXISTS `int_intf_type` (
  `INT_INTF_TYPE_UID` int(11) NOT NULL AUTO_INCREMENT COMMENT '새 컬럼',
  `TYPE_NAME` varchar(255) DEFAULT NULL COMMENT '새 컬럼2',
  `TYPE_DESC` varchar(2048) DEFAULT NULL COMMENT '새 컬럼3',
  PRIMARY KEY (`INT_INTF_TYPE_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='새 테이블7';

-- 테이블 데이터 zenca_meta.int_intf_type:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `int_intf_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `int_intf_type` ENABLE KEYS */;

-- 테이블 zenca_meta.int_project 구조 내보내기
CREATE TABLE IF NOT EXISTS `int_project` (
  `INT_PROJECT_UID` int(11) NOT NULL AUTO_INCREMENT COMMENT '새 컬럼',
  `PROJECT_NAME` varchar(255) DEFAULT NULL COMMENT '새 컬럼2',
  `PROJECT_DESC` varchar(2048) DEFAULT NULL COMMENT '새 컬럼3',
  PRIMARY KEY (`INT_PROJECT_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='새 테이블4';

-- 테이블 데이터 zenca_meta.int_project:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `int_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `int_project` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
