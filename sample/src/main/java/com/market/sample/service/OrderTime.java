package com.market.sample.service;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.market.sample.model.Product;

public class OrderTime {
	private List<Product> products;
	//주문시간 분포도 파악
	static int []time = new int[6];
	
	
	public OrderTime(List<Product> products) {
		super(); // super() 암묵적으로 호출됨		
		this.products = products;
	}
	
	public void per4Hours() {
		//빈도수 입력
		for (Product product : products) {
			int hour = product.getDate().getHour();
			if (hour>=20) {
				time[5]++;
			}
			else if(hour>=16) {
				time[4]++;
			}
			else if(hour>=12) {
				time[3]++;
			}
			else if(hour>=8) {
				time[2]++;
			}
			else if(hour>=4) {
				time[1]++;
			}
			else {
				time[0]++;
			}
		}
		System.out.println("4시간 단위의 주문량 정보입니다: ");
		for (int i = 0; i<6; i++) {
			System.out.println(i*4+"부터 "+(i+1)*4+"시 까지의 주문량은 "+time[i]+"입니다.");
		}
		
		JFrame frame = new JFrame("Program Language School");
        frame.setLocation(500,200);
        frame.setPreferredSize(new Dimension(400,350));
        Container contentPane = frame.getContentPane();

        DrawingPanel drawingPanel = new DrawingPanel();
        contentPane.add(drawingPanel, BorderLayout.CENTER);
        //그래프를 그릴 패널

        JPanel controlPanel = new JPanel();

        contentPane.add(controlPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        
        //drawingPanel.setScores(time[0], time[1], time[2]);
        drawingPanel.setScores(time[0], time[1], time[2], time[3], time[4],time[5]);
        drawingPanel.repaint();
		
	}
	

	//그래프를 그리는 패널 클래스
	class DrawingPanel extends JPanel
	{
	    int time04, time48, time812, time1216, time1620, time2024;
	    
	    public void paint(Graphics g){
	        g.clearRect(0,0,getWidth(),getHeight());
	        g.drawLine(50,250,350,250);
	        for(int cnt = 1 ;cnt<11;cnt++)
	        {
	            g.drawString(cnt +"",25,255-20*cnt);
	            g.drawLine(50, 250-20*cnt, 350,250-20*cnt);
	        }
	        g.drawLine(50,20,50,250);
	        g.drawString("0-4",70,270);
	        g.drawString("4-8",120,270);
	        g.drawString("8-12",170,270);
	        g.drawString("12-16",220,270);
	        g.drawString("16-20",270,270);
	        g.drawString("20-24",320,270);
	        
	        g.setColor(Color.BLUE);
	        
	        if (time04>0)
	            g.fillRect(70,250-time04*20,10,time04*20);
	        if(time48>0)
	            g.fillRect(120,250-time48*20,10,time48*20);
	        if(time812>0)
	            g.fillRect(170,250-time812*20,10,time812*20);
	        if (time1216>0)
	            g.fillRect(220,250-time1216*20,10,time1216*20);
	        if(time1620>0)
	            g.fillRect(270,250-time1620*20,10,time1620*20);
	        if(time2024>0)
	            g.fillRect(320,250-time2024*20,10,time2024*20);
	        
	    }
	    void setScores(int time04, int time48, int time812, int time1216, int time1620, int time2024)
	    {
	        this.time04=time04;
	        this.time48=time48;
	        this.time812=time812;
	        this.time1216 = time1216;
	        this.time1620 = time1620;
	        this.time2024 = time2024;
	    }
	
	}
}

	

