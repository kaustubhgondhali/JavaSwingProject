
package airlinemanagementsystem;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;

public class Cancel extends JFrame implements ActionListener {
    JTextField tfpnr;
    JButton cancel,bookflight,fetchButton;
    JRadioButton rbmale,rbfemale,rbother;
    JLabel tfname,cancelationno,tfaddress,lblfname,lblfcode,labelfcode,labelfname,lbldateoftravel;
    Choice source,destination;
   
    public Cancel(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELATION");
        heading.setBounds(180,20,250,35);
        heading.setFont(new Font("tahoma",Font.PLAIN,32));
        add(heading);
        
        
         JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60,230 ,150,25);
        lbladdress.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lbladdress);
        
         lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25);
        add(lblfcode);
        
         fetchButton = new JButton("Fetch Button");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(380,80,120,25);
         fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("tahoma",Font.PLAIN,25));
        
        add(lblname);
        
         tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Cancelation No");
       
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblnationality);
        
         cancelationno = new JLabel(""+ random.nextInt(100000));
        cancelationno.setBounds(220, 180, 150, 25);
        add(cancelationno);
        
        JLabel lblpnr = new JLabel("PNR No");
        lblpnr.setBounds(60,180,250,35);
        lblpnr.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblpnr);
        
         tfpnr = new JTextField();
        tfpnr.setBounds(280, 180, 250, 25);
        add(tfpnr);
        
       
        
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblgender);
        
         lbldateoftravel = new JLabel("Date");
        lbldateoftravel.setBounds(220,280,150,25);
        add(lbldateoftravel );
        
         cancel = new JButton("Cancel");
        cancel.setBounds(220, 330, 150, 25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
    
        
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==fetchButton){
        
        String pnr = tfpnr.getText();
      
        
        try {
            
            Conn c = new Conn();
            
            String querty  = "select *from reservation   where PNR = '"+pnr+"'";
            
          ResultSet rs =  c.s.executeQuery(querty);
          
          if(rs.next())
          {
              tfname.setText(rs.getString("name"));
              lblfcode.setText(rs.getString("flightcode"));
               lbldateoftravel .setText(rs.getString("ddate"));
              
          }
          else{
                          JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");

          }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }
        else if(ae.getSource()==cancel){
        
        String name = tfname.getText();
        String pnr = tfpnr.getText();
        String cancelno = cancelationno.getText();
        String fcode = lblfcode.getText();
        String date =  lbldateoftravel.getText();
        
        try {
            
            Conn c = new Conn();
            
            String querty  = " insert into cancel values ('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
            
          c.s.executeUpdate(querty);
          c.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
           JOptionPane.showMessageDialog(null, "Ticket Canceled...");
        
           
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }
//        else
//        {
//            Random random = new Random();
//            
//            String aadhar = tfaadhar.getText();
//            String name = tfname.getText();
//            String nationality = tfnationality.getText();
//            String flightname = labelfname.getText();
//            String flightcode = labelfcode.getText();
//            String src = source.getSelectedItem();
//            String des = destination.getSelectedItem();
//            String ddate  = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();  
//            
//                    try {
//            
//            Conn c = new Conn();
//            
//            String querty  = "insert into reservation values( 'PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"','"+ddate+"')";
//            
//               c.s.executeUpdate(querty);
//          
//          
//                                     JOptionPane.showMessageDialog(null, "Ticket booked successfully");
//                                     setVisible(false);
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
    }
    
    public static void main(String[] args) {
        
        new Cancel();
    }
}
