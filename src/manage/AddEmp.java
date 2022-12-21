package manage;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AddEmp extends JFrame implements ActionListener {
    Random ran=new Random();
    int number=ran.nextInt(99999);
    JButton add,back;
    JLabel namelabel,quanamelabel,fnamelabel,idnamelabel,adrnamelabel,aadnamelabel,doblabel,salnamelabel,phnamelabel,emnamelabel,desnamelabel;
    JTextField namefild,idnamefild,fnamefild,adrnamefild,aadnamefild,phnamefild,emnamefild,desnamefild,salnamefild;
    JComboBox quacomboBox;
    JDatePicker dob;
    AddEmp(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Add Employee");
        heading.setBounds(300,10,800,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.red);
        add(heading);

        namelabel=new JLabel("Name");
        namelabel.setBounds(20,50,100,30);
        add(namelabel);

        namefild=new JTextField();
        namefild.setBounds(130,50,100,30);
        add(namefild);

        fnamelabel=new JLabel("Father Name");
        fnamelabel.setBounds(20,90,100,30);
        add(fnamelabel);

        fnamefild=new JTextField();
        fnamefild.setBounds(130,90,100,30);
        add(fnamefild);

        doblabel=new JLabel("D.O.B");
        doblabel.setBounds(20,130,100,30);
        add(doblabel);

        dob=new JDatePicker();
        dob.setBounds(130,130,120,30);
        add(dob);

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

        String[] cou={"intermediate","UG","PG","highSchool","Phd"};
        quacomboBox=new JComboBox(cou);
        quacomboBox.setBounds(130,330,100,30);
        add(quacomboBox);

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

        idnamefild=new JTextField(""+number  );
        idnamefild.setBounds(130,450,100,30);
        add(idnamefild);

        add=new JButton("Add Details");
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(back);



        setSize(1000,600);
        setLocation(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddEmp();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=namefild.getText();
            String fname=fnamefild.getText();
            String dat= dob.getDateFormat();
           // String date = dob.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String salary=salnamefild.getText();
            String address=adrnamefild.getText();
            String aadhar=aadnamefild.getText();
            String phone=phnamefild.getText();
            String email=emnamefild.getText();
            String education=(String)quacomboBox.getSelectedItem();
            String designation=desnamefild.getText();
            String id=idnamefild.getText();
            try{
                Con con=new Con();
                String query="INSERT INTO employee VALUES('"+name+"','"+fname+"','"+phone+"','"+dat+"','"+address+"','"+email+"', '"+education+"','"+designation+"','"+aadhar+"','"+salary+"','"+id+"')";
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
