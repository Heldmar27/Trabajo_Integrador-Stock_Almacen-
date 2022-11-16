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

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNombre.setText(producto.getNombre());

                int cantidad = Integer.parseInt(textFieldCantidad.getText());
                producto.retirarCantidad(cantidad);
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
