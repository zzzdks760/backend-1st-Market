package com.market.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.market.sample.model.Product;
import com.market.sample.service.Order;
import com.market.sample.service.OrderTime;

public class ProductParser {
	
//	private static final String RESOURCES = "/resources/";

	public void analyze(final String fileName) {
//		final Path path = Paths.get(RESOURCES + fileName);
		ProductCSVParser csvParser = new ProductCSVParser();
		List<String> lines = new ArrayList<>();
		
			
		try (InputStream inputStream = MainApplication.class.getResourceAsStream("/" + fileName);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
			String line;
			while                                  
				((line = reader.readLine()) != null) {
				lines.add(line);
			}
			
			
			List<Product> products = csvParser.parseLinesFrom(lines);
			Order order = new Order(products);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("수익을 조회할 달을 영어로 입력하세요");
			String inputMonth = br.readLine();
			inputMonth = inputMonth.toUpperCase();
			
			order.calculateTotalInMonth(inputMonth);
			System.out.println();
		
			//브랜드 상위 10위
			order.top10Brand();
			
			System.out.println();
			//차트 호출
			
			System.out.println("차트를 확인하시겠습니까?(Y/N)");
			String isTrue = br.readLine();
			isTrue = isTrue.toUpperCase();
			
			if (isTrue.equals("Y")) {
				OrderTime ordertime = new OrderTime(products);
				ordertime.per4Hours();
			} else {
				System.out.println("프로그램 종료.");
			}
			
			
		} catch (Exception e) {
			System.out.println("실행 파일을 정확히 입력해 주세요.");
		}

	}
}
