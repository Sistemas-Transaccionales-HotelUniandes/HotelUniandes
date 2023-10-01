package uniandes.edu.co.app.model;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsumoPk implements Serializable{

    @ManyToOne
    @JoinColumn(name = "servicio", referencedColumnName = "id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "id")
    private Cuenta cuenta;

    public ConsumoPk() {
        super();
    }

    public ConsumoPk(Servicio servicio, Cuenta cuenta) {
        super();
        this.servicio = servicio;
        this.cuenta = cuenta;
    }

    public Servicio getServicio() {
        return this.servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    
}
