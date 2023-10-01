package main.java.uniandes.edu.co.app.model;

import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private Integer numEstrellas;

    public Hotel() {;}

    public Hotel(String nombre, Integer numEstrellas) {
        this.nombre = nombre;
        this.numEstrellas = numEstrellas;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumEstrellas() {
        return numEstrellas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumEstrellas(Integer numEstrellas) {
        this.numEstrellas = numEstrellas;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", nombre=" + nombre + ", numEstrellas=" + numEstrellas + "]";
    }
    
    
}
