package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.User;
import utitlity.ConnectionManager;

public class NewRegistrationDAO {

    ConnectionManager cm = new ConnectionManager();
    Connection con;

     // update user and customer details after new registration
     public void insertUserDetails(User user) throws Exception {
         con = cm.getConnection();
         String insertToUserdetails = "insert into userdetails1 (userId,customerid,username,password) values(?,?,?,?)";
         String insertToCustomer = "insert into customer (custId,firstname,lastname,email,address,gender,age,contact) values(?,?,?,?,?,?,?,?)";
         
         /// inserting into customer table
         PreparedStatement ps1 = con.prepareStatement(insertToCustomer);
         ps1.setString(1,user.getCustomerId());
         ps1.setString(2,user.getFirstName());
         ps1.setString(3,user.getLastName());
         ps1.setString(4,user.getEmailadd());
         ps1.setString(5,user.getAddress());
         ps1.setString(6, user.getGender());
         ps1.setInt(7, user.getAge());
         ps1.setString(8,user.getContact());
    	     
         /// inserting into userdetails table
         PreparedStatement ps =  con.prepareStatement(insertToUserdetails);
         ps.setInt(1, user.getUserId());
         ps.setString(2,user.getCustomerId());
         ps.setString(3,user.getUserName());
         ps.setString(4,user.getPassword());
         ps1.executeUpdate();
         ps.executeUpdate();  
     }  
     
     
     // generate unique user id for each user
     public int generateUserId() throws Exception {
         int userid = 0;
         String sql = "select count(userid)+1 from userdetails1";
         ResultSet rs = getDb(sql);
         if(rs.next()) {
    	 userid = Integer.parseInt(rs.getString(1));
         }
         return userid;
     }
     
     // generate unique customer id for each customer
     public String generateCustomerId() throws Exception {
         String custid = null;
         String sql = "select count(custid)+1 from customer";
         ResultSet rs = getDb(sql);
         if(rs.next()) {
    	custid = rs.getString(1);
         }
         return custid;
     }
     
     // fetch result driver
     public ResultSet getDb(String sql) throws Exception {
         con = cm.getConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         return rs; 
     }
    
}
