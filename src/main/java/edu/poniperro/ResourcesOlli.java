package edu.poniperro;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import edu.poniperro.dominio.Item;
import edu.poniperro.dominio.Orden;
import edu.poniperro.dominio.Usuaria;

@Path("/")
public class ResourcesOlli {

    @Inject
    public ServiceOlli service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/welcome")
    public String hello() {
        return "Welcome Ollivanders!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/usuaria/{nombre}")
    public Response getUsuariaByName(@PathParam("nombre") String name) {
        Usuaria usuaria = service.cargaUsuaria(name);
        
        return !usuaria.getNombre().isEmpty()
            ? Response.ok(usuaria).build()
            : Response.status(404).build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ordena")
    public Response getPedido(Orden orden) {
        Usuaria user = orden.getUser();
        Item item = orden.getItem();
        Orden comanda = service.comanda(user.getNombre(), item.getNombre());

        return comanda != null 
            ? Response.status(201).entity(comanda).build()
            : Response.noContent().status(404).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pedidos/{usuaria}")
    public Response getPedidos(Usuaria usuaria) {
        List<Orden> ordenes = service.cargaOrden(usuaria.getNombre());
        return Response.ok(ordenes).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/item/{nombre}")
    public Response getItem(@PathParam("nombre") String nombre) {
        Item item = service.cargaItem(nombre);

        return !item.getNombre().isEmpty()
            ? Response.ok(item).build()
            : Response.noContent().status(404).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/items")
    public Response getItems() {
        List<Item> items = service.getAllItems();
        return Response.ok(items).build();
    }
}