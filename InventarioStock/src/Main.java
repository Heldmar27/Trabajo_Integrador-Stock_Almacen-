public class Main {

    public static void main(String[] args) {
	Producto p1 = new Producto("Papa",1,10,300);
    Producto p2 = new Producto("Cebolla",2,5,500);

    Almacen almacen = new Almacen();
    almacen.agregarProducto(p1);
    almacen.agregarProducto(p2);
    almacen.verAlmacen();
    almacen.eliminarProducto(1);
        System.out.println("----");
    almacen.verAlmacen();
    }
}
