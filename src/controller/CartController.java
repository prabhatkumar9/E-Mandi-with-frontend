package controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import model.Product;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO prodDao = new ProductDAO();
	double totalAmount = 0;
	
	public CartController() {
	    super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
	    String ProductId = request.getParameter("id");
	    
	    // getting sessionListProduct
	    ArrayList<Product> NewList=(ArrayList<Product>)request.getSession().getAttribute("cartList");
	   
	    try {
		 switch(ProductId) {
		    	case "placeOrder":
		    	    System.out.println(" id for place order : "+ProductId);
		    	    System.out.println("Order placed successfully");
		    	    break;
		    	default:
		    	    if(ProductId != null) {
				 // remove product
				    NewList = prodDao.removeProduct(ProductId , NewList);
			    }
		    	   
		    	    break;
		 }// end of switch
	    }catch(Exception e) {
		
	    }
	    
	    // total cart value
    	    totalAmount = prodDao.totalCartValue(NewList);
    	    System.out.println("Product id which  is to be removed from cart : "+ProductId);
	   

	    // send to jsp
	    request.setAttribute("total", totalAmount);
	    
	    // sending data to jsp
	    request.setAttribute("updatedCart", NewList);
	    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/cart.jsp");
	    rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
