package uniandes.edu.co.app.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.app.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Query(value = "SELECT * FROM reserva", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reserva WHERE id = :id", nativeQuery = true)
    Reserva darReservaPorId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reserva WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reserva SET numnoches = :numnoches, fechain = :fechain, estado = :estado, acompanantes = :acompanantes, planconsumo_id = :planconsumo_id, cliente_cliente_id = :cliente_id WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param("id") Integer id, @Param("numnoches") Integer numnoches, @Param("fechain") Date fechain, @Param("estado") String estado, @Param("acompanantes") Integer acompanantes, @Param("planconsumo_id") Integer id_planconsumo, @Param("cliente_id") Integer id_cliente);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reserva (numnoches, fechain, estado, acompanantes, planconsumo:id, cliente_cliente_id) VALUES (:numnoches, :fechain, :estado, :acompanantes, :planconsumo_id, :cliente_id)", nativeQuery = true)
    void insertarReserva(@Param("numnoches") Integer numnoches, @Param("fechain") Date fechain, @Param("estado") String estado, @Param("acompanantes") Integer acompanantes, @Param("planconsumo_id") Integer id_planconsumo, @Param("cliente_id") Integer id_cliente);

    // Lo siguiente es para los check-in

    @Query(value = "SELECT * FROM reserva WHERE estado = 'activa'", nativeQuery = true)
    Collection<Reserva> darCheckins(); // da todas las reservas que hicieron checkin y no han hecho check out

    @Modifying
    @Transactional
    @Query(value = "UPDATE reserva SET estado = 'activa' WHERE id = :id", nativeQuery = true)
    void hacerCheckIn(@Param("id") Integer id);

    // Lo siguiente es para los check-out

    @Query(value = "SELECT * FROM reserva WHERE estado = 'terminada'", nativeQuery = true)
    Collection<Reserva> darCheckouts(); // da todas las reservas que hicieron checkout

    @Modifying
    @Transactional
    @Query(value = "UPDATE reserva SET estado = 'terminada' WHERE id = :id", nativeQuery = true)
    void hacerCheckOut(@Param("id") Integer id);

}
