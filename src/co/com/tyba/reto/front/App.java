package co.com.tyba.reto.front;

import co.com.tyba.reto.data.ArchivosCsv;
import co.com.tyba.reto.model.Persona;
import co.com.tyba.reto.model.Producto;
import co.com.tyba.reto.model.TipoDocumento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App extends JFrame{
    private JPanel panel;
    private JLabel title;
    private JTextField textUsuario;
    private JTextField textContraseña;
    private JButton buttonLogin;
    private JLabel candado;
    private JLabel sobre;

    private static ArrayList<Persona> personas;

    public App() {
        cargarInformacion();
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona persona = login(textUsuario.getText(),textContraseña.getText());
                if (persona!=null){
                    JOptionPane.showMessageDialog(panel,"Se ha logueado correctamente");
                    JFrame frame = new Consulta(persona.getNombre(),persona.getTipoDocumento());
                    frame.setSize(300,500);
                    frame.setVisible(true);
                    dispose();
                }else{
                    System.out.println("El usuario no existe....");
                }

            }
        });
    }

    public static void cargarInformacion(){
        ArchivosCsv archivosCsv = new ArchivosCsv();
        personas = archivosCsv.leerArchivoPersonas();
    }

    public Persona login(String usuario, String contasenia){
        for (Persona persona: personas){
            if (usuario.equals(persona.getNumeroDocumento()) && contasenia.equals(persona.getContrasenia())){
                return persona;
            }
        }
        return null;
    }
}
