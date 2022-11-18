import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame {

    static Almacen almacen;
    private Archivo archivo = new Archivo();
    private static String [] columnas = {"id","nombre","precio","cantidad"};
    private static MyTableModel model = new MyTableModel(null, columnas);


    private JTextField LeerCantidad;
    private JPanel panel1;
    private JTextField LeerNombre;
    private JButton actualizarButton;
    private JTable tableProducto;
    private JButton retirarButton;
    private JButton agregarButton;
    private JButton verInformeButton;
    private JScrollPane JScrollPane;
    private JLabel label1;
    private JButton nuevoProductoButton;
    private JTextField LeerPrecio;

    public Ventana(){

        setSize(800,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel1);

        if(archivo.leer() == null){
            almacen = new Almacen();
        }else {
            almacen = archivo.leer();
        }

        model.setColumnIdentifiers(columnas);
        tableProducto.setModel(model);

        mostrarTabla();

        // Botones
        nuevoProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaNuevoProducto ventanaNuevoProducto = new VentanaNuevoProducto();
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tableProducto.getSelectedRow() != -1){
                    Producto productoSeleccionado = almacen.listaProductos.get(tableProducto.getSelectedRow());

                    VentanaAgregar ventanaAgregar = new VentanaAgregar(productoSeleccionado);
                } else {
                    JOptionPane.showMessageDialog(null,"Debe selecionar un elemento de la tabla!");
                }

            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tableProducto.getSelectedRow() != -1){

                    Producto productoActualizar = almacen.listaProductos.get(tableProducto.getSelectedRow());

                    VentanaActualizar ventanaActualizar = new VentanaActualizar(productoActualizar);
                }else {
                    JOptionPane.showMessageDialog(null,"Debe selecionar un elemento de la tabla!");
                }

            }
        });

        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tableProducto.getSelectedRow() != -1){

                    Producto productoRetirar = almacen.listaProductos.get(tableProducto.getSelectedRow());

                    VentanaRetirar ventanaRetirar = new VentanaRetirar(productoRetirar);
                }else {
                    JOptionPane.showMessageDialog(null,"Debe selecionar un elemento de la tabla!");
                }

            }
        });


        tableProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Producto producto = almacen.listaProductos.get(tableProducto.getSelectedRow());

                LeerNombre.setText(producto.getNombre());
                LeerCantidad.setText(String.valueOf(producto.getCantidad()));
                LeerPrecio.setText(String.valueOf(producto.getPrecio()));
            }
        });


        verInformeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String informe = almacen.verInforme();
                JOptionPane.showMessageDialog(null,informe);
            }
        });

    }


    public static void mostrarTabla(){

        for (Producto p: almacen.listaProductos) {
            String[] datos = {Integer.toString(p.getId()), p.getNombre(),String.valueOf(p.getPrecio()), String.valueOf(p.getCantidad())};
            System.out.println(datos[0]+ " " + datos[1] + " " + datos[2] + " " + datos[3]);
            model.addRow(datos);
        }
    }

    public static void limpiarTabla(){
        System.out.println("-- limpiar table --");
        for (int i = 0; i < almacen.listaProductos.size() ; i++){
            System.out.println(almacen.listaProductos.get(i).getNombre());
            model.removeRow(0);
        }
    }


}
