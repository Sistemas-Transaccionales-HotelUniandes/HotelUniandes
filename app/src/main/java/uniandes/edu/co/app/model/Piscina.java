package uniandes.edu.co.app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscina")
public class Piscina extends Servicio{

    @EmbeddedId
    private PiscinaPK pk;

    private Integer profundidad;
    private Integer capacidad;
    private String horainicio;
    private String horafin;

    public Piscina() {;}

    public Piscina(Servicio servicio, Integer profundidad, Integer capacidad, String horaIn, String horaFin) {
        this.pk = new PiscinaPK(servicio);
        this.profundidad = profundidad;
        this.capacidad = capacidad;
        this.horainicio = horaIn;
        this.horafin = horaFin;
    }

    public PiscinaPK getIdPiscina() {
        return this.pk;
    }

    public void setIdPiscina(PiscinaPK id) {
        this.pk = id;
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
        return this.horainicio;
    }

    public void setHoraIn(String horaIn) {
        this.horainicio = horaIn;
    }

    public String getHoraFin() {
        return this.horafin;
    }

    public void setHoraFin(String horaFin) {
        this.horafin = horaFin;
    }





}
