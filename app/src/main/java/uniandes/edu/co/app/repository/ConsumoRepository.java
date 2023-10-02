package uniandes.edu.co.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {
    @Query(value = "SELECT * FROM consumo", nativeQuery = true)
        Collection<Consumo> darConsumos();

    @Query(value = "SELECT * FROM consumo WHERE cuenta_habitacion_id = :id AND servicio_id = :servicio", nativeQuery = true)
    Consumo darconsumo(@Param("id") Integer id, @Param("servicio") Integer servicio_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT IntegeregerO consumo (cuenta_habitacion_id, servicio_id, cuenta_reserva_id) VALUES (:hab, :servicio, :reserva)", nativeQuery = true)
    void insertarConsumo(@Param("hab") Integer habitacion_id, @Param("servicio") Integer servicio_id, @Param("reserva") Integer reserva_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumo SET cuenta_habitacion_id = :hab_nueva, servicio_id = :ser_nuevo, cuenta_reseva_id = :res_nuevo WHERE cuenta_habitacion_id = :hab AND servicio:id = :ser", nativeQuery = true)
    void actualizarConsumo(@Param("hab") Integer habitacion_id_antigua, @Param("ser") Integer servicio_id_antiguo, @Param("hab_nueva") Integer habitacion_id, @Param("ser_nuevo") Integer servicio_id, @Param("res_nuevo") Integer reserva_id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumo WHERE cuenta_habitacion_id = :id AND servicio_id = :servicio", nativeQuery = true)
    void eliminarConsumo(@Param("id") Integer id_habitacion, @Param("servicio") Integer id_servicio);
}