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
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Order extends JFrame{
    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
    public Add_Order(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("Place order");
        
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
            
            JLabel Oid = new JLabel("Order id ");
            Oid.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Oid.setBounds(60, 80, 150, 27);
            add(Oid);
            
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
            
            JLabel Items = new JLabel("Items");
            Items.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Items.setBounds(60, 170, 150, 27);
            add(Items);
            
            textField_2 = new JTextField();
            textField_2.setBounds(200, 170, 150, 27);
            add(textField_2);
                    
            JLabel costper = new JLabel("Cost Per");
            costper.setFont(new Font("Tahoma", Font.PLAIN, 17));
            costper.setBounds(60, 220, 150, 27);
            add(costper);
            
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);

            JLabel total = new JLabel("Total");
            total.setFont(new Font("Tahoma", Font.PLAIN, 17));
            total.setBounds(60, 270, 150, 27);
            add(total);

            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);            

            setVisible(true);

            JLabel AddPassengers = new JLabel("ADD ORDER DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(420, 24, 442, 35);
            add(AddPassengers);            
            
            //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("C:/Users/yagne/Desktop/py.allmight.jpeg"));
            //JLabel image = new JLabel(i1);
            //image.setBounds(450,80,280,410);
            //add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    int oid = Integer.parseInt(textField.getText());
                    int cid = Integer.parseInt(textField_1.getText());
                    String items =  textField_2.getText();
                    String cper = textField_3.getText();
                    int tot = Integer.parseInt(textField_4.getText());
                    
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO ordr values( '"+oid+"', '"+cid+"', '"+items+"', '"+cper+"','"+tot+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Order Added");
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
     new Add_Order();
    }
}
