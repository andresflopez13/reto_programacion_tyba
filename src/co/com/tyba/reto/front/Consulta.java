package co.com.tyba.reto.front;

import co.com.tyba.reto.data.ArchivosCsv;
import co.com.tyba.reto.model.TipoDocumento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Consulta extends JFrame{
    private JPanel PanelConsulta;
    private JTextField textFieldNombre;
    private JTextField textFieldMonto;
    private JButton consultarButton;
    private JComboBox<String> comboBoxTipoDocumento;
    private JLabel Producto;
    private JLabel Rentabilidad;
    private JLabel Ganancia;

    private ArchivosCsv archivosCsv = new ArchivosCsv();

    public Consulta(String nombre, String tipoDocumento){
        setContentPane(PanelConsulta);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldNombre.setText(nombre);
        llenarSeleccionar();
        comboBoxTipoDocumento.setSelectedItem(tipoDocumento);
        pack();

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verificacionCampos()){
                    System.out.println("A calcular todo");
                }
            }
        });
    }

    public boolean verificacionCampos(){
        if (textFieldNombre.getText()==null||textFieldNombre.getText().isEmpty()||
                textFieldNombre.getText().matches("[0-9]+")){
            textFieldNombre.setText("");
            JOptionPane.showMessageDialog(PanelConsulta,"Por favor ingrese un nombre valido");
        }else if(comboBoxTipoDocumento.getSelectedItem()==null||
                comboBoxTipoDocumento.getSelectedItem().toString().isEmpty()){
            JOptionPane.showMessageDialog(PanelConsulta,"Por favor seleccione un tipo de documento");
        }else if (textFieldMonto.getText()==null||textFieldMonto.getText().isEmpty()||
                !textFieldMonto.getText().matches("[0-9]+")){
            textFieldMonto.setText("");
            JOptionPane.showMessageDialog(PanelConsulta,"Por favor ingrese un monto valido");
        }else{
            return true;
        }
        return false;
    }

    public void llenarSeleccionar(){
        ArrayList<TipoDocumento> tiposDocumentos = archivosCsv.leerArchivoTiposDocumentos();
        comboBoxTipoDocumento.addItem("");
        for (TipoDocumento tipoDocumento: tiposDocumentos){
            comboBoxTipoDocumento.addItem(tipoDocumento.getNombre());
        }
    }
}
