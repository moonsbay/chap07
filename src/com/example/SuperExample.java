package com.example;

public class SuperExample {
	static class A{
		public A() {
			System.out.println("A()....");
		}
	}
	
	static class B extends A{
		public B() {
			System.out.println("B()....");
		}
	}
	static class C{
		public C(int speed) {
	     }
	}
//	static class D extends C{    에러.. 부모 C에서 생성자가 정의되어있으므로 생성자 자동 생성 안되어 에러
		
//	}
	static class D extends C{     // 그러므로 생성자를 다음과 같이 직접 넣어줘야 에러 없음
		public D() {
			super(100);
		}
		public D(int line) {
			super(200);            //부모가 기본 생성자가 아니라면 명시적으로 super로 생성자 호출해야함
		}
	}




	public static void main(String[] args) {
       //super();    부모 생성자를 자동 생성함으로.. this로 생성되는 것이 없으므로... 실행에 보면 안다
		B b = new B();
	}

}
