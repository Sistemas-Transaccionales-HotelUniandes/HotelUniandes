-- Inserción del plan "Larga estadía"
INSERT INTO planconsumo (id, nombre, descripcion)
VALUES (1, 'Larga estadía', 'Genera un descuento (%) en el costo del alojamiento para estadías mayores a 7 noches');

-- Inserción del plan "Tiempo compartido"
INSERT INTO planconsumo (id, nombre, descripcion)
VALUES (2, 'Tiempo compartido', 'Las estadías son de 7 noches, consumos son cargados a la cuenta de la habitación.');

-- Inserción del plan "Todo incluido"
INSERT INTO planconsumo (id, nombre, descripcion)
VALUES (3, 'Todo incluido', 'Un costo fijo total cubre el alojamiento y alimentación completa');

-- Inserción del plan "Sin plan"
INSERT INTO planconsumo (id, nombre, descripcion)
VALUES (4, 'Sin plan', 'No tienes plan');