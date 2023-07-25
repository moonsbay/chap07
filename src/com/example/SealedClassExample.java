package com.example;

public class SealedClassExample {
	static sealed class Person permits Employee, Manager{
		
	}
	
	static non-sealed class Employee extends Person{  //실드퍼밋한 클래스에도 반드시 non-sealed붙여야 한다
		
	}
	static non-sealed class Manager extends Person{  //실드퍼밋한 클래스에도 반드시 non-sealed붙여야 한다
		
	}
/*	static class Student extends Person{       퍼밋한 클래스가 아니므로 에러
		
	}*/
	public static void main(String[] args) {

	}

}
