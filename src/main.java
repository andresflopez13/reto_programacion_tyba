import co.com.tyba.reto.data.ArchivosCsv;
import co.com.tyba.reto.front.App;
import co.com.tyba.reto.model.Persona;
import co.com.tyba.reto.model.Producto;
import co.com.tyba.reto.model.TipoDocumento;
import org.omg.Messaging.SyncScopeHelper;

import javax.swing.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new App();
                frame.setSize(300,500);
                frame.setVisible(true);
            }
        });
    }
}
