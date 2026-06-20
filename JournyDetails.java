
package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class JournyDetails extends JFrame implements ActionListener {
 JTable table ;
    JTextField pnr;
     JButton show;
    public JournyDetails(){
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 50, 120, 25);
        add(pnr);
        
        show = new JButton("Show Detials");
        show.setBackground(Color.black);
        show.setForeground(Color.white);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        add(show);
        
        
         table = new JTable();
        
        
        
        JScrollPane jsp =new JScrollPane(table);
        jsp.setBounds(0, 100, 800, 150);
        jsp.setBackground(Color.white);
        add(jsp);
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        try {
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"';");
            
            if(!rs.isBeforeFirst())
            {
                JOptionPane.showMessageDialog(null, "No imformation found");
                return;
            }
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
        new JournyDetails();
    }
    }
