package manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmp extends JFrame implements ActionListener {

    Choice idChoic;
    JButton delete,back;
    public RemoveEmp() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel idlab=new JLabel("Emp id");
        idlab.setBounds(50,50,100,20);
        add(idlab);

        idChoic=new Choice();
        idChoic.setBounds(160,50,100,20);
        add(idChoic);

        try {
            Con c=new Con();
            String q="SELECT*FROM employee";
            ResultSet rs=c.st.executeQuery(q);
            while (rs.next()){
                idChoic.add(rs.getString("id"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel namelb=new JLabel("Name");
        namelb.setBounds(50,100,100,30);
        add(namelb);

        JLabel lbname=new JLabel();
        lbname.setBounds(160,100,100,30);
        add(lbname);

        JLabel phonelb=new JLabel("Phone");
        phonelb.setBounds(50,140,100,30);
        add(phonelb);

        JLabel lbphone=new JLabel();
        lbphone.setBounds(160,140,100,30);
        add(lbphone);

        JLabel emaillb=new JLabel("Email");
        emaillb.setBounds(50,180,100,30);
        add(emaillb);

        JLabel lbemail=new JLabel();
        lbemail.setBounds(160,180,100,30);
        add(lbemail);


        idChoic.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Con c=new Con();
                    String q="SELECT*FROM employee WHERE id='"+idChoic.getSelectedItem()+"'";
                    ResultSet rt=c.st.executeQuery(q);
                    while (rt.next()){
                        lbname.setText(rt.getString("name"));
                        lbphone.setText(rt.getString("phone"));
                        lbemail.setText(rt.getString("email"));
                    }
                }catch (Exception et){
                    et.printStackTrace();
                }

            }
        });

        delete=new JButton("Delete");
        delete.setBounds(200,600,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back=new JButton("Back");
        back.setBounds(310,600,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("delete.jpg"));
        Image i1=image1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(500,100,450,400);
        add(image);


        setSize(1000,700);
        setLocation(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
    new RemoveEmp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== delete){
            try {
                Con c=new Con();
                String q="DELETE FROM employee WHERE id='"+idChoic.getSelectedItem()+"'";
                c.st.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Employee deleted Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else {
            setVisible(false);
            new Home();
        }

    }
}
