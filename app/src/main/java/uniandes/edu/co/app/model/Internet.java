package uniandes.edu.co.app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "internet")
public class Internet extends Servicio{

    @EmbeddedId
    private InternetPK pk;
    private Integer capacidad;


    public Internet() {;}

    public Internet(Servicio servicio, Integer capacidad) {
        this.pk = new InternetPK(servicio);
        this.capacidad = capacidad;
    }

    public InternetPK getIdInternet() {
        return this.pk;
    }

    public void setIdInternet(InternetPK id) {
        this.pk = id;
    }

    public Integer getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }





}
