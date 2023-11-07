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
    private ReservaSalonPK pk;

    private String horaIn;
    private String dia;
    private Integer duracion;

    @ManyToOne
    @JoinColumn(name = "cuenta", referencedColumnName = "pk")
    private CuentaPK cuenta_reserva_id; 

    public ReservaSalon() {;}

    public ReservaSalon(CuentaPK cuentaPK, Salon salon, String horaIn, String dia, Integer duracion) {
        this.pk = new ReservaSalonPK(cuentaPK, salon);
        this.horaIn = horaIn;
        this.dia = dia;
        this.duracion = duracion;
        this.cuenta_reserva_id = cuentaPK;
    }

    public ReservaSalonPK getId() {
        return this.pk;
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
        this.pk = id;
    }

    public CuentaPK getCuentaReserva() {
        return this.cuenta_reserva_id;
    }

    public void setCuentaReserva(CuentaPK reserva) {
        this.cuenta_reserva_id = reserva;
    }

}
