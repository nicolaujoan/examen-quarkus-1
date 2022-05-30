package edu.poniperro;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import edu.poniperro.dominio.Item;
import edu.poniperro.dominio.Orden;
import edu.poniperro.dominio.Usuaria;

@ApplicationScoped
public class ServiceOlli {
    
    public Usuaria cargaUsuaria(String name) {
        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(name);
        return usuaria.isPresent() ?
            usuaria.get():
            new Usuaria("", 0);
    }

    public Item cargaItem(String name) {
        Optional<Item> item = Item.findByIdOptional(name);
        return item.isPresent() ?
            item.get():
            new Item("", 0);       
    }

    public List<Orden> cargaOrden(String name) {
        List<Orden> ordenes = Orden.list("ord_user", name);
        return ordenes;
    }

    public Orden comanda(String UserName, String itemName) {
        return null;
    }
}
