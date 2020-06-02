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


@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User newUser = new User();
	private NewRegistrationDAO register = new NewRegistrationDAO();

    public RegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp");
	     rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    // getting from jsp page
		     String userName = request.getParameter("userName");
		     String email =request.getParameter("email");
		     String password = request.getParameter("password");
		     String firstName = request.getParameter("firstName");
		     String lastName = request.getParameter("lastName");
		     String gender = request.getParameter("gender");
		     String number = request.getParameter("firstName");
		     String address = request.getParameter("address");
		     String age = request.getParameter("age");
		     
		     // setting details to newUser object 
		     try {
			newUser.setCustomerId(register.generateCustomerId());
			newUser.setUserId(register.generateUserId());
			newUser.setUserName(userName);
			newUser.setEmailadd(email);
			newUser.setPassword(password);
			newUser.setFirstName(firstName);
			newUser.setLastName(lastName);
			newUser.setGender(gender);
			newUser.setContact(number);
			newUser.setAddress(address);
			try {
			    newUser.setAge(Integer.parseInt(age));
			}catch (Exception e) {
			    }
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		
		     
		     if(password != null && firstName != null) {
			 try {
			    register.insertUserDetails(newUser);
			    request.setAttribute("message", "Registration Successful");
			} catch (Exception e) {
			    e.printStackTrace();
			}
		     }
		    
	 
//		     // printing output
//		     System.out.println("in registration controller ");
//		     System.out.println(newUser.getEmailadd());
//		     System.out.println(newUser.getUserName());
//		     System.out.println(newUser.getPassword());
//		     System.out.println(newUser.getFirstName());
//		     System.out.println(newUser.getLastName());
//		     System.out.println(newUser.getGender());
//		     System.out.println(newUser.getAge());
		     
		     
		     RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp");
		     rd.forward(request, response);
	}

}
