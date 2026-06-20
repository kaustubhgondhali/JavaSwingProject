
package airlinemanagementsystem;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField tfname,tfnationality,tfaadhar,tfaddress,tfphone;
    JButton save;
    JRadioButton rbmale,rbfemale,rbother;
    
    
    public AddCustomer(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Add Customer Details");
        heading.setBounds(220,20,500,35);
        heading.setFont(new Font("tahoma",Font.PLAIN,32));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("tahoma",Font.PLAIN,25));
        
        add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(280, 80, 250, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,130,250,35);
        lblnationality.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblnationality);
        
         tfnationality = new JTextField();
        tfnationality.setBounds(280, 130, 250, 25);
        add(tfnationality);
        
        JLabel lblaadhar = new JLabel("Aadhar No");
        lblaadhar.setBounds(60,180,250,35);
        lblaadhar.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblaadhar);
        
         tfaadhar = new JTextField();
        tfaadhar.setBounds(280, 180, 250, 25);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,250,35);
        lbladdress.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lbladdress);
        
         tfaddress = new JTextField();
        tfaddress.setBounds(280, 230, 250, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,250,35);
        lblgender.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblgender);
        
        ButtonGroup  gendergroup = new ButtonGroup();
        
         rbmale = new JRadioButton("Male");
        rbmale.setBounds(280,280,70,35);
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(360,280,70,35);
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
         rbother = new JRadioButton("Other");
        rbother.setBounds(440,280,70,35);
        rbother.setBackground(Color.white);
        add(rbother);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        gendergroup.add(rbother);

        JLabel lblphone = new JLabel("Phone No");
        lblphone.setBounds(60,320,250,35);
        lblphone.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblphone);
        
         tfphone = new JTextField();
        tfphone.setBounds(280, 320, 250, 25);
        add(tfphone);
        
         save = new JButton("Save");
        save.setBounds(180, 400, 150, 25);
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel i1  = new JLabel(image1);
        i1.setBounds(550,80,280,400);
        add(i1);
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==save){
        String name = tfname.getText();
        String nationality  = tfnationality.getText();
        String aadhar = tfaadhar.getText();
        String address = tfaddress.getText();
       String phone = tfphone.getText();
       String gender = null;
       if(rbmale.isSelected())
       {
           gender = "male";
       }
       else if (rbfemale.isSelected())
       {
           gender = "female";
           
       }
       else{
           gender = "Others";
       }
        
        try {
            
            Conn c = new Conn();
            
            String querty  = "insert into passenger values('"+name+"','"+nationality+"','"+aadhar+"','"+address+"','"+phone+"','"+gender+"')";
            
            c.s.executeUpdate(querty);
            JOptionPane.showMessageDialog(null, "customer details added sucssesfully");
            setVisible(false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }}
    
    public static void main(String[] args) {
        
        new AddCustomer();
    }
}
