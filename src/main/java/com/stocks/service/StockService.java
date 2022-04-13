package com.stocks.service;

import java.util.List;

import com.stocks.bean.StockBean;
import com.stocks.dao.StockDao;

public class StockService {
	
	private StockDao stockDao;
	
	public StockService() {
		super();
	}

	public StockService(StockDao stockDao) {
		super();
		this.stockDao = stockDao;
	}

	public StockDao getStockDao() {
		return stockDao;
	}

	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}

	public List<StockBean> getAllStocks() {
		
		List<StockBean> listOfStocks = stockDao.getAllStocks();
		return listOfStocks;
		
	}
	
	public StockBean getStockByIsin(String isin) {
		
		StockBean bean = stockDao.getStockByIsin(isin);
		return bean;
		
	}
	
	public int insertStock(StockBean bean) {
		
		int rowsAffected = stockDao.insertStock(bean);
		return rowsAffected;
		
	}
	
	public int deleteStockByIsin(String isin) {
		
		int rowsAffected = stockDao.deleteStockByIsin(isin);
		return rowsAffected;
		
	}

	public int updateStockByIsin(StockBean bean) {
		
		int rowsAffected = stockDao.updateStockByIsin(bean);
		return rowsAffected;
		
	}
	
	public void showUserOptions() {
		System.out.println("Select one of the following operations");
		System.out.println();
		System.out.println("1. Create new stock");
		System.out.println("2. Read all existing stocks");
		System.out.println("3. Read existing stock via ISIN");
		System.out.println("4. Update existing stock via ISIN");
		System.out.println("5. Delete existing stock via ISIN");
		System.out.println("6. End programm");
	}


}
