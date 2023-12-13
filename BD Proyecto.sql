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
  nombre VARCHAR(30) NOT NULL,
  codigo VARCHAR(10),
  precio DECIMAL(10, 2) NOT NULL,
  cantidad INT NOT NULL,
  promocion INT,
  activo BOOLEAN,
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_producto)
) ENGINE = InnoDB;

-- Crear la tabla de clientes
CREATE TABLE ticorganiko.cliente (
  id_cliente INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30),
  correo VARCHAR(30),
  numero_telefono INT NOT NULL,
  direccion VARCHAR(50),
  cedula INT NOT NULL,
  username VARCHAR(15),
  password VARCHAR(512),
  ruta_imagen VARCHAR(1024),
  activo BOOLEAN,
  PRIMARY KEY (id_cliente))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- Crear la tabla de facturas
CREATE TABLE ticorganiko.facturas (
  id_factura INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  fecha DATE,
  total DECIMAL(10, 2),
  estado INT,
  PRIMARY KEY (id_factura),
  FOREIGN KEY fk_factura_cliente (id_cliente) REFERENCES cliente(id_cliente)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- Crear la tabla de historial de compras de clientes
CREATE TABLE ticorganiko.historial_cliente (
  id_compra INT NOT NULL AUTO_INCREMENT,
  id_factura INT NOT NULL,
  fecha_compra DATE,
  monto_total DECIMAL(10, 2),
  productos_comprados TEXT,
  PRIMARY KEY (id_compra),
  FOREIGN KEY (id_factura) REFERENCES ticorganiko.facturas(id_factura))
ENGINE = InnoDB
CHARACTER SET = utf8mb4;

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

create table ticorganiko.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_cliente int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_cliente (id_cliente) references cliente(id_cliente)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO ticorganiko.cliente (id_cliente, nombre, correo, numero_telefono, direccion, cedula, username, password, ruta_imagen, activo) VALUES
(1, 'Juan Carlos Morales Silva', 'Juan1234@gmail.com', 123456789, 'Dirección del Admin', 184720483, 'juan12', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://th.bing.com/th/id/OIP.GyMB5gJgjcN3koFUW6TRPwHaHa?w=500&h=500&rs=1&pid=ImgDetMain', true),
(2, 'Ana María Silva Flores', 'Ana5322@gmail.com', 12345678, 'Dirección del Admin', 123456789, 'ana_maria53', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VM', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(3, 'Isabella Ruiz Vargas', 'Isabella1732@gmail.com', 123456789, 'Dirección del Admin', 123456789, 'isabella17', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(4, 'Adrian García López', 'Adrian9472@gmail.com', 123456789, 'Dirección del Admin', 123456789, 'adrian94', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(5, 'Valentina Rodríguez Mendoza', 'Valentina4723@gmail.com', 123456789, 'Dirección del Admin', 123456789, 'valentina47', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(6, 'Daniel Castro Jiménez', 'Daniel4726@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'daniel14', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(7, 'Sofia Díaz Ramírez', 'Sofia9214@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'sofia92', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(8, 'Marcos Camacho Arguedas', 'Marcos3746@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'marcos37', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(9, 'Alberto Carballo Hernandez', 'Alberto8362@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'alberto83', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(10, 'Natalia Flores González', 'Natalia8273@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'natalia82', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(11, 'Andres Herrera Ruiz', 'Andres2341@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'andres23', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(12, 'Javier Torres Martínez', 'Javier2936@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'javier29', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(13, 'Lucia Ramírez González', 'Lucia7362@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'lucia73', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(14, 'Eduardo González Pérez', 'Eduardo9428@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'eduardo94', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true),
(15, 'Laura Sánchez García', 'Laura2345@gmail.com', 123456789, 'Dirección del Cliente', 123456789, 'laura23', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg', true);

INSERT INTO ticorganiko.rol (id_rol, nombre, id_cliente) VALUES 
(1,'ROLE_ADMIN',1), (2,'ROLE_USER',1),
(3,'ROLE_ADMIN',2), (4,'ROLE_USER',2),
(5,'ROLE_ADMIN',3), (6,'ROLE_USER',3),
(7,'ROLE_ADMIN',4), (8,'ROLE_USER',4),
(9,'ROLE_ADMIN',5), (10,'ROLE_USER',5),
(11,'ROLE_USER',6),
(12,'ROLE_USER',7),
(13,'ROLE_USER',8),
(14,'ROLE_USER',9),
(15,'ROLE_USER',10),
(16,'ROLE_USER',11),
(17,'ROLE_USER',12),
(18,'ROLE_USER',13),
(19,'ROLE_USER',14),
(20,'ROLE_USER',15);

SELECT * FROM ticorganiko.cliente ;
SELECT * FROM ticorganiko.rol ;

/*create table ticorganiko.ventas (
  id_venta INT NOT NULL AUTO_INCREMENT,
  id_producto INT NOT NULL,
  total INT NOT NULL,
  confirmacion VARCHAR(20),
  fecha_venta date,
  PRIMARY KEY (id_producto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;*/
