package controller;

public class user1 {
	private String username;
	private String password;
	private String hoten;
	public user1(String username, String password, String hoten) {
		super();
		this.username = username;
		this.password = password;
		this.hoten = hoten;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getHoten() {
		return hoten;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	
}
