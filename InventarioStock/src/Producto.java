public class Producto {

    //Atributos
    private String nombre;
    private String descripcion;
    private int id;
    private int cantidad;
    private double precio;


    //Constructores
    public Producto(String nombre, int id, int cantidad, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(){

    };


    //Getter & Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
