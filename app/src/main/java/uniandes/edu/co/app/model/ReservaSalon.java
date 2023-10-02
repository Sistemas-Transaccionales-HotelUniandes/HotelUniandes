package uniandes.edu.co.app.model;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservaSalon")
public class ReservaSalon {

    @EmbeddedId
    private ReservaSalonPK id;

    private String horaIn;
    private String dia;
    private Integer duracion;

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "reserva")
    private Cuenta reserva;

    public ReservaSalon() {;}

    public ReservaSalon(Cuenta cuenta, Salon salon, String horaIn, String dia, Integer duracion) {
        this.id = new ReservaSalonPK(cuenta, salon);
        this.horaIn = horaIn;
        this.dia = dia;
        this.duracion = duracion;
        this.reserva = cuenta;
    }

    public ReservaSalonPK getId() {
        return this.id;
    }

    public String getHoraIn() {
        return this.horaIn;
    }

    public String getDia() {
        return this.dia;
    }

    public Integer getDuracion() {
        return this.duracion;
    }

    public void setHoraIn(String horaIn) {
        this.horaIn = horaIn;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public void setId(ReservaSalonPK id) {
        this.id = id;
    }
    
}
