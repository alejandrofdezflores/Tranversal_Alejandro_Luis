-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-03-2019 a las 17:20:22
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `transversal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_bin NOT NULL,
  `APELLIDO` varchar(30) COLLATE utf8_bin NOT NULL,
  `FECHA_NAC` date NOT NULL,
  `MEDIA` float(4,2) DEFAULT NULL,
  `APROBADO` tinyint(1) DEFAULT NULL,
  `ID_CLASE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`ID`, `NOMBRE`, `APELLIDO`, `FECHA_NAC`, `MEDIA`, `APROBADO`, `ID_CLASE`) VALUES
(1, 'Alejandro', 'Flores', '1997-11-28', 8.00, 1, 2),
(2, 'Luis', 'Garcia', '1997-05-02', 6.50, 1, 3),
(3, 'Guillermo', 'Tojar', '1996-09-10', 4.50, 0, 1),
(4, 'Ruben', 'Diaz', '1994-11-28', 3.90, 0, 2),
(5, 'Paula', 'Merayo', '1998-03-20', 7.00, 1, 3),
(6, 'David', 'Carrion', '1997-11-30', 3.50, 0, 2),
(7, 'David', 'Pociño', '1998-09-05', 6.00, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`ID`, `NOMBRE`) VALUES
(1, 'Acceso a datos'),
(2, 'Empresa iniciativa emprendedor'),
(3, 'Programación de servicios y pr'),
(4, 'Programacion de dispositivos m'),
(5, 'Desarrollo de interfaces'),
(6, 'Proyecto final');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clase`
--

CREATE TABLE `clase` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(20) COLLATE utf8_bin NOT NULL,
  `ID_PROFESOR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `clase`
--

INSERT INTO `clase` (`ID`, `NOMBRE`, `ID_PROFESOR`) VALUES
(1, 'Primero A', 2),
(2, 'Segundo A', 1),
(3, 'Segundo B', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imparte`
--

CREATE TABLE `imparte` (
  `ID_PROFESOR` int(11) NOT NULL,
  `ID_ASIGNATURA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `imparte`
--

INSERT INTO `imparte` (`ID_PROFESOR`, `ID_ASIGNATURA`) VALUES
(1, 2),
(2, 1),
(2, 6),
(3, 3),
(3, 4),
(3, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_bin NOT NULL,
  `APELLIDO` varchar(30) COLLATE utf8_bin NOT NULL,
  `FECHA_NAC` date NOT NULL,
  `TELEFONO` int(9) NOT NULL,
  `CORREO` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`ID`, `NOMBRE`, `APELLIDO`, `FECHA_NAC`, `TELEFONO`, `CORREO`) VALUES
(1, 'Encarna', 'Quesada', '1975-02-14', 666111444, 'encarna.quesada@campusfp.es'),
(2, 'Luis', 'De Blas', '1980-05-01', 777888555, 'luis.deblas@campusfp.es'),
(3, 'Patricia', 'Carrera', '1981-08-20', 611555999, 'patricia.carrera@campusfp.es');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiene`
--

CREATE TABLE `tiene` (
  `ID_CLASE` int(11) NOT NULL,
  `ID_ASIGNATURA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tiene`
--

INSERT INTO `tiene` (`ID_CLASE`, `ID_ASIGNATURA`) VALUES
(1, 1),
(1, 5),
(2, 2),
(2, 4),
(3, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_alumno_profesor` (`ID_CLASE`);

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `clase`
--
ALTER TABLE `clase`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_Profesor` (`ID_PROFESOR`);

--
-- Indices de la tabla `imparte`
--
ALTER TABLE `imparte`
  ADD PRIMARY KEY (`ID_PROFESOR`,`ID_ASIGNATURA`),
  ADD KEY `imparte_ibfk_2` (`ID_ASIGNATURA`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `tiene`
--
ALTER TABLE `tiene`
  ADD PRIMARY KEY (`ID_CLASE`,`ID_ASIGNATURA`),
  ADD KEY `tiene_ibfk_2` (`ID_ASIGNATURA`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `clase`
--
ALTER TABLE `clase`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `profesor`
--
ALTER TABLE `profesor`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `FKe61827gtcxg3ijufwor80kngc` FOREIGN KEY (`ID_CLASE`) REFERENCES `clase` (`ID`),
  ADD CONSTRAINT `fk_alumno_profesor` FOREIGN KEY (`ID_CLASE`) REFERENCES `clase` (`ID`);

--
-- Filtros para la tabla `imparte`
--
ALTER TABLE `imparte`
  ADD CONSTRAINT `FKgnruph5kld5gr851jbu7cb1uj` FOREIGN KEY (`ID_PROFESOR`) REFERENCES `profesor` (`ID`),
  ADD CONSTRAINT `FKrrqv0pkey40p08up41aniwyir` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `asignatura` (`ID`),
  ADD CONSTRAINT `imparte_ibfk_1` FOREIGN KEY (`ID_PROFESOR`) REFERENCES `profesor` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `imparte_ibfk_2` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `asignatura` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tiene`
--
ALTER TABLE `tiene`
  ADD CONSTRAINT `FK580xehl4pjlamxm0cgxuyan3u` FOREIGN KEY (`ID_CLASE`) REFERENCES `clase` (`ID`),
  ADD CONSTRAINT `FK9lhfl9tylraxh1rhljwo9ta3u` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `asignatura` (`ID`),
  ADD CONSTRAINT `tiene_ibfk_1` FOREIGN KEY (`ID_CLASE`) REFERENCES `clase` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tiene_ibfk_2` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `asignatura` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
