package Entrega4.managers;

import Entrega4.entities.Client;
import Entrega4.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductManager  {
    public void create (String name, Integer Stock, double price);
    EntityManager manager = null;
    EntityTransaction transaction;
       try {
        manager = manager.get();
        transaction = manager.getTransaction();
        transaction.begin();
        Product product = new Product();
        product.setName(name);
        product.setprice(price);
        product.setstock(stock)
        manager.persist(product);
        transaction.commit();
    } catch (Exception e){
        System.out.println(e);
    }  finally {
        manager.closeEntity(manager);
    }
    public class Product    readone (Integer id)

    {
        EntityManager manager = null;
        EntityTransaction transaction1;
        try {
            manager = manager.get();
            Product product = manager.find(Product.class, id);
            return product;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            manager.closeEntity(manager);
            return Product;
        }
    }
        public List<Product> readAll() {
            EntityManager entityManager = null;
            try {
                entityManager = Manager.getEntityManager();
                return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            } catch (Exception e) {
                System.out.println("Error retrieving all products: " + e.getMessage());
                return null;
            } finally {
                manager.closeEntityManager(entityManager);
            }
        }
    }
