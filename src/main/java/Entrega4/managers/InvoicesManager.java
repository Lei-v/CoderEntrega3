package Entrega4.managers;

public class InvoicesManager {package abm.managers;

import abm.entities.Invoice;
import abm.entities.Client;
import abm.entities.Cart;

import jakarta.persistence.*;

import java.util.List;

    public class InvoicesManager {

        public void doInvoice(Client client) {
            EntityManager entityManager = null;
            EntityTransaction transaction;
            try {
                entityManager = Manager.get();
                transaction = entityManager.getTransaction();
                transaction.begin();
                Invoice invoice = new Invoice();
                invoice.setClient(client);
                List<Cart> carts = entityManager
                        .createQuery("SELECT id FROM Cart id WHERE id.client = :client", Cart.class)
                        .setParameter("client", client).getResultList();
                for (Cart cart : carts) {
                    invoice.setAmount(invoice.getAmount()+cart.getPrice()*cart.getAmount());
                }
                entityManager.persist(invoice);
                transaction.commit();
                System.out.println(invoice.getAmount());
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                Manager.closeEntity(entityManager);
            }
        }

    }
}
