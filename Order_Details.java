
package shop_manage;


import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Order_Details extends JFrame {
    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Order_Details().setVisible(true);    
    }
    
    public Order_Details(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Fcode = new JLabel("Order ID");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
	add(Fcode);
	
		
	JLabel CustDetails = new JLabel("ORDER INFORMATION");
	CustDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	CustDetails.setForeground(new Color(100, 149, 237));
	CustDetails.setBounds(50, 20, 570, 35);
	add(CustDetails);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                int code = Integer.parseInt(textField.getText());
                
                try {
                    conn c = new conn();
                    String str = "select * from ordr where oid = '"+code+"'";
      
                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	add(btnShow);
        
        JButton btnShowAll = new JButton("SHOW ALL");
	btnShowAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        btnShowAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	                
                try {
                    conn c = new conn();
                    String str1 = "select o.oid,o.items,o.costper,o.total,c.cname,c.cdist,c.cstat from ordr o inner join customer c on c.cid=o.cid";
      
                    ResultSet rs = c.s.executeQuery(str1);
                    table.setModel(DbUtils.resultSetToTableModel(rs));	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });
        btnShowAll.setBounds(220+150, 150, 200, 30);
	add(btnShowAll);
        
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
	
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,70);
		
    }
}
