package uniandes.edu.co.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public abstract class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double costo;

    public Servicio() {;}

    public Servicio(Double costo) {
        this.costo = costo;
    }

    public Integer getId() {
        return this.id;
    }

    public Double getCosto() {
        return this.costo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    
}
