-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.10.1-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para gardenn
CREATE DATABASE IF NOT EXISTS `gardenn` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gardenn`;

-- Volcando estructura para tabla gardenn.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `usuario` varchar(100) NOT NULL,
  `contraseña` varchar(100) DEFAULT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `direccion_cliente` varchar(1000) DEFAULT NULL,
  `premium` tinyint(4) DEFAULT NULL,
  `saldo` float DEFAULT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gardenn.cliente: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`usuario`, `contraseña`, `nombres`, `apellidos`, `telefono`, `direccion_cliente`, `premium`, `saldo`) VALUES
	('admin', 'admin1234', 'juan', 'hernnadez', '3054548696', 'casa balnca', 1, 800000),
	('adolfo', 'laura', 'adolfo', 'hernandez', '3052343555', 'el dorado', 1, 20000),
	('alquimista', 'admin', 'dayvi', 'cuatin osorio', '123456789', 'españa', 1, 800000),
	('daivi', 'pam', 'osorio', 'cuatin', '123456789', 'dorado', 1, 5000),
	('daivi osorio', 'admin', 'osorio', 'cuatin', '123456789', 'dorado', 1, 1000000),
	('daivis', 'admin', 'osorio', 'cua', '123456789', 'dorado', 1, 100000),
	('daiviss', 'pam', 'osorio', 'cuatin', '123456789', 'dorado', 1, 100000),
	('jhuly', 'urabe', 'jhulyana paola', 'hernandez diaz', '123456789', 'dorado', 0, 100),
	('maria alejandra', 'pan', 'maria alejandra', 'urueña alvaran', '3148631124', 'manizales', 1, 1000000),
	('pan', 'pantostado', NULL, NULL, NULL, NULL, NULL, 500),
	('urabe', 'admin', 'juan', 'hernandez', '12344567', 'aoifdianfdfd ', 1, 30000);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla gardenn.contrato
CREATE TABLE IF NOT EXISTS `contrato` (
  `id_contrato` int(11) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `id_inmueble` int(11) NOT NULL,
  `medio_de_pago` varchar(1000) NOT NULL,
  `tiempo_minimo_alquiler` int(11) NOT NULL,
  `fecha_alquiler` datetime NOT NULL,
  PRIMARY KEY (`id_contrato`,`id_inmueble`,`usuario`) USING BTREE,
  KEY `FK__cliente` (`usuario`),
  KEY `FK__inmueble` (`id_inmueble`),
  CONSTRAINT `FK__cliente` FOREIGN KEY (`usuario`) REFERENCES `cliente` (`usuario`),
  CONSTRAINT `FK__inmueble` FOREIGN KEY (`id_inmueble`) REFERENCES `inmueble` (`id_inmueble`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gardenn.contrato: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;

-- Volcando estructura para tabla gardenn.inmueble
CREATE TABLE IF NOT EXISTS `inmueble` (
  `id_inmueble` int(11) NOT NULL,
  `tipo_inmueble` varchar(100) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `habitaciones` int(11) DEFAULT NULL,
  `banos` int(11) DEFAULT NULL,
  `area_total` float DEFAULT NULL,
  `parqueadero` int(11) DEFAULT NULL,
  `direccion_inmueble` varchar(1000) DEFAULT NULL,
  `descripcion` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id_inmueble`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gardenn.inmueble: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
INSERT INTO `inmueble` (`id_inmueble`, `tipo_inmueble`, `precio`, `habitaciones`, `banos`, `area_total`, `parqueadero`, `direccion_inmueble`, `descripcion`) VALUES
	(1, 'Casa lotez', 550000, 2, 2, 500, 1, 'Vereda San jose, Calima el Darién, \r\nValle del Cauca', 'Propiedad rural, Casa con Lote ubicada en el Municipio de \r\nCalima el Darién, cuenta con 500m2 de extensión, casa construida, \r\nservicios de Agua incluido; a cargo del cliente  Luz, Gas, WiFi Y \r\ntelevisión por suscripción, zona de huerta y fogón de leña.'),
	(2, 'pam', 850000, 3, 2, 48, 2, 'Cra 12b # 8-37, Barrio el albergue,\r\nGuadalajara de Buga, Valle del cauca', 'Casa 2 pisos, 3 alcobas, 2 baños, \r\nsala de estar, zona de parqueadero, zona urbana a 10 minutos del centro de Buga, patio de ropas.\r\nServicios a Cargo del cliente.'),
	(3, 'Apartaestudio', 450000, 1, 2, 24, 2, 'Cra 11 #53 - 53 sur, Barrio \r\nTunjuelito, Bogotá, Cundinamarca.', 'Apartaestudio, 1 habitación, un baño, sala de estar.'),
	(4, 'Apartamento', 500000, 2, 1, 48, 1, 'Av Calle 48Q sur # 4 - 28 int 2 apto 401, \r\nBarrio Molinos II, Bogotá, Cundinamarca.', 'Apartamento 4 piso,\r\n 2 habitaciones, 1 baño,sala de estar'),
	(5, 'Casa condominio', 1800000, 4, 5, 600, 0, 'Condominio Ritz, vereda llanitos,\r\n  Cali, Valle del Cauca.', 'Casa lote, con piscina, zona de asados, \r\n  3 parqueaderos, casa de 2 pisos, 4 habitaciones, 5 baños, patio de ropas, \r\n  sala, comedor, Jacuzzi. Servicio de agua y administración incluido.'),
	(6, 'apartamento', 800000, 7, 2, 56, 3, 'bomito', 'pam');
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
