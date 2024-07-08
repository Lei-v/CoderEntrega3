package Entrega3;

public class Prueba {
    public static void main(String[] args) {
        try {
            GestorCliente gestorCliente = new GestorCliente();
            gestorCliente.create("Lucas","Perez",27005,38);
            gestorCliente.create("Fernando","Gomez",14257,36);
            GestorProducto gestorProducto = new GestorProducto();
            gestorProducto.create("Pantalones",510,20);
            gestorProducto.create("Buzos",600,15);
            gestorProducto.create("Camisas",250,25);
            gestorProducto.create("Musculozas",260,30);
            Cliente cliente1 = gestorCliente.readById(1);
            Producto producto1 = gestorProducto.readById(1);
            gestorProducto.addToCart(cliente1, producto1);
            gestorProducto.addToCart(gestorCliente.readById(1),gestorProducto.readById(2));
            gestorProducto.addToCart(gestorCliente.readById(1),gestorProducto.readById(3));
            gestorProducto.addToCart(gestorCliente.readById(1),gestorProducto.readById(4));
            gestorProducto.removeToCart(gestorCliente.readById(1),gestorProducto.readById(4));
            gestorProducto.addToCart(gestorCliente.readById(2),gestorProducto.readById(4));
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
