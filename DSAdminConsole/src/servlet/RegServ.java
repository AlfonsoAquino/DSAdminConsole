package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.User;
import logic.RegModel;

/**
 * Servlet implementation class RegServ
 */
@WebServlet("/RegServ")
public class RegServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static RegModel reg= new RegModel(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect="/index.jsp";
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		String email= request.getParameter("email");
		String password= request.getParameter("pass");
		User user= (User) request.getSession().getAttribute("account");
        if(user == null) {
        	
        	try {
				int check= reg.registrazione(nome, cognome, email, password);
				
				if(check>0) {
					response.sendRedirect(request.getContextPath()+redirect);
				}else if(check<0) {
					String message= "L'email potrebbe essere già in uso";
					request.setAttribute("invalid", message);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrazione.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String message= "Contattare l'assistenza";
				request.setAttribute("invalid", message);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrazione.jsp");
				dispatcher.forward(request, response);
			}
        	
        }else {
        	user=null;
			request.getSession().setAttribute("account",user);
			redirect="/index.jsp";
			response.sendRedirect(request.getContextPath()+redirect);
        }
	}

}
