package productoApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class GestionProducto extends JFrame {

    private final JTextField txtNombre;
    private final JTextField txtPrecio;
    private final JTextField txtCantidad;
    private final JComboBox<String> cmbCategoria;
    private final JLabel lblInformacion;
    private Producto producto;

    public GestionProducto() {
        setTitle("Gestión de Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10)); // 5 filas, 2 columnas, padding

        // Inicializar Producto (opcional, se puede iniciar vacío)
        producto = new Producto("", 0, 0, "");

        // Etiquetas y campos de texto
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        add(new JLabel("Cantidad en Stock:"));
        txtCantidad = new JTextField();
        add(txtCantidad);

        add(new JLabel("Categoría:"));
        String[] categorias = {"Electrónica", "Ropa", "Alimentos", "Otros"};
        cmbCategoria = new JComboBox<>(categorias);
        add(cmbCategoria);

        // Botón y etiqueta de información
        JButton btnActualizar = new JButton("Actualizar Producto");
        add(btnActualizar);

        lblInformacion = new JLabel("");
        lblInformacion.setVerticalAlignment(JLabel.TOP); // Alinea el texto arriba
        add(lblInformacion);

        // Validación del campo Nombre (solo letras)
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignorar caracteres no alfabéticos
                    JOptionPane.showMessageDialog(null, "El nombre del producto solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Validación del campo Precio (solo números y punto)
        txtPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != '.') {
                    e.consume(); // Ignorar caracteres no numéricos y el punto
                    JOptionPane.showMessageDialog(null, "El precio solo puede contener números.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Validación del campo Cantidad (solo números)
        txtCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignorar caracteres no numéricos
                    JOptionPane.showMessageDialog(null, "La cantidad solo puede contener números.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ActionListener para el botón
        btnActualizar.addActionListener((ActionEvent e) -> {
            actualizarProducto();
        });

        pack();
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    private void actualizarProducto() {
        try {
            String nombre = txtNombre.getText();
            // Validación adicional para nombre vacío
            if (nombre.isEmpty()) {
                lblInformacion.setText("Error: El nombre del producto no puede estar vacío.");
                return;
            }
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            String categoria = (String) cmbCategoria.getSelectedItem();

            producto = new Producto(nombre, precio, cantidad, categoria);
            lblInformacion.setText("<html>" + producto.toString() + "</html>");

        } catch (NumberFormatException ex) {
            lblInformacion.setText("Error: Ingrese datos numéricos válidos en precio y cantidad.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestionProducto::new);
    }
}
