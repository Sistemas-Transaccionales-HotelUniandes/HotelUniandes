package uniandes.edu.co.app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservaSpa")
public class ReservaSpa {

    @EmbeddedId
    private ReservaSpaPK pk;

    private String horaIn;
    private String dia;
    private Double costo;

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "pk")
    private CuentaPK cuenta_reserva_id;

    public ReservaSpa() {;}

    public ReservaSpa(CuentaPK cuenta, Spa spa, String horaIn, String dia, Double costo) {
        this.pk = new ReservaSpaPK(cuenta, spa);
        this.horaIn = horaIn;
        this.dia = dia;
        this.costo = costo;
        this.cuenta_reserva_id = cuenta;
    }

    public ReservaSpaPK getId() {
        return this.pk;
    }

    public String getHoraIn() {
        return this.horaIn;
    }

    public String getDia() {
        return this.dia;
    }

    public Double getCosto() {
        return this.costo;
    }

    public void setHoraIn(String horaIn) {
        this.horaIn = horaIn;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setId(ReservaSpaPK id) {
        this.pk = id;
    }

    public CuentaPK getCuentaReserva() {
        return this.cuenta_reserva_id;
    }

    public void setCuentaReserva(CuentaPK reserva) {
        this.cuenta_reserva_id = reserva;
    }
    
    
}
