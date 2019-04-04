package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.DataSearchModel;
import logic.Statistica;
import logic.User;

/**
 * Servlet implementation class DataSearch
 */
@WebServlet("/DataSearch")
public class DataSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DataSearchModel ser= new DataSearchModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataSearch() {
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
		// TODO Auto-generated method stub
		
		String redirect="/index.jsp";
		String dataInizio= request.getParameter("dataInizio");
		String dataFine= request.getParameter("dataFine");
		
		User user= (User) request.getSession().getAttribute("account");
		ArrayList<Statistica> stats= new ArrayList<Statistica>();
		
		if(user!=null) {
			
			stats = ser.getData(dataInizio, dataFine);
			
			if(stats!=null) {
				request.getSession().setAttribute("stats", stats);
				redirect="/home.jsp";
				response.sendRedirect(request.getContextPath()+redirect);
			}else {
				String message= "Nessun corrispondenza trovata. Riprovare";
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
