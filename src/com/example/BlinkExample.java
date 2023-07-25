package com.example;

import util.VT100;
import util.Alpha;


public class BlinkExample {
	
	static class Blink extends Alpha {   //상속은 생성자를 제외한 인스턴스와 메소드
		                                         // 생성자는 기본생성자로 blink가  new가 될 때 부모 생성자가 호출된다
		int speed;
/*		public Blink() {
			super();                      // 부모 생성자 호출하는 과정이 자동으로 들어가는 것.. 이렇게 표기하는 것과 같다
		}  */
		public Blink() {
			// super();                    이것은 생략되어있는것이 아니라 필요없음, 다음 this로 호출됨으로
			this(100);
		}
		public Blink(int speed) {
		// super();	                         이것이 생략되어있는것..
			this.speed = speed;
		}
		void blink() throws InterruptedException {
			show();
			Thread.sleep(speed);
			hide();
			Thread.sleep(speed);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		Blink b = new Blink();
		for(int i=0; i<=100; i++)
			b.blink();
		b.show();
		VT100.reset();
		System.out.println("Program End...");
		
	}

}
