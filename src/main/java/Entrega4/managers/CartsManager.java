package Entrega4.managers;

import Entrega4.entities.Product;
import Entrega4.entities.Client;
import Entrega4.entities.Cart;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CartsManager {

    public void addToCart(int amount, Product product, Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = Manager.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Cart cart = new Cart();
            cart.setAmount(amount);
            cart.setPrice(product.getPrice());
            cart.setClient(client);
            cart.setProduct(product);

            entityManager.persist(cart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error adding to cart: " + e.getMessage());
        } finally {
            Manager.closeEntityManager(entityManager);
        }
    }

    public void removeFromCart(Product product, Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = Manager.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Cart cart = entityManager.createQuery("SELECT c FROM Cart c WHERE c.product = :product AND c.client = :client", Cart.class)
                    .setParameter("product", product)
                    .setParameter("client", client)
                    .getSingleResult();

            entityManager.remove(cart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error removing from cart: " + e.getMessage());
        } finally {
            Manager.closeEntityManager(entityManager);
        }
    }

    public List<Cart> readByClient(Client client) {
        EntityManager entityManager = null;
        try {
            entityManager = Manager.getEntityManager();
            return entityManager.createQuery("SELECT c FROM Cart c WHERE c.client = :client", Cart.class)
                    .setParameter("client", client)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error reading carts by client: " + e.getMessage());
            return null;
        } finally {
            Manager.closeEntityManager(entityManager);
        }
    }
}
