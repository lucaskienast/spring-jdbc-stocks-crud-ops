package com.stocks.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stocks.bean.StockBean;
import com.stocks.db.DBConnection;

public class StockDao {
	
	public DBConnection connection;
	
	public StockDao() {
		super();
	}

	public StockDao(DBConnection connection) {
		super();
		this.connection = connection;
	}

	public DBConnection getConnection() {
		return connection;
	}

	public void setConnection(DBConnection connection) {
		this.connection = connection;
	}

	public List<StockBean> getAllStocks() {
		
		List<StockBean> listOfStocks = new ArrayList<StockBean>();
		
		try {
			
			Statement stmt = this.connection.getConnection().createStatement();
			String query = "SELECT * FROM stocks";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				StockBean bean = new StockBean();
				bean.setIsin(rs.getString(1));
				bean.setTicker(rs.getString(2));
				bean.setName(rs.getString(3));
				bean.setSharePrice(rs.getFloat(4));
				bean.setSharesOutstanding(rs.getInt(5));
				listOfStocks.add(bean);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfStocks;
		
	}
	
	public StockBean getStockByIsin(String isin) {
		
		StockBean bean = new StockBean();
		
		try {
			
			Statement stmt = this.connection.getConnection().createStatement();
			String query = "SELECT * FROM stocks WHERE isin = '" + isin + "'";
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				bean.setIsin(rs.getString(1));
				bean.setTicker(rs.getString(2));
				bean.setName(rs.getString(3));
				bean.setSharePrice(rs.getFloat(4));
				bean.setSharesOutstanding(rs.getInt(5));
			} else {
				bean = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bean;
		
	}
	
	public int insertStock(StockBean bean) {
		
		int rowsAffected = 0;
		
		try {
			
			String query = "INSERT INTO stocks VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = this.connection.getConnection().prepareStatement(query);
			pstmt.setString(1, bean.getIsin());
			pstmt.setString(2, bean.getTicker());
			pstmt.setString(3, bean.getName());
			pstmt.setFloat(4, bean.getSharePrice());
			pstmt.setInt(5, bean.getSharesOutstanding());
			rowsAffected = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
		
	}
	
	public int deleteStockByIsin(String isin) {
		
		int rowsAffected = 0;
		
		try {
			
			String query = "DELETE FROM stocks WHERE isin = ?";
			PreparedStatement pstmt = this.connection.getConnection().prepareStatement(query);
			pstmt.setString(1, isin);
			rowsAffected = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
		
	}
	
	public int updateStockByIsin(StockBean bean) {
		
		int rowsAffected = 0;
		
		try {
			
			String query = "UPDATE stocks "
					+ "SET ticker = ?, name = ?, sharePrice = ?, sharesOutstanding = ? "
					+ "WHERE isin = ?";
			PreparedStatement pstmt = this.connection.getConnection().prepareStatement(query);
			pstmt.setString(1, bean.getTicker());
			pstmt.setString(2, bean.getName());
			pstmt.setFloat(3, bean.getSharePrice());
			pstmt.setInt(4, bean.getSharesOutstanding());
			pstmt.setString(5, bean.getIsin());
			rowsAffected = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
		
	}

}
