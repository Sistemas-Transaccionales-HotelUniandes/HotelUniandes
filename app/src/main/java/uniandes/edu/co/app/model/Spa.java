package uniandes.edu.co.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="spa")
public class Spa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String horaIn;
    private String horaFin;

    public Spa() {;}

    public Spa(String horaIn, String horaFin) {
        this.horaIn = horaIn;
        this.horaFin = horaFin;
    }

    public Integer getId() {
        return this.id;
    }

    public String getHoraIn() {
        return this.horaIn;
    }

    public String getHoraFin() {
        return this.horaFin;
    }

    public void setHoraIn(String horaIn) {
        this.horaIn = horaIn;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
