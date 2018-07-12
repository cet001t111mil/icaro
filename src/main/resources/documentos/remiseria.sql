create database if not exists remiseria;
create user 'userRemiseria'@'localhost' identified by '1234';
grant all on remiseria.* to userRemiseria@localhost;

CREATE TABLE IF NOT EXISTS remiseria.Cliente (
  `id_cliente` INT(4) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `saldo` DOUBLE NULL,
  `limite_de_credito` DOUBLE NULL,
  `activo` bit(2) not null,
  PRIMARY KEY (`id_cliente`));
  


CREATE TABLE IF NOT EXISTS remiseria.TelefonoCliente (
  `cod_area` INT NOT NULL,
  `nro_telefono` INT NOT NULL,
  `id_cliente` INT(4) NOT NULL,
  PRIMARY KEY (`cod_area`, `nro_telefono`),
  CONSTRAINT `fk_TelefonoCliente_Cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `remiseria`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS remiseria.Vehiculo (
  `patente` VARCHAR(10) NOT NULL,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `anio` INT NULL,
  `en_viaje` BIT(2) NULL,
  `disponible` BIT(2) NOT NULL,
  `activo` bit(2) not null,
  PRIMARY KEY (`patente`));

CREATE TABLE IF NOT EXISTS remiseria.Empleado(
  `nro_legajo` INT(4) NOT NULL,
  `dni` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `sueldo` DOUBLE NULL,
  `comision` DOUBLE NULL,
  `tipo_empleado` VARCHAR(45) NULL,
  `activo` bit(2) not null,
  PRIMARY KEY (`nro_legajo`));


CREATE TABLE IF NOT EXISTS remiseria.MovimientoDeSaldo (
  `id_movimiento` INT(4) NOT NULL,
  `importe` DOUBLE NULL,
  `tipo_comprobante` VARCHAR(2) NULL,
  `id_cliente` INT(4) NOT NULL,
  PRIMARY KEY (`id_movimiento`),
  CONSTRAINT `fk_MovimientoDeSaldo_Cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `remiseria`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS remiseria.Viaje (
  `id_viaje` INT NOT NULL,
  `origen` VARCHAR(45) NOT NULL,
  `destino` VARCHAR(45) NULL,
  `fecha` DATE NOT NULL,
  `importe` DOUBLE NULL,
  `forma_de_pago` INT NULL,
  `patente` VARCHAR(10) NULL,
  `id_cliente` INT(4) NULL,
  `nro_legajo` INT (4) NULL,
   `activo` bit(2) not null,
  PRIMARY KEY (`id_viaje`),
  CONSTRAINT `fk_Viaje_Cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `remiseria`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Viaje_Vehiculo1`
    FOREIGN KEY (`patente`)
    REFERENCES `remiseria`.`Vehiculo` (`patente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Viaje_empleado`
    FOREIGN KEY (`nro_legajo`)
    REFERENCES `remiseria`.`Empleado` (`nro_legajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);