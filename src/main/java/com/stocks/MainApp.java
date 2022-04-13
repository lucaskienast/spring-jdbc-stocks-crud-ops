package com.stocks;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stocks.bean.StockBean;
import com.stocks.service.StockService;

public class MainApp {
	

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.start();
		
		StockService stockService = context.getBean("stockService", StockService.class);
		
		Scanner sc = new Scanner(System.in);
		boolean conti = true;

		System.out.println("_________________ Stock Market CRUD Operations _________________");
		System.out.println();
		System.out.println("This Java application performs simple CRUD operations for stocks.");
		
		while (conti) {
			try {
				stockService.showUserOptions();
				int userInput = sc.nextInt();
				StockBean bean = new StockBean();
				String isin, ticker, name;
				float sharePrice;
				int sharesOutstanding, rowsAffected;
				
				switch (userInput) {
				case 1:
					
					System.out.println("ISIN: ");
					isin = sc.next();
					bean.setIsin(isin);
					
					System.out.println("Ticker: ");
					ticker = sc.next();
					bean.setTicker(ticker);
					sc.nextLine();
					
					System.out.println("Name: ");
					name = sc.nextLine();
					bean.setName(name);
					
					System.out.println("Share Price: ");
					sharePrice = sc.nextFloat();
					bean.setSharePrice(sharePrice);
					
					System.out.println("Shares Outstanding: ");
					sharesOutstanding = sc.nextInt();
					bean.setSharesOutstanding(sharesOutstanding);
					
					rowsAffected = stockService.insertStock(bean);
					System.out.println("Number of stocks created: " + rowsAffected);
					
					break;
				case 2:
					List<StockBean> listOfStocks = stockService.getAllStocks();
					
					for (StockBean stock : listOfStocks) {
						System.out.println(stock);
					}
					
					break;
				case 3:
					System.out.println("ISIN: ");
					isin = sc.next();
					bean = stockService.getStockByIsin(isin);
					System.out.println(bean);
					break;
				case 4:
					System.out.println("ISIN: ");
					isin = sc.next();
					bean.setIsin(isin);
					
					System.out.println("Ticker: ");
					ticker = sc.next();
					bean.setTicker(ticker);
					sc.nextLine();
					
					System.out.println("Name: ");
					name = sc.nextLine();
					bean.setName(name);
					
					System.out.println("Share Price: ");
					sharePrice = sc.nextFloat();
					bean.setSharePrice(sharePrice);
					
					System.out.println("Shares Outstanding: ");
					sharesOutstanding = sc.nextInt();
					bean.setSharesOutstanding(sharesOutstanding);
					
					rowsAffected = stockService.updateStockByIsin(bean);
					System.out.println("Number of stocks created: " + rowsAffected);
					break;
				case 5:
					System.out.println("ISIN: ");
					isin = sc.next();
					rowsAffected = stockService.deleteStockByIsin(isin);
					System.out.println("Stocks affected: " + rowsAffected);
					break;
				case 6:
					System.out.println("Goodbye!");
					conti = false;
					sc.close();
					break;
				default:
					System.out.println("Invalid user input. Please try again.");
				}
			} catch(Exception e) {
				System.out.println("Oops...there was an error of type " + e + "\nPlease try again");
				sc.nextLine();
			}
		}
		
		context.stop();
		context.close();
		
	}

}
