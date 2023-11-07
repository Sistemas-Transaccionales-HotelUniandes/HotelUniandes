package uniandes.edu.co.app.model;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

@Embeddable
public class PiscinaPK implements Serializable{

    @EmbeddedId
    private Servicio servicio_id;

    public PiscinaPK() {
        super();
    }

    public PiscinaPK(Servicio servicio) {
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
