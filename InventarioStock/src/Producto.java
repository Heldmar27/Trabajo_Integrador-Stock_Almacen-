import java.io.Serializable;
import java.util.Locale;

public class Producto implements Serializable {

    //Atributos
    private String nombre;
    private int id;
    private int cantidad;
    private int minimo;
    private double precio;


    //Constructores
    public Producto(String nombre, int id, int cantidad, double precio) {
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.minimo = 10;
    }

    public Producto(){};

    public boolean pocoStock(){
        return cantidad <= minimo;
    }

    public boolean comparar(String nombre){
        return this.nombre.toLowerCase().equals(nombre.toLowerCase());
    }

    public void retirarCantidad(int cantidad){
        if (cantidad >= this.cantidad){
            this.cantidad = 0;
        } else {
            this.cantidad -= cantidad;
        }
    }

    public void modificar(String nombre, double precio, int cantidad){
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    //Getter & Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad -= cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
