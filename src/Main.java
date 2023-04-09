import co.com.tyba.reto.front.App;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new App();
            frame.setSize(450,550);
            frame.setVisible(true);
        });
    }
}
