package uniandes.edu.co.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="salon")
public class Salon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipo;
    private Integer capacidad;
    private Double costohora;
    private Double costoAdicional;

    public Salon() {;}

    public Salon(String tipo, Integer capacidad, Double costo, Double costoAdicional) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costohora = costo;
        this.costoAdicional = costoAdicional;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Integer getCapacidad() {
        return this.capacidad;
    }

    public Double getCosto() {
        return this.costohora;
    }

    public Double getCostoAdicional() {
        return this.costoAdicional;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto(Double costo) {
        this.costohora = costo;
    }

    public void setCostoAdicional(Double costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
