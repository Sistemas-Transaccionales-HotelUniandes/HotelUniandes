package uniandes.edu.co.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
    @Query(value = "SELECT * FROM tipoUsuario", nativeQuery = true)
        Collection<TipoUsuario> darTipoUsuarios();

    @Query(value = "SELECT * FROM tipoUsuario WHERE id = :id", nativeQuery = true)
    TipoUsuario darTipoUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipoUsuario (id, tipo) VALUES ( hoteluniandes_sequence.nextval , :tipo)", nativeQuery = true)
    void insertarTipoUsuario(@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tipoUsuario SET tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarTipoUsuario(@Param("id") Integer id, @Param("tipo") String tipo);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipoUsuario WHERE id = :id", nativeQuery = true)
    void eliminarTipoUsuario(@Param("id") Integer id);
}