-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-04-2016 a las 23:38:49
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `db_farmacia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_bodega`
--

CREATE TABLE IF NOT EXISTS `tbl_bodega` (
  `codigo_bodega` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_medicina` varchar(45) NOT NULL,
  `medicina_faltante` varchar(45) NOT NULL,
  `cantidad_vencidos` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_bodega`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_bodeguero`
--

CREATE TABLE IF NOT EXISTS `tbl_bodeguero` (
  `id_bodeguero` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(70) NOT NULL,
  `apellidos` varchar(70) NOT NULL,
  `genero` varchar(2) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `numero_identidad` varchar(14) NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `codigo_bodega` int(11) NOT NULL,
  PRIMARY KEY (`id_bodeguero`),
  KEY `fk_tbl_bodeguero_tbl_bodega1_idx` (`codigo_bodega`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cliente`
--

CREATE TABLE IF NOT EXISTS `tbl_cliente` (
  `codigo_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cliente` varchar(45) NOT NULL,
  `telefono_cliente` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `identidad` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `correo_electronico` varchar(45) NOT NULL,
  `tbl_clientecol` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_descripcion`
--

CREATE TABLE IF NOT EXISTS `tbl_descripcion` (
  `codigo_descripcion` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_factura` int(11) NOT NULL,
  `codigo_medicamento` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `total` decimal(10,0) NOT NULL,
  PRIMARY KEY (`codigo_descripcion`),
  KEY `fk_tbl_descripcion_tbls_Factura1_idx` (`codigo_factura`),
  KEY `fk_tbl_descripcion_tbl_medicamento1_idx` (`codigo_medicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_distribuidora`
--

CREATE TABLE IF NOT EXISTS `tbl_distribuidora` (
  `codigo_distribuidora` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_distribuidora` varchar(45) NOT NULL,
  `direccion_distribuidora` varchar(45) NOT NULL,
  `correo_distribuidora` varchar(45) NOT NULL,
  `telefono_distribuidora` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_distribuidora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_fabricante`
--

CREATE TABLE IF NOT EXISTS `tbl_fabricante` (
  `codigo_fabricante` int(11) NOT NULL AUTO_INCREMENT,
  `direccion_fabricante` varchar(45) NOT NULL,
  `correo_fabricante` varchar(45) NOT NULL,
  `telefono_fabricante` varchar(45) NOT NULL,
  `nombre_fabricante` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_fabricante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_factura`
--

CREATE TABLE IF NOT EXISTS `tbl_factura` (
  `tbl_Factura` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_farmacia` int(11) NOT NULL,
  `codigo_bodega` int(11) NOT NULL,
  `codigo_cliente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  `isv` double NOT NULL,
  `total_pagar` double NOT NULL,
  `tipo_pago` varchar(45) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  PRIMARY KEY (`tbl_Factura`),
  KEY `fk_tbls_Factura_tbl_farmacia1_idx` (`codigo_farmacia`),
  KEY `fk_tbls_Factura_tbl_bodega1_idx` (`codigo_bodega`),
  KEY `fk_tbls_Factura_tbl_cliente1_idx` (`codigo_cliente`),
  KEY `fk_tbl_Factura_tbl_vendedor1_idx` (`id_vendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_farmacia`
--

CREATE TABLE IF NOT EXISTS `tbl_farmacia` (
  `codigo_farmacia` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_bodega` int(11) NOT NULL,
  `nombre_farmacia` varchar(45) NOT NULL,
  `direccion_farmacia` varchar(45) NOT NULL,
  `correo_farmacia` varchar(45) NOT NULL,
  `telefono_farmacia` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_farmacia`),
  KEY `fk_tbl_farmacia_tbl_bodega1_idx` (`codigo_bodega`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_lote`
--

CREATE TABLE IF NOT EXISTS `tbl_lote` (
  `codigo_lote` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_medicamento` int(11) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  PRIMARY KEY (`codigo_lote`),
  KEY `fk_tbl_lote_tbl_medicamento1_idx` (`codigo_medicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_medicamento`
--

CREATE TABLE IF NOT EXISTS `tbl_medicamento` (
  `codigo_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_distribuidora` int(11) NOT NULL,
  `codigo_fabricante` int(11) NOT NULL,
  `id_tipo_medicamento` int(11) NOT NULL,
  `nombre_medicamento` varchar(45) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`codigo_medicamento`),
  KEY `fk_tbl_medicamento_tbl_fabricante1_idx` (`codigo_fabricante`),
  KEY `fk_tbl_medicamento_tbl_distribuidora1_idx` (`codigo_distribuidora`),
  KEY `fk_tbl_medicamento_tbl_tipo_medicamento1_idx` (`id_tipo_medicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_supervisor_bodega`
--

CREATE TABLE IF NOT EXISTS `tbl_supervisor_bodega` (
  `id_supervisor_bodega` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(70) NOT NULL,
  `apellidos` varchar(70) NOT NULL,
  `genero` varchar(2) NOT NULL,
  `edad` int(11) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `numero_identidad` varchar(14) NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `codigo_bodega` int(11) NOT NULL,
  PRIMARY KEY (`id_supervisor_bodega`),
  KEY `fk_tbl_supervisor_bodega_tbl_bodega1_idx` (`codigo_bodega`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_supervisor_ventas`
--

CREATE TABLE IF NOT EXISTS `tbl_supervisor_ventas` (
  `id_supervisor_ventas` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(70) NOT NULL,
  `apellidos` varchar(70) NOT NULL,
  `genero` varchar(2) NOT NULL,
  `edad` int(11) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `numero_identidad` varchar(14) NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `codigo_farmacia` int(11) NOT NULL,
  PRIMARY KEY (`id_supervisor_ventas`),
  KEY `fk_tbl_supervisor_ventas_tbl_farmacia1_idx` (`codigo_farmacia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_super_usuario`
--

CREATE TABLE IF NOT EXISTS `tbl_super_usuario` (
  `id_super_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(70) NOT NULL,
  `apellidos` varchar(70) NOT NULL,
  `genero` varchar(2) NOT NULL,
  `edad` int(11) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `numero_identidad` varchar(14) NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_super_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_tipo_medicamento`
--

CREATE TABLE IF NOT EXISTS `tbl_tipo_medicamento` (
  `id_tipo_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_medicamento` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_medicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_vendedor`
--

CREATE TABLE IF NOT EXISTS `tbl_vendedor` (
  `id_vendedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(70) NOT NULL,
  `apellidos` varchar(70) NOT NULL,
  `genero` varchar(2) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `numero_identidad` varchar(14) NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `codigo_farmacia` int(11) NOT NULL,
  PRIMARY KEY (`id_vendedor`),
  KEY `fk_tbl_vendedor_tbl_farmacia1_idx` (`codigo_farmacia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_bodeguero`
--
ALTER TABLE `tbl_bodeguero`
  ADD CONSTRAINT `fk_tbl_bodeguero_tbl_bodega1` FOREIGN KEY (`codigo_bodega`) REFERENCES `tbl_bodega` (`codigo_bodega`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_descripcion`
--
ALTER TABLE `tbl_descripcion`
  ADD CONSTRAINT `fk_tbl_descripcion_tbls_Factura1` FOREIGN KEY (`codigo_factura`) REFERENCES `tbl_factura` (`tbl_Factura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_descripcion_tbl_medicamento1` FOREIGN KEY (`codigo_medicamento`) REFERENCES `tbl_medicamento` (`codigo_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_factura`
--
ALTER TABLE `tbl_factura`
  ADD CONSTRAINT `fk_tbls_Factura_tbl_farmacia1` FOREIGN KEY (`codigo_farmacia`) REFERENCES `tbl_farmacia` (`codigo_farmacia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbls_Factura_tbl_bodega1` FOREIGN KEY (`codigo_bodega`) REFERENCES `tbl_bodega` (`codigo_bodega`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbls_Factura_tbl_cliente1` FOREIGN KEY (`codigo_cliente`) REFERENCES `tbl_cliente` (`codigo_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_Factura_tbl_vendedor1` FOREIGN KEY (`id_vendedor`) REFERENCES `tbl_vendedor` (`id_vendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_farmacia`
--
ALTER TABLE `tbl_farmacia`
  ADD CONSTRAINT `fk_tbl_farmacia_tbl_bodega1` FOREIGN KEY (`codigo_bodega`) REFERENCES `tbl_bodega` (`codigo_bodega`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_lote`
--
ALTER TABLE `tbl_lote`
  ADD CONSTRAINT `fk_tbl_lote_tbl_medicamento1` FOREIGN KEY (`codigo_medicamento`) REFERENCES `tbl_medicamento` (`codigo_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_medicamento`
--
ALTER TABLE `tbl_medicamento`
  ADD CONSTRAINT `fk_tbl_medicamento_tbl_fabricante1` FOREIGN KEY (`codigo_fabricante`) REFERENCES `tbl_fabricante` (`codigo_fabricante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_medicamento_tbl_distribuidora1` FOREIGN KEY (`codigo_distribuidora`) REFERENCES `tbl_distribuidora` (`codigo_distribuidora`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_medicamento_tbl_tipo_medicamento1` FOREIGN KEY (`id_tipo_medicamento`) REFERENCES `tbl_tipo_medicamento` (`id_tipo_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_supervisor_bodega`
--
ALTER TABLE `tbl_supervisor_bodega`
  ADD CONSTRAINT `fk_tbl_supervisor_bodega_tbl_bodega1` FOREIGN KEY (`codigo_bodega`) REFERENCES `tbl_bodega` (`codigo_bodega`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_supervisor_ventas`
--
ALTER TABLE `tbl_supervisor_ventas`
  ADD CONSTRAINT `fk_tbl_supervisor_ventas_tbl_farmacia1` FOREIGN KEY (`codigo_farmacia`) REFERENCES `tbl_farmacia` (`codigo_farmacia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_vendedor`
--
ALTER TABLE `tbl_vendedor`
  ADD CONSTRAINT `fk_tbl_vendedor_tbl_farmacia1` FOREIGN KEY (`codigo_farmacia`) REFERENCES `tbl_farmacia` (`codigo_farmacia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
