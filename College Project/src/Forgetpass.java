import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class  Forgetpass extends JFrame implements ActionListener{
    JPanel panel;
    JLabel heading, unm, code, pass;
    JTextField unmField, codeField;
    JButton submitButton, backButton, refreshButton;
    int random = (int) (Math.random() * 1000000);
    public Forgetpass(){
        panel = new JPanel();
        panel.setBounds(500, 100, 350, 400);
        panel.setBackground(new Color(245, 114, 7, 200));
        panel.setLayout(null); // Use null layout for absolute positioning
        add(panel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/login.jpg"));
        Image image = icon.getImage().getScaledInstance(1400, 720, Image.SCALE_DEFAULT);
        ImageIcon i_icon = new ImageIcon(image);
        JLabel imgLabel = new JLabel(i_icon);
        imgLabel.setBounds(0, 0, 580, 600); // Positioning the image label
        add(imgLabel);

        heading = new JLabel("<html><font size='6'>Forget Password</font></html>");
        heading.setBounds(80, 20, 200, 40);
        heading.setForeground(new Color(10, 200, 200));
        panel.add(heading);

        unm = new JLabel("<html><font size='4'>Enter Username :-</font></html>");
        unm.setBounds(90, 80, 170, 30);        
        unm.setForeground(new Color(20, 20, 20));
        panel.add(unm);
        unmField = new JTextField();
        unmField.setBounds(90, 110, 120, 22);
        unmField.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(unmField);

        code = new JLabel("<html><font size='5'>" + random + "</font></html>");
        code.setBounds(100, 140, 70, 30);
        code.setForeground(new Color(60, 60, 60));
        panel.add(code);
        refreshButton = new JButton();
        refreshButton.setBounds(165, 142, 25, 25);
        refreshButton.setBackground(new Color(245, 114, 7, 150));
        refreshButton.setBorderPainted(false);
        ImageIcon ref = new ImageIcon(getClass().getResource("/img/refres.png"));
        Image img = ref.getImage();
        Image newImage = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ref = new ImageIcon(newImage);
        refreshButton.setIcon(ref);
        refreshButton.addActionListener(this);
        panel.add(refreshButton);
        codeField = new JTextField();
        codeField.setBounds(90, 170, 110, 22);
        codeField.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(codeField);

        pass = new JLabel("");
        pass.setBounds(50, 300, 250, 60);
        pass.setForeground(new Color(179, 13, 165));
        panel.add(pass);

        submitButton = new JButton("<html><font size='5'>S U B M I T</font></html>");
        submitButton.setBounds(90, 220, 170, 30);
        submitButton.setForeground(new Color(240, 240, 240));
        submitButton.setBackground(new Color(60, 60, 60));
        panel.add(submitButton);
        submitButton.addActionListener(this);

        backButton = new JButton("<html><font size='5'>B A C K</font></html>");
        backButton.setBounds(90, 255, 170, 30);
        backButton.setForeground(new Color(240, 240, 240));
        backButton.setBackground(new Color(60, 60, 60));
        panel.add(backButton);
        backButton.addActionListener(this);
        
        setTitle("Forget Username");
        setSize(1400, 750); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true); // Make the frame visible
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String username = unmField.getText();
            String vcode = codeField.getText();
            if(username.isEmpty()){
                JOptionPane.showMessageDialog(this, "Enter Username...");
            }
            else if (vcode.equals(String.valueOf(random))) {
                try{
                    database db = new database();
                    String query = "SELECT * FROM LoginData WHERE username = ?";
                    PreparedStatement pstmt = db.connection.prepareStatement(query);
                    pstmt.setString(1, username);
                    ResultSet resultSet = pstmt.executeQuery();
                    random = (int) (Math.random() * 1000000);
                    code.setText("<html><font size='5'>" + random + "</font></html>");
                    if (resultSet.next()) {
                        String password = resultSet.getString("password");
                        pass.setText("<html><font size='5'>Password :: " + password + "</font></html>");
                        JOptionPane.showMessageDialog(this, "Password Found", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid username");
                    }
                }catch (SQLException E){
                    JOptionPane.showMessageDialog(this, "Login failed: " + E.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    E.printStackTrace();
                }
            } 
            else {
                JOptionPane.showMessageDialog(this, "Invalid Verification Code");
            }
        }
        else if (e.getSource() == refreshButton) {
            random = (int) (Math.random() * 1000000);
            code.setText("<html><font size='5'>" + random + "</font></html>");
        }
        else if (e.getSource() == backButton) {
            new Login();
            dispose();
        }
    }
    public static void main(String[] args) {
        new Forgetpass();
    }
}