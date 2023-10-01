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
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    private Usuario usuario;

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
        this.usuario = usuario;
    }

    /**
     * Returns the ID of the client.
     * @return The ID of the client.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Returns the user associated with the client.
     * @return The user associated with the client.
     */
    public Usuario getUsuario() {
        return this.usuario;
    }

    /**
     * Sets the ID of the client.
     * @param id The ID of the client.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets the user associated with the client.
     * @param usuario The user associated with the client.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
