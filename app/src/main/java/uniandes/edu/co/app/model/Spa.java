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

    private String horainicio;
    private String horafin;

    public Spa() {;}

    public Spa(String horaIn, String horaFin) {
        this.horainicio = horaIn;
        this.horafin = horaFin;
    }

    public Integer getId() {
        return this.id;
    }

    public String getHoraIn() {
        return this.horainicio;
    }

    public String getHoraFin() {
        return this.horafin;
    }

    public void setHoraIn(String horaIn) {
        this.horainicio = horaIn;
    }

    public void setHoraFin(String horaFin) {
        this.horafin = horaFin;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
