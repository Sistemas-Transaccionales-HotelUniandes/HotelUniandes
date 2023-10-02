package uniandes.edu.co.app.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservaSpaPK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "id")
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "spa", referencedColumnName = "id")
    private Spa spa;
    
    public ReservaSpaPK() {
        super();
    }

    public ReservaSpaPK(Cuenta cuenta, Spa spa) {
        super();
        this.cuenta = cuenta;
        this.spa = spa;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public Spa getSpa() {
        return this.spa;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setSpa(Spa spa) {
        this.spa = spa;
    }

}
