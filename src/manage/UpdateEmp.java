package manage;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateEmp extends JFrame implements ActionListener {
    JButton add,back;
    JLabel namelabel,quanamelabel,fnamelabel,idnamelabel,adrnamelabel,aadnamelabel,doblabel,salnamelabel,phnamelabel,emnamelabel,desnamelabel;
    JTextField namefild,idnamefild,fnamefild,adrnamefild,aadnamefild,phnamefild,emnamefild,desnamefild,salnamefild;
    //JComboBox quacomboBox;
    JDatePicker dob;
    JTextField qual;
    String  id;
    UpdateEmp(String id){
        this.id=id;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Update Employee");
        heading.setBounds(300,10,800,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.red);
        add(heading);

        namelabel=new JLabel("Name");
        namelabel.setBounds(20,50,100,30);
        add(namelabel);

        JLabel namel=new JLabel();
        namel.setBounds(130,50,100,30);
        add(namel);

        fnamelabel=new JLabel("Father Name");
        fnamelabel.setBounds(20,90,100,30);
        add(fnamelabel);

        fnamefild=new JTextField();
        fnamefild.setBounds(130,90,100,30);
        add(fnamefild);

        doblabel=new JLabel("D.O.B");
        doblabel.setBounds(20,130,100,30);
        add(doblabel);

        JLabel dobl=new JLabel();
        dobl.setBounds(130,130,120,30);
        add(dobl);

        salnamelabel=new JLabel("Salary");
        salnamelabel.setBounds(20,170,100,30);
        add(salnamelabel);

        salnamefild=new JTextField();
        salnamefild.setBounds(130,170,100,30);
        add(salnamefild);

        adrnamelabel=new JLabel("Address");
        adrnamelabel.setBounds(20,210,100,30);
        add(adrnamelabel);

        adrnamefild=new JTextField();
        adrnamefild.setBounds(130,210,100,30);
        add(adrnamefild);

        phnamelabel=new JLabel("Phone No");
        phnamelabel.setBounds(20,250,100,30);
        add(phnamelabel);

        phnamefild=new JTextField();
        phnamefild.setBounds(130,250,100,30);
        add(phnamefild);

        emnamelabel=new JLabel("Email");
        emnamelabel.setBounds(20,290,100,30);
        add(emnamelabel);

        emnamefild=new JTextField();
        emnamefild.setBounds(130,290,100,30);
        add(emnamefild);

        quanamelabel=new JLabel("Email");
        quanamelabel.setBounds(20,330,100,30);
        add(quanamelabel);

        qual=new JTextField();
        qual.setBounds(130,330,100,30);
        add(qual);

        desnamelabel=new JLabel("Designation");
        desnamelabel.setBounds(20,370,100,30);
        add(desnamelabel);

        desnamefild=new JTextField();
        desnamefild.setBounds(130,370,100,30);
        add(desnamefild);

        aadnamelabel=new JLabel("Aadhar No");
        aadnamelabel.setBounds(20,410,100,30);
        add(aadnamelabel);

        aadnamefild=new JTextField();
        aadnamefild.setBounds(130,410,100,30);
        add(aadnamefild);

        idnamelabel=new JLabel("Emp Id");
        idnamelabel.setBounds(20,450,100,30);
        add(idnamelabel);

        JLabel idl=new JLabel();
        idl.setBounds(130,450,100,30);
        add(idl);

        try{
            Con c=new Con();
            String q="SELECT*FROM employee WHERE id='"+id+"'";
            ResultSet s=c.st.executeQuery(q);
            while (s.next()){
                namel.setText(s.getString("name"));
                dobl.setText(s.getString("dob"));
                idl.setText(s.getString("id"));
                adrnamefild.setText(s.getString("address"));
                aadnamefild.setText(s.getString("aadhar"));
                phnamefild.setText(s.getString("phone"));
                fnamefild.setText(s.getString("fname"));
                emnamefild.setText(s.getString("email"));
                desnamefild.setText(s.getString("designation"));
                salnamefild.setText(s.getString("salary"));
                qual.setText(s.getString("education"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        add=new JButton("Update Details");
        add.setBounds(500,500,80,30);
        add.addActionListener(this);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add(add);

        back=new JButton("Back");
        back.setBounds(590,500,80,30);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);



        setSize(1000,600);
        setLocation(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateEmp("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            //String name=namefild.getText();
            String fname=fnamefild.getText();
           // String dat= dob.getDateFormat();
            // String date = dob.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String salary=salnamefild.getText();
            String address=adrnamefild.getText();
            String aadhar=aadnamefild.getText();
            String phone=phnamefild.getText();
            String email=emnamefild.getText();
           String education=qual.getText();
            String designation=desnamefild.getText();
            //String id=idnamefild.getText();
            try{
                Con con=new Con();
                String query="UPDATE employee SET fname='"+fname+"',phone='"+phone+"',address='"+address+"',email='"+email+"',education='"+education+"',designation='"+designation+"',aadhar='"+aadhar+"',salary='"+salary+"' WHERE id='"+id+"'";
                con.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }else {
            setVisible(false);
            new Home();
        }
    }
}