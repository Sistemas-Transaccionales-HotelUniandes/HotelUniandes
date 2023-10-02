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
    private ConsumoPk id;

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "reserva")
    private Cuenta reserva;


    public Consumo() {;}

    public Consumo(Cuenta cuenta, Servicio servicio) {
        this.id = new ConsumoPk(servicio, cuenta);
        this.reserva = cuenta;
    }
    
    public ConsumoPk getId() {
        return this.id;
    }

    public void setId(ConsumoPk id) {
        this.id = id;
    }

    
}
