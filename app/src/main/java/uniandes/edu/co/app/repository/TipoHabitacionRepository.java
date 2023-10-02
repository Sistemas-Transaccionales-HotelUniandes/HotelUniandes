package uniandes.edu.co.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {
    @Query(value = "SELECT * FROM tipoHabitacion", nativeQuery = true)
        Collection<TipoHabitacion> darTipoHabitaciones();

    @Query(value = "SELECT * FROM tipoHabitacion WHERE id = :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipoHabitacion (id, tipo, descripcion, capacidad, precio) VALUES ( hoteluniandes_sequence.nextval , :tipo, :descripcion, :capacidad, :precio)", nativeQuery = true)
    void inserTipoHabitacion(@Param("tipo") String tipo, @Param("descripcion") String descripcion,@Param("capacidad") Integer capacidad,@Param("precio") Double precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tipoHabitacion SET tipo = :tipo, descripcion = :d, capacidad = :c, precio = :p WHERE id = :id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id") Integer id, @Param("tipo") String tipo, @Param("d") String descripcion,@Param("c") Integer capacidad,@Param("p") Double precio);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipoHabitacion WHERE id = :id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") Integer id);
}