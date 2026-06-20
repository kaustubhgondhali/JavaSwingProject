
package airlinemanagementsystem;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;

public class BookFlight extends JFrame implements ActionListener {
    JTextField tfaadhar;
    JButton flight,bookflight,fetchButton;
    JRadioButton rbmale,rbfemale,rbother;
    JLabel tfname,tfnationality,tfaddress,lblfname,lblfcode,labelfcode,labelfname,labelgender;
    Choice source,destination;
    JDateChooser dcdate;
    public BookFlight(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("tahoma",Font.PLAIN,32));
        heading.setForeground(Color.blue);
        add(heading);
        
         JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230 ,150,25);
        lbladdress.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lbladdress);
        
         tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
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
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblnationality);
        
         tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel lblaadhar = new JLabel("Aadhar No");
        lblaadhar.setBounds(60,180,250,35);
        lblaadhar.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblaadhar);
        
         tfaadhar = new JTextField();
        tfaadhar.setBounds(280, 180, 250, 25);
        add(tfaadhar);
        
       
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblgender);
        
         labelgender = new JLabel("Gender");
        labelgender.setBounds(220,280,150,25);
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60,330,150,25);
        lblsource.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblsource);
        
         source = new Choice();
        source.setBounds(220, 330, 120, 25);
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60,380,150,25);
        lbldest.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lbldest);
     
          destination = new Choice();
        destination.setBounds(220, 380, 120, 25);
        add(destination);
        
        try {
            Conn c = new Conn();
            String query = "select *from flight";
           ResultSet rs = c.s.executeQuery(query);
           
           while(rs.next())
           {
               source.add(rs.getString("source"));
               destination.add(rs.getString("destination"));
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,430 ,150,25);
        lblfname.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblfname);
        
         labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);
        
          lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60,480 ,150,25);
        lblfcode.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lblfcode);
        
         labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);
        
       JLabel lbldate = new JLabel("Date of travel");
        lbldate.setBounds(60,530 ,150,25);
        lbldate.setFont(new Font("tahoma",Font.PLAIN,25));
        add(lbldate);
        
         dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);
        
//        JLabel lblphone = new JLabel("Phone No");
//        lblphone.setBounds(60,320,250,35);
//        lblphone.setFont(new Font("tahoma",Font.PLAIN,25));
//        add(lblphone);
//        
//         tfphone = new JLabel();
//        tfphone.setBounds(280, 320, 250, 25);
//        add(tfphone);
        
         flight = new JButton("Fetch Flights");
        flight.setBounds(380, 400, 150, 25);
        flight.setBackground(Color.black);
        flight.setForeground(Color.white);
        flight.addActionListener(this);
        add(flight);
        
//        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
//        JLabel i1  = new JLabel(image1);
//        i1.setBounds(550,80,500,410);
//        add(i1);

           bookflight = new JButton("Book Flights");
        bookflight.setBackground(Color.black);
        bookflight.setForeground(Color.white);
        bookflight.setBounds(220,580,150,25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setSize(1100,800);
        setLocation(150,20);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==fetchButton){
        
        String aadhar = tfaadhar.getText();
      
        
        try {
            
            Conn c = new Conn();
            
            String querty  = "select *from passenger where aadhar = '"+aadhar+"'";
            
          ResultSet rs =  c.s.executeQuery(querty);
          
          if(rs.next())
          {
              tfname.setText(rs.getString("name"));
              tfnationality.setText(rs.getString("nationality"));
               tfaddress.setText(rs.getString("address"));
               labelgender.setText(rs.getString("gender"));
          }
          else{
                          JOptionPane.showMessageDialog(null, "Please Enter Correct aadhar number");

          }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }
        else if(ae.getSource()==flight){
        
        String srce = source.getSelectedItem();
        String dest = destination.getSelectedItem();
      
        
        try {
            
            Conn c = new Conn();
            
            String querty  = "select *from flight where source = '"+srce+"' and destination = '"+dest+"'";
            
          ResultSet rs =  c.s.executeQuery(querty);
          
          if(rs.next())
          {
              labelfname.setText(rs.getString("f_name"));
              labelfcode.setText(rs.getString("f_code"));
               
          }
          else{
                          JOptionPane.showMessageDialog(null, "NO Flights found");

          }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }
        else
        {
            Random random = new Random();
            
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String des = destination.getSelectedItem();
            String ddate  = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();  
            
                    try {
            
            Conn c = new Conn();
            
            String querty  = "insert into reservation values( 'PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"','"+ddate+"')";
            
               c.s.executeUpdate(querty);
          
          
                                     JOptionPane.showMessageDialog(null, "Ticket booked successfully");
                                     setVisible(false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
    
    public static void main(String[] args) {
        
        new BookFlight();
    }
}
