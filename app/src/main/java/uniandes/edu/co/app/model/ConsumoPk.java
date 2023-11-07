package uniandes.edu.co.app.model;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsumoPk implements Serializable{

    @ManyToOne
    @JoinColumn(name = "servicio", referencedColumnName = "id")
    private Servicio servicio_id;

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "pk")
    private CuentaPK cuenta_Habitacion_id;

    public ConsumoPk() {
        super();
    }

    public ConsumoPk(Servicio servicio, CuentaPK cuenta) {
        super();
        this.servicio_id = servicio;
        this.cuenta_Habitacion_id = cuenta;
    }

    public Servicio getServicio() {
        return this.servicio_id;
    }

    public void setServicio(Servicio servicio) {
        this.servicio_id = servicio;
    }

    public CuentaPK getCuenta() {
        return this.cuenta_Habitacion_id;
    }

    public void setCuenta(CuentaPK cuenta) {
        this.cuenta_Habitacion_id = cuenta;
    }


    
}
