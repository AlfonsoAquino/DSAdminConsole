package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StudModel {
	
	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/dsa");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "user";
	
	public synchronized ArrayList<Statistica> getStudStat(String codiceClasse, String codiceStud) {
		
		Utility ut = new Utility();
		ArrayList<Statistica> stats=new ArrayList<Statistica>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String logQuery="SELECT * FROM statitisticadislessia where codiceClasse=? and codiceRegistro=?";
		int temp=0;
		try {
		connection = (Connection) ds.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(logQuery);
		preparedStatement.setString(1, codiceClasse);
		preparedStatement.setString(2, codiceStud);
		
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			Statistica stat=new Statistica(result.getString("regione"), result.getString("codicePlesso"), result.getString("codiceClasse"), result.getString("codiceRegistro"), result.getString("tipoTest"), 
					result.getString("data"), result.getString("genere"), result.getString("eta"), result.getString("numCorr"), result.getString("numErr"), result.getString("numSaltate"), result.getString("livelloRaggiunto"),
					result.getString("tempo"), result.getString("errLiv1"), result.getString("errLiv2"), result.getString("errLiv3"), result.getString("errLiv4"), result.getString("domanda1"), 
					result.getString("domanda2"), result.getString("domanda3"), result.getString("domanda4"), result.getString("domanda5"), result.getString("domanda6"), result.getString("domanda7"),
					result.getString("domanda8"), result.getString("errorFileName"),ut.getDetail(result.getString("errorFileName")));
			System.out.println(stat.toString());
			stats.add(stat);
			temp++;
		}
		if(temp==0) {
			stats=null;
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (connection != null)
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
			
		return stats;
	}

}
