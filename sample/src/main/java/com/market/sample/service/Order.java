package com.market.sample.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.market.sample.model.Product;

public class Order {
	private List<Product> products;
	//private final String[] MONTHS = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
	
	static String month;
	
	public Order(List<Product> products) {
		this.products = products;
	}
	
	// 입력 검증
	public boolean validateInput(String inputMonth) {
		month = inputMonth.toUpperCase();
		for (Months s : Months.values()) {
			if (month.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	// 월을 입력받아서 월별 수익 조회
	public void calculateTotalInMonth() throws IOException {
	    double total = 0d;
	    double per = 0d;
	    double goal = 1000000;
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("수익을 조회할 달을 영어로 입력하세요");
		String inputMonth = br.readLine();
	    
	    if (!validateInput(inputMonth)) {
	    	System.out.println("입력값이 유효하지 않습니다.");
            System.exit(0); 
	    }

	    for (Product product : products) {	    	
	        if (product.getDate().getMonth().toString().equals(month)) {
	            total += product.getPrice() * product.getQuantity();
	        }
	    }
	    
	    System.out.println("월: " + month +", " + "총 수입금: " + (int)total + "원");

	    if (total < goal) {
	        per = ((goal - total) / goal) * 100;
	        System.out.printf("월: " + "%s, 기대수익보다 %.2f퍼센트 모자랍니다.\n", month, per);
	    } else {
	        System.out.println("목표액을 달성하였습니다.");
	    }
	}

	// 브랜드별 수익금 순위
	public void top10Brand() {
		Map<String, Integer> map = new HashMap<>();
		for (Product product : products) {
			map.put(product.getBrand(), map.getOrDefault(product.getBrand(), 0)+product.getPrice()*product.getQuantity());
		}
//		System.out.println(map);
		
		List<String> list = new ArrayList<>(map.keySet());
		list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
		
		System.out.println("2023년 브랜드 총 수익금 TOP10");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i+1 +"등: " + list.get(i) + " " + map.get(list.get(i)) + "원");
		}
	}


}
