package uniandes.edu.co.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "SELECT * FROM usuario", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT u FROM usuario u WHERE u.correo = :correo AND u.documento = :documento")
    Collection<Usuario> loginUsuario(@Param("correo") String correo, @Param("documento") String contrasena);

    @Query(value = "SELECT * FROM usuario WHERE id = :id", nativeQuery = true)
    Usuario darUsuarioPorId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuario WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuario SET nombre = :nombre_actualizado, email = :email_actualizado, tipodocumento = :tipoDocumento_actualizado, documento = :documento_actualizado, tipousuario_id = :tipoUsuario_actualizado WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") Integer id, @Param("nombre_actualizado") String nombre_actualizado, @Param("email_actualizado") String email_actualizado, @Param("tipoDocumento_actualizado") String tipoDocumento_actualizado, @Param("documento_actualizado") String documento_actualizado, @Param("tipoUsuario_actualizado") Integer id_tipoUsuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario (nombre, email, documento, tipodocumento, tipousuario_id) VALUES (:nombre, :email, :documento, :tipodocumento, :tipousuarioid)", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("email") String email, @Param("documento") String documento, @Param("tipodocumento") String tipodocumento, @Param("tipousuarioid") Integer id_tipousuario);
}
