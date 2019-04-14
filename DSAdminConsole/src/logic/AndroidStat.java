package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AndroidStat {
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

	
	public synchronized int setStatistica(String tipoTest,String codicePlesso,String regione,String data,String genere,String eta,String livelloRaggiunto,String numCorr,String numSaltate,String numErr,String tempo,String errLiv1,String errLiv2,
			String errLiv3,String errLiv4,String domanda1,String domanda2,String domanda3,String domanda4,String domanda5,String domanda6,String domanda7,String domanda8,String codiceClasse,String codiceRegistro,String fileName) throws SQLException {
		
		String response = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String regQuery="INSERT INTO statitisticadislessia VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int temp=0;
		try {
		connection = (Connection) ds.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(regQuery);
		preparedStatement.setString(1, tipoTest);
		preparedStatement.setString(2, regione);
		preparedStatement.setString(3, codicePlesso);
		preparedStatement.setString(4, codiceClasse);
		preparedStatement.setString(5, codiceRegistro);
		preparedStatement.setString(6, data);
		preparedStatement.setString(7, genere);
		preparedStatement.setString(8, eta);
		preparedStatement.setString(9, livelloRaggiunto);
		preparedStatement.setString(10, numErr);
		preparedStatement.setString(11, numSaltate);
		preparedStatement.setString(12, numCorr);
		preparedStatement.setString(13, tempo);
		preparedStatement.setString(14, errLiv1);
		preparedStatement.setString(15, errLiv2);
		preparedStatement.setString(16, errLiv3);
		preparedStatement.setString(17, errLiv4);
		preparedStatement.setString(18, domanda1);
		preparedStatement.setString(19, domanda2);
		preparedStatement.setString(20, domanda3);
		preparedStatement.setString(21, domanda4);
		preparedStatement.setString(22, domanda5);
		preparedStatement.setString(23, domanda6);
		preparedStatement.setString(24, domanda7);
		preparedStatement.setString(25, domanda8);
		preparedStatement.setString(26, fileName);
		
		
		int result = preparedStatement.executeUpdate();
			
		if(result>0) {
			temp=1;
		}else if(result<0) {
			temp= 0;
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return temp;
		
	}
	
}
