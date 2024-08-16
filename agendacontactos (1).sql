-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-08-2024 a las 06:24:17
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `agendacontactos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE `contacto` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `sobreNombre` varchar(20) DEFAULT NULL,
  `correo` varchar(20) DEFAULT NULL,
  `celular` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `contacto`
--

INSERT INTO `contacto` (`id`, `nombre`, `sobreNombre`, `correo`, `celular`) VALUES
(2, 'Ana', 'rojas', 'ana.garcia@example.c', '2345678901'),
(3, 'Pedro', 'López', 'pedro.lopez@example.', '3456789012'),
(4, 'Laura', 'Martínez', 'laura.martinez@examp', '4567890123'),
(5, 'Luis', 'Rodríguez', 'luis.rodriguez@examp', '5678901234'),
(6, 'María', 'González', 'maria.gonzalez@examp', '6789012345'),
(7, 'José', 'Hernández', 'jose.hernandez@examp', '7890123456'),
(8, 'Isabel', 'Martínez', 'isabel.martinez@exam', '8901234567'),
(9, 'Carlos', 'Ramírez', 'carlos.ramirez@examp', '9012345678'),
(10, 'Elena', 'Fernández', 'elena.fernandez@exam', '0123456789'),
(11, 'Andrés', 'Jiménez', 'andres.jimenez@examp', '1234509876'),
(12, 'Sofía', 'Vásquez', 'sofia.vasquez@exampl', '2345610987'),
(13, 'Diego', 'Paredes', 'diego.paredes@exampl', '3456721098'),
(14, 'Catalina', 'Moreno', 'catalina.moreno@exam', '4567832109'),
(15, 'Ricardo', 'Salazar', 'ricardo.salazar@exam', '5678943210'),
(16, 'Claudia', 'Cárdenas', 'claudia.cardenas@exa', '6789054321'),
(17, 'Felipe', 'Mendoza', 'felipe.mendoza@examp', '7890165432'),
(18, 'Valentina', 'García', 'valentina.garcia@exa', '8901276543'),
(19, 'Andrés', 'Torres', 'andres.torres@exampl', '9012387654'),
(20, 'Martina', 'Gómez', 'martina.gomez@exampl', '0123498765'),
(21, 'Sebastián', 'Ruiz', 'sebastian.ruiz@examp', '1234509876'),
(22, 'Laura', 'Pérez', 'laura.perez@example.', '2345610987'),
(23, 'Antonio', 'Hernández', 'antonio.hernandez@ex', '3456721098'),
(24, 'Gabriela', 'Sánchez', 'gabriela.sanchez@exa', '4567832109'),
(25, 'Nicolás', 'Gómez', 'nicolas.gomez@exampl', '5678943210'),
(26, 'Camila', 'Morales', 'camila.morales@examp', '6789054321'),
(27, 'Ricardo', 'Vega', 'ricardo.vega@example', '7890165432'),
(28, 'Manuela', 'García', 'manuela.garcia@examp', '8901276543'),
(29, 'Alejandro', 'Jaramillo', 'alejandro.jaramillo@', '9012387654'),
(30, 'Lucía', 'Castro', 'lucia.castro@example', '0123498765'),
(31, 'David', 'Ocampo', 'david.ocampo@example', '1234567891'),
(32, 'Natalia', 'Valencia', 'natalia.valencia@exa', '2345678902'),
(33, 'Jorge', 'Castaño', 'jorge.castano@exampl', '3456789013'),
(34, 'Isabella', 'Jiménez', 'isabella.jimenez@exa', '4567890124'),
(35, 'Luis', 'Vargas', 'luis.vargas@example.', '5678901235'),
(36, 'Mariana', 'Pinto', 'mariana.pinto@exampl', '6789012346'),
(37, 'Santiago', 'García', 'santiago.garcia@exam', '7890123457'),
(38, 'Alejandra', 'Serrano', 'alejandra.serrano@ex', '8901234568'),
(39, 'Carlos', 'González', 'carlos.gonzalez@exam', '9012345679'),
(40, 'Valeria', 'Ortega', 'valeria.ortega@examp', '0123456780'),
(41, 'Juan Pablo', 'Muñoz', 'juan.pablo@example.c', '1234509877'),
(42, 'Sara', 'Henao', 'sara.henao@example.c', '2345610988'),
(43, 'Tomás', 'Múnera', 'tomas.munera@example', '3456721099'),
(44, 'Catalina', 'García', 'catalina.garcia@exam', '4567832100'),
(45, 'Felipe', 'Tovar', 'felipe.tovar@example', '5678943211'),
(47, 'Diego', 'Bermúdez', 'diego.bermudez@examp', '7890165433'),
(48, 'Ana María', 'Castaño', 'ana.maria@example.co', '8901276544'),
(49, 'Óscar', 'Guerrero', 'oscar.guerrero@examp', '9012387655'),
(50, 'Robinson', 'Robinsito', 'robin@hot.com', '3127504269');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contacto`
--
ALTER TABLE `contacto`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
