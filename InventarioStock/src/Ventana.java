import Exepciones.ExeptionCampoVacio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class Ventana extends JFrame {

    static Almacen almacen;
    private Archivo archivo = new Archivo();
    private String [] culumnas = {"id","nombre","precio","cantidad"};
    private String[][] info;
    private MyTableModel model = new MyTableModel(info,culumnas);


    private JTextField LeerCantidad;
    private JPanel panel1;
    private JTextField LeerNombre;
    private JButton actualizarButton;
    private JTable table1;
    private JButton retirarButton;
    private JButton agregarButton;
    private JButton verInformeButton;
    private JScrollPane JScrollPane;
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

        table1.setModel(model);

        mostrarTabla();


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String nombre = LeerNombre.getText();
                    int cantidad = Integer.parseInt(LeerCantidad.getText());
                    double precio = Double.parseDouble(LeerPrecio.getText());
                    verificarCampos(LeerNombre.getText(),LeerCantidad.getText(),LeerPrecio.getText());

                    limpiarTabla();
                    almacen.agregarProducto(nombre,precio,cantidad);
                    mostrarTabla();
                } catch (ExeptionCampoVacio exeption){
                    exeption.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Campos vacios");
                } catch (Exception exception){
                    exception.printStackTrace();
                    String msj = "";
                    if (LeerNombre.getText().isEmpty() ||
                            LeerPrecio.getText().isEmpty() ||
                            LeerCantidad.getText().isEmpty()){
                        msj += "1 o mas Campos vacios\n";
                    }
                    JOptionPane.showMessageDialog(null, msj +"Campos cantidad y precio, solo pueden ser numeros");
                }


            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = LeerNombre.getText();
                double precio = Double.parseDouble(LeerPrecio.getText());
                int cantidad = Integer.parseInt(LeerCantidad.getText());

                System.out.println(table1.getSelectedRow());
                Producto actualizarP = almacen.listaProductos.get(table1.getSelectedRow());
                actualizarP.modificar(nombre,precio,cantidad);

                almacen.verProductos();

                limpiarTabla();
                mostrarTabla();

            }
        });

        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String nombre = LeerNombre.getName();
                int cantidad = Integer.parseInt(LeerCantidad.getText());

                if(almacen.existeProducto(nombre)){
                    //almacen.retirarProducto();
                }

            }
        });


        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Producto producto = almacen.listaProductos.get(table1.getSelectedRow());

                LeerNombre.setText(producto.getNombre());
                LeerCantidad.setText(String.valueOf(producto.getCantidad()));
                LeerPrecio.setText(String.valueOf(producto.getPrecio()));
            }
        });

        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                LeerNombre.setText("");
                LeerCantidad.setText("");
                LeerPrecio.setText("");

                table1.clearSelection();
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


    private void mostrarTabla(){
        almacen.verProductos();

        for (Producto p: almacen.listaProductos) {
            String[] datos = {Integer.toString(p.getId()), p.getNombre(),String.valueOf(p.getPrecio()), String.valueOf(p.getCantidad())};
            System.out.println(datos[0]+ " " + datos[1] + " " + datos[2] + " " + datos[3]);
            model.addRow(datos);
        }
    }

    private void limpiarTabla(){
        for (int i = 0; i < almacen.listaProductos.size() ; i++){
            System.out.println("-- limpiar table --");
            System.out.println(almacen.listaProductos.get(i).getNombre());
            model.removeRow(0);
        }
    }

    private void verificarCampos(String campo1, String campo2, String campo3) throws ExeptionCampoVacio{

        if (campo1.isEmpty() || campo2.isEmpty() || campo3.isEmpty()){
            ExeptionCampoVacio nuevaExepcion = new ExeptionCampoVacio("Campos vacios");
            throw nuevaExepcion;
        }
    }


}
