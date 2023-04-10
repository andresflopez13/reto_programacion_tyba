package co.com.tyba.reto.front;

import co.com.tyba.reto.data.ArchivosCsv;
import co.com.tyba.reto.model.Producto;
import co.com.tyba.reto.model.TipoDocumento;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
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
    private JLabel imageProducto;
    private JButton ButtonVolver;
    private final ArrayList<Producto> productos;
    private final ArrayList<TipoDocumento> tiposDocumentos;
    private final DecimalFormat formato = new DecimalFormat("#,###");

    public Consulta(String nombre, String tipoDocumento){
        setContentPane(PanelConsulta);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldNombre.setText(nombre);
        ArchivosCsv archivosCsv = new ArchivosCsv();
        productos = archivosCsv.leerArchivoProductos();
        tiposDocumentos = archivosCsv.leerArchivoTiposDocumentos();
        llenarSeleccionar();
        comboBoxTipoDocumento.setSelectedItem(tipoDocumento);
        pack();

        consultarButton.addActionListener(e -> {
            if (verificacionCampos()){
                Producto producto=recomendacionProducto(Double.parseDouble(textFieldMonto.getText()));
                if (producto == null){
                    textFieldMonto.setText("");
                    Producto.setText("");
                    Rentabilidad.setText("");
                    Ganancia.setText("");
                    ImageIcon icon = new ImageIcon(new ImageIcon("src/co/com/tyba/reto/" +
                            "imagenes/cargando.png").getImage()
                            .getScaledInstance(60,60, Image.SCALE_DEFAULT));
                    imageProducto.setIcon(icon);
                }else {
                    JOptionPane.showMessageDialog(PanelConsulta,textFieldNombre.getText()+
                            " la siguiente es la recomendación que tenemos para usted según los datos ingresados");
                    Producto.setText(producto.getNombre());
                    Rentabilidad.setText((producto.getGanancia()) + "%");
                    Ganancia.setText("$"+formato.format(Math.round(Double.parseDouble(textFieldMonto.getText())
                            * (producto.getGanancia()/100))));
                    ImageIcon icon = new ImageIcon(new ImageIcon("src/co/com/tyba/reto/imagenes/"+
                            producto.getImagen() +".png").getImage()
                            .getScaledInstance(250,120, Image.SCALE_DEFAULT));
                    imageProducto.setIcon(icon);
                }
            }
        });
        ButtonVolver.addActionListener(e -> volver());
    }

    public boolean verificacionCampos(){
        if (textFieldNombre.getText()==null||textFieldNombre.getText().isEmpty()||
                textFieldNombre.getText().matches("[0-9]+")){
            textFieldNombre.setText("");
            JOptionPane.showMessageDialog(PanelConsulta,"Por favor ingrese un nombre valido");
        }else if(comboBoxTipoDocumento.getSelectedItem()==null||
                comboBoxTipoDocumento.getSelectedItem().toString().isEmpty()){
            JOptionPane.showMessageDialog(PanelConsulta,"Por favor seleccione un tipo de documento");
        }else if(verificarTipoDocumento()){
            if(textFieldMonto.getText()==null||textFieldMonto.getText().isEmpty()||
                    !textFieldMonto.getText().matches("[0-9]+")){
                textFieldMonto.setText("");
                JOptionPane.showMessageDialog(PanelConsulta,"Por favor ingrese un monto valido");
            }else{
                return true;
            }
        }else {
            JOptionPane.showMessageDialog(PanelConsulta,"Por su tipo de documento no puede invertir " +
                    "en el momento");
            volver();
        }

        return false;
    }

    public void llenarSeleccionar(){
        comboBoxTipoDocumento.addItem("");
        for (TipoDocumento tipoDocumento: tiposDocumentos){
            comboBoxTipoDocumento.addItem(tipoDocumento.getNombre());
        }
    }

    public Producto recomendacionProducto(double monto){
        for (Producto producto : productos){
            if (200000<=monto){
                if (producto.getMinimo()<=monto){
                    if (producto.getMaximo()>monto){
                       return producto;
                    }
                }
            }else {
                JOptionPane.showMessageDialog(PanelConsulta,"La inversión minima debe ser de $200.000");
                return null;
            }
        }
        JOptionPane.showMessageDialog(PanelConsulta,"Por favor no ingrese números tan grandes que " +
                "usted no tiene tanta plata");
        return null;
    }

    public boolean verificarTipoDocumento(){
        for (TipoDocumento tipoDocumento : tiposDocumentos){
            if (tipoDocumento.getNombre().equals(comboBoxTipoDocumento.getSelectedItem())){
                return tipoDocumento.getInvertir();
            }
        }
        return false;
    }

    public void volver(){
        JFrame frame = new App();
        frame.setSize(450,550);
        frame.setVisible(true);
    }
}
