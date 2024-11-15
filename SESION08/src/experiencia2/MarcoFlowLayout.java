// Fig. 12.39: MarcoFlowLayout.java
// FlowLayout permite que los componentes fluyan a través de varias líneas.
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MarcoFlowLayout extends JFrame {
    private final JButton botonJButtonIzquierda; // botón para establecer la alineación a la izquierda
    private final JButton botonJButtonCentro; // botón para establecer la alineación al centro
    private final JButton botonJButtonDerecha; // botón para establecer la alineación a la derecha
    private final FlowLayout esquema; // objeto esquema
    private final Container contenedor; // contenedor para establecer el esquema

    // establece la GUI y registra los componentes de escucha de botones
    public MarcoFlowLayout() {
        super("Demostración de FlowLayout");

        esquema = new FlowLayout();
        contenedor = getContentPane(); // obtiene contenedor para esquema
        setLayout(esquema);

        // establece botonJButtonIzquierda y registra componente de escucha
        botonJButtonIzquierda = new JButton("Izquierda");
        add(botonJButtonIzquierda); // agrega botón Izquierda al marco
        botonJButtonIzquierda.addActionListener((ActionEvent evento) -> {
            esquema.setAlignment(FlowLayout.LEFT);
            // realinea los componentes adjuntos
            esquema.layoutContainer(contenedor);
        } // clase interna anónima
        // procesa evento de botonJButtonIzquierda
        );

        // establece botonJButtonCentro y registra componente de escucha
        botonJButtonCentro = new JButton("Centro");
        add(botonJButtonCentro); // agrega botón Centro al marco
        botonJButtonCentro.addActionListener((ActionEvent evento) -> {
            esquema.setAlignment(FlowLayout.CENTER);
            // realinea los componentes adjuntos
            esquema.layoutContainer(contenedor);
        } // clase interna anónima
        // procesa evento de botonJButtonCentro
        );

        // establece botonJButtonDerecha y registra componente de escucha
        botonJButtonDerecha = new JButton("Derecha");
        add(botonJButtonDerecha); // agrega botón Derecha al marco
        botonJButtonDerecha.addActionListener((ActionEvent evento) -> {
            esquema.setAlignment(FlowLayout.RIGHT);
            // realinea los componentes adjuntos
            esquema.layoutContainer(contenedor);
        } // clase interna anónima
        // procesa evento de botonJButtonDerecha
        );
    } // fin del constructor de MarcoFlowLayout

    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        MarcoFlowLayout marco = new MarcoFlowLayout();  // Crear una instancia de la clase
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Configurar el comportamiento de cierre
        marco.setSize(300, 100);  // Establecer el tamaño de la ventana
        marco.setVisible(true);   // Hacer visible la ventana
    }
} // fin de la clase MarcoFlowLayout
