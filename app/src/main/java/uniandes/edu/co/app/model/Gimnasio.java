package uniandes.edu.co.app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasio")
public class Gimnasio extends Servicio{

    @EmbeddedId
    private GimnasioPK pk;

    private Integer nummaquinas;
    private Integer capacidad;
    private String horainicio;
    private String horafin;

    public Gimnasio() {;}

    public Gimnasio(Servicio servicio, Integer numMaquinas, Integer capacidad, String horaIn, String horaFin) {
        this.pk = new GimnasioPK(servicio);
        this.nummaquinas = numMaquinas;
        this.capacidad = capacidad;
        this.horainicio = horaIn;
        this.horafin = horaFin;
    }

    public GimnasioPK getIdPiscina() {
        return this.pk;
    }

    public void setIdPiscina(GimnasioPK id) {
        this.pk = id;
    }

    public Integer getnumMaquinas() {
        return this.nummaquinas;
    }

    public void setnumMaquinas(Integer numMaquinas) {
        this.nummaquinas = numMaquinas;
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
