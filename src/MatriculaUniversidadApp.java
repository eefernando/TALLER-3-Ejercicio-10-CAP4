import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatriculaUniversidadApp extends JFrame implements ActionListener {
    private JLabel inscripcionLabel, nombresLabel, patrimonioLabel, estratoLabel, matriculaLabel;
    private JTextField inscripcionField, nombresField, patrimonioField, estratoField;
    private JButton calcularButton;

    public MatriculaUniversidadApp() {
        // Configurar la ventana
        setTitle("Calculadora de Matrícula Universitaria");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de la interfaz
        inscripcionLabel = new JLabel("Número de Inscripción:");
        inscripcionField = new JTextField(10);
        nombresLabel = new JLabel("Nombres:");
        nombresField = new JTextField(30);
        patrimonioLabel = new JLabel("Patrimonio:");
        patrimonioField = new JTextField(10);
        estratoLabel = new JLabel("Estrato Social:");
        estratoField = new JTextField(5);
        calcularButton = new JButton("Calcular Matrícula");
        matriculaLabel = new JLabel();

        // Agregar componentes a la ventana
        add(inscripcionLabel);
        add(inscripcionField);
        add(nombresLabel);
        add(nombresField);
        add(patrimonioLabel);
        add(patrimonioField);
        add(estratoLabel);
        add(estratoField);
        add(calcularButton);
        add(matriculaLabel);

        // Manejar el evento del botón Calcular Matrícula
        calcularButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // Obtener los datos ingresados por el usuario
            String inscripcion = inscripcionField.getText();
            String nombres = nombresField.getText();
            double patrimonio = Double.parseDouble(patrimonioField.getText());
            int estrato = Integer.parseInt(estratoField.getText());

            // Calcular el costo de matrícula
            double costoMatricula = 50000; // Valor constante de matrícula

            // Verificar condiciones para incremento
            if (patrimonio > 2000000 && estrato > 3) {
                costoMatricula += patrimonio * 0.03; // Incremento del 3% sobre el patrimonio
            }

            // Mostrar los resultados en la etiqueta
            matriculaLabel.setText("Número de Inscripción: " + inscripcion + "\nNombres: " + nombres + "\nPago de Matrícula: $" + costoMatricula);
        } catch (NumberFormatException ex) {
            matriculaLabel.setText("Error: Ingresa valores numéricos válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MatriculaUniversidadApp app = new MatriculaUniversidadApp();
            app.setVisible(true);
        });
    }
}
