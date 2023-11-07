package uniandes.edu.co.app.model;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;


@Embeddable
public class InternetPK implements Serializable{

    @EmbeddedId
    private Servicio servicio_id;

    public InternetPK() {
        super();
    }

    public InternetPK(Servicio servicio) {
        super();
        this.servicio_id = servicio;
    }

    public Servicio getServicio() {
        return this.servicio_id;
    }

    public void setServicio(Servicio servicio) {
        this.servicio_id = servicio;
    }

    
}
