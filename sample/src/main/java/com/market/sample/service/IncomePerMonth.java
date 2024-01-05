package com.market.sample.service;

import java.time.Month;
import java.util.List;

import com.market.sample.model.Product;

public class IncomePerMonth {
	//월을 입력받아서 월별 수익 조회
	
	List<>
	
	public String calculateTotalInMonth(List<Product> products) {
		int total = 0;

		for (Product product : products) {
			if (product.getDate().getMonth() == month)
				total += product.getPrice();
		}
		
		return String.format("월의 입출금액은 %.2f원 입니다.", total);
	}
}
