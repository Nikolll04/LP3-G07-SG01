import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("unused")
public class MarcoCuadroCombinado extends JFrame {
    private final JComboBox<String> imagenesJComboBox;
    private JLabel etiqueta = new JLabel();

    private static final String nombres[] = { "insecto.jpeg", "insecto2.jpg", "insecto3.jpeg", "insecto4.jpeg" };
    private final Icon[] iconos = {
        new ImageIcon(getClass().getResource(nombres[0])),
        new ImageIcon(getClass().getResource(nombres[1])),
        new ImageIcon(getClass().getResource(nombres[2])),
        new ImageIcon(getClass().getResource(nombres[3]))
    };

    public MarcoCuadroCombinado() {
        super("Prueba de JComboBox - [Integrantes del Grupo]");
        setLayout(new FlowLayout());

        imagenesJComboBox = new JComboBox<>(nombres);
        imagenesJComboBox.setMaximumRowCount(3);

        imagenesJComboBox.addItemListener((ItemEvent evento) -> {
            if (evento.getStateChange() == ItemEvent.SELECTED) {
                // Verificar si la imagen está cargada correctamente
                System.out.println("Cargando imagen: " + nombres[imagenesJComboBox.getSelectedIndex()]);
                etiqueta.setIcon(iconos[imagenesJComboBox.getSelectedIndex()]);
            }
        });

        add(imagenesJComboBox);
        etiqueta = new JLabel(iconos[0]);
        add(etiqueta);
    }

    public static void main(String[] args) {
        MarcoCuadroCombinado marco = new MarcoCuadroCombinado();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400, 400);  // Ajusta el tamaño de la ventana
        marco.setVisible(true);   // Hacer visible la ventana
    }
}
