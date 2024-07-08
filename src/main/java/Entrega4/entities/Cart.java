package Entrega4.entities;

import jakarta.persistence.*;

import java.util.Objects;

//@Table(name = "carts")
@Entity
public class Cart {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;
            private Integer amount;
            private double price ;

            @ManyToOne
            @JoinColumn(name = "client_id")
            private Client client;

            @ManyToOne
            @JoinColumn(name = "product_id")
            private Product product_id;

            @ManyToOne
            @JoinColumn (name ="cliente_id")
            private  client  client_id;

            public Integer getAmount() {
                return amount;
            }

            public void setAmount(Integer amount) {
                this.amount = amount;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Product getProduct_id() {
                return product_id;
            }

            public void setProduct_id(Product product_id) {
                this.product_id = product_id;
            }

            public Client getClient() {
                return client;
            }

            public void setClient(Client client) {
                this.client = client;
            }

            public client getClient_id() {
                return client_id;
            }

            public void setClient_id(client client_id) {
                this.client_id = client_id;
            }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Double.compare(price, cart.price) == 0 && Objects.equals(id, cart.id) && Objects.equals(amount, cart.amount) && Objects.equals(client, cart.client) && Objects.equals(product_id, cart.product_id) && Objects.equals(client_id,cart.client_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, price, client, product_id, client_id);
    }
}

