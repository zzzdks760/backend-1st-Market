package com.market.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.market.sample.model.Product;
import com.market.sample.service.Order;
import com.market.sample.service.OrderTime;

public class ProductParser {
	
	private static final String RESOURCES = "/resources/";

	public void analyze(final String fileName) {
		final Path path = Paths.get(RESOURCES + fileName);
		ProductCSVParser csvParser = new ProductCSVParser();
		List<String> lines = new ArrayList<>();
		
			
		try (InputStream inputStream = MainApplication.class.getResourceAsStream("/" + fileName);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while                                  
				((line = reader.readLine()) != null) {
				lines.add(line);
			}
			
					
			List<Product> products = csvParser.parseLinesFrom(lines);
			Order order = new Order(products);
			
			//월별 조회 메서드
			//order.validateInput(month);
			
			order.calculateTotalInMonth();
			//브랜드 상위 10위
			order.top10Brand();
			
			System.out.println();
			//차트 호출
			OrderTime ordertime = new OrderTime(products);
			ordertime.per4Hours();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
