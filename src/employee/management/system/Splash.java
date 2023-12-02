package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT");
        heading.setBounds(200,0,1200,72);
        heading.setFont(new Font("serif",Font.BOLD,50));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("images/employee_home.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0, 0, 1050, 600);
        add(image);
        
        JButton clickhere = new JButton("CONTINUE");
        clickhere.setBounds(450, 550, 170, 40);
        clickhere.setFont(new Font("serif",Font.PLAIN,20));
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.setMargin(new Insets(8, 4, 8, 4));
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        setSize(1070,650);
        setLocation(200,50);
        setVisible(true);
        
//        while(true) {
//            heading.setVisible(false);
//            try {
//                Thread.sleep(500);
//            } catch (Exception e){
//                
//            }
//            
//            heading.setVisible(true);
//            try {
//                Thread.sleep(500);
//            } catch (Exception e){
//                
//            }
//        }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]){
        new Splash();
    }
}
