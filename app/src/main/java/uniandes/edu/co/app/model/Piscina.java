package uniandes.edu.co.app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscina")
public class Piscina extends Servicio{

    @EmbeddedId
    private PiscinaPK id;

    private Integer profundidad;
    private Integer capacidad;
    private String horaIn;
    private String horaFin;

    public Piscina() {;}

    public Piscina(Servicio servicio, Integer profundidad, Integer capacidad, String horaIn, String horaFin) {
        this.id = new PiscinaPK(servicio);
        this.profundidad = profundidad;
        this.capacidad = capacidad;
        this.horaIn = horaIn;
        this.horaFin = horaFin;
    }

    public PiscinaPK getIdPiscina() {
        return this.id;
    }

    public void setIdPiscina(PiscinaPK id) {
        this.id = id;
    }

    public Integer getProfundidad() {
        return this.profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public Integer getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getHoraIn() {
        return this.horaIn;
    }

    public void setHoraIn(String horaIn) {
        this.horaIn = horaIn;
    }

    public String getHoraFin() {
        return this.horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }





}
