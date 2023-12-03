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
    private Integer id;
    private Date fechain;
    private Integer numnoches;
    private String estado; // creada, activa, cancelada, terminada
    private Integer acompanantes;

    @OneToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Cliente cliente_cliente_id;

    @ManyToOne
    @JoinColumn(name = "planConsumo", referencedColumnName = "id")
    private PlanConsumo planconsumo_id;

    public Reserva() {;}

    public Reserva(Date fechaIn, Integer numNoches, String estado, Integer acompanantes, Cliente cliente, PlanConsumo planConsumo) {
        this.fechain = fechaIn;
        this.numnoches = numNoches;
        this.estado = estado;
        this.acompanantes = acompanantes;
        this.cliente_cliente_id = cliente;
        this.planconsumo_id = planConsumo;
    }

    public Integer getId() {
        return this.id;
    }

    public Date getFechaIn() {
        return this.fechain;
    }

    public Integer getNumNoches() {
        return this.numnoches;
    }

    public String getEstado() {
        return this.estado;
    }

    public Integer getAcompanantes() {
        return this.acompanantes;
    }

    public Cliente getCliente() {
        return this.cliente_cliente_id;
    }

    public PlanConsumo getPlanConsumo() {
        return this.planconsumo_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechain = fechaIn;
    }

    public void setNumNoches(Integer numNoches) {
        this.numnoches = numNoches;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setAcompanantes(Integer acompañantes) {
        this.acompanantes = acompañantes;
    }

    public void setCliente(Cliente cliente) {
        this.cliente_cliente_id = cliente;
    }

    public void setPlanConsumo(PlanConsumo planConsumo) {
        this.planconsumo_id = planConsumo;
    }




    

}
