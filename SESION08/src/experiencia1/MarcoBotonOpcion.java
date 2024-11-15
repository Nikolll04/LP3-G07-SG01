import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MarcoBotonOpcion extends JFrame {
    private final JTextField campoTexto;
    private final Font tipoLetraSimple;
    private final Font tipoLetraNegrita;
    private final Font tipoLetraCursiva;
    private final Font tipoLetraNegritaCursiva;
    private final JRadioButton simpleJRadioButton;
    private final JRadioButton negritaJRadioButton;
    private final JRadioButton cursivaJRadioButton;
    private final JRadioButton negritaCursivaJRadioButton;
    private final ButtonGroup grupoOpciones;

    public MarcoBotonOpcion() {
        super("Prueba de RadioButton - [Integrantes del Grupo]");
        setLayout(new FlowLayout());

        campoTexto = new JTextField("Observe el cambio en el estilo del tipo de letra", 25);
        add(campoTexto);

        simpleJRadioButton = new JRadioButton("Simple", true);
        negritaJRadioButton = new JRadioButton("Negrita", false);
        cursivaJRadioButton = new JRadioButton("Cursiva", false);
        negritaCursivaJRadioButton = new JRadioButton("Negrita/Cursiva", false);
        add(simpleJRadioButton);
        add(negritaJRadioButton);
        add(cursivaJRadioButton);
        add(negritaCursivaJRadioButton);

        grupoOpciones = new ButtonGroup();
        grupoOpciones.add(simpleJRadioButton);
        grupoOpciones.add(negritaJRadioButton);
        grupoOpciones.add(cursivaJRadioButton);
        grupoOpciones.add(negritaCursivaJRadioButton);

        tipoLetraSimple = new Font("Serif", Font.PLAIN, 14);
        tipoLetraNegrita = new Font("Serif", Font.BOLD, 14);
        tipoLetraCursiva = new Font("Serif", Font.ITALIC, 14);
        tipoLetraNegritaCursiva = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        campoTexto.setFont(tipoLetraSimple);

        simpleJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraSimple));
        negritaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegrita));
        cursivaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraCursiva));
        negritaCursivaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegritaCursiva));
    }

    private class ManejadorBotonOpcion implements ItemListener {
        private final Font tipoLetra;

        public ManejadorBotonOpcion(Font f) {
            tipoLetra = f;
        }

        @Override
        public void itemStateChanged(ItemEvent evento) {
            campoTexto.setFont(tipoLetra);
        }
    }
}
