package manage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class ViewEmp extends JFrame implements ActionListener {
    JTable table;
    Choice cemplId;
    JButton search,print,update,back;
    public ViewEmp() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel searchl=new JLabel("Serach Emp");
        searchl.setBounds(20,20,150,20);
        add(searchl);

        cemplId=new Choice();
        cemplId.setBounds(180,20,150,20);
        add(cemplId);

        try {
            Con c = new Con();
            ResultSet rs = c.st.executeQuery("SELECT*FROM employee");

            while (rs.next()) {
                cemplId.add(rs.getString("id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table=new JTable();

        try {
            Con c = new Con();
            ResultSet rs = c.st.executeQuery("SELECT*FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(50, 100, 900, 600);
            add(jsp);

            search=new JButton("Search");
            search.setBounds(20,70,80,20);
            search.addActionListener(this);
            add(search);

            back=new JButton("Back");
            back.setBounds(110,70,80,20);
            back.addActionListener(this);
            add(back);

            update=new JButton("Update");
            update.setBounds(200,70,80,20);
            update.addActionListener(this);
            add(update);

            print=new JButton("Print");
            print.setBounds(290,70,80,20);
            print.addActionListener(this);
            add(print);



            setSize(1000, 600);
            setLocation(200, 200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
     new ViewEmp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==print){
            try {
                table.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }else if (e.getSource()==search){
            String q="SELECT*FROM employee WHERE id='"+ cemplId.getSelectedItem()+"'";
            try{
                Con c=new Con();
                ResultSet rs=c.st.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e1){
                e1.printStackTrace();
            }
        } else if (e.getSource()==update) {
            setVisible(false);
            new UpdateEmp(cemplId.getSelectedItem());
        }else {
            setVisible(false);
            new Home();
        }
    }
}
