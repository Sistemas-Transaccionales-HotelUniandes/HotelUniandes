package uniandes.edu.co.app.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CuentaPK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "reserva", referencedColumnName = "id")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "habitacion", referencedColumnName = "id")
    private Habitacion habitacion;


    public CuentaPK() {
        super();
    }

    public CuentaPK(Reserva reserva, Habitacion habitacion) {
        super();
        this.reserva = reserva;
        this.habitacion = habitacion;
    }

    public Reserva getReserva() {
        return this.reserva;
    }

    public Habitacion getHabitacion() {
        return this.habitacion;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }



    
}
