package Entrega4.entities;

import  jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private Integer stock;
    private double  price;

    @OneToMany(mappedBy = "product_id",cascade  = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> cart;

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && Objects.equals(stock, product.stock) && Objects.equals(cart, product.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stock, price, cart);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                //", cart=" + cart +
                '}';
    }
}