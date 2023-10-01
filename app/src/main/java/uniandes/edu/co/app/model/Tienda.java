package uniandes.edu.co.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tienda")
public class Tienda extends Servicio{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "servicio", referencedColumnName = "id")
    private Servicio servicio;

    private String tipo;

    public Tienda() {;}

    public Tienda(Servicio servicio, String tipo) {
        this.servicio = servicio;
        this.tipo = tipo;
    }

    public Long getId() {
        return this.id;
    }

    public Servicio getServicio() {
        return this.servicio;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
