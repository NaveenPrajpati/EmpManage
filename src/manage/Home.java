package manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton add,remove,update,view;

    public Home() {
        setLayout(null);

        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("home.jpg"));
        Image i1=image1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,1200,700);
        add(image);

        JLabel heading=new JLabel("Emp Management System");
        heading.setBounds(450,10,800,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.black);
        image.add(heading);

        JPanel li=new JPanel();
        li.setBounds(140,0,10,700);
        li.setBackground(Color.red);
        image.add(li);

         add=new JButton("Add Emp");
        add.setBounds(20,50,100,30);
        add.addActionListener(this);
        image.add(add);

         remove=new JButton("Remove Emp");
        remove.setBounds(20,100,100,30);
        remove.addActionListener(this);
        image.add(remove);

        update=new JButton("Update Emp");
        update.setBounds(20,150,100,30);
        update.addActionListener(this);
        image.add(update);

        view=new JButton("View Emp");
        view.setBounds(20,200,100,30);
        view.addActionListener(this);
        image.add(view);

        setSize(1200,700);
        setLocation(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
    new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            setVisible(false);
            new AddEmp();
        } else if (e.getSource()==remove) {
            setVisible(false);
            new RemoveEmp();

        } else if (e.getSource()==update) {
            setVisible(false);
            new ViewEmp();
            //new UpdateEmp();
        }else {
            setVisible(false);
            new ViewEmp();
        }

    }
}
