import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MarcoBorderLayout extends JFrame implements ActionListener {
    private final JButton botones[]; // arreglo de botones para ocultar porciones
    private static final String nombres[] = {"Ocultar Norte", "Ocultar Sur", 
        "Ocultar Este", "Ocultar Oeste", "Ocultar Centro"};
    private final BorderLayout esquema;

    // establece la GUI y el manejo de eventos
    public MarcoBorderLayout() {
        super("Demostracion de BorderLayout");

        esquema = new BorderLayout(5, 5); // espacios de 5 píxeles
        setLayout(esquema);
        botones = new JButton[nombres.length];

        // crea objetos JButton y registra componentes de escucha para ellos
        for (int cuenta = 0; cuenta < nombres.length; cuenta++) {
            botones[cuenta] = new JButton(nombres[cuenta]);
            botones[cuenta].addActionListener(this);
        }

        add(botones[0], BorderLayout.NORTH);
        add(botones[1], BorderLayout.SOUTH);
        add(botones[2], BorderLayout.EAST);
        add(botones[3], BorderLayout.WEST);
        add(botones[4], BorderLayout.CENTER);
    }

    // maneja los eventos de botón
    @Override
    public void actionPerformed(ActionEvent evento) {
        // comprueba el origen del evento y distribuye el panel de contenido de manera acorde
        for (JButton boton : botones) {
            if (evento.getSource() == boton)
                boton.setVisible(false); // oculta el botón oprimido
            else
                boton.setVisible(true); // muestra los demás botones
        }

        esquema.layoutContainer(getContentPane()); // distribuye el panel de contenido
    }

    // Método main para ejecutar el programa
    public static void main(String[] args) {
        MarcoBorderLayout marco = new MarcoBorderLayout();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400, 200);  // Tamaño de la ventana
        marco.setVisible(true);   // Hacer visible la ventana
    }
}
