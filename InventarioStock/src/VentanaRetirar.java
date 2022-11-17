import Exepciones.ExepcionPropia;
import Exepciones.ExeptionCampoVacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRetirar extends JFrame {
    private JPanel panelRetirar;
    private JTextField textFieldNombre;
    private JTextField textFieldCantidad;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JLabel labelProducto;
    private JLabel labelMax;
    private JLabel labelTitulo;
    private JLabel labelCantidad;

    public VentanaRetirar(Producto producto){
        setSize(500,250);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(panelRetirar);
        labelMax.setText("/"+producto.getCantidad());
        textFieldNombre.setText(producto.getNombre());

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    textFieldNombre.setText(producto.getNombre());

                    int cantidad = Integer.parseInt(textFieldCantidad.getText());
                    producto.retirarCantidad(cantidad);

                    ExepcionPropia.estaCampoVacio(String.valueOf(cantidad));

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
