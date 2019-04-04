package logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class LoginModel {
	
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
	
	public synchronized User login(String email, String password) throws SQLException {
	
		User user=new User();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String logQuery="SELECT * FROM user where email=? and password=?";
		int temp=0;
		try {
		connection = (Connection) ds.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(logQuery);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, md5(password));
		
		ResultSet result = preparedStatement.executeQuery();
			
		boolean more= result.next();
		if(!more) {
			user=null;
		}else if(more) {
			user.setNome(result.getString("nome"));
			user.setCognome(result.getString("cognome"));
			user.setEmail(result.getString("email"));
			user.setPassword(result.getString("password"));			
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
			
		return user;		
	
	}
	public static String md5(String data)
            throws NoSuchAlgorithmException {
        // Get the algorithm:
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // Calculate Message Digest as bytes:
        byte[] digest = md5.digest(data.getBytes(UTF_8));
        // Convert to 32-char long String:
        return String.format("%032x", new BigInteger(1, digest));
    }
}
