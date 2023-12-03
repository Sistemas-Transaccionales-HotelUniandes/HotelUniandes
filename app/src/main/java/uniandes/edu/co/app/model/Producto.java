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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "spa", referencedColumnName = "id")
    private Spa spa_id;

    @ManyToOne
    @JoinColumn(name = "tienda", referencedColumnName = "tienda_id")
    private Tienda tienda_tienda_id;

    @ManyToOne
    @JoinColumn(name = "local", referencedColumnName = "local_id")
    private Local local_local_id;

    private String nombre;
    private Double precio;

    public Producto() {;}

    public Producto(Spa spa, Tienda tienda, Local local, String nombre, Double precio) {
        this.spa_id = spa;
        this.tienda_tienda_id = tienda;
        this.local_local_id = local;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {
        return this.id;
    }

    public Spa getSpa() {
        return this.spa_id;
    }

    public Tienda getTienda() {
        return this.tienda_tienda_id;
    }

    public Local getLocal() {
        return this.local_local_id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setSpa(Spa spa) {
        this.spa_id = spa;
    }

    public void setTienda(Tienda tienda) {
        this.tienda_tienda_id = tienda;
    }

    public void setLocal(Local local) {
        this.local_local_id = local;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    
}
