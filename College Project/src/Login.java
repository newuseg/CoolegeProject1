
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Login extends JFrame implements ActionListener {
    JPanel panel;
    JLabel opt, unm, pass, code, heading;
    Choice loginChoice;
    JTextField unmField, codeField;
    JPasswordField passField; // Use JPasswordField for password input
    JButton loginButton, registerButton, exitButton, refreshButton, funmButton, fpassButton;
    int a = 0;
    // Generate a Random Value for Verification Code...
    int random = (int) (Math.random() * 1000000);

    public Login() {
        // Set up the panel
        panel = new JPanel();
        panel.setBounds(500, 100, 380, 470);
        panel.setBackground(new Color(245, 114, 7, 200));
        panel.setLayout(null); // Use null layout for absolute positioning
        add(panel);

        // Load and scale the image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/login.jpg"));
        Image image = icon.getImage().getScaledInstance(1400, 720, Image.SCALE_DEFAULT);
        ImageIcon i_icon = new ImageIcon(image);
        JLabel imgLabel = new JLabel(i_icon);
        imgLabel.setBounds(0, 0, 580, 600); // Positioning the image label
        add(imgLabel);

        // Initialize labels
        heading = new JLabel("<html><font size='7'>L o g i n</font></html>");
        heading.setBounds(130, 35, 150, 50);
        heading.setForeground(new Color(10, 200, 200));
        panel.add(heading);

        opt = new JLabel("<html><font size='5'>Search As</font></html>");
        opt.setBounds(50, 115, 90, 25);
        opt.setForeground(new Color(30, 30, 30));
        loginChoice = new Choice();
        loginChoice.add("User");
        loginChoice.add("Admin");
        loginChoice.setBounds(180, 110, 150, 30);
        loginChoice.setFont(new Font("Aral", Font.PLAIN, 20));

        unm = new JLabel("<html><font size='5'>Username</font></html>");
        unm.setBounds(50, 155, 100, 25);
        unm.setForeground(new Color(30, 30, 30));
        unmField = new JTextField();
        unmField.setBounds(180, 150, 150, 30);
        unmField.setFont(new Font("Arial", Font.PLAIN, 20));

        pass = new JLabel("<html><font size='5'>Password</font></html>");
        pass.setBounds(50, 195, 100, 25);
        pass.setForeground(new Color(30, 30, 30));
        passField = new JPasswordField(); // Changed to JPasswordField for password security
        passField.setBounds(180, 190, 150, 30);
        passField.setFont(new Font("Arial", Font.PLAIN, 20));

        code = new JLabel("<html><font size='6'>" + random + "</font></html>"); // Displaying the random code as a string
        code.setBounds(50, 240, 80, 25);
        code.setForeground(new Color(70, 70, 70));
        codeField = new JTextField();
        codeField.setBounds(180, 230, 150, 30);
        codeField.setFont(new Font("Arial", Font.PLAIN, 20));

        // Buttons for actions
        loginButton = new JButton("<html><font size='6'>L o g i n</font></html>");
        loginButton.setBounds(60, 315, 260, 40);
        loginButton.setBorderPainted(false);
        loginButton.setBackground(Color.GREEN);
        loginButton.setForeground(new Color(100, 10, 100));

        registerButton = new JButton("<html><font size='6'>Register</font></html>");
        registerButton.setBounds(60, 370, 125, 40);
        registerButton.setBackground(new Color(218, 83, 10));
        registerButton.setForeground(new Color(202, 199, 15));

        exitButton = new JButton("<html><font size='6'>Exit</font></html>");
        exitButton.setBounds(195, 370, 125, 40);
        exitButton.setBackground(new Color(218, 83, 10));
        exitButton.setForeground(new Color(202, 199, 24));

        refreshButton = new JButton();
        refreshButton.setBounds(135, 235, 35, 35);
        refreshButton.setBackground(new Color(245, 114, 7, 150));
        refreshButton.setBorderPainted(false);
        ImageIcon ref = new ImageIcon(getClass().getResource("/img/refres.png"));
        Image img = ref.getImage();
        Image newImage = img.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ref = new ImageIcon(newImage);
        refreshButton.setIcon(ref);

        funmButton = new JButton("<html><font size='3'>Forget Username?</font></html>");
        funmButton.setBounds(50, 285, 145, 15);
        funmButton.setBackground(new Color(245, 114, 7, 150));
        funmButton.setForeground(new Color(20, 20, 20));
        funmButton.setBorderPainted(false);         // Remove Border...
        panel.add(funmButton);
        funmButton.addActionListener(this);

        fpassButton = new JButton("<html><font size='3'>Forget Password?</font></html>");
        fpassButton.setBounds(190, 285, 145, 15);
        fpassButton.setBackground(new Color(245, 114, 7, 150));
        fpassButton.setForeground(new Color(20, 20, 20));
        fpassButton.setBorderPainted(false);
        panel.add(fpassButton);
        fpassButton.addActionListener(this);

        // Adding components to the panel
        panel.add(opt);
        panel.add(unm);
        panel.add(pass);
        panel.add(code);
        panel.add(loginChoice);
        panel.add(unmField);
        panel.add(passField);
        panel.add(codeField);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(exitButton);
        panel.add(refreshButton);

        // Adding action listeners
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        exitButton.addActionListener(this);
        refreshButton.addActionListener(this);

        setTitle("Login Interface");
        setSize(1400, 750); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true); // Make the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String type = loginChoice.getSelectedItem();
            String username = unmField.getText();
            String password = new String(passField.getPassword());
            String enteredCode = codeField.getText();
            if (loginChoice.getSelectedItem().equals("Admin")) {
                a = 1;
            }
            if (username.equals("")) {
                JOptionPane.showMessageDialog(this, "Enter Username...");
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(this, "Enter Password...");
            } else if (enteredCode.equals(String.valueOf(random))) {
                try{
                    database db = new database();
                    String query = "SELECT * FROM LoginData WHERE type = '"+type+"' AND username = '"+username+"' AND password = '"+password+"'";
                    ResultSet resultSet = db.statement.executeQuery(query);
                    if (resultSet.next()) {
                        // Login successful
                        JOptionPane.showMessageDialog(Login.this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        // if (a == 0) {
                            String dbtyp= resultSet.getString("Type");
                            String dbnm= resultSet.getString("Name");
                            Dashboard dbu = new Dashboard(dbtyp, dbnm);
                            // Dashboard.setVisible(true);
                            this.dispose();
                        // } else {
                        //     new Dashboard();      dispose();
                        // }
                    } else {
                        // Login failed
                        JOptionPane.showMessageDialog(this, "Invalid username or password");
                    }
                }catch (SQLException E){
                    JOptionPane.showMessageDialog(this, "Login failed: " + E.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    E.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Verification Code");
            }
        } else if (e.getSource() == registerButton) {
            new Register();         dispose();
        } else if (e.getSource() == exitButton) {
            System.exit(0); // Exit the application
        } else if (e.getSource() == refreshButton) {
            random = (int) (Math.random() * 1000000); // Generate a new random code
            code.setText("<html><font size='6'>" + random + "</font></html>"); // Update displayed code
        } else if (e.getSource() == funmButton) {
            new Forgetunm();       dispose();
        } else if (e.getSource() == fpassButton) {
            new Forgetpass();      dispose();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new); // Run the GUI in the Event Dispatch Thread
    }
}
