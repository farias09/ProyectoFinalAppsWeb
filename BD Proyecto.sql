/*Se crea la base de datos */
drop schema if exists ticorganiko;
drop user if exists usuario;
CREATE SCHEMA ticorganiko ;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario'@'%' identified by 'clave';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on ticorganiko.* to 'usuario'@'%';
flush privileges;

-- Crear la tabla de productos
CREATE TABLE ticorganiko.productos (
  id_producto INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(100) NOT NULL,
  codigo VARCHAR(10),
  precio DECIMAL(10, 2) NOT NULL,
  cantidad INT NOT NULL,
  promocion INT,
  activo BOOLEAN,
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_producto)
) ENGINE = InnoDB;

-- Crear la tabla de clientes
CREATE TABLE ticorganiko.clientes(
  id_cliente INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30),
  correo VARCHAR(50),
  numero_telefono INT NOT NULL,
  direccion VARCHAR(50),
  cedula INT NOT NULL,
  contraseña VARCHAR(15),
  activo BOOLEAN,
  PRIMARY KEY (id_cliente)
) ENGINE = InnoDB;

-- Crear la tabla de historial de compras de clientes
CREATE TABLE ticorganiko.historial_cliente (
    id_compra INT NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_factura INT NOT NULL,
    fecha_compra DATE,
    monto_total DECIMAL(10, 2),
    productos_comprados TEXT,
    PRIMARY KEY (id_compra),
    FOREIGN KEY (id_cliente) REFERENCES ticorganiko.clientes(id_cliente)
) ENGINE = InnoDB;

-- Crear la tabla de promociones
CREATE TABLE ticorganiko.promociones (
	id_promocion INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(30),
    precio DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL,
    activo BOOLEAN,
	ruta_imagen VARCHAR(1024),
	PRIMARY KEY (id_promocion)
) ENGINE = InnoDB;

CREATE TABLE ticorganiko.articulo (
  id_articulo INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(100) NOT NULL,
  codigo VARCHAR(10),
  precio DECIMAL(10, 2) NOT NULL,
  cantidad INT NOT NULL,
  promocion INT,
  activo BOOLEAN,
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_articulo)
) ENGINE = InnoDB;

/*create table ticorganiko.ventas (
  id_venta INT NOT NULL AUTO_INCREMENT,
  id_producto INT NOT NULL,
  total INT NOT NULL,
  confirmacion VARCHAR(20),
  fecha_venta date,
  PRIMARY KEY (id_producto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;*/
