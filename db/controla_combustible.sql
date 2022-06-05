/*
 Navicat Premium Data Transfer

 Source Server         : mysql-local
 Source Server Type    : MySQL
 Source Server Version : 100140
 Source Host           : localhost:3306
 Source Schema         : controla_combustible

 Target Server Type    : MySQL
 Target Server Version : 100140
 File Encoding         : 65001

 Date: 05/06/2022 14:45:10
*/
CREATE DATABASE IF NOT EXISTS controla_combustible;

USE controla_combustible;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for almacenes
-- ----------------------------
DROP TABLE IF EXISTS `almacenes`;
CREATE TABLE `almacenes`  (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'PK, Identificador correlativo',
  `nombre` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Nombre de almacén',
  `direccion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Dirección',
  `estado` tinyint(4) NULL DEFAULT NULL COMMENT 'Estado de ítem',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for catalogo_cargos
-- ----------------------------
DROP TABLE IF EXISTS `catalogo_cargos`;
CREATE TABLE `catalogo_cargos`  (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'PK, Identificador correlativo',
  `nombre` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Nombre de ítem',
  `estado` tinyint(4) NULL DEFAULT NULL COMMENT 'Estado de ítem',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for catalogo_tipos_vehiculo
-- ----------------------------
DROP TABLE IF EXISTS `catalogo_tipos_vehiculo`;
CREATE TABLE `catalogo_tipos_vehiculo`  (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'PK, Identificador correlativo',
  `nombre` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Nombre de ítem',
  `estado` tinyint(4) NULL DEFAULT NULL COMMENT 'Estado de ítem',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for empleados
-- ----------------------------
DROP TABLE IF EXISTS `empleados`;
CREATE TABLE `empleados`  (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'PK, Identificador correlativo',
  `nombres` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Nombres',
  `paterno` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Apellido paterno',
  `materno` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Apellido materno',
  `ci` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Cédula de identidad',
  `fecha_nac` date NULL DEFAULT NULL COMMENT 'Fecha de nacimiento',
  `cargo_id` smallint(6) NULL DEFAULT NULL COMMENT 'FK, tabla: catalogo_cargos campo: id',
  `telefono` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Teléfono',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `emp_cargoid_fk`(`cargo_id`) USING BTREE,
  CONSTRAINT `emp_cargoid_fk` FOREIGN KEY (`cargo_id`) REFERENCES `catalogo_cargos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for entradas
-- ----------------------------
DROP TABLE IF EXISTS `entradas`;
CREATE TABLE `entradas`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK, Número de entrada',
  `fecha` date NULL DEFAULT NULL COMMENT 'Fecha',
  `hora` time(0) NULL DEFAULT NULL COMMENT 'Hora',
  `almacen_id` smallint(6) NULL DEFAULT NULL COMMENT 'FK, tabla: almacenes campo: id',
  `responsable_id` smallint(6) NULL DEFAULT NULL COMMENT 'FK, tabla: empleados campo: id',
  `proveedor_id` smallint(6) NULL DEFAULT NULL COMMENT 'FK, tabla: proveedores campo: id',
  `obs` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'Observación',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `entrada_almacenid_fk`(`almacen_id`) USING BTREE,
  INDEX `entrada_empleadoid_fk`(`responsable_id`) USING BTREE,
  INDEX `entrada_proveedorid_fk`(`proveedor_id`) USING BTREE,
  CONSTRAINT `entrada_almacenid_fk` FOREIGN KEY (`almacen_id`) REFERENCES `almacenes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `entrada_empleadoid_fk` FOREIGN KEY (`responsable_id`) REFERENCES `empleados` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `entrada_proveedorid_fk` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for entradas_detalle
-- ----------------------------
DROP TABLE IF EXISTS `entradas_detalle`;
CREATE TABLE `entradas_detalle`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK, Número de entrada',
  `entrada_id` int(11) NULL DEFAULT NULL COMMENT 'FK, tabla: entradas campo: id',
  `item_id` int(11) NULL DEFAULT NULL COMMENT 'FK, tabla: items campo: id',
  `cantidad` int(11) NULL DEFAULT NULL COMMENT 'Cantidad',
  `precio_unit` decimal(11, 2) NULL DEFAULT NULL COMMENT 'Precio unitario',
  `nro_factura` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Número de factura',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `entradadet_entradaid_fk`(`entrada_id`) USING BTREE,
  INDEX `entradadet_itemid_fk`(`item_id`) USING BTREE,
  CONSTRAINT `entradadet_entradaid_fk` FOREIGN KEY (`entrada_id`) REFERENCES `entradas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `entradadet_itemid_fk` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK, Identificador correlativo',
  `nombre` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Nombre de ítem',
  `unidad_medida` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'FK, tabla: catalogo_unidad_medida campo: id',
  `stock_min` int(11) NULL DEFAULT NULL COMMENT 'Cantidad mínima',
  `stock_actual` int(11) NULL DEFAULT NULL COMMENT 'Cantidad actual',
  `estado` tinyint(4) NULL DEFAULT NULL COMMENT 'Estado [0=Inactivo, 1=Activo]',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for proveedores
-- ----------------------------
DROP TABLE IF EXISTS `proveedores`;
CREATE TABLE `proveedores`  (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'PK, Identificador correlativo',
  `nombre` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Nombre',
  `fono_1` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Teléfono principal',
  `fono_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Teléfono secundario',
  `direccion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Dirección',
  `correo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Correo electrónico',
  `nit` int(11) NULL DEFAULT NULL COMMENT 'NIT',
  `rep_legal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Datos de representante legal',
  `rep_fono` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Teléfono de representante legal',
  `rep_direccion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Dirección representante legal',
  `obs` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'Observación',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for salidas
-- ----------------------------
DROP TABLE IF EXISTS `salidas`;
CREATE TABLE `salidas`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK, Número de entrada',
  `fecha` date NULL DEFAULT NULL COMMENT 'Fecha',
  `hora` time(0) NULL DEFAULT NULL COMMENT 'Hora',
  `almacen_id` smallint(6) NULL DEFAULT NULL COMMENT 'FK, tabla: almacenes campo: id',
  `empleado_id` smallint(6) NULL DEFAULT NULL COMMENT 'FK, tabla: empleados campo: id',
  `responsable_id` smallint(6) NULL DEFAULT NULL COMMENT 'FK, tabla: empleados campo: id',
  `vehiculo_id` smallint(6) NULL DEFAULT NULL COMMENT 'FK, tabla: vehiculos campo: id',
  `obs` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'Observación',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `salida_almacenid_fk`(`almacen_id`) USING BTREE,
  INDEX `salida_vehiculoid_fk`(`vehiculo_id`) USING BTREE,
  INDEX `salida_empleadoid_fk`(`empleado_id`) USING BTREE,
  INDEX `salida_responsableid_fk`(`responsable_id`) USING BTREE,
  CONSTRAINT `salida_almacenid_fk` FOREIGN KEY (`almacen_id`) REFERENCES `almacenes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `salida_empleadoid_fk` FOREIGN KEY (`empleado_id`) REFERENCES `empleados` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `salida_responsableid_fk` FOREIGN KEY (`responsable_id`) REFERENCES `empleados` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `salida_vehiculoid_fk` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for salidas_detalle
-- ----------------------------
DROP TABLE IF EXISTS `salidas_detalle`;
CREATE TABLE `salidas_detalle`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK, Número de entrada',
  `salida_id` int(11) NULL DEFAULT NULL COMMENT 'FK, tabla: entradas campo: id',
  `item_id` int(11) NULL DEFAULT NULL COMMENT 'FK, tabla: items campo: id',
  `cantidad` int(11) NULL DEFAULT NULL COMMENT 'Cantidad',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `salidadet_salidaid_fk`(`salida_id`) USING BTREE,
  INDEX `salidadet_itemid_fk`(`item_id`) USING BTREE,
  CONSTRAINT `salidadet_itemid_fk` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `salidadet_salidaid_fk` FOREIGN KEY (`salida_id`) REFERENCES `salidas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vehiculos
-- ----------------------------
DROP TABLE IF EXISTS `vehiculos`;
CREATE TABLE `vehiculos`  (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'PK, Identificador correlativo',
  `tipo_id` smallint(6) NULL DEFAULT NULL COMMENT 'FK, tabla: catalogo_tipos_vehiculo campo: id',
  `marca` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Marca',
  `modelo` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Modelo',
  `placa` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Placa',
  `tipo_combustible` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Tipo de combustible utilizado',
  `estado` tinyint(4) NULL DEFAULT NULL COMMENT 'Estado [0=Inactivo, 1=Activo]',
  `creado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Creado por usuario',
  `actualizado_por` smallint(6) NULL DEFAULT NULL COMMENT 'Actualizado por usuario',
  `fecha_creacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de creación',
  `fecha_actualizacion` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'Fecha y hora de actualización',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `veh_tipoid_fk`(`tipo_id`) USING BTREE,
  CONSTRAINT `veh_tipoid_fk` FOREIGN KEY (`tipo_id`) REFERENCES `catalogo_tipos_vehiculo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
