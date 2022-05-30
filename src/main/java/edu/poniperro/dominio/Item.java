package edu.poniperro.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_items")
public class Item extends PanacheEntityBase {
    
    @Id()
    @Column(name = "item_nom")
    public String nombre;

    @Column(name = "item_prop")
    public int quality;

    @Column(name = "item_tipo")
    private String tipo;

    public Item(){}

    public Item(String nombre, int quality) {
        this.nombre = nombre;
        this.quality = quality;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    };    
}
