
package airlinemanagementsystem;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

    public FlightInfo(){
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JTable table = new JTable();
        
        try {
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from flight;");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        JScrollPane jsp =new JScrollPane(table);
        jsp.setBounds(0, 25, 800, 500);
        add(jsp);
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        
        new FlightInfo();
    }
    
}
