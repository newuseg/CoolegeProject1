import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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

public class AddConsumer extends JFrame implements ActionListener {
    JPanel panel;
    JButton submiButton, backButton, refreshButton;
    JLabel code, ca;
    JTextField nm, fnm, pin, mob, email, vill, pan, bl, sd, adhar, dob, codeField;
    Choice cType, dist, gender;
    int random = (int) (Math.random() * 1000000);
    public AddConsumer() {
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        pack();
        setTitle("Add New Consumer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(63, 128, 108));

        panel = new JPanel();
        panel.setBounds(150, 0, 1000, 750);
        panel.setBackground(new Color(6, 85, 61));
        panel.setLayout(null);
        add(panel);

        JLabel label;
        label = new JLabel("<html><font size='7'>Add New Consumer</font></html>");
        label.setBounds(350, 30, 350, 40);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);

        label = new JLabel("<html><font size='5'>Connection Type</font></html>");
        label.setBounds(170, 120, 150, 25);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        cType = new Choice();
        cType.add("Domestic");
        cType.add("Comercial");
        cType.setBounds(350, 120, 150, 25);
        cType.setFont(new Font("Aral", Font.PLAIN, 20));
        panel.add(cType);

        label = new JLabel("<html><font size='5'>Distric</font></html>");
        label.setBounds(550, 120, 80, 25);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        dist = new Choice();
        dist.add("Patna");
        dist.setBounds(630, 120, 150, 25);
        dist.setFont(new Font("Aral", Font.PLAIN, 20));
        panel.add(dist);

        label = new JLabel("<html><font size='5'>Applicant Name</font></html>");
        label.setBounds(90, 200, 150, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        nm = new JTextField();
        nm.setBounds(260, 200, 220, 25);
        nm.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(nm);

        label = new JLabel("<html><font size='5'>Father Name</font></html>");
        label.setBounds(540, 200, 120, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        fnm = new JTextField();
        fnm.setBounds(680, 200, 220, 25);
        fnm.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(fnm);

        label = new JLabel("<html><font size='5'>Gender</font></html>");
        label.setBounds(90, 250, 100, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        gender = new Choice();
        gender.add("Male");
        gender.add("Female");
        gender.add("Trans Gender");
        gender.setBounds(260, 250, 180, 25);
        gender.setFont(new Font("Aral", Font.PLAIN, 20));
        panel.add(gender);

        label = new JLabel("<html><font size='5'>Pin Code</font></html>");
        label.setBounds(540, 250, 100, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        pin = new JTextField();
        pin.setBounds(680, 250, 220, 25);
        pin.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(pin);

        label = new JLabel("<html><font size='5'>Mobile Number</font></html>");
        label.setBounds(90, 300, 140, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        mob = new JTextField();
        mob.setBounds(260, 300, 220, 25);
        mob.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(mob);

        label = new JLabel("<html><font size='5'>Email</font></html>");
        label.setBounds(540, 300, 100, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        email = new JTextField();
        email.setBounds(680, 300, 220, 25);
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(email);

        label = new JLabel("<html><font size='5'>Village</font></html>");
        label.setBounds(90, 350, 100, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        vill = new JTextField();
        vill.setBounds(260, 350, 220, 25);
        vill.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(vill);

        label = new JLabel("<html><font size='5'>Panchayat</font></html>");
        label.setBounds(540, 350, 120, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        pan = new JTextField();
        pan.setBounds(680, 350, 220, 25);
        pan.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(pan);

        label = new JLabel("<html><font size='5'>Block</font></html>");
        label.setBounds(90, 400, 100, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        bl = new JTextField();
        bl.setBounds(260, 400, 220, 25);
        bl.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(bl);

        label = new JLabel("<html><font size='5'>Sub-Division</font></html>");
        label.setBounds(540, 400, 120, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        sd = new JTextField();
        sd.setBounds(680, 400, 220, 25);
        sd.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(sd);

        label = new JLabel("<html><font size='5'>Aadhaar No.</font></html>");
        label.setBounds(90, 450, 150, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        adhar = new JTextField();
        adhar.setBounds(260, 450, 220, 25);
        adhar.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(adhar);

        label = new JLabel("<html><font size='5'>D.O.B.</font></html>");
        label.setBounds(540, 450, 150, 30);
        label.setForeground(new Color(30, 30, 30));
        panel.add(label);
        dob = new JTextField();
        dob.setBounds(680, 450, 220, 25);
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(dob);

        code = new JLabel("<html><font size='6'>" + random + "</font></html>");
        code.setBounds(200, 520, 80, 25);
        panel.add(code);
        refreshButton = new JButton();
        refreshButton.setBounds(290, 517, 30, 30);
        refreshButton.setBackground(new Color(6, 85, 61, 150));
        refreshButton.setBorderPainted(false);
        ImageIcon ref = new ImageIcon(getClass().getResource("/img/refres.png"));
        Image img = ref.getImage();
        Image newImage = img.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ref = new ImageIcon(newImage);
        refreshButton.setIcon(ref);
        panel.add(refreshButton);
        refreshButton.addActionListener(this);
        codeField = new JTextField();
        codeField.setBounds(350, 520, 120, 25);
        codeField.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(codeField);
        ca = new JLabel("<html><font size='5'></font></html>");
        ca.setBounds(520, 540, 300, 25);
        ca.setForeground(new Color(10, 10, 10));
        panel.add(ca);

        backButton = new JButton("<html><font size='5'>E X I T</font></html>");
        backButton.setBounds(330, 590, 170, 40);
        backButton.setBackground(new Color(11, 11, 11));
        panel.add(backButton);
        backButton.addActionListener(this);
        submiButton = new JButton("<html><font size='5'>S U B M I T</font></html>");
        submiButton.setBounds(530, 590, 170, 40);
        submiButton.setBackground(new Color(11, 11, 11));
        panel.add(submiButton);
        submiButton.addActionListener(this);

        JLabel info = new JLabel("<html><font size='4'>Note : Please Check All the Data is Correctly. After the Submiting Data is Not Updatable</font></html>");
        info.setBounds(200, 650, 800, 25);
        info.setForeground(Color.BLACK);
        panel.add(info);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refreshButton) {
            random = (int) (Math.random() * 1000000); // Generate a new random code
            code.setText("<html><font size='6'>" + random + "</font></html>"); // Update displayed code
        } else if (e.getSource() == backButton) {
            setVisible(false);
        } else if (e.getSource() == submiButton) {
            String ctypeString = cType.getSelectedItem();
            String distric = "Patna";
            String name = nm.getText();
            String fname = fnm.getText();
            String genderr = gender.getSelectedItem();
            String pincode = pin.getText();
            String mobile = mob.getText();
            String emaill = email.getText();
            String village = vill.getText();
            String panchayat = pan.getText();
            String block = bl.getText();
            String subd = sd.getText();
            String aadhar = adhar.getText();
            String dobb = dob.getText();
            String vcode = codeField.getText();
            int random2 = (int) (Math.random() * 1000000);
            String r3 = "2005" + random2;
            int bil = 100;
            while (bil <= 300) {
                bil = (int) (Math.random() * 1000);
            }
            if (name.isEmpty() || fname.isEmpty() || pincode.isEmpty() || mobile.isEmpty() || village.isEmpty() || panchayat.isEmpty()
                    || block.isEmpty() || subd.isEmpty() || aadhar.isEmpty() || dobb.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill All Data");
            } else if (vcode.equals(String.valueOf(random))) {
                try {
                    database db = new database(); // Assuming you have a Database class that handles connections
                    String query0 = "SELECT * FROM ConsumerData WHERE Mobile = '"+mobile+"'";
                    ResultSet resultSet = db.statement.executeQuery(query0);
                    String query1 = "SELECT * FROM ConsumerData WHERE Aadhaar = ?";
                    PreparedStatement pst = db.connection.prepareStatement(query1);
                    pst.setString(1, aadhar);
                    ResultSet resultSet2 = pst.executeQuery();
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "This Mobile Number is Allready Exist", "Error", JOptionPane.WARNING_MESSAGE);
                    } 
                    else if (resultSet2.next()) {
                        JOptionPane.showMessageDialog(this, "This Aadhaar Number is Allready Exist", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        // Use PreparedStatement to prevent SQL injection
                        String query = "INSERT INTO ConsumerData (ConnectionType, Distric, CANumber, TotalBill, Name, Fathername, Gender, Pincode, Mobile, Email, Village, Panchayat, Block, SubDivision,Aadhaar, DOB) VALUES ('" + ctypeString + "', '" + distric + "', '" + r3 + "','" + bil + "', '" + name + "', '" + fname + "', '" + genderr + "', '" + pincode + "', '" + mobile + "', '" + emaill + "', '" + village + "', '" + panchayat + "', '" + block + "', '" + subd + "', '" + aadhar + "', '" + dobb + "')";
                        int resultSet3 = db.statement.executeUpdate(query);
                        ca.setText("<html><font size='5'>Your CA Number is :: " + r3 + "</font></html>");
                        JOptionPane.showMessageDialog(this, "New Consumer Added Successfully", "success", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, " failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Verification Code is Wrong");
            }
        }
    }

    public static void main(String[] args) {
        new AddConsumer();
    }
}
