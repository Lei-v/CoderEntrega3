package Entrega3;


import jakarta.persistence.*;

import java.util.List;

public class GestorCliente {
    public void create(String nombre, String apellido, Integer dni, Integer edad) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Cliente cliente = new Cliente(nombre, apellido, dni, edad);
        manager.persist(cliente);
        manager.getTransaction().commit();
        manager.close();
    }
    public List<Cliente> readAll() {
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Cliente> lista = manager.createQuery("From Cliente", Cliente.class).getResultList();
        manager.close();
        return lista;
    }

    public Cliente readById(Integer id) {
        EntityManager manager = GestorGenerico.getEntityManager();
        Cliente cliente = manager.find(Cliente.class, id);
        manager.close();
        return cliente;
    }
}
