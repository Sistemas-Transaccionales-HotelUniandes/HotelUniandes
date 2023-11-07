package uniandes.edu.co.app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="consumo")
public class Consumo {

    @EmbeddedId
    private ConsumoPk pk;

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "pk")
    private CuentaPK cuenta_reserva_id;


    public Consumo() {;}

    public Consumo(CuentaPK cuenta, Servicio servicio) {
        this.pk = new ConsumoPk(servicio, cuenta);
        this.cuenta_reserva_id = cuenta;
    }
    
    public ConsumoPk getId() {
        return this.pk;
    }

    public void setId(ConsumoPk id) {
        this.pk = id;
    }

    public CuentaPK getCuentaReserva() {
        return this.cuenta_reserva_id;
    }

    public void setCuentaReserva(CuentaPK reserva) {
        this.cuenta_reserva_id = reserva;
    }

    public Servicio getServicio() {
        return this.pk.getServicio();
    }

    public void setServicio(Servicio servicio) {
        this.pk.setServicio(servicio);
    }

    public CuentaPK getCuenta() {
        return this.pk.getCuenta();
    }

    public void setCuenta(CuentaPK cuenta) {
        this.pk.setCuenta(cuenta);
    }
    


    
}
