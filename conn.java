
package shop_manage;


import java.sql.*;  


public class conn {
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c = DriverManager.getConnection("jdbc:mysql://instance-name/database_name","username","password");    
            s =c.createStatement(); 
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }
}
