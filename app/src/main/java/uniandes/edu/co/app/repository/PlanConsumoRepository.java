package uniandes.edu.co.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.PlanConsumo;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer> {
    @Query(value = "SELECT * FROM planConsumo", nativeQuery = true)
    Collection<PlanConsumo> darplanConsumos();

    @Query(value = "SELECT * FROM planConsumo WHERE id = :id", nativeQuery = true)
    PlanConsumo darplanConsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planConsumo (id, nombre, descripcion) VALUES ( hoteluniandes_sequence.nextval , :nombre, :descripcion)", nativeQuery = true)
    void insertarplanConsumo(@Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planConsumo SET nombre = :n, descripcion = :d WHERE id = :id", nativeQuery = true)
    void actualizarplanConsumo(@Param("id") Integer id, @Param("n") String nombre, @Param("d") String Descripcion);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planConsumo WHERE id = :id", nativeQuery = true)
    void eliminarplanConsumo(@Param("id") Integer id);
}