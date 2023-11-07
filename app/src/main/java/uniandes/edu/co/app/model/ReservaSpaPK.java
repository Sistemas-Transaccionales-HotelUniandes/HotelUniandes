package uniandes.edu.co.app.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservaSpaPK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "pk")
    private CuentaPK cuenta_habitacion_id;

    @ManyToOne
    @JoinColumn(name = "spa", referencedColumnName = "id")
    private Spa spa_id;
    
    public ReservaSpaPK() {
        super();
    }

    public ReservaSpaPK(CuentaPK cuenta, Spa spa) {
        super();
        this.cuenta_habitacion_id = cuenta;
        this.spa_id = spa;
    }

    public CuentaPK getCuenta() {
        return this.cuenta_habitacion_id;
    }

    public Spa getSpa() {
        return this.spa_id;
    }

    public void setCuenta(CuentaPK cuenta) {
        this.cuenta_habitacion_id = cuenta;
    }

    public void setSpa(Spa spa) {
        this.spa_id = spa;
    }

}
