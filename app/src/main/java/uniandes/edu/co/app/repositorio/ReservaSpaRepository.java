package uniandes.edu.co.app.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.ReservaSpa;

public interface ReservaSpaRepository extends JpaRepository<ReservaSpa, Integer> {
    @Query(value = "SELECT * FROM reservaSpa", nativeQuery = true)
    Collection<ReservaSpa> darreservaSpas();

    @Query(value = "SELECT * FROM reservaSpa WHERE spa_id = :spa AND cuenta_habitacion_id = :cuenta", nativeQuery = true)
    ReservaSpa darreservaSpaPorId(@Param("spa") Integer id_spa, @Param("cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservaSpa WHERE spa_id = :spa AND cuenta_habitacion_id = :cuenta", nativeQuery = true)
    void eliminarreservaSpa(@Param("spa") Integer id_spa, @Param("cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservaSpa SET costo = :costo, horainicio = :horainicio, dia = :dia, cuenta_reserva_id = :reserva WHERE spa_id = :spa AND cuenta_habitacion_id = :cuenta", nativeQuery = true)
    void actualizarreservaSpa(@Param("spa") Integer id_spa, @Param("cuenta") Integer id_cuenta, @Param("costo") Double costo, @Param("horainicio") String horainicio, @Param("dia") String dia, @Param("reserva") Integer reserva_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservaSpa (costo, horainicio, dia, spa_id, cuenta_habitacion_id, cuenta_reserva_id) VALUES (:costo, :horainicio, :dia, :spa, :cuenta. :reserva", nativeQuery = true)
    void insertarreservaSpa(@Param("spa") Integer id_spa, @Param("cuenta") Integer id_cuenta, @Param("costo") Double costo, @Param("horainicio") String horainicio, @Param("dia") String dia, @Param("reserva") Integer reserva_id);
}