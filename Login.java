
package airlinemanagementsystem;

import com.mysql.cj.jdbc.result.ResultSetFactory;
import com.mysql.cj.xdevapi.Result;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;


public class Login extends JFrame implements ActionListener{
    
    JButton reset,submit,cancel;
    JLabel lblusername, lblpassword;
    JTextField tfusername,tfpassword;
    public Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         lblusername = new JLabel("UserName");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);
        
         tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);
        
         
         lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);
        
         tfpassword = new JTextField();
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);
        
         reset = new JButton("Reset");
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        add(reset);
        
         submit = new JButton("Submit");
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this);
        add(submit);
        
         cancel = new JButton("Cancel");
        cancel.setBounds(120,160,120,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(400,250);
        setLocation(400,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
        else if (ae.getSource()==submit)
        {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try {
                Conn c = new Conn();
                
                String query = "select *from login where username = '"+username+"' and password = '"+password+"' ";
                        
                ResultSet rs =   c.s.executeQuery(query);
                
                if(rs.next())
                {
                    new Home();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "invalid username or password..");
                    setVisible(false);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==reset)
        {
             tfusername.setText("");
             tfpassword.setText("");
        }
    }
    public static void main(String[] args) {
        
        new Login();
    }
}
