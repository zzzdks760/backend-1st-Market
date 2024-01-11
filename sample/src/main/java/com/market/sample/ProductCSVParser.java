package com.market.sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.market.sample.model.Product;
import com.market.sample.model.Product.Builder;

public class ProductCSVParser {
	final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	// 메서드
		// 1. 데이터에서 한 줄만 파싱하는 기능
		public Product parseFrom(final String line) {
			String[] columns = line.split(",");
			
			LocalDateTime date = LocalDateTime.parse(columns[0], DATE_PATTERN);
			String item = columns[1];
			String brand = columns[2];
			int quantity = Integer.parseInt(columns[3]);
			int price = Integer.parseInt(columns[4]);

			Product product = new Builder()
					.date(date)
					.item(item)
					.brand(brand)
					.quantity(quantity)
					.price(price)
					.build();
					
			return product;
		}
		
		// 2. 한줄씩 파싱된 데이터를 리스트에 추가하는 기능
		public List<Product> parseLinesFrom(List<String> lines) {
			List<Product> products = new ArrayList<>();
			
			for (String line : lines) {
				Product product = parseFrom(line);
				products.add(product);
			}
			
			return products;
		}
}
