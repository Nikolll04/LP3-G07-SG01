package temperaturaApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperaturaSemana extends JFrame {

    private final JTextField[] txtTemperaturas = new JTextField[7];
    private final String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    private final JPanel panelGrafico;

    public TemperaturaSemana() {
        setTitle("Temperatura Semanal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelEntrada = new JPanel(new GridLayout(7, 2, 5, 5));
        for (int i = 0; i < 7; i++) {
            panelEntrada.add(new JLabel(dias[i] + ":"));
            txtTemperaturas[i] = new JTextField();
            // Validación: solo números
            txtTemperaturas[i].addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                        e.consume(); // Evita que se ingrese cualquier cosa que no sea un número
                        // Mostrar mensaje de error
                        JOptionPane.showMessageDialog(TemperaturaSemana.this, 
                            "No se pueden ingresar letras, solo números.", 
                            "Error de entrada", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            panelEntrada.add(txtTemperaturas[i]);
        }

        JButton btnMostrar = new JButton("Mostrar Gráfico");
        btnMostrar.addActionListener(e -> mostrarGrafico());

        // Aquí extraemos la clase anónima en una clase separada
        panelGrafico = new PanelGrafico();
        panelGrafico.setPreferredSize(new Dimension(600, 400));  // Definimos un tamaño para el panel gráfico

        add(panelEntrada, BorderLayout.NORTH);
        add(btnMostrar, BorderLayout.CENTER);
        add(panelGrafico, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarGrafico() {
        panelGrafico.repaint(); // Se ejecuta repaint para redibujar el gráfico
    }

    private class PanelGrafico extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            dibujarGrafico((Graphics2D) g);
        }

        private void dibujarGrafico(Graphics2D g2d) {
            int[] temperaturas = new int[7];
            boolean error = false;
            for (int i = 0; i < 7; i++) {
                try {
                    temperaturas[i] = Integer.parseInt(txtTemperaturas[i].getText());
                } catch (NumberFormatException e) {
                    temperaturas[i] = 0; // Valor por defecto si hay error
                    error = true;
                }
            }
            if (error) {
                g2d.drawString("Error: Ingrese valores numéricos válidos.", 20, 20);
                return;
            }

            int ancho = getWidth();
            int alto = getHeight();
            int margen = 20;
            int anchoBarra = (ancho - 2 * margen) / 7;

            int maxTemp = 0;
            for (int temp : temperaturas) {
                maxTemp = Math.max(maxTemp, temp);
            }

            g2d.setColor(Color.BLACK);
            g2d.drawLine(margen, alto - margen, margen, margen);
            g2d.drawLine(margen, alto - margen, ancho - margen, alto - margen);

            g2d.setColor(Color.BLUE);
            for (int i = 0; i < 7; i++) {
                int x = margen + i * anchoBarra + anchoBarra / 2;
                int y = alto - margen - (temperaturas[i] * (alto - 2 * margen)) / maxTemp; // Escala la temperatura
                g2d.fillOval(x - 3, y - 3, 6, 6); // Punto
                if (i > 0) {
                    int prevX = margen + (i - 1) * anchoBarra + anchoBarra / 2;
                    int prevY = alto - margen - (temperaturas[i - 1] * (alto - 2 * margen)) / maxTemp;
                    g2d.drawLine(prevX, prevY, x, y); // Línea
                }
            }
        }
    }

    public static void main(String[] args) {
        new TemperaturaSemana();
    }
}
