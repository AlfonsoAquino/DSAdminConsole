package logic;

import java.io.Serializable;

public class User implements Serializable{
	
	private String nome;
	private String cognome;
	private String email;
	private String password;
	
	
	public User() {
		super();
	}
	public User(String nome, String cognome, String email, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
