package uniandes.edu.co.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    @Query(value = "SELECT * FROM servicio", nativeQuery = true)
        Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicio WHERE id = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicio (id, costo) VALUES ( hoteluniandes_sequence.nextval , :costo)", nativeQuery = true)
    void insertarServicio(@Param("costo") Double costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicio SET costo = :costo WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") Integer id, @Param("costo") Double costo);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicio WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") Integer id);
}
