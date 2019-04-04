package servlet;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.User;
import logic.LoginModel;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static LoginModel log= new LoginModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String redirect="/index.jsp";
		String email= request.getParameter("loginEmail");
		String password= request.getParameter("loginPass");
		User user= (User) request.getSession().getAttribute("account");
        String pass;
		if(user==null) {
			try {
				
				user= log.login(email,password);
			
				if(user!= null) {
					request.getSession().setAttribute("account",user);
					redirect="/home.jsp";
					response.sendRedirect(request.getContextPath()+redirect);
				}else {
					String message= "Nessun account trovato. Controlla l'email o la password";
					request.setAttribute("invalid", message);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String message= "Contattare l'assistenza";
				request.setAttribute("invalid", message);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
			
		}else if(user!=null) {
			user=null;
			request.getSession().setAttribute("account",user);
			redirect="/index.jsp";
			response.sendRedirect(request.getContextPath()+redirect);
		}
	}
}
