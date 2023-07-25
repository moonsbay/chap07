package com.example;

import java.util.TimerTask;

public class OverridingExample {
	static class A{
		void show() {
			System.out.println("A.show()...");
		}
	}
	static class B extends A{
//		@Override 컴파일할 때 다음 함수를 override로 사용할 수 있는지 확인해달라는 것 
		void show() {
			System.out.println("B.show()...");
		}
	}
	
	static class C extends TimerTask{
		@Override
		public void run() {
		}
		
	}
	public static void main(String[] args) {
		B b = new B();  //new할 때 동일한 시그니쳐 메소드가 있으면 무조건 오버라이드된다
		A a = b;   //이게 된다 부모자식관계(상속관계)라서 큰그릇에 작은 것 담는것...
		b.show();
		a.show();  //부모의 것이 자식의 것으로 정의 된다
	}

}
