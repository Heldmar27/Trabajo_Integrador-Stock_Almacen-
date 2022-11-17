import Exepciones.ExepcionPropia;
import Exepciones.ExeptionCampoVacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregar extends JFrame{
    private JPanel panelAgregar;
    private JTextField textFieldCantidad;
    private JTextField textFieldProducto;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JLabel labelTitulo;
    private JLabel labelNombre;
    private JLabel labelCantidad;

    public VentanaAgregar(Producto producto){
        setSize(500,250);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(panelAgregar);
        textFieldProducto.setText(producto.getNombre());


        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    textFieldProducto.setText(producto.getNombre());
                    int cantidad = Integer.parseInt(textFieldCantidad.getText());

                    ExepcionPropia.estaCampoVacio(String.valueOf(cantidad));

                    producto.agregarCantidad(cantidad);
                    Ventana.limpiarTabla();
                    Ventana.mostrarTabla();

                    dispose();

                } catch (ExeptionCampoVacio ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"El campo esta vacio!");
                } catch (NumberFormatException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"El campo necesita un numero!");
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }
}
