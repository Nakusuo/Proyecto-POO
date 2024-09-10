# Proyecto-POO
Sistema de atención y recopilacion de ordenes para una Cafeteria

# Usamos de referencia este video
https://vm.tiktok.com/ZMhJamuf8/
tiene de manera similar nuestro trabajo

# Documento Google para avanzar
https://docs.google.com/document/d/1sb42Kf1dQEEU749Q3fiZjkeNDkrSoS8qc3eGnrV0bAE/edit?usp=sharing

# Tablas:
|Producto (para abstraer comida y bebida) |Cliente                                 |
|-----------------------------------------|----------------------------------------|
|id_producto (PK)                          |id_cliente (PK)                         |
|nombre                                   |nombre                                  |
|tipo (bebida/comida)                      |contacto                                |
|precio                                    |                                        |

|Empleado                                |Pedido                                  |
|---------------------------------------- |----------------------------------------|
|id_empleado (PK)                         |id_pedido (PK)                          |
|nombre                                  |fecha                                   |
|rol                                      |id_cliente (FK a Cliente)               |
|salario                                  |id_empleado (FK a Empleado)             |

|PedidosProductos (relación muchos a muchos)|Promocion                                |
|--------------------------------------------|-----------------------------------------|
|id_pedido (FK a Pedido)                      |id_promocion (PK)                        |
|id_producto (FK a Producto)                 |descripcion                              |
|cantidad                                   |descuento                                |

|PromocionProducto (relación muchos a muchos) |Usuario                                   |
|-------------------------------------------- |------------------------------------------|
|id_promocion (FK a Promocion)               |id_usuario (PK)                           |
|id_producto (FK a Producto)                   |nombre                                    |
|                                            |contraseña                                |
|                                              |id_empleado (FK a Empleado)               |

