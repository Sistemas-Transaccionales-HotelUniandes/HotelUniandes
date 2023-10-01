package uniandes.edu.co.app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasio")
public class Gimnasio extends Servicio{

    @EmbeddedId
    private GimnasioPK id;

    private Integer numMaquinas;
    private Integer capacidad;
    private String horaIn;
    private String horaFin;

    public Gimnasio() {;}

    public Gimnasio(Servicio servicio, Integer numMaquinas, Integer capacidad, String horaIn, String horaFin) {
        this.id = new GimnasioPK(servicio);
        this.numMaquinas = numMaquinas;
        this.capacidad = capacidad;
        this.horaIn = horaIn;
        this.horaFin = horaFin;
    }

    public GimnasioPK getIdPiscina() {
        return this.id;
    }

    public void setIdPiscina(GimnasioPK id) {
        this.id = id;
    }

    public Integer getnumMaquinas() {
        return this.numMaquinas;
    }

    public void setnumMaquinas(Integer numMaquinas) {
        this.numMaquinas = numMaquinas;
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
