package com.market.sample;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.market.sample.model.Product;
import com.market.sample.service.Order;
import com.market.sample.service.OrderTime;

public class ProductParser {
	
	private static final String RESOURCES = "src/main/resources/";

	public void analyze(String fileName) {
		final Path path = Paths.get(RESOURCES + fileName);
		ProductCSVParser csvParser = new ProductCSVParser();
		
		try {
			Charset cs = StandardCharsets.UTF_8;
			List<String> lines = Files.readAllLines(path, cs);
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
