package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserLoginDAO;
import model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UserLoginDAO loginUser = new UserLoginDAO();
	private boolean validUser = false;
	
    public LoginController() {
		super();
    	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		rd.forward(request,response);
    	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userName = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    // model object
	    User user = new User();
	    user.setUserName(userName);
	    user.setPassword(password);
	    
	    // verify user
	    try {
		validUser = loginUser.login(userName, password);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    

//	    if(validUser) {
////		// session 
////		 HttpSession session = request.getSession();
////		 session.setAttribute("validUser", validUser);
//		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
//		rd.forward(request,response);
//	    }else {
//		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
//		rd.forward(request,response);
//	    }
	    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		rd.forward(request,response);
	}

}
