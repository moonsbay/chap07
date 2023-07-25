package com.example;

public class CastingExample {
	static class A{

		
	}
	static class B extends A{
		
	}
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		A aa = b;   // b를 부모인 A타입에 대입하는 것은 OK : 자동형변환(Up-casting)
//      B bb = a;      안됨
//		B bb = (B)a; // 수동 형변환 (Down-casting) 문법적으로 맞지만 실행시 에러
		if(a instanceof B) {
		B bb = (B)aa; // 이것은 ok
		}
	}

}
