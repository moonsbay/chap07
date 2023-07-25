package com.example;

import util.Alpha;
import util.VT100;

public class AlphaMoveExample2 {
	static class AlphaMove extends Alpha{
		public AlphaMove() {
//			super();
			line = 1;     //패키지가 달라도 프로텍티드 필드라는 것은 상속관계에서는 접속 허용하는 것
			column =1;
		}
		void right() {
			hide();
			column++;
			show();
		}
		void down() {
			hide();
			line++;
			show();
		}
		void left() {
			hide();
			column--;
			show();
		}
		void up() {
			hide();
			line--;
			show();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
		VT100.clearScreen();
		AlphaMove am = new AlphaMove();
		for(int i=0;i<10;i++) {
			am.right();
			Thread.sleep(100);
		}
		for(int i=0;i<10;i++) {
			am.down();
			Thread.sleep(100);
		}
		for(int i=0;i<10;i++) {
			am.left();
			Thread.sleep(100);
		}
		for(int i=0;i<10;i++) {
			am.up();
			Thread.sleep(100);
		}
		VT100.reset();
		
	}

}
