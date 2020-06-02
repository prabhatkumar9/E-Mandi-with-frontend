package crud;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Product;
import utitlity.ConnectionManager;

public class ProductCRUD {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ConnectionManager cm = new ConnectionManager();
    Connection con;
 
    // modify products specs
    public void updateProduct(String proid) throws Exception {
	System.out.println("Select What you want to update.");
	System.out.println("1. Product Name.");
	System.out.println("2. Product Price.");
	System.out.println("3. Product Description.");
	System.out.println("4. Delete Product.");
	int choice = Integer.parseInt(br.readLine().trim());
	switch(choice) {
	case 1:
	    // update name
	    System.out.println("Enter New Name  :  ");
	    String name = br.readLine().trim();
	    String updateName = "update product set name ='"+name+"' where id='"+proid+"'";
	    updateDB(updateName);
	    break;
	case 2:
	    // update price
	    System.out.println("Enter New Price  :  ");
	    int price = Integer.parseInt(br.readLine().trim());
	    String updatePrice = "update product set price = "+price+" where id='"+proid+"'";
	    updateDB(updatePrice);
	    break;
	case 3:
	    // update description
	    System.out.println("Enter New Description  :  ");
	    String desc = br.readLine().trim();
	    String updateDes = "update product set description = '"+desc+"' where id='"+proid+"'";
	    updateDB(updateDes);
	    break;
	case 4:
	    // delete item
	    try {
		String delete = "delete from product where id = '"+proid+"'";
		    updateDB(delete);
	    }catch(Exception e) {
		System.out.println("Item cannot be deleted because of maintaining order history.");
	    }
	    break;
	}
    }
    
    
    // execute statement to update database
    public void updateDB(String update) throws Exception {
	con = cm.getConnection();
	PreparedStatement ps = con.prepareStatement(update);
	    int x = ps.executeUpdate();
		if(x==1) {
		    System.out.println("Updated Successfully.");
		}
    	}
    
    
    
    // adding product to the database table
    public void addProduct(Product product, int quantity) throws Exception {
	 addStock(product,quantity);
	con = cm.getConnection();
	String  insertProduct = "insert into product(id,name,price, description) values(?,?,?,?)";
	 PreparedStatement ps = con.prepareStatement(insertProduct);
	 ps.setString(1, product.getProductId());
	 ps.setString(2, product.getProductName());
	 ps.setInt(3, product.getPrice());
	 ps.setString(4, product.getDescription());
	 int x = ps.executeUpdate();
	 if(x==1) {
	     System.out.println("Product added.");
	 }else {
	     System.out.println("Error in adding products.");
	 }
	
	 con.close();
    }
    
    // adding item stocks to database table
    public void addStock(Product product, int quantity) throws Exception {
	String insertStock = "insert into stock(stockid,quantity) values(?,?)";
	con = cm.getConnection();
	PreparedStatement ps = con.prepareStatement(insertStock);
	String stockid = product.getProductName();
	try {
	    	ps.setString(1, stockid);
	    	ps.setInt(2, quantity);
		ps.executeUpdate();
	}catch(Exception e) {
	    String updateStock = "update stock set quantity = "+quantity+"where stockid = "+stockid;
	    PreparedStatement ps1 = con.prepareStatement(updateStock);
	    ps1.setInt(1, quantity);
	}
	
    }
    
    public String generateProductId() throws Exception {
	 int id = 0;
	 String sql = "select count(id)+1 from product";
	     con = cm.getConnection();
	     Statement st = con.createStatement();
	     ResultSet rs = st.executeQuery(sql);
	     if(rs.next()) {
		 id = Integer.parseInt(rs.getString(1));
	     }
	     String prodid = "prod"+id;
	     con.close();
	     return prodid ;
    }
    
    
    
    
}
