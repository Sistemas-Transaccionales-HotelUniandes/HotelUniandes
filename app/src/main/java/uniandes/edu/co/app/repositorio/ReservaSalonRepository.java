package uniandes.edu.co.app.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.ReservaSalon;

public interface ReservaSalonRepository extends JpaRepository<ReservaSalon, Integer> {
    @Query(value = "SELECT * FROM reservaSalon", nativeQuery = true)
    Collection<ReservaSalon> darreservaSalones();

    @Query(value = "SELECT * FROM reservaSalon WHERE salon_id = :salon AND cuenta_habitacion_id = :cuenta", nativeQuery = true)
    ReservaSalon darreservaSalonPorId(@Param("salon") Integer id_salon, @Param("cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservaSalon WHERE salon_id = :salon AND cuenta_habitacion_id = :cuenta", nativeQuery = true)
    void eliminarreservaSalon(@Param("salon") Integer id_salon, @Param("cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservaSalon SET horainicio = :horainicio, dia = :dia, duracion = :duracion, cuenta_reserva_id = :reserva WHERE salon_id = :salon AND cuenta_habitacion_id = :cuenta", nativeQuery = true)
    void actualizarreservaSalon(@Param("salon") Integer id_Salon, @Param("cuenta") Integer id_cuenta, @Param("horainicio") String horainicio, @Param("dia") String dia, @Param("duracion") Integer duracion, @Param("reserva") Integer reserva_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservaSalon (horainicio, dia, duracion, salon_id, cuenta_habitacion_id, cuenta_reserva_id) VALUES (:costo, :horainicio, :dia, :duracion,:salon, :cuenta. :reserva", nativeQuery = true)
    void insertarreservaSalon(@Param("salon") Integer id_Salon, @Param("cuenta") Integer id_cuenta, @Param("horainicio") String horainicio, @Param("dia") String dia, @Param("duracion") Integer duracion,@Param("reserva") Integer reserva_id);
}