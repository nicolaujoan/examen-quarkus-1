package edu.poniperro;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private boolean userExists(String userName) {
        return Usuaria.find("nombre", userName).count() > 0;
    }

    private boolean itemExists(String itemName) {
        return Item.find("nombre", itemName).count() > 0;
    }

    private boolean userAndItemExists(String userName, String itemName) {
        return userExists(userName) && itemExists(itemName);
    }

    private boolean isDestrezaGreaterThanQuality(String userName, String itemName) {
        Optional<Usuaria> user = Usuaria.findByIdOptional(userName);
        Optional<Item> item = Item.findByIdOptional(itemName);

        return user.isPresent() && item.isPresent()
            ? user.get().getDestreza() > item.get().getQuality()
            : false;
    }

    public Orden comanda(String userName, String itemName) {

        if (userAndItemExists(userName, itemName) && isDestrezaGreaterThanQuality(userName, itemName)) {
            Orden orden = new Orden(new Usuaria(userName), new Item(itemName));
            orden.persist();
            return orden;
        }
        return null;
    }

    public List<Orden> comandaMultiple(String userName, List<String> items) {
        if (!userExists(userName)) return Collections.<Orden>emptyList();
        
        List<Orden> comanda = items.stream()
                                .filter((i -> itemExists(i)))
                                .map((i -> new Orden(new Usuaria(userName), new Item(i))))
                                .collect(Collectors.toList());
        for (Orden orden : comanda) {
            orden.persist();
        }
        return comanda;
    }
}
