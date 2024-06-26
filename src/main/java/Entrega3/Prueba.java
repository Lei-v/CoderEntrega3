package Entrega3;

public class Prueba {
    public static void main(String[] args) {
        try {
            GestorCliente gestorCliente = new GestorCliente();
            gestorCliente.create("igna","borraz",35249,33);
            gestorCliente.create("fran","coder",25822,33);
            GestorProducto gestorProducto = new GestorProducto();
            gestorProducto.create("zapatilla",300,10);
            gestorProducto.create("remeras",500,20);
            gestorProducto.create("chomba",400,30);
            gestorProducto.create("gorra",150,20);
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

