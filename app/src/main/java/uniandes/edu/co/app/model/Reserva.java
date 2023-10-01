package uniandes.edu.co.app.model;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fechaIn;
    private Integer numNoches;
    private String estado; // creada, activa, cancelada, terminada
    private Integer acompañantes;

    @OneToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "planConsumo", referencedColumnName = "id")
    private PlanConsumo planConsumo;

    public Reserva() {;}

    public Reserva(Date fechaIn, Integer numNoches, String estado, Integer acompañantes, Cliente cliente, PlanConsumo planConsumo) {
        this.fechaIn = fechaIn;
        this.numNoches = numNoches;
        this.estado = estado;
        this.acompañantes = acompañantes;
        this.cliente = cliente;
        this.planConsumo = planConsumo;
    }

    public Long getId() {
        return this.id;
    }

    public Date getFechaIn() {
        return this.fechaIn;
    }

    public Integer getNumNoches() {
        return this.numNoches;
    }

    public String getEstado() {
        return this.estado;
    }

    public Integer getAcompañantes() {
        return this.acompañantes;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public PlanConsumo getPlanConsumo() {
        return this.planConsumo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public void setNumNoches(Integer numNoches) {
        this.numNoches = numNoches;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setAcompañantes(Integer acompañantes) {
        this.acompañantes = acompañantes;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPlanConsumo(PlanConsumo planConsumo) {
        this.planConsumo = planConsumo;
    }




    

}
