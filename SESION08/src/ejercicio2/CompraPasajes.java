import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import javax.swing.SwingUtilities;

public class CompraPasajes extends JFrame {
    private final JTextField nombreField;
    private final JTextField destinoField;
    private final JTextField fechaField;  // Cambié a JTextField
    private final JButton btnConfirmar;

    public CompraPasajes() {
        setTitle("Compra de Pasajes");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Componentes
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();

        JLabel destinoLabel = new JLabel("Destino:");
        destinoField = new JTextField();

        JLabel fechaLabel = new JLabel("Fecha (dd/MM/yyyy):");
        fechaField = new JTextField();  // Usando un campo de texto simple para la fecha

        btnConfirmar = new JButton("Confirmar");

        // Añadir componentes a la ventana
        add(nombreLabel);
        add(nombreField);
        add(destinoLabel);
        add(destinoField);
        add(fechaLabel);
        add(fechaField);  // Añadiendo el campo de fecha
        add(new JLabel()); // Espacio vacío para mantener el formato
        add(btnConfirmar);

        // Acción del botón
        btnConfirmar.addActionListener((ActionEvent e) -> {
            if (validarCampos()) {
                mostrarResumen();
            }
        });
    }

    private boolean validarCampos() {
        String nombre = nombreField.getText();
        String destino = destinoField.getText();
        String fechaTexto = fechaField.getText();  // Obteniendo la fecha como texto

        // Validación para nombre (solo letras)
        if (!Pattern.matches("[a-zA-Z]+", nombre)) {
            JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación para destino (solo letras)
        if (!Pattern.matches("[a-zA-Z]+", destino)) {
            JOptionPane.showMessageDialog(this, "El destino solo debe contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación de fecha (formato dd/MM/yyyy)
        if (fechaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una fecha válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verificar formato de fecha
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(fechaTexto);  // Si la fecha no tiene el formato correcto, lanzará una excepción
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "La fecha debe tener el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void mostrarResumen() {
        String nombre = nombreField.getText();
        String destino = destinoField.getText();
        String fechaTexto = fechaField.getText();  // Fecha como texto

        String mensaje = """
                         Resumen de Compra:
                         Nombre: """ + nombre + "\n" +
                         "Destino: " + destino + "\n" +
                         "Fecha: " + fechaTexto;

        JOptionPane.showMessageDialog(this, mensaje, "Resumen", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompraPasajes app = new CompraPasajes();
            app.setVisible(true);
        });
    }
}
