# Proyecto-POO
Sistema de atención y recopilacion de ordenes para una Cafeteria

#Usamos de referencia este video
https://vm.tiktok.com/ZMhJamuf8/
tiene de manera similar nuestro trabajo

Documento Google para avanzar
https://docs.google.com/document/d/1sb42Kf1dQEEU749Q3fiZjkeNDkrSoS8qc3eGnrV0bAE/edit?usp=sharing

Tablas:
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
