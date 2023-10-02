package uniandes.edu.co.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipoHabitacion")
public class TipoHabitacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipo;
    private String descripcion;
    private Integer capacidad;
    private Double precio;

    public TipoHabitacion() {;}

    public TipoHabitacion(String tipo, String descripcion, Integer capacidad, Double precio) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Integer getCapacidad() {
        return this.capacidad;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


}
