
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

// import com.mysql.cj.protocol.Resultset;
public class Dashboard extends JFrame implements ActionListener {
    JPanel userPanel, headerPanel, pbPanel, caPanel, delPanel;
    JLabel ppdcl, welcome, name, pbHeading, can, fcan, pbCode, code, caData, nmData;
    JTextField canField, mobField, adharField, pbCodeField, codeField, ca_dField, code_dField;
    JButton logoutButton, pbJButton, acJButton,  dcJButton, pbrefreshButton, refreshButton, delrefreshButton, searchButton, getCAButton, searchCAButton, gtpButton, getCADButton, deleteButton, payBackButton, CdeleteButton;
    JLabel  ca_data, nm_data, fnm_data, mob_data, bill_data;     // Pay Bill Searching Data...
    JLabel ca_d, code_d, cad_data, nmd_data, fnmd_data, mobd_data;
    int random = (int) (Math.random() * 1000000);

    public Dashboard(String dbtyp, String dbnm) {
        // Create a Header Panel & Related Data...
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 1400, 70);
        headerPanel.setBackground(new Color(30, 30, 30));
        headerPanel.setLayout(null);
        add(headerPanel);

        ppdcl = new JLabel("<html><font size='5' color='AQUA'>PatliPutra Power Distribution Company Limited</font></html>");
        ppdcl.setBounds(40, 10, 500, 50);
        headerPanel.add(ppdcl);

        acJButton = new JButton("<html><font size='5' color='white'>Add Consumer</font></html>");
        acJButton.setBounds(800, 13, 120, 45);
        acJButton.setBackground(new Color(30, 30, 30));
        headerPanel.add(acJButton);
        acJButton.addActionListener(this);

        dcJButton = new JButton("<html><font size='5' color='white'>Delete Consumer</font></html>");
        dcJButton.setBounds(960, 13, 120, 45);
        dcJButton.setBackground(new Color(30, 30, 30));
        headerPanel.add(dcJButton);
        dcJButton.addActionListener(this);

        logoutButton = new JButton("<html><font size='5' color='white'>Logout</font></html>");
        logoutButton.setBounds(1120, 20, 90, 30);
        logoutButton.setBackground(new Color(40, 40, 40));
        headerPanel.add(logoutButton);
        logoutButton.addActionListener(this);

        // Create and configure user panel & Related Data...
        userPanel = new JPanel();
        userPanel.setBounds(0, 70, 400, 700);
        userPanel.setBackground(new Color(50, 50, 50));
        userPanel.setLayout(null); // Consider using a layout manager here
        add(userPanel);

        ImageIcon user = new ImageIcon(ClassLoader.getSystemResource("img/user.jpg"));
        Image userscale = user.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon userr = new ImageIcon(userscale);
        JLabel userLabel = new JLabel(userr);
        userLabel.setBounds(100, 70, 200, 250);
        userPanel.add(userLabel);
        welcome = new JLabel("<html><font size='6'>"+dbtyp+"</font></html>");
        welcome.setBounds(150, 330, 150, 40);
        welcome.setForeground(new Color(200,200,2));
        userPanel.add(welcome);

        try{
            if(dbtyp.equals("User")){acJButton.hide();dcJButton.hide();}
        }catch(Exception a){a.printStackTrace();}

        welcome = new JLabel("<html><font size='6' color='white'>Welcome ❤ </font></html>");
        welcome.setBounds(120, 370, 150, 40);
        userPanel.add(welcome);

        name = new JLabel("<html><font size='6' color='white'>"+dbnm+"</font></html>");
        name.setBounds(100, 400, 400, 40);
        userPanel.add(name);

        // Create a Pay Bill Panel & Related Data...
        pbPanel = new JPanel();
        pbPanel.setBounds(630, 120, 400, 500);
        pbPanel.setBackground(new Color(30, 30, 30, 250));
        pbPanel.setLayout(null);
        add(pbPanel);

        pbHeading = new JLabel("<html><font size='7' color='AQUA'>P a y  B i l l</font></html>");
        pbHeading.setBounds(100, 20, 200, 50);
        pbPanel.add(pbHeading);

        can = new JLabel("<html><font size='4' color='white'>Enter CA Number</font></html>");
        can.setBounds(70, 100, 150, 30);
        pbPanel.add(can);
        canField = new JTextField();
        canField.setBounds(210, 100, 130, 25);
        canField.setFont(new Font("Arial", Font.PLAIN, 17));
        pbPanel.add(canField);

        pbCode = new JLabel("<html><font size='5'>" + random + "</font></html>");
        pbCode.setBounds(90, 140, 65, 30);
        pbCode.setForeground(new Color(100, 100, 100));
        pbPanel.add(pbCode);
        pbrefreshButton = new JButton();
        pbrefreshButton.setBounds(160, 142, 25, 25);
        pbrefreshButton.setBackground(new Color(30, 30, 30, 150));
        pbrefreshButton.setBorderPainted(false);
        ImageIcon ref = new ImageIcon(getClass().getResource("/img/refres.png"));
        Image img = ref.getImage();
        Image newImage = img.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ref = new ImageIcon(newImage);
        pbrefreshButton.setIcon(ref);
        pbPanel.add(pbrefreshButton);
        pbrefreshButton.addActionListener(this);
        pbCodeField = new JTextField();
        pbCodeField.setBounds(210, 140, 130, 25);
        pbCodeField.setFont(new Font("Arial", Font.PLAIN, 17));
        pbPanel.add(pbCodeField);

        fcan = new JLabel("<html><font size='3' color='white'>Forgot CA Number?</font></html>");
        fcan.setBounds(100, 180, 120, 20);
        pbPanel.add(fcan);
        getCAButton = new JButton("<html><font size='3' color='white'>GET CA</font></html>");
        getCAButton.setBounds(220, 180, 80, 20);
        getCAButton.setBackground(new Color(30, 30, 30, 200));
        pbPanel.add(getCAButton);
        getCAButton.addActionListener(this);

        searchButton = new JButton("<html><font size='5' color='white'>S e a r c h</font></html>");
        searchButton.setBounds(130, 220, 150, 35);
        searchButton.setBackground(new Color(30, 30, 30, 250));
        pbPanel.add(searchButton);
        searchButton.addActionListener(this);

        ca_data = new JLabel("");
        ca_data.setBounds(60, 260, 400, 50);
        pbPanel.add(ca_data);

        nm_data = new JLabel("");
        nm_data.setBounds(60, 290, 400, 50);
        pbPanel.add(nm_data);

        fnm_data = new JLabel("");
        fnm_data.setBounds(60, 320, 400, 50);
        pbPanel.add(fnm_data);

        mob_data = new JLabel("");
        mob_data.setBounds(60, 350, 400, 50);
        pbPanel.add(mob_data);

        bill_data = new JLabel("");
        bill_data.setBounds(60, 380, 400, 50);
        pbPanel.add(bill_data);

        pbJButton = new JButton("<html><font size='5' color='white'>Pay Bill</font></html>");
        pbJButton.setBounds(130, 430, 150, 40);
        pbJButton.setBackground(new Color(30, 30, 30));
        pbPanel.add(pbJButton);
        pbJButton.addActionListener(this);
        pbJButton.hide();

        // Create a Get CA Number Panel & Related Data...
        JLabel caHeading, ca_mob, ca_adhar, or;
        caPanel = new JPanel();
        caPanel.setBounds(630, 120, 400, 500);
        caPanel.setBackground(new Color(30, 30, 30, 250));
        caPanel.setLayout(null);
        add(caPanel);

        caHeading = new JLabel("<html><font size='7' color='AQUA'>Get CA</font></html>");
        caHeading.setBounds(140, 20, 200, 50);
        caPanel.add(caHeading);

        ca_mob = new JLabel("<html><font size='4' color='white'>Enter Mobile Number</font></html>");
        ca_mob.setBounds(130, 80, 200, 30);
        caPanel.add(ca_mob);
        mobField = new JTextField();
        mobField.setBounds(130, 110, 130, 25);
        mobField.setFont(new Font("Arial", Font.PLAIN, 17));
        caPanel.add(mobField);

        or = new JLabel("<html><font size='4' color='white'>------------- OR -------------</font></html>");
        or.setBounds(120, 145, 200, 30);
        caPanel.add(or);

        ca_adhar = new JLabel("<html><font size='4' color='white'>Enter Aadhaar Number</font></html>");
        ca_adhar.setBounds(130, 170, 200, 30);
        caPanel.add(ca_adhar);
        adharField = new JTextField();
        adharField.setBounds(130, 200, 130, 25);
        adharField.setFont(new Font("Arial", Font.PLAIN, 17));
        caPanel.add(adharField);

        code = new JLabel("<html><font size='5'>" + random + "</font></html>");
        code.setBounds(150, 230, 65, 30);
        code.setForeground(new Color(100, 100, 100));
        caPanel.add(code);
        refreshButton = new JButton();
        refreshButton.setBounds(220, 235, 25, 25);
        refreshButton.setBackground(new Color(30, 30, 30, 150));
        refreshButton.setBorderPainted(false);
        ImageIcon reff = new ImageIcon(getClass().getResource("/img/refres.png"));
        Image imgg = reff.getImage();
        Image newImage1 = imgg.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        reff = new ImageIcon(newImage1);
        refreshButton.setIcon(reff);
        caPanel.add(refreshButton);
        refreshButton.addActionListener(this);
        codeField = new JTextField();
        codeField.setBounds(130, 265, 130, 25);
        codeField.setFont(new Font("Arial", Font.PLAIN, 17));
        caPanel.add(codeField);

        searchCAButton = new JButton("<html><font size='5' color='white'>G e t  C A</font></html>");
        searchCAButton.setBounds(120, 310, 150, 35);
        searchCAButton.setBackground(new Color(30, 30, 30));
        caPanel.add(searchCAButton);
        searchCAButton.addActionListener(this);

        gtpButton = new JButton("<html><font size='5' color='white'>Back to Pay</font></html>");
        gtpButton.setBounds(120, 350, 150, 35);
        gtpButton.setBackground(new Color(30, 30, 30));
        caPanel.add(gtpButton);
        gtpButton.addActionListener(this);

        caData = new JLabel("");
        caData.setBounds(70, 410, 400, 30);
        caPanel.add(caData);

        nmData = new JLabel("");
        nmData.setBounds(70, 440, 400, 30);
        caPanel.add(nmData);
        caPanel.hide();

        // Delete a existing Consumer Data...
        delPanel = new JPanel();
        delPanel.setBounds(630, 120, 400, 500);
        delPanel.setBackground(new Color(30, 30, 30, 250));
        delPanel.setLayout(null);
        add(delPanel);

        JLabel Heading_d = new JLabel("<html><font size='7' color='AQUA'>Delete Consumer</font></html>");
        Heading_d.setBounds(60, 20, 300, 50);
        delPanel.add(Heading_d);

        ca_d = new JLabel("<html><font size='4' color='white'>Enter CA Number</font></html>");
        ca_d.setBounds(70, 100, 150, 30);
        delPanel.add(ca_d);
        ca_dField = new JTextField();
        ca_dField.setBounds(210, 100, 130, 25);
        ca_dField.setFont(new Font("Arial", Font.PLAIN, 17));
        delPanel.add(ca_dField);

        code_d = new JLabel("<html><font size='5'>" + random + "</font></html>");
        code_d.setBounds(90, 140, 65, 30);
        code_d.setForeground(new Color(100, 100, 100));
        delPanel.add(code_d);
        delrefreshButton = new JButton();
        delrefreshButton.setBounds(160, 142, 25, 25);
        delrefreshButton.setBackground(new Color(30, 30, 30, 150));
        delrefreshButton.setBorderPainted(false);
        ImageIcon ref1 = new ImageIcon(getClass().getResource("/img/refres.png"));
        Image img1 = ref1.getImage();
        Image newImage11 = img1.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ref1 = new ImageIcon(newImage11);
        delrefreshButton.setIcon(ref1);
        delPanel.add(delrefreshButton);
        delrefreshButton.addActionListener(this);
        code_dField = new JTextField();
        code_dField.setBounds(210, 140, 130, 25);
        code_dField.setFont(new Font("Arial", Font.PLAIN, 17));
        delPanel.add(code_dField);

        JLabel Fca_d = new JLabel("<html><font size='3' color='white'>Forgot CA Number?</font></html>");
        Fca_d.setBounds(100, 180, 120, 20);
        delPanel.add(Fca_d);
        getCADButton = new JButton("<html><font size='3' color='white'>GET CA</font></html>");
        getCADButton.setBounds(220, 180, 80, 20);
        getCADButton.setBackground(new Color(30, 30, 30, 200));
        delPanel.add(getCADButton);
        getCADButton.addActionListener(this);

        deleteButton = new JButton("<html><font size='5' color='white'>S e a r c h</font></html>");
        deleteButton.setBounds(75, 230, 120, 35);
        deleteButton.setBackground(new Color(30, 30, 30, 250));
        delPanel.add(deleteButton);
        deleteButton.addActionListener(this);

        payBackButton = new JButton("<html><font size='5' color='white'>Pay Bill</font></html>");
        payBackButton.setBounds(210, 230, 120, 35);
        payBackButton.setBackground(new Color(30, 30, 30, 250));
        delPanel.add(payBackButton);
        payBackButton.addActionListener(this);

        cad_data = new JLabel("");
        cad_data.setBounds(60, 270, 400, 50);
        delPanel.add(cad_data);
        nmd_data = new JLabel("");
        nmd_data.setBounds(60, 300, 400, 50);
        delPanel.add(nmd_data);
        fnmd_data = new JLabel("");
        fnmd_data.setBounds(60, 330, 400, 50);
        delPanel.add(fnmd_data);
        mobd_data = new JLabel("");
        mobd_data.setBounds(60, 360, 400, 50);
        delPanel.add(mobd_data);

        CdeleteButton = new JButton("<html><font size='5' color='white'>D e l e t e</font></html>");
        CdeleteButton.setBounds(130, 420, 150, 40);
        CdeleteButton.setBackground(new Color(30, 30, 30));
        delPanel.add(CdeleteButton);
        CdeleteButton.addActionListener(this);
        CdeleteButton.hide();
        delPanel.hide();

        // Load and scale the image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/dashboard.jpg")); // Check file extension
        Image image = icon.getImage().getScaledInstance(1000, 660, Image.SCALE_DEFAULT);
        ImageIcon i_icon = new ImageIcon(image);
        JLabel imgLabel = new JLabel(i_icon);
        imgLabel.setBounds(400, 20, 1000, 700);
        add(imgLabel);

        setTitle("Dashboard");
        setSize(1400, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acJButton) {
            new AddConsumer();         setVisible(false);
        } else if (e.getSource() == logoutButton) {
            new Login();            dispose();
        } else if (e.getSource() == dcJButton) {
            pbPanel.hide();            delPanel.show();
        } else if (e.getSource() == refreshButton) {
            random = (int) (Math.random() * 1000000); // Generate a new random code
            code.setText("<html><font size='5'>" + random + "</font></html>"); // Update displayed code
        } else if (e.getSource() == pbrefreshButton) {
            random = (int) (Math.random() * 1000000); // Generate a new random code
            pbCode.setText("<html><font size='5'>" + random + "</font></html>"); // Update displayed code
        } else if (e.getSource() == delrefreshButton) {
            random = (int) (Math.random() * 1000000); // Generate a new random code
            code_d.setText("<html><font size='5'>" + random + "</font></html>"); // Update displayed code
        } else if (e.getSource() == getCAButton) {
            pbPanel.hide();            caPanel.show();
        } else if (e.getSource() == searchButton) {
            String CANumber = canField.getText();
            String vcode = pbCodeField.getText();
            if (CANumber.isEmpty()) {               // line 150.......
                JOptionPane.showMessageDialog(this, "Please Enter CA Number", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (vcode.equals(String.valueOf(random))) {
                try {
                    database db = new database();
                    String query = "SELECT * FROM ConsumerData WHERE CANumber = ?";
                    PreparedStatement pst = db.connection.prepareStatement(query);
                    pst.setString(1, CANumber);
                    ResultSet resultSet = pst.executeQuery();
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "Data Found", "Success", JOptionPane.INFORMATION_MESSAGE);
                        ca_data.setText("<html><font size='4' color='white'>CA Number :: " + resultSet.getString("CANumber") + "</font></html>");
                        nm_data.setText("<html><font size='4' color='white'>Name :: " + resultSet.getString("Name") + "</font></html>");
                        fnm_data.setText("<html><font size='4' color='white'>Father Name :: " + resultSet.getString("FatherName") + "</font></html>");
                        mob_data.setText("<html><font size='4' color='white'>Mobile Number :: " + resultSet.getString("Mobile") + "</font></html>");
                        bill_data.setText("<html><font size='4' color='white'>Total Bill :: " + resultSet.getString("TotalBill") + "</font></html>");
                        pbJButton.show();
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Data");
                    }
                } catch (SQLException E) {
                    E.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Verification Code", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == pbJButton) {
            String input = JOptionPane.showInputDialog(this, "Enter Rupees for Payment", "Pay Bill", JOptionPane.INFORMATION_MESSAGE);
            if (input == null) { // User cancelled the input dialog
                return;
            }
            try {
                int amount = Integer.parseInt(input);
                if (amount <= 0) {
                    JOptionPane.showMessageDialog(this, "Please enter a positive amount.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int result = JOptionPane.showConfirmDialog(this, "Confirm Pay of " + amount + " Rupees?", "Pay", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) { // Use YES_OPTION
                    try {
                        database db = new database();
                        String ca = canField.getText();
                        String query = "SELECT * FROM ConsumerData WHERE CANumber = '" + ca + "'";
                        ResultSet resultSet = db.statement.executeQuery(query);
                        if (resultSet.next()){
                            int rbill = Integer.parseInt(resultSet.getString("TotalBill"));
                            db.statement.executeUpdate("update ConsumerData set TotalBill ='"+(rbill-amount)+"' where CANumber = '"+ca+"'");
                            bill_data.setText("<html><font size='4' color='white'>Total Bill :: " + (rbill-amount) + "</font></html>"); // Update displayed price
                            JOptionPane.showMessageDialog(this, "Payment of " + amount + " Rupees confirmed.", "Payment Success", JOptionPane.INFORMATION_MESSAGE);                        
                        }
                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == searchCAButton) {
            String mobile = mobField.getText();
            String aadhaar = adharField.getText();
            String vcode = codeField.getText();
            if ((mobile.isEmpty() || !aadhaar.isEmpty()) && (!mobile.isEmpty() || aadhaar.isEmpty())) {
                JOptionPane.showMessageDialog(this, "Fill Ony one Data (Aadhaar or Mobile)", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (vcode.equals(String.valueOf(random))) {
                try {
                    database db = new database();
                    String query = "SELECT * FROM ConsumerData WHERE Mobile = ? OR Aadhaar = ?";
                    PreparedStatement pstmt = db.connection.prepareStatement(query);
                    pstmt.setString(1, mobile);
                    pstmt.setString(2, aadhaar);
                    ResultSet resultSet = pstmt.executeQuery();
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "Data Found", "Success", JOptionPane.INFORMATION_MESSAGE);
                        caData.setText("<html><font size='4' color='white'>Your CA Number :: " + resultSet.getString("CANumber") + "</font></html>");
                        nmData.setText("<html><font size='4' color='white'>Your Name :: " + resultSet.getString("Name") + "</font></html>");
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Data");
                        caData.setText("");
                        nmData.setText("");
                    }
                } catch (SQLException E) {
                    JOptionPane.showMessageDialog(this, "Error: " + E.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Verification Code", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == gtpButton) {
            caPanel.hide();            pbPanel.show();
        } else if (e.getSource() == deleteButton) {
            String cadString = ca_dField.getText();
            String codeString = code_dField.getText();
            if (cadString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "CA Number is Empty...", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (codeString.equals(String.valueOf(random))) {
                try {
                    database db = new database();
                    String query = "SELECT * FROM ConsumerData WHERE CANumber = ?";
                    PreparedStatement pstmt = db.connection.prepareStatement(query);
                    pstmt.setString(1, cadString);
                    ResultSet resultSet = pstmt.executeQuery();
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "Data Found", "Success", JOptionPane.INFORMATION_MESSAGE);
                        cad_data.setText("<html><font size='4' color='white'> CA Number :: " + resultSet.getString("CANumber") + "</font></html>");
                        nmd_data.setText("<html><font size='4' color='white'> Name :: " + resultSet.getString("Name") + "</font></html>");
                        fnmd_data.setText("<html><font size='4' color='white'> Father Name :: " + resultSet.getString("FatherName") + "</font></html>");
                        mobd_data.setText("<html><font size='4' color='white'> Mobile Number :: " + resultSet.getString("Mobile") + "</font></html>");
                        CdeleteButton.show();
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Data");
                    }
                } catch (SQLException E) {
                    JOptionPane.showMessageDialog(this, "Error: " + E.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Verification Code", "ERROR", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource() == CdeleteButton) {
            try {
                database db = new database();
                String query = "delete from ConsumerData where CANumber = '" + ca_dField.getText() + "'";
                db.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Consumer Deleted Successfully");
                cad_data.setText("");
                nmd_data.setText("");
                fnmd_data.setText("");
                mobd_data.setText("");
                CdeleteButton.hide();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == getCADButton) {
            delPanel.hide();            caPanel.show();
        } else if (e.getSource() == payBackButton) {
            delPanel.hide();            pbPanel.show();
        }
    }
    public static void main(String[] args) {
        // new Dashboard();
    }
}
