package sonidosApp;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;

public class ReproductorSonido extends JFrame {

    // Constructor de la clase ReproductorSonido
    public ReproductorSonido() {
        setTitle("Reproductor de Efectos de Sonido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botón para reproducir el sonido de "Aplausos"
        JButton btnAplausos = new JButton("Aplausos");
        btnAplausos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirSonido("aplausos.wav");
            }
        });

        // Botón para reproducir el sonido de "Campana"
        JButton btnCampana = new JButton("Campana");
        btnCampana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirSonido("campana.wav");
            }
        });

        // Botón para reproducir el sonido de "Explosión"
        JButton btnExplosio = new JButton("Explosión");
        btnExplosio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirSonido("explosion.wav");
            }
        });

        // Añadir los botones a la ventana
        add(btnAplausos);
        add(btnCampana);
        add(btnExplosio);

        // Configurar la ventana
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Método para reproducir el sonido
    private void reproducirSonido(String archivo) {
        try {
            // Cargar el archivo WAV desde el classpath (dentro de la carpeta resources en bin)
            URL url = getClass().getResource("/resources/" + archivo);  // Cambié esta línea para usar el classpath
            if (url != null) {
                try {
                    File sonidoFile = new File(url.toURI()); // Llama a toURI() para convertir la URL a URI
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(sonidoFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start(); // Reproducir el sonido
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al convertir la URL a URI: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el archivo: " + archivo);
            }
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al reproducir el sonido: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Crear la instancia de la aplicación
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReproductorSonido();
            }
        });
    }
}


