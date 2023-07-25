package com.example;

public class AbstractClassExample {
    static abstract class Animal{
    abstract void sound();      
    		
    	
    }
    static class Cat extends Animal{

		@Override
		void sound() {            // abstract 매소드는 자식에서 반드시 오버라이드되어야 함
			// TODO Auto-generated method stub
			System.out.println("야옹");
		}
    	
    }
    static class Doc extends Animal{

		@Override
		void sound() {
			// TODO Auto-generated method stub
			System.out.println("멍멍");
		}
    	
    }
    static class People extends Animal{

		@Override
		void sound() {
			// TODO Auto-generated method stub
			System.out.println("야호");
		}
	
    }
	public static void main(String[] args) {
		Animal a1 = new Cat();
		Animal a2 = new Doc();
		Animal a3 = new People();
		
		a1.sound();
		a2.sound();
		a3.sound();
	}

}
