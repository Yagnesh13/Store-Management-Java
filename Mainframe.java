/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop_manage;

/**
 *
 * @author yagne
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Mainframe extends JFrame {
    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("Super Store Management");
        initialize();
    }
    
    private void initialize() {
	
        setForeground(Color.CYAN);
        setLayout(null); 

//        JLabel NewLabel = new JLabel("");//ClassLoader.getSystemResource
//	//NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("shop_manage/bg/logo.png")));
//	//NewLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("shop_manage/bg/mainf.jpg")).getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH)));
//        
//        
//        //NewLabel.setBounds(50,50,1920,990);//(0, 0, 1920, 990); 
//	add(NewLabel); 
JLabel NewLabel = new JLabel("");
	//NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/front.jpg")));
	NewLabel.setBounds(0, 0, 1920, 990); 
	add(NewLabel); 
        
        JLabel Store = new JLabel("Welcome To Super Store");
	Store.setForeground(Color.BLUE);
        Store.setFont(new Font("Tahoma", Font.PLAIN, 36));
	Store.setBounds(70, 60, 1000, 55);
	NewLabel.add(Store);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu StoreSystem = new JMenu("Store System");
        StoreSystem.setForeground(Color.BLUE);
	menuBar.add(StoreSystem);
		
        JMenuItem ProductDetails = new JMenuItem("Products Info");
	StoreSystem.add(ProductDetails);
        
        JMenuItem Addpro = new JMenuItem("Add Product");
	StoreSystem.add(Addpro);
        
        
        JMenuItem Cancellation = new JMenuItem("Cancellation");
	StoreSystem.add(Cancellation);
        
		
        JMenu Customers = new JMenu("Customers");
        Customers.setForeground(Color.RED);
	menuBar.add(Customers);
        
        JMenuItem CustomerDetails = new JMenuItem("Add Customer");
        Customers.add(CustomerDetails);	
        
        JMenuItem Reserve = new JMenuItem("See Customer Details");
        Customers.add(Reserve);
        
        JMenu Order = new JMenu("Orders");
        Order.setForeground(Color.RED);
	menuBar.add(Order);
        
        JMenuItem OrderDetails = new JMenuItem("Place Order");
	Order.add(OrderDetails);
        
        JMenuItem OrderDetails_1 = new JMenuItem("Order Details");
	Order.add(OrderDetails_1);
	
		
	/*JMenu Ticket = new JMenu("TICKET");
        Ticket.setForeground(Color.RED);
	menuBar.add(Ticket);*/
		
        /*JMenu List = new JMenu("LIST");
        List.setForeground(Color.BLUE);
	menuBar.add(List);*/
		
	/*JMenu Misc = new JMenu("MISC");
        Misc.setForeground(Color.RED);
	menuBar.add(Misc);*/
        
		
	ProductDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Product_Info();  //Flight_Info
            }
	});
        
	CustomerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Customer();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
        
        Reserve.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Display_Customers();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        Addpro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_product();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
	
        OrderDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Order(); //Payment_Details
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
        
        OrderDetails_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Order_Details(); //Payment_Details
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
            }
	});
		
        setSize(1950,1090);
	setVisible(true);
    }
}
