
package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener{
    
    public Home()
    {
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1380, 750);
        add(image);
        
        JLabel heading = new JLabel("Air india welcomes you");
        heading.setBounds(500, 20, 1000, 40);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("tohama",Font.PLAIN, 36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
          
          
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
         JMenuItem tiketcancellation = new JMenuItem("Cancel Tiket");
         tiketcancellation.addActionListener(this);
        details.add(tiketcancellation);
        
        JMenu Ticket = new JMenu("Ticket");
     
        menubar.add(Ticket);
        
        JMenuItem boardingpass = new JMenuItem("Boarding Pass");
      boardingpass.addActionListener(this);
        Ticket.add(boardingpass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        String text = e.getActionCommand();
        
        if(text.equals("Add Customer Details"))
        {
            new AddCustomer();
        } 
        else if(text.equals("Flight Details"))
        {
            new FlightInfo();
        }
        else if(text.equals("Book Flight"))
        {
            new BookFlight();
        }
        else if(text.equals("Journey Details"))
        {
            new JournyDetails();
        }
        else if(text.equals("Cancel Tiket"))
        {
            new Cancel();
        }
       else if(text.equals("Boarding Pass"))
        {
            new BoardingPass();
        }
    }
    
    
    public static void main(String[] args) {
        
        new Home();
    }
}
