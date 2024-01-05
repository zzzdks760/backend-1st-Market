package com.market.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("수익을 조회할 달을 입력하세요");
		String month = br.readLine();
		
		ProductParser parser = new ProductParser();
		
		parser.analyze("market-data.csv", month);
	}

}
