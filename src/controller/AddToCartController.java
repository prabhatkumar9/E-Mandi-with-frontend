package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import model.Product;

@WebServlet("/addToCart")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> cart = new ArrayList<Product>();
	ProductDAO prodDao = new ProductDAO();
	
    public AddToCartController() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id  = request.getParameter("id");
	    System.out.println("Product added");
	    System.out.println(id);
	     try {
		cart = prodDao.addTocart(cart,id, 1);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	     System.out.println("cart size : "+cart.size());
	     
	     // session	 // access anywhere    
	     // cart list for cart.jsp // sending to cartController
	     request.getSession().setAttribute("cartList",cart);

	     
	     // redirect to home
	     response.sendRedirect("home");
	    
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////	    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
////	    rd.forward(request,response);
//	    response.sendRedirect("home");
//	}

}
