package Entrega4.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer docnumber;

    @OneToMany(mappedBy = "client_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<Cart> Cart;

    @OneToMany(mappedBy = "client_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> Invoice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(Integer docnumber) {
        this.docnumber = docnumber;
    }

    public List<Entrega4.entities.Cart> getCart() {
        return Cart;
    }

    public void setCart(List<Entrega4.entities.Cart> cart) {
        Cart = cart;
    }

    public List<Entrega4.entities.Invoice> getInvoice() {
        return Invoice;
    }

    public void setInvoice(List<Entrega4.entities.Invoice> invoice) {
        Invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(docnumber, client.docnumber) && Objects.equals(Cart, client.Cart) && Objects.equals(Invoice, client.Invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, docnumber, Cart, Invoice);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", docnumber=" + docnumber +
                //", Cart=" + Cart +
                //", Invoice=" + Invoice +
                '}';
    }
}

