package manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JTextField tpassword;

    public Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lusername=new JLabel("Username");
        lusername.setBounds(40,100,100,30);
        add(lusername);

         tusername=new JTextField();
        tusername.setBounds(150,100,100,20);
        add(tusername);

        JLabel lpassword=new JLabel("Password");
        lpassword.setBounds(40,140,100,30);
        add(lpassword);

         tpassword=new JTextField();
        tpassword.setBounds(150,140,100,20);
        add(tpassword);

        JButton blogin=new JButton("LOGIN");
        blogin.setBounds(150,180,100,30);
        blogin.setBackground(Color.black);
        blogin.setForeground(Color.white);
        blogin.addActionListener(this);
        add(blogin);

        ImageIcon image2=new ImageIcon(ClassLoader.getSystemResource("login.jpg"));
        Image i1=image2.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(400,100,500,500);
        add(image);

        setSize(1000,700);
        setLocation(100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
    new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username=tusername.getText();
        String password=tpassword.getText();
        Con cc=new Con();

        String qu="SELECT*FROM login WHERE username='"+username+"' and password ='"+password+"'";

        try {
            ResultSet resultSet=cc.st.executeQuery(qu);
            if(resultSet.next()){
                new Home();
            }else
                JOptionPane.showMessageDialog(null,"invalid username or password");
            setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
