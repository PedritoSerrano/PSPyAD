-- Inserción de Estaciones
INSERT INTO estacion (estacion_id, numero, nombre, coordenadas, capacidad) VALUES (1, 101, 'Estación Plaza Mayor', '37.3891,-5.9845', 20);
INSERT INTO estacion (estacion_id, numero, nombre, coordenadas, capacidad) VALUES (2, 102, 'Estación Triana', '37.3836,-6.0026', 15);
INSERT INTO estacion (estacion_id, numero, nombre, coordenadas, capacidad) VALUES (3, 103, 'Estación Alameda', '37.3947,-5.9943', 25);
INSERT INTO estacion (estacion_id, numero, nombre, coordenadas, capacidad) VALUES (4, 104, 'Estación Nervión', '37.3778,-5.9738', 18);
INSERT INTO estacion (estacion_id, numero, nombre, coordenadas, capacidad) VALUES (5, 105, 'Estación Los Remedios', '37.3710,-6.0021', 22);

-- Inserción de Bicicletas
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (1, 'Orbea', 'Urban 20', 'NUEVA', 1);
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (2, 'BH', 'City Wave', 'SEMINUEVA', 1);
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (3, 'Giant', 'Escape 3', 'NUEVA', 2);
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (4, 'Trek', 'FX 2', 'USADA', 2);
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (5, 'Specialized', 'Sirrus X 2.0', 'NUEVA', 3);
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (6, 'Cannondale', 'Quick 4', 'SEMINUEVA', 3);
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (7, 'Scott', 'Sub Cross 30', 'AVERIADA', 4);
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (8, 'Cube', 'Nature', 'NUEVA', 4);
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (9, 'Merida', 'Crossway 100', 'SEMINUEVA', 5);
INSERT INTO bicicleta (bicicleta_id, marca, modelo, estado, bicicleta_estacion_id) VALUES (10, 'KTM', 'Life Space', 'NUEVA', 5);

-- Inserción de Usuarios
INSERT INTO usuario (usuario_id, nombre, num_tarjeta, pin, saldo) VALUES (1, 'Juan Pérez', 10001, 1234, 50.00);
INSERT INTO usuario (usuario_id, nombre, num_tarjeta, pin, saldo) VALUES (2, 'María García', 10002, 5678, 35.50);
INSERT INTO usuario (usuario_id, nombre, num_tarjeta, pin, saldo) VALUES (3, 'Carlos Domínguez', 10003, 9012, 80.00);
INSERT INTO usuario (usuario_id, nombre, num_tarjeta, pin, saldo) VALUES (4, 'Ana Martínez', 10004, 3456, 20.75);
INSERT INTO usuario (usuario_id, nombre, num_tarjeta, pin, saldo) VALUES (5, 'Luis Rodríguez', 10005, 7890, 100.00);
INSERT INTO usuario (usuario_id, nombre, num_tarjeta, pin, saldo) VALUES (6, 'Laura Sánchez', 10006, 2468, 45.25);
INSERT INTO usuario (usuario_id, nombre, num_tarjeta, pin, saldo) VALUES (7, 'Pedro Serrano', 10007, 1357, 60.00);

-- Inserción de Usos
INSERT INTO uso (uso_id, fecha_inicio, fecha_fin, coste, uso_estacion_id, uso_bicicleta_id, uso_usuario_id) VALUES (1, '2026-01-05', '2026-01-05', 2.50, 1, 1, 1);
INSERT INTO uso (uso_id, fecha_inicio, fecha_fin, coste, uso_estacion_id, uso_bicicleta_id, uso_usuario_id) VALUES (2, '2026-01-06', '2026-01-06', 3.00, 2, 3, 2);
INSERT INTO uso (uso_id, fecha_inicio, fecha_fin, coste, uso_estacion_id, uso_bicicleta_id, uso_usuario_id) VALUES (3, '2026-01-06', '2026-01-06', 1.50, 1, 2, 3);
INSERT INTO uso (uso_id, fecha_inicio, fecha_fin, coste, uso_estacion_id, uso_bicicleta_id, uso_usuario_id) VALUES (4, '2026-01-07', '2026-01-07', 4.00, 3, 5, 1);
INSERT INTO uso (uso_id, fecha_inicio, fecha_fin, coste, uso_estacion_id, uso_bicicleta_id, uso_usuario_id) VALUES (5, '2026-01-07', '2026-01-07', 2.75, 4, 8, 4);
INSERT INTO uso (uso_id, fecha_inicio, fecha_fin, coste, uso_estacion_id, uso_bicicleta_id, uso_usuario_id) VALUES (6, '2026-01-08', '2026-01-08', 3.50, 5, 10, 5);
INSERT INTO uso (uso_id, fecha_inicio, fecha_fin, coste, uso_estacion_id, uso_bicicleta_id, uso_usuario_id) VALUES (7, '2026-01-08', '2026-01-08', 2.00, 2, 4, 6);
INSERT INTO uso (uso_id, fecha_inicio, fecha_fin, coste, uso_estacion_id, uso_bicicleta_id, uso_usuario_id) VALUES (8, '2026-01-09', NULL, 0.00, 3, 6, 7);
INSERT INTO uso (uso_id, fecha_inicio, fecha_fin, coste, uso_estacion_id, uso_bicicleta_id, uso_usuario_id) VALUES (9, '2026-01-09', NULL, 0.00, 1, 1, 2);

