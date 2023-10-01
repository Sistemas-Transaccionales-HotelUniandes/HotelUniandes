package uniandes.edu.co.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String email;
    private String tipoDocumento ;
    private String documento;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario", referencedColumnName = "id")
    private TipoUsuario tipoUsuario;

    public Usuario() {;}

    public Usuario(String nombre, String email, String tipoDocumento, String documento, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.email = email;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.tipoUsuario = tipoUsuario;
    }


    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public String getDocumento() {
        return this.documento;
    }

    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }
        this.email = email;
    }

    public void setTipoDocumento(String tipoDocumento) {
        if (tipoDocumento == null || tipoDocumento.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de documento no puede ser nulo o vacío");
        }
        this.tipoDocumento = tipoDocumento;
    }

    public void setDocumento(String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("El documento no puede ser nulo o vacío");
        }
        this.documento = documento;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        if (tipoUsuario == null) {
            throw new IllegalArgumentException("El tipo de usuario no puede ser nulo");
        }
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", email='" + getEmail() + "'" +
            ", tipoDocumento='" + getTipoDocumento() + "'" +
            ", documento='" + getDocumento() + "'" +
            ", tipoUsuario='" + getTipoUsuario() + "'" +
            "}";
    }



}