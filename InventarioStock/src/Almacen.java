import java.util.ArrayList;

public class Almacen {

    ArrayList<Producto> listaProductos = new ArrayList<>();

    //Métodos
    public void agregarProducto(Producto producto){
    listaProductos.add(producto);
    }

    public void eliminarProducto(int id){
        for (Producto producto: listaProductos) {
        if (producto.getId() == id){
            listaProductos.remove(producto);
             }
        }
    }

    public void verAlmacen() {
        for (Producto producto: listaProductos) {
            System.out.println(producto.getNombre() + "\n");
        }
    }
}