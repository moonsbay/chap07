package com.example;

public class InherianceExample {
	class Parent{
//		int num;          // static main에서 그냥 num을 사용 못함
//		class Parent{}    // 마찬가지..
		static int num;
	//	static class Parent{
			
	//	}
		
	}
	public static void main(String[] args) {
//		num = 100;						// 그냥 int num은 사용못하고 static int로 해야함
		                  // static main이 만들어질 때 int num은 아직 생성 안됐으므로
//		InherianceExample x = InherianceExample();   이런식으로 먼저 인스턴스를 만들면
//		x.num = 100;                                 num접근이 가능하다.. 그래서 num을 
		                                       // static으로 놓으면 편하다
	   //		Parent p = new Parent();      
		
	}

}
