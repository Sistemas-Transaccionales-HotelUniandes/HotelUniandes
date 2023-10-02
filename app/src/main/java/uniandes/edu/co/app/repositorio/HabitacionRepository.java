package uniandes.edu.co.app.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    @Query(value = "SELECT * FROM habitacion", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitacion WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitacion (id, tipohabitacion_id) VALUES ( hoteluniandes_sequence.nextval , :tipo)", nativeQuery = true)
    void insertarHabitacion(@Param("tipo") Integer tipohabitacion_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacion SET tipohabitacion_id = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") Integer id, @Param("tipo") Integer tipohabitacion_id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitacion WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") Integer id);
}