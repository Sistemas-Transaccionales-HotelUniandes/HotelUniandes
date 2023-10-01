package uniandes.edu.co.app.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "spa", referencedColumnName = "id")
    private Spa spa;

    @ManyToOne
    @JoinColumn(name = "tienda", referencedColumnName = "id")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "local", referencedColumnName = "id")
    private Local local;

    private String nombre;
    private Double precio;

    public Producto() {;}

    public Producto(Spa spa, Tienda tienda, Local local, String nombre, Double precio) {
        this.spa = spa;
        this.tienda = tienda;
        this.local = local;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return this.id;
    }

    public Spa getSpa() {
        return this.spa;
    }

    public Tienda getTienda() {
        return this.tienda;
    }

    public Local getLocal() {
        return this.local;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setSpa(Spa spa) {
        this.spa = spa;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    
}
