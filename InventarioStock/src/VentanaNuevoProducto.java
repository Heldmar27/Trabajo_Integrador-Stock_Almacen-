import Exepciones.ExepcionPropia;
import Exepciones.ExeptionCampoVacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNuevoProducto extends JFrame {
    private JTextField textFieldNombre;
    private JTextField textFieldPrecio;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JLabel labelPrecio;
    private JLabel labelNombre;
    private JLabel labelTit;
    private JPanel PanelVentanaNuevoProducto;

    public VentanaNuevoProducto(){
        setSize(500,250);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(PanelVentanaNuevoProducto);


        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String nombre = textFieldNombre.getText();
                    double precio = Double.parseDouble(textFieldPrecio.getText());

                    ExepcionPropia.estaCampoVacio(nombre);

                    Ventana.limpiarTabla();
                    Ventana.almacen.agregarProducto(nombre,precio,0);
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
