package uniandes.edu.co.app.model;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

@Embeddable
public class GimnasioPK implements Serializable{

    @EmbeddedId
    private Servicio servicio_id;

    public GimnasioPK() {
        super();
    }

    public GimnasioPK(Servicio servicio) {
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
