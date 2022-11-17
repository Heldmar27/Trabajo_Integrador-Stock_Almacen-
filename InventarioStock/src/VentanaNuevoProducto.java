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

                String nombre = textFieldNombre.getText();
                double precio = Double.parseDouble(textFieldPrecio.getText());

                Ventana.limpiarTabla();
                Ventana.almacen.agregarProducto(nombre,precio,0);
                Ventana.mostrarTabla();

                dispose();

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
