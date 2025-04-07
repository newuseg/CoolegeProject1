
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {
    public Main() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/header.gif"));
        Image i2 = i1.getImage().getScaledInstance(1400, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1400, 750);
        add(image);

        setSize(1400, 750);
        setTitle("Loading...");
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        try {
            Thread.sleep(3000);
            new Login();
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
