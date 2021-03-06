package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Statistica;
import logic.User;

/**
 * Servlet implementation class Util
 */
@WebServlet("/Util")
public class Util extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Util() {
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
		String action= request.getParameter("action");
		User user= (User) request.getSession().getAttribute("account");
		ArrayList<Statistica> stats= (ArrayList<Statistica>) request.getSession().getAttribute("stats");

		switch(action.toLowerCase()) {
		case "logout":{

			user=null;
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+redirect);
		}break;	
		case "clear":{
			stats=null;
			redirect="/index.jsp";
			request.getSession().setAttribute("stats", stats);;
			response.sendRedirect(request.getContextPath()+redirect);
		}break;
		case "download":{
			//input il nome fie
			if(stats!=null) {
				int i=1;
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=StatisticaExcel.xls");
				PrintWriter out= response.getWriter();
				out.println("#\tRegione\tCod. plesso\tCod. classe\tCod. registro\tTipo test\tData\tGenere\tEt�\tNum. corrette\tNum. sbagliate\tNum saltate\t"
						+ "Livello max\tTempo\tErr. livello 1\tErr. livello 2\tErr. livello 3\tErr. livello 4\tFeedback 1\tFeedback 2\tFeedback 3\tFeedback 4\t"
						+ "Feedback 5\tFeedback 6\tFeedback 7\tFeedback 8");
				for(Statistica a: stats) {
					out.println(i+"\t"+a.getRegione()+"\t"+a.getCodicePlesso()+"\t"+a.getCodiceClasse()+"\t"+a.getCodiceRegistro()+"\t"+a.getTipoTest()+"\t"+a.getData()+"\t"+a.getGenere()+"\t"+a.getEta()+"\t"+a.getNumCorrette()+
							"\t"+a.getNumSbagliate()+"\t"+a.getNumSaltate()+"\t"+a.getLivelloRaggiunto()+"\t"+a.getTempoImpiegato()+"\t"+a.getErrore1()+"\t"+a.getErrore2()+"\t"+a.getErrore3()+"\t"+a.getErrore4()+
							"\t"+a.getDomanda1()+"\t"+a.getDomanda2()+"\t"+a.getDomanda3()+"\t"+a.getDomanda4()+"\t"+a.getDomanda5()+"\t"+a.getDomanda6()+"\t"+a.getDomanda7()+"\t"+a.getDomanda8());
					i++;
				}
			}else {
				redirect="/home.jsp";
				response.sendRedirect(request.getContextPath()+redirect);
			}
		}break;
		case "detail":{
			String file=request.getParameter("detail");
			redirect="/detail.jsp";
			request.getSession().setAttribute("stats", stats);
			request.getSession().setAttribute("detail", file);
			response.sendRedirect(request.getContextPath()+redirect);
		}break;
		}
	}

}
