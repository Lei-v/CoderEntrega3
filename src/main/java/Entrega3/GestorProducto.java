package Entrega3;


import jakarta.persistence.*;

import java.util.List;

public class GestorProducto {
    public void create(String nombre, Integer precio, Integer stock) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Producto producto = new Producto(nombre, precio, stock);
        manager.persist(producto);
        manager.getTransaction().commit();
        manager.close();
    }
    public List<Producto> readAll() {
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Producto> lista = manager.createQuery("From Producto", Producto.class).getResultList();
        manager.close();
        return lista;
    }
    public Producto readById(Integer id) {
        EntityManager manager = GestorGenerico.getEntityManager();
        Producto producto = manager.find(Producto.class, id);
        manager.close();
        return producto;
    }
    public void addToCart(Cliente cliente, Producto producto) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        cliente.getCarrito().add(producto);
        manager.merge(cliente);
        manager.getTransaction().commit();
        manager.close();
    }
    public void removeToCart(Cliente cliente, Producto producto) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        cliente.getCarrito().remove(producto);
        manager.merge(cliente);
        manager.getTransaction().commit();
        manager.close();
    }
}