package uniandes.edu.co.app.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservaSalonPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "pk")
    private CuentaPK cuentaPK;

    @ManyToOne
    @JoinColumn(name = "salon", referencedColumnName = "id")
    private Salon salon;
    
    public ReservaSalonPK() {
        super();
    }

    public ReservaSalonPK(CuentaPK cuentaPK, Salon salon) {
        super();
        this.cuentaPK = cuentaPK;
        this.salon = salon;
    }

    public CuentaPK getCuenta() {
        return this.cuentaPK;
    }

    public Salon getSalon() {
        return this.salon;
    }

    public void setCuenta(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

}
