package controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ProductDAO;
import model.Product;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  List<Product> productList ;
	private ProductDAO productDao = new ProductDAO();
	static int count =0;
	
    public HomeController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    try {
			if(count==0) {
			    productList = productDao.displayProductlist();
			}
			  count++;
			} catch (Exception e) {
	 		e.printStackTrace();
	 	    }

	    request.setAttribute("productList", productList);
	    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
	    rd.forward(request,response);
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    
//	    request.setAttribute("userName", "Prabhat");
//	    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
//		rd.forward(request,response);
//	}

}
