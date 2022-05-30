package edu.poniperro.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_ordenes")
public class Orden extends PanacheEntityBase {

    @Id
    @Column(name = "ord_id", nullable = false, updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordenId;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_user")
    private Usuaria usuaria;

    // muchos pedidos pueden tener el mismo Item    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_item", nullable = false)
    private Item item;

    public Orden(){}

    public Orden(Usuaria usuaria, Item item) {
        this.usuaria = usuaria;
        this.item = item;
    }

    public Long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Long ordenId) {
        this.ordenId = ordenId;
    }

    public Usuaria getUser() {
        return usuaria;
    }

    public void setUsuaria(Usuaria usuaria) {
        this.usuaria = usuaria;
    }

    public Item getItem() {
       return item;
    }
}
