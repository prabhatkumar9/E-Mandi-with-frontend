package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NewRegistrationDAO;
import model.User;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signup.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String userName = request.getParameter("userName");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String confirmPassword = request.getParameter("confirmPassword");

	    	 // redirect to registration page
		 if(userName != null && password != null) {
		
		     // setting attribute
		     request.setAttribute("userName", userName);
		     request.setAttribute("email", email);
		     request.setAttribute("password", password);
		     
		     RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp");
		     rd.forward(request, response);
		      
		 }else {
		     request.setAttribute("message", "Check your credentails");
		     RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signup.jsp");
		     rd.forward(request, response);
		 }
		 

/// validate new user passsword and mail is correct or not
//		 UserDAO userDao = new UserDAO();
//		 int checkUser = userDao.signup(user);
//		 if(checkUser!=0) {
		   

	}

}
