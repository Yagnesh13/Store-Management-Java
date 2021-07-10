
package shop_manage;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*; 
public class Add_product extends JFrame {
    JTextField textField,textField_1,textField_2;//,textField_3,textField_4,textField_5,textField_6;
    public Add_product(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD PRODUCT DETAILS");
        
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
            
            JLabel Pname = new JLabel("Product Name");
            Pname.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pname.setBounds(60, 80, 150, 27);
            add(Pname);
            
            textField = new JTextField();
            textField.setBounds(200, 80, 150, 27);
            add(textField);
            
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
            
            JLabel CID = new JLabel("Product ID");
            CID.setFont(new Font("Tahoma", Font.PLAIN, 17));
            CID.setBounds(60, 120, 150, 27);
            add(CID);
            
            textField_1 = new JTextField();
            textField_1.setBounds(200, 120, 150, 27);
            add(textField_1);
            
            JLabel Address = new JLabel("Price");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
            
            textField_2 = new JTextField();
            textField_2.setBounds(200, 170, 150, 27);
            add(textField_2);

            setVisible(true);

            JLabel AddPassengers = new JLabel("ADD PRODUCT DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(420, 24, 442, 35);
            add(AddPassengers);           
 
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String pname = textField.getText();
                    int pid = Integer.parseInt(textField_1.getText());
                    int price =  Integer.parseInt(textField_2.getText());                
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO product values( '"+pid+"', '"+pname+"', '"+price+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Product Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
                }
        }
            });
            
            setSize(900,600);
            setVisible(true);
            setLocation(400,90);
            
    }
        public static void main(String[] args){
     new Add_product();
    }
}
