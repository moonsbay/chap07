package com.example;

public class PolymorphismExample {
	 static abstract class Shape{
		 
		 abstract void draw(); //추상 메소드, 상속받아 자식이 내용을 채워넣어야한다
		
/*		void draw() {
			System.out.println("뭘 그리냐~~~모르겠다..??");
		}*/
		
	}
	
	static class Rectangle extends Shape{
		
		@Override
		void draw() {
//			super.draw();
			System.out.println("#####");
			System.out.println("#####");
			System.out.println("#####");
			System.out.println("#####");
		}
		
	}
	
	static class Triangle extends Shape{
		@Override
		void draw() {
//			super.draw();
			System.out.println("#");
			System.out.println("##");
			System.out.println("###");
			System.out.println("#####");
		}
	}
	
	public static void main(String[] args) {
//		Shape s = new Shape();      Shape class 추상화로 인하여 에러
		Shape s = new Triangle();
		s.draw();
		
		s = new Rectangle();     // 업캐스팅에 오버라이드.. 다형성
		s.draw();
		
		s = new Triangle();		// 업캐스팅에 오버라이드.. 다형성
		s.draw();
		
	}

}
