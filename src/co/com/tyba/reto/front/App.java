package co.com.tyba.reto.front;

import co.com.tyba.reto.data.ArchivosCsv;
import co.com.tyba.reto.model.Persona;

import javax.swing.*;
import java.util.ArrayList;

public class App extends JFrame {
    private JPanel panel;
    private JTextField textUsuario;
    private JTextField textContrasenia;
    private JButton buttonLogin;
    private JButton verificarLosFondosDeButton;
    private static ArrayList<Persona> personas;
    private JLabel titleApp;
    private JLabel candado;
    private JLabel sobre;


    public App() {
        cargarInformacion();
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        buttonLogin.addActionListener(e -> {
            if (textUsuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Por favor ingrese la cedula en el campo de usuario");
            } else if (textContrasenia.getText().isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Por favor ingrese la contraseña del usuario");
            } else {
                Persona persona = login(textUsuario.getText(), textContrasenia.getText());
                if (persona != null) {
                    JOptionPane.showMessageDialog(panel, "Se ha logueado correctamente");
                    JFrame frame = new Consulta(persona.getNombre(), persona.getTipoDocumento());
                    frame.setSize(450, 550);
                    frame.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(panel, "Por favor verifique su usuario y contraseña");
                    textContrasenia.setText("");
                }
            }
        });

        verificarLosFondosDeButton.addActionListener(e -> {
            JFrame frame = new Consulta("", "");
            frame.setSize(450, 550);
            frame.setVisible(true);
            dispose();
        });
    }

    public static void cargarInformacion() {
        ArchivosCsv archivosCsv = new ArchivosCsv();
        personas = archivosCsv.leerArchivoPersonas();
    }

    public Persona login(String usuario, String contasenia) {
        for (Persona persona : personas) {
            if (usuario.equals(persona.getNumeroDocumento()) && contasenia.equals(persona.getContrasenia())) {
                return persona;
            }
        }
        return null;
    }
}
