
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class About extends JFrame  implements ActionListener{
    About() {
        setBounds(400,100,600,500);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("javaapplication1/icons/windows-11-logo_print.png"));
        Image i2 = i1.getImage().getScaledInstance(300,60,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel headerIcon = new JLabel(i3);
        headerIcon.setBounds(70,40,500,80);
        add(headerIcon);
        
        /*
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("javaapplication1/icons/windows-11-logo_print.png"));
        Image i5 = i1.getImage().getScaledInstance(300,60,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon = new JLabel(i6);
        headerIcon.setBounds(50,180,70,70);
        add(icon);
        */
        JLabel text = new JLabel("CODE");
        text.setBounds(150,100,500,200);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        add(text);
        
        JButton b1 = new JButton("Ok");
        b1.setBounds(150,350,120,25);
        b1.addActionListener(this);
        add(b1);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void main(String[] args){
         new About();
    }

    
}

