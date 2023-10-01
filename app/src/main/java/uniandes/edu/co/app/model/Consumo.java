package uniandes.edu.co.app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="consumo")
public class Consumo {

    @EmbeddedId
    private ConsumoPk id;

    public Consumo() {;}

    public Consumo(Cuenta cuenta, Servicio servicio) {
        this.id = new ConsumoPk(servicio, cuenta);
    }
    
    public ConsumoPk getId() {
        return this.id;
    }

    public void setId(ConsumoPk id) {
        this.id = id;
    }

    
}
