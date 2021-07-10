
package shop_manage;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Customer extends JFrame {
    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
    public Add_Customer(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD CUSTOMER DETAILS");
        
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
            
            JLabel Cname = new JLabel("Customer Name");
            Cname.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Cname.setBounds(60, 80, 150, 27);
            add(Cname);
            
            textField = new JTextField();
            textField.setBounds(200, 80, 150, 27);
            add(textField);
            
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
            
            JLabel CID = new JLabel("Customer ID");
            CID.setFont(new Font("Tahoma", Font.PLAIN, 17));
            CID.setBounds(60, 120, 150, 27);
            add(CID);
            
            textField_1 = new JTextField();
            textField_1.setBounds(200, 120, 150, 27);
            add(textField_1);
            
            JLabel Address = new JLabel("Address");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
            
            textField_2 = new JTextField();
            textField_2.setBounds(200, 170, 150, 27);
            add(textField_2);
                    
            JLabel dist = new JLabel("Distance in minutes");
            dist.setFont(new Font("Tahoma", Font.PLAIN, 17));
            dist.setBounds(60, 220, 150, 27);
            add(dist);
            
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);

            JLabel Stat = new JLabel("Status");
            Stat.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Stat.setBounds(60, 270, 150, 27);
            add(Stat);

            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
            
            JLabel Phno = new JLabel("Ph.No.");
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phno.setBounds(60, 370, 150, 27);
            add(Phno);
            
            textField_5 = new JTextField();
            textField_5.setBounds(200, 370, 150, 27);
            add(textField_5);

            setVisible(true);

            JLabel AddPassengers = new JLabel("ADD CUSTOMER DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(420, 24, 442, 35);
            add(AddPassengers);
            

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String cname = textField.getText();
                    int cid = Integer.parseInt(textField_1.getText());
                    String cadd =  textField_2.getText();
                    int cdist = Integer.parseInt(textField_3.getText());
                    String cstat = textField_4.getText();
                    String cph = textField_5.getText();
                    
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO customer values( '"+cid+"', '"+cname+"', '"+cadd+"','"+cph+"', '"+cdist+"','"+cstat+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Customer Added");
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
     new Add_Customer();
    } 
     
}
