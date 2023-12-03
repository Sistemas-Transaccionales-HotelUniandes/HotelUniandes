package uniandes.edu.co.app.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CuentaPK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "reserva", referencedColumnName = "id")
    private Reserva reserva_id;

    @ManyToOne
    @JoinColumn(name = "habitacion", referencedColumnName = "id")
    private Habitacion habitacion_id;


    public CuentaPK() {
        super();
    }

    public CuentaPK(Reserva reserva, Habitacion habitacion) {
        super();
        this.reserva_id = reserva;
        this.habitacion_id = habitacion;
    }

    public Reserva getReserva() {
        return this.reserva_id;
    }

    public Habitacion getHabitacion() {
        return this.habitacion_id;
    }

    public void setReserva(Reserva reserva) {
        this.reserva_id = reserva;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion_id = habitacion;
    }



    
}
