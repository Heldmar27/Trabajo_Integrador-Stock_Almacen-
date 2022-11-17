import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Almacen implements Serializable {

    ArrayList<Producto> listaProductos = new ArrayList<>();
    private GeneradorID generadorID = new GeneradorID(0);

    //Métodos
    public void agregarProducto(String nombre, double precio, int cantidad){
        if(!existeProducto(nombre)){
            listaProductos.add(new Producto(nombre, generadorID.generarID(),cantidad,precio));
        } else {
            JOptionPane.showMessageDialog(null,"El producto ya existe!");
        }
    }

    public void retirarProducto(Producto producto, int cantidad){
        producto.retirarCantidad(cantidad);
    }

    public void verProductos() {
        for (Producto producto: listaProductos) {
            System.out.println(producto.getNombre() + "\n");
        }
    }

    public boolean existeProducto(String nombre){
        for (Producto p: listaProductos) {
            if (p.comparar(nombre)) return true;
        }
        return false;
    }

    public String verInforme(){
        String informe = "";
        int cant = 0;

        for (Producto p :listaProductos) {
            if (p.pocoStock()){
                informe += p.getNombre() + "\n";
                cant++;
            }
        }

        if (cant > 0){
            return "Productos con poco Stock: \n" + informe;
        } else return "Todo esta bien!";
    }

    public void modificarProducto(String nombre , double precio){

        for (Producto p:listaProductos) {
            if(p.comparar(nombre)){
                p.setPrecio(precio);
            }
        }
    }
}