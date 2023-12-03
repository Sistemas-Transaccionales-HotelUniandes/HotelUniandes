package uniandes.edu.co.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;  

    @ManyToOne
    @JoinColumn(name = "tipoHabitacion", referencedColumnName = "id")
    private TipoHabitacion tipohabitacion_id;

    public Habitacion() {;}

    public Habitacion(TipoHabitacion tipoHabitacion) {
        this.tipohabitacion_id = tipoHabitacion;

    }

    public Integer getId() {
        return this.id;
    }

    public TipoHabitacion getTipoHabitacion() {
        return this.tipohabitacion_id;  
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipohabitacion_id = tipoHabitacion;
    }



    
}
