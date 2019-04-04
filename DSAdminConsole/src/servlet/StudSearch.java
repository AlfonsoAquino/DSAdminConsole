package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.StudModel;
import logic.User;
import logic.Statistica;

/**
 * Servlet implementation class StudSearch
 */
@WebServlet("/StudSearch")
public class StudSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StudModel stu= new StudModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String redirect="/index.jsp";
		String codiceClasse= request.getParameter("codiceClasseStud");
		String codiceStud= request.getParameter("codiceStudente");

		User user= (User) request.getSession().getAttribute("account");
		ArrayList<Statistica> stats= (ArrayList<Statistica>) request.getSession().getAttribute("stats");

		if(user!=null) {
			stats = stu.getStudStat(codiceClasse, codiceStud);
			if(stats!=null) {
				request.getSession().setAttribute("stats", stats);
				redirect="/home.jsp";
				response.sendRedirect(request.getContextPath()+redirect);
			}else{
				String message= "Nessuna corrispondenza trovata. Riprovare";
				request.setAttribute("invalid", message);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
