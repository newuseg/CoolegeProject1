
import java.awt.Choice;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener {
    JPanel panel;
    JLabel heading, opt, nm, unm, mob, email, gender, pass, cpass, code;
    Choice choice, genderChoice;
    JTextField nmField, unmField, mobField, emailField, cpassField, codeField;
    JPasswordField passField; // Use JPasswordField for password input
    JButton loginButton, registerButton, exitButton, refreshButton;
    int random = (int) (Math.random() * 1000000);
    public Register() {
        // Set up the panel
        panel = new JPanel();
        panel.setBounds(500, 60, 450, 540);
        panel.setBackground(new Color(33, 119, 177, 220));
        panel.setLayout(null); // Use null layout for absolute positioning
        add(panel);

        // Load and scale the image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/register.jpg"));
        Image image = icon.getImage().getScaledInstance(1400, 720, Image.SCALE_DEFAULT);
        ImageIcon i_icon = new ImageIcon(image);
        JLabel imgLabel = new JLabel(i_icon);
        imgLabel.setBounds(0, 0, 580, 600); // Positioning the image label
        add(imgLabel);

        // Initialize labels
        heading = new JLabel("<html><font size='6'>R e g i s t e r</font></html>");
        heading.setBounds(160, 20, 150, 40);
        heading.setForeground(new Color(30, 240, 140));
        panel.add(heading);

        opt = new JLabel("<html><font size='4'>Register As</font></html>");
        opt.setBounds(80, 80, 90, 30);
        panel.add(opt);
        choice = new Choice();
        choice.add("User");
        choice.setBounds(220, 80, 150, 25);
        choice.setFont(new Font("Aral", Font.PLAIN, 17));
        panel.add(choice);

        nm = new JLabel("<html><font size='4'>Name</font></html>");
        nm.setBounds(80, 120, 150, 30);
        panel.add(nm);
        nmField = new JTextField();
        nmField.setBounds(220, 120, 150, 25);
        nmField.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(nmField);

        unm = new JLabel("<html><font size='4'>Username</font></html>");
        unm.setBounds(80, 160, 150, 30);
        panel.add(unm);
        unmField = new JTextField();
        unmField.setBounds(220, 160, 150, 25);
        unmField.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(unmField);
        
        mob = new JLabel("<html><font size='4'>Mobile No.</font></html>");
        mob.setBounds(80, 200, 150, 30);
        panel.add(mob);
        mobField = new JTextField();
        mobField.setBounds(220, 200, 150, 25);
        mobField.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(mobField);
        
        email = new JLabel("<html><font size='4'>Email</font></html>");
        email.setBounds(80, 240, 150, 30);
        panel.add(email);
        emailField = new JTextField();
        emailField.setBounds(220, 240, 150, 25);
        emailField.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(emailField);
        
        gender = new JLabel("<html><font size='4'>Gender</font></html>");
        gender.setBounds(80, 280, 100, 30);
        panel.add(gender);
        genderChoice = new Choice();
        genderChoice.add("Male");
        genderChoice.add("Female");
        genderChoice.add("Trans Gender");
        genderChoice.setBounds(220, 280, 150, 25);
        genderChoice.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(genderChoice);
        
        pass = new JLabel("<html><font size='4'>Password</font></html>");
        pass.setBounds(80, 320, 150, 30);
        panel.add(pass);
        passField = new JPasswordField();
        passField.setBounds(220, 320, 150, 25);
        passField.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(passField);

        cpass = new JLabel("<html><font size='4'>Confirm Password</font></html>");
        cpass.setBounds(80, 360, 150, 30);
        panel.add(cpass);
        cpassField = new JTextField();
        cpassField.setBounds(220, 360, 150, 25);
        cpassField.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(cpassField);
        
        code = new JLabel("<html><font size='5'>" + random + "</font></html>");
        code.setBounds(95, 400, 150, 30);
        code.setForeground(new Color(70, 70, 70));
        panel.add(code);
        refreshButton = new JButton();
        refreshButton.setBounds(160, 400, 25, 25);
        refreshButton.setBackground(new Color(33, 119, 177, 150));
        refreshButton.setBorderPainted(false);
        ImageIcon ref = new ImageIcon(getClass().getResource("/img/refres.png"));
        Image img = ref.getImage();
        Image newImage = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ref = new ImageIcon(newImage);
        refreshButton.setIcon(ref);
        panel.add(refreshButton);
        refreshButton.addActionListener(this);
        codeField = new JTextField();
        codeField.setBounds(220, 400, 150, 25);
        codeField.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(codeField);

        // Buttons for actions
        registerButton = new JButton("<html><font size='5'>R e g i s t e r</font></html>");
        registerButton.setBounds(100, 440, 250, 30);
        registerButton.setBackground(Color.GREEN);
        registerButton.setForeground(new Color(109, 2, 24));
        panel.add(registerButton);
        registerButton.addActionListener(this);

        loginButton = new JButton("<html><font size='5'>Login</font></html>");
        loginButton.setBounds(100, 480, 120, 30);
        loginButton.setBackground(Color.ORANGE);
        loginButton.setForeground(new Color(24, 24, 240));
        panel.add(loginButton);
        loginButton.addActionListener(this);

        exitButton = new JButton("<html><font size='5'>Exit</font></html>");
        exitButton.setBounds(230, 480, 120, 30);
        exitButton.setBackground(Color.ORANGE);
        exitButton.setForeground(new Color(24, 24, 240));
        panel.add(exitButton);
        exitButton.addActionListener(this);

        setTitle("Register Interface");
        setSize(1400, 750); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true); // Make the frame visible
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String type = "User";
            String name = nmField.getText().trim();
            String username = unmField.getText().trim();
            String mobile = mobField.getText().trim();
            String emaillll = emailField.getText().trim();
            String genderr = genderChoice.getSelectedItem();
            String password = new String(passField.getPassword());
            String cpassword = cpassField.getText().trim();
            String enteredCode = codeField.getText().trim();
            // Check for empty fields
            if (name.isEmpty() || username.isEmpty() || mobile.isEmpty() || emaillll.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill All the Information...");
            } else if (!password.equals(cpassword)) {
                JOptionPane.showMessageDialog(this, "Confirm Password Doesn't Match!!!");
            } else if (enteredCode.equals(String.valueOf(random))) {
                try {
                    database db = new database();
                    String queryu = "SELECT * FROM LoginData WHERE Username = ?";
                    PreparedStatement pstmu = db.connection.prepareStatement(queryu);
                    pstmu.setString(1, username);
                    ResultSet resultSetu = pstmu.executeQuery();
                    String querym = "SELECT * FROM LoginData WHERE Mobile_Number = ?";
                    PreparedStatement pstm = db.connection.prepareStatement(querym);
                    pstm.setString(1, mobile);
                    ResultSet resultSetm = pstm.executeQuery();
                
                    if (resultSetu.next()) {
                        JOptionPane.showMessageDialog(this, "This Username already exists", "Error", JOptionPane.WARNING_MESSAGE);
                    } else if (resultSetm.next()) {
                        JOptionPane.showMessageDialog(this, "This Mobile Number already exists", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        // Insert new user data
                        String insertQuery = "INSERT INTO LoginData (type, name, username, mobile_number, email, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement insertPstm = db.connection.prepareStatement(insertQuery);
                        insertPstm.setString(1, type);
                        insertPstm.setString(2, name);
                        insertPstm.setString(3, username);
                        insertPstm.setString(4, mobile);
                        insertPstm.setString(5, emaillll);
                        insertPstm.setString(6, genderr);
                        insertPstm.setString(7, password); // Ensure password is hashed in a real application    
                        int resultset = insertPstm.executeUpdate();        
                        if (resultset > 0) {
                            JOptionPane.showMessageDialog(this, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                            new Login(); // Assuming this opens the login window
                            dispose(); // Close the registration window
                        } else {
                            JOptionPane.showMessageDialog(this, "Registration failed: Unable to insert data", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Registration failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }                
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Verification Code", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == loginButton) {
            new Login();            dispose();
        } else if (e.getSource() == exitButton) {
            System.exit(0); // Exit the application
        } else if (e.getSource() == refreshButton) {
            random = (int) (Math.random() * 1000000); // Generate a new random code
            code.setText("<html><font size='5'>" + random + "</font></html>"); // Update displayed code
        }
    }
    public static void main(String[] args) {
        new Register();
    }
}
