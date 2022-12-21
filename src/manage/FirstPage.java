package manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JFrame implements ActionListener {
    public FirstPage() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading=new JLabel("Emp Management System");
        heading.setBounds(350,10,800,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.red);
        add(heading);

        //to set image
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("empFront.jpg"));
        Image i1=image1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(50,50,1100,600);
        add(image);

        JButton clickhere=new JButton("Click here to continue");
        clickhere.setBounds(400,500,200,50);
        clickhere.setBackground(Color.black);
        clickhere.setForeground(Color.white);
        clickhere.addActionListener(this);
        image.add(clickhere);




        setSize(1200,700);
        setLocation(100,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        while (true){//to blink heading
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();

    }
    public static void main(String[] args) {
        FirstPage s=new FirstPage();
    }


}
