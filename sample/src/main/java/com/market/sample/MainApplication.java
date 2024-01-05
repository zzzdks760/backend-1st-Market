package com.market.sample;

public class MainApplication {

	public static void main(String[] args){
		
		ProductParser parser = new ProductParser();
		String fileName = "market-data.csv";
		
		parser.analyze(args[0]);
	}

}
