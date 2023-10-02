package uniandes.edu.co.app.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "local")
public class Local extends Servicio{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "servicio", referencedColumnName = "id")
    private Servicio servicio;

    private String tipo;
    private Integer capacidad;
    private String estilo;

    public Local() {;}

    public Local(Servicio servicio, String tipo, Integer capacidad, String estilo) {
        this.servicio = servicio;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.estilo = estilo;
    }

    public Integer getId() {
        return this.id;
    }

    public Servicio getServicio() {
        return this.servicio;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Integer getCapacidad() {
        return this.capacidad;
    }

    public String getEstilo() {
        return this.estilo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
}
