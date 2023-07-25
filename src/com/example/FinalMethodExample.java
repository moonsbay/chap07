package com.example;

public class FinalMethodExample {
	static class A{
		
	
	void xxx() {
		
	}
	final void yyy() {
		
	}
   }
	static class B extends A {
		
		@Override
		void xxx() {
			
		}
//		@Override
//		void yyy() {      final 이니까 오버라이드 안됨
			
//		}
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
