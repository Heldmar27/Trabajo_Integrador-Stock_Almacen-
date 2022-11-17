import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaActualizar extends JFrame {
    private JPanel panelActualizar;
    private JTextField textFieldProducto;
    private JTextField textFieldCantidad;
    private JButton aceptarBotton;
    private JTextField textFieldPrecio;
    private JButton cancelarButton;
    private JLabel labelTitulo;
    private JLabel labelPrecio;
    private JLabel labelNombre;


    public VentanaActualizar(Producto producto){
        setSize(500,250);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(panelActualizar);
        textFieldProducto.setText(producto.getNombre());
        textFieldPrecio.setText(String.valueOf(producto.getPrecio()));



        aceptarBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = textFieldProducto.getText();
                double precio = Double.parseDouble(textFieldPrecio.getText());
                producto.modificar(nombre,precio);
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
