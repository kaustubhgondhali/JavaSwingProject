
package airlinemanagementsystem;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;

public class BoardingPass extends JFrame implements ActionListener {
    JTextField tfpnr;
    JButton fetchButton;
   
    JLabel tfname,tfnationality,tfaddress,lblfname,lblfcode,labelfcode,labelfname,lbldest,labeldate,lblsrc;
    Choice source,destination;
   
    public BoardingPass(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Air India");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("tahoma",Font.PLAIN,32));
      
        add(heading);
        
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360,50,300,30);
        subheading.setFont(new Font("tahoma",Font.PLAIN,24));
        subheading.setForeground(Color.blue);
        add(subheading);
        
         JLabel lbladdress = new JLabel("PNR Details");
        lbladdress.setBounds(60,100 ,150,25);
        lbladdress.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lbladdress);
        
         tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
         fetchButton = new JButton("Fetch Button");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(380,80,120,25);
         fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        
        
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("tahoma",Font.PLAIN,25));
          add(lblname);
        
         tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        ////////////////////////////////////////////////////////////////////////////
        
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60,180,250,25);
        lblnationality.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblnationality);
        
         tfnationality = new JLabel();
        tfnationality.setBounds(380, 180, 150, 25);
        add(tfnationality);
        //////////////////////////////////////////////////////////////////////
        
        
        JLabel lblaadhar = new JLabel("SRC");
        lblaadhar.setBounds(60,220,250,35);
        lblaadhar.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblaadhar);
        
                  lblsrc = new JLabel();
        lblsrc.setBounds(360, 220, 150, 25);
        add(lblsrc);

        tfnationality.setBounds(380, 180, 150, 25);
        add(tfnationality);
       
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380,280,150,25);
        lblgender.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblgender);
        
         lbldest = new JLabel("Gender");
        lbldest.setBounds(220,280,150,25);
        add(lbldest);
        
        
        
         lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,430 ,150,25);
        lblfname.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblfname);
        
         labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);
        
          lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60,260 ,150,25);
        lblfcode.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblfcode);
        
         labelfcode = new JLabel();
        labelfcode.setBounds(540,260 ,150,25);
        add(labelfcode);
        
       JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,300 ,150,25);
        lbldate.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lbldate);
        
         labeldate = new JLabel("Date");
        labeldate.setBounds(220,300 ,150,25);     
        add(labeldate);
        
//        
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae)
    {
       
        
        String pnr = tfpnr.getText();
      

        try {
            
            Conn c = new Conn();
            
            String querty  = "select *from reservation where PNR = '"+pnr+"'";
            
          ResultSet rs =  c.s.executeQuery(querty);
          
         if(rs.next())
          {
              tfname.setText(rs.getString("name"));
              tfnationality.setText(rs.getString("nationality"));
              lblsrc.setText(rs.getString("src"));
              lbldest.setText(rs.getString("des"));
              labelfname.setText(rs.getString("flightname"));
              labelfcode.setText(rs.getString("flightcode"));
              labeldate.setText(rs.getString("ddate"));
              
          }
          else{
                          JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");

          }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    
        
    }
    
    public static void main(String[] args) {
        
        new BoardingPass();
    }
}
