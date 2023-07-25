package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class BlinkTimerExample2 {
	static class Blink extends TimerTask{
		Alpha alpha = new Alpha();
		
		boolean isShow = false;
		@Override
		public void run() {
			if(!isShow)
				alpha.show();
			else
				alpha.hide();
			
			isShow = !isShow;
			
		}
	}
	public static void main(String[] args) {
		VT100.clearScreen();
		Timer timer = new Timer();
		for(int i=0; i<10; i++) {
			Blink b = new Blink();
			int speed = (int)(Math.random()*500+20);
			timer.schedule(b, 0, speed);
//			timer.schedule(null, 0, 1000);  상기 두줄 없이 이거 하나로도 된다.. 상기 두줄은 풀어 써본 것
		}
		VT100.reset();
	}

}
