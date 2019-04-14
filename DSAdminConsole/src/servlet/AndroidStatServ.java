package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.AndroidStat;
import logic.RegModel;

/**
 * Servlet implementation class Android
 */
@WebServlet("/AndroidStatServ")
public class AndroidStatServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AndroidStat stat= new AndroidStat();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AndroidStatServ() {
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
		boolean error=true;
		String tipoTest = request.getParameter("tipoTest");
	    String codicePlesso = request.getParameter("codicePlesso");
	    String regione = request.getParameter("regione");
	    String data = request.getParameter("data");
	    String genere = request.getParameter("genere");
	    String eta = request.getParameter("eta");
	    String livelloRaggiunto = request.getParameter("livelloRaggiunto");
	    String numCorr = request.getParameter("numCorr");
	    String numSaltate = request.getParameter("numSaltate");
	    String numErr = request.getParameter("numErr");
	    String tempo = request.getParameter("tempo");
	    String errLiv1 = request.getParameter("errLiv1");
	    String errLiv2 = request.getParameter("errLiv2");
	    String errLiv3 = request.getParameter("errLiv3");
	    String errLiv4 = request.getParameter("errLiv4");
	    String domanda1 = request.getParameter("domanda1");
	    String domanda2 = request.getParameter("domanda2");
	    String domanda3 = request.getParameter("domanda3");
	    String domanda4 = request.getParameter("domanda4");
	    String domanda5 = request.getParameter("domanda5");
	    String domanda6 = request.getParameter("domanda6");
	    String domanda7 = request.getParameter("domanda7");
	    String domanda8 = request.getParameter("domanda8");
	    String codiceClasse = request.getParameter("codiceClasse");
	    String codiceRegistro = request.getParameter("codiceRegistro");
	    String fileName = request.getParameter("fileName");
	    
	    try {
			int check = stat.setStatistica(tipoTest, codicePlesso, regione, data, genere, eta, livelloRaggiunto, numCorr, numSaltate, numErr, tempo, errLiv1, errLiv2, errLiv3, errLiv4, domanda1, domanda2, domanda3, domanda4, domanda5, domanda6, domanda7, domanda8, codiceClasse, codiceRegistro, fileName);
			
			if(check>0) {
				error=false;
				System.out.println("errore nel caricamento: "+error);
				
				String jsonObject="{\"error\": \"false\"}";
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.print(jsonObject);
				out.flush();
			}else {
				System.out.println("errore nel caricamento: "+error);

				String jsonObject="{\"error\": \"false\"}";
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.print(jsonObject);
				out.flush();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}

}
