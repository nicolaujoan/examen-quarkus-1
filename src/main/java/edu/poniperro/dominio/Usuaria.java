package edu.poniperro.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_users")
public class Usuaria extends PanacheEntityBase {

    @Id()
    @Column(name = "user_nom", nullable = false)
    private String nombre;

    @Column(name = "user_prop")
    private int destreza;

    public Usuaria(){}

    public Usuaria(String nombre, int destreza) {
        this.nombre = nombre;
        this.destreza = destreza;
    }

    public Usuaria(String nombre) {
        this.nombre = nombre;
        this.destreza = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
}
