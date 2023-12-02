package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField userInput;
    JPasswordField passInput;
    
    Login(){
        //Setting background white and creating custom inputs
        getContentPane().setBackground(Color.WHITE);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        setLayout(null);
        
        JPanel panel=new JPanel();  
        panel.setBounds(150,20,300,300);    
        panel.setBackground(Color.GRAY); 
        panel.setLayout(null);
        add(panel);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("images/manager.png"));
        Image img2 = img1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(80, 20, 140, 150);
        panel.add(image);
        
        //USERNAME
        JLabel username = new JLabel("UserName");
        username.setBounds(50,180,100,30);
        username.setFont(new Font("serif",Font.BOLD,20));
        username.setForeground(Color.BLACK);
        panel.add(username);
        
        //Textfield to take input for username
        userInput = new JTextField();
        userInput.setBounds(150,185,100,25);
        panel.add(userInput);
        
        //PASSWORD
        JLabel password = new JLabel("Password");
        password.setBounds(50,210,100,30);
        password.setFont(new Font("serif",Font.BOLD,20));
        password.setForeground(Color.BLACK);
        panel.add(password);
        
        //PasswordField to take input for password
        passInput = new JPasswordField();   
        passInput.setBounds(150,215,100,25);
        panel.add(passInput);
        
        //Button for login
        JButton login = new JButton("LOGIN");
        login.setBounds(110,250, 90, 30);
        login.setFont(new Font("serif",Font.BOLD,15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setMargin(new Insets(10, 5, 10, 5));
        login.addActionListener(this);
        panel.add(login);
        
        //Setting frame size,visiility and loction from where it will become visible
        setSize(600,400);
        setVisible(true);
        setLocation(450,200);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username = userInput.getText();
            String password = passInput.getText();
            
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
                new Splash();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
