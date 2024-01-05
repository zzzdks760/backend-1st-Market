package com.market.sample;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductParser parser = new ProductParser();
		
		parser.analyze("market-data.csv");
	}

}
