package experiencia1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MarcoBoton extends JFrame {
    private final JButton botonJButtonSimple;
    private final JButton botonJButtonElegante;

    public MarcoBoton() {
        super("Prueba de botones - [Integrantes del Grupo]");
        setLayout(new FlowLayout());

        botonJButtonSimple = new JButton("Boton simple");
        add(botonJButtonSimple);

        // Cargar solo la imagen insecto1.gif y mostrarla en el botón elegante
        Icon insecto1 = new ImageIcon(getClass().getResource("/insecto.jpeg"));
        botonJButtonElegante = new JButton("Boton elegante", insecto1);
        add(botonJButtonElegante);

        ManejadorBoton manejador = new ManejadorBoton();
        botonJButtonElegante.addActionListener(manejador);
        botonJButtonSimple.addActionListener(manejador);
    }

    private class ManejadorBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            JOptionPane.showMessageDialog(MarcoBoton.this, String.format(
                "Usted oprimió: %s", evento.getActionCommand()));
        }
    }

    public static void main(String[] args) {
        MarcoBoton marcoBoton = new MarcoBoton();
        marcoBoton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoBoton.setSize(300, 200);
        marcoBoton.setVisible(true);
    }
}
