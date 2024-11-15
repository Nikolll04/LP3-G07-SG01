// Fig. 12.41: MarcoGridLayout.java
// Alterna entre dos configuraciones de GridLayout.
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MarcoGridLayout extends JFrame implements ActionListener {
    private final JButton botones[]; // arreglo de botones
    private static final String nombres[] = {"Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis"}; // Seis botones
    private final GridLayout esquema; // Objeto GridLayout que cambia de configuración

    // establece la GUI y el manejo de eventos
    public MarcoGridLayout() {
        super("Demostracion de GridLayout");

        // Inicia con GridLayout(2, 3)
        esquema = new GridLayout(2, 3); // 2 filas y 3 columnas
        setLayout(esquema); // Establece el layout del marco

        botones = new JButton[nombres.length]; // 6 botones

        // Crea los botones y los agrega al contenedor
        for (int cuenta = 0; cuenta < nombres.length; cuenta++) {
            botones[cuenta] = new JButton(nombres[cuenta]);
            botones[cuenta].addActionListener(this); // Registra el escucha de eventos
            add(botones[cuenta]); // Agrega los botones al marco
        }
    }

    // Maneja los eventos de botón
    @Override
    public void actionPerformed(ActionEvent evento) {
        // Alterna entre GridLayout(2, 3) y GridLayout(3, 2)
        if (esquema.getRows() == 2) {
            esquema.setRows(3); // Cambia a 3 filas
            esquema.setColumns(2); // Cambia a 2 columnas
        } else {
            esquema.setRows(2); // Vuelve a 2 filas
            esquema.setColumns(3); // Vuelve a 3 columnas
        }

        // Llama a revalidate() para volver a distribuir los componentes
        revalidate();
        repaint();
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        MarcoGridLayout marcoGridLayout = new MarcoGridLayout();
        marcoGridLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoGridLayout.setSize(300, 200); // Establece el tamaño de la ventana
        marcoGridLayout.setVisible(true); // Muestra la ventana
    }
}
