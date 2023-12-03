package uniandes.edu.co.app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="cuenta")
public class Cuenta {

    @EmbeddedId
    private CuentaPK pk;

    private String descripcion;
    private Double total;

    public Cuenta() {;}

    public Cuenta(Reserva reserva, Habitacion habitacion, String descripcion, Double total) {
        this.pk = new CuentaPK(reserva, habitacion);
        this.descripcion = descripcion;
        this.total = total;
    }

    public CuentaPK getId() {
        return this.pk;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setId(CuentaPK id) {
        this.pk = id;
    }


    
}
