package uniandes.edu.co.app.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservaSalonPK {

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "id")
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "salon", referencedColumnName = "id")
    private Salon salon;
    
    public ReservaSalonPK() {
        super();
    }

    public ReservaSalonPK(Cuenta cuenta, Salon salon) {
        super();
        this.cuenta = cuenta;
        this.salon = salon;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public Salon getSalon() {
        return this.salon;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

}
