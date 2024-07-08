package Entrega4.managers;

import jakarta.persistence.Id;

public class Main {
    public static void main(String[] args) {
        ProductManager product = new ProductManager();
        product.create(name;"Remeras", stock; "50",price ; 35700);
        product.create(name;"Camisas ",stock; "100",price ; 20000);
        product.create(name;"Musculosas" stock; "600",price ; 25000):
        System.out.println(product,readOne (id;1));
        ClientManager client = new ClientManager();
        client.create(name; "Leila" docnumber:25364);
        client.create(name; "Fernando"docnumber: 25483);
        System.out.println(client,readOne(id;1));
}
