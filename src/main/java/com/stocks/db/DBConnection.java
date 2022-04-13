package com.stocks.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection connection;
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	public DBConnection() {
	}
	
	public DBConnection(Connection connection, String driverClassName, String url, String username, String password) {
		super();
		this.connection = connection;
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection(){ 
		try {
			if (this.connection == null) {
				Class.forName(this.driverClassName);
				connection = DriverManager.getConnection(this.url, this.username, this.password);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return this.connection;
	}

	public void closeConnection() { 
		try {
			if (this.connection != null)
				this.connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public String toString() {
		return "DBConnection [connection=" + connection + ", driverClassName=" + driverClassName + ", url=" + url
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}
