-- REQ 1
SELECT Cuenta_habitacion_id, SUM(costo) AS TotalRecolectado
FROM consumo
JOIN servicio ON consumo.servicio_id = servicio.id
WHERE fecha BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
GROUP BY Cuenta_habitacion_id;

-- REQ 2
SELECT servicio_id, COUNT(*) AS NumeroVecesConsumido
FROM consumo
WHERE fecha BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
GROUP BY servicio_id
ORDER BY NumeroVecesConsumido DESC
FETCH FIRST 20 ROWS ONLY;

-- REQ 3
SELECT habitacion_id, round((SUM(reserva.numnoches) / 365) * 100, 2) AS PorcentajeOcupacion
FROM cuenta
JOIN reserva ON reserva.id=cuenta.reserva_id
WHERE reserva_id IN (SELECT id FROM reserva WHERE fechain BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD'))
GROUP BY habitacion_id
ORDER BY habitacion_id;



-- REQ 4
SELECT *
FROM servicio
JOIN consumo ON servicio.id = consumo.servicio_id
WHERE servicio.costo BETWEEN 0 AND 100
AND consumo.fecha BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD');

-- REQ 5
SELECT usuario.nombre, servicio.nombre AS Servicio, consumo.fecha, servicio.costo
FROM consumo
JOIN servicio ON consumo.servicio_id = servicio.id
JOIN cuenta ON consumo.cuenta_reserva_id = cuenta.reserva_id
JOIN reserva ON cuenta.reserva_id = reserva.id
JOIN cliente ON reserva.cliente_cliente_id = cliente.cliente_id
JOIN usuario ON cliente.usuario_id = usuario.id
WHERE usuario.id = 9 AND consumo.fecha BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD');


-- REQ 6
-- Fechas de mayor ocupación/ revisar
SELECT fechain, COUNT(*) AS HabitacionesOcupadas
FROM reserva
WHERE fechain BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
GROUP BY fechain
ORDER BY HabitacionesOcupadas DESC;

-- Fechas de mayores ingresos
SELECT fecha, SUM(costo) AS Ingresos
FROM consumo
JOIN servicio ON consumo.servicio_id = servicio.id
WHERE fecha BETWEEN TO_DATE('2024-06-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
GROUP BY fecha
ORDER BY Ingresos DESC;

-- Fechas de menor demanda/ revisar
SELECT fechain, COUNT(*) AS HabitacionesOcupadas
FROM reserva
WHERE fechain BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
GROUP BY fechain
ORDER BY HabitacionesOcupadas ASC;

-- REQ 7
SELECT cliente.cliente_id, SUM(cuenta.total) AS TotalGastado, SUM(reserva.numnoches) AS TotalNoches
FROM cliente
JOIN reserva ON cliente.cliente_id = reserva.cliente_cliente_id
JOIN cuenta ON reserva.id = cuenta.reserva_id
WHERE reserva.fechain BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
GROUP BY cliente.cliente_id
HAVING SUM(cuenta.total) > 15000000 OR SUM(reserva.numnoches) >= 14;

-- REQ 8
SELECT servicio_id, COUNT(*) / 52 AS VecesSolicitadasPorSemana
FROM consumo
WHERE fecha BETWEEN TO_DATE('2024-06-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
GROUP BY servicio_id
HAVING COUNT(*) / 52 < 3;

-- REQ 9
SELECT cliente.cliente_id, usuario.email, usuario.nombre, COUNT(*) AS NumeroVecesConsumido, MAX(consumo.fecha) AS UltimaFechaConsumo
FROM cliente
JOIN usuario ON cliente.usuario_id = usuario.id
JOIN reserva ON cliente.cliente_id = reserva.cliente_cliente_id
JOIN cuenta ON reserva.id = cuenta.reserva_id
JOIN consumo ON cuenta.reserva_id = consumo.cuenta_reserva_id
WHERE consumo.servicio_id = :servicioId 
AND consumo.fecha BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
GROUP BY cliente.cliente_id, usuario.nombre, usuario.email
ORDER BY :criterioSeleccionado; -- puede ser 'NumeroVecesConsumido', 'UltimaFechaConsumo'

-- REQ 10
SELECT cliente.cliente_id AS id, usuario.nombre AS nombre
FROM cliente
JOIN usuario ON cliente.usuario_id = usuario.id
JOIN reserva ON cliente.cliente_id = reserva.cliente_cliente_id
LEFT JOIN consumo ON reserva.id = consumo.cuenta_reserva_id AND consumo.servicio_id = :servicioId 
WHERE consumo.servicio_id IS NULL
AND reserva.fechain BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
GROUP BY cliente.cliente_id, usuario.nombre
ORDER BY :criterioSeleccionado; -- :criterioSeleccionado puede ser 'nombre' o 'id' / ordena raro

-- REQ 12
SELECT DISTINCT usuario.id AS UsuarioID,
       usuario.nombre AS NombreUsuario,
       'Servicio costoso consumido' AS Razon
FROM usuario
JOIN cliente ON usuario.id = cliente.usuario_id
JOIN reserva ON cliente.cliente_id = reserva.cliente_cliente_id
JOIN cuenta ON reserva.id = cuenta.reserva_id
JOIN consumo ON cuenta.reserva_id = consumo.cuenta_reserva_id
JOIN servicio ON consumo.servicio_id = servicio.id
WHERE servicio.costo > 50

UNION

SELECT DISTINCT usuario.id AS UsuarioID,
       usuario.nombre AS NombreUsuario,
       'Servicio de salón' AS Razon
FROM usuario
JOIN cliente ON usuario.id = cliente.usuario_id
JOIN reserva ON cliente.cliente_id = reserva.cliente_cliente_id
JOIN cuenta ON reserva.id = cuenta.reserva_id
JOIN (SELECT reservasalon.cuenta_reserva_id FROM reservasalon WHERE reservasalon.duracion > 3) servicios_largos
ON cuenta.reserva_id = servicios_largos.cuenta_reserva_id;

















