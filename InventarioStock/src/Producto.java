import javax.swing.*;
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
        if (cantidad > this.cantidad){
            int retirado = this.cantidad;
            this.cantidad = 0;
            JOptionPane.showMessageDialog(null,"No se puede retirar esa cantidad!\n" +
                    "Se retiro en total " +retirado);
        } else {
            JOptionPane.showMessageDialog(null,"Se retiro exitosamente!\n"+ cantidad + " de "+this.nombre);
            this.cantidad -= cantidad;
        }
    }

    public void modificar(String nombre, double precio){
        this.precio = precio;
        this.nombre = nombre;
    }

    public void agregarCantidad(int cantidad){
        this.cantidad += cantidad;
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
