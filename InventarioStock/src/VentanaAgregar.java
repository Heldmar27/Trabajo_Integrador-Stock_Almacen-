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

                textFieldProducto.setText(producto.getNombre());
                int cantidad = Integer.parseInt(textFieldCantidad.getText());

                producto.agregarCantidad(cantidad);
                Ventana.limpiarTabla();
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
