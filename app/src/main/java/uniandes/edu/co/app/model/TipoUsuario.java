package uniandes.edu.co.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipoUsuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipo;

    public TipoUsuario() {;}

    public TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }
    
}
