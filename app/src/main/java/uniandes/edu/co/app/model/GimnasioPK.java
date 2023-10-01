package uniandes.edu.co.app.model;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class GimnasioPK implements Serializable{

    @OneToOne
    @JoinColumn(name = "servicio", referencedColumnName = "id")
    private Servicio servicio;

    public GimnasioPK() {
        super();
    }

    public GimnasioPK(Servicio servicio) {
        super();
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return this.servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    
}
