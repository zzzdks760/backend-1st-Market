package com.market.sample;

public class MainApplication {

	public static void main(String[] args){
		
		ProductParser parser = new ProductParser();
		
		parser.analyze("market-data.csv");
	}

}
