# Proyecto-POO
Sistema de atención y recopilacion de ordenes para una Cafeteria

# Usamos de referencia este video
https://vm.tiktok.com/ZMhJamuf8/
tiene de manera similar nuestro trabajo

# Documento Google para avanzar
https://docs.google.com/document/d/1sb42Kf1dQEEU749Q3fiZjkeNDkrSoS8qc3eGnrV0bAE/edit?usp=sharing

# ***Tablas:***
|Producto (para abstraer comida y bebida)|
|----------------------------------------|
|id_producto (PK)                        |
|nombre                                  |
|tipo (bebida/comida)                    |
|precio                                  |


|Cliente                                 |
|----------------------------------------|
|id_cliente (PK)                         |
|nombre                                  |
|contacto                                |


|Empleado                                |
|----------------------------------------|
|id_empleado (PK)                        |
|nombre                                  |
|rol                                     |
|salario                                 |


|Pedido                                  |
|----------------------------------------|
|id_pedido (PK)                          |
|fecha                                   |
|id_cliente (FK a Cliente)               |
|id_empleado (FK a Empleado)             |


|PedidosProductos (relación muchos a muchos)|
|--------------------------------------------|
|id_pedido (FK a Pedido)                     |
|id_producto (FK a Producto)                 |
|cantidad                                    |


|Promocion                                 |
|------------------------------------------|
|id_promocion (PK)                         |
|descripcion                               |
|descuento                                 |


|PromocionProducto (relación muchos a muchos)|
|--------------------------------------------|
|id_promocion (FK a Promocion)               |
|id_producto (FK a Producto)                 |


|Usuario                                   |
|------------------------------------------|
|id_usuario (PK)                           |
|nombre                                    |
|contraseña                                |
|id_empleado (FK a Empleado)               |

# BASES DE DATOS

```ruby
1. Base de Datos de Empleados
sql
Copiar código
-- Crear la base de datos para empleados
CREATE DATABASE CafeteriaEmpleados;

-- Usar la base de datos
USE CafeteriaEmpleados;

-- Crear la tabla Empleado
CREATE TABLE Empleado (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    rol VARCHAR(50) NOT NULL,
    salario DECIMAL(10,2) NOT NULL
);

-- Insertar datos de ejemplo en la tabla Empleado
INSERT INTO Empleado (nombre, rol, salario) VALUES ('Juan Pérez', 'Barista', 1200.00);
INSERT INTO Empleado (nombre, rol, salario) VALUES ('Ana García', 'Gerente', 2000.00);
```

```ruby
2. Base de Datos de Productos
sql
Copiar código
-- Crear la base de datos para productos
CREATE DATABASE CafeteriaProductos;

-- Usar la base de datos
USE CafeteriaProductos;

-- Crear la tabla Producto
CREATE TABLE Producto (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('bebida', 'comida') NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

-- Insertar datos de ejemplo en la tabla Producto
INSERT INTO Producto (nombre, tipo, precio) VALUES ('Café', 'bebida', 3.50);
INSERT INTO Producto (nombre, tipo, precio) VALUES ('Sándwich', 'comida', 5.00);
```

```ruby
3. Base de Datos de Pedidos
sql
Copiar código
-- Crear la base de datos para pedidos
CREATE DATABASE CafeteriaPedidos;

-- Usar la base de datos
USE CafeteriaPedidos;

-- Crear la tabla Pedido
CREATE TABLE Pedido (
    id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATETIME NOT NULL,
    id_cliente INT NOT NULL,
    id_empleado INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES CafeteriaClientes.Cliente(id_cliente),
    FOREIGN KEY (id_empleado) REFERENCES CafeteriaEmpleados.Empleado(id_empleado)
);

-- Insertar datos de ejemplo en la tabla Pedido
INSERT INTO Pedido (fecha, id_cliente, id_empleado) VALUES ('2024-09-10 10:30:00', 1, 1);
```

```ruby
4. Tabla Intermedia PedidosProductos
sql
Copiar código
-- Usar la base de datos de pedidos
USE CafeteriaPedidos;

-- Crear la tabla PedidosProductos
CREATE TABLE PedidosProductos (
    id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (id_pedido, id_producto),
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES CafeteriaProductos.Producto(id_producto)
);

-- Insertar datos de ejemplo en la tabla PedidosProductos
INSERT INTO PedidosProductos (id_pedido, id_producto, cantidad) VALUES (1, 1, 2);
INSERT INTO PedidosProductos (id_pedido, id_producto, cantidad) VALUES (1, 2, 1);
```
```ruby
5. Base de Datos de Promociones
sql
Copiar código
-- Crear la base de datos para promociones
CREATE DATABASE CafeteriaPromociones;

-- Usar la base de datos
USE CafeteriaPromociones;

-- Crear la tabla Promocion
CREATE TABLE Promocion (
    id_promocion INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(255) NOT NULL,
    descuento DECIMAL(5,2) NOT NULL
);

-- Insertar datos de ejemplo en la tabla Promocion
INSERT INTO Promocion (descripcion, descuento) VALUES ('Descuento en café', 10.00);
```

```ruby
6. Tabla Intermedia PromocionProducto
sql
Copiar código
-- Usar la base de datos de promociones
USE CafeteriaPromociones;

-- Crear la tabla PromocionProducto
CREATE TABLE PromocionProducto (
    id_promocion INT NOT NULL,
    id_producto INT NOT NULL,
    PRIMARY KEY (id_promocion, id_producto),
    FOREIGN KEY (id_promocion) REFERENCES Promocion(id_promocion),
    FOREIGN KEY (id_producto) REFERENCES CafeteriaProductos.Producto(id_producto)
);

-- Insertar datos de ejemplo en la tabla PromocionProducto
INSERT INTO PromocionProducto (id_promocion, id_producto) VALUES (1, 1);
```
```ruby
7. Base de Datos de Usuarios
sql
Copiar código
-- Crear la base de datos para usuarios
CREATE DATABASE CafeteriaUsuarios;

-- Usar la base de datos
USE CafeteriaUsuarios;

-- Crear la tabla Usuario
CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    contraseña VARCHAR(100) NOT NULL,
    id_empleado INT NOT NULL,
    FOREIGN KEY (id_empleado) REFERENCES CafeteriaEmpleados.Empleado(id_empleado)
);

-- Insertar datos de ejemplo en la tabla Usuario
INSERT INTO Usuario (nombre, contraseña, id_empleado) VALUES ('juan.perez', 'password123', 1);
```
