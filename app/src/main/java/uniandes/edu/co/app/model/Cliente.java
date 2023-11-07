package uniandes.edu.co.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cliente_id;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    private Usuario usuario_id;

    /**
     * Default constructor for Cliente class.
     */
    public Cliente() {;}

    /**
     * Constructor for Cliente class.
     * @param usuario The user associated with the client.
     * @param id The ID of the client.
     */
    public Cliente(Usuario usuario) {
        this.usuario_id = usuario;
    }

    /**
     * Returns the ID of the client.
     * @return The ID of the client.
     */
    public Integer getId() {
        return this.cliente_id;
    }

    /**
     * Returns the user associated with the client.
     * @return The user associated with the client.
     */
    public Usuario getUsuario() {
        return this.usuario_id;
    }

    /**
     * Sets the ID of the client.
     * @param id The ID of the client.
     */
    public void setId(Integer id) {
        this.cliente_id = id;
    }

    /**
     * Sets the user associated with the client.
     * @param usuario The user associated with the client.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario_id = usuario;
    }
}
